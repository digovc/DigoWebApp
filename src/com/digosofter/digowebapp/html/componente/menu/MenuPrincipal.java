package com.digosofter.digowebapp.html.componente.menu;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.componente.Componente;

public abstract class MenuPrincipal extends Componente {

  private List<MenuItemCabecalho> _lstMic;

  public MenuPrincipal(String strId) {

    try {

      this.setStrId(strId);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  void addMic(MenuItemCabecalho mic) {

    try {

      if (mic == null) {

        return;
      }

      if (this.getLstMic().contains(mic)) {

        return;
      }

      this.getLstMic().add(mic);
      mic.setTagPai(this);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  protected abstract void criarOpcoes();

  private List<MenuItemCabecalho> getLstMic() {

    try {

      if (_lstMic != null) {

        return _lstMic;
      }

      _lstMic = new ArrayList<MenuItemCabecalho>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstMic;
  }

  @Override
  protected void salvarEstruturaSecundaria() {

    super.salvarEstruturaSecundaria();

    try {

      new MenuItem().salvarEstrutura();
      new MenuItemContainer().salvarEstrutura();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.criarOpcoes();

      this.getTagLimiteFloat().setTagPai(this);
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

      this.addCss(tagCss.setBackgroundColor(AppWeb.getI().getObjEstilo().getCorControle()));
      this.addCss(tagCss.setBorderBottom(1, AppWeb.getI().getObjEstilo().getCorBorda()));
      this.addCss(tagCss.setCursor("pointer"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}