// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Botao(strId) {
  // HERANÇA

  Tag.apply(this);
  Objeto.apply(this);

  // ATRIBUTO

  var _this = this;

  // MÉTODO

  /* Construtor */
  {

    try {

      _this.setStrId(strId);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}