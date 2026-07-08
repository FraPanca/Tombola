package controller;

import java.util.Optional;
import java.util.StringJoiner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.Tombola;

public class Controller {
	
	public static void errorAlert(String title, String headerMessage, String contentMessage) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(title);
		alert.setHeaderText(headerMessage);
		alert.setContentText(contentMessage);
		alert.showAndWait();
	}
	
	public static boolean ConfirmationAlert(String title, String headerMessage, String contentMessage) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerMessage);
		alert.setContentText(contentMessage);
		Optional<ButtonType> buttonType = alert.showAndWait();
		
		if(buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) return true;
		
		return false;
	}
	
	
	private Tombola tombola;
	
	public Controller(Tombola tombola) {
		if(tombola == null) throw new IllegalArgumentException("Tombola nulla nel construttore del Controller");
		this.tombola = tombola;
	}

	public Tombola getTombola() {
		return tombola;
	}
	
	public int getNumero() {
		return tombola.getNum();
	}
	
	public int getRimanenti() {
		return tombola.numeriRimanenti();
	}
	
	public void restart() {
		tombola.newGame();
	}
	
	public String schema() {
		StringJoiner str = new StringJoiner(" | ");
		
		str.add("");
		for(int i=0; i<9; i++) {
			for(int j=1; j<=10; j++) {
				if(tombola.getTabella().contains(i*10+j)) str.add("O ");
				else {
					if(i*10+j < 10) str.add(String.valueOf(i*10+j) + " ");
					else str.add(String.valueOf(i*10+j));					
				}
			}
			str.add("\n ---------------------------------------------------\n");
		}
		
		//System.out.println(str.toString());
		return "\n ---------------------------------------------------\n" + str.toString();
	}
}
