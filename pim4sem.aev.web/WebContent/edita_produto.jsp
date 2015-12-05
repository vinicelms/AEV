<%@page import="pim4sem.aev.business.DAO.TipoProdutoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pim4sem.aev.business.produto.Produto" %>
<%@ page import="pim4sem.aev.business.DAO.ProdutoDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%
	String codigo = request.getParameter("valorEdicao");
    String nome = null;
    String marca = null;
    String cor = null;
    String valorCompra = null;
    String valorVenda = null;
    String tamanho = null;
    String estoque = null;
    String minima = null;
    String tipoProduto = null;
    String descricao = null;
    String alerta = null;
    ProdutoDAO produto = new ProdutoDAO();
    List<Produto> listaProduto = new ArrayList<>();
    listaProduto = produto.retornaProduto("Codigo", codigo);
    nome = listaProduto.get(0).getNome();
    marca = listaProduto.get(0).getMarca();
    cor = listaProduto.get(0).getCor();
    valorCompra = String.valueOf(listaProduto.get(0).getValorCompra());
    valorVenda = String.valueOf(listaProduto.get(0).getValorVenda());
    tamanho = String.valueOf(listaProduto.get(0).getTamanho());
    estoque = String.valueOf(listaProduto.get(0).getQuantidadeEstoque());
    minima = String.valueOf(listaProduto.get(0).getQuantidadeMinima());
    tipoProduto = listaProduto.get(0).getTipoProduto();
    descricao = listaProduto.get(0).getDescricao();
    
    TipoProdutoDAO tp = new TipoProdutoDAO();
	List<String> listaTp = new ArrayList<>();
	listaTp = tp.retornaTipoProduto();
%>
    
