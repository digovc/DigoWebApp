// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Tag() {
	// HERAN�A
	Objeto.apply(this);

	// ATRIBUTO
	var _booVisivel = true;
	this.getBooVisivel = function() {
		return _booVisivel;
	}
	this.setBooVisivel = function(booVisivel) {
		_booVisivel = booVisivel;
		if (_booVisivel) {
			$("#" + this.getStrId()).show();
		} else {
			$("#" + this.getStrId()).hide("slow");
		}
	}

	var _objJQuery;
	this.getObjJQuery = function() {
		_objJQuery = $("#" + this.getStrId());
		return _objJQuery;
	}

	var _strId;
	this.getStrId = function() {
		return _strId;
	}
	this.setStrId = function(strId) {
		_strId = strId;
	}

	// M�TODO

	/* Construtor */
	{
		// VARI�VEL
		// A��O
	}

}