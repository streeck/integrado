<%--
    Document   : _header
    Created on : Jun 5, 2015, 8:53:05 PM
    Author     : charles
--%>

<!-- Fixed navbar -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/Integrado/">Projeto Integrado</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li id="Home"><a href="/Integrado/">Inicio</a></li>
                <li id="About"><a href="about.jsp">Sobre</a></li>
                <li id="Contact"><a href="contact.jsp">Contato</a></li>
<!--                <li id="Contact"><a href="#contact">Contato</a></li>-->
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>