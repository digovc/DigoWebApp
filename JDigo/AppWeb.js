// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function AppWeb() {
  // HERANÇA

  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _arrObjPaletaCor = null;

  this.getArrObjPaletaCor = function() {

    try {

      if (_arrObjPaletaCor != null) {

        return _arrObjPaletaCor;
      }

      _arrObjPaletaCor = new Array();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }

    return _arrObjPaletaCor;
  }

  this._booEmFoco = null;

  this.getBooEmFoco = function() {
    return _this._booEmFoco;
  };

  this.setBooEmFoco = function(booEmFoco) {
    _this._booEmFoco = booEmFoco;
  };

  var _intPaletaCorSelecionada = 0;

  this.getIntPaletaCorSelecionada = function() {
    return _intPaletaCorSelecionada;
  }

  this.setIntPaletaCorSelecionada = function(intPaletaCorSelecionada) {
    _intPaletaCorSelecionada = intPaletaCorSelecionada;
  }

  var _msgLoad = null;

  this.getMsgLoad = function() {
    return _msgLoad;
  };

  this.setMsgLoad = function(msgLoad) {
    _msgLoad = msgLoad;
  };

  var _strSessionId;

  this.getStrSessionId = function() {

    return _strSessionId;

  }

  this.setStrSessionId = function(strSessionId) {

    _strSessionId = strSessionId;

  }

  // FIM ATRIBUTO

  // MÉTODO

  this.esconderEspera = function() {

    try {

      if (_this.getMsgLoad() == null) {

        return false;
      }

      _this.getMsgLoad().esconder();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.evtBlur = function(evt) {

    try {

      _this.setBooEmFoco(false);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.evtFocus = function(evt) {

    try {

      _this.setBooEmFoco(true);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.imprimir = function(pag) {

    var objWindow;

    try {

      objWindow = window.open('', 'my div', 'height=400,width=600');
      objWindow.document.write(pag);
      objWindow.print();
      objWindow.close();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarEspera = function(strTitulo, strMensagem) {

    try {

      _this.setMsgLoad(new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_LOAD));
      _this.getMsgLoad().mostrar();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgAlerta = function(strTitulo, strMensagem) {

    var msg;

    try {

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_ALERTA);
      msg.mostrar();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgNegativa = function(strTitulo, strMensagem) {

    var msg;

    try {

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_NEGATIVA);
      msg.mostrar();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgPositiva = function(strTitulo, strMensagem) {

    var msg;

    try {

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_POSITIVA);
      msg.mostrar();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.setEventos = function() {

    try {

      $(window).focus(_this.evtFocus);
      $(window).blur(_this.evtBlur);

      window.onfocus = _this.evtFocus;
      window.onblur = _this.evtBlur;

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  // FIM MÉTODO

  /* Construtor */
  {

    try {

      _this.setBooEmFoco(true);
      _this.setEventos();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}

// INICIALIZAÇÃO

var appWeb;

$(document).ready(function() {

  appWeb = new AppWeb();

});

// FIM INICIALIZAÇÃO
