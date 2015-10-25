<%@ page pageEncoding="utf-8" %>

<html>
    <head>
        <title>AEV - Pim 4 Sem</title>
        
        <!-- Define que a codificação da página será em UTF-8 -->
        <meta charset="utf-8">
        
        
        <!-- Define que a página não poderá ficar menor que o tamanho da tela de um dispositivo móvel -->
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        
        <!-- Define os pacotes externos para funcionamento da página, como CSS e Fonts -->
        <link href="css/style.css" rel="stylesheet"/>
        <link href="css/Semantic-UI/semantic.css" rel="stylesheet"/>
        <link href="css/Foundation-5.5.3/css/foundation.css" rel="stylesheet"/>
        <link href="images/sapato_vetorial.ico" rel="icon"/>
        <link href='https://fonts.googleapis.com/css?family=Dancing+Script:700' rel='stylesheet' type='text/css'>
    </head>
    <body class="corpo">
        
        <!--<span class="row">
            <div class="ui red segment" id="TopoBox">
                <div id="TextoTopoBox">Loja de Calçados</div>
            </div>
        </span>-->
        
        <span class="row">            
            <div class="ui raised segment" id="LoginBox">
                <span class="ui ribbon label" style="background-color: #FDB225; border-color: #D2941F">
                    
                    <h5 class="ui header" style="color: #F7F7F9">
                        <i class="privacy icon"></i>
                        Login
                    </h5>
                </span>
                <form action="" class="ui form">
                    <br>
                    <div class="ui left icon input fluid" style="width: 100%">
                        <input name="login" type="text" placeholder="Username">
                        <i class="user icon"></i>
                    </div>
                    <br>
                    <br>
                    <div class="ui left icon input fluid" style="width: 100%">
                        <input name="senha" type="password" placeholder="Password">
                        <i class="lock icon"></i>
                    </div>
                    <br>
                    <br>
                    <br>
                    <div class="ui buttons" style="margin-left: 20%">
                        <button class="ui button">Cancel</button>
                        <div class="or"></div>
                        <button class="ui positive button">Login</button>
                    </div>
                </form>
            </div>
        </span>
        
    </body>
</html>