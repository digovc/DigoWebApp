package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public class JavaScriptTag extends Tag {

  private int _intPrioridade = 5;
  private List<String> _lstStrMetodos;

  public JavaScriptTag(String strSrc) {

    super("script");

    try {

      this.setBooForcarTagDupla(true);
      this.getLstAtr().add(new Atributo("type", "text/javascript"));
      this.setSrc(strSrc);
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

  public int getIntPrioridade() {

    return _intPrioridade;
  }

  public List<String> getLstStrMetodos() {

    try {

      if (_lstStrMetodos != null) {

        return _lstStrMetodos;
      }

      _lstStrMetodos = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrMetodos;
  }

  @Override
  public String getStrTagFormatada() {

    String strResultado;

    try {

      if (this.getLstStrMetodos().isEmpty()) {

        return super.getStrTagFormatada();
      }

      strResultado = "$(document).ready(function(){_metodos});";

      strResultado = strResultado.replace("_metodos", Utils.getStrConcatenarLst(this.getLstStrMetodos(), Utils.STR_VAZIA, true));

      this.setStrConteudo(strResultado);

      return super.getStrTagFormatada();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public void setIntPrioridade(int intPrioridade) {

    _intPrioridade = intPrioridade;
  }
}