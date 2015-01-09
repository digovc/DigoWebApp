package com.digosofter.digowebapp.design;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.PaginaHtml;

public class PaletaCor extends Objeto {

  private boolean _booSelecionado;
  private String _strCorBorda = "#e1e1e1";
  private String _strCorBorda2 = "#777777";
  private String _strCorControleClicado;
  private String _strCorControleMouse;
  private String _strCorControleNormal;
  private String _strCorFundo;
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

  public String getStrCorBorda() {

    return _strCorBorda;
  }

  public String getStrCorBorda2() {

    return _strCorBorda2;
  }

  public String getStrCorControleClicado() {

    return _strCorControleClicado;
  }

  public String getStrCorControleMouse() {

    return _strCorControleMouse;
  }

  public String getStrCorControleNormal() {

    return _strCorControleNormal;
  }

  public String getStrCorFundo() {

    return _strCorFundo;
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

  public void setStrCorBorda(String strCorBorda) {

    String strJs;

    try {

      _strCorBorda = strCorBorda;

      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleClicado('" + _strCorControleClicado + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    _strCorBorda = strCorBorda;
  }

  public void setStrCorBorda2(String strCorBorda2) {

    try {

      _strCorBorda2 = strCorBorda2;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    _strCorBorda2 = strCorBorda2;
  }

  public void setStrCorControleClicado(String strCorControleClicado) {

    String strJs;

    try {

      _strCorControleClicado = strCorControleClicado;

      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleClicado('" + _strCorControleClicado + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrCorControleMouse(String strCorControleMouse) {

    String strJs;

    try {

      _strCorControleMouse = strCorControleMouse;

      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleMouse('" + _strCorControleMouse + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrCorControleNormal(String strCorControleNormal) {

    String strJs;

    try {

      _strCorControleNormal = strCorControleNormal;

      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleNormal('" + _strCorControleNormal + "');";

      this.addJs(strJs);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrCorFundo(String strCorFundo) {

    String strJs;

    try {

      _strCorFundo = strCorFundo;

      strJs = this.getStrObjJavaScriptNome() + ".setStrCorFundo('" + _strCorFundo + "');";

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