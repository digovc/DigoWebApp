package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

public class Imagem extends Tag {

  public Imagem() {

    super("img");

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setBooForcarTagDupla(true);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_IMAGEM));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrSrc(String strImagemSrc) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getLstAtr().add(new Atributo("src", strImagemSrc));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
