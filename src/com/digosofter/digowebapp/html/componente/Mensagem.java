package com.digosofter.digowebapp.html.componente;

import com.digosofter.digojava.Utils;
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
  private String _strJsCodigo;
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

        case LOAD:
          strResultado = "res/media/gif/load.gif";
          break;

        case NEGATIVA:
          strResultado = "res/media/png/info_negativa.png";
          break;

        case POSITIVA:
          strResultado = "res/media/png/info_positiva.png";
          break;

        default:
          strResultado = "res/media/png/info_alerta.png";
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

      _imgIcon.addCss(CssTag.getIMain().setBorderRadius(30, 30, 30, 30));
      _imgIcon.addCss(CssTag.getIMain().setBoxShadow(0, 0, 5, 0, "silver"));
      _imgIcon.addCss(CssTag.getIMain().setFloat("left"));
      _imgIcon.addCss(CssTag.getIMain().setHeight(50, "px"));
      _imgIcon.addCss(CssTag.getIMain().setMargin(5, "px"));
      _imgIcon.addCss(CssTag.getIMain().setMarginRight(25));
      _imgIcon.addCss(CssTag.getIMain().setPadding(5, "px"));
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

      _pnlConteudo.addCss(CssTag.getIMain().addCss("margin", "auto"));
      _pnlConteudo.addCss(CssTag.getIMain().setBackgroundColor("white"));
      _pnlConteudo.addCss(CssTag.getIMain().setBoxShadow(0, 0, 5, 0, "silver"));
      _pnlConteudo.addCss(CssTag.getIMain().setDisplay("table"));
      _pnlConteudo.addCss(CssTag.getIMain().setPadding(5, "px"));
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
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlTitulo;
  }

  public String getStrJsCodigo() {

    try {

      if (!Utils.getBooStrVazia(_strJsCodigo)) {

        return _strJsCodigo;
      }

      _strJsCodigo = "var msg_msg_id = new Mensagem('_msg_title', '_msg_msg', _msg_tipo); msg_msg_id.mostrar();";

      _strJsCodigo = _strJsCodigo.replace("_msg_id", String.valueOf(this.getIntObjetoId()));
      _strJsCodigo = _strJsCodigo.replace("_msg_title", this.getStrTitulo());
      _strJsCodigo = _strJsCodigo.replace("_msg_msg", this.getStrMensagem());
      _strJsCodigo = _strJsCodigo.replace("_msg_tipo", String.valueOf(this.getEnmTipo().ordinal()));

      return _strJsCodigo;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
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

      this.addCss(tagCss.setPaddingTop(25));
      this.addCss(tagCss.setPosition("fixed"));
      this.addCss(tagCss.setTop(0));
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