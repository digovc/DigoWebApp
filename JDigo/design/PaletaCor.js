// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE
function PaletaCor(strNome) {
  // HERAN�A

  Objeto.apply(this);

  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  var _strCorControleClicado = "";

  this.getStrCorControleClicado = function() {
    return _strCorControleClicado;
  }

  this.setStrCorControleClicado = function(strCorControleClicado) {
    _strCorControleClicado = strCorControleClicado;
  }

  var _strCorControleMouse = "";

  this.getStrCorControleMouse = function() {
    return _strCorControleMouse;
  }

  this.setStrCorControleMouse = function(strCorControleMouse) {
    _strCorControleMouse = strCorControleMouse;
  }

  var _strCorControleNormal = "";

  this.getStrCorControleNormal = function() {
    return _strCorControleNormal;
  }

  this.setStrCorControleNormal = function(strCorControleNormal) {
    _strCorControleNormal = strCorControleNormal;
  }

  var _strCorFundo = "";

  this.getStrCorFundo = function() {
    return _strCorFundo;
  }

  this.setStrCorFundo = function(strCorFundo) {
    _strCorFundo = strCorFundo;
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

      this.setStrNome(strNome);
      appWeb.getArrObjPaletaCor()[appWeb.getArrObjPaletaCor().length] = this;

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}
// INICIALIZA��O
// FIM INICIALIZA��O
