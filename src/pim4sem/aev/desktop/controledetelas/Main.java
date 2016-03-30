package scr.pim4sem.aev.desktop.controledetelas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static String MenuTelaID = "MenuTela";
	public static String MenuTelaFile = "MenuTela.fxml";
	public static String EstoqueTelaID = "EstoqueTela";
	public static String EstoqueTelaFile = "EstoqueTela.fxml";
	public static String VendasTelaID = "VendasTela";
	public static String VendasTelaFile = "VendasTela.fxml";	
	public static String LoginTelaID = "LoginTela";
	public static String LoginTelaFile = "LoginTela.fxml";	
	
	@Override
	public void start(Stage primaryStage){
		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(Main.LoginTelaID, LoginTelaFile);
		mainContainer.loadScreen(Main.MenuTelaID, MenuTelaFile);
		mainContainer.loadScreen(Main.EstoqueTelaID, EstoqueTelaFile);
		mainContainer.loadScreen(Main.VendasTelaID, VendasTelaFile);
		
		mainContainer.setScreen(Main.LoginTelaID);
		
		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root, 800, 580);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Loja de Calçados");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
