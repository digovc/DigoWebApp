package com.digosofter.digowebapp.html.componente.item;

import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.Painel;

public class PopupItem extends ItemMain {

  private int _intOrdem;
  private Painel _pnlTitulo;
  private String _strSrcIcon;

  public PopupItem(String strNomeExibicao, String strSrcIcon) {

    try {

      this.setStrNomeExibicao(strNomeExibicao);
      this.setStrSrcIcon(strSrcIcon);
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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_POPUP_ITEM));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private int getIntOrdem() {

    return _intOrdem;
  }

  @Override
  public Painel getPnlTitulo() {

    try {

      if (_pnlTitulo != null) {

        return _pnlTitulo;
      }

      _pnlTitulo = super.getPnlTitulo();

      _pnlTitulo.setStrConteudo(this.getStrNomeExibicao());
      _pnlTitulo.addCss(CssTag.getIMain().setTextAlign("left"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlTitulo;
  }

  private String getStrSrcIcon() {

    return _strSrcIcon;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    String strId;

    try {

      strId = "ppiAcao" + this.getIntOrdem();

      this.setStrId(strId);
      this.getPnlTitulo().setTagPai(this);
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

      this.addCss(tagCss.setBorderBottom(1, AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
      this.addCss(tagCss.setCursor("pointer"));
      this.addCss(tagCss.setPadding(10, "px"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setIntOrdem(int intOrdem) {

    _intOrdem = intOrdem;
  }

  private void setStrSrcIcon(String strSrcIcon) {

    _strSrcIcon = strSrcIcon;
  }
}