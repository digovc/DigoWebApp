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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (i == null) {
        i = new PaginaHtml();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro ao instanciar objeto do tipo 'PaginaHtml'.\n", ex);

    } finally {
    }

    return i;
  }

  private CssTag _cssImp;

  private List<JavaScriptTag> _lstTagJs = new ArrayList<JavaScriptTag>();

  private List<JavaScriptTag> _lstTagJsOrdenado;

  private String _strSrcIcon = "res/media/favicon.ico";

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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setI(this);
      this.addJsArquivo(this.getLstTagJs());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Acrescenta os arquivos de "JavaScript" para a "tagHead" na ordem correta.
   */
  private void addJsAoCabecalho() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (JavaScriptTag objJavaScriptTag : this.getLstTagJsOrdenado()) {

        objJavaScriptTag.setTagPai(this.getTagHead());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona os arquivos "JavaScript" que fazem a página funcionar no
   * navegador.
   */
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

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

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona códigos "JavaScript" indispensáveis para cada página. Este método
   * é chamado durante o método "montarLayout".
   */
  protected void addJsCodigo(JavaScriptTag tagJs) {
    // VARIÁVEIS

    String strJs;
    Usuario objUsuario;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objUsuario = AppWeb.getI().getObjUsuarioAtual();

      strJs = "";
      strJs += "appWeb.setStrSessionId('" + objUsuario.getStrSessaoId() + "');";
      strJs += "objUsuario.setBooLogado(" + objUsuario.getBooLogado() + ");";
      strJs += "objUsuario.setIntUsuarioId(" + objUsuario.getIntUsuarioId() + ");";
      strJs += "objUsuario.setStrNome('" + objUsuario.getStrNome() + "');";

      this.addJsCodigoMensagem(tagJs);
      tagJs.addJsCodigo(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona código "JavaScript" para ser executado no cliente após o processo
   * de carregamento ser concluído.
   */
  public void addJsCodigo(String strJsCodigo) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getTagJsMain().addJsCodigo(strJsCodigo);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona as estrutura das mensagens para as suas respectivas variáveis
   * "JavaScript".
   */
  private void addJsCodigoMensagem(JavaScriptTag tagJs) {
    // VARIÁVEIS

    String strJs;
    Mensagem msgAlerta;
    Mensagem msgNegativa;
    Mensagem msgPositiva;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      msgAlerta = new Mensagem();
      msgAlerta.setEnmTipo(Mensagem.EnmTipo.ALERTA);

      msgNegativa = new Mensagem();
      msgNegativa.setEnmTipo(Mensagem.EnmTipo.NEGATIVA);

      msgPositiva = new Mensagem();
      msgPositiva.setEnmTipo(Mensagem.EnmTipo.POSITIVA);

      strJs = "";
      strJs += "Mensagem_ESTRUTURA_INFO_ALERTA = '" + msgAlerta.toString() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_NEGATIVA = '" + msgNegativa.toString() + "';";
      strJs += "Mensagem_ESTRUTURA_INFO_POSITIVA = '" + msgPositiva.toString() + "';";

      tagJs.addJsCodigo(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private CssTag getCssImp() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_cssImp == null) {

        _cssImp = new CssTag();
        _cssImp.setStrId("cssImp");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _cssImp;
  }

  public CssTag getCssMain() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_cssMain == null) {

        _cssMain = CssTag.getIMain();
        _cssMain.setStrId("cssMain");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _cssMain;
  }

  public List<JavaScriptTag> getLstTagJs() {
    return _lstTagJs;
  }

  private List<JavaScriptTag> getLstTagJsOrdenado() {
    // VARIÁVEIS

    boolean booJsAdicionado;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstTagJsOrdenado != null) {
        return _lstTagJsOrdenado;
      }

      _lstTagJsOrdenado = new ArrayList<JavaScriptTag>();

      for (JavaScriptTag tagJs : this.getLstTagJs()) {

        booJsAdicionado = false;

        for (JavaScriptTag tagJsAdicionada : _lstTagJsOrdenado) {

          if (tagJsAdicionada.getStrSrc() == tagJs.getStrSrc()) {
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

          return objJsTag1.getIntPrioridade() < objJsTag2.getIntPrioridade() ? -1 : (objJsTag1
              .getIntPrioridade() > objJsTag2.getIntPrioridade() ? +1 : 0);
        }
      });

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstTagJsOrdenado;
  }

  public String getStrPagFormatada() {
    // VARIÁVEIS

    String strResultado = Utils.STRING_VAZIA;
    String strTagBodyConteudo = Utils.STRING_VAZIA;
    StringBuilder stbHtml;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.montarLayout();
      this.addJsCodigo(this.getTagJsMain());

      strTagBodyConteudo += this.getTagBody().toString();
      strTagBodyConteudo += "</html>";

      this.addJsAoCabecalho();

      stbHtml = new StringBuilder();
      stbHtml.append(this.getTagDocType().toString());
      stbHtml.append(this.getTagHtml().toString());

      strResultado = stbHtml.toString().replace("</html>", strTagBodyConteudo);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  private String getStrSrcIcon() {
    return _strSrcIcon;
  }

  public String getStrTitulo() {
    return _strTitulo;
  }

  public Tag getTagBody() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagBody == null) {

        _tagBody = new Tag("body");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagBody;
  }

  private Tag getTagDocType() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagDocType == null) {

        _tagDocType = new Tag("!DOCTYPE html");
        _tagDocType.setBooBarraNoFinal(false);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagDocType;
  }

  private Tag getTagHead() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagHead == null) {

        _tagHead = new Tag("head");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagHead;
  }

  private Tag getTagHtml() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagHtml == null) {

        _tagHtml = new Tag("html");
        _tagHtml.getLstAtr().add(new Atributo("xmlns", "http://www.w3.org/1999/xhtml"));
        _tagHtml.getLstAtr().add(new Atributo("lang", "pt-br"));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagHtml;
  }

  private Tag getTagIcon() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagIcon == null) {

        _tagIcon = new Tag("link");
        _tagIcon.addAtr("rel", "shortcut icon");
        _tagIcon.addAtr("href", this.getStrSrcIcon());
        _tagIcon.addAtr("type", "image/x-icon");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagIcon;
  }

  public JavaScriptTag getTagJsMain() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagJsMain == null) {

        _tagJsMain = new JavaScriptTag(null);
        _tagJsMain.setIntPrioridade(6);

        this.getLstTagJs().add(_tagJsMain);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagJsMain;
  }

  private Tag getTagMeta() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagMeta == null) {

        _tagMeta = new Tag("meta");
        _tagMeta.getLstAtr().add(new Atributo("http-equiv", "Content-Type"));
        _tagMeta.getLstAtr().add(new Atributo("content"));
        _tagMeta.getLstAtr().get(1).setStrDelimitador(";");
        _tagMeta.getLstAtr().get(1).getLstStrValor().add("text/html");
        _tagMeta.getLstAtr().get(1).getLstStrValor().add(" charset=ISO-8859-1");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagMeta;
  }

  public Tag getTagTitle() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagTitle == null) {

        _tagTitle = new Tag("title");
        // _tagTitle.setStrTitulo("Página sem título");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagTitle;
  }

  /**
   * Método que monta o layout antes de gerar o html da página.
   */
  protected void montarLayout() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.montarLayoutTitulo();
      this.getTagHead().setTagPai(this.getTagHtml());
      this.getTagMeta().setTagPai(this.getTagHead());
      this.getTagIcon().setTagPai(this.getTagHead());
      this.getTagTitle().setTagPai(this.getTagHead());
      this.getCssMain().setTagPai(this.getTagHead());
      this.getCssImp().setTagPai(this.getTagHead());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutTitulo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Utils.getBooStrVazia(this.getStrTitulo())) {
        this.setStrTitulo("Página sem título");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Mostra uma mensagem usando de informação ao cliente.
   */
  public void mostrarMsgCliente(Mensagem msg) {
    // VARIÁVEIS

    String strJs;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strJs = "var ";
      strJs += "msg" + msg.getIntId();
      strJs += "= new Mensagem(";
      strJs += "'" + msg.getStrTitulo() + "',";
      strJs += "'" + msg.getStrMensagem() + "',";
      strJs += msg.getEnmTipo().ordinal();
      strJs += ");";
      strJs += "msg" + msg.getIntId() + ".mostrar();";

      this.addJsCodigo(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setI(PaginaHtml _i) {
    i = _i;
  }

  @Override
  public void setStrNome(String strNome) {

    super.setStrNome(strNome);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrTitulo(strNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrSrcIcon(String strSrcIcon) {
    _strSrcIcon = strSrcIcon;
  }

  public void setStrTitulo(String strTitulo) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strTitulo = strTitulo;
      _strTitulo += " - " + AppWeb.getI().getStrNome();

      this.getTagTitle().setStrConteudo(_strTitulo);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
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