<html>
    <head>
        <title>AEV - Edita Produto</title>
        <meta charset="utf-8">
        <!-- Define os pacotes externos para funcionamento da pÃ¡gina, como CSS e Fonts -->
        <link href="css/style.css" rel="stylesheet"/>
        <link href="css/Semantic-UI/semantic.css" rel="stylesheet"/>
        <link href="css/Foundation-5.5.3/css/foundation.css" rel="stylesheet"/>
        <link href="images/sapato_vetorial.ico" rel="icon"/>
        <script language="javascript" src="js/TableFilter/tablefilter.js" type="text/javascript"></script>
        <script language="javascript" src="js/jquery.js" type="text/javascript"></script>
        <script language="javascript" src="js/event.js" type="text/javascript"></script>
        <script language="javascript" src="js/jquery.maskedinput.js" type="text/javascript"></script>
        <script language="javascript" src="js/jquery.maskMoney.js" type="text/javascript"></script>
        <script language="javascript" src="css/Semantic-UI/semantic.js" type="text/javascript"></script>
        <script language="javascript" src="js/jquery.label_better.js" type="text/javascript"></script>
        <script language="javascript" src="js/labelholder.js" type="text/javascript"></script>
        <link href="js/labelholder.css" rel="stylesheet"/>
        
        <script>
            $(function() {
                $('#valorCompra').maskMoney();
                $('#valorVenda').maskMoney();
            });
            
            jQuery(function($){
                $("#tamanho").mask("9?9");
                $("#qtd_estoque").mask("9?999");
                $("#qtd_minima").mask("9?999");
            });
            
            $('.ui.dropdown').dropdown();
            
            $(document).ready(function(){
                $(".labelholder").labelholder();
                $('#rodape').css("margin-top", function() {
                    var valor = $('body').height() - $('.row').height() - $('#rodape').height();
                    if(valor > 0){
                        return valor;
                    } else {
                        return 30;
                    }
                });
                reposicionaRodape();
                $('#tipoProduto').val('<%= tipoProduto %>');
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
    <body class="corpo_geral" onload="contarDescricao()">
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
                    <h1>Editar Produto</h1>
                    <br>
                    
                    <form class="ui form" action="cadastra_edicao.jsp" method="post">
                        <div class="fields">
                            <div class="two wide field labelholder">
                                <input id="codigo" name="codigo" type="text" readonly maxlength="10" placeholder="Código"
                                	value='<%= codigo %>'>
                            </div>
                            <div class="six wide field">
                                <div class="ui icon input labelholder">
                                    <input id="nome" name="nome" type="text" required 
                                           onkeyup="return validaFormulario(false)" placeholder="Nome do produto"
                                           value='<%= nome %>'>
                                    <i id="iconeNome" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="six wide field">
                                <div class="ui icon input labelholder">
                                    <input id="marca" name="marca" type="text" required 
                                           onkeyup="return validaFormulario(false)" placeholder="Marca do produto"
                                           value='<%= marca %>'>
                                    <i id="iconeMarca" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="cor" name="cor" type="text" required onkeyup="return validaFormulario(false)"
                                           placeholder="Cor do produto" value='<%= cor %>'>
                                    <i id="iconeCor" class="warning circle icon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="fields">
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="valorCompra" name="valorCompra" data-decimal="," data-prefix="R$ " 
                                       type="text" maxlength="9" required onkeyup="return validaFormulario(false)"
                                           placeholder="Valor de Compra" value='R$ <%= valorCompra %>'>
                                    <i id="iconeValorCompra" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="valorVenda" name="valorVenda" data-decimal="," data-prefix="R$ " 
                                       type="text" maxlength="9" required onkeyup="return validaFormulario(false)"
                                           placeholder="Valor de Venda" value='R$ <%= valorVenda %>'>
                                    <i id="iconeValorVenda" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three  wide field">
                                <div class="ui icon input labelholder">
                                    <input name="tamanho" id="tamanho" type="text" maxlength="2" required 
                                           placeholder="Tamanho" value='<%= tamanho %>'>
                                    <i id="iconeTamanho" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="estoque" name="estoque" id="qtd_estoque" maxlength="8" type="text" required
                                        onkeyup="return validaFormulario(false)" placeholder="Qtd. em Estoque"
                                        value='<%= estoque %>'>
                                    <i id="iconeEstoque" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="minima" name="minima" id="qtd_minima" maxlength="8" type="text" required
                                        onkeyup="return validaFormulario(false)" placeholder="Qtd. Mínima"
                                        value='<%= minima %>'>
                                    <i id="iconeMinima" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input">
                                    <select id="tipoProduto" name="tipoProduto" class="ui fluid dropdown" 
                                            onchange="return validaFormulario(false)">
                                        <option value="" placeholder="teste">Tipo de Produto</option>
                                        <%
                                        	for(int i = 0; i < listaTp.size(); i++){
                                        		out.print("<option value='" + listaTp.get(i) + "'>");
                                        		out.print(listaTp.get(i) + "</option>");
                                        	}
                                        %>
                                    </select>
                                    <i class="dropdown icon"></i>
                                    <i id="iconeTipoProduto" style="margin-right: 15px" class="warning circle icon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="field labelholder">
                            <textarea id="descricao" maxlength="500" draggable="false" rows="4" 
                                      style="resize: none" name="descricao" onkeyup="contarDescricao()" 
                                      placeholder="Descrição do produto"><%= descricao %></textarea>
                            <div id="carac_descricao" class="floated right"></div>
                            <br>
                        </div>
                        <div id="errorForm">
                            <div id="errorMensagem"></div>
                        </div>
                        <br>
                        <button class="ui left floated negative button" type="reset">Cancelar</button>
                        <button class="ui submit right floated positive button" type="submit" 
                                onclick="return validaFormulario(true)">Confirmar</button>
                        <br>
                        <br>
                    </form>
                    
                </div>
            </div>
            
        </span>
        
        <div id="rodape">
                <div class="circulo_sapato" style="margin-top: -15px; margin-left: 94%"></div>
                <img src="images/sapato_vetorial.ico" class="sapato_circulo"
                     style="margin-top: -5px; margin-left: 95%">
                <div id="rodape_texto">
                    <span id="rodape_texto_bold">Desnevolvido por:<br></span>
                    <span id="rodape_texto_bold">A</span>ndrÃ© Luiz Costa<br>
                    <span id="rodape_texto_bold">E</span>dson de Assis DalÃ©cio<br>
                    <span id="rodape_texto_bold">V</span>inicius Celms
                </div>
            </div>
        
    </body>
</html>