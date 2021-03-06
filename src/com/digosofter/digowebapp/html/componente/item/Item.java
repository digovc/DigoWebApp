package com.digosofter.digowebapp.html.componente.item;

import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.componente.Componente;

public abstract class Item extends Componente {

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.DIR_JS_ITEM_MAIN));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}