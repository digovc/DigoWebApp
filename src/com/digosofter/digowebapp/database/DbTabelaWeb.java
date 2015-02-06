package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.database.DbColuna;
import com.digosofter.digojava.database.DbFiltro;
import com.digosofter.digojava.database.DbTabela;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.Tag;
import com.digosofter.digowebapp.html.componente.ConsultaTbl;
import com.digosofter.digowebapp.html.componente.FormularioTbl;

public abstract class DbTabelaWeb extends DbTabela {

  private FormularioTbl _frmTbl;
  private List<DbView> _lstViw;
  private ConsultaTbl _objConsultaTbl;

  public DbTabelaWeb(String strNome) {

    super(strNome);
  }

  /**
   * Adiciona a estrutura completa de uma lista na tag passada como parâmetro.
   */
  public void adicionarConsultaTbl(Tag tagPai) {

    try {

      this.setObjConsultaTbl(new ConsultaTbl(this));
      this.getObjConsultaTbl().setTagPai(tagPai);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona a estrutura completa de um formulário na tag passada como
   * parâmetro.
   */
  public void adicionarFrmTbl(Tag tag) {

    try {

      this.setFrmTbl(new FormularioTbl(this));
      this.getFrmTbl().setTagPai(tag);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Atualizar os valores das colunas da tabela com o registro que satisfaz o
   * filtro passado nos parâmetros "cln" e "strFiltroValor".
   */
  public void buscarRegistro(DbColuna cln, String strFiltroValor) {

    ResultSet rst;

    try {

      this.limparColunas();
      rst = this.getRst(cln, strFiltroValor);

      if (rst == null || !rst.first()) {

        return;
      }

      for (DbColuna cln2 : this.getLstCln()) {

        cln2.setStrValor(rst.getString(cln2.getStrNomeSimplificado()));
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Apelido para o método
   * "buscarRegistroPorCln(DbColuna cln, String strFiltroValor)".
   */
  public void buscarRegistro(DbColunaWeb cln, int intValor) {

    this.buscarRegistro(cln, String.valueOf(intValor));
  }

  public void buscarRegistro(int intId) {

    this.buscarRegistro(String.valueOf(intId));
  }

  public void buscarRegistro(String strId) {

    this.buscarRegistro(this.getClnChavePrimaria(), strId);
  }

  public FormularioTbl getFrmTbl() {

    return _frmTbl;
  }

  /**
   * Retorna o maior "id" desta tabela.
   */
  public int getIntMaxId() {

    int intResultado = 0;
    String sql;

    try {

      sql = "select max (_cln_chave_primaria_nome) from _tbl_nome;";

      sql = sql.replace("_tbl_nome", this.getStrNomeSimplificado());
      sql = sql.replace("_cln_chave_primaria_nome", this.getClnChavePrimaria().getStrNomeSimplificado());

      intResultado = this.getObjDb().execSqlGetInt(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  /**
   * Retorna a quantidade de campos que existe na linha indicada por parâmetro.
   */
  public int getIntQtdCampo(int intLinha) {

    int intResultado = 0;

    try {

      for (DbColuna cln : this.getLstCln()) {

        if (cln.getIntFrmLinha() == intLinha) {

          intResultado++;
        }
      }

      if (intResultado == this.getLstCln().size()) {

        intResultado = 1;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;

  }

  /**
   * Retorna uma "List<Integer>" contendo toda a coluna indicada no parâmetro
   * "cln" da tabela no banco de dados.
   */
  public List<Integer> getLstIntClnValor(DbColunaWeb cln) {

    List<Integer> lstIntResultado = null;
    List<String> lstStr;

    try {

      lstStr = this.getLstStrClnValor(cln);

      if (lstStr != null) {

        lstIntResultado = new ArrayList<Integer>();

        for (int i = 0; i < lstStr.size(); i++) {

          lstIntResultado.add(Integer.valueOf(lstStr.get(i)));
        }
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return lstIntResultado;
  }

  public List<Integer> getLstIntClnValor(DbColunaWeb cln, List<DbFiltro> lstObjDbFiltro) {

    List<Integer> lstIntResultado = null;
    ResultSet objResultSet;

    try {

      objResultSet = this.getRst(cln, lstObjDbFiltro);

      if (objResultSet != null && objResultSet.first()) {

        lstIntResultado = new ArrayList<Integer>();

        do {

          lstIntResultado.add(objResultSet.getInt(1));
        }
        while (objResultSet.next());
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
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

    List<String> lstStrRetorno = null;

    try {

      lstStrRetorno = new ArrayList<String>();

      for (DbColuna cln : this.getLstCln()) {

        if (booPreenchida && Utils.getBooStrVazia(cln.getStrValor())) {

          continue;
        }

        lstStrRetorno.add(cln.getStrNomeSimplificado());
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return lstStrRetorno;
  }

  /**
   * Retorna um "List<String>" com os nomes das colunas e seus valores na
   * síntese "tblNome.clnNome='clnValorFormatado'";.
   *
   * @param "booPreenchida": Indica se o retorno só contém nome de colunas com
   *        valores diferente de "null" ou "String vazia".
   */
  protected List<String> getLstStrClnNomeValor(boolean booPreenchida) {

    List<String> lstStrRetorno = null;
    String strEstrutura;

    try {

      lstStrRetorno = new ArrayList<String>();

      for (DbColuna cln : this.getLstCln()) {

        if (booPreenchida && Utils.getBooStrVazia(cln.getStrValor())) {

          continue;
        }

        strEstrutura = "_cln_nome = '_cln_valor'";

        strEstrutura = strEstrutura.replace("_cln_nome", cln.getStrNomeSimplificado());
        strEstrutura = strEstrutura.replace("_cln_valor", cln.getStrValorSql());
        strEstrutura = strEstrutura.replace("'<null>'", "null");

        lstStrRetorno.add(strEstrutura);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return lstStrRetorno;
  }

  /**
   * Retorna um "List<String>" com os valores "sql" das colunas.
   *
   * @param "booPreenchida": Indica se o retorno só contém nome de colunas com
   *        valores diferente de "null".
   */
  protected List<String> getLstStrClnValor(boolean booPreenchida) {

    String strEstrutura;
    List<String> lstStrRetorno = null;

    try {

      lstStrRetorno = new ArrayList<String>();

      for (DbColuna cln : this.getLstCln()) {

        if (booPreenchida && Utils.getBooStrVazia(cln.getStrValor())) {

          continue;
        }

        strEstrutura = "'_cln_valor'";

        strEstrutura = strEstrutura.replace("_cln_valor", cln.getStrValorSql());
        strEstrutura = strEstrutura.replace("'<null>'", "null");

        lstStrRetorno.add(strEstrutura);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return lstStrRetorno;
  }

  /**
   * Retorna uma "List<String>" contendo toda a coluna indicada no parâmetro
   * "cln" da tabela no banco de dados.
   */
  public List<String> getLstStrClnValor(DbColunaWeb cln) {

    List<String> lstStrResultado = null;
    ResultSet objResultSet;
    String sql;

    try {

      sql = "select _cln_nome from _tbl_nome;";

      sql = sql.replace("_cln_nome", cln.getStrNomeSimplificado());
      sql = sql.replace("_tbl_nome", cln.getTbl().getStrNomeSimplificado());

      objResultSet = ((DataBaseWeb) this.getObjDb()).execSqlGetRst(sql);

      lstStrResultado = new ArrayList<String>();

      if (objResultSet == null || !objResultSet.first()) {

        return lstStrResultado;
      }

      do {

        lstStrResultado.add(objResultSet.getString(1));
      }
      while (objResultSet.next());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return lstStrResultado;
  }

  public List<DbView> getLstViw() {

    try {

      if (_lstViw != null) {

        return _lstViw;
      }

      _lstViw = new ArrayList<DbView>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstViw;
  }

  private ConsultaTbl getObjConsultaTbl() {

    return _objConsultaTbl;
  }

  /**
   * Retorna um "ResultSet" com os todas as linhas, com todas as colunas deta
   * tabela.
   */
  public ResultSet getRst() {

    return this.getRst(this.getLstCln(), null, null);
  }

  public ResultSet getRst(DbColuna cln, List<DbFiltro> lstObjDbFiltro, DbColuna clnOrdem) {

    List<DbColuna> lstClnOrdem;
    ResultSet rstResultado = null;

    try {

      lstClnOrdem = new ArrayList<DbColuna>();

      lstClnOrdem.add(clnOrdem);

      rstResultado = this.getRst(cln, lstObjDbFiltro, lstClnOrdem);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  public ResultSet getRst(DbColuna cln, List<DbFiltro> lstObjDbFiltro, List<DbColuna> lstClnOrdem) {

    List<DbColuna> lstCln;
    ResultSet rstResultado = null;

    try {

      lstCln = new ArrayList<DbColuna>();

      lstCln.add(cln);

      rstResultado = this.getRst(lstCln, lstObjDbFiltro, lstClnOrdem);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  public ResultSet getRst(DbColuna clnFiltro, String strFiltro) {

    List<DbFiltro> lstObjDbFiltro;
    ResultSet rstResultado = null;

    try {

      lstObjDbFiltro = new ArrayList<DbFiltro>();

      lstObjDbFiltro.add(new DbFiltro(clnFiltro, strFiltro));

      rstResultado = this.getRst(this.getLstCln(), lstObjDbFiltro, null);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  public ResultSet getRst(DbColunaWeb clnFiltro, int intFiltro) {

    ResultSet rstResultado = null;

    try {

      rstResultado = this.getRst(clnFiltro, String.valueOf(intFiltro));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  public ResultSet getRst(DbColunaWeb cln, List<DbFiltro> lstObjDbFiltro) {

    ResultSet rstResultado = null;

    try {

      rstResultado = this.getRst(cln, lstObjDbFiltro, this.getClnChavePrimaria());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  public ResultSet getRst(List<DbColuna> lstCln, List<DbFiltro> lstObjDbFiltro, List<DbColuna> lstClnOrdem) {

    ResultSet rstResultado = null;
    String sql;

    try {

      sql = "select _lst_cln_nome from _from where _where order by _order;";

      sql = sql.replace("_lst_cln_nome", this.getSqlParteLstClnNome(lstCln));
      sql = sql.replace("_from", this.getStrNomeSimplificado());
      sql = sql.replace("_where", this.getSqlParteWhere(lstObjDbFiltro));
      sql = sql.replace("_order", this.getSqlParteOrderBy(lstClnOrdem));

      sql = sql.replace(" where <null>", "");
      sql = sql.replace(" order by <null>", "");

      rstResultado = ((DataBaseWeb) this.getObjDb()).execSqlGetRst(sql);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  /**
   * Retorna um "ResultSet" com os valores que devem ser apresentados na tela de
   * consulta desta tabela.
   */
  public ResultSet getRstConsulta() {

    ResultSet rstResultado = null;

    try {

      rstResultado = this.getRst(this.getLstClnConsulta(), this.getLstObjDbFiltroConsulta(), null);

      this.getLstObjDbFiltroConsulta().clear();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return rstResultado;
  }

  /**
   * Retorna um objeto "ResultSet" com as colunas da chave-primária e a coluna
   * que representa o "nome" do registro.
   */
  public ResultSet getRstNomeValor() {

    List<DbColuna> lstCln;
    List<DbColuna> lstClnOrdem;
    ResultSet objResultSetResultado = null;

    try {

      lstCln = new ArrayList<DbColuna>();

      lstCln.add(this.getClnChavePrimaria());
      lstCln.add(this.getClnNome());

      lstClnOrdem = new ArrayList<DbColuna>();
      lstClnOrdem.add(this.getClnNome());

      objResultSetResultado = this.getRst(lstCln, null, lstClnOrdem);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return objResultSetResultado;
  }

  private String getSqlParteLstClnNome(List<DbColuna> lstCln) {

    String strEstrutura;
    String strResultado = Utils.STR_VAZIA;

    try {

      if (lstCln == null || lstCln.size() == 0) {

        return "*";
      }

      for (DbColuna cln : lstCln) {

        strEstrutura = "_tbl_nome._cln_nome, ";

        strEstrutura = strEstrutura.replace("_tbl_nome", cln.getTbl().getStrNomeSimplificado());
        strEstrutura = strEstrutura.replace("_cln_nome", cln.getStrNomeSimplificado());

        strResultado += strEstrutura;
      }

      strResultado = Utils.removerUltimaLetra(strResultado, 2);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  private String getSqlParteOrderBy(List<DbColuna> lstClnOrdem) {

    String strEstrutura;
    String strResultado = Utils.STR_VAZIA;

    try {

      if (lstClnOrdem == null || lstClnOrdem.size() == 0) {

        return "<null>";
      }

      for (DbColuna cln : lstClnOrdem) {

        strEstrutura = "_tbl_nome._cln_nome, ";

        strEstrutura = strEstrutura.replace("_tbl_nome", cln.getTbl().getStrNomeSimplificado());
        strEstrutura = strEstrutura.replace("_cln_nome", cln.getStrNomeSimplificado());

        strResultado += strEstrutura;
      }

      strResultado = Utils.removerUltimaLetra(strResultado, 2);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  private String getSqlParteWhere(List<DbFiltro> lstObjDbFiltro) {

    boolean booPrimeiroTermo = true;
    String strResultado = Utils.STR_VAZIA;

    try {

      if (lstObjDbFiltro == null || lstObjDbFiltro.size() == 0) {

        return "<null>";
      }

      for (DbFiltro objDbFiltro : lstObjDbFiltro) {

        strResultado += objDbFiltro.getSqlFiltro(booPrimeiroTermo);
        strResultado += " ";

        booPrimeiroTermo = false;
      }

      strResultado = Utils.removerUltimaLetra(strResultado);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  /**
   * Persiste os valores atuais das colunas no banco de dados. Caso o valor da
   * coluna chave-primária já exista faz apenas um "update", do contrário insere
   * uma nova linha na tabela. Logo após incluir o registro, atualiza os valores
   * de todas as colunas pelo que está no banco de dados. Retorna o "intId" do
   * registro.
   */
  public int salvar() {

    int intResultado = 0;
    String sql;
    String strId;

    try {

      strId = this.getClnChavePrimaria().getStrValor();

      if (Utils.getBooStrVazia(strId) || "0".equals(strId)) {

        this.getClnChavePrimaria().setStrValor(null);

        sql = "insert into _tbl_nome (_cln_nome) values (_cln_valor) returning _cln_chave_primaria_nome;";

        sql = sql.replace("_tbl_nome", this.getStrNomeSimplificado());
        sql = sql.replace("_cln_nome", Utils.getStrConcatenarLst(this.getLstStrClnNome(true), ", ", true));
        sql = sql.replace("_cln_chave_primaria_nome", this.getClnChavePrimaria().getStrNomeSimplificado());
        sql = sql.replace("_cln_valor", Utils.getStrConcatenarLst(this.getLstStrClnValor(true), ", ", true));

        intResultado = this.getObjDb().execSqlGetInt(sql);
      }
      else {

        sql = "update _tbl_nome set _cln_nome_valor where _cln_chave_primaria = '_cln_chave_primaria_valor'; insert into _tbl_nome (_cln_nome) select _cln_valor where not exists (select true from _tbl_nome where _cln_chave_primaria = '_cln_chave_primaria_valor');";

        sql = sql.replace("_tbl_nome", this.getStrNomeSimplificado());
        sql = sql.replace("_cln_chave_primaria_valor", this.getClnChavePrimaria().getStrValor());
        sql = sql.replace("_cln_chave_primaria", this.getClnChavePrimaria().getStrNomeSimplificado());
        sql = sql.replace("_cln_nome_valor", Utils.getStrConcatenarLst(this.getLstStrClnNomeValor(true), ", ", true));
        sql = sql.replace("_cln_nome", Utils.getStrConcatenarLst(this.getLstStrClnNome(true), ", ", true));
        sql = sql.replace("_cln_valor", Utils.getStrConcatenarLst(this.getLstStrClnValor(true), ", ", true));

        intResultado = this.getClnChavePrimaria().getIntValor();

        this.getObjDb().execSql(sql);
      }

      this.buscarRegistro(intResultado);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  /**
   * Persiste os dados vindos do cliente pelo método "POST" no banco de dados.
   */
  public int salvarRegistroPost() {

    int intResultado = -1;
    String strPostValor;
    String strId;

    try {

      this.limparColunas();

      strId = AppWeb.getI().getStrParam("id");

      if (!Utils.getBooStrVazia(strId)) {

        this.getClnChavePrimaria().setStrValor(strId);
      }

      for (DbColuna cln : this.getLstClnCadastro()) {

        strPostValor = AppWeb.getI().getStrParam(cln.getStrNomeSimplificado());
        cln.setStrValor(strPostValor);
      }

      intResultado = this.salvar();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  private void setFrmTbl(FormularioTbl frmTbl) {

    _frmTbl = frmTbl;
  }

  private void setObjConsultaTbl(ConsultaTbl objConsultaTbl) {

    _objConsultaTbl = objConsultaTbl;
  }
}