// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 * 
 */
function Formulario() {
	// HERAN�A
	
	Tag.apply(this);
	Objeto.apply(this);
	
	// FIM HERAN�A

	// ATRIBUTO
	// FIM ATRIBUTO

	// M�TODO
	
	this.enviar = function() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.getJq().submit();
			
			// FIM A��ES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	
	// FIM M�TODO

	/* Construtor */{
		// VARI�VEL
		// A��O
	}

}
// INICIALIZA��O

// var objFormulario;
// $(document).ready(function() {
//	objFormulario = new Formulario();
// });

// FIM INICIALIZA��O