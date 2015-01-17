// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Painel(strId) {
  // HERANÇA

  Tag.apply(this);
  Objeto.apply(this);

  // ATRIBUTO
  // MÉTODO

  /* Construtor */
  {

    var _this = this;

    try {

      this.setStrId(strId);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}