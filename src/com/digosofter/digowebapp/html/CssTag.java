package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class CssTag extends Tag {

  private static CssTag _cssMainInst;

  public static final String CSS_BORDER_TIPO_SOLID = "solid";
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
  public static final String CSS_CURSOR_REDIM_DIAG_BAIXO = "nw-resize";
  public static final String CSS_CURSOR_REDIM_DIAG_CIMA = "ne-resize";
  public static final String CSS_CURSOR_REDIM_HOR = "e-resize";
  public static final String CSS_CURSOR_REDIM_VERT = "n-resize";
  public static final String CSS_CURSOR_TEXT = "text";
  public static final String CSS_CURSOR_WAIT = "wait";
  public static final String CSS_DISPLAY_BLOCK = "block";
  public static final String CSS_DISPLAY_NONE = "none";
  public static final String CSS_DISPLAY_TABLE = "table";
  public static final String CSS_FLOAT_DIREITA = "right";

  public static final String CSS_FLOAT_ESQUERDA = "left";
  public static final String CSS_GRANDEZA_PIXEL = "px";

  public static final String CSS_GRANDEZA_PORCENTAGEM = "%";
  public static final String CSS_OVERFLOW_AUTO = "auto";
  public static final String CSS_OVERFLOW_HIDDEN = "hidden";
  public static final String CSS_OVERFLOW_INHERIT = "inherit";
  public static final String CSS_OVERFLOW_SCROLL = "scroll";

  public static final String CSS_OVERFLOW_VISIBLE = "visible";
  public static final String CSS_POSITION_ABSOLUTE = "absolute";
  public static final String CSS_POSITION_FIXED = "fixed";

  public static final String CSS_POSITION_RELATIVE = "relative";
  public static final String CSS_REPEAT = "repeat";
  public static final String CSS_REPEAT_INHERIT = "inherit";
  public static final String CSS_REPEAT_NO_REPEAT = "no-repeat";
  public static final String CSS_REPEAT_X = "repeat-x";

  public static final String CSS_REPEAT_Y = "repeat-y";
  public static final String CSS_TEXT_ALIGN_CENTRO = "center";
  public static final String CSS_TEXT_ALIGN_DIREITA = "right";

  public static final String CSS_TEXT_ALIGN_ESQUERDA = "left";

  public static final String CSS_TEXT_DECORATION_NONE = "none";

  public static CssTag getCssMainInst() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_cssMainInst == null) {
        _cssMainInst = new CssTag();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _cssMainInst;
  }

  public static void setCssMainInst(CssTag cssMainInst) {
    _cssMainInst = cssMainInst;
  }

  private List<AtributoCss> _lstAtrCss = new ArrayList<AtributoCss>();

  private String _strConteudo;

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

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public String addCss(String strCssNome, String strValor) {
    // VARI�VEIS

    AtributoCss objAtributoCssNovo;
    boolean booExiste;
    String strResultado = Utils.STRING_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      booExiste = false;

      for (AtributoCss atrCss : this.getLstAtrCss()) {

        if (atrCss.getStrNome().equals(strCssNome) && atrCss.getStrValor().equals(strValor)) {

          booExiste = true;
          strResultado = atrCss.getStrClassAssociada();
        }
      }

      if (!booExiste) {

        objAtributoCssNovo = new AtributoCss(strCssNome, strValor);
        strResultado = "c" + String.valueOf(this.getLstAtrCss().size());
        objAtributoCssNovo.setStrClassAssociada(strResultado);
        this.getLstAtrCss().add(objAtributoCssNovo);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public List<AtributoCss> getLstAtrCss() {
    return _lstAtrCss;
  }

  @Override
  public String getStrConteudo() {
    // VARI�VEIS

    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(Utils.STRING_VAZIA);

      for (AtributoCss atrCss : this.getLstAtrCss()) {

        stb.append(".");
        stb.append(atrCss.getStrClassAssociada());
        stb.append("{");
        stb.append(atrCss.getStrNome());
        stb.append(":");

        for (String strValor : atrCss.getLstStrValor()) {
          stb.append(strValor);
          stb.append(";");
        }

        stb.append("}");
      }

      _strConteudo = stb.toString();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strConteudo;
  }

  public String setBackgroundColor(String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      strResultado = this.addCss("background-color", hexColor);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBackgroundImage(String strSrcImagem) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append("url('");
      stb.append(strSrcImagem);
      stb.append("')");

      strResultado = this.addCss("background-image", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBackgroundRepeat(String strRepeat) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strRepeat);

      strResultado = this.addCss("background-repeat", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
    return strResultado;
  }

  public String setBackgroundSize(String strSize) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strSize);

      strResultado = this.addCss("background-size", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBooCenter() {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append("0 auto");

      strResultado = this.addCss("margin", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBorder(int intBorderPx, String strTipo, String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intBorderPx);
      stb.append("px ");
      stb.append(strTipo);
      stb.append(" ");
      stb.append(hexColor);

      strResultado = this.addCss("border", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBorderBottom(int intBorderBottomPx, String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intBorderBottomPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-bottom", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBorderLeft(int intBorderLeftPx, String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intBorderLeftPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-left", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
    return strResultado;
  }

  public String setBorderRadius(int intTopLeftPx, int intTopRightPx, int intBottomLeftPx,
      int intBottomRightPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intTopLeftPx);
      stb.append("px ");
      stb.append(intTopRightPx);
      stb.append("px ");
      stb.append(intBottomRightPx);
      stb.append("px ");
      stb.append(intBottomLeftPx);
      stb.append("px");

      strResultado = this.addCss("border-radius", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBorderRight(int intBorderRightPx, String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intBorderRightPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-right", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBorderTop(int intBorderTopPx, String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intBorderTopPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-top", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBottom(int intBottom) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intBottom);
      stb.append("px");

      strResultado = this.addCss("bottom", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setBoxShadow(int intHorizontal, int intVertical, int intBlur, int intSpread,
      String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intHorizontal);
      stb.append("px ");
      stb.append(intVertical);
      stb.append("px ");
      stb.append(intBlur);
      stb.append("px ");
      stb.append(intSpread);
      stb.append("px ");
      stb.append(hexColor);

      strResultado = this.addCss("box-shadow", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setClearBoth() {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      strResultado = this.addCss("clear", "both");

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setColor(String hexColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      strResultado = this.addCss("color", hexColor);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setCursor(String strCursor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      strResultado = this.addCss("cursor", strCursor);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setDisplay(String strDisplay) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strDisplay);

      strResultado = this.addCss("display", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setFloat(String strFloat) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strFloat);

      strResultado = this.addCss("float", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setFontFamily(String strFontFamily) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strFontFamily);

      strResultado = this.addCss("font-family", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setFontNegrito() {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      strResultado = this.addCss("font-Weight", "bold");

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setFontSize(int intFontSize, String strGrandeza) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intFontSize);
      stb.append(strGrandeza);

      strResultado = this.addCss("font-size", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setFontStyle(String strFontStyle) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strFontStyle);

      strResultado = this.addCss("font-style", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setHeight(double dblHeight, String strGrandeza) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(dblHeight);
      stb.append(strGrandeza);

      strResultado = this.addCss("height", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setLeft(int intLeft) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intLeft);
      stb.append("px");

      strResultado = this.addCss("left", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  protected void setLstAtrCss(List<AtributoCss> lstAtrCss) {
    _lstAtrCss = lstAtrCss;
  }

  public String setMargin(int intMarginPx, String strGrandeza) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intMarginPx);
      stb.append(strGrandeza);

      strResultado = this.addCss("margin", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setMarginBottom(int intMarginBottomPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intMarginBottomPx);
      stb.append("px");

      strResultado = this.addCss("margin-bottom", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setMarginLeft(int intMarginLeftPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intMarginLeftPx);
      stb.append("px");

      strResultado = this.addCss("margin-left", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setMarginRight(int intMarginRightPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intMarginRightPx);
      stb.append("px");

      strResultado = this.addCss("margin-right", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setMarginTop(int intMarginTopPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intMarginTopPx);
      stb.append("px");

      strResultado = this.addCss("margin-top", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setOpacity(double dblOpacity) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(dblOpacity);

      strResultado = this.addCss("opacity", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setOverflow(String strOverflowPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strOverflowPx);

      strResultado = this.addCss("overflow", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setOverflowX(String strOverflowPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strOverflowPx);

      strResultado = this.addCss("overflow-x", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setOverflowY(String strOverflowPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strOverflowPx);

      strResultado = this.addCss("overflow-y", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setPadding(int intPaddingPx, String strGrandeza) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intPaddingPx);
      stb.append(strGrandeza);

      strResultado = this.addCss("padding", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setPaddingBottom(int intPaddingBottomPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intPaddingBottomPx);
      stb.append("px");

      strResultado = this.addCss("padding-bottom", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setPaddingLeft(int intPaddingLeftPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intPaddingLeftPx);
      stb.append("px");

      strResultado = this.addCss("padding-left", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setPaddingRight(int intPaddingRightPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intPaddingRightPx);
      stb.append("px");

      strResultado = this.addCss("padding-right", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setPaddingTop(int intPaddingTopPx) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intPaddingTopPx);
      stb.append("px");

      strResultado = this.addCss("padding-top", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setPosition(String strPosition) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strPosition);

      strResultado = this.addCss("position", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setRight(int intRight) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intRight);
      stb.append("px");

      strResultado = this.addCss("right", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setTextAlign(String strTextAlign) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strTextAlign);
      strResultado = this.addCss("text-align", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setTextDecoration(String strTextDecoration) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(strTextDecoration);

      strResultado = this.addCss("text-decoration", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setTextShadow(int intX, int intY, int intBlur, String strColor) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intX);
      stb.append("px ");
      stb.append(intY);
      stb.append("px ");
      stb.append(intBlur);
      stb.append("px ");
      stb.append(strColor);

      strResultado = this.addCss("text-shadow", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setTop(int intTop) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intTop);
      stb.append("px");

      strResultado = this.addCss("top", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setWidth(double dblWidth, String strGrandeza) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(dblWidth);
      stb.append(strGrandeza);

      strResultado = this.addCss("width", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String setZ(int intZ) {
    // VARI�VEIS

    String strResultado = Utils.STRING_VAZIA;
    StringBuilder stb;

    // FIM VARI�VEIS
    try {
      // A��ES

      stb = new StringBuilder();
      stb.append(intZ);
      strResultado = this.addCss("z-index", stb.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

}
