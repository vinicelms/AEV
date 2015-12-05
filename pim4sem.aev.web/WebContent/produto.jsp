<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pim4sem.aev.business.produto.Produto" %>
<%@ page import="pim4sem.aev.business.DAO.ProdutoDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE HTML>
    
<html>
    <head>
        <title>AEV - Produtos</title>
        <meta charset="utf-8">
        <!-- Define os pacotes externos para funcionamento da página, como CSS e Fonts -->
        <link href="css/style.css" rel="stylesheet"/>
        <link href="css/Semantic-UI/semantic.css" rel="stylesheet"/>
        <link href="css/Foundation-5.5.3/css/foundation.css" rel="stylesheet"/>
        <link href="images/sapato_vetorial.ico" rel="icon"/>
        <link href="js/labelholder.css" rel="stylesheet"/>
        <script language="javascript" src="js/TableFilter/tablefilter.js" type="text/javascript"></script>
        <script language="javascript" src="js/jquery.js" type="text/javascript"></script>
        <script language="javascript" src="js/event.js" type="text/javascript"></script>
        <script language="javascript" src="js/jquery.maskedinput.js" type="text/javascript"></script>
        <script language="javascript" src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <script language="javascript" src="css/Semantic-UI/semantic.js" type="text/javascript"></script>
        <script language="javascript" src="js/labelholder.js" type="text/javascript"></script>
        <script language="javascript" src="js/mutate/mutate.events.js" type="text/javascript"></script>
        <script language="javascript" src="js/mutate/mutate.min.js" type="text/javascript"></script>
        
        <script>
            $(document).ready( function() {
                $(".labelholder").labelholder();
                reposicionaRodape();
            });
            
            function reposicionaRodape() {
                $('#rodape').css("margin-top", function() {
                    var valor = $('body').height() - $('.row').height() - $('#rodape').height();
                    if(valor > 0){
                        return valor;
                    } else {
                        return 30;
                    }
                });
                setTimeout(reposicionaRodape, 100);
            }
        </script>
    </head>
    <body class="corpo_geral" onload="defineMascaraPesquisaProduto()">
        <span class="row">
        
            <div id="TopoBox">
                <a style="color: #292929;" href="home.jsp">
                    <div class="circulo_sapato"></div>
                        <img src="images/sapato_vetorial.ico" class="sapato_circulo"
                         style="margin-top: 13px; margin-left: 20px">
                        <div id="TextoTopoBox">
                            PIM AEV
                </a>
                    <span id="links">
                        <a href="#">Link 1</a>
                        <a href="#">Link 2</a>
                        <a href="#">Link 3</a>
                        <a href="#">Link 4</a>
                    </span>
                </div>
            </div>
            
            <div class="full_body">
                <div class="full_body_text">
                    <h1>Produto</h1>
                    
                    <form id="formProduto" action="edita_produto.jsp" method="post" class="ui form grid">
                        <div class="ui four column grid">
                            <div class="row">
                            	<div class="column"></div>
                            	<div class="column"></div>
                            	<div class="column">
                                    <input id="valorEdicao" name="valorEdicao" type="hidden" value="">
                                </div>
                                <div class="column">
                                    <button id="cadastraProduto" class="ui submit positive button right floated">
                                        Cadastrar Novo Produto</button>
                                </div>
                            </div>
                        </div>
                	</form>
	                    <table id="table_produto" class="ui selectable celled table">
	                        <thead>
	                            <tr>
	                                <th>Cod.</th>
	                                <th>Nome</th>
	                                <th>Marca</th>
	                                <th>Cor</th>
	                                <th>Compra ($)</th>
	                                <th>Venda ($)</th>
	                                <th>Descrição</th>
	                                <th>Tamanho</th>
	                                <th>Tipo de Produto</th>
	                                <th>Estoque</th>
	                                <th>Minima</th>
	                                <th></th>
	                            </tr>
	                        </thead>
	                        <tr>
	                        	<%                        	
	                        		ProdutoDAO prod = new ProdutoDAO();
	                        		Produto produto = new Produto();
	                        		List<Produto> listaProduto = new ArrayList<Produto>();
	                        		listaProduto = prod.retornaProduto(null, null);
	                        		for(int i = 0; i < listaProduto.size(); i++){
	                        			out.println("<tr><td>");
	                        			out.println(listaProduto.get(i).getCodigo());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getNome());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getMarca());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getCor());
	                        			out.println("</td><td>");
	                        			out.println("R$ " + listaProduto.get(i).getValorCompra());
	                        			out.println("</td><td>");
	                        			out.println("R$ " + listaProduto.get(i).getValorVenda());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getDescricao());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getTamanho());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getTipoProduto());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getQuantidadeEstoque());
	                        			out.println("</td><td>");
	                        			out.println(listaProduto.get(i).getQuantidadeMinima());
	                        			out.println("</td><td><i id='editaProduto' onclick='editaProduto(" +
	                        					listaProduto.get(i).getCodigo() + ")' " +
	                        					"class='write icon'></i></td></tr>");
	                        		}
	                        	%>
	                        </tr>
	                    </table>
                    	<br>
                </div>
            </div>
            
        </span>
        
        <script lang="javascript" type="text/javascript">
             var tableFilter = {
                col_11: "none",
                on_change: false,
            };

            var tf = setFilterGrid("table_produto", tableFilter);
            
            $('.ui.dropdown').dropdown();
            
            $(document).ready(function(){
                $("#cadastraProduto").click(function(){
                    document.location.href = "cadastra_produto.jsp";
                    return false;
                });
            });
        </script>
        
        <div id="rodape">
                <div class="circulo_sapato" style="margin-top: -15px; margin-left: 94%"></div>
                <img src="images/sapato_vetorial.ico" class="sapato_circulo"
                     style="margin-top: -5px; margin-left: 95%">
                <div id="rodape_texto">
                    <span id="rodape_texto_bold">Desnevolvido por:<br></span>
                    <span id="rodape_texto_bold">A</span>ndré Luiz Costa<br>
                    <span id="rodape_texto_bold">E</span>dson de Assis Dalécio<br>
                    <span id="rodape_texto_bold">V</span>inicius Celms
                </div>
            </div>
        
    </body>
</html>