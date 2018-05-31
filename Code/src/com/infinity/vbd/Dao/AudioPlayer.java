/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Dao;

/**
 *
 * @author Akash
 */
import com.infinity.vbd.Beans.AudioPlayerBean;
import com.infinity.vbd.Beans.AudioPlayerBean.Status;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import marytts.util.data.audio.MonoAudioInputStream;
import marytts.util.data.audio.StereoAudioInputStream;
//import speechtotext.AudioPlayerBean.Status;


public class AudioPlayer extends Thread {
    AudioPlayerBean APB=new AudioPlayerBean();
    

	public AudioPlayer() {
	}

	public AudioPlayer(File audioFile) throws IOException, UnsupportedAudioFileException {
		this.APB.setAis(AudioSystem.getAudioInputStream(audioFile));
	}


	public AudioPlayer(AudioInputStream ais) {
		this.APB.setAis(ais);
	}

	
	public AudioPlayer(File audioFile, LineListener lineListener) throws IOException, UnsupportedAudioFileException {
		this.APB.setAis(AudioSystem.getAudioInputStream(audioFile));  
		this.APB.setLineListener(lineListener);
	}
	

	public AudioPlayer(AudioInputStream ais, LineListener lineListener) {
		this.APB.setAis(ais);
		this.APB.setLineListener(lineListener);
	}


	public AudioPlayer(File audioFile, SourceDataLine line, LineListener lineListener)
			throws IOException, UnsupportedAudioFileException {
		this.APB.setAis(AudioSystem.getAudioInputStream(audioFile)); 
		this.APB.setLine(line);
		this.APB.setLineListener(lineListener);
	}


	public AudioPlayer(AudioInputStream ais, SourceDataLine line, LineListener lineListener) {
		this.APB.setAis(ais);
		this.APB.setLine(line);
		this.APB.setLineListener(lineListener);
	}

	
	public AudioPlayer(File audioFile, SourceDataLine line, LineListener lineListener, int outputMode)
			throws IOException, UnsupportedAudioFileException {
		this.APB.setAis(AudioSystem.getAudioInputStream(audioFile)); 
		this.APB.setLine(line);
		this.APB.setLineListener(lineListener);
		this.APB.setOutputMode(outputMode);
	}

	
	public AudioPlayer(AudioInputStream ais, SourceDataLine line, LineListener lineListener, int outputMode) {
		this.APB.setAis(ais);
		this.APB.setLine(line);
		this.APB.setLineListener(lineListener);
		this.APB.setOutputMode(outputMode);
	}

	public void setAudio(AudioInputStream audio) {
		if (APB.getStatus().equals(Status.PLAYING)) {
			throw new IllegalStateException("Cannot set audio while playing");
		}
		this.APB.setAis(audio);
	}

	public void cancel() {
		if (APB.getLine() != null) {
			(APB.getLine()).stop(); // Confirmation
		}
		APB.setExitRequested(true);
	}


	public SourceDataLine getLine() {
		return this.APB.getLine();
	}

	public float getGainValue() {
		return this.APB.getGain();
	}


	public void setGain(float fGain) {
                APB.setGain(fGain);
		// Better type
		if ((APB.getLine()) != null && (APB.getLine()).isControlSupported(FloatControl.Type.MASTER_GAIN))
			((FloatControl) (APB.getLine()).getControl(FloatControl.Type.MASTER_GAIN))
					.setValue((float) (20 * Math.log10(fGain <= 0.0 ? 0.0000 : fGain)));
        }

	@Override
	public void run() {

		APB.setStatus(Status.PLAYING);
		AudioFormat audioFormat = (APB.getAis()).getFormat();
		if (audioFormat.getChannels() == 1) {
			if ((APB.getOutputMode()) != 0) {
				APB.setAis(new StereoAudioInputStream((APB.getAis()),(APB.getOutputMode())));
				audioFormat = (APB.getAis()).getFormat();
			}
		} else {
			assert audioFormat.getChannels() == 2 : "Unexpected number of channels: " + audioFormat.getChannels();
			if ((APB.getOutputMode())== 0) {
				APB.setAis( new MonoAudioInputStream((APB.getAis())));
			} else if ((APB.getOutputMode()) == 1 ||(APB.getOutputMode()) == 2) {
				APB.setAis( new StereoAudioInputStream((APB.getAis()), (APB.getOutputMode())));
			} else {
				assert APB.getOutputMode() == 3 : "Unexpected output mode: " + APB.getOutputMode();
			}
		}

		DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

		try {
			if ((APB.getLine()) == null) {
				boolean bIsSupportedDirectly = AudioSystem.isLineSupported(info);
				if (!bIsSupportedDirectly) {
					AudioFormat sourceFormat = audioFormat;
					AudioFormat targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
							sourceFormat.getSampleRate(), sourceFormat.getSampleSizeInBits(),
							sourceFormat.getChannels(),
							sourceFormat.getChannels() * (sourceFormat.getSampleSizeInBits() / 8),
							sourceFormat.getSampleRate(), sourceFormat.isBigEndian());

					APB.setAis(AudioSystem.getAudioInputStream(targetFormat, (APB.getAis())));
					audioFormat = (APB.getAis()).getFormat();
				}
				info = new DataLine.Info(SourceDataLine.class, audioFormat);
				APB.setLine((SourceDataLine) AudioSystem.getLine(info)) ;
			}
			if ((APB.getLineListener())!= null) {
				(APB.getLine()).addLineListener(APB.getLineListener());
			}
			(APB.getLine()).open(audioFormat);
		} catch (LineUnavailableException ex) {
			Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
			return;
		}

		(APB.getLine()).start();
		setGain(getGainValue());

		int nRead = 0;
		byte[] abData = new byte[65532];
		while ((nRead != -1) && (!(APB.isExitRequested()))) {
			try {
				nRead = (APB.getAis()).read(abData, 0, abData.length);
			} catch (IOException ex) {
				Logger.getLogger(getClass().getName()).log(Level.WARNING, null, ex);
			}
			if (nRead >= 0) {
				(APB.getLine()).write(abData, 0, nRead);
			}
		}
		if (!(APB.isExitRequested())) {
			(APB.getLine()).drain();
		}
		(APB.getLine()).close();
	}

}
