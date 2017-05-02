package model;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import tts.TextToSpeech;

public class houseMain {
	
	
	 

	EnglishNumberToString numberToString = new EnglishNumberToString();
	EnglishStringToNumber stringToNumber = new EnglishStringToNumber();
	static TextToSpeech textToSpeech = new TextToSpeech();

	// Logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// Variables
	private String result;

	// Threadsjn
	Thread speechThread;
	Thread resourcesThread;

	// LiveRecognizer
	private LiveSpeechRecognizer recognizer;

	/**
	 * Constructor
	 */
	public houseMain() {

		// Loading Message
		logger.log(Level.INFO, "Loading..\n");

		// Configuration
		Configuration configuration = new Configuration();

		// Load model from the jar
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");

		configuration.setGrammarPath("resource:/grammars");
		configuration.setGrammarName("grammar");
		configuration.setUseGrammar(true);

		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		}

		// Start recognition process pruning previously cached data.
		recognizer.startRecognition(true);

		// Start the Thread
		startSpeechThread();
		startResourcesThread();
	}

	protected void startSpeechThread() {

		// alive?
		if (speechThread != null && speechThread.isAlive())
			return;

		// initialise
		speechThread = new Thread(() -> {
			logger.log(Level.INFO, "You can start to speak...\n");
			try {
				while (true) {
					/*
					 * This method will return when the end of speech is
					 * reached. Note that the end pointer will determine the end
					 * of speech.
					 */
					SpeechResult speechResult = recognizer.getResult();
					if (speechResult != null) {

						result = speechResult.getHypothesis();
						System.out.println("You said: [" + result + "]\n");
						makeDecision(result);
						// logger.log(Level.INFO, "You said: " + result + "\n")

					} else
						logger.log(Level.INFO, "I can't understand what you said.\n");

				}
			} catch (Exception ex) {
				logger.log(Level.WARNING, null, ex);
			}

			logger.log(Level.INFO, "SpeechThread has exited...");

		});

		// Start
		speechThread.start();

	}

	/**
	 * Starting a Thread that checks if the resources needed to the
	 * SpeechRecognition library are available
	 */
	protected void startResourcesThread() {

		// alive?
		if (resourcesThread != null && resourcesThread.isAlive())
			return;

		resourcesThread = new Thread(() -> {
			try {

				while (true) {
					if (AudioSystem.isLineSupported(Port.Info.MICROPHONE)) {

					} else {

					}

					// Sleep some period
					Thread.sleep(350);
				}

			} catch (InterruptedException ex) {
				logger.log(Level.WARNING, null, ex);
				resourcesThread.interrupt();
			}
		});

		// Start
		resourcesThread.start();
	}

	
		/// voice activation
	public void makeDecision(String speech) {

		if ("fuck you gabriel".equalsIgnoreCase(speech)) {
			textToSpeech.speak("You too motherfucker", 1.5f, false, true);
			return;

		} else if ("password".equalsIgnoreCase(speech)) {
			textToSpeech.speak("opening front door", 1.5f, false, true);
			return;
		}
	}

	/**
	 * Java Main Application Method
	 * 
	 * @param args
	 */
	
	
	

	public static void main(String[] args) {

		String cardOne = "0008008784122,13392";
		String cardTwo = "000765967211657496";

		Scanner scanner = new Scanner(System.in);

		String cardInput = scanner.nextLine();
		
		while (cardInput != cardOne) {
			
			cardInput = scanner.nextLine();
			

			if (cardInput.equals("0008008784122,13392")) {

				textToSpeech.speak("enter password", 1.5f, false, true);

				new houseMain();
				
				

			}

			else {
				textToSpeech.speak("wrong card", 1.5f, false, true);
				//System.exit(0);
			
			}

			

		}
	}

}