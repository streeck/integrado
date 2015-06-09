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
                <h2>Dados Abertos Governamentais</h2>
                 <p> </p>
                <p>Desenvolver um sistema que realiza a apresentação e busca de dados abertos governamentais 
                    municipais. Nesse caso, temos como foco as fontes de despesas de um município.</p>
                <p> </p>
                <p>Esse site foi desenvolvido em conjunto com 3 disciplinas (WEB, LabBD e ES2). Temos como foco, duas
                consultas sugeridas que mostram: a maior fonte de despesa especificada por um subdominio; e outra que mostra
                uma paginação com vários dados, mostrando os valores gastos por cada licitação dos orgãos, ordenados do maior
                para o menor</p>
                <p> </p>
                <p>Assim como, uma consulta relativa onde o usuário escolhe o mês que queira verificar os dados referentes
                    a um subdominio.</p>
                <p> </p>
                <p>Todos os resultados que geram paginação são exibidos em tabelas para melhor visualização.</p>
            </div>
        </div>
    </body>
</html>
