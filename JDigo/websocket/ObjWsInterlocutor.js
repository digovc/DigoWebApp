// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function ObjWsInterlocutor() {
  // HERAN�A

  Objeto.apply(this);

  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  this._intFncId = 0;

  this.getIntFncId = function() {
    return this._intFncId;
  }

  this.setIntFncId = function(intFncId) {
    this._intFncId = intFncId;
  }

  this._strJson = null;

  this.getStrJson = function() {
    return this._strJson;
  }

  this.setStrJson = function(strJson) {
    this._strJson = strJson;
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