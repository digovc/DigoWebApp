package com.digosofter.digowebapp.erro;

import java.io.Console;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;

public class Erro extends Objeto {

  private String _strMensagem;

  private String _strMensagemDetalhada;

  public Erro(String strMensagem, Exception ex) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (ex != null) {
        ex.printStackTrace();
      }

      if (!Utils.getBooStrVazia(strMensagem)) {
        System.out.println(strMensagem);
      }

      // FIM A��ES
    } catch (Exception ex2) {
    } finally {
    }
  }

  protected String getStrMensagem() {
    return _strMensagem;
  }

  protected String getStrMensagemDetalhada() {
    return _strMensagemDetalhada;
  }

  protected void setStrMensagem(String strMensagem) {
    _strMensagem = strMensagem;
  }

  protected void setStrMensagemDetalhada(String strMensagemDetalhada) {
    _strMensagemDetalhada = strMensagemDetalhada;
  }

}
