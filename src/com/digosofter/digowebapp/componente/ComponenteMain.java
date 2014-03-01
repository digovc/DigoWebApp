package com.digosofter.digowebapp.componente;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.Tag;

public abstract class ComponenteMain extends Objeto {

  private Painel _pnlComando;

  private Painel _pnlContainer;

  private Painel _pnlTitulo;

  private String _strId;

  private Tag _tagPai;

  public Painel getPnlComando() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlComando == null) {

        _pnlComando = new Painel();
        _pnlComando.addCss(CssTag.getCssMainInst().setPaddingLeft(10));
        _pnlComando.addCss(CssTag.getCssMainInst().setPaddingRight(10));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlComando;
  }

  public Painel getPnlContainer() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlContainer == null) {
        _pnlContainer = new Painel();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlContainer;
  }

  protected Painel getPnlTitulo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlTitulo == null) {
        _pnlTitulo = new Painel();
      }

      // FIM AÇÕES
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
    // VARIÁVEIS

    String strResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strResultado = this.getPnlContainer().getStrTagFormatada();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  protected String getStrId() {
    return _strId;
  }

  public Tag getTagPai() {
    return _tagPai;
  }

  /**
   * Prepara o layout final do componente.
   */
  public abstract void montarLayout();

  protected void setStrId(String strId) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strId = strId;
      this.getPnlContainer().setStrId(_strId);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setTagPai(Tag tagPai) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _tagPai = tagPai;
      this.getPnlContainer().setTagPai(_tagPai);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
