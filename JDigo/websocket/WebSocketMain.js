﻿// CONSTANTE

var WebSocketMain_FNC_MSG_ERRO = 70000;
var WebSocketMain_FNC_MSG_POSITIVA = 701000;

// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function WebSocketMain(strUrl) {
  // HERANÇA
  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _fncOnMessage = null;

  /**
   * Método que deve ser implementado pela classe de instância para receber e
   * processar as mensagens vindas do servidor.
   */
  this.getFncOnMessage = function() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_fncOnMessage == null) {

        _fncOnMessage = function(evt) {
          // VARIÁVEIS

          var objWsInterlocutor;

          // FIM VARIÁVEIS
          try {
            // AÇÕES

            objWsInterlocutor = JSON.parse(evt.data);
            _this.processarObjWsInterlocutor(objWsInterlocutor);

            // FIM AÇÕES
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        };

      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncOnMessage;
  };

  var _objWebSocket = null;

  this.getObjWebSocket = function() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (!"WebSocket" in window) {
        new Erro(STR_MENSAGEM_00001, null);
      }

      if (_objWebSocket == null) {

        _objWebSocket = new WebSocket(this.getStrUrl());
        _objWebSocket.onmessage = this.getFncOnMessage();
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _objWebSocket;
  };

  var _strUrl = "";

  this.getStrUrl = function() {
    return _strUrl;
  };

  this.setStrUrl = function(strUrl) {
    _strUrl = strUrl;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.abrirConexao = function() {
    // VARIÁVEIS
    try {
      // AÇÕES

      this.getObjWebSocket();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.enviar = function(objWsInterlocutor) {
    // VARIÁVEIS
    try {
      // AÇÕES

      this.getObjWebSocket().send(JSON.stringify(objWsInterlocutor));

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.processarMsgErro = function(strMsgErro) {
    // VARIÁVEIS

    var msg;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Utils.getBooStrVazia(strMsgErro)) {
        return false;
      }

      msg = new Mensagem("Erro", strMsgErro, Mensagem_TIPO_NEGATIVA);
      msg.mostrar();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.processarMsgPositiva = function(strMsgPositiva) {
    // VARIÁVEIS

    var msg;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Utils.getBooStrVazia(strMsgPositiva)) {
        return false;
      }

      msg = new Mensagem("Ok " + objUsuario.getStrNome(), strMsgPositiva, Mensagem_TIPO_POSITIVA);
      msg.mostrar();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.processarObjWsInterlocutor = function(objWsInterlocutor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES
      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */
  {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrUrl(strUrl);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}