package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Tag extends Objeto {

  private Atributo _atrClass;

  private Atributo _atrType;

  private boolean _booBarraNoFinal = true;

  private boolean _booForcarTagDupla = false;

  private List<Atributo> _lstAtr;

  private List<Tag> _lstTag;

  private String _strAbertura = "<";

  private String _strConteudo = Utils.STRING_VAZIA;

  private String _strFechamento = ">";

  private String _strId = Utils.STRING_VAZIA;

  private String _strLink;

  private String _strNome;

  private String _strTagNome = "div";

  private String _strTitle;

  private Tag _tagPai;

  public Tag(String strTagName) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrTagNome(strTagName);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void addAtr(String strNome, int intValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getLstAtr().add(new Atributo(strNome, String.valueOf(intValor)));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void addAtr(String strNome, String strValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getLstAtr().add(new Atributo(strNome, strValor));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void addCss(String strClassCss) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getAtrClass().getLstStrValor().add(strClassCss);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona o arquivo "JavaScript" correspondente a esta classe à página do
   * cliente.
   */
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TAG));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona código à tag de "JavaScript" da página.
   */
  protected void addJsCodigo(JavaScriptTag tagJs) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES
      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public Atributo getAtrClass() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_atrClass == null) {

        _atrClass = new Atributo("class");
        this.getLstAtr().add(_atrClass);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _atrClass;
  }

  public Atributo getAtrType() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_atrType == null) {

        _atrType = new Atributo("type");
        this.getLstAtr().add(_atrType);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstAtr == null) {
        _lstAtr = new ArrayList<Atributo>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstAtr;
  }

  public List<Tag> getLstTag() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstTag == null) {
        _lstTag = new ArrayList<Tag>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstTag;
  }

  protected String getStrAbertura() {
    return _strAbertura;
  }

  protected String getStrAtributoFormatado() {
    // VARIÁVEIS

    String strAtributoIncluido = Utils.STRING_VAZIA;
    StringBuilder stbAtrFormatado = new StringBuilder();

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (Atributo atr : this.getLstAtr()) {

        if (!strAtributoIncluido.contains("#" + atr.getStrNome() + "#")) {

          strAtributoIncluido += "#" + atr.getStrNome() + "#";
          stbAtrFormatado.append(" ");
          stbAtrFormatado.append(atr.getStrNome());
          stbAtrFormatado.append("=\"");
          stbAtrFormatado.append(Utils.getStrConcatenarLst(atr.getLstStrValor(),
              atr.getStrDelimitador(), true));
          stbAtrFormatado.append("\"");
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return stbAtrFormatado.toString();
  }

  public String getStrConteudo() {
    return _strConteudo;
  }

  protected String getStrFechamento() {
    return _strFechamento;
  }

  public String getStrId() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Utils.getBooStrVazia(_strId)) {

        _strId = "id" + String.valueOf(this.getIntId());
        this.getLstAtr().add(new Atributo("id", _strId));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strId;
  }

  private String getStrLink() {
    return _strLink;
  }

  public String getStrTagFormatada() {
    // VARIÁVEIS

    StringBuilder stbTagFormatada = new StringBuilder();

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.montarLayout();

      if (!Utils.getBooStrVazia(this.getStrConteudo()) || !this.getLstTag().isEmpty()
          || this.getBooForcarTagDupla()) {

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

      } else {

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

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return stbTagFormatada.toString();
  }

  protected String getStrTagNome() {
    return _strTagNome;
  }

  private String getStrTitle() {
    return _strTitle;
  };

  public Tag getTagPai() {
    return _tagPai;
  }

  /**
   * Limpa todas as "classes" já adicionadas à tag.
   */
  public void limparClass() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getAtrClass().getLstStrValor().clear();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  protected void montarLayout() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.addJsArquivo(PaginaHtml.getI().getLstTagJs());
      this.addJsCodigo(PaginaHtml.getI().getTagJsMain());
      this.setCss(CssTag.getIMain());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setAtrClass(Atributo atrClass) {
    _atrClass = atrClass;
  }

  private void setAtrType(Atributo atrType) {
    _atrType = atrType;
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES
      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setLstAtr(List<Atributo> lstAtr) {
    _lstAtr = lstAtr;
  }

  private void setLstTag(List<Tag> lstTag) {
    _lstTag = lstTag;
  }

  private void setStrAbertura(String strAbertura) {
    _strAbertura = strAbertura;
  }

  public void setStrConteudo(String strConteudo) {
    _strConteudo = strConteudo;
  }

  public void setStrConteudo(StringBuilder stbConteudo) {
    this.setStrConteudo(stbConteudo.toString());
  }

  private void setStrFechamento(String strFechamento) {
    _strFechamento = strFechamento;
  }

  public void setStrId(String strId) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strId = strId;
      this.getLstAtr().add(new Atributo("id", _strId));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
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

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strNome = strNome;
      this.addAtr("name", _strNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  protected void setStrTagNome(String strTagNome) {
    _strTagNome = strTagNome;
  }

  public void setStrTitle(String strTitle) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strTitle = strTitle;
      this.getLstAtr().add(new Atributo("title", _strTitle));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrTitulo(String strTitulo) {
    this.setStrTitle(strTitulo);
  }

  public void setTagPai(Tag tagPai) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _tagPai = tagPai;
      _tagPai.getLstTag().add(this);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
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
