package com.digosofter.digowebapp.html.componente.item;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.componente.ComponenteMain;

public abstract class ItemMain extends ComponenteMain {

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_ITEM_MAIN));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
