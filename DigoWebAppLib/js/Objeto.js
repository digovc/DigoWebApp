// CONSTANTE
// ATRIBUTOS GLOBAIS
var Objeto_intId = 0;
// CLASSE
function Objeto() {
	// HERANÇA

	// ATRIBUTO

	var _intId = 0;
	this.getIntId = function() {
		return _intId;
	}
	var setIntId = function(intId) {
		_intId = intId;
	}

	// MÉTODO

	/* Construtor */
	{
		// VARIÁVEL
		// AÇÃO
		Objeto_intId++;
		setIntId(Objeto_intId);
	}

}