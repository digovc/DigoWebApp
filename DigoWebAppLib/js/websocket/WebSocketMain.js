// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function WebSocketMain(strUrl) {
	// HERANÇA

	Objeto.apply(this);

	// FIM HERANÇA

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

	// MÉTODO

	this.abrirConexao = function() {
		// VARIÁVEIS
		try {
			// AÇÕES
			this.getObjWebSocket();

		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	this.enviar = function(objWsObjetoMain) {
		// VARIÁVEIS
		try {
			// AÇÕES

			this.getObjWebSocket().send(JSON.stringify(objWsObjetoMain));

		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM MÉTODO

	/* Construtor */
	{
		// VARIÁVEL
		// AÇÃO

		this.setStrUrl(strUrl);
	}

}

// INICIALIZAÇÃO
// FIM INICIALIZAÇÃO
