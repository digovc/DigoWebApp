package com.digosofter.digowebapp.html;

import com.digosofter.digojava.erro.Erro;

public class Titulo extends Tag {

  public enum EnmTipo {

    H1,
    H2,
    H3,
    H4,
    H5,
    H6
  }

  private EnmTipo _enmTipo = EnmTipo.H1;

  public Titulo() {

    super("h1");
  }

  public EnmTipo getEnmTipo() {

    return _enmTipo;
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      this.addCss(tagCss.setColor("#666666"));
      this.addCss(tagCss.setTextAlign("initial"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setEnmTipo(EnmTipo enmTipo) {

    try {

      _enmTipo = enmTipo;

      switch (_enmTipo) {
        case H2:
          this.setStrTagNome("h2");
          return;

        case H3:
          this.setStrTagNome("h3");
          return;

        case H4:
          this.setStrTagNome("h4");
          return;

        case H5:
          this.setStrTagNome("h5");
          return;

        case H6:
          this.setStrTagNome("h6");
          return;

        default:
          this.setStrTagNome("h1");
          break;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}