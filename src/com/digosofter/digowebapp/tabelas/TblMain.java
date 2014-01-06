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
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_clnBooAtivo == null) {
				_clnBooAtivo = new DbColuna("booAtivo", this, DbColuna.EnmClnTipo.BOOLEAN);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnBooAtivo;
	}

	private DbColuna _clnBooExcluido;

	public DbColuna getClnBooExcluido() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_clnBooExcluido == null) {
				_clnBooExcluido = new DbColuna("booExcluido", this, DbColuna.EnmClnTipo.BOOLEAN);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnBooExcluido;
	}

	private DbColuna _clnDttAlteracao;

	public DbColuna getClnDttAlteracao() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_clnDttAlteracao == null) {
				_clnDttAlteracao = new DbColuna("dttAlteracao", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnDttAlteracao;
	}

	private DbColuna _clnDttCadastro;

	public DbColuna getClnDttCadastro() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_clnDttCadastro == null) {
				_clnDttCadastro = new DbColuna("dttCadastro", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnDttCadastro;
	}

	private DbColuna _clnDttExclusao;

	public DbColuna getClnDttExclusao() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_clnDttExclusao == null) {
				_clnDttExclusao = new DbColuna("dttExclusao", this, DbColuna.EnmClnTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _clnDttExclusao;
	}

	private DbColuna _clnIntId;

	public DbColuna getClnIntId() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_clnIntId == null) {

				_clnIntId = new DbColuna("intId", this, DbColuna.EnmClnTipo.BIGSERIAL);
				_clnIntId.setBooChavePrimaria(true);
			}

			// FIM A��ES
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

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getClnBooAtivo();
			this.getClnBooExcluido();
			this.getClnDttAlteracao();
			this.getClnDttCadastro();
			this.getClnDttExclusao();
			this.getClnIntId();
			this.getClnNome();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public void buscarRegistroPeloId(int intId) {
		this.buscarRegistroPorCln(this.getClnIntId(), String.valueOf(intId));
	}

	public void buscarRegistroPeloId(String strId) {
		this.buscarRegistroPeloId(Integer.valueOf(strId));
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}