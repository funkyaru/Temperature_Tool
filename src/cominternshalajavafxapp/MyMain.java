package cominternshalajavafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
		System.out.println("init");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode, 500, 500);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter tool");
		//primaryStage.setResizable(false);
		primaryStage.show();
	}

	public MenuBar createMenu(){

		//File menu
		Menu fileMenu=new Menu("File");
		MenuItem newmenuItem=new MenuItem("New");

		newmenuItem.setOnAction(event -> System.out.println("New Menu item clicked"));

		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitmenuItem=new MenuItem("Quit");

		quitmenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newmenuItem,separatorMenuItem,quitmenuItem);

		//help menu
		Menu helpMenu=new Menu("Help");
		MenuItem aboutmenu=new MenuItem("About");

		aboutmenu.setOnAction(event -> {
			aboutApp();
		});

		helpMenu.getItems().addAll(aboutmenu);

		//menubar
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;

	}

	private static void aboutApp() {
		Alert alertDialog=new Alert(Alert.AlertType.CONFIRMATION);
		alertDialog.setTitle("My First Desktop Application");
		alertDialog.setHeaderText("Learning JavaFx");
		alertDialog.setContentText("This tool helps you convert temperature C to F");

		ButtonType yesBtn=new ButtonType("Yes");
		ButtonType noBtn=new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> clickBtn=alertDialog.showAndWait();

		if(clickBtn.isPresent() && (clickBtn.get() == yesBtn)){
			System.out.println("Yes");
		}
		if(clickBtn.isPresent() && clickBtn.get()==noBtn){
			System.out.println("No");
		}
	}


	@Override
	public void stop() throws Exception {
		super.stop();
		System.out.println("stop");
	}
}
