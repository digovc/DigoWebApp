// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Usuario() {
  // HERAN�A

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

  // M�TODO

  /* Construtor */
  {
    // VARI�VEL
    // A��O
  }

}

// INICIALIZA��O
var objUsuario;

$(document).ready(function() {

  objUsuario = new Usuario();

});