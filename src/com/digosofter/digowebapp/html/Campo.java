package com.digosofter.digowebapp.html;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

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
    WEEK

  }

  private EnmTipo _enmTipo = EnmTipo.TEXT;

  private String _strId;

  private String _strPlaceHolder;

  private String _strValor;

  public Campo() {

    super("input");

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

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_CAMPO));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private EnmTipo getEnmTipo() {
    return _enmTipo;
  }

  protected String getStrPlaceHolder() {
    return _strPlaceHolder;
  }

  protected String getStrValor() {
    return _strValor;
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.addCss(CssTag.getIMain().addCss("box-sizing", "border-box"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setEnmTipo(EnmTipo enmTipo) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

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
          break;
        case DATETIME:
          this.getAtrType().setStrValor("datetime");
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
          this.addAtr("rows", "5");
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

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  public void setStrId(String strId) {

    super.setStrId(strId);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strId = this.getStrId();

      if (this.getEnmTipo() != EnmTipo.RADIO) {

        this.getLstAtr().add(new Atributo("name", _strId));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrPlaceHolder(String strPlaceHolder) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strPlaceHolder = strPlaceHolder;
      this.getLstAtr().add(new Atributo("placeholder", _strPlaceHolder));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setStrValor(String strValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strValor = strValor;

      switch (this.getEnmTipo()) {
        case TEXT_AREA:
          this.setStrConteudo(_strValor);
          break;
        default:
          this.addAtr("value", _strValor);
          break;
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
