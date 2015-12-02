function contarDescricao() {
    'use strict';
    var text = document.getElementById('descricao');
    var carac = text.value.length;
    var contador = document.getElementById('carac_descricao');
    var total = text.maxLength - carac;
    contador.style.fontWeight = "bold";
    contador.innerHTML = "[ " + total +"/" + text.maxLength + " caracteres ]";
}

function defineMascaraPesquisaProduto() {
    var coluna = document.getElementById('coluna');
    var valorColuna = coluna.value;
    var campo = document.getElementById('pesquisa_produto');
    var tamanhoCampo = null;
    
    if(valorColuna == ""){
        campo.value = "";
        $("#pesquisa_produto").unmask();
        $("#pesquisa_produto").maskMoney('destroy');
        tamanhoCampo = 1;
    }
    
    if(valorColuna == "Codigo"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask().mask("9?999999999");
        tamanhoCampo = 10;
    }
    
    if(valorColuna == "Nome"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask();
        tamanhoCampo = 50;
    }
    
    if(valorColuna == "Marca"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask();
        tamanhoCampo = 40;
    }

    if(valorColuna == "Cor"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask();
        tamanhoCampo = 25;
    }
    
    if(valorColuna == "Descricao"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask();
        tamanhoCampo = 80;
    }
    
    if(valorColuna == "Tamanho"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").mask("9?9");
        tamanhoCampo = 2;
    }
    
    if(valorColuna == "Tipo de Produto"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask();
        tamanhoCampo = 20;
    }
    
    if(valorColuna == "Quantidade Minima"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask().mask("9?999");
        tamanhoCampo = 4;
    }
    
    if(valorColuna == "Quantidade Estoque"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask().mask("9?999");
        tamanhoCampo = 4;
    }
    
    if(valorColuna == "Valor de Compra"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask();
        $("#pesquisa_produto").maskMoney({prefix:'R$ ', decimal:'.'});
        tamanhoCampo = 9;
    }
    
    if(valorColuna == "Valor de Venda"){
        campo.value = "";
        $("#pesquisa_produto").maskMoney('destroy');
        $("#pesquisa_produto").unmask();
        $("#pesquisa_produto").maskMoney({prefix:'RS ', decimal:'.'});
        tamanhoCampo = 9;
    }
    
    campo.maxLength = tamanhoCampo;
}

