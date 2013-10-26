package com.digosofter.digowebapp.database;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;

public class DbColuna extends Objeto {
	// CONSTANTES

	public static enum EnmClnTipo {
		BIGINT, BIGSERIAL, BOOLEAN, CHAR, DATE, DECIMAL, DOUBLE, INTEGER, INTERVAL, MONEY, NUMERIC, REAL, SERIAL, SMALLINT, TEXT, TIME_WITH_TIME_ZONE, TIME_WITHOUT_TIME_ZONE, TIMESTAMP_WITH_TIME_ZONE, TIMESTAMP_WITHOUT_TIME_ZONE, VARCHAR
	}

	// FIM CONSTANTES

	// ATRIBUTOS

	private boolean _booChavePrimaria = false;

	public boolean getBooChavePrimaria() {
		return _booChavePrimaria;
	}

	public void setBooChavePrimaria(boolean booChavePrimaria) {
		_booChavePrimaria = booChavePrimaria;
	}

	private boolean _booClnNome = false;

	public boolean getBooClnNome() {
		return _booClnNome;
	}

	public void setBooClnNome(boolean booClnNome) {
		_booClnNome = booClnNome;
	}

	private boolean _booSenha = false;

	private boolean getBooSenha() {
		return _booSenha;
	}

	public void setBooSenha(boolean booSenha) {
		_booSenha = booSenha;
	}

	private DbColuna _clnReferencia;

	private DbColuna getClnReferencia() {
		return _clnReferencia;
	}

	public void setClnReferencia(DbColuna clnReferencia) {
		_clnReferencia = clnReferencia;
	}

	private EnmClnTipo _enmClnTipo = EnmClnTipo.INTEGER;

	private EnmClnTipo getEnmClnTipo() {
		return _enmClnTipo;
	}

	public void setEnmClnTipo(EnmClnTipo enmClnTipo) {
		_enmClnTipo = enmClnTipo;
	}

	private List<String> _lstStrOpcao;

	public List<String> getLstStrOpcao() {
		if (_lstStrOpcao == null) {
			_lstStrOpcao = new ArrayList<String>();
		}
		return _lstStrOpcao;
	}

	private void setLstStrOpcao(List<String> lstStrOpcao) {
		_lstStrOpcao = lstStrOpcao;
	}

	private String _strValor;

	public String getStrValor() {
		return _strValor;
	}

	public void setStrValor(String strValor) {
		_strValor = strValor;
	}

	private DbTabela _tbl;

	private DbTabela getTbl() {
		return _tbl;
	}

	private void setTbl(DbTabela tbl) {
		_tbl = tbl;
		_tbl.getLstCln().add(this);
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public DbColuna(String strNome, DbTabela tbl, EnmClnTipo enmClnTipo) {
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

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
