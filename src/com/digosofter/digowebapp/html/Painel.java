package com.digosofter.digowebapp.html;

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

      PaginaHtml.getI().getLstObjJsTag()
          .add(new JavaScriptTag("res/js/lib/JDigo/html/Painel.js"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
