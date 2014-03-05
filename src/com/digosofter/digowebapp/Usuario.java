package com.digosofter.digowebapp;

import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.PaginaHtml;

public class Usuario extends Objeto {

  public static Usuario getObjUsuarioPelaSessionId(String strSessionId) {
    // VARIÁVEIS

    Usuario objUsuarioResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (Usuario objUsuario : AppWeb.getI().getLstObjUsuarioSessao()) {
        if (objUsuario.getStrSessaoId().equals(strSessionId)) {
          objUsuarioResultado = objUsuario;
          break;
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objUsuarioResultado;
  }

  private boolean _booLogado = false;

  private int _intUsuarioId;

  private String _strSessaoId;

  public Usuario() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      AppWeb.getI().getLstObjUsuarioSessao().add(this);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public boolean getBooLogado() {
    return _booLogado;
  }

  public int getIntUsuarioId() {
    return _intUsuarioId;
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