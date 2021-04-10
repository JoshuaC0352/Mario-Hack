package Main;

import Controller.Globals;
import Controller.MainScene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RunEditor 
{
	public static Stage mainWindow;
	
	/*
	 * SCENES
	 */
	public static Scene mainScene;
	public static String filePath;
	public static TextField pathField;
	
	public static TextField wzOneOne = new TextField();
	public static TextField wzOneTwo = new TextField();
	public static TextField wzOneThree = new TextField();
	public static TextField wzTwo = new TextField();
	public static TextField wzThreeOne = new TextField();
	public static TextField wzThreeTwo = new TextField();
	public static TextField wzThreeThree = new TextField();

	
	public static void startProgram(Stage primaryStage)
	{
		filePath = MainScene.getFilePath();
		mainWindow = primaryStage;
		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		
		GridPane root = new GridPane();
		
		Scene mainScene = new Scene(root);
		
		FileChooser fileChooser = new FileChooser();
		Button chooseFileButton = new Button("Browse");
		Button applyButton = new Button("Apply");
		Globals.addFileChoserToButton(chooseFileButton, fileChooser);
		MainScene.addListenerToButton(applyButton);
		
		
		HBox warpZoneOne = new HBox();
		HBox warpZoneTwo = new HBox();
		HBox warpZoneThree = new HBox();
		
		Label title = new Label("MARIO EDITOR");
		
		Label pathLabel = new Label("File Path: ");
		Label labelOne = new Label("Warp Zone One: ");
		Label labelTwo = new Label("Warp Zone Two: ");
		Label labelThree = new Label("Warp Zone Three: ");
		
		pathField = new TextField();
		wzOneOne = new TextField();
		wzOneOne.setText("2");
		wzOneTwo = new TextField();
		wzOneTwo.setText("3");
		wzOneThree = new TextField();
		wzOneThree.setText("4");
		wzTwo = new TextField();
		wzTwo.setText("5");
		wzThreeOne = new TextField();
		wzThreeOne.setText("6");
		wzThreeTwo = new TextField();
		wzThreeTwo.setText("7");
		wzThreeThree = new TextField();
		wzThreeThree.setText("8");
		
		pathField.setText(filePath);
		pathField.setEditable(false);
		
		
		Globals.addTextLimiter(wzOneOne, 3);
		Globals.addTextLimiter(wzOneTwo, 3);
		Globals.addTextLimiter(wzOneThree, 3);
		Globals.addTextLimiter(wzTwo, 3);
		Globals.addTextLimiter(wzThreeOne, 3);
		Globals.addTextLimiter(wzThreeTwo, 3);
		Globals.addTextLimiter(wzThreeThree, 3);
		
		wzOneOne.setMaxWidth(35);
		wzOneTwo.setMaxWidth(35);
		wzOneThree.setMaxWidth(35);
		wzTwo.setMaxWidth(35);
		wzThreeOne.setMaxWidth(35);
		wzThreeTwo.setMaxWidth(35);
		wzThreeThree.setMaxWidth(35);
		
		warpZoneOne.getChildren().add(wzOneOne);
		warpZoneOne.getChildren().add(wzOneTwo);
		warpZoneOne.getChildren().add(wzOneThree);
		warpZoneTwo.getChildren().add(wzTwo);
		warpZoneThree.getChildren().add(wzThreeOne);
		warpZoneThree.getChildren().add(wzThreeTwo);
		warpZoneThree.getChildren().add(wzThreeThree);
		
		//root.add(buffer, 1, 0);
		
		root.add(title, 1, 0);
		root.add(pathLabel, 0, 1);
		root.add(pathField, 1, 1);
		root.add(chooseFileButton, 2, 1);
		root.add(labelOne, 0, 3);
		root.add(labelTwo, 0, 4);
		root.add(labelThree, 0, 5);
		root.add(warpZoneOne, 1, 3);
		root.add(warpZoneTwo, 1, 4);
		root.add(warpZoneThree, 1, 5);
		root.add(applyButton, 1, 6);
		
		primaryStage.setScene(mainScene);
		
		mainWindow.setResizable(false);
		mainWindow.show();
	}
}


	
	

