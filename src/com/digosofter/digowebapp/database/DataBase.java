package com.digosofter.digowebapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DataBase extends Objeto {

  private int _intPort = 5432;

  private Connection _objConnection;

  private String _strDbName;

  private String _strHost;

  private String _strPassword = "postgres";

  private String _strUser = "postgres";

  public DataBase(String strHost, int intPort, String strDbName, String strUser, String strPassword) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrHost(strHost);
      this.setIntPort(intPort);
      this.setStrDbName(strDbName);
      this.setStrUser(strUser);
      this.setStrPassword(strPassword);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void execSql(String sql) {
    // VARIÁVEIS

    Statement objStatement;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);
      objStatement.execute(sql);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Executa um "SQL" e retorna o valor da primeira coluna que tem de ser um
   * inteiro.
   * <p>
   * Caso o valor não exista no bando de dados retorna -1.
   */
  public int execSqlGetInt(String sql) {
    // VARIÁVEIS

    int intResultado = 0;
    String str;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      str = this.execSqlGetStr(sql);

      if (!Utils.getBooStrVazia(str)) {
        intResultado = Integer.valueOf(str);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;
  }

  public List<Integer> execSqlGetLstInt(String sql) {
    // VARIÁVEIS

    List<Integer> lstIntResultado = null;
    List<String> lstStr;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstStr = this.execSqlGetLstStr(sql);

      if (lstStr != null && !lstStr.isEmpty()) {

        lstIntResultado = new ArrayList<Integer>();

        for (String str : lstStr) {

          lstIntResultado.add(Integer.valueOf(str));
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstIntResultado;
  }

  public List<String> execSqlGetLstStr(String sql) {
    // VARIÁVEIS

    ResultSet rst;
    List<String> lstStrResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      rst = this.execSqlGetRst(sql);

      if (rst != null && rst.first()) {

        lstStrResultado = new ArrayList<String>();

        do {

          lstStrResultado.add(rst.getString(1));

        } while (rst.next());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstStrResultado;
  }

  public ResultSet execSqlGetRst(String sql) {
    // VARIÁVEIS

    ResultSet rstResultado = null;
    Statement objStatement;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
          ResultSet.CONCUR_READ_ONLY);
      rstResultado = objStatement.executeQuery(sql);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return rstResultado;
  }

  public String execSqlGetStr(String sql) {
    // VARIÁVEIS

    String strResultado = Utils.STR_VAZIA;
    List<String> lstStr;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstStr = this.execSqlGetLstStr(sql);

      if (lstStr != null && lstStr.size() > 0) {
        strResultado = lstStr.get(0);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public ResultSet execView(String strViewNome) {
    // VARIÁVEIS

    ResultSet objResultSetResultado = null;
    StringBuilder strBuilder;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strBuilder = new StringBuilder();
      strBuilder.append("select * from ");
      strBuilder.append(strViewNome);
      strBuilder.append(";");

      objResultSetResultado = this.execSqlGetRst(strBuilder.toString());

      // FIM AÇÕES
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
    // VARIÁVEIS

    Properties objProperties;
    String url;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_objConnection == null) {

        objProperties = new Properties();
        objProperties.setProperty("user", this.getStrUser());
        objProperties.setProperty("password", this.getStrPassword());

        url = "jdbc:" + this.getStrDriveName() + "://" + this.getStrHost() + ":"
            + String.valueOf(this.getIntPort()) + "/" + this.getStrDbName();
        Class.forName(this.getStrPackegeClassName());
        _objConnection = DriverManager.getConnection(url, objProperties);
      }

      // FIM AÇÕES
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

  public boolean execSqlGetBoolean(String sql) {
    // VARIÁVEIS

    boolean booResultado = false;
    String str;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

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

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return booResultado;
  }

}
