package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DbFuncao extends DbTabela {

  private List<String> _lstStrParamIn;

  public DbFuncao(String strNome, DataBase objDataBase) {

    super(strNome, objDataBase);
  }

  public List<String> getLstStrParamIn() {

    try {

      if (_lstStrParamIn == null) {
        _lstStrParamIn = new ArrayList<>();
      }

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

      rstResultado = this.getObjDataBase().execSqlGetRst(sql);

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

    String strResultado = "";

    try {

      strResultado = "";
      strResultado += super.getStrNomeSimplificado();
      strResultado += "(";
      strResultado += this.getStrParamInFormatado();
      strResultado += ")";

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
        str = "'" + str + "',";
        strResultado += str;
      }

      strResultado = Utils.getStrRemoverUltimaLetra(strResultado);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strResultado;
  }

}
