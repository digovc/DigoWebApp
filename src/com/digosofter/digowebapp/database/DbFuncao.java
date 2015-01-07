package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public abstract class DbFuncao extends DbTabelaWeb {

  private List<String> _lstStrParamIn;

  public DbFuncao(String strNome) {

    super(strNome);
  }

  public List<String> getLstStrParamIn() {

    try {

      if (_lstStrParamIn != null) {

        return _lstStrParamIn;
      }

      _lstStrParamIn = new ArrayList<>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrParamIn;
  }

  /**
   * Retorna um objeto "ResultSet" contendo o resultado da consulta feita no
   * banco de dados. Esta consulta faz uso do valores contidos na propriedade
   * "lstStrParamIn" desta função.
   */
  public ResultSet getRst() {

    ResultSet rstResultado = null;
    String sql;

    try {

      sql = "select * from _fnc_nome;";
      sql = sql.replace("_fnc_nome", this.getStrNomeSimplificado());

      rstResultado = ((DataBaseWeb) this.getObjDb()).execSqlGetRst(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  @Override
  public String getStrNomeSimplificado() {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = "_fnc_nome (_params)";

      strResultado = strResultado.replace("_fnc_nome", super.getStrNomeSimplificado());
      strResultado = strResultado.replace("_params", this.getStrParamInFormatado());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  private String getStrParamInFormatado() {

    String strResultado = Utils.STR_VAZIA;

    try {

      for (String str : this.getLstStrParamIn()) {

        str = "'" + str + "', ";
        strResultado += str;
      }

      strResultado = Utils.removerUltimaLetra(strResultado);
      strResultado = Utils.removerUltimaLetra(strResultado);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }
}
