
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFX_Lighting extends Application {
<<<<<<< HEAD
    @Override
    public void start(Stage primaryStage) {
    	GridPane root = new GridPane();

        //Light.Distant: Represents a distant light source.
        Light.Distant light = new Light.Distant();
        light.setAzimuth(45);
        light.setElevation(45);
        light.setColor(Color.YELLOW);
        Lighting lighting = new Lighting();
        lighting.setLight(light);


        ColorPicker colorPicker = new ColorPicker(Color.YELLOW);
        colorPicker.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                light.setColor(colorPicker.getValue());
            }
        });

        Button btn = new Button("Living Room");
        btn.setEffect(lighting);



        Circle circle = new Circle(30,  Color.rgb(255,255,255));
        circle.setEffect(lighting);


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
        sliderElevation.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                        Number old_val, Number new_val) -> {
            light.setElevation((Double)new_val);
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(colorPicker, btn, hBoxShape,
                labelElevation, sliderElevation);
   //2
    	GridPane root2 = new GridPane();

      //Light.Distant: Represents a distant light source.
        Light.Distant light2 = new Light.Distant();
        light2.setAzimuth(45);
        light2.setElevation(45);
        light2.setColor(Color.RED);
        Lighting lighting2 = new Lighting();
        lighting2.setLight(light2);


        ColorPicker colorPicker2 = new ColorPicker(Color.RED);
        colorPicker2.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                light2.setColor(colorPicker2.getValue());
            }
        });

        Button btn2 = new Button("Bedroom");
        btn2.setEffect(lighting2);



        Circle circle2 = new Circle(30,  Color.rgb(255,255,255));
        circle2.setEffect(lighting2);



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
        sliderElevation2.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                        Number old_val, Number new_val) -> {
            light2.setElevation((Double)new_val);
        });


        VBox vBox2 = new VBox();
        vBox2.setPadding(new Insets(10, 10, 10, 10));
        vBox2.getChildren().addAll(colorPicker2, btn2, hBoxShape2,
                labelElevation2, sliderElevation2);
//2 ends
    	GridPane root3 = new GridPane();

//3
        //Light.Distant: Represents a distant light source.
        Light.Distant light3 = new Light.Distant();
        light3.setAzimuth(45);
        light3.setElevation(45);
        light3.setColor(Color.GREEN);
        Lighting lighting3 = new Lighting();
        lighting3.setLight(light3);


        ColorPicker colorPicker3 = new ColorPicker(Color.GREEN);
        colorPicker3.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                light3.setColor(colorPicker3.getValue());
            }
        });

        Button btn3 = new Button("Hallways");

        btn3.setEffect(lighting3);



        Circle circle3 = new Circle(30,  Color.rgb(255,255,255));
        circle3.setEffect(lighting3);



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
        sliderElevation3.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                        Number old_val, Number new_val) -> {
            light3.setElevation((Double)new_val);
        });


        VBox vBox3 = new VBox();
        vBox3.setPadding(new Insets(10, 10, 10, 10));
        vBox3.getChildren().addAll(colorPicker3, btn3, hBoxShape3,
                labelElevation3, sliderElevation3);
//3 ends
        root.getChildren().add(vBox); //yellow bottom center
        root.setAlignment(Pos.BOTTOM_CENTER);
        root2.getChildren().add(vBox2);//red bottom right
        root2.setAlignment(Pos.BOTTOM_LEFT);
        root3.getChildren().add(vBox3); //green bottom left
        root3.setAlignment(Pos.BOTTOM_LEFT);

        primaryStage.show();
=======
	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();

		// Light.Distant: Represents a distant light source.
		Light.Distant light = new Light.Distant();
		light.setAzimuth(45);
		light.setElevation(45);
		light.setColor(Color.YELLOW);
		Lighting lighting = new Lighting();
		lighting.setLight(light);

		ColorPicker colorPicker = new ColorPicker(Color.YELLOW);
		colorPicker.setOnAction(new EventHandler() {
			@Override
			public void handle(Event t) {
				light.setColor(colorPicker.getValue());
			}
		});

		Button btn = new Button("Living Room");
		btn.setEffect(lighting);

		Circle circle = new Circle(30, Color.rgb(255, 255, 255));
		circle.setEffect(lighting);

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
					light.setElevation((Double) new_val);
				});

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.getChildren().addAll(colorPicker, btn, hBoxShape, labelElevation, sliderElevation);
		// 2
		GridPane root2 = new GridPane();

		// Light.Distant: Represents a distant light source.
		Light.Distant light2 = new Light.Distant();
		light2.setAzimuth(45);
		light2.setElevation(45);
		light2.setColor(Color.RED);
		Lighting lighting2 = new Lighting();
		lighting2.setLight(light2);

		ColorPicker colorPicker2 = new ColorPicker(Color.RED);
		colorPicker2.setOnAction(new EventHandler() {
			@Override
			public void handle(Event t) {
				light2.setColor(colorPicker2.getValue());
			}
		});

		Button btn2 = new Button("Bedroom");
		btn2.setEffect(lighting2);

		Circle circle2 = new Circle(30, Color.rgb(255, 255, 255));
		circle2.setEffect(lighting2);

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
					light2.setElevation((Double) new_val);
				});

		VBox vBox2 = new VBox();
		vBox2.setPadding(new Insets(10, 10, 10, 10));
		vBox2.getChildren().addAll(colorPicker2, btn2, hBoxShape2, labelElevation2, sliderElevation2);
		// 2 ends
		GridPane root3 = new GridPane();

		// 3
		// Light.Distant: Represents a distant light source.
		Light.Distant light3 = new Light.Distant();
		light3.setAzimuth(45);
		light3.setElevation(45);
		light3.setColor(Color.GREEN);
		Lighting lighting3 = new Lighting();
		lighting3.setLight(light3);

		ColorPicker colorPicker3 = new ColorPicker(Color.GREEN);
		colorPicker3.setOnAction(new EventHandler() {
			@Override
			public void handle(Event t) {
				light3.setColor(colorPicker3.getValue());
			}
		});

		Button btn3 = new Button("Hallways");

		btn3.setEffect(lighting3);

		Circle circle3 = new Circle(30, Color.rgb(255, 255, 255));
		circle3.setEffect(lighting3);

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
					light3.setElevation((Double) new_val);
				});

		VBox vBox3 = new VBox();
		vBox3.setPadding(new Insets(10, 10, 10, 10));
		vBox3.getChildren().addAll(colorPicker3, btn3, hBoxShape3, labelElevation3, sliderElevation3);
		// 3 ends
		root.getChildren().add(vBox); // yellow bottom center
		root.setAlignment(Pos.BOTTOM_CENTER);
		root2.getChildren().add(vBox2);// red bottom right
		root2.setAlignment(Pos.BOTTOM_LEFT);
		root3.getChildren().add(vBox3); // green bottom left
		root3.setAlignment(Pos.BOTTOM_LEFT);
>>>>>>> origin/lighting

		primaryStage.show();

		BorderPane border = new BorderPane(root, null, root2, null, root3);
		primaryStage.setTitle("Light");

		primaryStage.setScene(new Scene(border, 500, 500));
		primaryStage.show();
<<<<<<< HEAD


    }


=======
>>>>>>> origin/lighting

	}

	public static void main(String[] args) {
<<<<<<< HEAD
        launch(args);
    }
=======
		launch(args);
	}
>>>>>>> origin/lighting

}
