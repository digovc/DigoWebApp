package com.digosofter.digowebapp.database;


public class DbFirebird extends DataBaseWeb {

  private static final String STR_DRIVE_NAME = "firebirdsql";
  private static final String STR_PACKEGE_CLASS_NAME = "org.firebirdsql.jdbc.FBDriver";

  public DbFirebird(String strHost, int intPort, String strName) {

    super(strHost, intPort, strName, "sysdba", "masterkey");
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
