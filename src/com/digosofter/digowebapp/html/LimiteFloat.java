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

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.addCss(tagCss.setClearBoth());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
