<%@page import="pim4sem.aev.business.produto.Produto"%>
<%@page import="pim4sem.aev.business.DAO.ProdutoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");	
	String[] nome = request.getParameterValues("nomeLista");
	String[] marca = request.getParameterValues("marcaLista");
	String[] cor = request.getParameterValues("corLista");
	String[] valorCompra = request.getParameterValues("valorCompraLista");
	String[] valorVenda = request.getParameterValues("valorVendaLista");
	String[] tamanho = request.getParameterValues("tamanhoLista");
	String[] estoque = request.getParameterValues("estoqueLista");
	String[] minima = request.getParameterValues("minimaLista");
	String[] tipoProduto = request.getParameterValues("tipoProdutoLista");
	String[] descricao = request.getParameterValues("descricaoLista");
		
	ProdutoDAO produto = new ProdutoDAO();
	Produto prod = new Produto();
	for(int i = 0; i < nome.length; i++){
		prod.setNome(nome[i]);
		prod.setMarca(marca[i]);
		prod.setCor(cor[i]);
		prod.setValorCompra(Double.parseDouble(valorCompra[i].replace("R$ ", "").replace(',', '.')));
		prod.setValorVenda(Double.parseDouble(valorVenda[i].replace("R$ ", "").replace(',', '.')));
		prod.setTamanho(Integer.parseInt(tamanho[i]));
		prod.setQuantidadeEstoque(Integer.parseInt(estoque[i]));
		prod.setQuantidadeMinima(Integer.parseInt(minima[i]));
		prod.setTipoProduto(tipoProduto[i]);
		prod.setDescricao(descricao[i]);
		produto.registrarProduto(prod);
	}
	String redireciona = "<meta http-equiv=\"refresh\" content=\"0; URL='produto.jsp'\" />";
%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%= redireciona %>
<title>Insert title here</title>
</head>
<body>
	
</body>
</html>