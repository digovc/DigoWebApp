package com.digosofter.digowebapp.design;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;

public class Estilo extends Objeto {

  private boolean _booSelecionado;
  private String _corBorda = "#e1e1e1";
  private String _corControle = "#f4f4f4";
  private String _corControleClicado;
  private String _corControleMouseEnter = "#d8d8d8";
  private String _corFundo = "#eeeeee";
  private String _corFundo2 = "#e0e0e0";
  private String _corFundo3 = "#9e9e9e";
  private String _strSombra = "#e1e1e1";

  public Estilo(String strNome) {

    try {

      this.setStrNome(strNome);
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

  public String getCorControle() {

    return _corControle;
  }

  public String getCorControleClicado() {

    return _corControleClicado;
  }

  public String getCorControleMouseEnter() {

    return _corControleMouseEnter;
  }

  public String getCorFundo() {

    return _corFundo;
  }

  public String getCorFundo2() {

    return _corFundo2;
  }

  public String getCorFundo3() {

    return _corFundo3;
  }

  public String getStrSombra() {

    return _strSombra;
  }

  public void setBooSelecionado(boolean booSelecionado) {

    _booSelecionado = booSelecionado;
  }

  public void setCorBorda(String corBorda) {

    _corBorda = corBorda;
  }

  public void setCorControle(String corControle) {

    _corControle = corControle;
  }

  public void setCorControleClicado(String corControleClicado) {

    _corControleClicado = corControleClicado;
  }

  public void setCorControleMouseEnter(String corControleMouseEnter) {

    _corControleMouseEnter = corControleMouseEnter;
  }

  public void setCorFundo(String corFundo) {

    _corFundo = corFundo;
  }

  public void setCorFundo2(String corFundo2) {

    _corFundo2 = corFundo2;
  }

  public void setCorFundo3(String corFundo3) {

    _corFundo3 = corFundo3;
  }

  public void setStrSombra(String strSombra) {

    _strSombra = strSombra;
  }
}