function validaFormulario(error) {
    var nome = document.getElementById('nome');
    var marca = document.getElementById('marca');
    var cor = document.getElementById('cor');
    var valorCompra = document.getElementById('valorCompra');
    var valorVenda = document.getElementById('valorVenda');
    var tamanho = document.getElementById('tamanho');
    var estoque = document.getElementById('estoque');
    var minima = document.getElementById('minima');
    var tipoProduto = document.getElementById('tipoProduto');
    
    var iconeNome = document.getElementById('iconeNome');
    var iconeMarca = document.getElementById('iconeMarca');
    var iconeCor = document.getElementById('iconeCor');
    var iconeValorCompra = document.getElementById('iconeValorCompra');
    var iconeValorVenda = document.getElementById('iconeValorVenda');
    var iconeTamanho = document.getElementById('iconeTamanho');
    var iconeEstoque = document.getElementById('iconeEstoque');
    var iconeMinima = document.getElementById('iconeMinima');
    var iconeTipoProduto = document.getElementById('iconeTipoProduto');
    var dropIcon = document.getElementById('dropIcon');
    
    var texto = "";
    var destacaCampo = "<li><span class='destacaCampo'>";
    var mensagemNaoPreenchido = "</span> - não foi preenchido!";
    var status = false;
    
    if(nome.value == "" || marca.value == "" || cor.value == "" || valorCompra.value == "" || 
       valorVenda.value == "" || tamanho.value == "" || estoque.value == "" || minima.value == "" || tipoProduto.value == ""){
        status = true;
    }
    
    if(status){
        texto = "<h4>Campos sem preenchimento:</h4><ul>";
    }
    
    if(nome.value == ""){
        texto = texto + destacaCampo + "Nome" + mensagemNaoPreenchido;
        iconeNome.style.visibility = "visible";
        nome.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeNome.style.visibility = "hidden";
        nome.style.boxShadow = "none";
    }
    
    if(marca.value == ""){
        texto = texto + destacaCampo + "Marca" + mensagemNaoPreenchido;
        iconeMarca.style.visibility = "visible";
        marca.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeMarca.style.visibility = "hidden";
        marca.style.boxShadow = "none";
    }
    
    if(cor.value == ""){
        texto = texto + destacaCampo + "Cor" + mensagemNaoPreenchido;
        iconeCor.style.visibility = "visible";
        cor.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeCor.style.visibility = "hidden";
        cor.style.boxShadow = "none";
    }
    
    if(valorCompra.value == ""){
        texto = texto + destacaCampo + "Valor de Compra" + mensagemNaoPreenchido;
        iconeValorCompra.style.visibility = "visible";
        valorCompra.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeValorCompra.style.visibility = "hidden";
        valorCompra.style.boxShadow = "none";
    }
    
    if(valorVenda.value == ""){
        texto = texto + destacaCampo + "Valor de Venda" + mensagemNaoPreenchido;
        iconeValorVenda.style.visibility = "visible";
        valorVenda.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeValorVenda.style.visibility = "hidden";
        valorVenda.style.boxShadow = "none";
    }
    
    if(tamanho.value == ""){
        texto = texto + destacaCampo + "Tamanho" + mensagemNaoPreenchido;
        iconeTamanho.style.visibility = "visible";
        tamanho.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeTamanho.style.visibility = "hidden";
        tamanho.style.boxShadow = "none";
    }
    
    if(estoque.value == ""){
        texto = texto + destacaCampo + "Quantidade em Estoque" + mensagemNaoPreenchido;
        iconeEstoque.style.visibility = "visible";
        estoque.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeEstoque.style.visibility = "hidden";
        estoque.style.boxShadow = "none";
    }
    
    if(minima.value == ""){
        texto = texto + destacaCampo + "Quantidade Mínima" + mensagemNaoPreenchido;
        iconeMinima.style.visibility = "visible";
        minima.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeMinima.style.visibility = "hidden";
        minima.style.boxShadow = "none";
    }
    
    if(tipoProduto.value == ""){
        texto = texto + destacaCampo + "Tipo de Produto" + mensagemNaoPreenchido;
        iconeTipoProduto.style.visibility = "visible";
        //dropIcon.style.visibility = "hidden";
        tipoProduto.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
    } else {
        iconeTipoProduto.style.visibility = "hidden";
        //dropIcon.style.visibility = "visible";
        tipoProduto.style.boxShadow = "none";
    }
    
    if(status){
        texto = texto + "</ul>";
        verificaAreaErro(error, texto);
    }
    
    if(!status){
        if(valorVenda.value.replace("R$ ", "") < valorCompra.value.replace("R$ ", "")){
            status = true;
            texto = "<h4>Informações incoerentes:</h4><ul>";
            texto = texto + "<li><span class='destacaCampo'>Valor de Venda</span> é menor do que ";
            texto = texto + "<span class='destacaCampo'>Valor de Compra</span></li>";
            texto = texto + "<ul><li>Valor de Compra: " + valorCompra.value + "</li>";
            texto = texto + "<li>Valor de Venda: " + valorVenda.value + "</li></ul></ul>";
            iconeValorVenda.style.visibility = "visible";
            iconeValorCompra.style.visibility = "visible";
            valorVenda.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
            valorCompra.style.boxShadow = "0px 0px 5px rgba(255, 0, 0, 1.0)";
            verificaAreaErro(error, texto);
        } else {
            iconeValorVenda.style.visibility = "hidden";
            iconeValorCompra.style.visibility = "hidden";
            valorVenda.style.boxShadow = "none";
            valorCompra.style.boxShadow = "none";
            verificaAreaErro(error, texto);
            status = false;
        }
    }
    
    if(status){
        return false;
    } else {
        return true;
    }
}

function verificaAreaErro(error, texto) {
    if(error == true){
        exibeErro(texto);
    } else {
        if(document.getElementById('errorMensagem').innerHTML.length > 0){
            exibeErro(texto);
        }
    }
}

function exibeErro(texto) {
    var form = document.getElementById('errorForm');
    var msg = document.getElementById('errorMensagem');
    
    if(texto.length == 0){
        form.style.width = "0%";
        form.style.backgroundColor = "none";
        form.style.border = "none";
        msg.style.width = "0%";
    } else {
        form.style.width = "100%";
        form.style.backgroundColor = "#FFB7B7";
        form.style.border = "solid 1px #FF0000";
        form.style.borderRadius = "10px";
        msg.style.width = "95%";
        msg.style.marginTop = "10px";
        msg.style.marginBottom = "10px";
        msg.style.marginLeft = "2.5%";
    }
    
    msg.innerHTML = texto;
}

