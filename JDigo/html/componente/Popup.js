// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Popup(strId) {
  // HERAN�A

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  var _arrPpiAcao = null;

  this.getArrPpiAcao = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_arrPpiAcao == null) {

        _arrPpiAcao = new Array();
      }

      // FIM A��ES
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

            _this.getJq().remove();

            // FIM A��ES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        };
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncMouseLeave;
  };

  // FIM ATRIBUTO

  // M�TODO

  this.acaoClick = function(ppi) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES
      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarPopup = function(intX, intY) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setBooVisivel(true);
      this.getJq().remove();

      $("body").append(this.getStrEstrutura());

      this.getJq().css("left", intX);
      this.getJq().css("top", intY);
      this.getJq().slideDown("fast");

      this.setItens();
      this.setEventos();

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

      this.getJq().mouseleave(this.getFncMouseLeave());
      this.setEventosItens();

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setItens = function() {
    // VARI�VEIS

    var arrTag;
    var ppiAcao;

    // FIM VARI�VEIS
    try {
      // A��ES

      this.setArrPpiAcao(null);

      arrTag = this.getJq().find("[id*=ppiAcao]");

      for (var i = 0; i < arrTag.length; i++) {
        var tag = arrTag[i];

        ppiAcao = new PopupItem(tag.id, this);
        this.getArrPpiAcao().push(ppiAcao);
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventosItens = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      for (var i = 0; i < this.getArrPpiAcao().length; i++) {
        var ppiAcao = this.getArrPpiAcao()[i];

        ppiAcao.setEventos();
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

      if (!Utils.getBooStrVazia(strId)) {

        this.setStrId(strId);
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}