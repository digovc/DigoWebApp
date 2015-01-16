﻿// CONSTANTE

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

  var _fncOnMessage;

  /**
   * Método que deve ser implementado pela classe de instância para receber e
   * processar as mensagens vindas do servidor.
   */
  this.getFncOnMessage = function() {

    try {

      if (_fncOnMessage != null) {

        return _fncOnMessage;
      }

      _fncOnMessage = function(evt) {

        var objWsInterlocutor;

        try {

          objWsInterlocutor = JSON.parse(evt.data);
          _this.processarObjWsInterlocutor(objWsInterlocutor);

        } catch (e) {

          new Erro("Erro inesperado.", e);
        }
      };
    } catch (e) {

      new Erro("Erro inesperado.", e);
    }

    return _fncOnMessage;
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

      _objWebSocket = new WebSocket(this.getStrUrl());

      _objWebSocket.onmessage = this.getFncOnMessage();

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

      this.getObjWebSocket();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.enviar = function(objWsInterlocutor) {

    try {

      this.getObjWebSocket().send(JSON.stringify(objWsInterlocutor));

    } catch (e) {

      new Erro("Erro inesperado.", e);
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

      msg = new Mensagem("Ok " + objUsuario.getStrNome(), strMsgPositiva, Mensagem_TIPO_POSITIVA);

      msg.mostrar();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.processarObjWsInterlocutor = function(objWsInterlocutor) {
  };

  // FIM MÉTODO

  /* Construtor */
  {
    try {

      this.abrirConexao();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  }
}