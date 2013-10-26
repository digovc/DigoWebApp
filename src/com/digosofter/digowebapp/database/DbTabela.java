package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public abstract class DbTabela extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private DbColuna _clnChavePrimaria;

	private DbColuna getClnChavePrimaria() {
		for (DbColuna cln : this.getLstCln()) {
			if (cln.getBooChavePrimaria()) {
				_clnChavePrimaria = cln;
				break;
			}
		}
		return _clnChavePrimaria;
	}

	private DbColuna _clnNome;

	public DbColuna getClnNome() {
		for (DbColuna cln : this.getLstCln()) {
			if (cln.getBooClnNome()) {
				_clnNome = cln;
				break;
			}
		}
		return _clnNome;
	}

	private List<DbColuna> _lstCln;

	public List<DbColuna> getLstCln() {
		if (_lstCln == null) {
			_lstCln = new ArrayList<DbColuna>();
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

	public ResultSet getResultSet(List<DbColuna> lstCln, List<DbFiltro> lstObjDbFiltro, List<DbColuna> lstClnOrdem) {
		// VARI�VEIS

		ResultSet objResultSetResultado = null;

		String sql = Utils.STRING_VAZIA;
		String strClnNomes = Utils.STRING_VAZIA;
		String strWhere = Utils.STRING_VAZIA;
		String strOrderBy = Utils.STRING_VAZIA;

		StringBuilder strBuilder = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

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

		List<DbColuna> lstCln = new ArrayList<DbColuna>();
		ResultSet objResultSetResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			lstCln.add(cln);

			objResultSetResultado = this.getResultSet(lstCln, lstObjDbFiltro, lstClnOrdem);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return objResultSetResultado;
	}

	public ResultSet getResultSet(DbColuna clnIntId, int intId) {
		// VARI�VEIS

		List<DbFiltro> lstObjDbFiltro = new ArrayList<DbFiltro>();

		ResultSet objResultSetResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			lstObjDbFiltro.add(new DbFiltro(clnIntId.getStrNomeSimplificado(), String.valueOf(intId)));

			objResultSetResultado = this.getResultSet(this.getLstCln(), lstObjDbFiltro, null);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return objResultSetResultado;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
