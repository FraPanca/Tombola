package tombola.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tombola.controller.Controller;
import tombola.model.Tombola;

public class TombolaApp extends Application {
	
	@Override
	public void start(Stage stage) {
		stage.setTitle("Tombola!");
		stage.getIcons().add(new Image("icon.png"));
		
		Tombola tombola = new Tombola();
		
		var controller = new Controller(tombola);
		MainPane mainPanel = new MainPane(controller);
		//
		Scene scene = new Scene(mainPanel, 640, 800, Color.AQUAMARINE);
		stage.setScene(scene);stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
