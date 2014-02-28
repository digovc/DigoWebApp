package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.componente.ConsultaTbl;
import com.digosofter.digowebapp.componente.FormularioTbl;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Tag;

public abstract class DbTabela extends Objeto {

  private DbColuna _clnChavePrimaria;

  private DbColuna _clnNome;

  private FormularioTbl _frmTbl;

  private List<DbColuna> _lstCln;

  private List<DbColuna> _lstClnVisivelCadastro;

  private List<DbColuna> _lstClnVisivelConsulta;

  private ConsultaTbl _objConsultaTbl;

  private DataBase _objDataBase;

  public DbTabela(String strNome, DataBase objDataBase) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrNome(strNome);
      this.setObjDataBase(objDataBase);
      this.inicializarColunas();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona a estrutura completa de uma lista na tag passada como par�metro.
   */
  public void adicionarConsultaTbl(Tag tag) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setObjConsultaTbl(new ConsultaTbl(this));
      this.getObjConsultaTbl().montarLayout();
      this.getObjConsultaTbl().getPnlContainer().setTagPai(tag);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona a estrutura completa de um formul�rio na tag passada como
   * par�metro.
   */
  public void adicionarFrmTbl(Tag tag) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setFrmTbl(new FormularioTbl(this));
      this.getFrmTbl().montarLayout();
      this.getFrmTbl().getPnlContainer().setTagPai(tag);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Apelido para o m�todo
   * "buscarRegistroPorCln(DbColuna cln, String strFiltroValor)".
   */
  public void buscarRegistroPorCln(DbColuna cln, int intValor) {
    this.buscarRegistroPorCln(cln, String.valueOf(intValor));
  }

