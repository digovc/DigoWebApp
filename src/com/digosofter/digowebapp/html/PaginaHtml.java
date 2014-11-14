package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Usuario;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.componente.Mensagem;

public class PaginaHtml extends Objeto {

  private static CssTag _cssMain;
  private static PaginaHtml i;

  public static final String JS_APP_WEB = "res/js/lib/JDigo/AppWeb.js";
  public static final String JS_ERRO = "res/js/lib/JDigo/erro/Erro.js";
  public static final String JS_LIB_DATE = "res/js/lib/JDigo/lib/date.js";
  public static final String JS_LIB_JQUERY = "res/js/lib/JDigo/lib/jquery-2.0.3.js";
  public static final String JS_LIB_JQUERY_UI = "res/js/lib/JDigo/lib/jquery-ui.min.js";
  public static final String JS_LIB_MD5 = "res/js/lib/JDigo/lib/md5.js";
  public static final String JS_LST_ERRO = "res/js/lib/JDigo/lista/LstStrErro.js";
  public static final String JS_MENSAGEM = "res/js/lib/JDigo/html/componente/Mensagem.js";
  public static final String JS_OBJ_WS_INTERLOCUTOR = "res/js/lib/JDigo/websocket/ObjWsInterlocutor.js";
  public static final String JS_OBJETO = "res/js/lib/JDigo/Objeto.js";
  public static final String JS_PAG_HTML = "res/js/lib/JDigo/html/PaginaHtml.js";
  public static final String JS_USUARIO = "res/js/lib/JDigo/Usuario.js";
  public static final String JS_UTILS = "res/js/lib/JDigo/Utils.js";
  public static final String JS_WEB_SOCKET = "res/js/lib/JDigo/websocket/WebSocketMain.js";

  public static PaginaHtml getI() {

    try {

      if (i == null) {
        i = new PaginaHtml();
      }

    }
    catch (Exception ex) {

      new Erro("Erro ao instanciar objeto do tipo 'PaginaHtml'.\n", ex);

    }
    finally {
    }

    return i;
  }

  private boolean _booPagSimples;
  private CssTag _cssImp;
  private List<CssTag> _lstTagCss;
  private List<CssTag> _lstTagCssOrdenado;
  private List<JavaScriptTag> _lstTagJs;
  private List<JavaScriptTag> _lstTagJsOrdenado;
  private String _strSrcIcon;
  private String _strTitulo;
  private Tag _tagBody;
  private Tag _tagDocType;
  private Tag _tagHead;
  private Tag _tagHtml;
  private Tag _tagIcon;
  private JavaScriptTag _tagJsMain;
  private Tag _tagMeta;
  private Tag _tagTitle;

