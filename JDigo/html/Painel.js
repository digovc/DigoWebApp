// ATRIBUTOS GLOBAIS
// CLASSE
// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Painel(strId) {
  // HERANÇA

  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  // FIM ATRIBUTO

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */{

    try {

      _this.setStrId(strId);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  }
}