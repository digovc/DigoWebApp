// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 * 
 */
function Formulario() {
	// HERANÇA
	
	Tag.apply(this);
	Objeto.apply(this);
	
	// FIM HERANÇA

	// ATRIBUTO
	// FIM ATRIBUTO

	// MÉTODO
	
	this.enviar = function() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.getJq().submit();
			
			// FIM AÇÕES
		} catch (e) {
			new Erro("Erro inesperado.", e);
		}
	}
	
	// FIM MÉTODO

	/* Construtor */{
		// VARIÁVEL
		// AÇÃO
	}

}
// INICIALIZAÇÃO

// var objFormulario;
// $(document).ready(function() {
//	objFormulario = new Formulario();
// });

// FIM INICIALIZAÇÃO