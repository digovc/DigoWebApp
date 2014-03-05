package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

public class Painel extends Tag {

  public Painel() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrTagNome("div");
      this.setBooForcarTagDupla(true);
      this.addCss(CssTag.getCssMainInst().setTextAlign("center"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_PAINEL));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
