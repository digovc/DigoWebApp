// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE
function PaletaCor(strNome) {
	// HERAN�A

	Objeto.apply(this);

	// FIM HERAN�A

	// ATRIBUTO

	var _strCorControleClicado = "";
	this.getStrCorControleClicado = function() {
		return _strCorControleClicado;
	}
	this.setStrCorControleClicado = function(strCorControleClicado) {
		_strCorControleClicado = strCorControleClicado;
	}

	var _strCorControleMouse = "";
	this.getStrCorControleMouse = function() {
		return _strCorControleMouse;
	}
	this.setStrCorControleMouse = function(strCorControleMouse) {
		_strCorControleMouse = strCorControleMouse;
	}

	var _strCorControleNormal = "";
	this.getStrCorControleNormal = function() {
		return _strCorControleNormal;
	}
	this.setStrCorControleNormal = function(strCorControleNormal) {
		_strCorControleNormal = strCorControleNormal;
	}

	var _strCorFundo = "";
	this.getStrCorFundo = function() {
		return _strCorFundo;
	}
	this.setStrCorFundo = function(strCorFundo) {
		_strCorFundo = strCorFundo;
	}

	// FIM ATRIBUTO

	// M�TODO
	// FIM M�TODO

	/* Construtor */
	{
		// VARI�VEL
		// A��O

		this.setStrNome(strNome);
		appWeb.getArrObjPaletaCor()[appWeb.getArrObjPaletaCor().length] = this;
	}

}
// INICIALIZA��O
// FIM INICIALIZA��O
