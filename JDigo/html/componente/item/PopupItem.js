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

    try {

      if (_fncClick == null) {

        _fncClick = function(evt) {

          try {

            _this.click();
            _this.getPpp().getJq().remove();

          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncClick;
  };

  var _fncMouseEnter = null;

  this.getFncMouseEnter = function() {

    try {

      if (_fncMouseEnter == null) {

        _fncMouseEnter = function(evt) {

          try {

            $("#" + evt.target.id).css("background-color", "#e1e1e1");

          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseEnter;
  };

  var _fncMouseLeave = null;

  this.getFncMouseLeave = function() {

    try {

      if (_fncMouseLeave == null) {

        _fncMouseLeave = function(evt) {

          try {

            $("#" + evt.target.id).css("background-color", "");

          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        }
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseLeave;
  };

  var _intOrdem = null;

  this.getIntOrdem = function() {

    try {

      _intOrdem = this.getStrId();
      _intOrdem = _intOrdem.replace("ppiAcao", "");
      _intOrdem = window.parseInt(_intOrdem);

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

    try {

      this.getPpp().acaoClick(this);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventos = function() {

    try {

      this.getJq().click(this.getFncClick());
      this.getJq().mouseenter(this.getFncMouseEnter());
      this.getJq().mouseleave(this.getFncMouseLeave());

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */{

    try {

      this.setStrId(strId);

      if (ppp != null) {
        this.setPpp(ppp);
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}