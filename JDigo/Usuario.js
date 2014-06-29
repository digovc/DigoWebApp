// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Usuario() {
  // HERANÇA

  Objeto.apply(this);

  // ATRIBUTO

  var _this = this;

  var _booLogado = false;

  this.getBooLogado = function() {
    return _booLogado;
  }

  this.setBooLogado = function(booLogado) {
    _booLogado = booLogado;
  }

  var _intUsuarioId = null;

  this.getIntUsuarioId = function() {
    return _intUsuarioId;
  }

  this.setIntUsuarioId = function(intUsuarioId) {
    _intUsuarioId = intUsuarioId;
  }

  // MÉTODO

  /* Construtor */
  {
    // VARIÁVEL
    // AÇÃO
  }

}

// INICIALIZAÇÃO
var objUsuario;

$(document).ready(function() {

  objUsuario = new Usuario();

});