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

    try {

      if (_arrPpiAcao == null) {

        _arrPpiAcao = new Array();
      }

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

    try {

      if (_fncMouseLeave == null) {

        _fncMouseLeave = function(evt) {

          try {

            _this.getJq().remove();

          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        };
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseLeave;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.acaoClick = function(ppi) {

    try {

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarPopup = function(intX, intY) {

    try {

      _this.setBooVisivel(true);
      _this.getJq().remove();

      $("body").append(_this.getStrEstrutura());

      _this.getJq().css("left", intX);
      _this.getJq().css("top", intY);
      _this.getJq().slideDown("fast");

      _this.setItens();
      _this.setEventos();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventos = function() {

    try {

      _this.getJq().mouseleave(_this.getFncMouseLeave());
      _this.setEventosItens();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setItens = function() {

    var arrTag;
    var ppiAcao;

    try {

      _this.setArrPpiAcao(null);

      arrTag = _this.getJq().find("[id*=ppiAcao]");

      for (var i = 0; i < arrTag.length; i++) {
        var tag = arrTag[i];

        ppiAcao = new PopupItem(tag.id, _this);
        _this.getArrPpiAcao().push(ppiAcao);
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventosItens = function() {

    try {

      for (var i = 0; i < _this.getArrPpiAcao().length; i++) {
        var ppiAcao = _this.getArrPpiAcao()[i];

        ppiAcao.setEventos();
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */{

    try {

      _this.setStrId(strId);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}