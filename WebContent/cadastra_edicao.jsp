<%@page import="pim4sem.aev.business.DAO.ProdutoDAO"%>
<%@page import="pim4sem.aev.business.produto.Produto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String codigo = request.getParameter("codigo");
	String nome = request.getParameter("nome");
	String marca = request.getParameter("marca");
	String cor = request.getParameter("cor");
	String valorCompra = request.getParameter("valorCompra").replace("R$ ", "");
	String valorVenda = request.getParameter("valorVenda").replace("R$ ", "");
	String tamanho = request.getParameter("tamanho");
	String estoque = request.getParameter("estoque");
	String minima = request.getParameter("minima");
	String tipoProduto = request.getParameter("tipoProduto");
	String descricao = request.getParameter("descricao");
	
	if(descricao == null){
		descricao = "";	
	}
	
	ProdutoDAO produto = new ProdutoDAO();
	Produto prod = new Produto();
	prod.setCodigo(Integer.parseInt(codigo));
	prod.setNome(nome);
	prod.setMarca(marca);
	prod.setCor(cor);
	prod.setValorCompra(Double.parseDouble(valorCompra));
	prod.setValorVenda(Double.parseDouble(valorVenda));
	prod.setTamanho(Integer.parseInt(tamanho));
	prod.setQuantidadeEstoque(Integer.parseInt(estoque));
	prod.setQuantidadeMinima(Integer.parseInt(minima));
	prod.setTipoProduto(tipoProduto);
	prod.setDescricao(descricao);
	produto.alteraProduto(prod);
	String redireciona = "<meta http-equiv=\"refresh\" content=\"1; URL='produto.jsp'\" />";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%= redireciona %>
<title>Cadastra Edição</title>
</head>
<body>

</body>
</html>