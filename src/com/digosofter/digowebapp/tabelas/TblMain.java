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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_clnBooAtivo == null) {
				_clnBooAtivo = new DbColuna("booAtivo", this, DbColuna.EnmClnTipo.BOOLEAN);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnBooAtivo;
	}

	private DbColuna _clnBooExcluido;

	public DbColuna getClnBooExcluido() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_clnBooExcluido == null) {
				_clnBooExcluido = new DbColuna("booExcluido", this, DbColuna.EnmClnTipo.BOOLEAN);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnBooExcluido;
	}

	private DbColuna _clnDttAlteracao;

	public DbColuna getClnDttAlteracao() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_clnDttAlteracao == null) {
				_clnDttAlteracao = new DbColuna("dttAlteracao", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnDttAlteracao;
	}

	private DbColuna _clnDttCadastro;

	public DbColuna getClnDttCadastro() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_clnDttCadastro == null) {
				_clnDttCadastro = new DbColuna("dttCadastro", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnDttCadastro;
	}

	private DbColuna _clnDttExclusao;

	public DbColuna getClnDttExclusao() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_clnDttExclusao == null) {
				_clnDttExclusao = new DbColuna("dttExclusao", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnDttExclusao;
	}

	private DbColuna _clnIntId;

	public DbColuna getClnIntId() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_clnIntId == null) {

				_clnIntId = new DbColuna("intId", this, DbColuna.EnmClnTipo.BIGSERIAL);
				_clnIntId.setBooChavePrimaria(true);
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnIntId;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	public TblMain(String strNome, DataBase objDataBase) {

		super(strNome, objDataBase);

		// VARIÁVEIS
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

		ResultSet objResultSet;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			objResultSet = this.getResultSet(this.getClnIntId(), String.valueOf(intId));

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
