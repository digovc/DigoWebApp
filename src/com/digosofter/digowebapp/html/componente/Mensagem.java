package com.digosofter.digowebapp.html.componente;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Imagem;
import com.digosofter.digowebapp.html.Painel;

public class Mensagem extends ComponenteMain {

  public enum EnmTipo {

    ALERTA,
    LOAD,
    NEGATIVA,
    POSITIVA,
  }

  private EnmTipo _enmTipo = EnmTipo.POSITIVA;
  private Imagem _imgIcon;
  private Painel _pnlConteudo;
  private Painel _pnlMensagem;
  private Painel _pnlTitulo;
  private String _strMensagem = "_msg";
  private String _strTitulo = "_titulo";

  public Mensagem() {

    try {

      this.setStrId("msg");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private String definirSrc() {

    String strResultado = null;

    try {

      switch (this.getEnmTipo()) {

        case ALERTA:
          strResultado = "res/media/info_alerta.png";
          break;

        case LOAD:
          strResultado = "res/media/load.gif";
          break;

        case NEGATIVA:
          strResultado = "res/media/info_negativa.png";
          break;

        case POSITIVA:
          strResultado = "res/media/info_positiva.png";
          break;

        default:
          strResultado = "res/media/info_alerta.png";
          break;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public EnmTipo getEnmTipo() {

    return _enmTipo;
  }

  private Imagem getImgIcon() {

    try {

      if (_imgIcon != null) {

        return _imgIcon;
      }

      _imgIcon = new Imagem();

      _imgIcon.setSrc(this.definirSrc());
      _imgIcon.addCss(CssTag.getIMain().setHeight(50, "px"));
      _imgIcon.addCss(CssTag.getIMain().setWidth(50, "px"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _imgIcon;
  }

  private Painel getPnlConteudo() {

    try {

      if (_pnlConteudo != null) {

        return _pnlConteudo;
      }

      _pnlConteudo = new Painel();

      _pnlConteudo.addCss(CssTag.getIMain().setBorder(1, "outset", AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
      _pnlConteudo.addCss(CssTag.getIMain().setBorderRadius(5, 5, 5, 5));
      _pnlConteudo.addCss(CssTag.getIMain().setBoxShadow(0, 2, 2, 2, AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
      _pnlConteudo.addCss(CssTag.getIMain().setDisplay("table"));
      _pnlConteudo.addCss(CssTag.getIMain().setPadding(5, "px"));
      _pnlConteudo.addCss(CssTag.getIMain().setBackgroundColor("white"));
      _pnlConteudo.addCss(CssTag.getIMain().addCss("margin", "auto"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlConteudo;
  }

  private Painel getPnlMensagem() {

    try {

      if (_pnlMensagem != null) {

        return _pnlMensagem;
      }

      _pnlMensagem = new Painel();

      _pnlMensagem.setStrConteudo(this.getStrMensagem());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlMensagem;
  }

  @Override
  protected Painel getPnlTitulo() {

    try {

      if (_pnlTitulo != null) {

        return _pnlTitulo;
      }

      _pnlTitulo = super.getPnlTitulo();

      _pnlTitulo.setStrConteudo(this.getStrTitulo());
      _pnlTitulo.addCss(CssTag.getIMain().setFontNegrito());
      _pnlTitulo.addCss(CssTag.getIMain().setMarginBottom(5));
      _pnlTitulo.addCss(CssTag.getIMain().setPaddingTop(5));
      _pnlTitulo.addCss(CssTag.getIMain().setBorderTop(1, AppWeb.getI().getObjPaletaCor().getStrCorBorda()));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
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

    try {

      this.getPnlConteudo().setTagPai(this);
      this.getImgIcon().setTagPai(this.getPnlConteudo());
      this.getPnlTitulo().setTagPai(this.getPnlConteudo());
      this.getPnlMensagem().setTagPai(this.getPnlConteudo());
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

      this.addCss(tagCss.setPosition("fixed"));
      this.addCss(tagCss.setPaddingTop(50));
      this.addCss(tagCss.setWidth(100, "%"));
      this.addCss(tagCss.setZ(100));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
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

    try {

      _strTitulo = strTitulo;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}