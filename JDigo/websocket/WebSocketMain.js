// CONSTANTE

var WebSocketMain_FNC_MSG_ERRO = 70000;
var WebSocketMain_FNC_MSG_POSITIVA = 701000;

// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function WebSocketMain(strUrl) {
  // HERAN�A
  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  var _fncOnMessage = null;

  /**
   * M�todo que deve ser implementado pela classe de inst�ncia para receber e
   * processar as mensagens vindas do servidor.
   */
  this.getFncOnMessage = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_fncOnMessage == null) {

        _fncOnMessage = function(evt) {
          // VARI�VEIS

          var objWsInterlocutor;

          // FIM VARI�VEIS
          try {
            // A��ES

            objWsInterlocutor = JSON.parse(evt.data);
            _this.processarObjWsInterlocutor(objWsInterlocutor);

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

    return _fncOnMessage;
  };

  var _objWebSocket = null;

  this.getObjWebSocket = function() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (!"WebSocket" in window) {
        new Erro(STR_MENSAGEM_00001, null);
      }

      if (_objWebSocket == null) {

        _objWebSocket = new WebSocket(this.getStrUrl());
        _objWebSocket.onmessage = this.getFncOnMessage();
      }

      // FIM A��ES
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

  // M�TODO

  this.abrirConexao = function() {
    // VARI�VEIS
    try {
      // A��ES

      this.getObjWebSocket();

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.enviar = function(objWsInterlocutor) {
    // VARI�VEIS
    try {
      // A��ES

      this.getObjWebSocket().send(JSON.stringify(objWsInterlocutor));

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.processarMsgErro = function(strMsgErro) {
    // VARI�VEIS

    var msg;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (Utils.getBooStrVazia(strMsgErro)) {
        return false;
      }

      msg = new Mensagem("Erro", strMsgErro, Mensagem_TIPO_NEGATIVA);
      msg.mostrar();

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.processarMsgPositiva = function(strMsgPositiva) {
    // VARI�VEIS

    var msg;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (Utils.getBooStrVazia(strMsgPositiva)) {
        return false;
      }

      msg = new Mensagem("Ok " + objUsuario.getStrNome(), strMsgPositiva, Mensagem_TIPO_POSITIVA);
      msg.mostrar();

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.processarObjWsInterlocutor = function(objWsInterlocutor) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES
      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM M�TODO

  /* Construtor */
  {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrUrl(strUrl);

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}