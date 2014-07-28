package com.digosofter.digowebapp.database;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class DbFiltro extends Objeto {

  private boolean _booAndOr = true;

  private boolean _booSelect = false;

  private DbColuna _cln;

  private String _strOperador = "=";

  private String _strValor;

  public DbFiltro(DbColuna cln, int intValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setCln(cln);
      this.setStrValor(String.valueOf(intValor));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public DbFiltro(DbColuna cln, String strValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setCln(cln);
      this.setStrValor(strValor);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public DbFiltro(String strSelect) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrValor(strSelect);
      this.setBooSelect(true);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private boolean getBooAndOr() {
    return _booAndOr;
  }

  private boolean getBooSelect() {
    return _booSelect;
  }

  private DbColuna getCln() {
    return _cln;
  }

  private String getStrOperador() {
    return _strOperador;
  }

  private String getStrValor() {
    return _strValor;
  }

  public void setBooAndOr(boolean booAndOr) {
    _booAndOr = booAndOr;
  }

  private void setBooSelect(boolean booSelect) {
    _booSelect = booSelect;
  }

  private void setCln(DbColuna cln) {
    _cln = cln;
  }

  public void setStrOperador(String strOperador) {
    _strOperador = strOperador;
  }

  public void setStrValor(String strValor) {
    _strValor = strValor;
  }

  @Override
  public String toString() {
    // VARIÁVEIS

    String strResultado = Utils.STR_VAZIA;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (this.getBooSelect()) {
        return this.getStrValor();
      }

      strResultado = "_condicao _tbl_nome._cln_nome _operador '_filtro_valor'";
      strResultado = strResultado.replace("_condicao", this.getBooAndOr() ? "and" : "or");
      strResultado = strResultado.replace("_tbl_nome", this.getCln().getTbl().getStrNomeSimplificado());
      strResultado = strResultado.replace("_cln_nome", this.getCln().getStrNomeSimplificado());
      strResultado = strResultado.replace("_operador", this.getStrOperador());
      strResultado = strResultado.replace("_filtro_valor", this.getStrValor());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

}
