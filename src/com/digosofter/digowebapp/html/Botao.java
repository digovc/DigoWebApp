package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {

  public Botao() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrTagNome("button");
      this.setStrConteudo("Bot�o");
      this.addCss(CssTag.getCssMainInst().setColor("#333"));
      this.addCss(CssTag.getCssMainInst().setFloat("right"));
      this.addCss(CssTag.getCssMainInst().setPaddingBottom(7));
      this.addCss(CssTag.getCssMainInst().setPaddingLeft(25));
      this.addCss(CssTag.getCssMainInst().setPaddingRight(25));
      this.addCss(CssTag.getCssMainInst().setPaddingTop(7));
      this.addCss(CssTag.getCssMainInst().setFontNegrito());

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

}
