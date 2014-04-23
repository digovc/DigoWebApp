package com.digosofter.digowebapp.database;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DbFuncao extends DbTabela {

  private List<String> _lstStrParamIn;

  public List<String> getLstStrParamIn() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrParamIn == null) {
        _lstStrParamIn = new ArrayList<>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrParamIn;
  }

  @Override
  public String getStrNomeSimplificado() {
    // VARI�VEIS

    String strResultado = "";

    // FIM VARI�VEIS
    try {
      // A��ES

      strResultado = "";
      strResultado += super.getStrNomeSimplificado();
      strResultado += "(";
      strResultado += Utils.getStrConcatenarLst(this.getLstStrParamIn(), ",", false);
      strResultado += ")";

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public DbFuncao(String strNome, DataBase objDataBase) {
    super(strNome, objDataBase);
  }

}
