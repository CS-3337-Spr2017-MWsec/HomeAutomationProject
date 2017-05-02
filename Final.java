package model;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import tts.TextToSpeech;

public class Final extends Application {
	
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
	public Final() {

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
	

	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	final Label response = new Label("");

	@Override
	public void start(Stage stage) {
		Group root = new Group();
		Scene scene = new Scene(root, 250, 100);
		stage.setScene(scene);
		stage.setTitle("Login");

		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 0, 0, 10));
		vb.setSpacing(10);
		HBox hb = new HBox();
		hb.setSpacing(10);
		hb.setAlignment(Pos.CENTER_LEFT);

		Label label = new Label("Password: ");
		final PasswordField password = new PasswordField();

		password.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (password.getText().equals("Password123!")) {
					stage.setTitle("H.A.S.");
					
					 Image home = new Image("http://content.abt.com/media/about/buying_guide_images/home-automation-mobile.jpg");
				      ImageView home1 = new ImageView();
				      home1.setImage(home);
				      home1.setFitHeight(820);
				      home1.setFitWidth(1000);
				      home1.relocate(220, 0);
					
					
					
			        

			        Image image = new Image("http://www.iconsdb.com/icons/preview/black/security-camera-xxl.png");
			        ImageView imageView = new ImageView(image);
			        
			        Image image1 = new Image("http://www.freeiconspng.com/uploads/lightbulb-icon-png-effects-17.png");
			        ImageView imageView1 = new ImageView(image1);
			        
			        Image image2 = new Image("https://image.flaticon.com/icons/png/512/59/59801.png");
			        ImageView imageView2= new ImageView(image2);
			        
			        Image image3 = new Image("http://www.freeiconspng.com/uploads/alarm-bell-icon-4.png");
			        ImageView imageView3= new ImageView(image3);
			        
			        
			        imageView.setFitWidth(200);

			    	imageView.setFitHeight(200);
			        
			    	imageView1.setFitWidth(200);

			    	imageView1.setFitHeight(200);
			    	
			    	imageView2.setFitWidth(200);

			    	imageView2.setFitHeight(200);
			    	
			    	imageView3.setFitWidth(200);

			    	imageView3.setFitHeight(200);
			        
			    		Image image4 = new Image("https://sundaynightsingles.files.wordpress.com/2015/02/kettleman-3.png");
			    		ImageView cam1 = new ImageView();
			        cam1.setImage(image4);
			        
			        cam1.setFitHeight(300);
			        cam1.setFitWidth(400);
			        cam1.relocate(-25000, -2000);
			        
			        
			      
			     
			        Image image5 = new Image("https://www.3dartistonline.com/users/1313/thm1024/garage_stret.jpg");
					ImageView cam2 = new ImageView();
			    cam2.setImage(image5);
			    
			    cam2.setFitHeight(300);
			    cam2.setFitWidth(400);
			    cam2.relocate(-25000, -2000);
			    
			    
			   
			    
			    
			    Image image6 = new Image("http://cdn.home-designing.com/wp-content/uploads/2014/07/house-layout-ideas.1.jpeg");
				ImageView light = new ImageView();
				light .setImage(image6);

				light .setFitHeight(600);
				light .setFitWidth(800);
				light .relocate(-25000, -2000);
			    
				
				Circle light1 = new Circle(45);
				light1.setStroke(Color.GREEN);
			    light1.setFill(Color.BLACK);
			    light1.relocate(-111, -111);
			    
			    Circle light2 = new Circle(45);
				light2.setStroke(Color.GREEN);
			    light2.setFill(Color.BLACK);
			    light2.relocate(-111, -111);
			    
			    Circle light3 = new Circle(45);
				light3.setStroke(Color.GREEN);
			    light3.setFill(Color.BLACK);
			    light3.relocate(-111, -111);
			    
			    
			    Image locki1 = new Image("https://cdn3.iconfinder.com/data/icons/dev-toolpack/512/lock-512.png");
			    Image locki2 = new Image("https://cdn3.iconfinder.com/data/icons/dev-toolpack/512/unlock-512.png");
			    
				ImageView lock1 = new ImageView();
				lock1.setImage(locki1);
				lock1.setFitHeight(100);
				lock1.setFitWidth(100);
				lock1.relocate(-25000, -2000);
			    
				
				ImageView lock2 = new ImageView();
				lock2.setImage(locki1);
				lock2.setFitHeight(100);
				lock2.setFitWidth(100);
				lock2.relocate(-25000, -2000);
				
				Button allLock = new Button("Lock ALL");
				
				Button allUnLock = new Button("unLock ALL");
				
				
				GridPane root = new GridPane();

				// Light.Distant: Represents a distant light source.
				Light.Distant lights = new Light.Distant();
				lights.setAzimuth(45);
				lights.setElevation(45);
				lights.setColor(Color.WHITE);
				Lighting lighting = new Lighting();
				lighting.setLight(lights);

				ColorPicker colorPicker = new ColorPicker(Color.WHITE);
				colorPicker.setOnAction(new EventHandler() {
					@Override
					public void handle(Event t) {
						lights.setColor(colorPicker.getValue());
						light1.setFill(colorPicker.getValue());
					}
				});

				Button btn = new Button("Bedroom");
				btn.setEffect(lighting);

				Circle circle = new Circle(30, Color.rgb(255, 255, 255));
				circle.setEffect(lighting);
				light1.setEffect(lighting);

				HBox hBoxShape = new HBox();
				hBoxShape.getChildren().addAll(circle);

				Label labelElevation = new Label("Light: Darker to Brighter");
				Slider sliderElevation = new Slider();
				sliderElevation.setMin(0);
				sliderElevation.setMax(90);
				sliderElevation.setValue(45);
				sliderElevation.setMajorTickUnit(30);
				sliderElevation.setMinorTickCount(3);
				sliderElevation.setShowTickLabels(true);
				sliderElevation.setShowTickMarks(true);
				sliderElevation.valueProperty()
						.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
							lights.setElevation((Double) new_val);
						});

				VBox vBox = new VBox();
				vBox.setPadding(new Insets(10, 10, 10, 10));
				vBox.getChildren().addAll(colorPicker, btn, hBoxShape, labelElevation, sliderElevation);
				// 2
				GridPane root2 = new GridPane();

				// Light.Distant: Represents a distant light source.
				Light.Distant lights2 = new Light.Distant();
				lights2.setAzimuth(45);
				lights2.setElevation(45);
				lights2.setColor(Color.WHITE);
				Lighting lighting2 = new Lighting();
				lighting2.setLight(lights2);

				ColorPicker colorPicker2 = new ColorPicker(Color.WHITE);
				colorPicker2.setOnAction(new EventHandler() {
					@Override
					public void handle(Event t) {
						lights2.setColor(colorPicker2.getValue());
						light2.setFill(colorPicker.getValue());
					}
				});

				Button btn2 = new Button("Hallway");
				btn2.setEffect(lighting2);

				Circle circle2 = new Circle(30, Color.rgb(255, 255, 255));
				circle2.setEffect(lighting2);
				light2.setEffect(lighting2);

				HBox hBoxShape2 = new HBox();
				hBoxShape2.getChildren().addAll(circle2);

				Label labelElevation2 = new Label("Light: Darker to Brighter");
				Slider sliderElevation2 = new Slider();
				sliderElevation2.setMin(0);
				sliderElevation2.setMax(90);
				sliderElevation2.setValue(45);
				sliderElevation2.setMajorTickUnit(30);
				sliderElevation2.setMinorTickCount(3);
				sliderElevation2.setShowTickLabels(true);
				sliderElevation2.setShowTickMarks(true);
				sliderElevation2.valueProperty()
						.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
							lights2.setElevation((Double) new_val);
						});

				VBox vBox2 = new VBox();
				vBox2.setPadding(new Insets(10, 10, 10, 10));
				vBox2.getChildren().addAll(colorPicker2, btn2, hBoxShape2, labelElevation2, sliderElevation2);
				// 2 ends
				GridPane root3 = new GridPane();

				// 3
				// Light.Distant: Represents a distant light source.
				Light.Distant lights3 = new Light.Distant();
				lights3.setAzimuth(45);
				lights3.setElevation(45);
				lights3.setColor(Color.WHITE);
				Lighting lighting3 = new Lighting();
				lighting3.setLight(lights3);

				ColorPicker colorPicker3 = new ColorPicker(Color.WHITE);
				colorPicker3.setOnAction(new EventHandler() {
					@Override
					public void handle(Event t) {
						lights3.setColor(colorPicker3.getValue());
						light3.setFill(colorPicker.getValue());
					}
				});

				Button btn3 = new Button("Livingroom");

				btn3.setEffect(lighting3);

				Circle circle3 = new Circle(30, Color.rgb(255, 255, 255));
				circle3.setEffect(lighting3);
				light3.setEffect(lighting3);

				HBox hBoxShape3 = new HBox();
				hBoxShape3.getChildren().addAll(circle3);

				Label labelElevation3 = new Label("Light: Darker to Brighter");
				Slider sliderElevation3 = new Slider();
				sliderElevation3.setMin(0);
				sliderElevation3.setMax(90);
				sliderElevation3.setValue(45);
				sliderElevation3.setMajorTickUnit(30);
				sliderElevation3.setMinorTickCount(3);
				sliderElevation3.setShowTickLabels(true);
				sliderElevation3.setShowTickMarks(true);
				sliderElevation3.valueProperty()
						.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
							lights3.setElevation((Double) new_val);
						});

				VBox vBox3 = new VBox();
				vBox3.setPadding(new Insets(10, 10, 10, 10));
				vBox3.getChildren().addAll(colorPicker3, btn3, hBoxShape3, labelElevation3, sliderElevation3);
				// 3 ends
				root.getChildren().add(vBox); // yellow bottom center
				//root.setAlignment(Pos.BOTTOM_CENTER);
				root2.getChildren().add(vBox2);// red bottom right
				//root2.setAlignment(Pos.BOTTOM_LEFT);
				root3.getChildren().add(vBox3); // green bottom left
				//root3.setAlignment(Pos.BOTTOM_LEFT);
				root.setLayoutX(-300);
				root.setLayoutY(-620);
				
				root2.setLayoutX(-500);
				root2.setLayoutY(-620);
				
				root3.setLayoutX(-700);
				root3.setLayoutY(-620);
				
				
			    	
				
			        
			        Button button1 = new Button("",imageView);
			        button1.setOnAction(f -> {
			        	textToSpeech.speak("Camera", 1.5f, false, true);
			        	
			        	cam1.relocate(250, 20);
			        	
			        	cam2.relocate(720, 20);
			        	
			        	light.relocate(-25000, -2000);
			        	
			        	light1.relocate(-111, -111);
			        	
			        	light2.relocate(-111, -111);
			        	
			        	light3.relocate(-111, -111);
			        	
			        	
			        	lock1.relocate(-25000, -2000);
			        	
			        	lock2.relocate(-25000, -2000);
			        	
			        	allLock.setLayoutX(-1000);
			        	allLock.setLayoutY(-1000);
			        	
			        	allUnLock.setLayoutX(-1000);
			        	allUnLock.setLayoutY(-1000);
			        	
			        	root.setLayoutX(-300);
			        	root.setLayoutY(-620);
			        	
			        	root2.setLayoutX(-500);
			        	root2.setLayoutY(-620);
			        	
			        	root3.setLayoutX(-700);
			        	root3.setLayoutY(-620);
			        	
			        	
			        	cam1.addEventHandler(MouseEvent.MOUSE_CLICKED, g -> {
			        		
			        	
			        		
			        		if(cam1.getFitHeight() == 300){
			        			
			        			textToSpeech.speak("Camera One", 1.5f, false, true);
			        			
			        		cam1.setFitHeight(600);
			                cam1.setFitWidth(800);
			                
			                cam2.relocate(-25000, -2000);
			        		}
			        		else {
			        			cam1.setFitHeight(300);
			                    cam1.setFitWidth(400);
			                    
			                    cam2.relocate(720, 20);
			        		}
			        		
			            });
			        	
			        	
			        	cam2.addEventHandler(MouseEvent.MOUSE_CLICKED, g -> {
			        		
			        		if(cam2.getFitHeight() == 300){
			        			textToSpeech.speak("Camera Two", 1.5f, false, true);
			        			
			        		cam2.setFitHeight(600);
			                cam2.setFitWidth(800);
			                
			                cam2.relocate(250, 20);
			        		}
			        		else {
			        			cam2.setFitHeight(300);
			                    cam2.setFitWidth(400);
			                    
			                    cam2.relocate(720, 20);
			        		}
			        		
			            });
			        	
			        	
			        });

			        
			        Button button2 = new Button("",imageView1);
			        
			        button2.setOnAction(f -> {
			        	
			        	textToSpeech.speak("Lights", 1.5f, false, true);
			        	
			        	cam1.relocate(-25000, -2000);
			        	
			        	cam2.relocate(-25000, -2000);
			        	
			        	
			        	light.relocate(250, 20);
			        	
			        	light1.relocate(380, 250);
			        	
			        	light2.relocate(600, 170);
			        	
			        	light3.relocate(650, 400);
			        	
			        	lock1.relocate(-25000, -2000);
			        	
			        	lock2.relocate(-25000, -2000);
			        	
			        	allLock.setLayoutX(-1000);
			        	allLock.setLayoutY(-1000);
			        	
			        	
			        	allUnLock.setLayoutX(-1000);
			        	allUnLock.setLayoutY(-1000);
			        	
			        	root.setLayoutX(300);
			        	root.setLayoutY(620);
			        	
			        	root2.setLayoutX(500);
			        	root2.setLayoutY(620);
			        	
			        	root3.setLayoutX(700);
			        	root3.setLayoutY(620);
			        	
			        	
			        	light1.addEventHandler(MouseEvent.MOUSE_CLICKED, me -> {
			        		if(light1.getFill() == Color.WHITE){
			        			textToSpeech.speak("Lights Off", 1.5f, false, true);
			                light1.setFill(Color.BLACK);
			              
			        		}
			        		else{
			        			light1.setFill(Color.WHITE);
			        			
			        			textToSpeech.speak("Lights On", 1.5f, false, true);
			        			
			        		}
			        	
			        		
			            });
			        	
			        	

			        	light2.addEventHandler(MouseEvent.MOUSE_CLICKED, me -> {
			        		if(light2.getFill() == Color.WHITE){
			        			textToSpeech.speak("Lights Off", 1.5f, false, true);
			                light2.setFill(Color.BLACK);
			              
			        		}
			        		else{
			        			light2.setFill(Color.WHITE);
			        			textToSpeech.speak("Lights On", 1.5f, false, true);
			        			
			        		}
			        	
			        		
			            });
			        	
			        	

			        	light3.addEventHandler(MouseEvent.MOUSE_CLICKED, me -> {
			        		if(light3.getFill() == Color.WHITE){
			        			textToSpeech.speak("Lights Off", 1.5f, false, true);
			                light3.setFill(Color.BLACK);
			              
			        		}
			        		else{
			        			light3.setFill(Color.WHITE);
			        			textToSpeech.speak("Lights On", 1.5f, false, true);
			        			
			        		}
			        	
			        		
			            });
			        	
			        	
			            
			        });
			        	
			        Button button3 = new Button("",imageView2);
			        
			        button3.setOnAction(f -> {
			        	textToSpeech.speak("Doors", 1.5f, false, true);
			        	cam1.relocate(-25000, -2000);
			        	
			        	cam2.relocate(-25000, -2000);
			        	
			        	light.relocate(250, 20);
			        	
			        	light1.relocate(-111, -111);
			        	
			        	
			        	
			light2.relocate(-111, -111);
			        	
			        	light3.relocate(-111, -111);
			        	
			        	
			        	lock1.relocate(750, 350);
			        	
			        	lock2.relocate(350, 270);
			        	
			        	
			        	
			        	root.setLayoutX(-300);
			        	root.setLayoutY(-620);
			        	
			        	root2.setLayoutX(-500);
			        	root2.setLayoutY(-620);
			        	
			        	root3.setLayoutX(-700);
			        	root3.setLayoutY(-620);
			        	
			        	
			        	lock1.addEventHandler(MouseEvent.MOUSE_CLICKED, d -> {
			        		if(lock1.getImage() == locki1){
			        			lock1.setImage(locki2);
			        			
			        		}
			        		else{
			        			
			        			lock1.setImage(locki1);
			        			
			        		}
			        	
			        		
			            });
			            
			        	lock2.addEventHandler(MouseEvent.MOUSE_CLICKED, d -> {
			        		if(lock2.getImage() == locki1){
			        			lock2.setImage(locki2);
			        			
			        		}
			        		else{
			        			
			        			lock2.setImage(locki1);
			        			
			        		}
			        	
			        		
			            });
			        
			        	
			        	
			        	
			        	allLock.setLayoutX(500);
			        	allLock.setLayoutY(630);
			        	
			        	allUnLock.setLayoutX(600);
			        	allUnLock.setLayoutY(630);
			             
			             allLock.setOnAction(d -> {
			            	 lock2.setImage(locki1);
			            	 lock1.setImage(locki1);
			            	 
			            	 
			            	 
			             
			             });
			        	
			             allUnLock.setOnAction(d -> {
			            	 lock2.setImage(locki2);
			            	 lock1.setImage(locki2);
			            	 
			            	 
			            	 
			             
			             });  
			        
			        
			        
			        });
			        
			        
			        
			        
			        
			        
			        
			        
			        Button button4 = new Button("",imageView3);
			        
			        button4.setOnAction(f -> {
			        	cam1.relocate(-25000, -2000);
			        	
			        	cam2.relocate(-25000, -2000);
			        	
			        	light.relocate(-25000, -2000);
			        	
			        	light1.relocate(-111, -111);
			        	
			light2.relocate(-111, -111);
			        	
			        	light3.relocate(-111, -111);
			        	
			        	lock1.relocate(-25000, -2000);
			        	
			        	
			        	lock2.relocate(-25000, -2000);
			        	
			        	allLock.setLayoutX(-1000);
			        	allLock.setLayoutY(-1000);
			        	
			        	allUnLock.setLayoutX(-1000);
			        	allUnLock.setLayoutY(-1000);
			        	
			        	root.setLayoutX(-300);
			        	root.setLayoutY(-620);
			        	
			        	root2.setLayoutX(-500);
			        	root2.setLayoutY(-620);
			        	
			        	root3.setLayoutX(-700);
			        	root3.setLayoutY(-620);
			        	
			        	
			        });

			        

			        button1.setLayoutX(0);
			        button1.setLayoutY(0);
			        button2.setLayoutX(0);
			        button2.setLayoutY(210);
			        button3.setLayoutX(0);
			        button3.setLayoutY(420);
			        button4.setLayoutX(0);
			        button4.setLayoutY(630);
			        
			        allLock.setLayoutX(-1000);
			    	allLock.setLayoutY(-1000);
			    	
			    	 allUnLock.setLayoutX(-1000);
			     	allUnLock.setLayoutY(-1000);
			         
			        
			        
			        
			        Pane pane = new Pane(button1,button2, button3, button4,home1 ,cam1, cam2,light,light1,light2,light3,lock1,lock2,allLock,allUnLock,root, root2, root3);


			        Scene scene = new Scene(pane, 1200, 840);
			        stage.setScene(scene);
			        stage.show();
			    }
				 else {
					response.setText("Access Denied!");
					response.setTextFill(Color.web("red"));
				}
				password.setText("");
			}
		});

		hb.getChildren().addAll(label, password);
		vb.getChildren().addAll(hb, response);
		scene.setRoot(vb);
		stage.show();
		
		
	}
	
	
	
	public void makeDecision(String speech) {

		if ("fuck you gabriel".equalsIgnoreCase(speech)) {
			textToSpeech.speak("You too motherfucker", 1.5f, false, true);
			return;

		} else if ("password".equalsIgnoreCase(speech)) {
			textToSpeech.speak("opening front door", 1.5f, false, true);
			return;
		}
		
		if("lights on".equalsIgnoreCase(speech)){
			
			textToSpeech.speak("All lights on", 1.5f, false, true);
			return;
		}
		
		if("lights off".equalsIgnoreCase(speech)){
			
			
			textToSpeech.speak("All lights off", 1.5f, false, true);
			return;
		}
		
if("lock doors".equalsIgnoreCase(speech)){
			
			
			textToSpeech.speak("Doors Locked", 1.5f, false, true);
			return;
		}
		

if("open doors".equalsIgnoreCase(speech)){
	
	
	textToSpeech.speak("Doors open", 1.5f, false, true);
	return;
}
		
	}
	
}





	

