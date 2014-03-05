package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

public class Formulario extends Tag {

  public enum EnmMetodo {
    GET, POST
  }

  private EnmMetodo _enmMetodo = EnmMetodo.POST;

  private String _strAction;

  public Formulario(String strAction, EnmMetodo enmMetodo) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrTagNome("form");
      this.setStrAction(strAction);
      this.setEnmMetodo(enmMetodo);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_FORMULARIO));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private EnmMetodo getEnmMetodo() {
    return _enmMetodo;
  }

  private String getStrAction() {
    return _strAction;
  }

  private void setEnmMetodo(EnmMetodo enmMetodo) {
    // VARI�VEIS

    String strMetodo;

    // FIM VARI�VEIS
    try {
      // A��ES

      _enmMetodo = enmMetodo;
      switch (_enmMetodo) {
        case GET:
          strMetodo = "get";
          break;
        case POST:
          strMetodo = "post";
          break;
        default:
          strMetodo = "get";
          break;
      }

      this.getLstAtr().add(new Atributo("method", strMetodo));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setStrAction(String strAction) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      _strAction = strAction;
      this.getLstAtr().add(new Atributo("action", _strAction));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
