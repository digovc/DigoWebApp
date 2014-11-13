// CONSTANTE

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
    
    
    try {
      

      if (_fncOnMessage == null) {

        _fncOnMessage = function(evt) {
          

          var objWsInterlocutor;

          
          try {
            

            objWsInterlocutor = JSON.parse(evt.data);
            _this.processarObjWsInterlocutor(objWsInterlocutor);

            
          } catch (e) {
            new Erro("Erro inesperado.", e);
          }
        };

      }

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _fncOnMessage;
  };

  var _objWebSocket = null;

  this.getObjWebSocket = function() {
    
    
    try {
      

      if (!"WebSocket" in window) {
        new Erro(STR_MENSAGEM_00001, null);
      }

      if (_objWebSocket == null) {

        _objWebSocket = new WebSocket(this.getStrUrl());
        _objWebSocket.onmessage = this.getFncOnMessage();
      }

      
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
    
    
    try {
      
      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */
  {
    
    
    try {
      

      this.setStrUrl(strUrl);

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}