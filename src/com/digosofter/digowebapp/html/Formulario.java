package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Formulario extends Tag {
	// CONSTANTES

	public enum EnmMetodo {
		GET, POST
	}

	// FIM CONSTANTES

	// ATRIBUTOS

	private EnmMetodo _enmMetodo = EnmMetodo.POST;

	private EnmMetodo getEnmMetodo() {
		return _enmMetodo;
	}

	private void setEnmMetodo(EnmMetodo enmMetodo) {
		// VARI�VEIS

		String strMetodo = "get";

		// FIM VARI�VEIS
		try {
			// A��ES

			_enmMetodo = enmMetodo;
			switch (_enmMetodo) {
			case GET:
				strMetodo = "get";
				break;
			case POST:
				strMetodo = "post";
				break;
			default:
				strMetodo = "get";
				break;
			}
			this.getLstAtr().add(new Atributo("method", strMetodo));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strAction;

	private String getStrAction() {
		return _strAction;
	}

	private void setStrAction(String strAction) {
		_strAction = strAction;
		this.getLstAtr().add(new Atributo("action", _strAction));
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Formulario(String strAction, EnmMetodo enmMetodo) {
		// VARI�VEIS
		
		JavaScriptTag objJsFormulario = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Formulario.js");

		// FIM VARI�VEIS
		try {
			// A��ES
			
			this.setStrTagNome("form");
			this.setStrAction(strAction);
			this.setEnmMetodo(enmMetodo);

			PaginaHtml.getPagHtmlInstancia().getLstObjJavaScriptTag().add(objJsFormulario);
			
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
