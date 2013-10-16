package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class CssTag extends Tag {
	// CONSTANTES

	public static final String CSS_BORDER_TIPO_SOLID = "solid";

	public static final String CSS_FLOAT_DIREITA = "right";
	public static final String CSS_FLOAT_ESQUERDA = "left";

	public static final String CSS_COR_AMARELO = "#FFFF00";
	public static final String CSS_COR_AZUL = "#0000FF";
	public static final String CSS_COR_BRANCO = "#FFFFFF";
	public static final String CSS_COR_CINZA = "#C0C0C0";
	public static final String CSS_COR_GRAY = "#808080";
	public static final String CSS_COR_LARANJA = "#FFA500";
	public static final String CSS_COR_PRETO = "#000";
	public static final String CSS_COR_VERDE = "#008000";
	public static final String CSS_COR_VERMERLHO = "#FF0000";

	public static final String CSS_GRANDEZA_PORCENTAGEM = "%";
	public static final String CSS_GRANDEZA_PIXEL = "px";

	public static final String CSS_POSITION_ABSOLUTE = "absolute";
	public static final String CSS_POSITION_FIXED = "fixed";
	public static final String CSS_POSITION_RELATIVE = "relative";

	public static final String CSS_TEXT_ALIGN_CENTRO = "center";
	public static final String CSS_TEXT_ALIGN_DIREITA = "right";
	public static final String CSS_TEXT_ALIGN_ESQUERDA = "left";

	// FIM CONSTANTES

	// ATRIBUTOS

	private static CssTag _cssMainInstancia;

	public static CssTag getCssMainInstancia() {
		return _cssMainInstancia;
	}

	public void setCssMainInstancia(CssTag cssMainInstancia) {
		_cssMainInstancia = cssMainInstancia;
	}

	private List<AtributoCss> _lstAtrCss = new ArrayList<AtributoCss>();

	public List<AtributoCss> getLstAtrCss() {
		return _lstAtrCss;
	}

	private void setLstAtrCss(List<AtributoCss> lstAtrCss) {
		_lstAtrCss = lstAtrCss;
	}

	private String _strConteudo;

	@Override
	public String getStrConteudo() {
		// VARI�VEIS

		StringBuilder strBuilder = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBuilder.append(Utils.STRING_VAZIA);
			for (AtributoCss atrCss : this.getLstAtrCss()) {
				strBuilder.append(".");
				strBuilder.append(atrCss.getStrClassAssociada());
				strBuilder.append("{");
				strBuilder.append(atrCss.getStrNome());
				strBuilder.append(":");
				for (String strValor : atrCss.getLstStrValor()) {
					strBuilder.append(strValor);
					strBuilder.append(";");
				}
				strBuilder.append("}");
			}
			_strConteudo = strBuilder.toString();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return _strConteudo;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public CssTag() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrTagNome("style");
			this.setBooForcarTagDupla(true);
			this.getLstAtr().add(new Atributo("type", "text/css"));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public String addCss(String strCssNome, String strValor) {
		// VARI�VEIS

		AtributoCss atrCssNovo = null;
		boolean booExiste = false;
		String strClassAssociadaResultado = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (AtributoCss atrCss : this.getLstAtrCss()) {
				if (atrCss.getStrNome().equals(strCssNome) && atrCss.getStrValor().equals(strValor)) { 
					booExiste = true;
					strClassAssociadaResultado = atrCss.getStrClassAssociada();
				}
			}

			if (!booExiste) {
				atrCssNovo = new AtributoCss(strCssNome, strValor);
				strClassAssociadaResultado = "c" + String.valueOf(this.getLstAtrCss().size());
				atrCssNovo.setStrClassAssociada(strClassAssociadaResultado);
				this.getLstAtrCss().add(atrCssNovo);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociadaResultado;
	}

	public String setBackgroundColor(String hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			strClassAssociada = this.addCss("background-color", hexColor);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBooCenter() {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append("0 auto");

			strClassAssociada = this.addCss("margin", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorder(int intBorderPx, String strTipo, String hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intBorderPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(strTipo);
			strBulderValorEstrutura.append(" ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderBottom(int intBorderBottomPx, String hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intBorderBottomPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-bottom", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderLeft(int intBorderLeftPx, String hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intBorderLeftPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-left", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderRadius(int intBorderRadiusTopLeftPx, int intBorderRadiusTopRightPx, int intBorderRadiusBottomLeftPx,
			int intBorderRadiusBottomRightPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intBorderRadiusTopLeftPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intBorderRadiusTopRightPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intBorderRadiusBottomRightPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intBorderRadiusBottomLeftPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("border-radius", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderRight(int intBorderRightPx, String hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intBorderRightPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-right", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderTop(int intBorderTopPx, String hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intBorderTopPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-top", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBottom(int intBottom) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intBottom);

			strClassAssociada = this.addCss("bottom", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setBoxShadow(int intHorizontal, int intVertical, int intBlur, int intSpread, int hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intHorizontal);
			strBulderValorEstrutura.append(" ");
			strBulderValorEstrutura.append(intVertical);
			strBulderValorEstrutura.append(" ");
			strBulderValorEstrutura.append(intBlur);
			strBulderValorEstrutura.append(" ");
			strBulderValorEstrutura.append(intSpread);
			strBulderValorEstrutura.append(" ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("box-shadow", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setClearBoth() {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			strClassAssociada = this.addCss("clear", "both");

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setColor(String hexColor) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			strClassAssociada = this.addCss("color", hexColor);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setFloat(String strFloat) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(strFloat);

			strClassAssociada = this.addCss("float", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setHeight(int intHeight, String strGrandeza) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intHeight);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("height", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setLeft(int intLeft) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intLeft);

			strClassAssociada = this.addCss("left", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setMargin(int intMarginPx, String strGrandeza) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intMarginPx);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("margin", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginBottom(int intMarginBottomPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intMarginBottomPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-bottom", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginLeft(int intMarginLeftPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intMarginLeftPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-left", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginRight(int intMarginRightPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intMarginRightPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-right", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginTop(int intMarginTopPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intMarginTopPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-top", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setPadding(int intPaddingPx, String strGrandeza) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intPaddingPx);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("padding", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingBottom(int intPaddingBottomPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intPaddingBottomPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-bottom", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingLeft(int intPaddingLeftPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intPaddingLeftPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-left", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingRight(int intPaddingRightPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intPaddingRightPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-right", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingTop(int intPaddingTopPx) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intPaddingTopPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-top", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setPosition(String strPosition) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(strPosition);

			strClassAssociada = this.addCss("position", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setRight(int intRight) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intRight);

			strClassAssociada = this.addCss("right", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setTextAlign(String strTextAlign) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(strTextAlign);

			strClassAssociada = this.addCss("text-align", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setTop(int intTop) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(intTop);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("top", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	public String setWidth(double dblWidth, String strGrandeza) {
		// VARI�VEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBulderValorEstrutura.append(dblWidth);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("width", strBulderValorEstrutura.toString());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strClassAssociada;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
