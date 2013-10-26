package com.digosofter.digowebapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DataBase extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private int _intPort = 5432;

	private int getIntPort() {
		return _intPort;
	}

	private void setIntPort(int intPort) {
		_intPort = intPort;
	}

	private Connection _objConnection;

	private Connection getObjConnection() {
		// VARI�VEIS

		Properties objProperties = null;
		String url = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (_objConnection == null) {
				objProperties = new Properties();
				objProperties.setProperty("user", this.getStrUser());
				objProperties.setProperty("password", this.getStrPassword());

				url = "jdbc:" + this.getStrDriveName() + "://" + this.getStrHost() + ":" + String.valueOf(this.getIntPort()) + "/"
						+ this.getStrDbName();
				Class.forName("org.postgresql.Driver");
				_objConnection = DriverManager.getConnection(url, objProperties);
			}

			// FIM A��ES
		} catch (Exception ex) {
			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return _objConnection;
	}

	private String _strDbName;

	private String getStrDbName() {
		return _strDbName;
	}

	private void setStrDbName(String strDbName) {
		_strDbName = strDbName;
	}

	private String _strDriveName;

	protected abstract String getStrDriveName();

	private String _strHost;

	private String getStrHost() {
		return _strHost;
	}

	private void setStrHost(String strHost) {
		_strHost = strHost;
	}

	private String _strPassword = "postgres";

	private String getStrPassword() {
		return _strPassword;
	}

	private void setStrPassword(String strPassword) {
		_strPassword = strPassword;
	}

	private String _strUser = "postgres";

	private String getStrUser() {
		return _strUser;
	}

	private void setStrUser(String strUser) {
		_strUser = strUser;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public DataBase(String strHost, String strDbName, String strUser, String strPassword) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrHost(strHost);
			this.setStrDbName(strDbName);
			this.setStrUser(strUser);
			this.setStrPassword(strPassword);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public ResultSet execSqlRetornaResultSet(String sql) {
		// VARI�VEIS

		ResultSet objResultSetResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			Statement objStatement = this.getObjConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			objResultSetResultado = objStatement.executeQuery(sql);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return objResultSetResultado;
	}
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
