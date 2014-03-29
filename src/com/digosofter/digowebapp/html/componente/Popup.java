package com.digosofter.digowebapp.html.componente;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.componente.item.PopupItem;

public class Popup extends ComponenteMain {

  private List<PopupItem> _lstObjPopupItem;

  private Painel _pnlOpcao;

  public void addItem(PopupItem ppi) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (ppi == null) {

        return;
      }

      this.getLstObjPopupItem().add(ppi);
      ppi.setIntOrdem(this.getLstObjPopupItem().size());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_POPUP));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public List<PopupItem> getLstObjPopupItem() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstObjPopupItem == null) {

        _lstObjPopupItem = new ArrayList<PopupItem>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstObjPopupItem;
  }

  private Painel getPnlOpcao() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlOpcao == null) {

        _pnlOpcao = new Painel();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlOpcao;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getPnlOpcao().setTagPai(this);
      this.montarLayoutLstObjPopupItem();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutLstObjPopupItem() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      for (PopupItem objPopupItem : this.getLstObjPopupItem()) {

        objPopupItem.setTagPai(this.getPnlOpcao());
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.addCss(tagCss.setBackgroundColor("white"));
      this.addCss(tagCss.setBorder(1, "outset", AppWeb.getI().getObjPaletaCor().getStrCorBorda2()));
      this.addCss(tagCss.setDisplay("none"));
      this.addCss(tagCss.setPadding(1, "px"));
      this.addCss(tagCss.setPosition("absolute"));
      this.addCss(tagCss.setZ(100));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
