package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Formulario extends Tag {

	public enum EnmMetodo {
		GET, POST
	}





	private EnmMetodo _enmMetodo = EnmMetodo.POST;

	private String _strAction;

	public Formulario(String strAction, EnmMetodo enmMetodo) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTagNome("form");
			this.setStrAction(strAction);
			this.setEnmMetodo(enmMetodo);

			PaginaHtml
					.getI()
					.getLstObjJavaScriptTag()
					.add(new JavaScriptTag(
							"res/js/lib/JDigo/html/Formulario.js"));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private EnmMetodo getEnmMetodo() {
		return _enmMetodo;
	}

	private String getStrAction() {
		return _strAction;
	}

	private void setEnmMetodo(EnmMetodo enmMetodo) {
		// VARIÁVEIS

		String strMetodo;

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





	private void setStrAction(String strAction) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_strAction = strAction;
			this.getLstAtr().add(new Atributo("action", _strAction));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}








}
