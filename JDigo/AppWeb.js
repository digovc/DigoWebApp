// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function AppWeb() {
  // HERAN�A

  Objeto.apply(this);

  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  var _arrObjPaletaCor = null;

  this.getArrObjPaletaCor = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_arrObjPaletaCor == null) {

        _arrObjPaletaCor = new Array();
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _arrObjPaletaCor;
  }

  var _intPaletaCorSelecionada = 0;

  this.getIntPaletaCorSelecionada = function() {

    return _intPaletaCorSelecionada;

  }

  this.setIntPaletaCorSelecionada = function(intPaletaCorSelecionada) {

    _intPaletaCorSelecionada = intPaletaCorSelecionada;

  }

  var _strSessionId;

  this.getStrSessionId = function() {

    return _strSessionId;

  }

  this.setStrSessionId = function(strSessionId) {

    _strSessionId = strSessionId;

  }

  // FIM ATRIBUTO

  // M�TODO
  // FIM M�TODO

  /* Construtor */
  {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES
      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}

// INICIALIZA��O

var appWeb;

$(document).ready(function() {

  appWeb = new AppWeb();

});

// FIM INICIALIZA��O
