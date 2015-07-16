package com.digosofter.digowebapp.html.componente.menu;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.componente.Componente;

public class MenuItemCabecalho extends Componente {

  private MenuPrincipal _mnp;

  public MenuItemCabecalho(String strId, String strTitulo, MenuPrincipal mnp) {

    try {

      this.setMnp(mnp);
      this.setStrId(strId);
      this.setStrNome(strTitulo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private MenuPrincipal getMnp() {

    return _mnp;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.setStrConteudo(this.getStrNome());
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
      this.addCss(tagCss.setPaddingLeft(10));
      this.addCss(tagCss.setPaddingRight(10));
      this.addCss(tagCss.setPaddingTop(5));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setMnp(MenuPrincipal mnp) {

    try {

      _mnp = mnp;

      if (_mnp == null) {

        return;
      }

      _mnp.addMic(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}