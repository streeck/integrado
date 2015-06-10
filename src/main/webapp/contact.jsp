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

    <title>Projeto Integrado - Contato</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Bootstrap theme -->
    <link href="bootstrap-theme.min.css" rel="stylesheet">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Custom styles for this template -->
    <link href="style.css" rel="stylesheet">
    <link href="css/bootstrap-social.css" rel="stylesheet">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">

  </head>
  <body role="document">

    <%@include file="_header.jsp" %>

    <div class="container text-center centered">
      <div class="col-sm-6 col-md-3 perfil">
        <div class="thumbnail">
          <img src="img/charles.jpg" class="img-circle">
          <div class="caption">
            <h3>Charles Moraes</h3>
            <p>Estudante de Ciência da Computação, apaixonado por programação, DIY e ciclismo.<br>Tenho uma namorada incrível!</p>
            <p><a href="https://github.com/streeck" class="btn btn-social-icon btn-github">
              <i class="fa fa-github"></i>
            </a>
            <a href="https://br.linkedin.com/pub/charles-moraes/60/983/a68" class="btn btn-linkedin">
              <i class="fa fa-linkedin"></i>
            </a>
            <a href="https://www.facebook.com/charles.david.129" class="btn btn-social-icon btn-facebook">
              <i class="fa fa-facebook"></i>
            </a>
            <a href="https://plus.google.com/u/0/102024472255403359832/" class="btn btn-social-icon btn-google">
              <i class="fa fa-google"></i>
            </a>
            <a href="https://bitbucket.org/streeck" class="btn btn-social-icon btn-bitbucket">
              <i class="fa fa-bitbucket"></i>
            </a></p>
          </div>
        </div>
      </div>

      <div class="col-sm-6 col-md-3 perfil">
        <div class="thumbnail">
          <img src="img/marcello.jpg" class="img-circle">
          <div class="caption">
            <h3>Marcello Acar</h3>
            <p>...</p>
            <p><a href="#" class="btn btn-social-icon btn-github">
              <i class="fa fa-github"></i>
            </a>
            <a href="#" class="btn btn-linkedin">
              <i class="fa fa-linkedin"></i>
            </a>
            <a href="#" class="btn btn-social-icon btn-facebook">
              <i class="fa fa-facebook"></i>
            </a>
            <a href="#" class="btn btn-social-icon btn-google">
              <i class="fa fa-google"></i>
            </a>
            <a href="#" class="btn btn-social-icon btn-bitbucket">
              <i class="fa fa-bitbucket"></i>
            </a></p>
          </div>
        </div>
      </div>
    </div>
    <!-- Scripts -->
    <script src="jquery-2.1.4.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <script src="scripts.js"></script>
  </body>
</html>
