package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {

  public Botao() {

    super("button");

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrConteudo("Bot�o");

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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_BOTAO));

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

      this.addCss(tagCss.setColor("#333"));
      this.addCss(tagCss.setFloat("right"));
      this.addCss(tagCss.setFontNegrito());
      this.addCss(tagCss.setPaddingBottom(7));
      this.addCss(tagCss.setPaddingLeft(25));
      this.addCss(tagCss.setPaddingRight(25));
      this.addCss(tagCss.setPaddingTop(7));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
