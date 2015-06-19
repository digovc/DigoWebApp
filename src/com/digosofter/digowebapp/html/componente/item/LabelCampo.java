package com.digosofter.digowebapp.html.componente.item;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;

public class LabelCampo extends Item {

  private Painel _pnlCampo;
  private Painel _pnlLabel;
  private String _strLabel;
  private Campo _tagCampo;

  private Painel getPnlCampo() {

    try {

      if (_pnlCampo != null) {

        return _pnlCampo;
      }

      _pnlCampo = new Painel();

      _pnlCampo.addCss(CssTag.getIMain().setPadding(5, "px"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlCampo;
  }

  private Painel getPnlLabel() {

    try {

      if (_pnlLabel != null) {

        return _pnlLabel;
      }

      _pnlLabel = new Painel();

      _pnlLabel.addCss(CssTag.getIMain().setTextAlign("initial"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlLabel;
  }

  protected String getStrLabel() {

    return _strLabel;
  }

  public Campo getTagCampo() {

    try {

      if (_tagCampo != null) {

        return _tagCampo;
      }

      _tagCampo = new Campo();
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

      this.getPnlLabel().setTagPai(this);
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

      this.addCss(tagCss.setBorderBottom(1, "#e0e0e0"));
      this.addCss(tagCss.setFloat("left"));
      this.addCss(tagCss.setMarginBottom(10));
      this.addCss(tagCss.setMarginRight(10));
      this.addCss(tagCss.setMinWidth(150));
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

      if (Utils.getBooStrVazia(_strLabel)) {

        return;
      }

      this.getPnlLabel().setStrConteudo(_strLabel);
      this.setStrTitle(_strLabel);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}