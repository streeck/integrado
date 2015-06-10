<!DOCTYPE html>
<html>
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

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@include file="_header.jsp" %>

    <div class="container" role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->

      <div class="well well-lg">
        <div class="row">
          <div class="col-md-8">
            <h4>Digite o sub setor que deseja saber as despesas no m&ecircs selecionado.</h4>
            <form id="consulta-relativa" method="GET">
              <div class="row">
                <div class="col-md-3" id="selectList">
                  <select class="form-control input-lg" id="selectList2">
                    <option value="1">Janeiro</option>
                    <option value="2">Fevereiro</option>
                    <option value="3">Mar&ccedilo</option>
                    <option value="4">Abril</option>
                    <option value="5">Maio</option>
                    <option value="6">Junho</option>
                    <option value="7">Julho</option>
                    <option value="8">Agosto</option>
                    <option value="9">Setembro</option>
                    <option value="10">Outubro</option>
                    <option value="11">Novembro</option>
                    <option value="12">Dezembro</option>
                  </select>
                </div>
                <div class="col-md-9">
                  <div id="custom-search-input">
                    <div class="input-group">
                      <input type="text" class="form-control input-lg" placeholder="Ex: Ensino" id="entrada"/>
                      <span class="input-group-btn">
                        <button class="btn btn-info btn-lg" type="submit">
                          <i class="glyphicon glyphicon-search"></i>
                        </button>
                      </span>
                    </div>
                  </div>
                </div>
              </div>
            </form>
            <p>Pressione <kbd>Enter</kbd> para buscar.</p>
          </div>
          <div class="col-sm-4">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title">Buscas Sugeridas</h3>
              </div>
              <ul class="list-group">
                <li class="list-group-item"><button class="btn btn-link" id="consulta-subdominio">Sub setor de maior despesa</button></li>
                <li class="list-group-item"><button class="consulta-fonte btn btn-link" data-pag="0">Fontes de despesa com licita&ccedil&atildeo</button></li>
              </ul>
            </div>
          </div><!-- /.col-sm-4 -->
        </div>

      </div>

      <div id="results">
      <!-- Onde será apresentado os resultados das consultas. -->
      </div>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery-2.1.4.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script src="scripts.js"></script>
    <link href="style.css" rel="stylesheet">
    <!--<script src="http://getbootstrap.com/assets/js/docs.min.js"></script>-->

    <script>

    </script>
  </body>
</html>
