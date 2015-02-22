package com.digosofter.digowebapp;

import java.util.HashMap;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;

public class Usuario extends Objeto {

  public static Usuario getUsrPorSessionId(String strSessionId) {

    try {

      for (Usuario objUsuario : AppWeb.getI().getLstUsrSessao()) {

        if (!objUsuario.getStrSessaoId().equals(strSessionId)) {

          continue;
        }

        return objUsuario;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  private boolean _booLogado;
  private int _intUsuarioId;
  private HashMap<String, String> _lstKeyValue;
  private String _srcPerfil;
  private String _strSessaoId;

  public Usuario() {

    try {

      AppWeb.getI().getLstUsrSessao().add(this);
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

  public String getSrcPerfil() {

    return _srcPerfil;
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

  public void setSrcPerfil(String srcPerfil) {

    _srcPerfil = srcPerfil;
  }

  public void setStrSessaoId(String strSessaoId) {

    _strSessaoId = strSessaoId;
  }
}