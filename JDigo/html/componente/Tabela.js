// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

function Tabela(strId) {
  // HERAN�A

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  // FIM ATRIBUTO

  // M�TODO

  this.setOrdenacao = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getJq().find('table').tablesorter();

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setPesquisa = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if ('quicksearch' in $('document')) {
        this.getJq().find("input").quicksearch('#' + this.getStrId() + ' table tbody tr');
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM M�TODO

  /* Construtor */{
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      _this.setStrId(strId);
      _this.setPesquisa();
      _this.setOrdenacao();

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}