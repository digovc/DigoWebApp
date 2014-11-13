// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 * Classe que representa itens
 */
function ItemMain() {
  // HERANÇA

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _booSelecionado = false;

  this.getBooSelecionado = function() {
    return _booSelecionado;
  }

  this.setBooSelecionado = function(booSelecionado) {
    _booSelecionado = booSelecionado;
  }

  // FIM ATRIBUTO

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */{
    // VARIÁVEIS
    
    try {
      
      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}