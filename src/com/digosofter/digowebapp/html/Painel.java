package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

public class Painel extends Tag {

  public Painel() {

    super("div");

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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_PAINEL));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.addCss(tagCss.setTextAlign("center"));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
