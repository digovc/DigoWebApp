// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 * Classe que representa itens
 */
function ItemMain() {
  // HERAN�A

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERAN�A

  // ATRIBUTO

  var _booSelecionado = false;

  this.getBooSelecionado = function() {
    return _booSelecionado;
  }

  this.setBooSelecionado = function(booSelecionado) {
    _booSelecionado = booSelecionado;
  }

  // FIM ATRIBUTO

  // M�TODO
  // FIM M�TODO

  /* Construtor */{
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES
      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}