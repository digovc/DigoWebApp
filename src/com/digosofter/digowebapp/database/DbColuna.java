package com.digosofter.digowebapp.database;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.database.frm.CampoFrmTbl;
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

	public boolean getBooSenha() {
		return _booSenha;
	}

	public void setBooSenha(boolean booSenha) {
		_booSenha = booSenha;
	}

	private DbColuna _clnReferencia;

	public DbColuna getClnReferencia() {
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

	private int _intFrmLinha;

	public int getIntFrmLinha() {
		return _intFrmLinha;
	}

	public void setIntFrmLinha(int intFrmLinha) {
		_intFrmLinha = intFrmLinha;
	}

	private int _intFrmLinhaPeso = 1;

	private int getIntFrmLinhaPeso() {
		return _intFrmLinhaPeso;
	}

	public void setIntFrmLinhaPeso(int intFrmLinhaPeso) {
		_intFrmLinhaPeso = intFrmLinhaPeso;
	}

	private List<String> _lstStrOpcao;

	public List<String> getLstStrOpcao() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_lstStrOpcao == null) {
				_lstStrOpcao = new ArrayList<String>();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _lstStrOpcao;
	}

	private void setLstStrOpcao(List<String> lstStrOpcao) {
		_lstStrOpcao = lstStrOpcao;
	}

	private CampoFrmTbl _objCampoFrmTbl;

	private CampoFrmTbl getObjCampoFrmTbl() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_objCampoFrmTbl == null) {
				_objCampoFrmTbl = new CampoFrmTbl(this);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _objCampoFrmTbl;
	}

	private void setObjCampoFrmTbl(CampoFrmTbl objCampoFrmTbl) {
		_objCampoFrmTbl = objCampoFrmTbl;
	}

	private String _strValor;

	public String getStrValor() {
		return _strValor;
	}

	public Date getDttValor() {
		// VARI�VEIS

		SimpleDateFormat objSimpleDateFormat;
		Date dttResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			dttResultado = new Date(objSimpleDateFormat.parse(this.getStrValor()).getTime());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return dttResultado;
	}

	public int getIntValor() {
		return Integer.valueOf(this.getStrValor());
	}

	public void setStrValor(String strValor) {
		_strValor = strValor;
	}

	public void setIntValor(int intValor) {
		this.setStrValor(String.valueOf(intValor));
	}

	private DbTabela _tbl;

	public DbTabela getTbl() {
		return _tbl;
	}

	private void setTbl(DbTabela tbl) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_tbl = tbl;
			_tbl.getLstCln().add(this);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public DbColuna(String strNome, DbTabela tbl, EnmClnTipo enmClnTipo) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrNome(strNome);
			this.setTbl(tbl);
			this.setEnmClnTipo(enmClnTipo);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	/**
	 * Adiciona um campo ao formul�rio passado como par�metro.
	 */
	public void adicionarCampoFrm() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getObjCampoFrmTbl().setTagPai(this.getTbl().getFrmTbl());

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
