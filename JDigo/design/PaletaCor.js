// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE
function PaletaCor(strNome) {
  // HERANÇA

  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _corControleClicado = null;

  this.getCorControleClicado = function() {
    return _corControleClicado;
  }

  this.setCorControleClicado = function(corControleClicado) {
    _corControleClicado = corControleClicado;
  }

  var _corControleMouse = "";

  this.getCorControleMouse = function() {
    return _corControleMouse;
  }

  this.setCorControleMouse = function(corControleMouse) {
    _corControleMouse = corControleMouse;
  }

  var _corControleNormal = "";

  this.getCorControleNormal = function() {
    return _corControleNormal;
  }

  this.setCorControleNormal = function(corControleNormal) {
    _corControleNormal = corControleNormal;
  }

  var _corFundo = "";

  this.getCorFundo = function() {
    return _corFundo;
  }

  this.setCorFundo = function(corFundo) {
    _corFundo = corFundo;
  }

  // FIM ATRIBUTO

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */
  {

    try {

      _this.setStrNome(strNome);

      appWeb.getArrObjPaletaCor()[appWeb.getArrObjPaletaCor().length] = _this;

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }
}