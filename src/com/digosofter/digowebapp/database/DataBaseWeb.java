package com.digosofter.digowebapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.database.DataBase;
import com.digosofter.digojava.erro.Erro;

public abstract class DataBaseWeb extends DataBase {

  private int _intPort = 5432;
  private Connection _objConnection;
  private String _strHost;
  private String _strPassword = "postgres";
  private String _strUser = "postgres";

  public DataBaseWeb(String strHost, int intPort, String strNome, String strUser, String strPassword) {

    try {

      this.setIntPort(intPort);
      this.setStrHost(strHost);
      this.setStrNome(strNome);
      this.setStrPassword(strPassword);
      this.setStrUser(strUser);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void execSql(String sql) {

    Statement objStatement;

    try {

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      objStatement.execute(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public boolean execSqlGetBoolean(String sql) {

    boolean booResultado = false;
    String str;

    try {

      str = this.execSqlGetStr(sql).toLowerCase();

      switch (str) {

        case "t":
        case "true":
          return true;

        case "f":
        case "false":
        case "":
          return false;

        default:
          return false;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return booResultado;
  }

  /**
   * Executa um "SQL" e retorna o valor da primeira coluna que tem de ser um
   * inteiro.
   * <p>
   * Caso o valor não exista no bando de dados retorna -1.
   */
  @Override
  public int execSqlGetInt(String sql) {

    int intResultado = 0;
    String str;

    try {

      str = this.execSqlGetStr(sql);

      if (Utils.getBooStrVazia(str)) {

        return 0;
      }

      intResultado = Integer.valueOf(str);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  public List<Integer> execSqlGetLstInt(String sql) {

    List<Integer> lstIntResultado = null;
    List<String> lstStr;

    try {

      lstStr = this.execSqlGetLstStr(sql);

      lstIntResultado = new ArrayList<Integer>();

      if (lstStr == null || lstStr.isEmpty()) {

        return lstIntResultado;
      }

      for (String str : lstStr) {

        lstIntResultado.add(Integer.valueOf(str));
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return lstIntResultado;
  }

  public List<String> execSqlGetLstStr(String sql) {

    ResultSet rst;
    List<String> lstStrResultado = null;

    try {

      rst = this.execSqlGetRst(sql);

      lstStrResultado = new ArrayList<String>();

      if (rst == null || !rst.first()) {

        return lstStrResultado;
      }

      do {

        lstStrResultado.add(rst.getString(1));
      }
      while (rst.next());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return lstStrResultado;
  }

  public ResultSet execSqlGetRst(String sql) {

    ResultSet rstResultado = null;
    Statement objStatement;

    try {

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      rstResultado = objStatement.executeQuery(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  @Override
  public String execSqlGetStr(String sql) {

    String strResultado = Utils.STR_VAZIA;
    List<String> lstStr;

    try {

      lstStr = this.execSqlGetLstStr(sql);

      if (lstStr == null || lstStr.isEmpty()) {

        return strResultado;
      }

      strResultado = lstStr.get(0);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public ResultSet execView(String strViewNome) {

    ResultSet objResultSetResultado = null;
    String sql;

    try {

      if (Utils.getBooStrVazia(strViewNome)) {

        return null;
      }

      sql = "select * from _viw_name;";

      sql = sql.replace("_viw_name", strViewNome);

      objResultSetResultado = this.execSqlGetRst(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return objResultSetResultado;
  }

  private int getIntPort() {

    return _intPort;
  }

  private Connection getObjConnection() {

    Properties objProperties;
    String url;

    try {

      if (_objConnection != null) {

        return _objConnection;
      }

      objProperties = new Properties();

      objProperties.setProperty("user", this.getStrUser());
      objProperties.setProperty("password", this.getStrPassword());

      url = "jdbc:" + this.getStrDriveName() + "://" + this.getStrHost() + ":" + String.valueOf(this.getIntPort()) + "/" + this.getStrNome();

      Class.forName(this.getStrPackegeClassName());

      _objConnection = DriverManager.getConnection(url, objProperties);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objConnection;
  }

  protected abstract String getStrDriveName();

  private String getStrHost() {

    return _strHost;
  }

  protected abstract String getStrPackegeClassName();

  private String getStrPassword() {

    return _strPassword;
  }

  private String getStrUser() {

    return _strUser;
  }

  private void setIntPort(int intPort) {

    _intPort = intPort;
  }

  private void setStrHost(String strHost) {

    _strHost = strHost;
  }

  private void setStrPassword(String strPassword) {

    _strPassword = strPassword;
  }

  private void setStrUser(String strUser) {

    _strUser = strUser;
  }
}