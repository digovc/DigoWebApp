// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

function Tabela(strId) {
  // HERANÇA

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO
  // FIM ATRIBUTO

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */{
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrId(strId);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}