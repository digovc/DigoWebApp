package com.digosofter.digowebapp;

import java.util.HashMap;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;

public class Usuario extends Objeto {

  public static Usuario getObjUsuarioPelaSessionId(String strSessionId) {

    Usuario objUsuarioResultado = null;

    try {

      for (Usuario objUsuario : AppWeb.getI().getLstObjUsuarioSessao()) {

        if (objUsuario.getStrSessaoId().equals(strSessionId)) {

          objUsuarioResultado = objUsuario;
          break;
        }
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return objUsuarioResultado;
  }

  private boolean _booLogado;

  private int _intUsuarioId;

  private HashMap<String, String> _lstKeyValue;
  private String _strSessaoId;

  public Usuario() {

    try {

      AppWeb.getI().getLstObjUsuarioSessao().add(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public boolean getBooLogado() {

    return _booLogado;
  }

  public int getIntUsuarioId() {

    return _intUsuarioId;
  }

  public HashMap<String, String> getLstKeyValue() {

    try {

      if (_lstKeyValue != null) {

        return _lstKeyValue;
      }

      _lstKeyValue = new HashMap<String, String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
    return _lstKeyValue;
  }

  public String getStrSessaoId() {

    return _strSessaoId;
  }

  public void setBooLogado(boolean booLogado) {

    _booLogado = booLogado;
  }

  public void setIntUsuarioId(int intUsuarioId) {

    _intUsuarioId = intUsuarioId;
  }

  public void setStrSessaoId(String strSessaoId) {

    _strSessaoId = strSessaoId;
  }
}