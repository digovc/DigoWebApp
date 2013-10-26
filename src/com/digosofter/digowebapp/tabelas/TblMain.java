package com.digosofter.digowebapp.tabelas;

import java.sql.ResultSet;

import com.digosofter.digowebapp.database.DataBase;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;

public abstract class TblMain extends DbTabela {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private DbColuna _clnBooAtivo;

	public DbColuna getClnBooAtivo() {
		if (_clnBooAtivo == null) {
			_clnBooAtivo = new DbColuna("booAtivo", this, DbColuna.EnmClnTipo.BOOLEAN);
		}
		return _clnBooAtivo;
	}

	private DbColuna _clnBooExcluido;

	public DbColuna getClnBooExcluido() {
		if (_clnBooExcluido == null) {
			_clnBooExcluido = new DbColuna("booExcluido", this, DbColuna.EnmClnTipo.BOOLEAN);
		}
		return _clnBooExcluido;
	}

	private DbColuna _clnDttAlteracao;

	public DbColuna getClnDttAlteracao() {
		if (_clnDttAlteracao == null) {
			_clnDttAlteracao = new DbColuna("dttAlteracao", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
		}
		return _clnDttAlteracao;
	}

	private DbColuna _clnDttCadastro;

	public DbColuna getClnDttCadastro() {
		if (_clnDttCadastro == null) {
			_clnDttCadastro = new DbColuna("dttCadastro", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
		}
		return _clnDttCadastro;
	}

	private DbColuna _clnDttExclusao;

	public DbColuna getClnDttExclusao() {
		if (_clnDttExclusao == null) {
			_clnDttExclusao = new DbColuna("dttExclusao", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
		}
		return _clnDttExclusao;
	}

	private DbColuna _clnIntId;

	public DbColuna getClnIntId() {
		if (_clnIntId == null) {
			_clnIntId = new DbColuna("intId", this, DbColuna.EnmClnTipo.BIGSERIAL);

			_clnIntId.setBooChavePrimaria(true);
		}
		return _clnIntId;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	public TblMain(String strNome, DataBase objDataBase) {
		// VARIÁVEIS
		super(strNome, objDataBase);
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			
			this.getClnBooAtivo();
			this.getClnBooExcluido();
			this.getClnDttAlteracao();
			this.getClnDttCadastro();
			this.getClnDttExclusao();
			this.getClnIntId();
			this.getClnNome();
			
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS

	public void buscarRegistroPeloId(int intId) {
		// VARIÁVEIS

		ResultSet objResultSet = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			objResultSet = this.getResultSet(this.getClnIntId(), intId);

			if (objResultSet != null) {
				objResultSet.first();
				for (DbColuna cln : this.getLstCln()) {
					cln.setStrValor(objResultSet.getString(cln.getStrNomeSimplificado()));
				}
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
