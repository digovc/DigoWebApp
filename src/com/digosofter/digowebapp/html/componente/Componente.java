package com.digosofter.digowebapp.html.componente;

import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.LimiteFloat;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.Tag;

public abstract class Componente extends Tag {

  private Painel _pnlComando;
  private Painel _pnlTitulo;
  private LimiteFloat _tagLimiteFloat;

  public Componente() {

    super("div");
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.DIR_JS_COMPONENTE_MAIN));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public Painel getPnlComando() {

    try {

      if (_pnlComando != null) {

        return _pnlComando;
      }

      _pnlComando = new Painel();

      _pnlComando.addCss(CssTag.getIMain().setPaddingLeft(10));
      _pnlComando.addCss(CssTag.getIMain().setPaddingRight(10));
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

      if (_pnlTitulo != null) {

        return _pnlTitulo;
      }

      _pnlTitulo = new Painel();
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

      if (_tagLimiteFloat != null) {

        return _tagLimiteFloat;
      }

      _tagLimiteFloat = new LimiteFloat();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagLimiteFloat;
  }
}