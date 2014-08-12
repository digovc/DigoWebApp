package com.digosofter.digowebapp.database;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.ComboBox;
import com.digosofter.digowebapp.html.CssTag;

public class DbColuna extends Objeto {

  public static enum EnmTipo {
    BIGINT,
    BIGSERIAL,
    BOOLEAN,
    CHAR,
    DATE,
    DECIMAL,
    DOUBLE,
    INTEGER,
    INTERVAL,
    MONEY,
    NUMERIC,
    REAL,
    SERIAL,
    SMALLINT,
    TEXT,
    TIME_WITH_TIME_ZONE,
    TIME_WITHOUT_TIME_ZONE,
    TIMESTAMP_WITH_TIME_ZONE,
    TIMESTAMP_WITHOUT_TIME_ZONE,
    VARCHAR,
    XML
  }

  private static enum EnmTipoGrupo {
    ALPHANUMERICO,
    NUMERICO,
    TEMPORAL
  }

  private boolean _booChavePrimaria = false;

  private boolean _booClnNome = false;

  private boolean _booNotNull = false;

  private boolean _booSenha = false;

  private boolean _booVisivelCadastro = true;

  private boolean _booVisivelConsulta = true;

  private DbColuna _clnReferencia;

  private EnmTipo _enmTipo = EnmTipo.INTEGER;

  private EnmTipoGrupo _enmTipoGrupo;

  private int _intFrmLinha = 1;

  private int _intFrmLinhaPeso = 1;

  private int _intOrdem;

  private int _intTamanhoCampo = 100;

  private List<String> _lstStrOpcao;

  private String _strValor;

  private String _strValorSql;

  private DbTabela _tbl;

