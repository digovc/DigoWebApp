package com.digosofter.digowebapp.database;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrNome(strNome);
			this.setObjDataBase(objDataBase);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
