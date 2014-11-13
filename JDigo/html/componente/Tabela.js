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

  var _this = this;

  // FIM ATRIBUTO

  // MÉTODO

  this.setOrdenacao = function() {
    // VARIÁVEIS
    
    try {
      

      this.getJq().find('table').tablesorter();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setPesquisa = function() {
    // VARIÁVEIS
    
    try {
      

      if ('quicksearch' in $('document')) {
        this.getJq().find("input").quicksearch('#' + this.getStrId() + ' table tbody tr');
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */{
    // VARIÁVEIS
    
    try {
      

      _this.setStrId(strId);
      _this.setPesquisa();
      _this.setOrdenacao();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}