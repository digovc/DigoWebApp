package com.digosofter.digowebapp.database;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sun.org.mozilla.javascript.internal.ast.SwitchStatement;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CampoComboBox;
import com.digosofter.digowebapp.html.componente.item.CampoFrmTbl;

public class DbColuna extends Objeto {

  public static enum EnmTipo {
    BIGINT, BIGSERIAL, BOOLEAN, CHAR, DATE, DECIMAL, DOUBLE, INTEGER, INTERVAL, MONEY, NUMERIC, REAL, SERIAL, SMALLINT, TEXT, TIME_WITH_TIME_ZONE, TIME_WITHOUT_TIME_ZONE, TIMESTAMP_WITH_TIME_ZONE, TIMESTAMP_WITHOUT_TIME_ZONE, VARCHAR
  }

  public static enum EnmTipoGrupo {
    ALPHANUMERICO, NUMERICO, TEMPORAL
  }

  private boolean _booChavePrimaria = false;

  private boolean _booClnNome = false;

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

  private CampoFrmTbl _objCampoFrmTbl;

  private String _strValor;

  private String _strValorSql;

  private DbTabela _tbl;

  public DbColuna(String strNome, DbTabela tbl, EnmTipo enmClnTipo) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNome(strNome);
      this.setTbl(tbl);
      this.setEnmClnTipo(enmClnTipo);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Carrega "comboBox" com os devidos valores de acordo com a tabela
   * referenciada ou as opções default da coluna.
   */
  public void carregarComboBox(CampoComboBox objCampoComboBox) {
    // VARIÁVEIS

    int intIndex;
    ResultSet objResultSet;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (this.getClnReferencia() != null) {

        objResultSet = this.getClnReferencia().getTbl().getObjResultSetNomeValor();

        if (objResultSet != null && objResultSet.first()) {

          do {

            objCampoComboBox.getLstStrValor().add(objResultSet.getString(1));
            objCampoComboBox.getLstStrNome().add(objResultSet.getString(2));

          } while (objResultSet.next());

          return;
        }
      }

      if (this.getLstStrOpcao().size() > 0) {

        intIndex = 0;

        for (String strOpcao : this.getLstStrOpcao()) {

          objCampoComboBox.getLstStrValor().add(String.valueOf(++intIndex));
          objCampoComboBox.getLstStrNome().add(strOpcao);
        }

        return;
      }

      // FIM AÇÕES
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
    // VARIÁVEIS

    SimpleDateFormat objSimpleDateFormat;
    Date dttResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
      dttResultado = new Date(objSimpleDateFormat.parse(this.getStrValor()).getTime());

      // FIM AÇÕES
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      switch (this.getEnmTipo()) {
        case BIGINT:
          _enmTipoGrupo = EnmTipoGrupo.NUMERICO;
          break;
        default:
          _enmTipoGrupo = EnmTipoGrupo.ALPHANUMERICO;
          break;
      }

      // FIM AÇÕES
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrOpcao == null) {
        _lstStrOpcao = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrOpcao;
  }

  public CampoFrmTbl getObjCampoFrmTbl() {
    return _objCampoFrmTbl;
  }

  public String getStrValor() {
    return _strValor;
  }

  public String getStrValorSql() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _strValorSql = Utils.STRING_VAZIA;

      switch (this.getEnmTipoGrupo()) {
        case ALPHANUMERICO:
          _strValorSql += "'";
          _strValorSql += this.getStrValor();
          _strValorSql += "'";
          break;
        case NUMERICO:
          _strValorSql += "'";
          _strValorSql += this.getStrValor().replace(".", "").replace(",", ".");
          _strValorSql += "'";
          break;
        default:
          _strValorSql += "'";
          _strValorSql += this.getStrValor();
          _strValorSql += "'";
          break;
      }

      // FIM AÇÕES
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _booChavePrimaria = booChavePrimaria;

      if (_booChavePrimaria) {
        this.getTbl().setClnChavePrimaria(null);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setBooClnNome(boolean booClnNome) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _booClnNome = booClnNome;

      if (_booClnNome) {
        this.getTbl().setClnNome(null);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setBooSenha(boolean booSenha) {
    _booSenha = booSenha;
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

  public void setObjCampoFrmTbl(CampoFrmTbl objCampoFrmTbl) {
    _objCampoFrmTbl = objCampoFrmTbl;
  }

  public void setStrValor(String strValor) {
    _strValor = strValor;
  }

  private void setTbl(DbTabela tbl) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _tbl = tbl;
      _tbl.getLstCln().add(this);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
