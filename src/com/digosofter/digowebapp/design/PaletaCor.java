package com.digosofter.digowebapp.design;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.PaginaHtml;

public class PaletaCor extends Objeto {

  private boolean _booSelecionado;
  private String _corBorda = "#e1e1e1";
  private String _corBorda2 = "#777777";
  private String _corControleClicado;
  private String _corControleMouse;
  private String _corControleNormal;
  private String _corFundo;
  private String _strObjJavaScriptNome = Utils.STR_VAZIA;
  private String _strSombra = "#e1e1e1";

  public PaletaCor(String strNome) {

    try {

      this.setStrNome(strNome);
      this.addJs("var " + this.getStrObjJavaScriptNome() + "= new PaletaCor('" + this.getStrNome() + "');");

      PaginaHtml.getI().getLstTagJs().add(new JavaScriptTag("res/js/lib/JDigo/design/PaletaCor.js"));

      AppWeb.getI().getLstObjPaletaCor().add(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void addJs(String strJs) {

    try {

      PaginaHtml.getI().addJsCodigo(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public boolean getBooSelecionado() {

    return _booSelecionado;
  }

  public String getCorBorda() {

    return _corBorda;
  }

  public String getCorBorda2() {

    return _corBorda2;
  }

  public String getCorControleClicado() {

    return _corControleClicado;
  }

  public String getCorControleMouse() {

    return _corControleMouse;
  }

  public String getCorControleNormal() {

    return _corControleNormal;
  }

  public String getCorFundo() {

    return _corFundo;
  }

  private String getStrObjJavaScriptNome() {

    try {

      if (!Utils.getBooStrVazia(_strObjJavaScriptNome)) {

        return _strObjJavaScriptNome;
      }

      _strObjJavaScriptNome = "objPaletaCor" + this.getStrNome();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strObjJavaScriptNome;
  }

  public String getStrSombra() {

    return _strSombra;
  }

  public void setBooSelecionado(boolean booSelecionado) {

    try {

      _booSelecionado = booSelecionado;

      if (_booSelecionado) {

        AppWeb.getI().setObjPaletaCorSelecionada(this);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setCorBorda(String corBorda) {

    String strJs;

    try {

      _corBorda = corBorda;

      strJs = this.getStrObjJavaScriptNome() + ".setCorControleClicado('" + _corControleClicado + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    _corBorda = corBorda;
  }

  public void setCorBorda2(String corBorda2) {

    try {

      _corBorda2 = corBorda2;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    _corBorda2 = corBorda2;
  }

  public void setCorControleClicado(String corControleClicado) {

    String strJs;

    try {

      _corControleClicado = corControleClicado;

      strJs = this.getStrObjJavaScriptNome() + ".setCorControleClicado('" + _corControleClicado + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setCorControleMouse(String corControleMouse) {

    String strJs;

    try {

      _corControleMouse = corControleMouse;

      strJs = this.getStrObjJavaScriptNome() + ".setCorControleMouse('" + _corControleMouse + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setCorControleNormal(String corControleNormal) {

    String strJs;

    try {

      _corControleNormal = corControleNormal;

      strJs = this.getStrObjJavaScriptNome() + ".setCorControleNormal('" + _corControleNormal + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setCorFundo(String corFundo) {

    String strJs;

    try {

      _corFundo = corFundo;

      strJs = this.getStrObjJavaScriptNome() + ".setCorFundo('" + _corFundo + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrSombra(String strSombra) {

    _strSombra = strSombra;
  }
}