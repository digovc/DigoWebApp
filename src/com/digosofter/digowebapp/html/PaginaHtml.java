package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Usuario;
import com.digosofter.digowebapp.html.componente.Mensagem;

public class PaginaHtml extends Objeto {

  public static final String DIR_JS_APP_WEB = "res/js/lib/JDigo/AppWeb.js";
  public static final String DIR_JS_ERRO = "res/js/lib/JDigo/erro/Erro.js";
  public static final String DIR_JS_LIB_DATE = "res/js/lib/JDigo/lib/date.js";
  public static final String DIR_JS_LIB_JQUERY = "res/js/lib/JDigo/lib/jquery-2.1.3.min.js";
  public static final String DIR_JS_LIB_JQUERY_UI = "res/js/lib/JDigo/lib/jquery-ui.min.js";
  public static final String DIR_JS_LIB_MD5 = "res/js/lib/JDigo/lib/md5.js";
  public static final String DIR_JS_LST_ERRO = "res/js/lib/JDigo/lista/LstStrErro.js";
  public static final String DIR_JS_MENSAGEM = "res/js/lib/JDigo/html/componente/Mensagem.js";
  public static final String DIR_JS_OBJ_WS_INTERLOCUTOR = "res/js/lib/JDigo/websocket/ObjWsInterlocutor.js";
  public static final String DIR_JS_OBJETO = "res/js/lib/JDigo/Objeto.js";
  public static final String DIR_JS_PAG_HTML = "res/js/lib/JDigo/html/PaginaHtml.js";
  public static final String DIR_JS_USUARIO = "res/js/lib/JDigo/Usuario.js";
  public static final String DIR_JS_UTILS = "res/js/lib/JDigo/Utils.js";
  public static final String DIR_JS_WEB_SOCKET = "res/js/lib/JDigo/websocket/WebSocketMain.js";
  private static PaginaHtml i;

  public static PaginaHtml getI() {

    try {

      if (i != null) {

        return i;
      }

      i = new PaginaHtml();
    }
    catch (Exception ex) {

      new Erro("Erro ao instanciar objeto do tipo 'PaginaHtml'.\n", ex);
    }
    finally {
    }

    return i;
  }