  /**
   * Atualizar os valores das colunas da tabela com o registro que satisfaz o
   * filtro passado nos par�metros "cln" e "strFiltroValor".
   */
  public void buscarRegistroPorCln(DbColuna cln, String strFiltroValor) {
    // VARI�VEIS

    ResultSet objResultSet;

    // FIM VARI�VEIS
    try {
      // A��ES

      this.limparColunas();
      objResultSet = this.getObjResultSet(cln, strFiltroValor);

      if (objResultSet != null && objResultSet.first()) {

        for (DbColuna cln2 : this.getLstCln()) {

          cln2.setStrValor(objResultSet.getString(cln2.getStrNomeSimplificado()));
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private DbColuna getClnChavePrimaria() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      for (DbColuna cln : this.getLstCln()) {
        if (cln.getBooChavePrimaria()) {
          _clnChavePrimaria = cln;
          break;
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnChavePrimaria;
  }

  public DbColuna getClnNome() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_clnNome == null) {

        for (DbColuna cln : this.getLstCln()) {

          if (cln.getBooClnNome()) {

            _clnNome = cln;
            break;
          }
        }
      }

      if (_clnNome == null) {
        _clnNome = this.getLstCln().get(0);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnNome;
  }

  public FormularioTbl getFrmTbl() {
    return _frmTbl;
  }

  /**
   * Retorna a quantidade de campos que existe na linha indicada por par�metro.
   */
  public int getIntQtdCampoPorLinha(int intLinha) {
    // VARI�VEIS

    int intResultado = 0;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (DbColuna cln : this.getLstCln()) {

        if (cln.getIntFrmLinha() == intLinha) {
          intResultado++;
        }
      }

      if (intResultado == this.getLstCln().size()) {
        intResultado = 1;
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;

  }

  public List<DbColuna> getLstCln() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstCln == null) {
        _lstCln = new ArrayList<DbColuna>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstCln;
  }

  public List<DbColuna> getLstClnVisivelCadastro() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstClnVisivelCadastro == null) {

        _lstClnVisivelCadastro = new ArrayList<DbColuna>();

        for (DbColuna cln : this.getLstCln()) {

          if (cln.getBooVisivelCadastro()) {
            _lstClnVisivelCadastro.add(cln);
          }
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstClnVisivelCadastro;
  }

  public List<DbColuna> getLstClnVisivelConsulta() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstClnVisivelConsulta == null) {

        _lstClnVisivelConsulta = new ArrayList<DbColuna>();

        for (DbColuna cln : this.getLstCln()) {

          if (cln.getBooVisivelConsulta()) {
            _lstClnVisivelConsulta.add(cln);
          }
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstClnVisivelConsulta;
  }

  /**
   * Retorna uma "List<Integer>" contendo toda a coluna indicada no par�metro
   * "cln" da tabela no banco de dados.
   */
  public List<Integer> getLstIntClnValor(DbColuna cln) {
    // VARI�VEIS

    List<Integer> lstIntResultado = null;
    List<String> lstStr;

    // FIM VARI�VEIS
    try {
      // A��ES

      lstStr = this.getLstStrClnValor(cln);

      if (lstStr != null) {

        lstIntResultado = new ArrayList<Integer>();

        for (int intIndex = 0; intIndex < lstStr.size(); intIndex++) {
          lstIntResultado.add(Integer.valueOf(lstStr.get(intIndex)));
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstIntResultado;
  }

  /**
   * Retorna um "List<String>" com os nomes das colunas.
   * 
   * @param "booPreenchida": Indica se o retorno s� cont�m nome de colunas com
   *        valores diferente de "null".
   */
  protected List<String> getLstStrClnNome(boolean booPreenchida) {
    // VARI�VEIS

    List<String> lstStrRetorno = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      lstStrRetorno = new ArrayList<String>();

      for (DbColuna cln : this.getLstCln()) {

        if (booPreenchida && Utils.getBooStrVazia(cln.getStrValor())) {
          continue;
        }

        lstStrRetorno.add(cln.getStrNomeSimplificado());
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstStrRetorno;
  }

  /**
   * Retorna um "List<String>" com os nomes das colunas e seus valores na
   * s�ntese "tblNome.clnNome='clnValorFormatado'";.
   * 
   * @param "booPreenchida": Indica se o retorno s� cont�m nome de colunas com
   *        valores diferente de "null".
   */
  protected List<String> getLstStrClnNomeValor(boolean booPreenchida) {
    // VARI�VEIS

    List<String> lstStrRetorno = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      lstStrRetorno = new ArrayList<String>();

      for (DbColuna cln : this.getLstCln()) {

        if (booPreenchida && Utils.getBooStrVazia(cln.getStrValor())) {
          continue;
        }

        lstStrRetorno.add(cln.getStrNomeSimplificado());
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstStrRetorno;
  }

  /**
   * Retorna uma "List<String>" contendo toda a coluna indicada no par�metro
   * "cln" da tabela no banco de dados.
   */
  public List<String> getLstStrClnValor(DbColuna cln) {
    // VARI�VEIS

    List<String> lstStrResultado = null;
    ResultSet objResultSet;
    String sql;

    // FIM VARI�VEIS
    try {
      // A��ES

      sql = "select " + cln.getStrNomeSimplificado() + " from " + this.getStrNomeSimplificado()
          + ";";

      objResultSet = this.getObjDataBase().execSqlRetornaResultSet(sql);

      if (objResultSet != null) {
        if (objResultSet.first()) {

          lstStrResultado = new ArrayList<String>();

          do {

            lstStrResultado.add(objResultSet.getString(1));

          } while (objResultSet.next());
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstStrResultado;
  }

  private ConsultaTbl getObjConsultaTbl() {
    return _objConsultaTbl;
  }

  public DataBase getObjDataBase() {
    return _objDataBase;
  }

  public ResultSet getObjResultSet(DbColuna cln, List<DbFiltro> lstObjDbFiltro,
      List<DbColuna> lstClnOrdem) {
    // VARI�VEIS

    List<DbColuna> lstCln;
    ResultSet objResultSetResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      lstCln = new ArrayList<DbColuna>();
      lstCln.add(cln);

      objResultSetResultado = this.getObjResultSet(lstCln, lstObjDbFiltro, lstClnOrdem);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  public ResultSet getObjResultSet(DbColuna clnFiltro, String strFiltro) {
    // VARI�VEIS

    List<DbFiltro> lstObjDbFiltro;
    ResultSet objResultSetResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      lstObjDbFiltro = new ArrayList<DbFiltro>();
      lstObjDbFiltro.add(new DbFiltro(clnFiltro.getStrNomeSimplificado(), strFiltro));

      objResultSetResultado = this.getObjResultSet(this.getLstCln(), lstObjDbFiltro, null);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
    return objResultSetResultado;
  }

  public ResultSet getObjResultSet(List<DbColuna> lstCln, List<DbFiltro> lstObjDbFiltro,
      List<DbColuna> lstClnOrdem) {
    // VARI�VEIS

    ResultSet objResultSetResultado = null;

    String sql;
    String strClnNomes = Utils.STRING_VAZIA;
    String strWhere = Utils.STRING_VAZIA;
    String strOrderBy = Utils.STRING_VAZIA;

    StringBuilder strBuilder;

    // FIM VARI�VEIS
    try {
      // A��ES

      strBuilder = new StringBuilder();
      strBuilder.append("select ");

      if (lstCln == null) {
        strBuilder.append("*");
      } else {
        for (DbColuna cln : lstCln) {
          strClnNomes += "tbl" + this.getIntId() + ".";
          strClnNomes += cln.getStrNomeSimplificado() + ",";
        }
        strClnNomes = Utils.getStrRemoverUltimaLetra(strClnNomes);
        strBuilder.append(strClnNomes);
      }

      strBuilder.append(" from ");
      strBuilder.append(this.getStrNomeSimplificado());
      strBuilder.append(" ");
      strBuilder.append("tbl" + this.getIntId());

      if (lstObjDbFiltro != null) {
        strBuilder.append(" where ");
        for (DbFiltro objDbFiltro : lstObjDbFiltro) {
          strWhere += objDbFiltro.toString();
        }

        strWhere = strWhere.substring(4);
        strWhere = Utils.getStrRemoverUltimaLetra(strWhere);

        strBuilder.append(strWhere);
      }

      if (lstClnOrdem != null) {

        strBuilder.append(" order by ");

        for (DbColuna clnOrdem : lstClnOrdem) {

          strOrderBy += "tbl" + this.getIntId() + ".";
          strOrderBy += clnOrdem.getStrNomeSimplificado();
          strOrderBy += " ";

        }

        strOrderBy = Utils.getStrRemoverUltimaLetra(strOrderBy);
        strBuilder.append(strOrderBy);
      }

      strBuilder.append(";");
      sql = strBuilder.toString();
      objResultSetResultado = this.getObjDataBase().execSqlRetornaResultSet(sql);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  /**
   * Retorna um "ResultSet" com os valores que devem ser apresentados na tela de
   * consulta desta tabela.
   */
  public ResultSet getObjResultSetConsulta() {
    // VARI�VEIS

    ResultSet objResultSetResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      objResultSetResultado = this.getObjResultSet(this.getLstClnVisivelConsulta(), null, null);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  /**
   * Retorna um objeto "ResultSet" com as colunas da chave-prim�ria e a coluna
   * que representa o "nome" do registro.
   */
  public ResultSet getObjResultSetNomeValor() {
    // VARI�VEIS

    List<DbColuna> lstCln;
    List<DbColuna> lstClnOrdem;

    ResultSet objResultSetResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      lstCln = new ArrayList<DbColuna>();
      lstCln.add(this.getClnChavePrimaria());
      lstCln.add(this.getClnNome());

      lstClnOrdem = new ArrayList<DbColuna>();
      lstClnOrdem.add(this.getClnNome());

      objResultSetResultado = this.getObjResultSet(lstCln, null, lstClnOrdem);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  protected abstract void inicializarColunas();

  /**
   * Limpa os valores de todas as colunas da tabela.
   */
  public void limparColunas() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      for (DbColuna cln : this.getLstCln()) {
        cln.setStrValor(Utils.STRING_VAZIA);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Persiste os valores atuais das colunas no banco de dados. Caso o valor da
   * coluna chave-prim�ria j� exista faz apenas um "update", do contr�rio insere
   * uma nova linha na tabela. Logo ap�s incluir o registro, atualiza os valores
   * de todas as colunas pelo que est� no banco de dados.
   */
  public void salvar() {
    // VARI�VEIS

    ResultSet objResultSet;

    String sql;

    // FIM VARI�VEIS
    try {
      // A��ES

      // Object[]

      // sql =
      // "UPDATE %1$ SET %6$ WHERE %2$=%3$; INSERT INTO %1$ (%4$) SELECT %5$ WHERE NOT EXISTS (SELECT 1 FROM %1$ WHERE %2$=%3$);";
      // sql = sql.format(this.getStrNomeSimplificado(),
      // this.getClnChavePrimaria().getStrNomeSimplificado(),
      // this.getClnChavePrimaria()
      // .getStrValor(), strClnNomes, strClnValores, strClnNomesValores);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Persiste os dados vindos do cliente pelo m�todo "POST" no banco de dados.
   */
  public void salvarRegistroPost() {
    // VARI�VEIS

    String strPostValor;

    // FIM VARI�VEIS
    try {
      // A��ES

      this.limparColunas();

      for (DbColuna cln : this.getLstClnVisivelCadastro()) {

        strPostValor = AppWeb.getI().getParametro(cln.getStrNomeSimplificado());
        cln.setStrValor(strPostValor);
      }

      this.salvar();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setFrmTbl(FormularioTbl frmTbl) {
    _frmTbl = frmTbl;
  }

  private void setObjConsultaTbl(ConsultaTbl objConsultaTbl) {
    _objConsultaTbl = objConsultaTbl;
  }

  private void setObjDataBase(DataBase objDataBase) {
    _objDataBase = objDataBase;
  }

  /**
   * Apelido para "limparColunas()".
   */
  public void zerarColunas() {
    this.limparColunas();
  }

  /**
   * Apelido para "limparColunas()".
   */
  public void zerarValores() {
    this.limparColunas();
  }

}
