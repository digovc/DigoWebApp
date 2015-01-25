// CONSTANTE

var WebSocketMain_FNC_MSG_ERRO = 70000;
var WebSocketMain_FNC_MSG_POSITIVA = 701000;

// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function WebSocketMain(strUrl) {
  // HERANÇA

  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  // ATRIBUTO ABSTRATO

  var _strHost;
  var _strWsPagina;

  // FIM ATRIBUTO ABSTRATO

  var _booConectado = false;

  this.getBooConectado = function() {
    return _booConectado;
  };

  this.setBooConectado = function(booConectado) {
    _booConectado = booConectado;
  };

  var _objWebSocket;

  this.getObjWebSocket = function() {

    try {

      if (!"WebSocket" in window) {

        new Erro(STR_MENSAGEM_00001, null);
        return false;
      }

      if (_objWebSocket != null) {

        return _objWebSocket;
      }

      _objWebSocket = new WebSocket(_this.getStrUrl());

      _objWebSocket.onclose = _this.evtOnClose;
      _objWebSocket.onmessage = _this.evtOnMessage;
      _objWebSocket.onopen = _this.evtOnOpen;

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }

    return _objWebSocket;
  };

  var _strUrl;

  this.getStrUrl = function() {

    try {

      if (!Utils.getBooStrVazia(_strUrl)) {

        return _strUrl;
      }

      _strUrl = "ws://_host/ws/_ws_pag";

      _strUrl = _strUrl.replace("_host", _this.getStrHost());
      _strUrl = _strUrl.replace("_ws_pag", _this.getStrWsPagina());

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }

    return _strUrl;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.abrirConexao = function() {

    try {

      _this.getObjWebSocket();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.enviar = function(objWsInterlocutor) {

    try {

      _this.getObjWebSocket().send(JSON.stringify(objWsInterlocutor));

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.evtOnClise = function(evt) {

    try {

      _this.setBooConectado(false);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.evtOnMessage = function(evt) {

    var objWsInterlocutor;

    try {

      objWsInterlocutor = JSON.parse(evt.data);

      _this.processarObjWsInterlocutor(objWsInterlocutor);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.evtOnOpen = function(evt) {

    try {

      _this.setBooConectado(true);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.processarMsgErro = function(strMsgErro) {

    var msg;

    try {

      if (Utils.getBooStrVazia(strMsgErro)) {

        return false;
      }

      msg = new Mensagem("Erro", strMsgErro, Mensagem_TIPO_NEGATIVA);

      msg.mostrar();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.processarMsgPositiva = function(strMsgPositiva) {

    var msg;

    try {

      if (Utils.getBooStrVazia(strMsgPositiva)) {

        return false;
      }

      msg = new Mensagem("Hey " + objUsuario.getStrNome(), strMsgPositiva, Mensagem_TIPO_POSITIVA);

      msg.setBooBloquearTela(false);
      msg.mostrar();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.processarObjWsInterlocutor = function(objWsInterlocutor) {

    try {

      switch (objWsInterlocutor._intFncId) {

      case WebSocketMain_FNC_MSG_ERRO:

        _this.processarMsgErro(objWsInterlocutor._strJson);
        return true;

      case WebSocketMain_FNC_MSG_POSITIVA:

        _this.processarMsgPositiva(objWsInterlocutor._strJson);
        return true;
      }
    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */
  {
    try {

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  }
}