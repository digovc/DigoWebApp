package com.digosofter.digowebapp.html;

import com.digosofter.digojava.erro.Erro;

public class DartTag extends Tag {

  private int _intPrioridade = 5;

  public DartTag(String strSrc) {

    super("script");

    try {

      this.addAtr("type", "application/dart");
      this.setBooForcarTagDupla(true);
      this.setSrc(strSrc);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public int getIntPrioridade() {

    return _intPrioridade;
  }

  public void setIntPrioridade(int intPrioridade) {

    _intPrioridade = intPrioridade;
  }
}