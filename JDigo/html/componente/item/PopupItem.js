// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function PopupItem(strId, ppp) {
  // HERAN�A

  ItemMain.apply(this);
  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  var _fncClick = null;

  this.getFncClick = function() {
    // VARI�VEIS

    // FIM VARI�VEIS
    try {
      // A��ES

      if (_fncClick == null) {

        _fncClick = function(evt) {
          // VARI�VEIS
          // FIM VARI�VEIS
          try {
            // A��ES

            _this.click();

            // FIM A��ES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncClick;
  };

  var _fncMouseEnter = null;

  this.getFncMouseEnter = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_fncMouseEnter == null) {

        _fncMouseEnter = function(evt) {
          // VARI�VEIS
          // FIM VARI�VEIS
          try {
            // A��ES

            $("#" + evt.target.id).css("background-color", "#e1e1e1");

            // FIM A��ES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseEnter;
  };

  var _fncMouseLeave = null;

  this.getFncMouseLeave = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_fncMouseLeave == null) {

        _fncMouseLeave = function(evt) {
          // VARI�VEIS
          // FIM VARI�VEIS
          try {
            // A��ES

            $("#" + evt.target.id).css("background-color", "");

            // FIM A��ES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseLeave;
  };

  var _ppp = null;

  this.getPpp = function() {
    return _ppp;
  };

  this.setPpp = function(ppp) {
    _ppp = ppp;
  };

  // FIM ATRIBUTO

  // M�TODO

  this.click = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getPpp().acaoClick(this);

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventos = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getJq().click(this.getFncClick());
      this.getJq().mouseenter(this.getFncMouseEnter());
      this.getJq().mouseleave(this.getFncMouseLeave());

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

      if (!Utils.getBooStrVazia(strId)) {

        this.setStrId(strId);
      }

      if (ppp != null) {
        this.setPpp(ppp);
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}