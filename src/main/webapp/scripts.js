function createTableSub(data) {
  var html = "";

  if(data.length !== 0) {
    // Construção tabela
    html += "<table class=\"table table-hover\"> <thead><tr><th>#</th><th>Descrição SubDominio</th><th>Despesas</th></tr></thead><tbody>";

    for (var i = 0, len = data.length; i < len; i++) {
      html += "<tr><td>" + (i + 1) + "</td><td>" + data[i].descricao + "</td><td>" + data[i].soma + "</td></tr>";
    }

    html += "</tbody></table>";
  } else {
    html = "<div class=\"alert alert-danger text-center\" role=\"alert\"><strong>Nenhum resultado encontrado!</strong> Tente outro termo de busca.</div>"
  }
  $('#results').html(html);
}

function createTableFonte(data, pagAtual) {
  var html = "";

  if(data.length !== 0) {
    // Construção tabela
    html += "<table class=\"table table-hover\"> <thead><tr><th>#</th><th>Descrição Fonte</th><th>Tipo de Licitação</th><th>Despesas</th></tr></thead><tbody>";

    for (var i = 0, len = data.length; i < len; i++) {
      html += "<tr><td>" + (pagAtual * 10 + i + 1) + "</td><td>" + data[i].descricao + "</td><td>" + data[i].licitacao + "<td>" + data[i].soma + "</td></tr>";
    }

    html += "</tbody></table>";

  } else {
    html = "<div class=\"alert alert-danger text-center\" role=\"alert\"><strong>Nenhum resultado encontrado!</strong> Tente outro termo de busca.</div>"
  }
  return html;
}

function createPagination(count, pagAtual) {
  var html = ""

  html += "<nav class=\"text-center\"><ul class=\"pagination\">";

  for(var i = 0; i < count; i++) {
    if(i == pagAtual) {
      html += "<li class=\"active\"><a class=\"consulta-fonte\" data-pag=\""+ i + "\" href=\"#\">"+ (i + 1) +"</a></li>";
    } else {
      html += "<li><a class=\"consulta-fonte\" data-pag=\""+ i + "\" href=\"#\">"+ (i + 1) +"</a></li>";
    }
  }
  html += "</ul></nav>";
  return html;
}

$(document).ready(function() {
  // Consulta Relativa
  $('#consulta-relativa').submit(function(e) {
    e.preventDefault();
    $.ajax({
      type: 'GET',
      url: 'ConsultaRelativa',
      data: {entrada: $('#entrada').val(),
             value: $('#selectList2').val()}
    }).done(function(data) {
      $('#entrada').val("");
      createTableSub(data);
    }).fail(function(data) {
      alert("ERROR!");
    });
  });

  // Consulta Subdominio
  $('#consulta-subdominio').click(function(e) {
    $.ajax({
      type: 'GET',
      url: 'ConsultaSubDominio',
      data: {}
    }).done(function(data) {
      createTableSub(data);
    }).fail(function(data) {
      alert("ERROR!");
    });
  });

  // Consulta Fonte
  $('body').on("click", ".consulta-fonte", function(e) {
    var pagAtual = $(this).attr("data-pag");
    e.preventDefault();
    $.ajax({
      type: 'GET',
      url: 'ConsultaFonte',
      data: {offset: pagAtual * 10}
    }).done(function(data) {
      $('#results').html(createTableFonte(data, pagAtual));
      $('#results').append(createPagination(7, pagAtual));
    }).fail(function(data) {
      alert("ERROR!");
    });
  });

  // Home
  if($('.well').length > 0) {
    $('#Home').addClass('active');
  };

  // About
  if($('.jumbotron').length > 0) {
    $('#About').addClass('active');
  };

  // Contact
  if($('.img-circle').length > 0) {
    $('#Contact').addClass('active');
    $('body').css({"background-image": "url('img/background.jpg')"})
  };
});
