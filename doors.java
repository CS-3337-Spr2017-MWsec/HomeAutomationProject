package midterm.practice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;


public class doors extends Application {
    private CirclePane circlePane = new CirclePane();

    @Override // Override the start method in the Application class.
    public void start(Stage primaryStage) {     
        Pane pane = new Pane();
     
        
       
     
        

        // Handle mouse click actions.
        circlePane.setOnMousePressed(e -> { 
            circlePane.paintBlack();
            
          
        });

        // Handle mouse release actions.
        circlePane.setOnMouseReleased(e -> {
            circlePane.paintWhite();
            
        });

        // Create a scene & place it on the stage.
        Scene scene = new Scene(circlePane,200,200);
        primaryStage.setTitle("CircleColor"); // Set the stage title.
        primaryStage.setScene(scene); // Place the scene on the stage.
        primaryStage.show(); // Display the stage.

        
        circlePane.requestFocus();


    } // Close the start method.


    // Main method only needed for IDEs with limited JavaFX support
    public static void main(String[] args) {
        launch(args);

    } // Close the main method.

} // Close CircleColor class


class CirclePane extends StackPane {
    private Circle circle = new Circle(50);

    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.GREEN);
        circle.setFill(Color.WHITE);
    } // Close CirclePane constructor.

    public void paintBlack() {
        circle.setFill(Color.GREEN);
    } // Close the paintBlack method.

    public void paintWhite() {
        circle.setFill(Color.WHITE);
    } // Close the paintWhite method.

} // Close the CirclePane class.