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

  public String getStrAtrFormatado() {

    String strResultado;

    try {

      strResultado = "._class_nome{_att_nome:_att_valor}";

      strResultado = strResultado.replace("_class_nome", this.getStrClassAssociada());
      strResultado = strResultado.replace("_att_nome", this.getStrNome());
      strResultado = strResultado.replace("_att_valor", this.getStrValor());

      return strResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String getStrClassAssociada() {

    return _strClassAssociada;
  }

  @Override
  public String getStrValor() {

    return _strValor;
  }

  public void setStrClassAssociada(String strClassAssociada) {

    _strClassAssociada = strClassAssociada;
  }

  @Override
  public void setStrValor(String strValor) {

    _strValor = strValor;
  }
}