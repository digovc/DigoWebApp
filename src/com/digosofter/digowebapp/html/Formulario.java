package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Formulario extends Tag {

  public enum EnmMetodo {

    GET,
    POST,
  }

  private EnmMetodo _enmMetodo = EnmMetodo.POST;
  private String _strAction;

  public Formulario(String strAction, EnmMetodo enmMetodo) {

    super("form");

    try {

      this.setEnmMetodo(enmMetodo);
      this.setStrAction(strAction);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.DIR_JS_FORMULARIO));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected EnmMetodo getEnmMetodo() {

    return _enmMetodo;
  }

  protected String getStrAction() {

    return _strAction;
  }

  private void setEnmMetodo(EnmMetodo enmMetodo) {

    String strMetodo;

    try {

      _enmMetodo = enmMetodo;

      switch (_enmMetodo) {

        case POST:
          strMetodo = "post";
          break;

        default:
          strMetodo = "get";
          break;
      }

      this.getLstAtr().add(new Atributo("method", strMetodo));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setStrAction(String strAction) {

    try {

      _strAction = strAction;

      if (Utils.getBooStrVazia(_strAction)) {

        return;
      }

      this.getLstAtr().add(new Atributo("action", _strAction));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}