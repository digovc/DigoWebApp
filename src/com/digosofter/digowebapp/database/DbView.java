package com.digosofter.digowebapp.database;

public abstract class DbView extends DbTabela {

  public DbView(String strNome, DataBase objDataBase) {

    super(strNome, objDataBase);

  }


  @Override
  protected void inicializarColunas() {
    // TODO Auto-generated method stub

  }

}
