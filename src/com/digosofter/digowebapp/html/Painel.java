package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Painel extends Tag {

  private boolean _booMarkdown;

  public Painel() {

    super("div");

    try {

      this.setBooForcarTagDupla(true);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void addCssArquivo(List<CssTag> lstTagCss) {

    super.addCssArquivo(lstTagCss);

    try {

      this.addCssArquivoMarkdown(lstTagCss);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void addCssArquivoMarkdown(List<CssTag> lstTagCss) {

    CssTag cssMarkdown;
    CssTag cssMarkdownMonoBlue;

    try {

      if (!this.getBooMarkdown()) {

        return;
      }

      cssMarkdown = new CssTag();

      cssMarkdown.addAtr("href", "res/css/markdown.css");
      cssMarkdown.addAtr("rel", "stylesheet");

      lstTagCss.add(cssMarkdown);

      cssMarkdownMonoBlue = new CssTag();
      cssMarkdownMonoBlue.addAtr("href", "res/css/markdown-mono-blue.css");
      cssMarkdownMonoBlue.addAtr("rel", "stylesheet");

      lstTagCss.add(cssMarkdownMonoBlue);
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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.STR_JS_PAINEL));

      if (!this.getBooMarkdown()) {

        return;
      }

      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/lib/Markdown.Converter.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/lib/Markdown.Extra.js"));
      lstObjJsTag.add(new JavaScriptTag("res/js/lib/JDigo/lib/highlight.pack.js"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void addJsCodigoConverterMarkdown() {

    String strJsCodigo;

    try {

      if (!this.getBooMarkdown()) {

        return;
      }

      strJsCodigo = Utils.STR_VAZIA;

      strJsCodigo += "var objMdConverter = new Markdown.Converter();";
      strJsCodigo += "Markdown.Extra.init(objMdConverter);";
      strJsCodigo += "var strHtml = objMdConverter.makeHtml($('#_pnl_id').html());";
      strJsCodigo += "$('#_pnl_id').html(strHtml);";
      strJsCodigo += "hljs.initHighlightingOnLoad();";

      strJsCodigo = strJsCodigo.replace("_pnl_id", this.getStrId());

      PaginaHtml.getI().addJsCodigo(strJsCodigo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private boolean getBooMarkdown() {

    return _booMarkdown;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      if (!this.getBooMarkdown()) {

        return;
      }

      this.addJsCodigoConverterMarkdown();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setBooMarkdown(boolean booMarkdown) {

    _booMarkdown = booMarkdown;
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      this.addCss(tagCss.setTextAlign("center"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}