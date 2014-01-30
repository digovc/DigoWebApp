package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.database.frm.FormularioTbl;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DbTabela extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private DbColuna _clnChavePrimaria;

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

	private DbColuna _clnNome;

	public DbColuna getClnNome() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			for (DbColuna cln : this.getLstCln()) {
				if (cln.getBooClnNome()) {
					_clnNome = cln;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnNome;
	}

	private FormularioTbl _frmTbl;

	public FormularioTbl getFrmTbl() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_frmTbl == null) {
				_frmTbl = new FormularioTbl(this);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _frmTbl;
	}

	private void setFrmTbl(FormularioTbl frmTbl) {
		_frmTbl = frmTbl;
	}

	private List<DbColuna> _lstCln;

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

	private DataBase _objDataBase;

	public DataBase getObjDataBase() {
		return _objDataBase;
	}

	private void setObjDataBase(DataBase objDataBase) {
		_objDataBase = objDataBase;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public DbTabela(String strNome, DataBase objDataBase) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrNome(strNome);
			this.setObjDataBase(objDataBase);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public void buscarRegistroPorCln(DbColuna cln, String strFiltroValor) {
		// VARI�VEIS

		ResultSet objResultSet;

		// FIM VARI�VEIS
		try {
			// A��ES

			this.limparColunas();
			objResultSet = this.getResultSet(cln, strFiltroValor);

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

	public void buscarRegistroPorCln(DbColuna cln, int intValor) {
		this.buscarRegistroPorCln(cln, String.valueOf(intValor));
	}

	/**
	 * Retorna a quantidade de campos que existe na linha indicada por
	 * par�metro.
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

	public List<Integer> getLstIntColunaValor(DbColuna cln) {
		// VARI�VEIS

		List<Integer> lstIntResultado = null;
		List<String> lstStr;

		// FIM VARI�VEIS
		try {
			// A��ES

			lstStr = this.getLstStrColunaValor(cln);

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

	public List<String> getLstStrColunaValor(DbColuna cln) {
		// VARI�VEIS

		List<String> lstStrResultado = null;
		ResultSet objResultSet;
		String sql;

		// FIM VARI�VEIS
		try {
			// A��ES

			sql = "select " + cln.getStrNomeSimplificado() + " from " + this.getStrNomeSimplificado() + ";";

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

	public ResultSet getResultSet(List<DbColuna> lstCln, List<DbFiltro> lstObjDbFiltro, List<DbColuna> lstClnOrdem) {
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
					strClnNomes += cln.getStrNomeSimplificado() + ",";
				}
				strClnNomes = Utils.getStrRemoverUltimaLetra(strClnNomes);
				strBuilder.append(strClnNomes);
			}

			strBuilder.append(" from ");
			strBuilder.append(this.getStrNomeSimplificado());

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

	public ResultSet getResultSet(DbColuna cln, List<DbFiltro> lstObjDbFiltro, List<DbColuna> lstClnOrdem) {
		// VARI�VEIS

		List<DbColuna> lstCln;
		ResultSet objResultSetResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			lstCln = new ArrayList<DbColuna>();
			lstCln.add(cln);

			objResultSetResultado = this.getResultSet(lstCln, lstObjDbFiltro, lstClnOrdem);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return objResultSetResultado;
	}

	public ResultSet getResultSet(DbColuna clnFiltro, String strFiltro) {
		// VARI�VEIS

		List<DbFiltro> lstObjDbFiltro;
		ResultSet objResultSetResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			lstObjDbFiltro = new ArrayList<DbFiltro>();
			lstObjDbFiltro.add(new DbFiltro(clnFiltro.getStrNomeSimplificado(), strFiltro));

			objResultSetResultado = this.getResultSet(this.getLstCln(), lstObjDbFiltro, null);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return objResultSetResultado;
	}

	public int inserir() {
		// VARI�VEIS

		int intIdResultado = 0;

		List<String> lstStrClnNome;
		List<String> lstStrClnValor;

		ResultSet objResultSet;

		StringBuilder stbSql;

		// FIM VARI�VEIS
		try {
			// A��ES

			lstStrClnNome = new ArrayList<String>();
			lstStrClnValor = new ArrayList<String>();

			for (DbColuna cln : this.getLstCln()) {

				if (!cln.getStrValor().equals(Utils.STRING_VAZIA)) {

					lstStrClnNome.add(cln.getStrNomeSimplificado());
					lstStrClnValor.add("'" + cln.getStrValor() + "'");

				}
			}

			stbSql = new StringBuilder();
			stbSql.append("INSERT INTO ");
			stbSql.append(this.getStrNomeSimplificado());
			stbSql.append("(" + Utils.getStrConcatenarLst(lstStrClnNome, ",", false) + ")VALUES(");
			stbSql.append(Utils.getStrConcatenarLst(lstStrClnValor, ",", false) + ")RETURNING intid;");

			objResultSet = this.getObjDataBase().execSqlRetornaResultSet(stbSql.toString());

			if (objResultSet != null) {
				if (objResultSet.first()) {
					intIdResultado = objResultSet.getInt(1);
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return intIdResultado;
	}

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

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
