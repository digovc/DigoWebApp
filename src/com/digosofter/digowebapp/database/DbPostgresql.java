package com.digosofter.digowebapp.database;

import com.digosofter.digojava.erro.Erro;

public class DbPostgresql extends DataBaseWeb {

  private static final String STR_DRIVE_NAME = "postgresql";
  private static final String STR_PACKEGE_CLASS_NAME = "org.postgresql.Driver";

  public DbPostgresql(String strHost, int intPort, String strDbName, String strUser, String strPassword) {

    super(strHost, intPort, strDbName, strUser, strPassword);
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