  public DbColuna(String strNome, DbTabela tbl, EnmTipo enmClnTipo) {

    try {

      this.setStrNome(strNome);
      this.setTbl(tbl);
      this.setEnmClnTipo(enmClnTipo);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Carrega "comboBox" com os devidos valores de acordo com a tabela
   * referenciada ou as opções default da coluna.
   */
  public void carregarComboBox(ComboBox objCampoComboBox) {

    int intIndex;
    ResultSet objResultSet;

    try {

      if (this.getClnReferencia() != null) {

        objResultSet = this.getClnReferencia().getTbl().getRstNomeValor();

        objCampoComboBox.setBooOpcaoVazia(!this.getClnReferencia().getBooNotNull());

        if (objResultSet != null && objResultSet.first()) {

          do {

            objCampoComboBox.addNomeValor(objResultSet.getString(2), objResultSet.getString(1));

          }
          while (objResultSet.next());

          return;
        }
      }

      if (this.getLstStrOpcao().size() > 0) {

        intIndex = 0;

        for (String strOpcao : this.getLstStrOpcao()) {

          objCampoComboBox.addNomeValor(strOpcao, String.valueOf(intIndex++));
        }

        return;
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public boolean getBooChavePrimaria() {

    return _booChavePrimaria;
  }

  public boolean getBooClnNome() {

    return _booClnNome;
  }

  private boolean getBooNotNull() {

    return _booNotNull;
  }

  public boolean getBooSenha() {

    return _booSenha;
  }

  public boolean getBooVisivelCadastro() {

    return _booVisivelCadastro;
  }

  public boolean getBooVisivelConsulta() {

    return _booVisivelConsulta;
  }

  public DbColuna getClnReferencia() {

    return _clnReferencia;
  }

  public Date getDttValor() {

    SimpleDateFormat objSimpleDateFormat;
    Date dttResultado = null;

    try {

      objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      dttResultado = new Date(objSimpleDateFormat.parse(this.getStrValor()).getTime());

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return dttResultado;
  }

  public EnmTipo getEnmTipo() {

    return _enmTipo;
  }

  private EnmTipoGrupo getEnmTipoGrupo() {

    try {

      switch (this.getEnmTipo()) {
        case BIGINT:
          _enmTipoGrupo = EnmTipoGrupo.NUMERICO;
          break;
        default:
          _enmTipoGrupo = EnmTipoGrupo.ALPHANUMERICO;
          break;
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _enmTipoGrupo;
  }

  public int getIntFrmLinha() {

    return _intFrmLinha;
  }

  public int getIntFrmLinhaPeso() {

    return _intFrmLinhaPeso;
  }

  protected int getIntOrdem() {

    return _intOrdem;
  }

  public int getIntTamanhoCampo() {

    return _intTamanhoCampo;
  }

  public int getIntValor() {

    return Integer.valueOf(this.getStrValor());
  }

  public List<String> getLstStrOpcao() {

    try {

      if (_lstStrOpcao == null) {
        _lstStrOpcao = new ArrayList<String>();
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _lstStrOpcao;
  }

  public String getStrCss() {

    String strCss = "";

    try {

      switch (this.getEnmTipoGrupo()) {
        case ALPHANUMERICO:
          strCss += CssTag.getIMain().setTextAlign("left");
          break;
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strCss;
  }

  public String getStrValor() {

    return _strValor;
  }

  public String getStrValorFormatado(String strValor) {

    String strResultado = "";

    try {

      switch (this.getEnmTipoGrupo()) {

        case ALPHANUMERICO:
          strResultado = strValor;
          break;

        case NUMERICO:
          strResultado = strValor;
          break;

        case TEMPORAL:
          strResultado = strValor;
          break;

        default:
          strResultado = strValor;
          break;
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strResultado;
  }

  public String getStrValorSql() {

    String strValorSemScape;

    try {

      _strValorSql = Utils.STR_VAZIA;

      strValorSemScape = this.getStrValor();
      strValorSemScape = strValorSemScape.replace("'", "''");

      switch (this.getEnmTipoGrupo()) {

        case ALPHANUMERICO:

          _strValorSql += "'";
          _strValorSql += strValorSemScape;
          _strValorSql += "'";
          break;

        case NUMERICO:

          _strValorSql += "'";
          _strValorSql += strValorSemScape.replace(".", "").replace(",", ".");
          _strValorSql += "'";
          break;

        default:

          _strValorSql += "'";
          _strValorSql += strValorSemScape;
          _strValorSql += "'";
          break;
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _strValorSql;
  }

  public DbTabela getTbl() {

    return _tbl;
  }

  public void setBooChavePrimaria(boolean booChavePrimaria) {

    try {

      _booChavePrimaria = booChavePrimaria;

      if (_booChavePrimaria) {
        this.getTbl().setClnChavePrimaria(null);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public void setBooClnNome(boolean booClnNome) {

    try {

      _booClnNome = booClnNome;

      if (_booClnNome) {
        this.getTbl().setClnNome(null);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public void setBooNotNull(boolean booNotNull) {

    _booNotNull = booNotNull;
  }

  public void setBooSenha(boolean booSenha) {

    _booSenha = booSenha;
  }

  public void setBooValor(boolean booValor) {

    this.setStrValor(String.valueOf(booValor));
  }

  public void setBooVisivelCadastro(boolean booVisivelCadastro) {

    _booVisivelCadastro = booVisivelCadastro;
  }

  public void setBooVisivelConsulta(boolean booVisivelConsulta) {

    _booVisivelConsulta = booVisivelConsulta;
  }

  public void setClnReferencia(DbColuna clnReferencia) {

    _clnReferencia = clnReferencia;
  }

  public void setEnmClnTipo(EnmTipo enmClnTipo) {

    _enmTipo = enmClnTipo;
  }

  public void setIntFrmLinha(int intFrmLinha) {

    _intFrmLinha = intFrmLinha;
  }

  public void setIntFrmLinhaPeso(int intFrmLinhaPeso) {

    _intFrmLinhaPeso = intFrmLinhaPeso;
  }

  public void setIntOrdem(int intOrdem) {

    _intOrdem = intOrdem;
  }

  public void setIntTamanhoCampo(int intTamanhoCampo) {

    _intTamanhoCampo = intTamanhoCampo;
  }

  public void setIntValor(int intValor) {

    this.setStrValor(String.valueOf(intValor));
  }

  protected void setLstStrOpcao(List<String> lstStrOpcao) {

    _lstStrOpcao = lstStrOpcao;
  }

  public void setStrValor(String strValor) {

    _strValor = strValor;
  }

  private void setTbl(DbTabela tbl) {

    try {

      _tbl = tbl;
      _tbl.getLstCln().add(this);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

}