  private boolean _booPagSimples;
  private List<CssTag> _lstTagCss;
  private List<CssTag> _lstTagCssOrdenado;
  private List<DartTag> _lstTagDart;
  private List<DartTag> _lstTagDartOrdenado;
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
      this.addCss(this.getLstTagCss());
      this.addJsArquivo(this.getLstTagJs());
      this.addJsDart(this.getLstTagDart());
      this.addJsCodigoMensagem();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void addCss() {

    try {

      if (this.getBooPagSimples()) {

        return;
      }

      for (CssTag cssTag : this.getLstTagCssOrdenado()) {

        if (cssTag == null) {

          continue;
        }

        cssTag.setTagPai(this.getTagHead());
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void addCss(List<CssTag> lstTagCss) {

  }

  private void addDart() {

    try {

      if (this.getBooPagSimples()) {

        return;
      }

      for (DartTag tagDart : this.getLstTagDartOrdenado()) {

        if (tagDart == null) {

          continue;
        }

        tagDart.setTagPai(this.getTagHead());
      }
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
  private void addJs() {

    try {

      if (this.getBooPagSimples()) {

        return;
      }

      this.addJsCodigo(this.getTagJsMain());

      for (JavaScriptTag tagJs : this.getLstTagJsOrdenado()) {

        if (tagJs == null) {

          continue;
        }

        tagJs.setTagPai(this.getTagHead());
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

      // lstObjJsTag.add(new JavaScriptTag("res/dart/main.dart.js"));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_LIB_JQUERY));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_LIB_JQUERY_UI));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_LIB_MD5));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_LIB_DATE));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_LST_ERRO));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_OBJETO));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_ERRO));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_UTILS));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_APP_WEB));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_WEB_SOCKET));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_OBJ_WS_INTERLOCUTOR));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_USUARIO));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_PAG_HTML));
      lstObjJsTag.add(new JavaScriptTag(DIR_JS_MENSAGEM));
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
    Usuario usr;

    try {

      usr = AppWeb.getI().getUsrAtual();

      if (usr == null) {

        return;
      }

      strJs = "";

      strJs += "appWeb.setStrSessionId('" + usr.getStrSessaoId() + "');";
      strJs += "objUsuario.setBooLogado(" + usr.getBooLogado() + ");";
      strJs += "objUsuario.setIntUsuarioId(" + usr.getIntUsuarioId() + ");";
      strJs += "objUsuario.setStrNome('" + usr.getStrNome() + "');";

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

      if (Utils.getBooStrVazia(strJsCodigo)) {

        return;
      }

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
  private void addJsCodigoMensagem() {

    Mensagem msgAlerta;
    Mensagem msgLoad;
    Mensagem msgNegativa;
    Mensagem msgPositiva;
    String strJs;

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

      strJs += "Mensagem_ESTRUTURA_INFO_ALERTA = '" + msgAlerta.toHtml() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_LOAD = '" + msgLoad.toHtml() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_NEGATIVA = '" + msgNegativa.toHtml() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_POSITIVA = '" + msgPositiva.toHtml() + "';";

      this.getTagJsMain().addJsCodigo(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected void addJsDart(List<DartTag> lstTagDart) {

    try {

      lstTagDart.add(new DartTag("res/dart/main.dart"));
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

  private List<CssTag> getLstTagCssOrdenado() {

    List<String> lstStrAtrAdicionado;

    try {

      if (_lstTagCssOrdenado != null) {

        return _lstTagCssOrdenado;
      }

      _lstTagCssOrdenado = new ArrayList<CssTag>();
      lstStrAtrAdicionado = new ArrayList<String>();

      for (CssTag cssTag : this.getLstTagCss()) {

        if (cssTag == null) {

          continue;
        }

        if (lstStrAtrAdicionado.contains(cssTag.getStrAtributoFormatado())) {

          continue;
        }

        _lstTagCssOrdenado.add(cssTag);
        lstStrAtrAdicionado.add(cssTag.getStrAtributoFormatado());
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstTagCssOrdenado;
  }

  public List<DartTag> getLstTagDart() {

    try {

      if (_lstTagDart != null) {

        return _lstTagDart;
      }

      _lstTagDart = new ArrayList<DartTag>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstTagDart;
  }

  private List<DartTag> getLstTagDartOrdenado() {

    List<String> lstSrcDartAdicionado;

    try {

      if (_lstTagDartOrdenado != null) {

        return _lstTagDartOrdenado;
      }

      _lstTagDartOrdenado = new ArrayList<DartTag>();
      lstSrcDartAdicionado = new ArrayList<String>();

      for (DartTag tagDart : this.getLstTagDart()) {

        if (tagDart == null) {

          continue;
        }

        if (lstSrcDartAdicionado.contains(tagDart.getSrc())) {

          continue;
        }

        _lstTagDartOrdenado.add(tagDart);
        lstSrcDartAdicionado.add(tagDart.getSrc());
      }

      Collections.sort(_lstTagDartOrdenado, new Comparator<DartTag>() {

        @Override
        public int compare(final DartTag tagDart, final DartTag tagDart2) {

          return tagDart.getIntPrioridade() < tagDart2.getIntPrioridade() ? -1 : tagDart.getIntPrioridade() > tagDart2.getIntPrioridade() ? +1 : 0;
        }
      });
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstTagDartOrdenado;
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

  private List<JavaScriptTag> getLstTagJsOrdenado() {

    List<String> lstSrcJsAdicionado;

    try {

      if (_lstTagJsOrdenado != null) {

        return _lstTagJsOrdenado;
      }

      _lstTagJsOrdenado = new ArrayList<JavaScriptTag>();
      lstSrcJsAdicionado = new ArrayList<String>();

      for (JavaScriptTag tagJs : this.getLstTagJs()) {

        if (tagJs == null) {

          continue;
        }

        if (lstSrcJsAdicionado.contains(tagJs.getSrc())) {

          continue;
        }

        _lstTagJsOrdenado.add(tagJs);
        lstSrcJsAdicionado.add(tagJs.getSrc());
      }

      Collections.sort(_lstTagJsOrdenado, new Comparator<JavaScriptTag>() {

        @Override
        public int compare(final JavaScriptTag tagJs, final JavaScriptTag tagJs2) {

          return tagJs.getIntPrioridade() < tagJs2.getIntPrioridade() ? -1 : tagJs.getIntPrioridade() > tagJs2.getIntPrioridade() ? +1 : 0;
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

  private String getStrSrcIcon() {

    try {

      if (!Utils.getBooStrVazia(_strSrcIcon)) {

        return _strSrcIcon;
      }

      _strSrcIcon = "res/media/ico/favicon.ico";
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

      if (_tagBody != null) {

        return _tagBody;
      }

      _tagBody = new Tag("body");
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

      if (_tagDocType != null) {

        return _tagDocType;
      }

      _tagDocType = new Tag("!DOCTYPE");

      _tagDocType.addAtr("html");

      _tagDocType.setBooBarraNoFinal(false);
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

      if (_tagHead != null) {

        return _tagHead;
      }

      _tagHead = new Tag("head");
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

      if (_tagHtml != null) {

        return _tagHtml;
      }

      _tagHtml = new Tag("html");

      _tagHtml.addAtr("xmlns", "http://www.w3.org/1999/xhtml");
      _tagHtml.addAtr("lang", "pt-br");
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

      if (_tagIcon != null) {

        return _tagIcon;
      }

      _tagIcon = new Tag("link");

      _tagIcon.addAtr("rel", "shortcut icon");
      _tagIcon.addAtr("href", this.getStrSrcIcon());
      _tagIcon.addAtr("type", "image/x-icon");
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

      if (_tagJsMain != null) {

        return _tagJsMain;
      }

      _tagJsMain = new JavaScriptTag(null);

      _tagJsMain.setIntPrioridade(6);

      this.getLstTagJs().add(_tagJsMain);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagJsMain;
  }

  // TODO: As tags "meta" só podem carregar um único atributo. Sendo assim
  // precisa mudar este para uma lista.
  private Tag getTagMeta() {

    try {

      if (_tagMeta != null) {

        return _tagMeta;
      }

      _tagMeta = new Tag("meta");

      _tagMeta.addAtr("http-equiv", "Content-Type");
      _tagMeta.addAtr("content", this.getStrDescricao());
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

      if (_tagTitle != null) {

        return _tagTitle;
      }

      _tagTitle = new Tag("title");

      _tagTitle.setStrConteudo("Página sem nome");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagTitle;
  }

  /**
   * Método que monta o layout antes de gerar o HTML da página.
   */
  protected void montarLayout() {

    try {

      this.getTagTitle().setTagPai(this.getTagHead());
      this.getTagMeta().setTagPai(this.getTagHead());
      this.getTagIcon().setTagPai(this.getTagHead());

      CssTag.getIImpr().setTagPai(this.getTagHead());
      CssTag.getIMain().setTagPai(this.getTagHead());
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

    try {

      if (msg == null) {

        return;
      }

      this.addJsCodigo(msg.getStrJsCodigo());
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

      if (Utils.getBooStrVazia(strTitulo)) {

        return;
      }

      _strTitulo = "_titulo - _app_nome";

      _strTitulo = _strTitulo.replace("_titulo", strTitulo);
      _strTitulo = _strTitulo.replace("_app_nome", AppWeb.getI().getStrNome());

      this.getTagTitle().setStrConteudo(_strTitulo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public String toHtml() {

    String strBody;
    String strConteudo;
    String strHead;
    String strResultado;

    try {

      this.montarLayout();

      strBody = this.getTagBody().toHtml();

      this.addCss();
      this.addJs();
      this.addDart();

      strHead = this.getTagHead().toHtml();

      strConteudo = "_head_body";
      strConteudo = strConteudo.replace("_head", strHead);
      strConteudo = strConteudo.replace("_body", strBody);

      this.getTagHtml().setStrConteudo(strConteudo);

      strResultado = "_tag_doc_type_tag_html";
      strResultado = strResultado.replace("_tag_doc_type", this.getTagDocType().toHtml());
      strResultado = strResultado.replace("_tag_html", this.getTagHtml().toHtml());

      return strResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }
}