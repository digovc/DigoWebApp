// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function Tag() {
	// HERAN�A

	Objeto.apply(this);

	// FIM HERAN�A

	// ATRIBUTO

	var _booVisivel = true;
	this.getBooVisivel = function() {
		return _booVisivel;
	}
	this.setBooVisivel = function(booVisivel) {
		_booVisivel = booVisivel;
		if (_booVisivel) {
			$("#" + this.getStrId()).slideDown("100");
		} else {
			$("#" + this.getStrId()).slideUp("100");
		}
	}

	var _fncOnClick;
	this.getFncOnClick = function() {
		return _fncOnClick;
	}
	this.setFncOnClick = function(fncOnClick) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			_fncOnClick = fncOnClick;
			
			this.getJq().click(_fncOnClick);
			
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	
	this.click = function(fncOnClick) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setFncOnClick(fncOnClick);
			
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	
	var _fncKeyDown;
	this.getFncKeyDown = function() {
		return _fncKeyDown;
	}
	this.setFncKeyDown = function(fncKeyDown) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			_fncKeyDown = fncKeyDown;
			
			this.getJq().keydown(_fncKeyDown);
			
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	
	this.keyDown = function(fncKeyDown) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setFncKeyDown(fncKeyDown);
			
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	
	var _fncKeyPress;
	this.getFncKeyPress = function() {
		return _fncKeyPress;
	}
	this.setFncKeyPress = function(fncKeyPress) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			_fncKeyPress = fncKeyPress;
			
			this.getJq().keypress(_fncKeyPress);
			
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	
	this.keyPress = function(fncKeyPress) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setFncKeyPress(fncKeyPress);
			
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	var _fncKeyUp;
	this.getFncKeyUp = function() {
		return _fncKeyUp;
	}
	this.setFncKeyUp = function(fncKeyUp) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_fncKeyUp = fncKeyUp;

			this.getJq().keyup(_fncKeyUp);

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	this.keyUp = function(fncKeyUp) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setFncKeyUp(fncKeyUp);

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	var _objJQuery;
	this.getObjJQuery = function() {
		_objJQuery = $("#" + this.getStrId());
		return _objJQuery;
	}
	this.getJQuery = function() {
		return this.getObjJQuery();
	}
	this.getJQ = function() {
		return this.getObjJQuery();
	}
	this.getJq = function() {
		return this.getObjJQuery();
	}

	var _strId;
	this.getStrId = function() {
		return _strId;
	}
	this.setStrId = function(strId) {
		_strId = strId;
	}

	var _strPlaceholder = "";
	this.getStrPlaceholder = function() {

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strPlaceholder = this.getJq().attr("placeholder");

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return _strPlaceholder;
	}
	this.setStrPlaceholder = function(strPlaceholder) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strPlaceholder = strPlaceholder;

			this.getJq().attr("placeholder", _strPlaceholder);

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	var _strTitle = "";
	this.getStrTitle = function() {

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strTitle = this.getJq().attr("title");

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}

		return _strTitle;
	}
	this.setStrTitle = function(strTitle) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_strTitle = strTitle;

			this.getJq().attr("title", _strTitle);

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	this.setStrTitulo = function(strTitle) {
		this.setStrTitle(strTitle);
	}

	// FIM ATRIBUTO

	// M�TODO

	this.addStrConteudo = function(strConteudo) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			$("#" + this.getStrId()).append(strConteudo);

			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}

	// FIM M�TODO

	/* Construtor */
	{
		// VARI�VEL
		// A��O
	}

}