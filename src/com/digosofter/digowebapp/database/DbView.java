package com.digosofter.digowebapp.database;

import com.digosofter.digojava.database.Dominio;

public abstract class DbView extends DbTabelaWeb<Dominio> {

  public DbView(String strNome) {

    super(strNome, null);
  }
}