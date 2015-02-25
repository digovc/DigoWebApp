package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public class CssTag extends Tag {

  private static CssTag _iMain;

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

  public static final String CSS_WHITE_SPACE_NOWRAP = "nowrap";

  public static CssTag getIMain() {

    try {

      if (_iMain != null) {

        return _iMain;
      }

      _iMain = new CssTag();

      _iMain.addCssPuro("::-webkit-scrollbar-corner{background-color:rgb(239,239,239)}");
      _iMain.addCssPuro("::-webkit-scrollbar-thumb{background-color:rgb(215, 215, 215);border:1px solid rgb(195,195,195)}");
      _iMain.addCssPuro("::-webkit-scrollbar-track{background-color:rgb(239,239,239)}");
      _iMain.addCssPuro("::-webkit-scrollbar{height:12px;width:12px}");
      _iMain.addCssPuro("a{color:#428bca;text-decoration:none}");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _iMain;
  }

  public static void setCssMainInst(CssTag cssMainInst) {

    _iMain = cssMainInst;
  }

  private String _cssPuro;
  private List<AtributoCss> _lstAtrCss;
  private String _strConteudo;

  public CssTag() {

    super("style");

    try {

      this.setBooForcarTagDupla(true);
      this.getLstAtr().add(new Atributo("type", "text/css"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public String addCss(String strCssNome, String strValor) {

    AtributoCss objAtributoCssNovo;
    String strResultado = Utils.STR_VAZIA;

    try {

      for (AtributoCss atrCss : this.getLstAtrCss()) {

        if (atrCss.getStrNome().equals(strCssNome) && atrCss.getStrValor().equals(strValor)) {

          return atrCss.getStrClassAssociada();
        }
      }

      strResultado = "c" + String.valueOf(this.getLstAtrCss().size());

      objAtributoCssNovo = new AtributoCss(strCssNome, strValor);

      objAtributoCssNovo.setStrClassAssociada(strResultado);

      this.getLstAtrCss().add(objAtributoCssNovo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  private void addCssPuro(String css) {

    try {

      if (Utils.getBooStrVazia(css)) {

        return;
      }

      this.setCssPuro(this.getCssPuro().concat(css));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private String getCssPuro() {

    try {

      if (!Utils.getBooStrVazia(_cssPuro)) {

        return _cssPuro;
      }

      _cssPuro = Utils.STR_VAZIA;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _cssPuro;
  }

  public List<AtributoCss> getLstAtrCss() {

    try {

      this.setStrConteudo(Utils.STR_VAZIA);

      if (_lstAtrCss != null) {

        return _lstAtrCss;
      }

      _lstAtrCss = new ArrayList<AtributoCss>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstAtrCss;
  }

  @Override
  public String getStrConteudo() {

    String strAttCss;

    try {

      if (!Utils.getBooStrVazia(_strConteudo)) {

        return _strConteudo;
      }

      _strConteudo = Utils.STR_VAZIA;

      for (AtributoCss atrCss : this.getLstAtrCss()) {

        strAttCss = "._class_nome{_att_nome:_att_valor}";

        strAttCss = strAttCss.replace("_class_nome", atrCss.getStrClassAssociada());
        strAttCss = strAttCss.replace("_att_nome", atrCss.getStrNome());
        strAttCss = strAttCss.replace("_att_valor", atrCss.getStrValor());

        _strConteudo += strAttCss;
      }

      _strConteudo += this.getCssPuro();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strConteudo;
  }

  @Override
  public String getStrTagFormatada() {

    try {

      this.verificarCssExterna();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return super.getStrTagFormatada();
  }

  public String setBackgroundColor(String hexColor) {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = this.addCss("background-color", hexColor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBackgroundGradiente(String hexColor1, String hexColor2) {

    String strResultado = Utils.STR_VAZIA;
    String css;

    try {

      css = "linear-gradient(to bottom,_cor_1,_cor_2)";

      css = css.replace("_cor_1", hexColor1);
      css = css.replace("_cor_2", hexColor2);

      strResultado = this.addCss("background", css);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBackgroundImage(String strSrcImagem) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append("url('");
      stb.append(strSrcImagem);
      stb.append("')");

      strResultado = this.addCss("background-image", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBackgroundRepeat(String strRepeat) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strRepeat);

      strResultado = this.addCss("background-repeat", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBackgroundSize(String strSize) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strSize);

      strResultado = this.addCss("background-size", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBooCenter() {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append("0 auto");

      strResultado = this.addCss("margin", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBorder(int intBorderPx, String strTipo, String hexColor) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intBorderPx);
      stb.append("px ");
      stb.append(strTipo);
      stb.append(" ");
      stb.append(hexColor);

      strResultado = this.addCss("border", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBorderBottom(int intBorderBottomPx, String hexColor) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intBorderBottomPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-bottom", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBorderLeft(int intBorderLeftPx, String hexColor) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intBorderLeftPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-left", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBorderRadius(int intTopLeftPx, int intTopRightPx, int intBottomRightPx, int intBottomLeftPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

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
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBorderRight(int intBorderRightPx, String hexColor) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intBorderRightPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-right", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBorderTop(int intBorderTopPx, String hexColor) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intBorderTopPx);
      stb.append("px solid ");
      stb.append(hexColor);

      strResultado = this.addCss("border-top", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBottom(int intBottom) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intBottom);
      stb.append("px");

      strResultado = this.addCss("bottom", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setBoxShadow(int intHorizontal, int intVertical, int intBlur, int intSpread, String hexColor) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

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
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setClearBoth() {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = this.addCss("clear", "both");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setColor(String hexColor) {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = this.addCss("color", hexColor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  /**
   * Não remover! Este método tem de ser sob-escrito da classe pai para que não
   * haja um loop infinito. E também porque esta tag não precisa de layout.
   */
  @Override
  protected void setCss(CssTag tagCss) {

  }

  private void setCssPuro(String cssPuro) {

    _cssPuro = cssPuro;
  }

  public String setCursor(String strCursor) {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = this.addCss("cursor", strCursor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setDisplay(String strDisplay) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strDisplay);

      strResultado = this.addCss("display", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setFloat(String strFloat) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strFloat);

      strResultado = this.addCss("float", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setFontFamily(String strFontFamily) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strFontFamily);

      strResultado = this.addCss("font-family", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setFontNegrito() {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = this.addCss("font-weight", "bold");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setFontSize(double dblFontSize, String strGrandeza) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(dblFontSize);
      stb.append(strGrandeza);

      strResultado = this.addCss("font-size", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setFontStyle(String strFontStyle) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strFontStyle);

      strResultado = this.addCss("font-style", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setHeight(double dblHeight, String strGrandeza) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(dblHeight);
      stb.append(strGrandeza);

      strResultado = this.addCss("height", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setLeft(int intLeft) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intLeft);
      stb.append("px");

      strResultado = this.addCss("left", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  protected void setLstAtrCss(List<AtributoCss> lstAtrCss) {

    _lstAtrCss = lstAtrCss;
  }

  public String setMargin(int intMargin, String strGrandeza) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intMargin);
      stb.append(strGrandeza);

      strResultado = this.addCss("margin", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setMarginBottom(int intMarginBottomPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intMarginBottomPx);
      stb.append("px");

      strResultado = this.addCss("margin-bottom", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setMarginLeft(int intMarginLeftPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intMarginLeftPx);
      stb.append("px");

      strResultado = this.addCss("margin-left", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setMarginRight(int intMarginRightPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intMarginRightPx);
      stb.append("px");

      strResultado = this.addCss("margin-right", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setMarginTop(int intMarginTopPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intMarginTopPx);
      stb.append("px");

      strResultado = this.addCss("margin-top", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setMinHeight(double dblMinHeight) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(dblMinHeight);
      stb.append("px");

      strResultado = this.addCss("min-height", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setMinWidth(double dblMinWidth) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(dblMinWidth);
      stb.append("px");

      strResultado = this.addCss("min-width", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setOpacity(double dblOpacity) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(dblOpacity);

      strResultado = this.addCss("opacity", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setOverflow(String strOverflowPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strOverflowPx);

      strResultado = this.addCss("overflow", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setOverflowX(String strOverflowPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strOverflowPx);

      strResultado = this.addCss("overflow-x", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setOverflowY(String strOverflowPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strOverflowPx);

      strResultado = this.addCss("overflow-y", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setPadding(int intPadding, String strGrandeza) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intPadding);
      stb.append(strGrandeza);

      strResultado = this.addCss("padding", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setPaddingBottom(int intPaddingBottomPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intPaddingBottomPx);
      stb.append("px");

      strResultado = this.addCss("padding-bottom", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setPaddingLeft(int intPaddingLeftPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intPaddingLeftPx);
      stb.append("px");

      strResultado = this.addCss("padding-left", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setPaddingRight(int intPaddingRightPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intPaddingRightPx);
      stb.append("px");

      strResultado = this.addCss("padding-right", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setPaddingTop(int intPaddingTopPx) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intPaddingTopPx);
      stb.append("px");

      strResultado = this.addCss("padding-top", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setPosition(String strPosition) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strPosition);

      strResultado = this.addCss("position", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setRight(int intRight) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intRight);
      stb.append("px");

      strResultado = this.addCss("right", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  @Override
  public void setStrConteudo(String strConteudo) {

    _strConteudo = strConteudo;
  }

  public String setTextAlign(String strTextAlign) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strTextAlign);

      strResultado = this.addCss("text-align", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setTextDecoration(String strTextDecoration) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(strTextDecoration);

      strResultado = this.addCss("text-decoration", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setTextShadow(int intX, int intY, int intBlur, String strColor) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intX);
      stb.append("px ");
      stb.append(intY);
      stb.append("px ");
      stb.append(intBlur);
      stb.append("px ");
      stb.append(strColor);

      strResultado = this.addCss("text-shadow", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setTop(int intTop) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intTop);
      stb.append("px");

      strResultado = this.addCss("top", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setWhiteSpace(String strWhiteSpace) {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = this.addCss("white-space", strWhiteSpace);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setWidth(double dblWidth, String strGrandeza) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(dblWidth);
      stb.append(strGrandeza);

      strResultado = this.addCss("width", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public String setZ(int intZ) {

    String strResultado = Utils.STR_VAZIA;
    StringBuilder stb;

    try {

      stb = new StringBuilder();

      stb.append(intZ);

      strResultado = this.addCss("z-index", stb.toString());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  private void verificarCssExterna() {

    try {

      if ("cssMain".equals(this.getStrId())) {

        return;
      }

      if ("cssImp".equals(this.getStrId())) {

        return;
      }

      this.setStrTagNome("link");
      this.setBooForcarTagDupla(false);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}