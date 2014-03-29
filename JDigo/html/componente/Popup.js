// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Popup(strId) {
  // HERANÇA
  // FIM HERANÇA

  // ATRIBUTO

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM ATRIBUTO

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */{
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (!Utils.getBooStrVazia(strId)) {

        this.setStrId(strId);
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}