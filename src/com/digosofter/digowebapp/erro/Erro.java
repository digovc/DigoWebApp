package com.digosofter.digowebapp.erro;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;

public class Erro extends Objeto {

  private String _strMensagem;

  private String _strMensagemDetalhada;

  public Erro(String strMensagem, Exception ex) {

    try {

      if (ex != null) {
        ex.printStackTrace();
      }

      if (!Utils.getBooStrVazia(strMensagem)) {
        System.out.println(strMensagem);
      }

    }
    catch (Exception ex2) {
    }
    finally {
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
