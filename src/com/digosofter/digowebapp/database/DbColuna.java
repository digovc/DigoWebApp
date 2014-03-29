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
import com.digosofter.digowebapp.html.Tag;

public class DbColuna extends Objeto {

  public static enum EnmTipo {
    BIGINT, BIGSERIAL, BOOLEAN, CHAR, DATE, DECIMAL, DOUBLE, INTEGER, INTERVAL, MONEY, NUMERIC, REAL, SERIAL, SMALLINT, TEXT, TIME_WITH_TIME_ZONE, TIME_WITHOUT_TIME_ZONE, TIMESTAMP_WITH_TIME_ZONE, TIMESTAMP_WITHOUT_TIME_ZONE, VARCHAR
  }

  private static enum EnmTipoGrupo {
    ALPHANUMERICO, NUMERICO, TEMPORAL
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

  private int _intTamanhoCampo = 50;

  private List<String> _lstStrOpcao;

  private String _strValor;

  private String _strValorSql;

  private DbTabela _tbl;

  public DbColuna(String strNome, DbTabela tbl, EnmTipo enmClnTipo) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrNome(strNome);
      this.setTbl(tbl);
      this.setEnmClnTipo(enmClnTipo);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Carrega "comboBox" com os devidos valores de acordo com a tabela
   * referenciada ou as op��es default da coluna.
   */
  public void carregarComboBox(ComboBox objCampoComboBox) {
    // VARI�VEIS

    int intIndex;
    ResultSet objResultSet;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (this.getClnReferencia() != null) {

        objResultSet = this.getClnReferencia().getTbl().getObjResultSetNomeValor();

        objCampoComboBox.setBooOpcaoVazia(!this.getClnReferencia().getBooNotNull());

        if (objResultSet != null && objResultSet.first()) {

          do {

            objCampoComboBox.addNomeValor(objResultSet.getString(2), objResultSet.getString(1));

          } while (objResultSet.next());

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

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
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
    // VARI�VEIS

    SimpleDateFormat objSimpleDateFormat;
    Date dttResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      dttResultado = new Date(objSimpleDateFormat.parse(this.getStrValor()).getTime());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return dttResultado;
  }

  public EnmTipo getEnmTipo() {
    return _enmTipo;
  }

  private EnmTipoGrupo getEnmTipoGrupo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      switch (this.getEnmTipo()) {
        case BIGINT:
          _enmTipoGrupo = EnmTipoGrupo.NUMERICO;
          break;
        default:
          _enmTipoGrupo = EnmTipoGrupo.ALPHANUMERICO;
          break;
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
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
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrOpcao == null) {
        _lstStrOpcao = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrOpcao;
  }

  public String getStrCss() {
    // VARI�VEIS

    String strCss = "";

    // FIM VARI�VEIS
    try {
      // A��ES

      switch (this.getEnmTipoGrupo()) {
        case ALPHANUMERICO:
          strCss += CssTag.getCssMainInst().setTextAlign("left");
          break;
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strCss;
  }

  public String getStrValor() {
    return _strValor;
  }

  public String getStrValorFormatado(String strValor) {
    // VARI�VEIS

    String strResultado = "";

    // FIM VARI�VEIS
    try {
      // A��ES

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

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String getStrValorSql() {
    // VARI�VEIS

    String strValorSemScape;

    // FIM VARI�VEIS
    try {
      // A��ES

      _strValorSql = Utils.STRING_VAZIA;

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

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strValorSql;
  }

  public DbTabela getTbl() {
    return _tbl;
  }

  public void setBooChavePrimaria(boolean booChavePrimaria) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      _booChavePrimaria = booChavePrimaria;

      if (_booChavePrimaria) {
        this.getTbl().setClnChavePrimaria(null);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setBooClnNome(boolean booClnNome) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      _booClnNome = booClnNome;

      if (_booClnNome) {
        this.getTbl().setClnNome(null);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
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
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      _tbl = tbl;
      _tbl.getLstCln().add(this);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
