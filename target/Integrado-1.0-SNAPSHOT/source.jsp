<%-- 
    Document   : fontes
    Created on : 07/06/2015, 11:14:09
    Author     : Marcello
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Projeto Integrado</title>

        <!-- Bootstrap core CSS -->
        <!-- <link href="bootstrap.min.css" rel="stylesheet"> -->

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- Bootstrap theme -->
        <!-- <link href="bootstrap-theme.min.css" rel="stylesheet"> -->

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

        <!-- Custom styles for this template -->
        <link href="style.css" rel="stylesheet">

    </head>
    <body role="document">

        <%@include file="_header.jsp" %>

        <div class="container" role="main">
            <div class="jumbotron">
                <h3>ALGUMA COISA CRIATIVA PARA ESCREVER</h3>
                <p>Essa pesquisa é para saber a fonte de despesa com maior gasto juntamente com sua descrição, clique no botão a seguir!</p>
                <button id="consulta1" type="button" class="btn btn-primary">Search</button>


                <p>Nessa pesquisa, você receberá os resultados de uma lista contendo os valores gerados por cada tipo de licitação de um orgão juntamente com a descrição da fonte.</p>
                <button id="consulta2" type="button" class="btn btn-primary">Search</button>
                <script>
                    $('#consulta2').change(function () {
                        $.ajax({
                            type: "POST",
                            url: "ConsultaFonte",
                            dataType: "html",
                            result: {consulta2: $('#consulta2').val()},
                            success: function () {
                                $('#table').html(result);
                            }
                        });
                    });
                </script>
            </div>
        </div>
    </body>
</html>
