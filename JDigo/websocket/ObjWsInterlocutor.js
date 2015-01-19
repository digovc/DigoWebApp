// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function ObjWsInterlocutor() {
  // HERANÇA

  Objeto.apply(this);

  // FIM HERANÇA

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

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */
  {

    try {

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}