// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS

var Objeto_intId = 0;

// FIM ATRIBUTOS GLOBAIS

// CLASSE
function Objeto() {
  // HERANÇA
  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _intObjetoId = 0;

  this.getIntObjetoId = function() {
    return _intObjetoId;
  }

  this.setIntObjetoId = function(intObjetoId) {
    _intObjetoId = intObjetoId;
  }

  var _strNome = "";

  this.getStrNome = function() {
    return _strNome;
  }

  this.setStrNome = function(strNome) {
    _strNome = strNome;
  }

  var _strNomeExibicao = "";

  this.getStrNomeExibicao = function() {

    try {

      if (!Utils.getBooVazia(_strNomeExibicao)) {

        return _strNomeExibicao;
      }

      _strNomeExibicao = _this.getStrNome();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }

    return _strNomeExibicao;
  }

  this.setStrNomeExibicao = function(strNomeExibicao) {
    _strNomeExibicao = strNomeExibicao;
  }

  // FIM ATRIBUTO

  // MÉTODO
  // FIM MÉTODO

  /* Construtor */
  {

    try {

      Objeto_intId++;
      _this.setIntObjetoId(Objeto_intId);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }
}