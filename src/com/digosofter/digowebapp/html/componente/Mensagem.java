package com.digosofter.digowebapp.html.componente;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Imagem;
import com.digosofter.digowebapp.html.Painel;

public class Mensagem extends ComponenteMain {

  public enum EnmTipo {
    ALERTA, NEGATIVA, POSITIVA
  }

  private EnmTipo _enmTipo = EnmTipo.POSITIVA;

  private Imagem _imgIcon;

  private Painel _pnlConteudo;

  private Painel _pnlMsg;

  private Painel _pnlTitulo;

  private String _strMensagem = "_msg";

  private String _strTitulo = "_titulo";

  public Mensagem() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrId("msg");

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public EnmTipo getEnmTipo() {
    return _enmTipo;
  }

  private Imagem getImgIcon() {
    // VARI�VEIS

    String src;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (_imgIcon == null) {

        switch (this.getEnmTipo()) {

          case ALERTA:
            src = "res/media/info_alerta.png";
            break;

          case NEGATIVA:
            src = "res/media/info_negativa.png";
            break;

          case POSITIVA:
            src = "res/media/info_positiva.png";
            break;

          default:
            src = "res/media/info_alerta.png";
            break;
        }

        _imgIcon = new Imagem();
        _imgIcon.setSrc(src);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _imgIcon;
  }

  private Painel getPnlConteudo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlConteudo == null) {

        _pnlConteudo = new Painel();
        _pnlConteudo.addCss(CssTag.getIMain().setBorder(1, "outset",
            AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
        _pnlConteudo.addCss(CssTag.getIMain().setBorderRadius(5, 5, 5, 5));
        _pnlConteudo.addCss(CssTag.getIMain().setBoxShadow(0, 2, 2, 2,
            AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
        _pnlConteudo.addCss(CssTag.getIMain().setDisplay("table"));
        _pnlConteudo.addCss(CssTag.getIMain().setPadding(5, "px"));
        _pnlConteudo.addCss(CssTag.getIMain().setBackgroundColor("white"));
        _pnlConteudo.addCss(CssTag.getIMain().addCss("margin", "auto"));
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlConteudo;
  }

  private Painel getPnlMsg() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlMsg == null) {

        _pnlMsg = new Painel();
        _pnlMsg.setStrConteudo(this.getStrMensagem());
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlMsg;
  }

  @Override
  protected Painel getPnlTitulo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlTitulo == null) {

        _pnlTitulo = super.getPnlTitulo();
        _pnlTitulo.setStrConteudo(this.getStrTitulo());
        _pnlTitulo.addCss(CssTag.getIMain().setFontNegrito());
        _pnlTitulo.addCss(CssTag.getIMain().setMarginBottom(5));
        _pnlTitulo.addCss(CssTag.getIMain().setPaddingTop(5));
        _pnlTitulo.addCss(CssTag.getIMain().setBorderTop(1,
            AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlTitulo;
  }

  public String getStrMensagem() {
    return _strMensagem;
  }

  public String getStrTitulo() {
    return _strTitulo;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getPnlConteudo().setTagPai(this);
      this.getImgIcon().setTagPai(this.getPnlConteudo());
      this.getPnlTitulo().setTagPai(this.getPnlConteudo());
      this.getPnlMsg().setTagPai(this.getPnlConteudo());

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

      this.addCss(tagCss.setPosition("fixed"));
      this.addCss(tagCss.setWidth(100, "%"));
      this.addCss(tagCss.setTop(15));
      this.addCss(tagCss.setZ(100));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setEnmTipo(EnmTipo enmTipo) {
    _enmTipo = enmTipo;
  }

  public void setStrMensagem(String strMensagem) {
    _strMensagem = strMensagem;
  }

  @Override
  public void setStrTitulo(String strTitulo) {

    super.setStrTitulo(strTitulo);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      _strTitulo = strTitulo;

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
