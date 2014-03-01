package com.digosofter.digowebapp.design;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.PaginaHtml;

public class PaletaCor extends Objeto {

  private boolean _booSelecionado;

  private String _strCorControleClicado;

  private String _strCorControleMouse;

  private String _strCorControleNormal;

  private String _strCorFundo;

  private String _strObjetoJavaScriptNome = "";

  public PaletaCor(String strNome) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNome(strNome);
      this.addJs("var " + this.getStrObjetoJavaScriptNome() + "= new PaletaCor('"
          + this.getStrNome() + "');");

      PaginaHtml.getI().getLstObjJsTag()
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

      PaginaHtml.getI().adicionarJsCodigo(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public boolean getBooSelecionado() {
    return _booSelecionado;
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

  private String getStrObjetoJavaScriptNome() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_strObjetoJavaScriptNome == "") {
        _strObjetoJavaScriptNome = "objPaletaCor" + this.getStrNome();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strObjetoJavaScriptNome;
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

  public void setStrCorControleClicado(String strCorControleClicado) {
    // VARIÁVEIS

    String strJs;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strCorControleClicado = strCorControleClicado;
      strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorControleClicado('"
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
      strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorControleMouse('"
          + _strCorControleMouse + "');";
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
      strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorControleNormal('"
          + _strCorControleNormal + "');";
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
      strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorFundo('" + _strCorFundo + "');";
      this.addJs(strJs);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
