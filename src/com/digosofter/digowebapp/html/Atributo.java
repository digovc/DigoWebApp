package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Atributo extends Objeto {

  private List<String> _lstStrValor = new ArrayList<String>();

  private String _strDelimitador = " ";

  private String _strValor;

  public Atributo(String strNome) {

    try {

      if (Utils.getBooStrVazia(strNome)) {
        strNome = "attr";
      }

      this.setStrNome(strNome);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public Atributo(String strNome, String strValor) {

    try {

      if (Utils.getBooStrVazia(strNome)) {
        strNome = "attr";
      }

      this.setStrNome(strNome);
      this.setStrValor(strValor);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public List<String> getLstStrValor() {

    return _lstStrValor;
  }

  public String getStrDelimitador() {

    return _strDelimitador;
  }

  public String getStrValor() {

    return _strValor;
  }

  private void setLstStrValor(List<String> lstStrValor) {

    _lstStrValor = lstStrValor;
  }

  public void setStrDelimitador(String strDelimitador) {

    _strDelimitador = strDelimitador;
  }

  public void setStrValor(String strValor) {

    try {

      _strValor = strValor;

      this.getLstStrValor().clear();
      this.getLstStrValor().add(_strValor);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

}
