// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Campo(strId) {
  // HERANÇA

  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _strValor = null;

  this.getStrValor = function() {

    try {

      _strValor = _this.getJq().val();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _strValor;
  }

  this.setStrValor = function(strValor) {

    try {

      _strValor = strValor;
      _this.getJq().val(_strValor);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

  // FIM ATRIBUTO

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */
  {

    try {

      _this.setStrId(strId);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}