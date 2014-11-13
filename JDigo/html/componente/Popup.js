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

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _arrPpiAcao = null;

  this.getArrPpiAcao = function() {
    // VARIÁVEIS
    
    try {
      

      if (_arrPpiAcao == null) {

        _arrPpiAcao = new Array();
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _arrPpiAcao;
  };

  this.setArrPpiAcao = function(arrPpiAcao) {
    _arrPpiAcao = arrPpiAcao;
  }

  var _fncMouseLeave = null;

  this.getFncMouseLeave = function() {
    // VARIÁVEIS
    
    try {
      

      if (_fncMouseLeave == null) {

        _fncMouseLeave = function(evt) {
          // VARIÁVEIS
          
          try {
            

            _this.getJq().remove();

            // FIM AÇÕES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        };
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseLeave;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.acaoClick = function(ppi) {
    // VARIÁVEIS
    
    try {
      
      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarPopup = function(intX, intY) {
    // VARIÁVEIS
    
    try {
      

      this.setBooVisivel(true);
      this.getJq().remove();

      $("body").append(this.getStrEstrutura());

      this.getJq().css("left", intX);
      this.getJq().css("top", intY);
      this.getJq().slideDown("fast");

      this.setItens();
      this.setEventos();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventos = function() {
    // VARIÁVEIS
    
    try {
      

      this.getJq().mouseleave(this.getFncMouseLeave());
      this.setEventosItens();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setItens = function() {
    // VARIÁVEIS

    var arrTag;
    var ppiAcao;

    
    try {
      

      this.setArrPpiAcao(null);

      arrTag = this.getJq().find("[id*=ppiAcao]");

      for (var i = 0; i < arrTag.length; i++) {
        var tag = arrTag[i];

        ppiAcao = new PopupItem(tag.id, this);
        this.getArrPpiAcao().push(ppiAcao);
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventosItens = function() {
    // VARIÁVEIS
    
    try {
      

      for (var i = 0; i < this.getArrPpiAcao().length; i++) {
        var ppiAcao = this.getArrPpiAcao()[i];

        ppiAcao.setEventos();
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
      

      if (!Utils.getBooStrVazia(strId)) {

        this.setStrId(strId);
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}