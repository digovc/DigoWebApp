// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function PopupItem(strId, ppp) {
  // HERANÇA

  ItemMain.apply(this);
  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _fncClick = null;

  this.getFncClick = function() {
    // VARIÁVEIS

    
    try {
      

      if (_fncClick == null) {

        _fncClick = function(evt) {
          // VARIÁVEIS
          
          try {
            

            _this.click();
            _this.getPpp().getJq().remove();

            // FIM AÇÕES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncClick;
  };

  var _fncMouseEnter = null;

  this.getFncMouseEnter = function() {
    // VARIÁVEIS
    
    try {
      

      if (_fncMouseEnter == null) {

        _fncMouseEnter = function(evt) {
          // VARIÁVEIS
          
          try {
            

            $("#" + evt.target.id).css("background-color", "#e1e1e1");

            // FIM AÇÕES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseEnter;
  };

  var _fncMouseLeave = null;

  this.getFncMouseLeave = function() {
    // VARIÁVEIS
    
    try {
      

      if (_fncMouseLeave == null) {

        _fncMouseLeave = function(evt) {
          // VARIÁVEIS
          
          try {
            

            $("#" + evt.target.id).css("background-color", "");

            // FIM AÇÕES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseLeave;
  };

  var _intOrdem = null;

  this.getIntOrdem = function() {
    // VARIÁVEIS
    
    try {
      

      _intOrdem = this.getStrId();
      _intOrdem = _intOrdem.replace("ppiAcao", "");
      _intOrdem = window.parseInt(_intOrdem);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _intOrdem;
  };

  var _ppp = null;

  this.getPpp = function() {
    return _ppp;
  };

  this.setPpp = function(ppp) {
    _ppp = ppp;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.click = function() {
    // VARIÁVEIS
    
    try {
      

      this.getPpp().acaoClick(this);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventos = function() {
    // VARIÁVEIS
    
    try {
      

      this.getJq().click(this.getFncClick());
      this.getJq().mouseenter(this.getFncMouseEnter());
      this.getJq().mouseleave(this.getFncMouseLeave());

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

      if (ppp != null) {
        this.setPpp(ppp);
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}