package com.digosofter.digowebapp.database;

import com.digosofter.digowebapp.erro.Erro;

public class DbPostgresql extends DataBase {

	private static final String STR_DRIVE_NAME = "postgresql";
	private static final String STR_PACKEGE_CLASS_NAME = "org.postgresql.Driver";

	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public DbPostgresql(String strHost, int intPort, String strDbName,
			String strUser, String strPassword) {

		super(strHost, intPort, strDbName, strUser, strPassword);

		// VARI�VEIS
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

	@Override
	protected String getStrDriveName() {
		return STR_DRIVE_NAME;
	}

	@Override
	protected String getStrPackegeClassName() {
		return STR_PACKEGE_CLASS_NAME;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
