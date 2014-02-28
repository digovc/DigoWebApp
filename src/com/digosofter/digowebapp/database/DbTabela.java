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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrNome(strNome);
      this.setObjDataBase(objDataBase);
      this.inicializarColunas();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona a estrutura completa de uma lista na tag passada como parâmetro.
   */
  public void adicionarConsultaTbl(Tag tag) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setObjConsultaTbl(new ConsultaTbl(this));
      this.getObjConsultaTbl().montarLayout();
      this.getObjConsultaTbl().getPnlContainer().setTagPai(tag);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona a estrutura completa de um formulário na tag passada como
   * parâmetro.
   */
  public void adicionarFrmTbl(Tag tag) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setFrmTbl(new FormularioTbl(this));
      this.getFrmTbl().montarLayout();
      this.getFrmTbl().getPnlContainer().setTagPai(tag);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Apelido para o método
   * "buscarRegistroPorCln(DbColuna cln, String strFiltroValor)".
   */
  public void buscarRegistroPorCln(DbColuna cln, int intValor) {
    this.buscarRegistroPorCln(cln, String.valueOf(intValor));
  }

  /**
   * Atualizar os valores das colunas da tabela com o registro que satisfaz o
   * filtro passado nos parâmetros "cln" e "strFiltroValor".
   */
  public void buscarRegistroPorCln(DbColuna cln, String strFiltroValor) {
    // VARIÁVEIS

    ResultSet objResultSet;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.limparColunas();
      objResultSet = this.getObjResultSet(cln, strFiltroValor);

      if (objResultSet != null && objResultSet.first()) {

        for (DbColuna cln2 : this.getLstCln()) {

          cln2.setStrValor(objResultSet.getString(cln2.getStrNomeSimplificado()));
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private DbColuna getClnChavePrimaria() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (DbColuna cln : this.getLstCln()) {
        if (cln.getBooChavePrimaria()) {
          _clnChavePrimaria = cln;
          break;
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnChavePrimaria;
  }

  public DbColuna getClnNome() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

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

      // FIM AÇÕES
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
   * Retorna a quantidade de campos que existe na linha indicada por parâmetro.
   */
  public int getIntQtdCampoPorLinha(int intLinha) {
    // VARIÁVEIS

    int intResultado = 0;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (DbColuna cln : this.getLstCln()) {

        if (cln.getIntFrmLinha() == intLinha) {
          intResultado++;
        }
      }

      if (intResultado == this.getLstCln().size()) {
        intResultado = 1;
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;

  }

  public List<DbColuna> getLstCln() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstCln == null) {
        _lstCln = new ArrayList<DbColuna>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstCln;
  }

  public List<DbColuna> getLstClnVisivelCadastro() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstClnVisivelCadastro == null) {

        _lstClnVisivelCadastro = new ArrayList<DbColuna>();

        for (DbColuna cln : this.getLstCln()) {

          if (cln.getBooVisivelCadastro()) {
            _lstClnVisivelCadastro.add(cln);
          }
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstClnVisivelCadastro;
  }

  public List<DbColuna> getLstClnVisivelConsulta() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstClnVisivelConsulta == null) {

        _lstClnVisivelConsulta = new ArrayList<DbColuna>();

        for (DbColuna cln : this.getLstCln()) {

          if (cln.getBooVisivelConsulta()) {
            _lstClnVisivelConsulta.add(cln);
          }
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstClnVisivelConsulta;
  }

  /**
   * Retorna uma "List<Integer>" contendo toda a coluna indicada no parâmetro
   * "cln" da tabela no banco de dados.
   */
  public List<Integer> getLstIntClnValor(DbColuna cln) {
    // VARIÁVEIS

    List<Integer> lstIntResultado = null;
    List<String> lstStr;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstStr = this.getLstStrClnValor(cln);

      if (lstStr != null) {

        lstIntResultado = new ArrayList<Integer>();

        for (int intIndex = 0; intIndex < lstStr.size(); intIndex++) {
          lstIntResultado.add(Integer.valueOf(lstStr.get(intIndex)));
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstIntResultado;
  }

  /**
   * Retorna um "List<String>" com os nomes das colunas.
   * 
   * @param "booPreenchida": Indica se o retorno só contém nome de colunas com
   *        valores diferente de "null".
   */
  protected List<String> getLstStrClnNome(boolean booPreenchida) {
    // VARIÁVEIS

    List<String> lstStrRetorno = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstStrRetorno = new ArrayList<String>();

      for (DbColuna cln : this.getLstCln()) {

        if (booPreenchida && Utils.getBooStrVazia(cln.getStrValor())) {
          continue;
        }

        lstStrRetorno.add(cln.getStrNomeSimplificado());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstStrRetorno;
  }

  /**
   * Retorna um "List<String>" com os nomes das colunas e seus valores na
   * síntese "tblNome.clnNome='clnValorFormatado'";.
   * 
   * @param "booPreenchida": Indica se o retorno só contém nome de colunas com
   *        valores diferente de "null".
   */
  protected List<String> getLstStrClnNomeValor(boolean booPreenchida) {
    // VARIÁVEIS

    List<String> lstStrRetorno = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstStrRetorno = new ArrayList<String>();

      for (DbColuna cln : this.getLstCln()) {

        if (booPreenchida && Utils.getBooStrVazia(cln.getStrValor())) {
          continue;
        }

        lstStrRetorno.add(cln.getStrNomeSimplificado());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return lstStrRetorno;
  }

  /**
   * Retorna uma "List<String>" contendo toda a coluna indicada no parâmetro
   * "cln" da tabela no banco de dados.
   */
  public List<String> getLstStrClnValor(DbColuna cln) {
    // VARIÁVEIS

    List<String> lstStrResultado = null;
    ResultSet objResultSet;
    String sql;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

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

      // FIM AÇÕES
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
    // VARIÁVEIS

    List<DbColuna> lstCln;
    ResultSet objResultSetResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstCln = new ArrayList<DbColuna>();
      lstCln.add(cln);

      objResultSetResultado = this.getObjResultSet(lstCln, lstObjDbFiltro, lstClnOrdem);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  public ResultSet getObjResultSet(DbColuna clnFiltro, String strFiltro) {
    // VARIÁVEIS

    List<DbFiltro> lstObjDbFiltro;
    ResultSet objResultSetResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstObjDbFiltro = new ArrayList<DbFiltro>();
      lstObjDbFiltro.add(new DbFiltro(clnFiltro.getStrNomeSimplificado(), strFiltro));

      objResultSetResultado = this.getObjResultSet(this.getLstCln(), lstObjDbFiltro, null);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
    return objResultSetResultado;
  }

  public ResultSet getObjResultSet(List<DbColuna> lstCln, List<DbFiltro> lstObjDbFiltro,
      List<DbColuna> lstClnOrdem) {
    // VARIÁVEIS

    ResultSet objResultSetResultado = null;

    String sql;
    String strClnNomes = Utils.STRING_VAZIA;
    String strWhere = Utils.STRING_VAZIA;
    String strOrderBy = Utils.STRING_VAZIA;

    StringBuilder strBuilder;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

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

      // FIM AÇÕES
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
    // VARIÁVEIS

    ResultSet objResultSetResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objResultSetResultado = this.getObjResultSet(this.getLstClnVisivelConsulta(), null, null);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objResultSetResultado;
  }

  /**
   * Retorna um objeto "ResultSet" com as colunas da chave-primária e a coluna
   * que representa o "nome" do registro.
   */
  public ResultSet getObjResultSetNomeValor() {
    // VARIÁVEIS

    List<DbColuna> lstCln;
    List<DbColuna> lstClnOrdem;

    ResultSet objResultSetResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstCln = new ArrayList<DbColuna>();
      lstCln.add(this.getClnChavePrimaria());
      lstCln.add(this.getClnNome());

      lstClnOrdem = new ArrayList<DbColuna>();
      lstClnOrdem.add(this.getClnNome());

      objResultSetResultado = this.getObjResultSet(lstCln, null, lstClnOrdem);

      // FIM AÇÕES
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (DbColuna cln : this.getLstCln()) {
        cln.setStrValor(Utils.STRING_VAZIA);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Persiste os valores atuais das colunas no banco de dados. Caso o valor da
   * coluna chave-primária já exista faz apenas um "update", do contrário insere
   * uma nova linha na tabela. Logo após incluir o registro, atualiza os valores
   * de todas as colunas pelo que está no banco de dados.
   */
  public void salvar() {
    // VARIÁVEIS

    ResultSet objResultSet;

    String sql;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      // Object[]

      // sql =
      // "UPDATE %1$ SET %6$ WHERE %2$=%3$; INSERT INTO %1$ (%4$) SELECT %5$ WHERE NOT EXISTS (SELECT 1 FROM %1$ WHERE %2$=%3$);";
      // sql = sql.format(this.getStrNomeSimplificado(),
      // this.getClnChavePrimaria().getStrNomeSimplificado(),
      // this.getClnChavePrimaria()
      // .getStrValor(), strClnNomes, strClnValores, strClnNomesValores);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Persiste os dados vindos do cliente pelo método "POST" no banco de dados.
   */
  public void salvarRegistroPost() {
    // VARIÁVEIS

    String strPostValor;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.limparColunas();

      for (DbColuna cln : this.getLstClnVisivelCadastro()) {

        strPostValor = AppWeb.getI().getParametro(cln.getStrNomeSimplificado());
        cln.setStrValor(strPostValor);
      }

      this.salvar();

      // FIM AÇÕES
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
