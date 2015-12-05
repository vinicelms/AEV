<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pim4sem.aev.business.DAO.TipoProdutoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	TipoProdutoDAO tp = new TipoProdutoDAO();
	List<String> listaTp = new ArrayList<>();
	listaTp = tp.retornaTipoProduto();
%>
<html>
    <head>
        <title>AEV - Cadastra Produto</title>
        <meta charset="utf-8">
        <!-- Define os pacotes externos para funcionamento da página, como CSS e Fonts -->
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
            });
            
            $(window).resize(function() {
                $('#rodape').css("margin-top", function() {
                    var valor = $('body').height() - $('.row').height() - $('#rodape').height();
                    if(valor > 0){
                        return valor;
                    } else {
                        return 30;
                    }
                });
            });
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
                    <h1>Cadastra Produto</h1>
                    <br>
                    
                    <form class="ui form" action="cadastra_lista.jsp" method="post" id="cadastroProduto">
                        <div class="fields">
                            <div class="six wide field">
                                <div class="ui icon input labelholder">
                                    <input id="nome" name="nome" type="text" 
                                           onkeyup="return validaFormulario(false)" placeholder="Nome do produto">
                                    <i id="iconeNome" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="six wide field">
                                <div class="ui icon input labelholder">
                                    <input id="marca" name="marca" type="text" 
                                           onkeyup="return validaFormulario(false)" placeholder="Marca do produto">
                                    <i id="iconeMarca" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="four wide field">
                                <div class="ui icon input labelholder">
                                    <input id="cor" name="cor" type="text" onkeyup="return validaFormulario(false)"
                                           placeholder="Cor do produto">
                                    <i id="iconeCor" class="warning circle icon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="fields">
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="valorCompra" name="valorCompra" data-decimal="," data-prefix="R$ " 
                                       type="text" maxlength="9" onkeyup="return validaFormulario(false)"
                                           placeholder="Valor de Compra">
                                    <i id="iconeValorCompra" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="valorVenda" name="valorVenda" data-decimal="," data-prefix="R$ " 
                                       type="text" maxlength="9" onkeyup="return validaFormulario(false)"
                                           placeholder="Valor de Venda">
                                    <i id="iconeValorVenda" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three  wide field">
                                <div class="ui icon input labelholder">
                                    <input name="tamanho" id="tamanho" type="text" maxlength="2" 
                                           placeholder="Tamanho" onkeyup="return validaFormulario(false)">
                                    <i id="iconeTamanho" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="estoque" name="estoque" id="qtd_estoque" maxlength="8" type="text"
                                        onkeyup="return validaFormulario(false)" placeholder="Qtd. em Estoque">
                                    <i id="iconeEstoque" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="minima" name="minima" id="qtd_minima" maxlength="8" type="text"
                                        onkeyup="return validaFormulario(false)" placeholder="Qtd. Mínima">
                                    <i id="iconeMinima" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input">
                                    <select id="tipoProduto" name="tipoProduto" class="ui fluid dropdown" 
                                            onchange="return validaFormulario(false)">
                                        <option value="">Tipo de Produto</option>
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
                                      style="resize: none" onkeyup="contarDescricao()" 
                                      placeholder="Descrição do produto"></textarea>
                            <div id="carac_descricao" class="floated right"></div>
                            <br>
                        </div>
                        <button class="ui left floated negative button" type="reset">Limpa Formulário</button>
                        <button class="ui submit right floated positive button" type="submit" 
                                onclick="return insereProdutoLista()">Insere Produto</button>
                        <br>
                        <br>
                        <div id="listaCadastro"></div>
                        <div id="errorForm">
                            <div id="errorMensagem"></div>
                        </div>
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
                    <span id="rodape_texto_bold">A</span>ndré Luiz Costa<br>
                    <span id="rodape_texto_bold">E</span>dson de Assis DalÃ©cio<br>
                    <span id="rodape_texto_bold">V</span>inicius Celms
                </div>
            </div>
        
    </body>
</html>