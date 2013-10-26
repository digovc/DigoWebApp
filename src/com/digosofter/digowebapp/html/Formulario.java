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
		// VARIÁVEIS

		String strMetodo = "get";

		// FIM VARIÁVEIS
		try {
			// AÇÕES

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

			// FIM AÇÕES
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
		// VARIÁVEIS
		
		JavaScriptTag objJsFormulario = new JavaScriptTag("res/lib/DigoWebAppLib/js/html/Formulario.js");

		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.setStrTagNome("form");
			this.setStrAction(strAction);
			this.setEnmMetodo(enmMetodo);

			PaginaHtml.getPagHtmlInstancia().getLstObjJavaScriptTag().add(objJsFormulario);
			
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
