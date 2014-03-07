package com.digosofter.digowebapp.database;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class DbFiltro extends Objeto {

  private boolean _booAndOr = true;

  private boolean _booSelect = false;

  private String _strOperador = "=";

  private String _strValor;

  public DbFiltro(DbColuna cln, String strValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNome(cln.getStrNomeSimplificado());
      this.setStrValor(strValor);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public DbFiltro(String strNome, String strValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNome(strNome);
      this.setStrValor(strValor);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public DbFiltro(DbColuna cln, int intValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNome(cln.getStrNomeSimplificado());
      this.setStrValor(String.valueOf(intValor));

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

  private String getStrOperador() {
    return _strOperador;
  }

  private String getStrValor() {
    return _strValor;
  }

  public void setBooAndOr(boolean booAndOr) {
    _booAndOr = booAndOr;
  }

  public void setBooSelect(boolean booSelect) {
    _booSelect = booSelect;
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

    String strDbFiltroResultado = Utils.STRING_VAZIA;
    StringBuilder strBuilder;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (this.getBooSelect()) {

        strDbFiltroResultado = this.getStrValor();

      } else {

        strBuilder = new StringBuilder();

        if (this.getBooAndOr()) {
          strBuilder.append("and ");
        } else {
          strBuilder.append("or ");
        }

        strBuilder.append(this.getStrNomeSimplificado());
        strBuilder.append(this.getStrOperador());
        strBuilder.append("'");
        strBuilder.append(this.getStrValor());
        strBuilder.append("' ");

        strDbFiltroResultado = strBuilder.toString();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strDbFiltroResultado;
  }

}
