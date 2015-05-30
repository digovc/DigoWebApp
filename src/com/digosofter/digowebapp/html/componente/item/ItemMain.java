package com.digosofter.digowebapp.html.componente.item;

import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.componente.ComponenteMain;

public abstract class ItemMain extends ComponenteMain {

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.STR_JS_ITEM_MAIN));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}