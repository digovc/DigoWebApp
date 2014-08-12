package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class JavaScriptTag extends Tag {

  private Atributo _atrSrc;

  private int _intPrioridade = 5;

  private List<String> _lstStrMetodos = new ArrayList<String>();

  private String _strSrc;

  public JavaScriptTag(String strSrc) {

    super("script");

    try {

      this.setBooForcarTagDupla(true);
      this.getLstAtr().add(new Atributo("type", "text/javascript"));
      this.setStrSrc(strSrc);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

  }

  public void addJsCodigo(String strJsCodigo) {

    try {

      if (Utils.getBooStrVazia(strJsCodigo)) {
        return;
      }

      this.getLstStrMetodos().add(strJsCodigo);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  private Atributo getAtrSrc() {

    try {

      if (_atrSrc == null) {
        _atrSrc = new Atributo("src");
        this.getLstAtr().add(_atrSrc);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _atrSrc;
  }

  public int getIntPrioridade() {

    return _intPrioridade;
  }

  public List<String> getLstStrMetodos() {

    return _lstStrMetodos;
  }

  public String getStrSrc() {

    return _strSrc;
  }

  @Override
  public String getStrTagFormatada() {

    StringBuilder strBuilder;

    try {

      if (!this.getLstStrMetodos().isEmpty()) {

        strBuilder = new StringBuilder();
        strBuilder.append("$(document).ready(function(){");
        strBuilder
            .append(Utils.getStrConcatenarLst(this.getLstStrMetodos(), Utils.STR_VAZIA, true));
        strBuilder.append("});");

        this.setStrConteudo(strBuilder.toString());
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return super.getStrTagFormatada();
  }

  public void setIntPrioridade(int intPrioridade) {

    _intPrioridade = intPrioridade;
  }

  public void setStrSrc(String strSrc) {

    try {

      _strSrc = strSrc;

      if (_strSrc != null && !_strSrc.equals(Utils.STR_VAZIA)) {
        this.getAtrSrc().setStrValor(strSrc);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }
}
