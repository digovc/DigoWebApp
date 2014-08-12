package com.digosofter.digowebapp.arquivo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Arquivo extends Objeto {

  private boolean _booExiste;
  private String _dir;
  private String _dirCompleto;
  private String _strConteudo;

  private boolean getBooExiste() {

    File fil;
    try {

      if (Utils.getBooStrVazia(this.getDirCompleto())) {
        return false;
      }

      fil = new File(this.getDirCompleto());
      _booExiste = fil.exists();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return _booExiste;
  }

  private String getDir() {

    return _dir;
  }

  protected String getDirCompleto() {

    try {

      if (!Utils.getBooStrVazia(_dirCompleto)) {
        return _dirCompleto;
      }

      _dirCompleto = this.getDir();
      _dirCompleto += "\\";
      _dirCompleto += this.getStrNome();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _dirCompleto;
  }

  public String getStrConteudo() {

    FileInputStream fis;

    try {

      if (Utils.getBooStrVazia(this.getDirCompleto())) {
        return Utils.STR_VAZIA;
      }

      if (!this.getBooExiste()) {
        return Utils.STR_VAZIA;
      }

      fis = new FileInputStream(this.getDirCompleto());
      _strConteudo = IOUtils.toString(fis, "UTF-8");

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _strConteudo;
  }

  public void setDir(String dir) {

    _dir = dir;
  }

  public void setDirCompleto(String dirCompleto) {

    File fil;
    try {

      _dirCompleto = dirCompleto;

      if (Utils.getBooStrVazia(_dirCompleto)) {
        return;
      }

      if (!this.getBooExiste()) {
        return;
      }

      fil = new File(_dirCompleto);
      this.setDir(fil.getPath());
      this.setStrNome(fil.getName());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public void setStrConteudo(String strConteudo) {

    _strConteudo = strConteudo;
  }
}
