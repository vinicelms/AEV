package pim4sem.aev.desktop.controledetelas;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static String MenuTelaID = "MenuTela";
	public static String MenuTelaFile = "MenuTela.fxml";
	public static String EstoqueTelaID = "EstoqueTela";
	public static String EstoqueTelaFile = "EstoqueTela.fxml";
	
	@Override
	public void start(Stage primaryStage){
		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(Main.MenuTelaID, MenuTelaFile);
		mainContainer.loadScreen(Main.EstoqueTelaID, EstoqueTelaFile);
		
		mainContainer.setScreen(Main.MenuTelaID);
		
		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root, 800, 550);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Loja de Calçados");
		primaryStage.show();
	}
	
	
	
	
	
/*
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			String sceneName;
			sceneName = "MenuTela.fxml";
			//sceneName = "EstoqueTela.fxml";
			
			Pane root = FXMLLoader.load(getClass().getResource(sceneName));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
*/
	public static void main(String[] args) {
		launch(args);
	}
}
