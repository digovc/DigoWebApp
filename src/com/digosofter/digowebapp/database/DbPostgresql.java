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
		// VARI�VEIS

		super(strHost, strDbName, strUser, strPassword);

		// FIM VARI�VEIS
		try {
			// A��ES
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
