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
	private void initialize() throws SQLException{
		btnPesquisar.disableProperty().bind(txtId.textProperty().isEmpty());
		btnLimpar.disableProperty().bind(txtId.textProperty().isEmpty());
		
		
		Produto p1 = new Produto();
		ProdutoDAO pdd = new ProdutoDAO();
		
		/*
		p1.setCodigo(1122);
		p1.setNome("crocs");
		p1.setMarca("feio");
		p1.setCor("verde");
		p1.setValorCompra(10);
		p1.setValorVenda(300);
		p1.setDescricao("yhyhyhyedede");
		p1.setTamanho(40);
		p1.setTipoProduto("2");
		p1.setQuantidadeEstoque(25);
		p1.setQuantidadeMinima(15);
		p1.setPosicaoEstoque('a');
		p1.setPosicaoPrateleira(1);
		pdd.registrarProduto(p1);
		*/
		
		
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
	private void onPesquisar() throws SQLException, IndexOutOfBoundsException{
		ProdutoDAO pd = new ProdutoDAO();	
		List<Produto> produtos = new ArrayList<Produto>();
		produtos = pd.retornaProduto("Codigo", txtId.getText());
			
		try {
			txtNome.setText(produtos.get(0).getNome());
			txtDesc.setText(produtos.get(0).getDescricao());
			txtCor.setText(produtos.get(0).getCor());
			txtMarca.setText(produtos.get(0).getMarca());
			txtQuantidade.setText(String.valueOf(produtos.get(0).getQuantidadeEstoque()));
			txtValor.setText(String.valueOf(produtos.get(0).getValorVenda()));
		} catch (IndexOutOfBoundsException e) {
			onLimpar();
			txtId.setText("ID INEXISTENTE");
		}

		//TESTE
		/*
		produtos = pd.retornaProduto(null,null);
		for(int i = 0; i < produtos.size(); i++){
			System.out.println(produtos.get(i).getCodigo());
		}*/
				
	}
	
}
