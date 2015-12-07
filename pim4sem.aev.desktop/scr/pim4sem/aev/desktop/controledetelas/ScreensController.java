package scr.pim4sem.aev.desktop.controledetelas;

import java.util.HashMap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class ScreensController extends StackPane{
	
	private HashMap<String, Node> screens = new HashMap<>();
	
	public ScreensController(){
		super();
	}
	
	//Adicionar uma screen para a coleçao
	public void addScreen(String name, Node screen){
		screens.put(name, screen);
	}
	
	//Retorno do node pelo nome
	public Node getScreen(String name){
		return screens.get(name);
	}
	
	//Este método carrega o fxml e o adiciona na coleção.
	//Ele também injeta o screenPane no controller.
	public boolean loadScreen(String name, String resource){
		try {
			FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
			Parent loadScreen = (Parent) myLoader.load();
			IControlledScreen myScreenControler = ((IControlledScreen) myLoader.getController());
			myScreenControler.setScreenParent(this);
			addScreen(name, loadScreen);
			return true;			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;			
		}
	}
	
	//Esse método tenta mostrar uma tela com nome pré-definido.
	//Primeiro ele garante se a tela está carregada. Se há mais de uma tela
	//a nova tela é adicionada em segundo plano, e a primeira é removida.
	// se não há nenhuma tela para ser mostrada, a nova tela é addicionada no root.
	public boolean setScreen(final String name){
		if(screens.get(name) != null){ //tela carregada
			final DoubleProperty opacity = opacityProperty();
			
			if(!getChildren().isEmpty()){ //se há mais de uma tela
				Timeline fade = new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
					new KeyFrame(new Duration(300), new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent t){
							getChildren().remove(0); //remove tela mostrada
							getChildren().add(0, screens.get(name)); //Adciona tela
							Timeline fadeIn = new Timeline(
								new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),	
								new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
							fadeIn.play();									
						}
				}, new KeyValue(opacity, 0.0)));
				fade.play();						
			} else {
				setOpacity(0.0);
				getChildren().add(screens.get(name)); //nenhuma tela, entao apenas mostra a tela nova
				Timeline fadeIn = new Timeline(
					new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
					new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
				fadeIn.play();						
			}
			return true;
		} else {
			System.out.println("A tela não foi carregada!!!\n");
			return false;
		}		
	}
	
	//Este método removerá a tela com o nome recebido
	public boolean unloadScreen(String name){
		if(screens.remove(name) == null){
			System.out.println("Tela não existe");
			return false;
		} else {
			return true;
		}
	}

}
