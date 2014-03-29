package com.digosofter.digowebapp.design;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.PaginaHtml;

public class PaletaCor extends Objeto {

  private boolean _booSelecionado;

  private String _strCorBorda;

  private String _strCorControleClicado;

  private String _strCorControleMouse;

  private String _strCorControleNormal;

  private String _strCorFundo;

  private String _strObjJavaScriptNome = "";

  public PaletaCor(String strNome) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNome(strNome);
      this.addJs("var " + this.getStrObjJavaScriptNome() + "= new PaletaCor('" + this.getStrNome()
          + "');");

      PaginaHtml.getI().getLstTagJs()
          .add(new JavaScriptTag("res/js/lib/JDigo/design/PaletaCor.js"));

      AppWeb.getI().getLstObjPaletaCor().add(this);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void addJs(String strJs) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      PaginaHtml.getI().addJsCodigo(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public boolean getBooSelecionado() {
    return _booSelecionado;
  }

  public String getStrCorBorda() {
    return _strCorBorda;
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_strObjJavaScriptNome == "") {
        _strObjJavaScriptNome = "objPaletaCor" + this.getStrNome();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strObjJavaScriptNome;
  }

  public void setBooSelecionado(boolean booSelecionado) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _booSelecionado = booSelecionado;

      if (_booSelecionado) {
        AppWeb.getI().setObjPaletaCorSelecionada(this);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrCorBorda(String strCorBorda) {
    // VARIÁVEIS

    String strJs;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strCorBorda = strCorBorda;
      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleClicado('"
          + _strCorControleClicado + "');";
      this.addJs(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    _strCorBorda = strCorBorda;
  }

  public void setStrCorControleClicado(String strCorControleClicado) {
    // VARIÁVEIS

    String strJs;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strCorControleClicado = strCorControleClicado;
      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleClicado('"
          + _strCorControleClicado + "');";
      this.addJs(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrCorControleMouse(String strCorControleMouse) {
    // VARIÁVEIS

    String strJs;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strCorControleMouse = strCorControleMouse;
      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleMouse('" + _strCorControleMouse
          + "');";
      this.addJs(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrCorControleNormal(String strCorControleNormal) {
    // VARIÁVEIS

    String strJs;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strCorControleNormal = strCorControleNormal;
      strJs = this.getStrObjJavaScriptNome() + ".setStrCorControleNormal('" + _strCorControleNormal
          + "');";
      this.addJs(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrCorFundo(String strCorFundo) {
    // VARIÁVEIS

    String strJs;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strCorFundo = strCorFundo;
      strJs = this.getStrObjJavaScriptNome() + ".setStrCorFundo('" + _strCorFundo + "');";
      this.addJs(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
