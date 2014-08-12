package com.digosofter.digowebapp.html.componente;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.LimiteFloat;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.Tag;

public abstract class ComponenteMain extends Tag {

  private Painel _pnlComando;

  private Painel _pnlTitulo;

  private LimiteFloat _tagLimiteFloat;

  public ComponenteMain() {

    super("div");

    try {

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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_COMPONENTE_MAIN));

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public Painel getPnlComando() {

    try {

      if (_pnlComando == null) {

        _pnlComando = new Painel();
        _pnlComando.addCss(CssTag.getIMain().setPaddingLeft(10));
        _pnlComando.addCss(CssTag.getIMain().setPaddingRight(10));
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _pnlComando;
  }

  protected Painel getPnlTitulo() {

    try {

      if (_pnlTitulo == null) {
        _pnlTitulo = new Painel();
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _pnlTitulo;
  }

  protected LimiteFloat getTagLimiteFloat() {

    try {

      if (_tagLimiteFloat == null) {

        _tagLimiteFloat = new LimiteFloat();
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _tagLimiteFloat;
  }

}
