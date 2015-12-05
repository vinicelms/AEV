<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
               $('.labelholder').labelholder();
            });
        </script>
    </head>
    <body class="corpo_index">
        
        <span class="row">            
            <div class="ui raised segment" id="LoginBox">
                <span class="ui ribbon label" style="background-color: #FDB225; border-color: #D2941F">
                    
                    <h4 class="ui header" style="color: #F7F7F9; font-family:'Oswald-Light', cursive">
                        <i class="privacy icon"></i>
                        Login
                    </h4>
                </span>
                <form action="" class="ui form" style="margin-top: 5px">
                    <div class="ui left icon input fluid labelholder" style="width: 100%; margin-bottom: 5px">
                        <input name="login" type="text" placeholder="Username" 
                               style="height: 55px; padding-top: 20px">
                        <i class="user icon" style="margin-top: 8px"></i>
                    </div>
                    <br>
                    <br>
                    <div class="ui left icon input fluid labelholder" style="width: 100%; margin-bottom: 10px">
                        <input name="senha" type="password" placeholder="Password" 
                               style="height: 55px; padding-top: 20px">
                        <i class="lock icon" style="margin-top: 8px"></i>
                    </div>
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