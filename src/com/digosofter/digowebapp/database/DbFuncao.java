package com.digosofter.digowebapp.database;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DbFuncao extends DbTabela {

  private List<String> _lstStrParamIn;

  public List<String> getLstStrParamIn() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrParamIn == null) {
        _lstStrParamIn = new ArrayList<>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrParamIn;
  }

  @Override
  public String getStrNomeSimplificado() {
    // VARIÁVEIS

    String strResultado = "";

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strResultado = "";
      strResultado += super.getStrNomeSimplificado();
      strResultado += "(";
      strResultado += Utils.getStrConcatenarLst(this.getLstStrParamIn(), ",", false);
      strResultado += ")";

      // FIM AÇÕES
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
