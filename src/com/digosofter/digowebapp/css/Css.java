package com.digosofter.digowebapp.css;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;

public abstract class Css {
	// CONSTANTES

	public enum EnmCssAtributo {
		PADDING_BOTTOM
	}

	// FIM CONSTANTES

	// ATRIBUTOS

	private static CssTag _cssMain;

	public static CssTag getCssMain() {
		if (_cssMain == null) {
			_cssMain = new CssTag();
			_cssMain.setStrId("cssMain");
		}
		return _cssMain;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// M�TODOS

	public static String addCss(EnmCssAtributo enmCssAtributo, String strValor) {
		// VARI�VEIS

		String strClassRelacionadaResultado = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES
			
			
			
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassRelacionadaResultado;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
