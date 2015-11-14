package Covert;

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CovertChannelGUI extends Application {
	
	Stage stage;
	File fileToTransfer;
	Label fileSelection;
	GridPane root;

	@Override
	public void start(Stage primaryStage) {
		root = new GridPane();
		setupMenu();
		stage = primaryStage;
		stage.setScene(new Scene(root));
		stage.setTitle("Covert Channel GUI");
		stage.show();
	}
	
	public void setupMenu(){
		root.setPadding(new Insets(15,15,15,15));
		
		setupFileTransfer();
		setupTextTransfer();
		setupStartArea();
		
	}
	
	public void setupFileTransfer(){
		HBox fileRow = new HBox();
		HBox checkBoxRow = new HBox();
		fileRow.setSpacing(5);
		Button openButton = new Button("Select File");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select file to transfer");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
		fileSelection = new Label("No file selected");
		openButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				fileToTransfer = fileChooser.showOpenDialog(stage.getScene().getWindow());
				if(fileToTransfer!=null){
					try{
						fileSelection.setText(fileToTransfer.getName());
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		});
		CheckBox sendFileCheckbox = new CheckBox();
		Label fileTransferDescription = new Label("Send file: ");
		fileRow.getChildren().add(fileSelection);
		fileRow.getChildren().add(openButton);
		checkBoxRow.getChildren().add(fileTransferDescription);
		checkBoxRow.getChildren().add(sendFileCheckbox);
		
		root.add(fileRow, 1, 1);
		root.add(checkBoxRow, 1, 2);
	}
	
	public void setupTextTransfer(){
		HBox textRow = new HBox();
		textRow.setSpacing(5);
		
		TextArea textEntryArea = new TextArea();
		
		CheckBox sendText = new CheckBox();
		Label textTransferDescription = new Label("Send text: ");
		
		textRow.getChildren().add(textTransferDescription);
		textRow.getChildren().add(sendText);
		
		root.add(textEntryArea, 2, 1);
		root.add(textRow, 2, 2);
	}
	
	public void setupStartArea(){
		Button startChannelButton = new Button("Start Covert App");
		//Add code to start Server/Client connection
		startChannelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		Button startTransfersButton = new Button("Start Covert Transfers");
		//Add code to start the covert transfer
		startTransfersButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			}
		});
		
		root.add(startChannelButton, 1, 3);
		root.add(startTransfersButton, 2, 3);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
