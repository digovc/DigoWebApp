// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function PopupItem(strId) {
  // HERAN�A
  // FIM HERAN�A

  // ATRIBUTO

  ItemMain.apply(this);
  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM ATRIBUTO

  // M�TODO
  // FIM M�TODO

  /* Construtor */{
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (!Utils.getBooStrVazia(strId)) {

        this.setStrId(strId);
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}