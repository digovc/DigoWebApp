package com.digosofter.digowebapp.database;

import com.digosofter.digowebapp.erro.Erro;

public class DbPostgresql extends DataBase {

	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private String _strDriveName = "postgresql";
	
	@Override
	protected String getStrDriveName() {
		return _strDriveName;
	}


	// FIM ATRIBUTOS

	// CONSTRUTORES

	public DbPostgresql(String strHost, String strDbName, String strUser, String strPassword) {
		// VARIÁVEIS

		super(strHost, strDbName, strUser, strPassword);

		// FIM VARIÁVEIS
		try {
			// AÇÕES
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
