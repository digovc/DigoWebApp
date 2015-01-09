package com.digosofter.digowebapp.html;

import com.digosofter.digojava.erro.Erro;

public class LimiteFloat extends Tag {

  public LimiteFloat() {

    super("div");

    try {

      this.setBooForcarTagDupla(true);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      this.addCss(tagCss.setClearBoth());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}