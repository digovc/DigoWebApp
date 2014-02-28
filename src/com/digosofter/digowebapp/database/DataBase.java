package com.digosofter.digowebapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DataBase extends Objeto {

  private int _intPort = 5432;

  private Connection _objConnection;

  private String _strDbName;

  private String _strHost;

  private String _strPassword = "postgres";

  private String _strUser = "postgres";

  public DataBase(String strHost, int intPort, String strDbName, String strUser, String strPassword) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrHost(strHost);
      this.setIntPort(intPort);
      this.setStrDbName(strDbName);
      this.setStrUser(strUser);
      this.setStrPassword(strPassword);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void execSql(String sql) {
    // VARI�VEIS

    Statement objStatement;

    // FIM VARI�VEIS
    try {
      // A��ES

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);
      objStatement.execute(sql);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public List<Integer> execSqlRetornaLstInt(String sql) {
    // VARI�VEIS

    ResultSet objResultSet;
    List<Integer> lstIntResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      objResultSet = this.execSqlRetornaResultSet(sql);

      if (objResultSet != null && objResultSet.first()) {

        lstIntResultado = new ArrayList<Integer>();

        do {

          lstIntResultado.add(objResultSet.getInt(1));

        } while (objResultSet.next());
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstIntResultado;
  }

  public ResultSet execSqlRetornaResultSet(String sql) {
    // VARI�VEIS

    ResultSet objResultSetResultado = null;
    Statement objStatement;

    // FIM VARI�VEIS
    try {
      // A��ES

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);
      objResultSetResultado = objStatement.executeQuery(sql);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  public ResultSet execView(String strViewNome) {
    // VARI�VEIS

    ResultSet objResultSetResultado = null;
    StringBuilder strBuilder;

    // FIM VARI�VEIS
    try {
      // A��ES

      strBuilder = new StringBuilder();
      strBuilder.append("select * from ");
      strBuilder.append(strViewNome);
      strBuilder.append(";");

      objResultSetResultado = this.execSqlRetornaResultSet(strBuilder.toString());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  private int getIntPort() {
    return _intPort;
  }

  private Connection getObjConnection() {
    // VARI�VEIS

    Properties objProperties;
    String url;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (_objConnection == null) {

        objProperties = new Properties();
        objProperties.setProperty("user", this.getStrUser());
        objProperties.setProperty("password", this.getStrPassword());

        url = "jdbc:" + this.getStrDriveName() + "://" + this.getStrHost() + ":"
            + String.valueOf(this.getIntPort()) + "/" + this.getStrDbName();
        Class.forName(this.getStrPackegeClassName());
        _objConnection = DriverManager.getConnection(url, objProperties);
      }

      // FIM A��ES
    } catch (Exception ex) {
      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objConnection;
  }

  private String getStrDbName() {
    return _strDbName;
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

  private void setStrDbName(String strDbName) {
    _strDbName = strDbName;
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
