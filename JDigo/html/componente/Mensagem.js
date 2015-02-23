// CONSTANTE

var Mensagem_BOO_MENSAGEM_VISIVEL = false;
var Mensagem_STR_MENSAGEM_ULTIMA = "";

var Mensagem_ESTRUTURA_INFO_ALERTA = "";
var Mensagem_ESTRUTURA_INFO_LOAD = "";
var Mensagem_ESTRUTURA_INFO_NEGATIVA = "";
var Mensagem_ESTRUTURA_INFO_POSITIVA = "";

var Mensagem_TIPO_ALERTA = 0;
var Mensagem_TIPO_LOAD = 1;
var Mensagem_TIPO_NEGATIVA = 2;
var Mensagem_TIPO_POSITIVA = 3;

// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Mensagem(strTitulo, strMsg, intTipo) {
  // HERANÇA

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _booBloquearTela = true;

  this.getBooBloquearTela = function() {

    return _booBloquearTela;
  };

  this.setBooBloquearTela = function(booBloquearTela) {
    _booBloquearTela = booBloquearTela;
  };

  var _intTipo = Mensagem_TIPO_POSITIVA;

  this.getIntTipo = function() {
    return _intTipo;
  };

  /**
   * 0 = alerta; 1 = load; 2 = negativa; 3 = positiva.
   */
  this.setIntTipo = function(intTipo) {

    try {

      _intTipo = intTipo;
      _this.setBooBloquearTela(!_intTipo == 3);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  var _srcIcon = null;

  this.getSrcIcon = function() {

    try {

      if (_srcIcon != null) {

        return _srcIcon;
      }

      switch (_this.getIntTipo()) {

      case Mensagem_TIPO_LOAD:
        _srcIcon = "res/media/gif/load.gif";
        break;

      case Mensagem_TIPO_NEGATIVA:
        _srcIcon = "res/media/png/info_negativa.png";
        break;

      case Mensagem_TIPO_POSITIVA:
        _srcIcon = "res/media/png/info_positiva.png";
        break;

      default:
        _srcIcon = "res/media/png/info_alerta.png";
        break;
      }
    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }

    return _srcIcon;
  };

  var _strMsg = "";

  this.getStrMsg = function() {
    return _strMsg;
  };

  this.setStrMsg = function(strMsg) {
    _strMsg = strMsg;
  };

  var _strTitulo = "";

  this.getStrTitulo = function() {
    return _strTitulo;
  };

  this.setStrTitulo = function(strTitulo) {
    _strTitulo = strTitulo;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.esconder = function() {

    try {

      $(document).find("#msg").fadeOut("slow");

      window.setTimeout(function() {

        $(document).find("#msg").remove();
        Mensagem_BOO_MENSAGEM_VISIVEL = false;

      }, 400);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.montarLayout = function() {

    var tag;

    try {

      switch (_this.getIntTipo()) {

      case 0: // Alerta
        tag = Mensagem_ESTRUTURA_INFO_ALERTA;
        break;

      case 1: // Load
        tag = Mensagem_ESTRUTURA_INFO_LOAD;
        break;

      case 2: // Negativa
        tag = Mensagem_ESTRUTURA_INFO_NEGATIVA;
        break;

      case 3: // Positiva
        tag = Mensagem_ESTRUTURA_INFO_POSITIVA;
        break;

      default:
        tag = Mensagem_ESTRUTURA_INFO_POSITIVA;
        break;
      }

      tag = tag.replace("_titulo", _this.getStrTitulo());
      tag = tag.replace("_msg", _this.getStrMsg());

      _this.montarLayoutBloquearTela(tag)

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.montarLayoutBloquearTela = function(tag) {

    try {

      if (!_this.getBooBloquearTela()) {

        _this.setStrEstrutura(tag);
        return false;
      }

      tag = $(tag).css("background", "rgba(0, 0, 0, 0.15)");
      tag = $(tag).css("bottom", "0px");

      _this.setStrEstrutura(tag[0]);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.mostrar = function() {

    var intTempo;

    try {

      if (!appWeb.getBooEmFoco()) {

        _this.mostrarNotificacao();
        return false;
      }

      if (Mensagem_BOO_MENSAGEM_VISIVEL) {

        window.setTimeout(function() {
          _this.mostrar();
        }, 250);

        return false;
      }

      intTempo = _this.getStrMsg().length * 75;

      $("body").append(_this.toHtml());

      Mensagem_BOO_MENSAGEM_VISIVEL = true;

      if (_this.getIntTipo() == 1) {

        return;
      }

      window.setTimeout(function() {

        _this.esconder();

      }, intTempo);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarNotificacao = function() {

    var objNotificacaoOption;

    try {

      if (Mensagem_STR_MENSAGEM_ULTIMA == _this.getStrTitulo() + _this.getStrMsg()) {

        return false;
      }

      objNotificacaoOption = {

        body : _this.getStrMsg(),
        icon : _this.getSrcIcon(),
      }

      if (!("Notification" in window)) {

        return false;

      } else if (Notification.permission === "granted") {

        new Notification(_this.getStrTitulo(), objNotificacaoOption);

      } else if (Notification.permission !== 'denied') {

        Notification.requestPermission(function(permission) {

          if (permission === "granted") {

            new Notification(_this.getStrTitulo(), objNotificacaoOption);
          }
        });
      }

      Mensagem_STR_MENSAGEM_ULTIMA = _this.getStrTitulo() + _this.getStrMsg();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  // FIM MÉTODO

  /* Construtor */{

    try {

      _this.setIntTipo(intTipo);
      _this.setStrTitulo(strTitulo);
      _this.setStrMsg(strMsg);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  }
}