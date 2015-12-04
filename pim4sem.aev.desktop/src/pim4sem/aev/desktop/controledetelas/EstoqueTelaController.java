package pim4sem.aev.desktop.controledetelas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pim4sem.aev.business.DAO.ProdutoDAO;
import pim4sem.aev.business.produto.Produto;

public class EstoqueTelaController {

	
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtDesc;
	@FXML
	private TextField txtCor;
	@FXML
	private TextField txtMarca;
	@FXML
	private TextField txtQuantidade;
	@FXML
	private TextField txtValor;
	@FXML 
	private Button btnPesquisar;
	@FXML 
	private Button btnLimpar;

	@FXML
	private void initialize(){
		btnPesquisar.disableProperty().bind(txtId.textProperty().isEmpty());
		btnLimpar.disableProperty().bind(txtId.textProperty().isEmpty());
	}
	
	@FXML
	private void onExit(){
		Platform.exit();
	}
	
	@FXML
	private void onLimpar(){
		txtId.setText(null);
		txtNome.setText(null);
		txtDesc.setText(null);
		txtCor.setText(null);
		txtMarca.setText(null);
		txtQuantidade.setText(null);
		txtValor.setText(null);
	}
	
	@FXML
	private void onPesquisar() throws SQLException{
		int numProd = 0;
		
		ProdutoDAO pd = new ProdutoDAO();
		List<Produto> produtos = new ArrayList<Produto>();
		produtos = pd.retornaProduto("id_produto", txtId.getText());
		
		for(Produto prod : produtos){
			numProd++;
		}
		txtQuantidade.setText(String.valueOf(numProd));
	}
	
}
