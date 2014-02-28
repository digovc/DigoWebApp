package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {

  public Botao() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrTagNome("button");
      this.setStrConteudo("Botão");
      this.addCss(CssTag.getCssMainInst().setFloat("right"));
      this.addCss(CssTag.getCssMainInst().setPaddingBottom(7));
      this.addCss(CssTag.getCssMainInst().setPaddingLeft(25));
      this.addCss(CssTag.getCssMainInst().setPaddingRight(25));
      this.addCss(CssTag.getCssMainInst().setPaddingTop(7));

      PaginaHtml.getI().getLstObjJavaScriptTag()
          .add(new JavaScriptTag("res/js/lib/JDigo/html/Botao.js"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
