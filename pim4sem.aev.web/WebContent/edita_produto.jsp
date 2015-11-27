<!DOCTYPE HTML>
    
<html>
    <head>
        <title>AEV - Edita Produto</title>
        <meta charset="utf-8">
        <!-- Define os pacotes externos para funcionamento da página, como CSS e Fonts -->
        <link href="css/style.css" rel="stylesheet"/>
        <link href="css/Semantic-UI/semantic.css" rel="stylesheet"/>
        <link href="css/Foundation-5.5.3/css/foundation.css" rel="stylesheet"/>
        <link href="images/sapato_vetorial.ico" rel="icon"/>
        <script language="javascript" src="js/TableFilter/tablefilter.js" type="text/javascript"></script>
    </head>
    <body class="corpo_geral" onload="init()">
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
                    
                    <form class="ui form" action="" method="post">
                        <div class="fields">
                            <div class="two wide field">
                                <label>Código</label>
                                <input type="text" readonly maxlength="180">
                            </div>
                            <div class="six wide field">
                                <label>Nome</label>
                                <input type="text">
                            </div>
                            <div class="six wide field">
                                <label>Marca</label>
                                <input type="text">
                            </div>
                            <div class="three wide field">
                                <label>Cor</label>
                                <input type="text">
                            </div>
                        </div>
                        <div class="fields">
                            <div class="three wide field">
                                <label>Valor Compra</label>
                                <input type="text">
                            </div>
                            <div class="three wide field">
                                <label>Valor Venda</label>
                                <input type="text">
                            </div>
                            <div class="three  wide field">
                                <label>Tamanho</label>
                                <input type="text">
                            </div>
                            <div class="three wide field">
                                <label>Qtd. Estoque</label>
                                <input type="text">
                            </div>
                            <div class="three wide field">
                                <label>Qtd. Mínima</label>
                                <input type="text">
                            </div>
                            <div class="three wide field">
                                <label>Tipo de Produto</label>
                                <select class="ui fluid dropdown">
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>
                        <div class="field">
                            <label>Descrição</label>
                            <textarea maxlength="500" draggable="false" rows="4" style="resize: none"></textarea>
                        </div>
                        <button class="ui left floated negative button">Cancelar</button>
                        <button class="ui right floated positive button">Confirmar</button>
                        <br>
                        <br>
                    </form>
                    
                </div>
            </div>
            
        </span>
        
        <script lang="javascript" type="text/javascript">
             var tableFilter = {
                col_11: "none",
                on_change: false,
            };

            var tf = setFilterGrid("table_produto", tableFilter);        
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