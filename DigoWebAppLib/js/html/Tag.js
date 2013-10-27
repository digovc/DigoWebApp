// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Tag() {
	// HERANÇA
	Objeto.apply(this);

	// ATRIBUTO
	var _booVisivel = true;
	this.getBooVisivel = function() {
		return _booVisivel;
	}
	this.setBooVisivel = function(booVisivel) {
		_booVisivel = booVisivel;
		if (_booVisivel) {
			$("#" + this.getStrId()).slideDown("fast");
		} else {
			$("#" + this.getStrId()).slideUp("slow");
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

	// MÉTODO

	/* Construtor */
	{
		// VARIÁVEL
		// AÇÃO
	}

}