  public PaginaHtml() {

    try {

      this.setI(this);
      this.addCssArquivo(this.getLstTagCss());
      this.addJsArquivo(this.getLstTagJs());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  private void addCssAoCabecalho() {

    try {

      if (this.getBooPagSimples()) {
        return;
      }

      for (CssTag cssTag : this.getLstTagCssOrdenado()) {

        cssTag.setTagPai(this.getTagHead());
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  protected void addCssArquivo(List<CssTag> lstTagCss) {

    try {

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Acrescenta os arquivos de "JavaScript" para a "tagHead" na ordem correta.
   */
  private void addJsAoCabecalho() {

    try {

      if (this.getBooPagSimples()) {
        return;
      }

      for (JavaScriptTag objJavaScriptTag : this.getLstTagJsOrdenado()) {

        objJavaScriptTag.setTagPai(this.getTagHead());
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Adiciona os arquivos "JavaScript" que fazem a página funcionar no
   * navegador.
   */
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    try {

      lstObjJsTag.add(new JavaScriptTag(JS_LIB_JQUERY));
      lstObjJsTag.add(new JavaScriptTag(JS_LIB_JQUERY_UI));
      lstObjJsTag.add(new JavaScriptTag(JS_LIB_MD5));
      lstObjJsTag.add(new JavaScriptTag(JS_LIB_DATE));
      lstObjJsTag.add(new JavaScriptTag(JS_LST_ERRO));
      lstObjJsTag.add(new JavaScriptTag(JS_OBJETO));
      lstObjJsTag.add(new JavaScriptTag(JS_ERRO));
      lstObjJsTag.add(new JavaScriptTag(JS_UTILS));
      lstObjJsTag.add(new JavaScriptTag(JS_APP_WEB));
      lstObjJsTag.add(new JavaScriptTag(JS_WEB_SOCKET));
      lstObjJsTag.add(new JavaScriptTag(JS_OBJ_WS_INTERLOCUTOR));
      lstObjJsTag.add(new JavaScriptTag(JS_USUARIO));
      lstObjJsTag.add(new JavaScriptTag(JS_PAG_HTML));
      lstObjJsTag.add(new JavaScriptTag(JS_MENSAGEM));

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Adiciona códigos "JavaScript" indispensáveis para cada página. Este método
   * é chamado durante o método "montarLayout".
   */
  protected void addJsCodigo(JavaScriptTag tagJs) {

    String strJs;
    Usuario objUsuario;

    try {

      objUsuario = AppWeb.getI().getObjUsuarioAtual();

      strJs = "";
      strJs += "appWeb.setStrSessionId('" + objUsuario.getStrSessaoId() + "');";
      strJs += "objUsuario.setBooLogado(" + objUsuario.getBooLogado() + ");";
      strJs += "objUsuario.setIntUsuarioId(" + objUsuario.getIntUsuarioId() + ");";
      strJs += "objUsuario.setStrNome('" + objUsuario.getStrNome() + "');";

      this.addJsCodigoMensagem(tagJs);
      tagJs.addJsCodigo(strJs);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Adiciona código "JavaScript" para ser executado no cliente após o processo
   * de carregamento ser concluído.
   */
  public void addJsCodigo(String strJsCodigo) {

    try {

      this.getTagJsMain().addJsCodigo(strJsCodigo);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Adiciona as estrutura das mensagens para as suas respectivas variáveis
   * "JavaScript".
   */
  private void addJsCodigoMensagem(JavaScriptTag tagJs) {

    String strJs;
    Mensagem msgAlerta;
    Mensagem msgLoad;
    Mensagem msgNegativa;
    Mensagem msgPositiva;

    try {

      msgAlerta = new Mensagem();
      msgAlerta.setEnmTipo(Mensagem.EnmTipo.ALERTA);

      msgLoad = new Mensagem();
      msgLoad.setEnmTipo(Mensagem.EnmTipo.LOAD);

      msgNegativa = new Mensagem();
      msgNegativa.setEnmTipo(Mensagem.EnmTipo.NEGATIVA);

      msgPositiva = new Mensagem();
      msgPositiva.setEnmTipo(Mensagem.EnmTipo.POSITIVA);

      strJs = "";
      strJs += "Mensagem_ESTRUTURA_INFO_ALERTA = '" + msgAlerta.toString() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_LOAD = '" + msgLoad.toString() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_NEGATIVA = '" + msgNegativa.toString() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_POSITIVA = '" + msgPositiva.toString() + "';";

      tagJs.addJsCodigo(strJs);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  private boolean getBooPagSimples() {

    return _booPagSimples;
  }

  private CssTag getCssImp() {

    try {

      if (_cssImp == null) {

        _cssImp = new CssTag();
        _cssImp.setStrId("cssImp");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _cssImp;
  }

  public CssTag getCssMain() {

    try {

      if (_cssMain == null) {

        _cssMain = CssTag.getIMain();
        _cssMain.setStrId("cssMain");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _cssMain;
  }

  public List<CssTag> getLstTagCss() {

    try {

      if (_lstTagCss != null) {
        return _lstTagCss;
      }

      _lstTagCss = new ArrayList<CssTag>();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return _lstTagCss;
  }

  public List<JavaScriptTag> getLstTagJs() {

    try {
      if (_lstTagJs != null) {
        return _lstTagJs;
      }

      _lstTagJs = new ArrayList<JavaScriptTag>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _lstTagJs;
  }

  private List<CssTag> getLstTagCssOrdenado() {

    boolean booCssAdicionado;

    try {

      if (_lstTagCssOrdenado != null) {
        return _lstTagCssOrdenado;
      }

      _lstTagCssOrdenado = new ArrayList<CssTag>();

      for (CssTag cssTag : this.getLstTagCss()) {

        booCssAdicionado = false;

        for (CssTag tagJsAdicionada : _lstTagCssOrdenado) {

          if (tagJsAdicionada.getStrAtributoFormatado().equals(cssTag.getStrAtributoFormatado())) {
            booCssAdicionado = true;
            break;
          }
        }

        if (!booCssAdicionado) {
          _lstTagCssOrdenado.add(cssTag);
        }
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _lstTagCssOrdenado;
  }

  private List<JavaScriptTag> getLstTagJsOrdenado() {

    boolean booJsAdicionado;

    try {

      if (_lstTagJsOrdenado != null) {
        return _lstTagJsOrdenado;
      }

      _lstTagJsOrdenado = new ArrayList<JavaScriptTag>();

      for (JavaScriptTag tagJs : this.getLstTagJs()) {

        booJsAdicionado = false;

        for (JavaScriptTag tagJsAdicionada : _lstTagJsOrdenado) {

          if (tagJsAdicionada.getSrc() == tagJs.getSrc()) {
            booJsAdicionado = true;
            break;
          }
        }

        if (!booJsAdicionado) {
          _lstTagJsOrdenado.add(tagJs);
        }
      }

      Collections.sort(_lstTagJsOrdenado, new Comparator<JavaScriptTag>() {

        @Override
        public int compare(final JavaScriptTag objJsTag1, final JavaScriptTag objJsTag2) {

          return objJsTag1.getIntPrioridade() < objJsTag2.getIntPrioridade() ? -1 : objJsTag1.getIntPrioridade() > objJsTag2.getIntPrioridade() ? +1 : 0;
        }
      });

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _lstTagJsOrdenado;
  }

  public String getStrPagFormatada() {

    String strResultado = Utils.STR_VAZIA;
    String strTagBodyConteudo = Utils.STR_VAZIA;
    StringBuilder stbHtml;

    try {

      this.montarLayout();
      this.addJsCodigo(this.getTagJsMain());

      strTagBodyConteudo += this.getTagBody().toString();
      strTagBodyConteudo += "</html>";

      this.addCssAoCabecalho();
      this.addJsAoCabecalho();

      stbHtml = new StringBuilder();
      stbHtml.append(this.getTagDocType().toString());
      stbHtml.append(this.getTagHtml().toString());

      strResultado = stbHtml.toString().replace("</html>", strTagBodyConteudo);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strResultado;
  }

  private String getStrSrcIcon() {

    try {

      if (!Utils.getBooStrVazia(_strSrcIcon)) {
        return _strSrcIcon;
      }

      _strSrcIcon = "res/media/favicon.ico";
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return _strSrcIcon;
  }

  public String getStrTitulo() {

    return _strTitulo;
  }

  public Tag getTagBody() {

    try {

      if (_tagBody == null) {

        _tagBody = new Tag("body");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagBody;
  }

  private Tag getTagDocType() {

    try {

      if (_tagDocType == null) {

        _tagDocType = new Tag("!DOCTYPE html");
        _tagDocType.setBooBarraNoFinal(false);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagDocType;
  }

  private Tag getTagHead() {

    try {

      if (_tagHead == null) {

        _tagHead = new Tag("head");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagHead;
  }

  private Tag getTagHtml() {

    try {

      if (_tagHtml == null) {

        _tagHtml = new Tag("html");
        _tagHtml.getLstAtr().add(new Atributo("xmlns", "http://www.w3.org/1999/xhtml"));
        _tagHtml.getLstAtr().add(new Atributo("lang", "pt-br"));
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagHtml;
  }

  private Tag getTagIcon() {

    try {

      if (_tagIcon == null) {

        _tagIcon = new Tag("link");
        _tagIcon.addAtr("rel", "shortcut icon");
        _tagIcon.addAtr("href", this.getStrSrcIcon());
        _tagIcon.addAtr("type", "image/x-icon");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagIcon;
  }

  public JavaScriptTag getTagJsMain() {

    try {

      if (_tagJsMain == null) {

        _tagJsMain = new JavaScriptTag(null);
        _tagJsMain.setIntPrioridade(6);

        this.getLstTagJs().add(_tagJsMain);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagJsMain;
  }

  private Tag getTagMeta() {

    try {

      if (_tagMeta == null) {

        _tagMeta = new Tag("meta");
        _tagMeta.getLstAtr().add(new Atributo("http-equiv", "Content-Type"));
        _tagMeta.getLstAtr().add(new Atributo("content"));
        _tagMeta.getLstAtr().get(1).setStrDelimitador(";");
        _tagMeta.getLstAtr().get(1).getLstStrValor().add("text/html");
        _tagMeta.getLstAtr().get(1).getLstStrValor().add(" charset=ISO-8859-1");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagMeta;
  }

  public Tag getTagTitle() {

    try {

      if (_tagTitle == null) {

        _tagTitle = new Tag("title");
        // _tagTitle.setStrTitulo("Página sem título");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagTitle;
  }

  /**
   * Método que monta o layout antes de gerar o html da página.
   */
  protected void montarLayout() {

    try {

      this.montarLayoutTitulo();
      this.getTagHead().setTagPai(this.getTagHtml());
      this.getTagMeta().setTagPai(this.getTagHead());
      this.getTagIcon().setTagPai(this.getTagHead());
      this.getTagTitle().setTagPai(this.getTagHead());
      this.getCssMain().setTagPai(this.getTagHead());
      this.getCssImp().setTagPai(this.getTagHead());

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  private void montarLayoutTitulo() {

    try {

      if (Utils.getBooStrVazia(this.getStrTitulo())) {
        this.setStrTitulo("Página sem título");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Mostra uma mensagem usando de informação ao cliente.
   */
  public void mostrarMsgCliente(Mensagem msg) {

    String strJs;

    try {

      strJs = "var ";
      strJs += "msg" + msg.getIntId();
      strJs += "= new Mensagem(";
      strJs += "'" + msg.getStrTitulo() + "',";
      strJs += "'" + msg.getStrMensagem() + "',";
      strJs += msg.getEnmTipo().ordinal();
      strJs += ");";
      strJs += "msg" + msg.getIntId() + ".mostrar();";

      this.addJsCodigo(strJs);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public void setBooPagSimples(boolean booPagSimples) {

    _booPagSimples = booPagSimples;
  }

  private void setI(PaginaHtml _i) {

    i = _i;
  }

  @Override
  public void setStrNome(String strNome) {

    super.setStrNome(strNome);

    try {

      this.setStrTitulo(strNome);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public void setStrSrcIcon(String strSrcIcon) {

    _strSrcIcon = strSrcIcon;
  }

  public void setStrTitulo(String strTitulo) {

    try {

      _strTitulo = strTitulo;
      _strTitulo += " - " + AppWeb.getI().getStrNome();

      this.getTagTitle().setStrConteudo(_strTitulo);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public String toHtml() {

    return this.getStrPagFormatada();
  }

  @Override
  public String toString() {

    return this.getStrPagFormatada();
  }

}
