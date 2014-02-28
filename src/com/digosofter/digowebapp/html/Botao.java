package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {

  public Botao() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrTagNome("button");
      this.setStrConteudo("Bot�o");
      this.addCss(CssTag.getCssMainInst().setFloat("right"));
      this.addCss(CssTag.getCssMainInst().setPaddingBottom(7));
      this.addCss(CssTag.getCssMainInst().setPaddingLeft(25));
      this.addCss(CssTag.getCssMainInst().setPaddingRight(25));
      this.addCss(CssTag.getCssMainInst().setPaddingTop(7));

      PaginaHtml.getI().getLstObjJavaScriptTag()
          .add(new JavaScriptTag("res/js/lib/JDigo/html/Botao.js"));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
