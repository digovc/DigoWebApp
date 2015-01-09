package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Tag extends Objeto {

  private Atributo _atrClass;
  private Atributo _atrSrc;
  private Atributo _atrType;
  private boolean _booBarraNoFinal = true;
  private boolean _booForcarTagDupla;
  private List<Atributo> _lstAtr;
  private List<Tag> _lstTag;
  private String _strAbertura;
  private String _strConteudo;
  private String _strFechamento;
  private String _strId;
  private String _strLink;
  private String _strNome;
  private String _strSrc;
  private String _strTagNome;
  private String _strTitle;
  private Tag _tagPai;

  public Tag(String strTagName) {

    try {

      this.setStrTagNome(strTagName);
      this.setStrConteudo(Utils.STR_VAZIA);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addAtr(String strNome, int intValor) {

    try {

      this.getLstAtr().add(new Atributo(strNome, String.valueOf(intValor)));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addAtr(String strNome, String strValor) {

    try {

      this.getLstAtr().add(new Atributo(strNome, strValor));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addCss(String strClassCss) {

    try {

      this.getAtrClass().getLstStrValor().add(strClassCss);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void addCssArquivo(List<CssTag> lstTagCss) {

  }

  /**
   * Adiciona o arquivo "JavaScript" correspondente a esta classe à página do
   * cliente.
   */
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TAG));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona código à tag de "JavaScript" da página.
   */
  protected void addJsCodigo(JavaScriptTag tagJs) {

  }

  public Atributo getAtrClass() {

    try {

      if (_atrClass != null) {

        return _atrClass;
      }

      _atrClass = new Atributo("class");

      this.getLstAtr().add(_atrClass);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrClass;
  }

  private Atributo getAtrSrc() {

    try {

      if (_atrSrc != null) {

        return _atrSrc;
      }

      _atrSrc = new Atributo("src");

      this.getLstAtr().add(_atrSrc);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrSrc;
  }

  public Atributo getAtrType() {

    try {

      if (_atrType != null) {

        return _atrType;
      }

      _atrType = new Atributo("type");

      this.getLstAtr().add(_atrType);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrType;
  }

  private boolean getBooBarraNoFinal() {

    return _booBarraNoFinal;
  }

  protected boolean getBooForcarTagDupla() {

    return _booForcarTagDupla;
  }

  public List<Atributo> getLstAtr() {

    try {

      if (_lstAtr != null) {

        return _lstAtr;
      }

      _lstAtr = new ArrayList<Atributo>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstAtr;
  }

  public List<Tag> getLstTag() {

    try {

      if (_lstTag != null) {

        return _lstTag;
      }

      _lstTag = new ArrayList<Tag>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstTag;
  }

  public String getSrc() {

    return _strSrc;
  }

  protected String getStrAbertura() {

    try {

      if (!Utils.getBooStrVazia(_strAbertura)) {

        return _strAbertura;
      }

      _strAbertura = "<";
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strAbertura;
  }

  protected String getStrAtributoFormatado() {

    String strAtributoIncluido = Utils.STR_VAZIA;
    StringBuilder stbAtrFormatado = new StringBuilder();

    try {

      for (Atributo atr : this.getLstAtr()) {

        if (strAtributoIncluido.contains("#" + atr.getStrNome() + "#")) {

          continue;
        }

        strAtributoIncluido += "#" + atr.getStrNome() + "#";

        stbAtrFormatado.append(" ");
        stbAtrFormatado.append(atr.getStrNome());
        stbAtrFormatado.append("=\"");
        stbAtrFormatado.append(Utils.getStrConcatenarLst(atr.getLstStrValor(), atr.getStrDelimitador(), true));
        stbAtrFormatado.append("\"");
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return stbAtrFormatado.toString();
  }

  public String getStrConteudo() {

    return _strConteudo;
  }

  protected String getStrFechamento() {

    try {

      if (!Utils.getBooStrVazia(_strFechamento)) {

        return _strFechamento;
      }

      _strFechamento = ">";
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strFechamento;
  }

  public String getStrId() {

    try {

      if (!Utils.getBooStrVazia(_strId)) {

        return _strId;
      }

      _strId = "id_int_id";
      _strId = _strId.replace("_int_id", String.valueOf(this.getIntIndexObjeto()));

      this.getLstAtr().add(new Atributo("id", _strId));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strId;
  }

  private String getStrLink() {

    return _strLink;
  }

  public String getStrTagFormatada() {

    StringBuilder stbTagFormatada = new StringBuilder();

    try {

      this.montarLayout();

      if (!Utils.getBooStrVazia(this.getStrConteudo()) || !this.getLstTag().isEmpty() || this.getBooForcarTagDupla()) {

        if (!Utils.getBooStrVazia(this.getStrLink())) {

          stbTagFormatada.append("<a href=\"");
          stbTagFormatada.append(this.getStrLink());
          stbTagFormatada.append("\">");
        }

        stbTagFormatada.append(this.getStrAbertura());
        stbTagFormatada.append(this.getStrTagNome());
        stbTagFormatada.append(this.getStrAtributoFormatado());
        stbTagFormatada.append(this.getStrFechamento());
        stbTagFormatada.append(this.getStrConteudo());

        for (Tag tag : this.getLstTag()) {

          stbTagFormatada.append(tag.getStrTagFormatada());
        }

        stbTagFormatada.append(this.getStrAbertura());

        if (this.getBooBarraNoFinal()) {

          stbTagFormatada.append("/");
        }

        stbTagFormatada.append(this.getStrTagNome());
        stbTagFormatada.append(this.getStrFechamento());

        if (!Utils.getBooStrVazia(this.getStrLink())) {

          stbTagFormatada.append("</a>");
        }

        return stbTagFormatada.toString();
      }

      if (!Utils.getBooStrVazia(this.getStrLink())) {

        stbTagFormatada.append("<a href=\"");
        stbTagFormatada.append(this.getStrLink());
        stbTagFormatada.append("\">");
      }

      stbTagFormatada.append(this.getStrAbertura());
      stbTagFormatada.append(this.getStrTagNome());
      stbTagFormatada.append(this.getStrAtributoFormatado());

      if (this.getBooBarraNoFinal()) {

        stbTagFormatada.append("/");
      }

      stbTagFormatada.append(this.getStrFechamento());

      if (!Utils.getBooStrVazia(this.getStrLink())) {

        stbTagFormatada.append("</a>");
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return stbTagFormatada.toString();
  }

  protected String getStrTagNome() {

    try {

      if (!Utils.getBooStrVazia(_strTagNome)) {

        return _strTagNome;
      }

      _strTagNome = "div";
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strTagNome;
  }

  protected String getStrTitle() {

    return _strTitle;
  }

  public Tag getTagPai() {

    return _tagPai;
  }

  /**
   * Limpa todas as "classes" já adicionadas à tag.
   */
  public void limparClass() {

    try {

      this.getAtrClass().getLstStrValor().clear();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void montarLayout() {

    try {

      this.addCssArquivo(PaginaHtml.getI().getLstTagCss());
      this.addJsArquivo(PaginaHtml.getI().getLstTagJs());
      this.addJsCodigo(PaginaHtml.getI().getTagJsMain());
      this.setCss(CssTag.getIMain());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setBooBarraNoFinal(boolean booBarraNoFinal) {

    _booBarraNoFinal = booBarraNoFinal;
  }

  public void setBooForcarTagDupla(boolean booForcarTagDupla) {

    _booForcarTagDupla = booForcarTagDupla;
  }

  /**
   * Método responsável por carregar o "layout" da tag através de "css".
   */
  protected void setCss(CssTag tagCss) {

  }

  public void setSrc(String strSrc) {

    try {

      _strSrc = strSrc;

      if (Utils.getBooStrVazia(_strSrc)) {

        return;
      }

      this.getAtrSrc().setStrValor(strSrc);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrConteudo(String strConteudo) {

    _strConteudo = strConteudo;
  }

  public void setStrConteudo(StringBuilder stbConteudo) {

    this.setStrConteudo(stbConteudo.toString());
  }

  public void setStrId(String strId) {

    try {

      _strId = strId;

      this.getLstAtr().add(new Atributo("id", _strId));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrLink(String strLink) {

    _strLink = strLink;
  }

  public void setStrLinkNovaJanela(String strLink) {

    _strLink = strLink + "\"target=\"_blank\"";
  }

  @Override
  public void setStrNome(String strNome) {

    super.setStrNome(strNome);

    try {

      _strNome = strNome;

      this.addAtr("name", _strNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void setStrTagNome(String strTagNome) {

    _strTagNome = strTagNome;
  }

  public void setStrTitle(String strTitle) {

    try {

      _strTitle = strTitle;

      this.getLstAtr().add(new Atributo("title", _strTitle));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrTitulo(String strTitulo) {

    this.setStrTitle(strTitulo);
  }

  public void setTagPai(Tag tagPai) {

    try {

      _tagPai = tagPai;
      _tagPai.getLstTag().add(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public String toHtml() {

    return this.getStrTagFormatada();
  }

  @Override
  public String toString() {

    return this.getStrTagFormatada();
  }
}