import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login extends Application {
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
				if (password.getText().equals("Password123!") || password.getText().equals("0008008784122,13392")) {
					response.setText("Access Granted!");
					response.setTextFill(Color.web("green"));
				} else {
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
}