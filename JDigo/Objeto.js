// CONSTANTE

// ATRIBUTOS GLOBAIS
var Objeto_intId = 0;

// CLASSE
function Objeto() {
  // HERANÇA

  // ATRIBUTO

  var _this = this;

  var _intId = 0;

  this.getIntId = function() {
    return _intId;
  }

  this.setIntId = function(intId) {
    _intId = intId;
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
      

      if (_strNomeExibicao == "") {

        _strNomeExibicao = this.getStrNome();
      }

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _strNomeExibicao;
  }

  this.setStrNomeExibicao = function(strNomeExibicao) {
    _strNomeExibicao = strNomeExibicao;
  }

  // MÉTODO

  /* Construtor */
  {
    
    
    try {
      

      Objeto_intId++;
      this.setIntId(Objeto_intId);

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}