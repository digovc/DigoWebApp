package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Botao extends Tag {

  public Botao() {

    super("button");

    try {

      this.setStrConteudo("Botão");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.STR_JS_BOTAO));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      this.addCss(tagCss.setColor("#333"));
      this.addCss(tagCss.setFloat("right"));
      this.addCss(tagCss.setFontNegrito());
      this.addCss(tagCss.setPaddingBottom(7));
      this.addCss(tagCss.setPaddingLeft(25));
      this.addCss(tagCss.setPaddingRight(25));
      this.addCss(tagCss.setPaddingTop(7));
      this.addCss(tagCss.setMarginLeft(5));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}