<!-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
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
        
        <script>
            $(document).ready( function() {
                $(".labelholder").labelholder();
            });
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
                    
                    <form class="ui form grid">
                        <div class="ui four column grid">
                            <div class="row">
                                <div class="column">
                                    <button id="cadastraProduto" class="ui submit positive button">
                                        Cadastrar Novo Produto</button>
                                </div>
                                <div class="column"></div>
                                <div class="column">
                                    <select id="coluna" onchange="defineMascaraPesquisaProduto()" 
                                            class="ui fluid dropdown">
                                        <option value="">Tipo de Informação</option>
                                        <option value="Codigo">Código</option>
                                        <option value="Nome">Nome</option>
                                        <option value="Marca">Marca</option>
                                        <option value="Cor">Cor</option>
                                        <option value="Descricao">Descrição</option>
                                        <option value="Tamanho">Tamanho</option>
                                        <option value="Tipo de Produto">Tipo de Produto</option>
                                        <option value="Quantidade Minima">Quantidade Mínima</option>
                                        <option value="Quantidade Estoque">Quantidade em Estoque</option>
                                        <option value="Valor de Compra">Valor de Compra</option>
                                        <option value="Valor de Venda">Valor de Venda</option>
                                    </select>
                                </div>
                                <div class="column">
                                    <div class="ui icon input labelholder">
                                        <input id="pesquisa_produto" placeholder="Pesquisar produto" type="text">
                                        <button class="ui icon button" onclick="defineMascaraPesquisaProduto()">
                                            <i class="search icon"></i>
                                        </button>
                                    </div>
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
                                <th><i class="write icon"></i></th>
                            </tr>
                            <tr>
                                <td>123</td>
                                <td>Nome Teste</td>
                                <td>Marca Teste</td>
                                <td>Cor Teste</td>
                                <td>R$ 50.00</td>
                                <td>R$ 60.00</td>
                                <td>Tenha um gás a mais na corrida com o Tênis Asics Gel Kayano 21 NYC. Inspirado na grande Maratona de Nova York, ele chega em sua vigésima primeira edição, com novo design e novas combinações de cores.</td>
                                <td>48</td>
                                <td>Sapato</td>
                                <td>20</td>
                                <td>10</td>
                                <td><a href="edita_produto.jsp"><i class="write icon"></i></a></td>
                            </tr>
                            <tr>
                                <td>456</td>
                                <td>Nome</td>
                                <td>Marca</td>
                                <td>Cor</td>
                                <td>R$ 50.00</td>
                                <td>R$ 60.00</td>
                                <td>Descrição</td>
                                <td>48</td>
                                <td>Sapato</td>
                                <td>20</td>
                                <td>10</td>
                                <td><a href="edita_produto.jsp"><i class="write icon"></i></a></td>
                            </tr>
                            <tr>
                                <td>123</td>
                                <td>Nome Teste</td>
                                <td>Marca Teste</td>
                                <td>Cor Teste</td>
                                <td>R$ 50.00</td>
                                <td>R$ 60.00</td>
                                <td>Descrição Teste</td>
                                <td>48</td>
                                <td>Sapato</td>
                                <td>15</td>
                                <td>10</td>
                                <td><a href="edita_produto.jsp"><i class="write icon"></i></a></td>
                            </tr>
                        </thead>
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