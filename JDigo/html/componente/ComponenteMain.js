// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function ComponenteMain(strId) {
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
    }
  }

}
// INICIALIZAÇÃO

// var objComponenteMain;
// $(document).ready(function() {
// objComponenteMain = new ComponenteMain();
// });

// FIM INICIALIZAÇÃO
