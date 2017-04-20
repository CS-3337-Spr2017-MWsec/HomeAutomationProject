package midterm.practice;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ButtonExperiments extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Button Experiment 1");
        
        
        
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
    
        
    	
        
        Button button1 = new Button("",imageView);
        button1.setOnAction(e -> {
        	cam1.relocate(250, 20);
        	
        	cam2.relocate(720, 20);
        	
        	light.relocate(-25000, -2000);
        	
            
        });

        
        Button button2 = new Button("",imageView1);
        
        button2.setOnAction(e -> {
        	cam1.relocate(-25000, -2000);
        	
        	cam2.relocate(-25000, -2000);
        	
        	
        	light.relocate(250, 20);
        	
            
        });
        	
        Button button3 = new Button("",imageView2);
        
        button3.setOnAction(e -> {
        	cam1.relocate(-25000, -2000);
        	
        	cam2.relocate(-25000, -2000);
        	
        	light.relocate(250, 20);
            
        });
        Button button4 = new Button("",imageView3);
        
        button4.setOnAction(e -> {
        	cam1.relocate(-25000, -2000);
        	
        	cam2.relocate(-25000, -2000);
        	
        	light.relocate(-25000, -2000);
        });

        

        button1.setLayoutX(0);
        button1.setLayoutY(0);
        button2.setLayoutX(0);
        button2.setLayoutY(210);
        button3.setLayoutX(0);
        button3.setLayoutY(420);
        button4.setLayoutX(0);
        button4.setLayoutY(630);
        
        
        
        
        Pane pane = new Pane(button1, button2, button3, button4, cam1, cam2,light);


        Scene scene = new Scene(pane, 1200, 840);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}