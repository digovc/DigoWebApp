package com.digosofter.digowebapp.componente;

import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.Tag;

public abstract class ComponenteMain extends Tag {

  private Painel _pnlComando;

  private Painel _pnlContainer;

  private Painel _pnlTitulo;

  public Painel getPnlComando() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlComando == null) {

        _pnlComando = new Painel();
        _pnlComando.addCss(CssTag.getCssMainInst().setPaddingLeft(10));
        _pnlComando.addCss(CssTag.getCssMainInst().setPaddingRight(10));
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlComando;
  }

  public Painel getPnlContainer() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlContainer == null) {
        _pnlContainer = new Painel();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlContainer;
  }

  protected Painel getPnlTitulo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlTitulo == null) {
        _pnlTitulo = new Painel();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlTitulo;
  }

  /**
   * Retorna o componente pronto para ser usado no html.
   */
  public String getStrCompFormatado() {
    // VARI�VEIS

    String strResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      strResultado = this.getPnlContainer().getStrTagFormatada();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  /**
   * Prepara o layout final do componente.
   */
  public abstract void montarLayout();

}
