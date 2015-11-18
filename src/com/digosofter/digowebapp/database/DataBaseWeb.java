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

      if (Utils.getBooStrVazia(sql)) {

        return;
      }

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      objStatement.execute(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public boolean execSqlGetBoo(String sql) {

    String str;

    try {

      if (Utils.getBooStrVazia(sql)) {

        return false;
      }

      str = this.execSqlGetStr(sql);

      if (Utils.getBooStrVazia(str)) {

        return false;
      }

      str = str.toLowerCase();

      switch (str) {

        case "1":
        case "s":
        case "sim":
        case "t":
        case "true":
          return true;

        default:
          return false;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return false;
  }

  /**
   * Executa um "SQL" e retorna o valor da primeira coluna que tem de ser um
   * inteiro.
   * <p>
   * Caso o valor não exista no bando de dados retorna -1.
   */
  @Override
  public int execSqlGetInt(String sql) {

    String str;

    try {

      if (Utils.getBooStrVazia(sql)) {

        return 0;
      }

      str = this.execSqlGetStr(sql);

      if (Utils.getBooStrVazia(str)) {

        return 0;
      }

      return Integer.valueOf(str);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return 0;
  }

  public List<Integer> execSqlGetLstInt(String sql) {

    List<Integer> lstIntResultado;
    List<String> lstStr;

    try {

      if (Utils.getBooStrVazia(sql)) {

        return null;
      }

      lstIntResultado = new ArrayList<Integer>();
      lstStr = this.execSqlGetLstStr(sql);

      if (lstStr == null || lstStr.isEmpty()) {

        return null;
      }

      for (String str : lstStr) {

        if (Utils.getBooStrVazia(str)) {

          lstIntResultado.add(0);
          continue;
        }

        lstIntResultado.add(Integer.valueOf(str));
      }

      return lstIntResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public List<String> execSqlGetLstStr(String sql) {

    List<String> lstStrResultado;
    ResultSet rst;

    try {

      if (Utils.getBooStrVazia(sql)) {

        return null;
      }

      rst = this.execSqlGetRst(sql);

      lstStrResultado = new ArrayList<String>();

      if (rst == null || !rst.first()) {

        return null;
      }

      do {

        lstStrResultado.add(rst.getString(1));
      }
      while (rst.next());

      rst.close();

      return lstStrResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public ResultSet execSqlGetRst(String sql) {

    Statement objStatement;

    try {

      if (Utils.getBooStrVazia(sql)) {

        return null;
      }

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

      return objStatement.executeQuery(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  @Override
  public String execSqlGetStr(String sql) {

    List<String> lstStr;

    try {

      lstStr = this.execSqlGetLstStr(sql);

      if (lstStr == null || lstStr.isEmpty()) {

        return null;
      }

      return lstStr.get(0);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public ResultSet execView(String strViewNome) {

    String sql;

    try {

      if (Utils.getBooStrVazia(strViewNome)) {

        return null;
      }

      sql = "select * from _viw_name;";
      sql = sql.replace("_viw_name", strViewNome);

      return this.execSqlGetRst(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
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