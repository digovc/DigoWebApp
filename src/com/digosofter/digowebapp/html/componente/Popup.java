package com.digosofter.digowebapp.html.componente;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.componente.item.PopupItem;

public class Popup extends ComponenteMain {

  private List<PopupItem> _lstObjPopupItem;

  private Painel _pnlOpcao;

  public Popup() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES
      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void addItem(PopupItem ppi) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (ppi == null) {

        return;
      }

      this.getLstObjPopupItem().add(ppi);

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


}
