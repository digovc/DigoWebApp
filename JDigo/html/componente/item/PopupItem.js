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

  var _intOrdem = null;

  this.getIntOrdem = function() {

    try {

      _intOrdem = _this.getStrId();
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

  this.evtClick = function(evt) {

    try {

      _this.getPpp().acaoClick(_this);
      _this.getPpp().getJq().remove();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.evtMouseEnter = function(evt) {

    try {

      $("#" + evt.target.id).css("background-color", "#e1e1e1");

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.evtMouseLeave = function(evt) {

    try {

      $("#" + evt.target.id).css("background-color", "");

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.setEventos = function() {

    try {

      _this.getJq().click(_this.evtClick);
      _this.getJq().mouseenter(_this.evtMouseEnter);
      _this.getJq().mouseleave(_this.evtMouseLeave);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */{

    try {

      _this.setStrId(strId);

      if (ppp != null) {

        _this.setPpp(ppp);
      }

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  }

}