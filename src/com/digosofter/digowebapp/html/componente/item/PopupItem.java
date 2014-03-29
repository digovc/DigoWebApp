package com.digosofter.digowebapp.html.componente.item;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;

public class PopupItem extends ItemMain {

  private Painel _pnlTitulo;

  private String _strSrcIcon;

  public PopupItem(String strNomeExibicao, String strSrcIcon) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNomeExibicao(strNomeExibicao);
      this.setStrSrcIcon(strSrcIcon);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public Painel getPnlTitulo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlTitulo == null) {

        _pnlTitulo = super.getPnlTitulo();
        _pnlTitulo.setStrConteudo(this.getStrNomeExibicao());
        _pnlTitulo.addCss(CssTag.getCssMainInst().setTextAlign("left"));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlTitulo;
  }

  private String getStrSrcIcon() {
    return _strSrcIcon;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getPnlTitulo().setTagPai(this);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.addCss(tagCss.setBorderBottom(1, AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
      this.addCss(tagCss.setPadding(10, "px"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setStrSrcIcon(String strSrcIcon) {
    _strSrcIcon = strSrcIcon;
  }

}
