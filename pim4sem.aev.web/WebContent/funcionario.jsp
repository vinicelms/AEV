<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String userName = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("lojaCalcados")){
				userName = cookie.getValue();
			}
		}
	}
	if(userName == null){
		response.sendRedirect("index.jsp");
	}
%>

<html>
    <head>
        <title>AEV - Funcionario</title>
        <meta charset="utf-8">
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
            
            $(function() {
                $('#salario').maskMoney();
            });
            
            jQuery(function($){
                $("#matricula").mask("9?999999999");
                $("#dataNascimento").mask("99/99/9999");
                $("#dataContratacao").mask("99/99/9999");
            });
        </script>
    </head>
    <body class="corpo_geral">
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
                        <a href="home.jsp">Home</a>
                        <a href="produto.jsp">Produtos</a>
                        <a href="funcionario.jsp">Funcionários</a>
                    </span>
                </div>
            </div>
            
            <div class="full_body">
                <div class="full_body_text">
                    <h1>FuncionÃ¡rio</h1>
                    <br>
                    
                    <form class="ui form" name="formFuncionario">
                        <div class="fields">
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="matricula" name="matricula" type="text" required 
                                           onkeyup="return validaFuncionario(false)" placeholder="MatrÃ­cula">
                                    <i id="iconeMatricula" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="five wide field">
                                <div class="ui icon input labelholder">
                                    <input id="nomeFunc" type="text" required onkeyup="return validaFuncionario(false)" 
                                           placeholder="Nome do FuncionÃ¡rio">
                                    <i id="iconeNomeFunc" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="four wide field">
                                <div class="ui icon input">
                                    <select id="cargo" name="cargo" class="ui fluid dropdown" 
                                            onchange="return validaFuncionario(false)">
                                        <option value="">Cargo</option>
                                        <option value="cargo1">Cargo 1</option>
                                    </select>
                                    <i class="dropdown icon"></i>
                                    <i id="iconeCargo" style="margin-right: 15px" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="four wide field">
                                <div class="ui icon input">
                                    <select id="setor" name="setor" class="ui fluid dropdown" 
                                            onchange="return validaFuncionario(false)">
                                        <option value="">Setor</option>
                                        <option value="setor1">Setor 1</option>
                                    </select>
                                    <i class="dropdown icon"></i>
                                    <i id="iconeSetor" style="margin-right: 15px" class="warning circle icon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="fields">
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="salario" type="text" required onkeyup="return validaFuncionario(false)"
                                           placeholder="SalÃ¡rio" data-decimal=',' data-prefix='R$ ' maxlength="11">
                                    <i id="iconeSalario" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="dataNascimento" type="text" required onkeyup="return validaFuncionario(false)"
                                           placeholder="Data de Nascimento">
                                    <i id="iconeNascimento" class="warning circle icon"></i>
                                </div>
                            </div>
                            <div class="three wide field">
                                <div class="ui icon input labelholder">
                                    <input id="dataContratacao" type="text" required onkeyup="return validaFuncionario(false)"
                                           placeholder="Data de ContrataÃ§Ã£o">
                                    <i id="iconeContratacao" class="warning circle icon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="fields">
                            <div id="checks" class="ui horizontal segments" style="border-top: 3px solid #017EC1">
                                <div class="ui segment">
                                    <div class="grouped fields">
                                        <label>Sexo</label>
                                        <div class="field">
                                            <div class="ui slider checkbox">
                                                <input value="masculino" name="sexo" type="radio" 
                                                       onchange="return validaFuncionario(false)">
                                                <label>Masculino</label>
                                            </div>
                                            <div class="field">
                                                <div class="ui slider checkbox">
                                                    <input value="feminino" name="sexo" type="radio" 
                                                           onchange="return validaFuncionario(false)">
                                                    <label>Feminino</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="ui segment">
                                    <div class="grouped fields">
                                        <label>Gerente</label>
                                        <div class="field">
                                            <div class="ui slider checkbox">
                                                <input value="sim" name="gerente" type="radio"
                                                       onchange="return validaFuncionario(false)">
                                                <label>Sim</label>
                                            </div>
                                        </div>
                                        <div class="field">
                                            <div class="ui slider checkbox">
                                                <input value="nao" name="gerente" type="radio"
                                                       onchange="return validaFuncionario(false)">
                                                <label>NÃ£o</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div id="errorForm">
                            <div id="errorMensagem"></div>
                        </div>
                        <br>
                        
                        <button class="ui left floated negative button" type="reset">Limpa FormulÃ¡rio</button>
                        <button class="ui submit right floated positive button" type="submit" 
                                onclick="return validaFuncionario(true)">Cadastra FuncionÃ¡rio</button>
                        <br>
                        <br>
                    </form>
                    
                    <table id="table_funcionario" class="ui selectable celled table">
                            <thead>
                                <tr>
                                    <th>Matricula</th>
                                    <th>Nome</th>
                                    <th>Cargo</th>
                                    <th>Setor</th>
                                    <th>SalÃ¡rio</th>
                                    <th>Nascimento</th>
                                    <th>ContrataÃ§Ã£o</th>
                                    <th>Sexo</th>
                                    <th>Cargo Gerencial</th>
                                    <th><i class="write icon"></i></th>
                                </tr>
                            </thead>
                                <tr>
                                    <td>123456</td>
                                    <td>Vinicius Celms</td>
                                    <td>Gerente</td>
                                    <td>Vendas</td>
                                    <td>R$ 1.000,00</td>
                                    <td>02/08/1988</td>
                                    <td>02/12/2015</td>
                                    <td>Masculino</td>
                                    <td>Sim</td>
                                    <td><i class="write icon"></i></td>
                                </tr>
                        </table>
                        <br>
                                        
                </div>
            </div>
            
        </span>
        
        <script language="javascript" type="text/javascript">
            var tableFilter = {
                col_9: "none",
                on_change: false,
            };

            var tf = setFilterGrid("table_funcionario", tableFilter);
        </script>
        
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