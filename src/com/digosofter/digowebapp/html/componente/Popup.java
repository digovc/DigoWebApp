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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (ppi == null) {

        return;
      }

      this.getLstObjPopupItem().add(ppi);
      ppi.setIntOrdem(this.getLstObjPopupItem().size());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_POPUP));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public List<PopupItem> getLstObjPopupItem() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstObjPopupItem == null) {

        _lstObjPopupItem = new ArrayList<PopupItem>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstObjPopupItem;
  }

  private Painel getPnlOpcao() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlOpcao == null) {

        _pnlOpcao = new Painel();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlOpcao;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getPnlOpcao().setTagPai(this);
      this.montarLayoutLstObjPopupItem();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutLstObjPopupItem() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (PopupItem objPopupItem : this.getLstObjPopupItem()) {

        objPopupItem.setTagPai(this.getPnlOpcao());
      }

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

      this.addCss(tagCss.setBackgroundColor("white"));
      this.addCss(tagCss.setBorder(1, "outset", AppWeb.getI().getObjPaletaCor().getStrCorBorda2()));
      this.addCss(tagCss.setDisplay("none"));
      this.addCss(tagCss.setPadding(1, "px"));
      this.addCss(tagCss.setPosition("absolute"));
      this.addCss(tagCss.setZ(100));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
