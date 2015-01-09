package com.digosofter.digowebapp.html;

import com.digosofter.digojava.erro.Erro;

public class AtributoCss extends Atributo {

  private String _strClassAssociada;

  private String _strValor;

  public AtributoCss(String strNome, String strValor) {

    super(strNome);

    try {

      this.setStrValor(strValor);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

  }

  public String getStrClassAssociada() {

    return _strClassAssociada;
  }

  private String getstrValor() {

    return _strValor;
  }

  public void setStrClassAssociada(String strClassAssociada) {

    _strClassAssociada = strClassAssociada;
  }

  private void setstrValor(String strValor) {

    _strValor = strValor;
  }
}