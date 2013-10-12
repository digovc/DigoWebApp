package com.digosofter.digowebapp.css;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Atributo;
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

		Atributo atrCss = null;
		String strClassRelacionadaResultado = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			atrCss = new Atributo(Css.getStrAtrNomePeloEnmCssAtr(enmCssAtributo), strValor);
			Css.getCssMain().getLstAtrCss().add(atrCss);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassRelacionadaResultado;
	}

	private static String getStrAtrNomePeloEnmCssAtr(EnmCssAtributo enmCssAtributo) {
		// VARI�VEIS

		String strAtrNomeResultado = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			switch (enmCssAtributo) {
			case PADDING_BOTTOM:
				strAtrNomeResultado = "padding-bottom";
				break;
			default:
				throw new Exception("Atributo CSS n�o implementado");
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strAtrNomeResultado;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
