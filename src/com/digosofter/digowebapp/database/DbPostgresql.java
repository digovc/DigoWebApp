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

		// VARIÁVEIS
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

	@Override
	protected String getStrDriveName() {
		return STR_DRIVE_NAME;
	}

	@Override
	protected String getStrPackegeClassName() {
		return STR_PACKEGE_CLASS_NAME;
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