function insereProdutoLista() {
    var nome = document.getElementById('nome');
    var marca = document.getElementById('marca');
    var cor = document.getElementById('cor');
    var valorCompra = document.getElementById('valorCompra');
    var valorVenda = document.getElementById('valorVenda');
    var tamanho = document.getElementById('tamanho');
    var estoque = document.getElementById('estoque');
    var minima = document.getElementById('minima');
    var tipoProduto = document.getElementById('tipoProduto');
    var descricao = document.getElementById('descricao');
    
    var texto = "";    
    var campo = document.getElementById('listaCadastro');
    var form = document.getElementById('cadastroProduto');
    var numeroLinha = 2;
    
    var status = validaFormulario(true);
    
    if(status == true){
        if(document.getElementById('listaProduto') != null){
            numeroLinha = parseInt(document.getElementById('listaProduto').rows.length + 1);
        }
        
        if(campo.innerHTML.length == 0){
            texto = texto + "<table id='listaProduto' class='ui selectable striped celled table'>";
            texto = texto + "<thead><tr>";
            texto = texto + "<th>Nome</th>";
            texto = texto + "<th>Marca</th>";
            texto = texto + "<th>Cor</th>";
            texto = texto + "<th>Valor de Compra</th>";
            texto = texto + "<th>Valor de Venda</th>";
            texto = texto + "<th>Tamanho</th>";
            texto = texto + "<th>Qtd. Estoque</th>";
            texto = texto + "<th>Qtd. Mínima</th>";
            texto = texto + "<th>Tipo de Produto</th>";
            texto = texto + "<th>Descrição</th>";
            texto = texto + "<th>Remover</th>";
            texto = texto + "</tr></thead>";
            texto = texto + "<tr><td colspan='11'><button class='ui submit right floated positive button' type='submit' ";
            texto = texto + "onclick='return cadastraProduto()'>Cadastra Produtos</button>";
            texto = texto + "<button class='ui left floated negative button' type='reset' onclick='cancelaCadastro()'>";
            texto = texto + "Cancela Cadastro</button>";
            texto = texto + "</td></tr></table>";
            campo.innerHTML = texto;
        }
        
        var tabela = document.getElementById('listaProduto');
        var row = tabela.insertRow(parseInt(tabela.rows.length)-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        var cell5 = row.insertCell(4);
        var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);
        var cell8 = row.insertCell(7);
        var cell9 = row.insertCell(8);
        var cell10 = row.insertCell(9);
        var cell11 = row.insertCell(10);
        
        cell1.innerHTML = nome.value;
        cell2.innerHTML = marca.value;
        cell3.innerHTML = cor.value;
        cell4.innerHTML = valorCompra.value;
        cell5.innerHTML = valorVenda.value;
        cell6.innerHTML = tamanho.value;
        cell7.innerHTML = estoque.value;
        cell8.innerHTML = minima.value;
        cell9.innerHTML = tipoProduto.value;
        cell10.innerHTML = descricao.value;
        cell11.innerHTML = "<i id='removeItem' class='remove icon' onclick='return removeProdutoLista(this)'></i>";
        form.reset();
        contarDescricao();
    }
    
    return false;
}

function removeProdutoLista(linha) {
    var tabela = document.getElementById('listaProduto');
    tabela.deleteRow(linha.parentNode.parentNode.rowIndex);
    if(tabela.rows.length == 2){
        document.getElementById('listaCadastro').innerHTML = "";
    }
    return false;
}

function cancelaCadastro() {
    document.getElementById('listaCadastro').innerHTML = "";
}

function cadastraProduto() {
    var tabela = document.getElementById('listaProduto');
    
    var nomeLista = new Array();
    var marcaLista = new Array();
    var corLista = new Array();
    var valorCompraLista = new Array();
    var valorVendaLista = new Array();
    var tamanhoLista = new Array();
    var estoqueLista = new Array();
    var minimaLista = new Array();
    var tipoProdutoLista = new Array();
    var descricaoLista = new Array();
    
    var texto = "";
    
    for (var r = 0; r < tabela.rows.length; r++) {
        if(r != 0 && r != parseInt(tabela.rows.length - 1)){
            for (var c = 0; c < tabela.rows[r].cells.length; c++) {
                nomeLista[r] = tabela.rows[r].cells[0].innerHTML;
                marcaLista[r] = tabela.rows[r].cells[1].innerHTML;
                corLista[r] = tabela.rows[r].cells[2].innerHTML;
                valorCompraLista = tabela.rows[r].cells[3].innerHTML;
                valorVendaLista = tabela.rows[r].cells[4].innerHTML;
                tamanhoLista = tabela.rows[r].cells[5].innerHTML;
                estoqueLista = tabela.rows[r].cells[6].innerHTML;
                minimaLista = tabela.rows[r].cells[7].innerHTML;
                tipoProdutoLista = tabela.rows[r].cells[8].innerHTML;
                descricaoLista = tabela.rows[r].cells[9].innerHTML;
            }
        }
    }
    
    return false;
}