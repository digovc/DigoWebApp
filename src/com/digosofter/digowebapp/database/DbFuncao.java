package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
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

  /**
   * Retorna um objeto "ResultSet" contendo o resultado da consulta feita no
   * banco de dados. Esta consulta faz uso do valores contidos na propriedade
   * "lstStrParamIn" desta fun��o.
   */
  public ResultSet getRst() {
    // VARI�VEIS

    ResultSet rstResultado = null;
    String sql;

    // FIM VARI�VEIS
    try {
      // A��ES

      sql = "select * from _fnc_nome;";
      sql = sql.replace("_fnc_nome", this.getStrNomeSimplificado());

      rstResultado = this.getObjDataBase().execSqlGetRst(sql);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return rstResultado;
  }

}
