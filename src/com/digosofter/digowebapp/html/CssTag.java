package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public class CssTag extends Tag {

  private static CssTag _iImp;
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

  private static final String STR_CLASS_NOME_SUFIXO = "c";
  public static final String STR_CSS_IMPRESSAO_ID = "cssImp";
  public static final String STR_CSS_MAIN_ID = "cssMain";

  public static CssTag getIImpr() {

    try {

      if (_iImp != null) {

        return _iImp;
      }

      _iImp = new CssTag();

      _iImp.addAtr("media", "print");
      _iImp.setStrId(CssTag.STR_CSS_IMPRESSAO_ID);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _iImp;
  }

  public static CssTag getIMain() {

    try {

      if (_iMain != null) {

        return _iMain;
      }

      _iMain = new CssTag();

      _iMain.setStrId(CssTag.STR_CSS_MAIN_ID);

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

  private String _cssPuro;
  private List<AtributoCss> _lstAtrCss;
  private String _strConteudo;

  public CssTag() {

    super("style");

    try {

      this.setBooForcarTagDupla(true);
      this.addAtr("type", "text/css");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public String addCss(String strNome, String strValor) {

    try {

      if (Utils.getBooStrVazia(strNome)) {

        return null;
      }

      if (Utils.getBooStrVazia(strValor)) {

        return null;
      }

      for (AtributoCss atrCss2 : this.getLstAtrCss()) {

        if (atrCss2 == null) {

          continue;
        }

        if (!atrCss2.getStrNome().equals(strNome)) {

          continue;
        }

        if (!atrCss2.getStrValor().equals(strValor)) {

          continue;
        }

        return atrCss2.getStrClassAssociada();
      }

      return this.addCssNovo(strNome, strValor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  private String addCssNovo(String strNome, String strValor) {

    AtributoCss atrCss;
    String strResultado;

    try {

      if (Utils.getBooStrVazia(strNome)) {

        return null;
      }

      if (Utils.getBooStrVazia(strValor)) {

        return null;
      }

      strResultado = CssTag.STR_CLASS_NOME_SUFIXO + String.valueOf(this.getLstAtrCss().size());

      atrCss = new AtributoCss(strNome, strValor);

      atrCss.setStrClassAssociada(strResultado);

      this.getLstAtrCss().add(atrCss);
      this.setStrConteudo(Utils.STR_VAZIA);

      return strResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
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

    try {

      if (!Utils.getBooStrVazia(_strConteudo)) {

        return _strConteudo;
      }

      _strConteudo = Utils.STR_VAZIA;

      for (AtributoCss atrCss : this.getLstAtrCss()) {

        if (atrCss == null) {

          continue;
        }

        _strConteudo += atrCss.getStrAtrFormatado();
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

  public String setBackgroundColor(String cor) {

    try {

      if (Utils.getBooStrVazia(cor)) {

        return null;
      }

      return this.addCss("background-color", cor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBackgroundGradiente(String cor, String cor2) {

    String css;

    try {

      if (Utils.getBooStrVazia(cor)) {

        return null;
      }

      if (Utils.getBooStrVazia(cor2)) {

        return null;
      }

      css = "linear-gradient(to bottom,_cor_1,_cor_2)";

      css = css.replace("_cor_1", cor);
      css = css.replace("_cor_2", cor2);

      return this.addCss("background", css);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBackgroundImage(String srcImagem) {

    String css;

    try {

      if (Utils.getBooStrVazia(srcImagem)) {

        return null;
      }
      css = "url('_src_imagem')";

      css = css.replace("_src_imagem", srcImagem);

      return this.addCss("background-image", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBackgroundRepeat(String css) {

    try {

      if (Utils.getBooStrVazia(css)) {

        return null;
      }

      return this.addCss("background-repeat", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBackgroundSize(String css) {

    try {

      if (Utils.getBooStrVazia(css)) {

        return null;
      }

      return this.addCss("background-size", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBooCenter() {

    return this.addCss("margin", "0 auto");
  }

  public String setBorder(int intBorderPx, String strTipo, String cor) {

    String css;

    try {

      css = "_border_pxpx _tipo _cor";

      css = css.replace("_border_px", String.valueOf(intBorderPx));
      css = css.replace("_tipo", strTipo);
      css = css.replace("_cor", cor);

      return this.addCss("border", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBorderBottom(int intBorderBottomPx, String cor) {

    String css;

    try {

      css = "_border_bottom_pxpx solid _cor";
      css = css.replace("_border_bottom_px", String.valueOf(intBorderBottomPx));
      css = css.replace("_cor", cor);

      return this.addCss("border-bottom", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBorderLeft(int intBorderLeftPx, String cor) {

    String css;

    try {

      css = "_border_left_pxpx solid _cor";
      css = css.replace("_border_left_px", String.valueOf(intBorderLeftPx));
      css = css.replace("_cor", cor);

      return this.addCss("border-left", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBorderRadius(int intTopLeftPx, int intTopRightPx, int intBottomRightPx, int intBottomLeftPx) {

    String css;

    try {

      css = "_top_left_pxpx _top_right_pxpx _bottom_right_pxpx _bottom_left_pxpx";

      css = css.replace("_top_left_px", String.valueOf(intTopLeftPx));
      css = css.replace("_top_right_px", String.valueOf(intTopRightPx));
      css = css.replace("_bottom_right_px", String.valueOf(intBottomRightPx));
      css = css.replace("_bottom_left_px", String.valueOf(intBottomLeftPx));

      return this.addCss("border-radius", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBorderRight(int intBorderRightPx, String cor) {

    String css;

    try {

      css = "_border_tight_pxpx solid _cor";

      css = css.replace("_border_tight_px", String.valueOf(intBorderRightPx));
      css = css.replace("_cor", cor);

      return this.addCss("border-right", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBorderTop(int intBorderTopPx, String cor) {

    String css;

    try {

      css = "_border_top_pxpx solid _cor";

      css = css.replace("_border_top_px", String.valueOf(intBorderTopPx));
      css = css.replace("_cor", cor);

      return this.addCss("border-top", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBottom(int intBottom) {

    String css;

    try {

      css = "_bottompx";
      css = css.replace("_bottom", String.valueOf(intBottom));

      return this.addCss("bottom", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setBoxShadow(int intHorizontal, int intVertical, int intBlur, int intSpread, String cor) {

    String css;

    try {

      css = "_horizontal_pxpx _vertical_pxpx _blur_pxpx _spread_pxpx _cor";

      css = css.replace("_horizontal_px", String.valueOf(intHorizontal));
      css = css.replace("_vertical_px", String.valueOf(intVertical));
      css = css.replace("_blur_px", String.valueOf(intBlur));
      css = css.replace("_spread_px", String.valueOf(intSpread));
      css = css.replace("_cor", cor);

      return this.addCss("box-shadow", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setClearBoth() {

    return this.addCss("clear", "both");
  }

  public String setColor(String cor) {

    try {

      if (Utils.getBooStrVazia(cor)) {

        return null;
      }

      return this.addCss("color", cor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  /**
   * Não remover! Este método tem de ser sob-escrito da classe pai para que não
   * haja um loop infinito. E também porque esta tag não precisa de layout.
   */
  @Override
  protected void setCss(CssTag tagCss) {

    // Fazer nada.
  }

  private void setCssPuro(String cssPuro) {

    _cssPuro = cssPuro;
  }

  public String setCursor(String strCursor) {

    try {

      if (Utils.getBooStrVazia(strCursor)) {

        return null;
      }

      return this.addCss("cursor", strCursor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setDisplay(String strDisplay) {

    try {

      if (Utils.getBooStrVazia(strDisplay)) {

        return null;
      }

      return this.addCss("display", strDisplay);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setFloat(String strFloat) {

    try {

      if (Utils.getBooStrVazia(strFloat)) {

        return null;
      }

      return this.addCss("float", strFloat);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setFontFamily(String strFontFamily) {

    try {

      if (Utils.getBooStrVazia(strFontFamily)) {

        return null;
      }

      return this.addCss("font-family", strFontFamily);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setFontNegrito() {

    return this.addCss("font-weight", "bold");
  }

  public String setFontSize(double dblFontSize, String strGrandeza) {

    String css;

    try {

      css = "_font_size_font_grandeza";

      css = css.replace("_font_size", String.valueOf(dblFontSize));
      css = css.replace("_font_grandeza", strGrandeza);

      return this.addCss("font-size", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setFontStyle(String strFontStyle) {

    try {

      if (Utils.getBooStrVazia(strFontStyle)) {

        return null;
      }

      return this.addCss("font-style", strFontStyle);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setHeight(double dblHeight, String strGrandeza) {

    String css;

    try {

      css = "_height_grandeza";

      css = css.replace("_height", String.valueOf(dblHeight));
      css = css.replace("_grandeza", strGrandeza);

      return this.addCss("height", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setLeft(int intLeft) {

    String css;

    try {

      css = "_right_pxpx";
      css = css.replace("_right_px", String.valueOf(intLeft));

      return this.addCss("left", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  protected void setLstAtrCss(List<AtributoCss> lstAtrCss) {

    _lstAtrCss = lstAtrCss;
  }

  public String setMargin(int intMargin, String strGrandeza) {

    String css;

    try {

      css = "_margin_grandeza";

      css = css.replace("_margin", String.valueOf(intMargin));
      css = css.replace("_grandeza", strGrandeza);

      return this.addCss("margin", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setMarginBottom(int intMarginBottomPx) {

    String css;

    try {

      css = "_margin_bottom_pxpx";
      css = css.replace("_margin_bottom_px", String.valueOf(intMarginBottomPx));

      return this.addCss("margin-bottom", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setMarginLeft(int intMarginLeftPx) {

    String css;

    try {

      css = "_margin_left_pxpx";
      css = css.replace("_margin_left_px", String.valueOf(intMarginLeftPx));

      return this.addCss("margin-left", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setMarginRight(int intMarginRightPx) {

    String css;

    try {

      css = "_margin_right_pxpx";
      css = css.replace("_margin_right_px", String.valueOf(intMarginRightPx));

      return this.addCss("margin-right", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setMarginTop(int intMarginTopPx) {

    String css;

    try {

      css = "_margin_top_pxpx";
      css = css.replace("_margin_top_px", String.valueOf(intMarginTopPx));

      return this.addCss("margin-top", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setMinHeight(double dblMinHeight) {

    String css;

    try {

      css = "_min_height_pxpx";
      css = css.replace("_min_height_px", String.valueOf(dblMinHeight));

      return this.addCss("min-height", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setMinWidth(double dblMinWidth) {

    String css;

    try {

      css = "_min_width_pxpx";
      css = css.replace("_min_width_px", String.valueOf(dblMinWidth));

      return this.addCss("min-width", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setOpacity(double dblOpacity) {

    try {

      return this.addCss("opacity", String.valueOf(dblOpacity));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setOverflow(String strOverflowPx) {

    try {

      if (Utils.getBooStrVazia(strOverflowPx)) {

        return null;
      }

      return this.addCss("overflow", strOverflowPx);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setOverflowX(String strOverflowPx) {

    try {

      if (Utils.getBooStrVazia(strOverflowPx)) {

        return null;
      }

      return this.addCss("overflow-x", strOverflowPx);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setOverflowY(String strOverflowPx) {

    try {

      if (Utils.getBooStrVazia(strOverflowPx)) {

        return null;
      }

      return this.addCss("overflow-y", strOverflowPx);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setPadding(int intPadding, String strGrandeza) {

    String css;

    try {

      css = "_padding_grandeza";

      css = css.replace("_padding", String.valueOf(intPadding));
      css = css.replace("_grandeza", strGrandeza);

      return this.addCss("padding", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setPaddingBottom(int intPaddingBottomPx) {

    String css;

    try {

      css = "_padding_bottom_pxpx";
      css = css.replace("_padding_bottom_px", String.valueOf(intPaddingBottomPx));

      return this.addCss("padding-bottom", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setPaddingLeft(int intPaddingLeftPx) {

    String css;

    try {

      css = "_padding_left_pxpx";
      css = css.replace("_padding_left_px", String.valueOf(intPaddingLeftPx));

      return this.addCss("padding-left", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setPaddingRight(int intPaddingRightPx) {

    String css;

    try {

      css = "_padding_right_pxpx";
      css = css.replace("_padding_right_px", String.valueOf(intPaddingRightPx));

      return this.addCss("padding-right", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setPaddingTop(int intPaddingTopPx) {

    String css;

    try {

      css = "_padding_top_pxpx";
      css = css.replace("_padding_top_px", String.valueOf(intPaddingTopPx));

      return this.addCss("padding-top", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setPosition(String strPosition) {

    try {

      if (Utils.getBooStrVazia(strPosition)) {

        return null;
      }

      return this.addCss("position", strPosition);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setRight(int intRight) {

    String css;

    try {

      css = "_right_pxpx";
      css = css.replace("_right_px", String.valueOf(intRight));

      return this.addCss("right", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  @Override
  public void setStrConteudo(String strConteudo) {

    _strConteudo = strConteudo;
  }

  public String setTextAlign(String strTextAlign) {

    try {

      return this.addCss("text-align", strTextAlign);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setTextDecoration(String strTextDecoration) {

    try {

      if (Utils.getBooStrVazia(strTextDecoration)) {

        return null;
      }

      return this.addCss("text-decoration", strTextDecoration);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setTextShadow(int intX, int intY, int intBlur, String cor) {

    String css;

    try {

      css = "_x_pxpx _y_pxpx _blur_pxpx _cor";

      css = css.replace("_x_px", String.valueOf(intX));
      css = css.replace("_y_px", String.valueOf(intY));
      css = css.replace("_blur_px", String.valueOf(intBlur));
      css = css.replace("_cor", cor);

      return this.addCss("text-shadow", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setTop(int intTop) {

    String css;

    try {

      css = "_top_pxpx";

      css = css.replace("_top_px", String.valueOf(intTop));

      return this.addCss("top", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setWhiteSpace(String strWhiteSpace) {

    try {

      if (Utils.getBooStrVazia(strWhiteSpace)) {

        return null;
      }

      return this.addCss("white-space", strWhiteSpace);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setWidth(double dblWidth, String strGrandeza) {

    String css;

    try {

      css = "_width_grandeza";

      css = css.replace("_width", String.valueOf(dblWidth));
      css = css.replace("_grandeza", strGrandeza);

      return this.addCss("width", css);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String setZ(int intZ) {

    return this.addCss("z-index", String.valueOf(intZ));
  }

  @Override
  public String toHtml() {

    try {

      if (CssTag.STR_CSS_MAIN_ID.equals(this.getStrId())) {

        return super.toHtml();
      }

      if (CssTag.STR_CSS_IMPRESSAO_ID.equals(this.getStrId())) {

        return super.toHtml();
      }

      this.setStrTagNome("link");
      this.setBooForcarTagDupla(false);

      return super.toHtml();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }
}