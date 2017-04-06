package midterm.practice;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
 
public class ColorPickerSample extends Application {
      
   
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("ColorPicker");
 
        Scene scene = new Scene(new VBox(20), 300, 300);
        scene.setFill(Color.web("#ccffcc"));
        VBox box = (VBox) scene.getRoot();
 
        ToolBar tb = new ToolBar();
        box.getChildren().add(tb);
 
        final ComboBox logoSamples = new ComboBox();
        logoSamples.getItems().addAll(
                "Normal",
                "Party",
                "Hello",
                "Cup");
        logoSamples.setValue("Normal");

        logoSamples.valueProperty().addListener(new ChangeListener<String>() {
            @Override 
            public void changed(ObservableValue ov, String t, String t1) {                
                  
            }    
        });
        
 
        final ColorPicker colorPicker = new ColorPicker();
        tb.getItems().addAll(logoSamples, colorPicker);
 
        StackPane stack = new StackPane();
        box.getChildren().add(stack);
 
        final SVGPath svg = new SVGPath();
        svg.setContent("M-100,0a100,100 0 1,0 200,0a100,100 0 1,0 -200,0");
        svg.setStroke(Color.DARKGREY);
        svg.setStrokeWidth(2);
        svg.setEffect(new DropShadow());
        svg.setFill(colorPicker.getValue());
        stack.getChildren().addAll(svg);
 
        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                svg.setFill(colorPicker.getValue());                    
            }
        });
 
        stage.setScene(scene);
        stage.show();
    }
}