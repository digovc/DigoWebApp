package com.digosofter.digowebapp.arquivo;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Arquivo extends Objeto {

  private String _dir;

  private String _dirCompleto;

  private String getDir() {
    return _dir;
  }

  protected String getDirCompleto() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (!Utils.getBooStrVazia(_dirCompleto)) {
        return _dirCompleto;
      }

      _dirCompleto = this.getDir();
      _dirCompleto += "\\";
      _dirCompleto += this.getStrNome();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _dirCompleto;
  }

  private void setDir(String dir) {
    _dir = dir;
  }

  private void setDirCompleto(String dirCompleto) {
    _dirCompleto = dirCompleto;
  }

}
