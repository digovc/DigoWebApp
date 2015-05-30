package com.digosofter.digowebapp;

import java.util.LinkedHashMap;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public class Usuario extends Objeto {

  private boolean _booLogado;
  private int _intUsuarioId;
  private LinkedHashMap<String, String> _mapPropriedade;
  private String _srcPerfil;
  private String _strPrimeiroNome;
  private String _strSessaoId;

  public Usuario() {

    try {

      AppWeb.getI().addUsr(this);
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

  public LinkedHashMap<String, String> getMapPropriedade() {

    try {

      if (_mapPropriedade != null) {

        return _mapPropriedade;
      }

      _mapPropriedade = new LinkedHashMap<String, String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _mapPropriedade;
  }

  public String getSrcPerfil() {

    return _srcPerfil;
  }

  public String getStrPrimeiroNome() {

    try {

      if (!Utils.getBooStrVazia(_strPrimeiroNome)) {

        return _strPrimeiroNome;
      }

      if (Utils.getBooStrVazia(this.getStrNome())) {

        return Utils.STR_VAZIA;
      }

      _strPrimeiroNome = this.getStrNome().split(" ")[0];
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strPrimeiroNome;
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