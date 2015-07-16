package com.digosofter.digowebapp.design;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Estilo extends Objeto {

  private boolean _booSelecionado;
  private String _corBorda = "#e1e1e1";
  private String _corControle = "#f4f4f4";
  private String _corControleClicado;
  private String _corControleMouseEnter = "#d8d8d8";
  private String _corFundo;
  private String _strSombra = "#e1e1e1";

  public Estilo(String strNome) {

    try {

      this.setStrNome(strNome);
      AppWeb.getI().getLstObjEstilo().add(this);
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

  public void setStrSombra(String strSombra) {

    _strSombra = strSombra;
  }
}