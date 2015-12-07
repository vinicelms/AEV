package scr.pim4sem.aev.desktop.controledetelas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuTelaController implements IControlledScreen {

	@FXML 
	private Button btnCompras;
	@FXML 
	private Button btnEstoque;
	
	ScreensController myController;
	
	public void setScreenParent(ScreensController screenParent){
		myController = screenParent;	
	}	
	
	@FXML 
	private void onAbrirEstoque(){
		myController.setScreen(Main.EstoqueTelaID);
	}

	@FXML 
	public void onAbrirVendas() {
		myController.setScreen(Main.VendasTelaID);
	}
	
	
	

}
