// CONSTANTE
// ATRIBUTOS GLOBAIS
var Objeto_intId = 0;
// CLASSE
function Objeto() {
	// HERAN�A

	// ATRIBUTO

	var _intId = 0;
	this.getIntId = function() {
		return _intId;
	}
	var setIntId = function(intId) {
		_intId = intId;
	}

	// M�TODO

	/* Construtor */
	{
		// VARI�VEL
		// A��O
		Objeto_intId++;
		setIntId(Objeto_intId);
	}

}