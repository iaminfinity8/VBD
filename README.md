# VBD

Dictionary Application with Speech Recognition and Speech Synthesis

## Getting Started

You do not need to install it seperately, it is provided in zip format so it is directly started by launching the JAR (EXE if Any). 

### Prerequisites

JDK Minimum ver. 1.7

System Tray Support in OS

1 GB RAM

Good, Well Functioning Microphone & Speakers

### Installing

1. Extract the given .zip file

2. Start Application by Double Clicking on VBD.jar

## Running the tests

Instead of automated tests manual tests are carried out for testing various test cases on application, as folows : 

1. Verify whether System Tray Icon is supported and visible in Taskbar.

2. Verify Pop-up menu is visible and functioning(handling all events).

3. Verify the Notification is getting displayed in time.

4. Verify Time Required for Speech Recognition.

5. Verify proper meaning of word is getting synthesized.

### Break down into end to end tests

Above tests needs to be performed for checking whether system/application is working properly.

1. Some OS does not support System Tray Icon feature like , ubuntu. in such case application will not work properly.OS like windows have support for System Tray feature for showing application icon in taskbar.

2. System Tray icon Should show the pop-up menu otherwise it will be of no use.

3. Notification indicating the initiation of Speech Recognition needs to be displayed within a time limit otherwise user will not get when the system is listening.

4. Time required for for recognizing the word and finding meaning of it needs to be fast in order to achieve max performance.

5. Searched meaning has to be accurate otherwise application is of no use. 

## Deployment

For deployment no additional features/steps required other than mentioned above.

## Built With

* [JAVAFX] - JAVA library used for rich user interface desktop application.
* [Sphinx4] - Open source speech recognition API.
* [MARYTTS] - Open source speech synthesis API.
* [Netbeans] - IDE used for development.
* [Gluon SceneBuilder] - used for designing the rich GUI with JAVAFX.

##Contibuting

## Versioning

Versions Available of Dictionary Application are : 1.0(March 2018),2.0(beta). 

## Authors

* **Sanket Kamble** - GUI Designing and Documentation

* **Ajinkya Kundur** -  GUI Designing and Documentation

* **Akash Hulbutti** - Programming and Testing of Application

* **Shubham Thorve** - Programming and Testing of Application

* **Vijayendra Gaikwad** - Project Guide


## License



## Acknowledgments

* We would also like to thank and acknowledge P. Lamere, P.Kwok, W. Walker, E. Gouva, R. Singh, B. Raj, P. Wolf for their useful resources and information
* We would also like to thank *jewelsea* on GitHub for their information and implementation of JAVAFX Event handling from System Tray Icon.Link mentioned here : https://gist.github.com/jewelsea/e231e89e8d36ef4e5d8a
* We would like to thank Prof. Manoj Mulik, Head of Computer Department at ABMSP's A.P.C.O.E.R, Prof. Rama Gaikwad, Project Co-ordinator at ABMSP's A.P.C.O.E.R, Prof. Vijayendra Gaikwad, Project Guide at ABMSP's A.P.C.O.E.R, for making this team possible.
