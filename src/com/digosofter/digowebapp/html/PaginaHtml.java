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

public class PaginaHtml extends Objeto {

  private static CssTag _cssMain;

  private static PaginaHtml i;

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

  private List<JavaScriptTag> _lstObjJsTag = new ArrayList<JavaScriptTag>();

  private List<JavaScriptTag> _lstObjJsTagOrdenado;

  private JavaScriptTag _tagJsMain;

  private String _strTitulo;

  private Tag _tagBody;

  private Tag _tagDocType;

  private Tag _tagHead;

  private Tag _tagHtml;

  private Tag _tagMeta;

  private Tag _tagTitle;

  public PaginaHtml() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setI(this);
      this.addJsArquivo(this.getLstObjJsTag());

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

      for (JavaScriptTag objJavaScriptTag : this.getLstObjJsTagOrdenado()) {

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

      // TODO: Colocar a localização dos arquivos dentro de constantes na classe
      // "AppWeb".

      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/lib/jquery-2.0.3.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/lib/md5.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/lista/LstStrErro.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/erro/Erro.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/Utils.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/Objeto.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/AppWeb.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/websocket/WebSocketMain.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/websocket/ObjWsInterlocutor.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/Usuario.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/html/PaginaHtml.js"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona códigos "JavaScript" indispensáveis para cada página.
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

      tagJs.addJsCodigo(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void adicionarJsCodigo(String strJsCodigo) {
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

        _cssMain = CssTag.getCssMainInst();
        _cssMain.setStrId("cssMain");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _cssMain;
  }

  public List<JavaScriptTag> getLstObjJsTag() {
    return _lstObjJsTag;
  }

  private List<JavaScriptTag> getLstObjJsTagOrdenado() {
    // VARIÁVEIS

    boolean booJsAdicionado;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstObjJsTagOrdenado != null) {
        return _lstObjJsTagOrdenado;
      }

      _lstObjJsTagOrdenado = new ArrayList<JavaScriptTag>();

      for (JavaScriptTag tagJs : this.getLstObjJsTag()) {

        booJsAdicionado = false;

        for (JavaScriptTag tagJsAdicionada : _lstObjJsTagOrdenado) {

          if (tagJsAdicionada.getStrSrc() == tagJs.getStrSrc()) {
            booJsAdicionado = true;
            break;
          }
        }

        if (!booJsAdicionado) {
          _lstObjJsTagOrdenado.add(tagJs);
        }
      }

      Collections.sort(_lstObjJsTagOrdenado, new Comparator<JavaScriptTag>() {

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

    return _lstObjJsTagOrdenado;
  }

  public JavaScriptTag getTagJsMain() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagJsMain == null) {

        _tagJsMain = new JavaScriptTag(null);
        _tagJsMain.setIntPrioridade(6);

        this.getLstObjJsTag().add(_tagJsMain);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagJsMain;
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

  public String getStrTitulo() {
    return _strTitulo;
  }

  public Tag getTagBody() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagBody == null) {

        _tagBody = new Tag();
        _tagBody.setStrTagNome("body");
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

        _tagDocType = new Tag();
        _tagDocType.setBooBarraNoFinal(false);
        _tagDocType.setStrTagNome("!DOCTYPE html");
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

        _tagHead = new Tag();
        _tagHead.setStrTagNome("head");
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

        _tagHtml = new Tag();
        _tagHtml.setStrTagNome("html");
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

  private Tag getTagMeta() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagMeta == null) {

        _tagMeta = new Tag();
        _tagMeta.setStrTagNome("meta");
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

        _tagTitle = new Tag();
        _tagTitle.setStrTagNome("title");

        this.setStrTitulo("Página sem título");
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

      this.getTagHead().setTagPai(this.getTagHtml());
      this.getTagMeta().setTagPai(this.getTagHead());
      this.getTagTitle().setTagPai(this.getTagHead());
      this.getCssMain().setTagPai(this.getTagHead());
      this.getCssImp().setTagPai(this.getTagHead());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void mostrarMsgInfoCliente(String strMensagem) {
    // VARIÁVEIS

    String strJsCodigo, strMensagemFormatada;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strMensagemFormatada = "Informação:";
      strMensagemFormatada += "\\n\\n\\n";
      strMensagemFormatada += strMensagem;

      strJsCodigo = "alert('" + strMensagemFormatada + "');";

      this.adicionarJsCodigo(strJsCodigo);

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
  };

  @Override
  public String toString() {
    return this.getStrPagFormatada();
  }

}
