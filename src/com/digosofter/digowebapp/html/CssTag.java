package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class CssTag extends Tag {
	// CONSTANTES

	public static final String CSS_BORDER_TIPO_SOLID = "solid";

	public static final String CSS_DISPLAY_BLOCK = "block";
	public static final String CSS_DISPLAY_NONE = "none";
	public static final String CSS_DISPLAY_TABLE = "table";

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

	public static final String CSS_CURSOR_AJUDA = "help";
	public static final String CSS_CURSOR_CRUZ = "crosshair";
	public static final String CSS_CURSOR_MOVER = "move";
	public static final String CSS_CURSOR_POINTER = "pointer";
	public static final String CSS_CURSOR_PROGRESS = "progress";
	public static final String CSS_CURSOR_REDIM_DIAG_CIMA = "ne-resize";
	public static final String CSS_CURSOR_REDIM_DIAG_BAIXO = "nw-resize";
	public static final String CSS_CURSOR_REDIM_HOR = "e-resize";
	public static final String CSS_CURSOR_REDIM_VERT = "n-resize";
	public static final String CSS_CURSOR_WAIT = "wait";
	public static final String CSS_CURSOR_TEXT = "text";

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
		// VARIÁVEIS

		StringBuilder strBuilder = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

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

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return _strConteudo;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public CssTag() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTagNome("style");
			this.setBooForcarTagDupla(true);
			this.getLstAtr().add(new Atributo("type", "text/css"));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS

	public String addCss(String strCssNome, String strValor) {
		// VARIÁVEIS

		AtributoCss atrCssNovo = null;
		boolean booExiste = false;
		String strClassAssociadaResultado = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

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

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociadaResultado;
	}

	public String setBackgroundColor(String hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strClassAssociada = this.addCss("background-color", hexColor);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBooCenter() {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append("0 auto");

			strClassAssociada = this.addCss("margin", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorder(int intBorderPx, String strTipo, String hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intBorderPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(strTipo);
			strBulderValorEstrutura.append(" ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderBottom(int intBorderBottomPx, String hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intBorderBottomPx);
			strBulderValorEstrutura.append("px solid ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-bottom", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderLeft(int intBorderLeftPx, String hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intBorderLeftPx);
			strBulderValorEstrutura.append("px solid ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-left", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderRadius(int intBorderRadiusTopLeftPx, int intBorderRadiusTopRightPx, int intBorderRadiusBottomLeftPx,
			int intBorderRadiusBottomRightPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intBorderRadiusTopLeftPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intBorderRadiusTopRightPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intBorderRadiusBottomRightPx);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intBorderRadiusBottomLeftPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("border-radius", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderRight(int intBorderRightPx, String hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intBorderRightPx);
			strBulderValorEstrutura.append("px solid ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-right", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBorderTop(int intBorderTopPx, String hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intBorderTopPx);
			strBulderValorEstrutura.append("px solid ");
			strBulderValorEstrutura.append(hexColor);

			strClassAssociada = this.addCss("border-top", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBottom(int intBottom) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intBottom);

			strClassAssociada = this.addCss("bottom", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setBoxShadow(int intHorizontal, int intVertical, int intBlur, int intSpread, int hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

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

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setClearBoth() {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strClassAssociada = this.addCss("clear", "both");

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setColor(String hexColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strClassAssociada = this.addCss("color", hexColor);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setCursor(String strCursor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strClassAssociada = this.addCss("cursor", strCursor);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setDisplay(String strDisplay) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(strDisplay);

			strClassAssociada = this.addCss("display", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setFloat(String strFloat) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(strFloat);

			strClassAssociada = this.addCss("float", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setFontFamily(String strFontFamily) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(strFontFamily);

			strClassAssociada = this.addCss("font-family", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setFontNegrito() {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strClassAssociada = this.addCss("font-Weight", "bold");

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setFontSize(int intFontSize, String strGrandeza) {
		// VARIÁVEIS
		
		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();
		
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			strBulderValorEstrutura.append(intFontSize);
			strBulderValorEstrutura.append(strGrandeza);
			
			strClassAssociada = this.addCss("font-size", strBulderValorEstrutura.toString());
			
			// FIM AÇÕES
		} catch (Exception ex) {
			
			new Erro("Erro inesperado.\n", ex);
			
		} finally {
		}
		return strClassAssociada;
	}
	
	public String setHeight(int intHeight, String strGrandeza) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intHeight);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("height", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setLeft(int intLeft) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intLeft);

			strClassAssociada = this.addCss("left", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setMargin(int intMarginPx, String strGrandeza) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intMarginPx);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("margin", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginBottom(int intMarginBottomPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intMarginBottomPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-bottom", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginLeft(int intMarginLeftPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intMarginLeftPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-left", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginRight(int intMarginRightPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intMarginRightPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-right", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setMarginTop(int intMarginTopPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intMarginTopPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("margin-top", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setPadding(int intPaddingPx, String strGrandeza) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intPaddingPx);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("padding", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingBottom(int intPaddingBottomPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intPaddingBottomPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-bottom", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingLeft(int intPaddingLeftPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intPaddingLeftPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-left", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingRight(int intPaddingRightPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intPaddingRightPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-right", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setPaddingTop(int intPaddingTopPx) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intPaddingTopPx);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("padding-top", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setPosition(String strPosition) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(strPosition);

			strClassAssociada = this.addCss("position", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setRight(int intRight) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intRight);

			strClassAssociada = this.addCss("right", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setTextAlign(String strTextAlign) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(strTextAlign);

			strClassAssociada = this.addCss("text-align", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setTextShadow(int intX, int intY, int intBlur, String strColor) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intX);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intY);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(intBlur);
			strBulderValorEstrutura.append("px ");
			strBulderValorEstrutura.append(strColor);

			strClassAssociada = this.addCss("text-shadow", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setTop(int intTop) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(intTop);
			strBulderValorEstrutura.append("px");

			strClassAssociada = this.addCss("top", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	public String setWidth(double dblWidth, String strGrandeza) {
		// VARIÁVEIS

		String strClassAssociada = Utils.STRING_VAZIA;
		StringBuilder strBulderValorEstrutura = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strBulderValorEstrutura.append(dblWidth);
			strBulderValorEstrutura.append(strGrandeza);

			strClassAssociada = this.addCss("width", strBulderValorEstrutura.toString());

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strClassAssociada;
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
