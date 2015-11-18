package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Tag extends Objeto {

  private Atributo _atrClass;
  private Atributo _atrId;
  private Atributo _atrNome;
  private Atributo _atrSrc;
  private Atributo _atrTitle;
  private Atributo _atrType;
  private boolean _booBarraNoFinal = true;
  private boolean _booClicavel;
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

      if (this instanceof CssTag) {

        return;
      }

      this.setCss(CssTag.getIMain());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addAtr(Atributo atr) {

    try {

      if (atr == null) {

        return;
      }

      if (Utils.getBooStrVazia(atr.getStrNome())) {

        return;
      }

      if (this.getLstAtr().contains(atr)) {

        return;
      }

      this.getLstAtr().add(atr);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addAtr(String strNome) {

    this.addAtr(strNome, null);
  }

  public void addAtr(String strNome, double dblValor) {

    this.addAtr(strNome, String.valueOf(dblValor));
  }

  public void addAtr(String strNome, int intValor) {

    this.addAtr(strNome, String.valueOf(intValor));
  }

  public void addAtr(String strNome, String strValor) {

    Atributo atr;

    try {

      if (Utils.getBooStrVazia(strNome)) {

        return;
      }

      atr = new Atributo(strNome, strValor);

      this.addAtr(atr);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addCss(String strClassCss) {

    try {

      if (Utils.getBooStrVazia(strClassCss)) {

        return;
      }

      if (this.getAtrClass().getLstStrValor().contains(strClassCss)) {

        return;
      }

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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.DIR_JS_TAG));
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

      this.addAtr(_atrClass);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrClass;
  }

  private Atributo getAtrId() {

    try {

      if (_atrId != null) {

        return _atrId;
      }

      _atrId = new Atributo("id");

      this.addAtr(_atrId);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrId;
  }

  private Atributo getAtrNome() {

    try {

      if (_atrNome != null) {

        return _atrNome;
      }

      _atrNome = new Atributo("name");

      this.addAtr(_atrNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrNome;
  }

  private Atributo getAtrSrc() {

    try {

      if (_atrSrc != null) {

        return _atrSrc;
      }

      _atrSrc = new Atributo("src");

      this.addAtr(_atrSrc);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrSrc;
  }

  private Atributo getAtrTitle() {

    try {

      if (_atrTitle != null) {

        return _atrTitle;
      }

      _atrTitle = new Atributo("title");

      this.addAtr(_atrTitle);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _atrTitle;
  }

  public Atributo getAtrType() {

    try {

      if (_atrType != null) {

        return _atrType;
      }

      _atrType = new Atributo("type");

      this.addAtr(_atrType);
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

  protected boolean getBooClicavel() {

    return _booClicavel;
  }

  protected boolean getBooForcarTagDupla() {

    return _booForcarTagDupla;
  }

  private List<Atributo> getLstAtr() {

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

    List<String> lstStrAtrNomeAdicionado;
    String strResultado;

    try {

      lstStrAtrNomeAdicionado = new ArrayList<String>();
      strResultado = Utils.STR_VAZIA;

      for (Atributo atr : this.getLstAtr()) {

        if (atr == null) {

          continue;
        }

        if (Utils.getBooStrVazia(atr.getStrNome())) {

          continue;
        }

        if (lstStrAtrNomeAdicionado.contains(atr.getStrNome())) {

          continue;
        }

        strResultado += atr.getStrFormatado();
        strResultado += " ";
      }

      strResultado = Utils.removerUltimaLetra(strResultado);

      return strResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
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

      _strId = this.getStrIdAuto();

      this.getAtrId().setStrValor(_strId);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strId;
  }

  private String getStrIdAuto() {

    String strResultado;

    try {

      strResultado = "id_int_id";
      strResultado = strResultado.replace("_int_id", String.valueOf(this.getIntObjetoId()));

      return strResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  private String getStrLink() {

    return _strLink;
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
   * Limpa todas as classes já adicionadas à tag.
   */
  public void limparClass() {

    this.getAtrClass().getLstStrValor().clear();
  }

  protected void montarLayout() {

    try {

      this.salvarEstruturaSecundaria();

      this.addCssArquivo(PaginaHtml.getI().getLstTagCss());
      this.addJsArquivo(PaginaHtml.getI().getLstTagJs());
      this.addJsCodigo(PaginaHtml.getI().getTagJsMain());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Salva a estrutura html desta tag em um objeto JavaScript para ser utilizada
   * no cliente.
   */
  public void salvarEstrutura() {

    String strEstrutura;
    String strJsCodigo;
    String strJsNome;

    try {

      strEstrutura = this.toHtml();

      strJsNome = "str__tag_id_estrutura";
      strJsNome = strJsNome.replace("_tag_id", this.getClass().getSimpleName());

      strJsCodigo = "var _str_js_nome = '_estrutura_html';";
      strJsCodigo = strJsCodigo.replace("_str_js_nome", strJsNome);
      strJsCodigo = strJsCodigo.replace("_estrutura_html", strEstrutura);

      PaginaHtml.getI().getTagJsMain().addJsCodigo(strJsCodigo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Chamado dentro de {@link #montarLayout()}, este método deve ser
   * implementado pelas classes que extendem esta, com o objetivo de salvar
   * estruturas secundárias que serão utilizadas no cliente.
   */
  protected void salvarEstruturaSecundaria() {

  }

  public void setBooBarraNoFinal(boolean booBarraNoFinal) {

    _booBarraNoFinal = booBarraNoFinal;
  }

  protected void setBooClicavel(boolean booClicavel) {

    try {

      _booClicavel = booClicavel;

      if (!_booClicavel) {

        return;
      }

      this.addCss(CssTag.getIMain().setCursor("pointer"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
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

      _strSrc += "?" + Utils.simplificar(AppWeb.getI().getStrVersao());

      this.getAtrSrc().setStrValor(_strSrc);
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

      if (Utils.getBooStrVazia(_strId)) {

        _strId = this.getStrIdAuto();
      }

      this.getAtrId().setStrValor(_strId);
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

    try {

      if (Utils.getBooStrVazia(strLink)) {

        return;
      }

      _strLink = strLink + "\"target=\"_blank\"";
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void setStrNome(String strNome) {

    super.setStrNome(strNome);

    try {

      _strNome = strNome;

      if (Utils.getBooStrVazia(_strNome)) {

        return;
      }

      this.getAtrNome().setStrValor(Utils.simplificar(_strNome));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void setStrTagNome(String strTagNome) {

    try {

      _strTagNome = strTagNome;

      if (Utils.getBooStrVazia(_strTagNome)) {

        _strTagNome = "div";
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrTitle(String strTitle) {

    try {

      _strTitle = strTitle;

      if (Utils.getBooStrVazia(_strTitle)) {

        return;
      }

      this.getAtrTitle().setStrValor(_strTitle);
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

      if (_tagPai == null) {

        return;
      }

      _tagPai.getLstTag().add(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public String toHtml() {

    StringBuilder stbResultado;

    try {

      this.montarLayout();

      stbResultado = new StringBuilder();

      if (!Utils.getBooStrVazia(this.getStrConteudo()) || !this.getLstTag().isEmpty() || this.getBooForcarTagDupla()) {

        if (!Utils.getBooStrVazia(this.getStrLink())) {

          stbResultado.append("<a href=\"");
          stbResultado.append(this.getStrLink());
          stbResultado.append("\">");
        }

        stbResultado.append(this.getStrAbertura());
        stbResultado.append(this.getStrTagNome());
        stbResultado.append(!this.getLstAtr().isEmpty() ? " " : Utils.STR_VAZIA);
        stbResultado.append(this.getStrAtributoFormatado());
        stbResultado.append(this.getStrFechamento());

        stbResultado.append(!Utils.getBooStrVazia(this.getStrConteudo()) ? this.getStrConteudo() : Utils.STR_VAZIA);

        for (Tag tag : this.getLstTag()) {

          stbResultado.append(tag.toHtml());
        }

        stbResultado.append(this.getStrAbertura());

        if (this.getBooBarraNoFinal()) {

          stbResultado.append("/");
        }

        stbResultado.append(this.getStrTagNome());
        stbResultado.append(this.getStrFechamento());

        if (!Utils.getBooStrVazia(this.getStrLink())) {

          stbResultado.append("</a>");
        }

        return stbResultado.toString();
      }

      if (!Utils.getBooStrVazia(this.getStrLink())) {

        stbResultado.append("<a href=\"");
        stbResultado.append(this.getStrLink());
        stbResultado.append("\">");
      }

      stbResultado.append(this.getStrAbertura());
      stbResultado.append(this.getStrTagNome());
      stbResultado.append(" ");
      stbResultado.append(this.getStrAtributoFormatado());

      if (this.getBooBarraNoFinal()) {

        stbResultado.append("/");
      }

      stbResultado.append(this.getStrFechamento());

      if (!Utils.getBooStrVazia(this.getStrLink())) {

        stbResultado.append("</a>");
      }

      return stbResultado.toString();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }
}