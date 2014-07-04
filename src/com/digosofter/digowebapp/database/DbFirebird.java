package com.digosofter.digowebapp.database;

import com.digosofter.digowebapp.erro.Erro;

public class DbFirebird extends DataBase {

  private static final String STR_DRIVE_NAME = "firebirdsql";
  private static final String STR_PACKEGE_CLASS_NAME = "org.firebirdsql.jdbc.FBDriver";

  public DbFirebird(String strHost, int intPort, String strDbName) {

    super(strHost, intPort, strDbName, "sysdba", "masterkey");

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

  @Override
  protected String getStrDriveName() {
    return STR_DRIVE_NAME;
  }

  @Override
  protected String getStrPackegeClassName() {
    return STR_PACKEGE_CLASS_NAME;
  }

}
