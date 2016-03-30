<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="pim4sem.aev.business.seguranca.Senha"%>
<%@page import="pim4sem.aev.business.DAO.UsuarioDAO"%>
<%@page import="java.util.Calendar"%>
<%@page import="pim4sem.aev.business.produto.Produto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pim4sem.aev.business.DAO.ProdutoDAO"%>
<%@page import="pim4sem.aev.business.DAO.VendaDAO"%>
<%@page import="pim4sem.aev.business.DAO.NotaFiscalDAO"%>
<%@page import="pim4sem.aev.business.controlefinanceiro.NotaFiscal" %>
<%@page import="pim4sem.aev.business.controlefinanceiro.Venda" %>
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
		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter("login");
		String pass = request.getParameter("senha");
		
		UsuarioDAO usudao = new UsuarioDAO();
		Senha senha = new Senha();
		
		boolean status = false;
		
		if(login == null || senha == null){
			status = false;
		} else {
			status = usudao.loginUsuario(login, senha.criptografaSenha(pass));
		}
		
		if(status){
			Cookie loginCookie = new Cookie("lojaCalcados", login);
			loginCookie.setMaxAge(5*60);
			response.addCookie(loginCookie);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	NotaFiscalDAO nfdao = new NotaFiscalDAO();
	VendaDAO vndao = new VendaDAO();
	ProdutoDAO prdao = new ProdutoDAO();
	List<NotaFiscal> listaNf = new ArrayList<>();
	List<Venda> listaVenda = new ArrayList<>();
	List<Produto> listaProduto = new ArrayList<>();
	listaNf = nfdao.retornaNotaFiscal(null, null);
	listaVenda = vndao.retornaVenda();
	
	Calendar cal = Calendar.getInstance();
	
	int dia = 0;
	int segunda = 0;
	int terca = 0;
	int quarta = 0;
	int quinta = 0;
	int sexta = 0;
	int sabado = 0;
	int domingo = 0;
	
	int segundaTenis = 0;
	int segundaChuteira = 0;
	int segundaSapato = 0;
	int segundaBota = 0;
	int tercaTenis = 0;
	int tercaChuteira = 0;
	int tercaSapato = 0;
	int tercaBota = 0;
	int quartaTenis = 0;
	int quartaChuteira = 0;
	int quartaSapato = 0;
	int quartaBota = 0;
	int quintaTenis = 0;
	int quintaChuteira = 0;
	int quintaSapato = 0;
	int quintaBota = 0;
	int sextaTenis = 0;
	int sextaChuteira = 0;
	int sextaSapato = 0;
	int sextaBota = 0;
	int sabadoTenis = 0;
	int sabadoChuteira = 0;
	int sabadoSapato = 0;
	int sabadoBota = 0;
	int domingoTenis = 0;
	int domingoChuteira = 0;
	int domingoSapato = 0;
	int domingoBota = 0;
	
	String tipoProduto = null;
	int tenis = 0;
	int chuteira = 0;
	int sapato = 0;
	int bota = 0;
	
	for(int i = 0; i < listaVenda.size(); i++){
		listaProduto = prdao.retornaProduto("Codigo", 
				String.valueOf(listaVenda.get(i).getProduto().getCodigo()));
		listaVenda.get(i).setProduto(listaProduto.get(0));
	}
	
	for(int i = 0; i < listaNf.size(); i++){
		cal.setTime(listaNf.get(i).getDataPagamento());
		dia = cal.get(Calendar.DAY_OF_WEEK);
		for(int j = 0; j < listaVenda.size(); j++){
			tipoProduto = listaVenda.get(i).getProduto().getTipoProduto();
			if(dia == 1){
				switch (tipoProduto){
					case "Tênis":
						domingoTenis++;
						break;
					case "Chuteira":
						domingoChuteira++;
						break;
					case "Sapato":
						domingoSapato++;
						break;
					case "Bota":
						domingoBota++;
						break;
					default:
						break;
				}
			} else if(dia == 2){
				switch (tipoProduto){
					case "Tênis":
						segundaTenis++;
						break;
					case "Chuteira":
						segundaChuteira++;
						break;
					case "Sapato":
						segundaSapato++;
						break;
					case "Bota":
						segundaBota++;
						break;
					default:
						break;
				}
			} else if(dia == 3){
				switch (tipoProduto){
					case "Tênis":
						tercaTenis++;
						break;
					case "Chuteira":
						tercaChuteira++;
						break;
					case "Sapato":
						tercaSapato++;
						break;
					case "Bota":
						tercaBota++;
						break;
					default:
						break;
				}
			} else if(dia == 4){
				switch (tipoProduto) {
					case "Tênis":
						quartaTenis++;
						break;
					case "Chuteira":
						quartaChuteira++;
						break;
					case "Sapato":
						quartaSapato++;
						break;
					case "Bota":
						quartaBota++;
						break;
					default:
						break;
				}
			} else if(dia == 5){
				switch (tipoProduto){
					case "Tênis":
						quintaTenis++;
						break;
					case "Chuteira":
						quintaChuteira++;
						break;
					case "Sapato":
						quintaSapato++;
						break;
					case "Bota":
						quintaBota++;
						break;
					default:
						break;
				}
			} else if(dia == 6){
				switch (tipoProduto){
					case "Tênis":
						sextaTenis++;
						break;
					case "Chuteira":
						sextaChuteira++;
						break;
					case "Sapato":
						sextaSapato++;
						break;
					case "Bota":
						sextaBota++;
						break;
					default:
						break;
				}
			} else if(dia == 7){
				switch (tipoProduto){
					case "Tênis":
						sabadoTenis++;
						break;
					case "Chuteira":
						sabadoChuteira++;
						break;
					case "Sapato":
						sabadoSapato++;
						break;
					case "Bota":
						sabadoBota++;
						break;
					default:
						break;
				}
			}
		}
	}
	
	segunda = segundaTenis + segundaChuteira + segundaSapato + segundaBota;
	terca = tercaTenis + tercaChuteira + tercaSapato + tercaBota;
	quarta = quartaTenis + quartaChuteira + quartaSapato + quartaBota;
	quinta = quintaTenis + quintaChuteira + quintaSapato + quintaBota;
	sexta = sextaTenis + sextaChuteira + sextaSapato + sextaBota;
	sabado = sabadoTenis + sabadoChuteira + sabadoSapato + sabadoBota;
	domingo = domingoTenis + domingoChuteira + domingoSapato + domingoBota;
	
	tenis = segundaTenis + tercaTenis + quartaTenis + quintaTenis + sextaTenis + sabadoTenis + domingoTenis;
	chuteira = segundaChuteira + tercaChuteira + quartaChuteira + quintaChuteira + sextaChuteira + sabadoChuteira + domingoChuteira;
	sapato = segundaSapato + tercaSapato + quartaSapato + quintaSapato + sextaSapato + sabadoSapato + domingoSapato;
	bota = segundaBota + tercaBota + quartaBota + quintaBota + sextaBota + sabadoBota + domingoBota;
%>

<html>
    <head>
        <title>AEV - Pim 4 Sem</title>
        <meta charset="utf-8">
        <!-- Define os pacotes externos para funcionamento da pÃ¡gina, como CSS e Fonts -->
        <link href="css/style.css" rel="stylesheet"/>
        <link href="css/Semantic-UI/semantic.css" rel="stylesheet"/>
        <link href="css/Foundation-5.5.3/css/foundation.css" rel="stylesheet"/>
        <link href="images/sapato_vetorial.ico" rel="icon"/>
        <script language="javascript" src="js/Chart.js" type="text/javascript"></script>
        
        <script>
            $(document).ready( function() {
                $(".labelholder").labelholder();
                reposicionaRodape();
            });
            
            function pegaTamanho() {
            	return 500;
            }
            
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
                    <h1>Gráficos de Desempenho</h1>
                    <div class="ui grid">
                        <div class="eight wide column" id="areaGrafico">
                            <h3 class="ui header">
                                <i class="circular inverted bar chart icon"></i>
                                Vendas por Dia da Semana
                            </h3>
                            <canvas id="vendaDiaSemana" width="500" height="400"></canvas>
                            <div class="ui horizontal list"
                                 style="margin-left: 20px; border: 1px solid rgba(0, 0, 0, 0.2); padding: 5px">
                                <div class="item">
                                    <div class="content">
                                        <div class="header">Segunda</div>
                                        <%= segunda %>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="content">
                                        <div class="header">Terça</div>
                                        <%= terca %>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="content">
                                        <div class="header">Quarta</div>
                                        <%= quarta %>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="content">
                                        <div class="header">Quinta</div>
                                        <%= quinta %>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="content">
                                        <div class="header">Sexta</div>
                                        <%= sexta %>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="content">
                                        <div class="header">Sábado</div>
                                        <%= sabado %>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="content">
                                        <div class="header">Domingo</div>
                                        <%= domingo %>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="eight wide column floated right" id="areaGrafico">
                            <h3 class="ui header">
                                <i class="circular inverted pie chart icon"></i>
                                Vendas por Tipo de Produto
                            </h3>
                            <canvas id="vendaTipoProduto" width="500" height="400"></canvas>
                            <ul class="ui list" style="position: absolute; margin-top: -250px; margin-left: 220px">
                                <li>Tênis - <%= tenis %></li>
                                <li>Chuteira - <%= chuteira %></li>
                                <li>Sapato - <%= sapato %></li>
                                <li>Bota - <%= bota %></li>
                            </ul>
                        </div>
                    </div>
                    <div class="ui grid">
                    	<div class="sixteen wide column" id="areaGrafico">
                    		<h3 class="ui header">
                    			<i class="ui circular inverted bar chart icon"></i>
                    			Vendas por Tipo de Produto vs Dia da Semana
                    		</h3>
                    		<canvas id="vendaTipoProdutoDiaSemana" width="1000" height="400"></canvas>
                    	</div>
                    </div>
                </div>
            </div>
            
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
            
            <script language="javascript" type="text/javascript">
                var vendaDiaSemana = document.getElementById('vendaDiaSemana').getContext('2d');
                var dataVendaDiaSemana = {
                    labels: ["Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"],
                    datasets: [
                        {
                            fillColor: "rgba(253, 178, 37, 1)",
                            strokeColor: "rgba(0, 0, 0, 1)",
                            highlightFill: "rgba(253, 192, 77, 1)",
                            highlightStroke: "rgba(0, 0, 0, 1)",
                            data: [
                            	<%= segunda %>,
                            	<%= terca %>,
                            	<%= quarta %>,
                            	<%= quinta %>,
                            	<%= sexta %>,
                            	<%= sabado %>,
                            	<%= domingo %>
                            ]
                        }
                    ]
                };
                
                var optionsVendaDiaSemana = {
                    scaleGridLineColor: "rgba(0, 0, 0, 0.1)",
                    scaleGridLineWidth: 1,
                    barStrokeWidth: 1,
                    scaleShowVerticalLines: false,
                };
                new Chart(vendaDiaSemana).Bar(dataVendaDiaSemana, optionsVendaDiaSemana);
                
                var vendaTipoProduto = document.getElementById('vendaTipoProduto').getContext('2d');
                var dataVendaTipoProduto = [
                    {
                        value: <%= tenis %>,
                        color: "#EF3D31",
                        highlight: "#EF7267",
                        label: "Tênis"
                    },
                    {
                        value: <%= chuteira %>,
                        color: "#FDB225",
                        highlight: "#FDD281",
                        label: "Chuteira"
                    },
                    {
                        value: <%= sapato %>,
                        color: "#41C6F3",
                        highlight: "#6FD6F3",
                        label: "Sapato"
                    },
                    {
                        value: <%= bota %>,
                        color: "#017EC1",
                        highlight: "#2D91C1",
                        label: "Bota"
                    }
                ];
                new Chart(vendaTipoProduto).Doughnut(dataVendaTipoProduto);
                
                var vendaTipoProdutoDiaSemana = document.getElementById('vendaTipoProdutoDiaSemana').getContext('2d');
                var dataVendaTipoProdutoDiaSemana = {
					labels: ["Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo"],
					datasets: [
						{
							label: "Tênis",
							fillColor: "rgba(239, 61, 49, 1)",
							strokeColor: "rgba(0, 0, 0, 1)",
							highlightFill: "rgba(239, 114, 103, 1)",
	                        highlightStroke: "rgba(0, 0, 0, 1)",
	                        data: [
								<%= segundaTenis %>,
								<%= tercaTenis %>,
								<%= quartaTenis %>,
								<%= quintaTenis %>,
								<%= sextaTenis %>,
								<%= sabadoTenis %>,
								<%= domingoTenis %>
							]
						},
						{
							label: "Chuteira",
							fillColor: "rgba(253, 178, 37, 1)",
							strokeColor: "rgba(0, 0, 0, 1)",
							highlightFill: "rgba(253, 210, 129, 1)",
	                        highlightStroke: "rgba(0, 0, 0, 1)",
	                        data: [
								<%= segundaChuteira %>,
								<%= tercaChuteira %>,
								<%= quartaChuteira %>,
								<%= quintaChuteira %>,
								<%= sextaChuteira %>,
								<%= sabadoChuteira %>,
								<%= domingoChuteira %>
							]
						},
						{
							label: "Sapato",
							fillColor: "rgba(65, 198, 243, 1)",
							strokeColor: "rgba(0, 0, 0, 1)",
							highlightFill: "rgba(111, 214, 243, 1)",
	                        highlightStroke: "rgba(0, 0, 0, 1)",
	                        data: [
								<%= segundaSapato %>,
								<%= tercaSapato %>,
								<%= quartaSapato %>,
								<%= quintaSapato %>,
								<%= sextaSapato %>,
								<%= sabadoSapato %>,
								<%= domingoSapato %>
							]
						},
						{
							label: "Bota",
							fillColor: "rgba(1, 126, 193, 1)",
							strokeColor: "rgba(0, 0, 0, 1)",
							highlightFill: "rgba(45, 145, 193, 1)",
	                        highlightStroke: "rgba(0, 0, 0, 1)",
	                        data: [
								<%= segundaBota %>,
								<%= tercaBota %>,
								<%= quartaBota %>,
								<%= quintaBota %>,
								<%= sextaBota %>,
								<%= sabadoBota %>,
								<%= domingoBota %>
							]
						}
					]
				};
                new Chart(vendaTipoProdutoDiaSemana).Bar(dataVendaTipoProdutoDiaSemana, optionsVendaDiaSemana);
            </script>
        </span>
    </body>
</html>