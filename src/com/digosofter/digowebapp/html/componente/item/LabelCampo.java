package com.digosofter.digowebapp.html.componente.item;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;

public class LabelCampo extends ItemMain {

  private Painel _pnlCampo;
  private Painel _pnlTitulo;
  private String _strLabel;
  private Campo _tagCampo;

  private Painel getPnlCampo() {

    try {

      if (_pnlCampo != null) {

        return _pnlCampo;
      }

      _pnlCampo = new Painel();

      _pnlCampo.addCss(CssTag.getIMain().setPaddingLeft(10));
      _pnlCampo.addCss(CssTag.getIMain().setPaddingRight(10));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlCampo;
  }

  @Override
  protected Painel getPnlTitulo() {

    try {

      if (_pnlTitulo != null) {

        return _pnlTitulo;
      }

      _pnlTitulo = super.getPnlTitulo();

      _pnlTitulo.addCss(CssTag.getIMain().setPaddingLeft(10));
      _pnlTitulo.addCss(CssTag.getIMain().setPaddingRight(10));
      _pnlTitulo.addCss(CssTag.getIMain().setTextAlign("left"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlTitulo;
  }

  protected String getStrLabel() {

    return _strLabel;
  }

  protected Campo getTagCampo() {

    try {

      if (_tagCampo != null) {

        return _tagCampo;
      }

      _tagCampo = new Campo();

      _tagCampo.addCss(CssTag.getIMain().setPadding(5, "px"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagCampo;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.getPnlTitulo().setTagPai(this);
      this.getPnlCampo().setTagPai(this);
      this.getTagCampo().setTagPai(this.getPnlCampo());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      this.addCss(tagCss.setFloat("left"));
      this.addCss(tagCss.setPaddingBottom(5));
      this.addCss(tagCss.setPaddingTop(5));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrLabel(String strLabel) {

    try {

      _strLabel = strLabel;

      if (!Utils.getBooStrVazia(_strLabel)) {

        this.getPnlTitulo().setStrConteudo(_strLabel);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}