/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infinity.vbd.Beans;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Akash
 */
public class AudioPlayerBean {
	public static final int		MONO		= 0;
	public static final int		STEREO		= 3;
	public static final int		LEFT_ONLY	= 1;
	public static final int		RIGHT_ONLY	= 2;
	private AudioInputStream	ais;
	private LineListener		lineListener;
	private SourceDataLine		line;
	private int			outputMode;
	private Status	status		= Status.WAITING;
	private boolean	exitRequested	= false;
	private float	gain		= 1.0f;

	
	public enum Status {WAITING,PLAYING;}


    public void setStatus(Status status) {
        this.status = status;
    }

    public void setGain(float gain) {
        this.gain = gain;
    }
    public void setAis(AudioInputStream ais) {
        this.ais = ais;
    }

    public void setLineListener(LineListener lineListener) {
        this.lineListener = lineListener;
    }

    public void setLine(SourceDataLine line) {
        this.line = line;
    }

    public void setOutputMode(int outputMode) {
        this.outputMode = outputMode;
    }

    public void setExitRequested(boolean exitRequested) {
        this.exitRequested = exitRequested;
    }

    public static int getMONO() {
        return MONO;
    }

    public static int getSTEREO() {
        return STEREO;
    }

    public static int getLEFT_ONLY() {
        return LEFT_ONLY;
    }

    public static int getRIGHT_ONLY() {
        return RIGHT_ONLY;
    }

    public AudioInputStream getAis() {
        return ais;
    }

    public LineListener getLineListener() {
        return lineListener;
    }

    public SourceDataLine getLine() {
        return line;
    }

    public int getOutputMode() {
        return outputMode;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isExitRequested() {
        return exitRequested;
    }

    public float getGain() {
        return gain;
    }  
}
