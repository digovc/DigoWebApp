package com.digosofter.digowebapp.html.componente;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.componente.item.PopupItem;

public class Popup extends ComponenteMain {

  private List<PopupItem> _lstObjPopupItem;

  private Painel _pnlOpcao;

  public void addItem(PopupItem ppi) {

    try {

      if (ppi == null) {

        return;
      }

      this.getLstObjPopupItem().add(ppi);
      ppi.setIntOrdem(this.getLstObjPopupItem().size());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_POPUP));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public List<PopupItem> getLstObjPopupItem() {

    try {

      if (_lstObjPopupItem != null) {

        return _lstObjPopupItem;
      }

      _lstObjPopupItem = new ArrayList<PopupItem>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstObjPopupItem;
  }

  private Painel getPnlOpcao() {

    try {

      if (_pnlOpcao != null) {

        return _pnlOpcao;
      }

      _pnlOpcao = new Painel();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlOpcao;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.getPnlOpcao().setTagPai(this);
      this.montarLayoutLstObjPopupItem();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutLstObjPopupItem() {

    try {

      for (PopupItem objPopupItem : this.getLstObjPopupItem()) {

        objPopupItem.setTagPai(this.getPnlOpcao());
      }
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

      this.addCss(tagCss.setBackgroundColor("white"));
      this.addCss(tagCss.setBorder(1, "outset", AppWeb.getI().getObjPaletaCor().getStrCorBorda2()));
      this.addCss(tagCss.setDisplay("none"));
      this.addCss(tagCss.setPadding(1, "px"));
      this.addCss(tagCss.setPosition("absolute"));
      this.addCss(tagCss.setZ(100));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}