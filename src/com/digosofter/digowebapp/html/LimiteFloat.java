package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class LimiteFloat extends Tag {

  public LimiteFloat() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrTagNome("div");
      this.setBooForcarTagDupla(true);
      this.addCss(CssTag.getCssMainInst().setClearBoth());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
