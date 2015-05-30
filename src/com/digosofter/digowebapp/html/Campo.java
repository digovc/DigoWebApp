package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Campo extends Tag {

  public enum EnmTipo {

    BUTTON,
    CHECKBOX,
    COLOR,
    DATE,
    DATETIME,
    DATETIME_LOCAL,
    EMAIL,
    FILE,
    HIDDEN,
    IMAGE,
    MONTH,
    NUMBER,
    PASSWORD,
    RADIO,
    RANGE,
    RESET,
    SEARCH,
    SUBMIT,
    TEL,
    TEXT,
    TEXT_AREA,
    TIME,
    URL,
    WEEK,
  }

  private boolean _booDisabled;
  private EnmTipo _enmTipo = EnmTipo.TEXT;
  private int _intValor;
  private String _strId;
  private String _strPlaceHolder;
  private String _strValor;

  public Campo() {

    super("input");
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.STR_JS_CAMPO));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public boolean getBooDisabled() {

    return _booDisabled;
  }

  private EnmTipo getEnmTipo() {

    return _enmTipo;
  }

  public int getIntValor() {

    try {

      _intValor = Integer.valueOf(this.getStrValor());
    }
    catch (Exception ex) {

      return 0;
    }
    finally {
    }

    return _intValor;
  }

  protected String getStrPlaceHolder() {

    return _strPlaceHolder;
  }

  protected String getStrValor() {

    return _strValor;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.montarLayoutValor();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutValor() {

    try {

      if (Utils.getBooStrVazia(this.getStrValor())) {

        return;
      }

      switch (this.getEnmTipo()) {
        case TEXT_AREA:
          this.setStrConteudo(this.getStrValor());
          break;
        case CHECKBOX:
          this.montarLayoutValorCheckBox();
          break;
        default:
          this.addAtr("value", this.getStrValor());
          break;
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutValorCheckBox() {

    try {

      if (Utils.getBooStrVazia(this.getStrValor())) {

        return;
      }

      switch (this.getStrValor().toLowerCase()) {
        case "s":
        case "sim":
        case "1":
        case "true":
        case "t":
          this.addAtr("checked", "");
          break;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setBooDisabled(boolean booDisabled) {

    try {

      _booDisabled = booDisabled;

      if (_booDisabled) {

        this.addAtr("disabled", "");
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

      this.addCss(CssTag.getIMain().addCss("box-sizing", "border-box"));
      this.addCss(CssTag.getIMain().setMarginBottom(5));
      this.addCss(CssTag.getIMain().setPadding(5, "px"));
      this.addCss(CssTag.getIMain().setWidth(100, "%"));
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
        case BUTTON:
          this.getAtrType().setStrValor("button");
          break;
        case CHECKBOX:
          this.getAtrType().setStrValor("checkbox");
          break;
        case COLOR:
          this.getAtrType().setStrValor("color");
          break;
        case DATE:
          this.getAtrType().setStrValor("date");
          this.addCss(CssTag.getIMain().setTextAlign("right"));
          break;
        case DATETIME:
          this.getAtrType().setStrValor("datetime");
          this.addCss(CssTag.getIMain().setTextAlign("right"));
          break;
        case DATETIME_LOCAL:
          this.getAtrType().setStrValor("datetime-local");
          break;
        case EMAIL:
          this.getAtrType().setStrValor("email");
          break;
        case FILE:
          this.getAtrType().setStrValor("file");
          break;
        case HIDDEN:
          this.getAtrType().setStrValor("hidden");
          break;
        case IMAGE:
          this.getAtrType().setStrValor("image");
          break;
        case MONTH:
          this.getAtrType().setStrValor("month");
          break;
        case NUMBER:
          this.getAtrType().setStrValor("number");
          this.addCss(CssTag.getIMain().setTextAlign("right"));
          break;
        case PASSWORD:
          this.getAtrType().setStrValor("password");
          break;
        case RADIO:
          this.getAtrType().setStrValor("radio");
          break;
        case RANGE:
          this.getAtrType().setStrValor("range");
          break;
        case RESET:
          this.getAtrType().setStrValor("reset");
          break;
        case SEARCH:
          this.getAtrType().setStrValor("search");
          break;
        case SUBMIT:
          this.getAtrType().setStrValor("submit");
          break;
        case TEL:
          this.getAtrType().setStrValor("tel");
          break;
        case TEXT:
          this.getAtrType().setStrValor("text");
          break;
        case TEXT_AREA:
          this.setStrTagNome("textarea");
          this.setBooForcarTagDupla(true);
          this.addAtr("rows", "7");
          this.addCss(CssTag.getIMain().setWidth(100, "%"));
          break;
        case TIME:
          this.getAtrType().setStrValor("time");
          break;
        case URL:
          this.getAtrType().setStrValor("url");
          break;
        case WEEK:
          this.getAtrType().setStrValor("week");
          break;
        default:
          this.getAtrType().setStrValor("text");
          break;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setIntValor(int intValor) {

    try {

      _intValor = intValor;

      this.setStrValor(String.valueOf(_intValor));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void setStrId(String strId) {

    super.setStrId(strId);

    try {

      _strId = this.getStrId();

      if (this.getEnmTipo() != EnmTipo.RADIO) {

        this.getLstAtr().add(new Atributo("name", _strId));
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrPlaceHolder(String strPlaceHolder) {

    try {

      _strPlaceHolder = strPlaceHolder;

      this.getLstAtr().add(new Atributo("placeholder", _strPlaceHolder));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setStrValor(String strValor) {

    _strValor = strValor;
  }
}