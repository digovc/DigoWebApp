package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public abstract class DbFuncao extends DbTabelaWeb {

  private List<String> _lstStrParamIn;

  public DbFuncao(String strNome) {

    super(strNome);
  }

  public void addParam(double dblParam) {

    this.addParam(String.valueOf(dblParam));
  }

  public void addParam(GregorianCalendar dttParam) {

    this.addParam(Utils.getStrDataFormatada(dttParam, Utils.EnmDataFormato.YYYY_MM_DD_HH_MM_SS));
  }

  public void addParam(int intParam) {

    this.addParam(String.valueOf(intParam));
  }

  public void addParam(String strParam) {

    this.getLstStrParamIn().add(strParam);
  }

  public void addParamFk(int intParam) {

    this.addParam(intParam > 0 ? String.valueOf(intParam) : null);
  }

  private List<String> getLstStrParamIn() {

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
  @Override
  public ResultSet getRstConsulta() {

    String sql;

    try {

      sql = "select * from _fnc_nome;";
      sql = sql.replace("_fnc_nome", this.getStrNomeSql());

      return ((DataBaseWeb) this.getObjDb()).execSqlGetRst(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  @Override
  public String getStrNomeSql() {

    String strResultado;

    try {

      if (this.getLstStrParamIn() == null) {

        return super.getStrNomeSql();
      }

      if (this.getLstStrParamIn().isEmpty()) {

        return super.getStrNomeSql();
      }

      strResultado = "_fnc_nome (_params)";

      strResultado = strResultado.replace("_fnc_nome", super.getStrNomeSql());
      strResultado = strResultado.replace("_params", this.getStrParamFormatado());

      return strResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  private String getStrParamFormatado() {

    String strEstrutura;
    String strResultado;

    try {

      if (this.getLstStrParamIn() == null) {

        return Utils.STR_VAZIA;
      }

      if (this.getLstStrParamIn().isEmpty()) {

        return Utils.STR_VAZIA;
      }

      strResultado = Utils.STR_VAZIA;

      for (String strParamIn : this.getLstStrParamIn()) {

        if (Utils.getBooStrVazia(strParamIn)) {

          strResultado += "null, ";
          continue;
        }

        strParamIn = strParamIn.replace("'", "''");

        strEstrutura = "'_param_valor', ";

        strEstrutura = strEstrutura.replace("_param_valor", strParamIn);

        strResultado += strEstrutura;
      }

      return Utils.removerUltimaLetra(strResultado, 2);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public void limparParametros() {

    this.getLstStrParamIn().clear();
  }
}