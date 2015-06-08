/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
  $('#consulta-relativa').submit(function(e) {
    e.preventDefault();
    $.ajax({
      type: 'GET',
      url: 'ConsultaRelativa',
      // dataType: 'json',
      data: {entrada: $('#entrada').val(),
             value: $('#selectList2').val()}
    }).done(function(data) {
      var html = "";

      if(data.length !== 0) {
        // Construção tabela
        html += "<table class=\"table table-hover\"> <thead><tr><th>#</th><th>Descricao SubDominio</th><th>Despesas</th></tr></thead><tbody>";

        for (var i = 0, len = data.length; i < len; i++) {
          html += "<tr><td>" + (i + 1) + "</td><td>" + data[i].descricao + "</td><td>" + data[i].soma + "</td></tr>";
        }

        html += "</tbody></table>";
      } else {
        html = "<div class=\"alert alert-danger text-center\" role=\"alert\"><strong>Nenhum resultado encontrado!</strong> Tente outro termo de busca.</div>"
      }


      $('#results').html(html);
    }).fail(function(data) {
      alert("teste");
    });
  });
});
