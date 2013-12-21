// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function WebSocketMain(strUrl) {
	// HERAN�A

	Objeto.apply(this);

	// FIM HERAN�A

	// ATRIBUTO

	var _fncOnMessage;
	this.getFncOnMessage = function() {
		return _fncOnMessage;
	}
	this.setFncOnMessage = function(fncOnMessage) {
		_fncOnMessage = fncOnMessage;
	}

	var _objWebSocket;
	this.getObjWebSocket = function() {
		if (!"WebSocket" in window) {
			new Erro(STR_MENSAGEM_00001, null);
		}

		if (_objWebSocket == null) {
			_objWebSocket = new WebSocket(this.getStrUrl());

			_objWebSocket.onmessage = this.getFncOnMessage();
		}

		return _objWebSocket;
	}

	var _strUrl = "";
	this.getStrUrl = function() {
		return _strUrl + "?" + appWeb.getStrSessionId();
	}
	this.setStrUrl = function(strUrl) {
		_strUrl = strUrl;
	}

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
	}

	this.enviar = function(objWsObjetoMain) {
		// VARI�VEIS
		try {
			// A��ES

			this.getObjWebSocket().send(JSON.stringify(objWsObjetoMain));

		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM M�TODO

	/* Construtor */
	{
		// VARI�VEL
		// A��O

		this.setStrUrl(strUrl);
	}

}

// INICIALIZA��O
// FIM INICIALIZA��O
