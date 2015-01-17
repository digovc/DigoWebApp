// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Formulario(strId) {
  // HERANÇA

  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  // FIM ATRIBUTO

  // MÉTODO

  this.enviar = function() {

    try {

      this.getJq().submit();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

  this.submit = function() {

    try {

      _this.enviar();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */
  {

    try {

      this.setStrId(strId);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}