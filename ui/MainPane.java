package ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import controller.Controller;

public class MainPane extends BorderPane {
	
	private Controller controller;
	
	private TextArea outputAreaSchema, outputAreaNumEstr, outputAreaNumRim;
	private Button estrai, restart;
	
	public MainPane(Controller controller) {
		
		this.controller=controller;
		
		VBox leftBox = new VBox();
			leftBox.setPrefWidth(432);
			
			outputAreaSchema = new TextArea();
			outputAreaSchema.setPrefSize(432, 800);
			outputAreaSchema.setFont(Font.font("Courier New", FontWeight.NORMAL, 13));
			outputAreaSchema.setEditable(false);
			
			outputAreaSchema.setText(controller.schema());
			leftBox.getChildren().addAll(outputAreaSchema);
		this.setLeft(leftBox);
		
		////////////
		
		VBox rightBox = new VBox();
			rightBox.setPrefWidth(200);
			rightBox.setPrefHeight(100);
			
			HBox miniBoxIniziale = new HBox();
				miniBoxIniziale.setAlignment(Pos.CENTER);
				Label titolino = new Label("Tombola");
				titolino.setStyle("-fx-font-weight: bold");
			miniBoxIniziale.getChildren().addAll(titolino);
			rightBox.getChildren().addAll(new Label("\n\n\n"), miniBoxIniziale);
			
			HBox miniBoxNumEstr = new HBox();
				miniBoxNumEstr.setAlignment(Pos.CENTER);
				outputAreaNumEstr = new TextArea();
				outputAreaNumEstr.setPrefSize(150, 16);
				outputAreaNumEstr.setFont(Font.font("Courier New", FontWeight.NORMAL, 16));
				outputAreaNumEstr.setEditable(false);
				
				outputAreaNumEstr.setText("");
			miniBoxNumEstr.getChildren().addAll(outputAreaNumEstr);
			rightBox.getChildren().addAll(new Label("\n\n\n\n\n\t\tNumero estratto: "), miniBoxNumEstr);
			
			HBox miniBoxNumRim = new HBox();
				miniBoxNumRim.setAlignment(Pos.CENTER);
				outputAreaNumRim = new TextArea();
				outputAreaNumRim.setPrefSize(150, 16);
				outputAreaNumRim.setFont(Font.font("Courier New", FontWeight.NORMAL, 16));
				outputAreaNumRim.setEditable(false);
				
				outputAreaNumRim.setText("0 / 90");
			miniBoxNumRim.getChildren().addAll(outputAreaNumRim);
			rightBox.getChildren().addAll(new Label("\n\n\n\n\n\t\tNumeri rimanenti: "), miniBoxNumRim);
			
			HBox miniBoxButtonEstr = new HBox();
				miniBoxButtonEstr.setAlignment(Pos.CENTER);
				estrai = new Button("Estrai");
				estrai.setPrefWidth(150);		
				estrai.setAlignment(Pos.CENTER);
				
				estrai.setOnAction(e -> estrai());
			miniBoxButtonEstr.getChildren().addAll(estrai);
			rightBox.getChildren().addAll(new Label("\n\n\n\n\n\n\n\n\n\n"), miniBoxButtonEstr);
			
			HBox miniBoxButtonRes = new HBox();
				miniBoxButtonRes.setAlignment(Pos.CENTER);
				restart = new Button("Restart");
				restart.setPrefWidth(150);	
				restart.setAlignment(Pos.CENTER);
				
				restart.setOnAction(e -> askRestart());
			miniBoxButtonRes.getChildren().addAll(restart);
			rightBox.getChildren().addAll(new Label("\n\n\n\n\n\n\n\n\n\n"), miniBoxButtonRes);
			
			
		this.setRight(rightBox);
	}
	
	private void estrai() {
		if(controller.getRimanenti() == 0) {
			Controller.errorAlert("Tombola!", "Sono finiti i numeri!", "Qualcuno dovrà pur aver vinto...");
			res();
		} else {
			int n = controller.getNumero();
			
			outputAreaSchema.setText(controller.schema());
			
			outputAreaNumEstr.setText(String.valueOf(n));
			outputAreaNumRim.setText(String.valueOf(controller.getRimanenti()) + " / 90");
		}	
	}
	
	private void askRestart() {
		if(Controller.ConfirmationAlert("Tombola!", "Vuoi riniziare la partita?", "Una volta premuto \"ok\" non è possibile tornare indietro")) res();
	}
	
	private void res() {		
		controller.restart();
			
		outputAreaSchema.setText(controller.schema());
			
		outputAreaNumEstr.setText("");
		outputAreaNumRim.setText("0 / 90");		
	}
	
}
