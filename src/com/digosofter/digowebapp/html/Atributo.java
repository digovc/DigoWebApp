package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Atributo extends Objeto {

  private List<String> _lstStrValor;
  private String _strDelimitador;
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

    try {

      if (_lstStrValor != null) {
        return _lstStrValor;
      }

      _lstStrValor = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _lstStrValor;
  }

  public String getStrDelimitador() {

    try {

      if (!Utils.getBooStrVazia(_strDelimitador)) {
        return _strDelimitador;
      }

      _strDelimitador = " ";

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return _strDelimitador;
  }

  public String getStrValor() {

    try {

      if (!Utils.getBooStrVazia(_strValor)) {
        return _strValor;
      }

      _strValor = Utils.STR_VAZIA;

      for (String strValor : this.getLstStrValor()) {
        if (Utils.getBooStrVazia(strValor)) {
          continue;
        }
        _strValor += strValor;
        _strValor += this.getStrDelimitador();
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _strValor;
  }

  public void setStrDelimitador(String strDelimitador) {

    _strDelimitador = strDelimitador;
  }

  public void setStrValor(String strValor) {

    try {

      _strValor = strValor;

      if (Utils.getBooStrVazia(_strValor)) {
        return;
      }

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
