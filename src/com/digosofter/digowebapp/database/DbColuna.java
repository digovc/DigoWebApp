package com.digosofter.digowebapp.database;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.componente.item.CampoFrmTbl;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CampoComboBox;

public class DbColuna extends Objeto {

	public static enum EnmClnTipo {
		BIGINT, BIGSERIAL, BOOLEAN, CHAR, DATE, DECIMAL, DOUBLE, INTEGER, INTERVAL, MONEY, NUMERIC, REAL, SERIAL, SMALLINT, TEXT, TIME_WITH_TIME_ZONE, TIME_WITHOUT_TIME_ZONE, TIMESTAMP_WITH_TIME_ZONE, TIMESTAMP_WITHOUT_TIME_ZONE, VARCHAR
	}

	// FIM CONSTANTES

	// ATRIBUTOS

	private boolean _booChavePrimaria = false;

	private boolean _booClnNome = false;

	private boolean _booSenha = false;

	private boolean _booVisivelCadastro = true;

	private boolean _booVisivelConsulta = true;

	private DbColuna _clnReferencia;

	private EnmClnTipo _enmClnTipo = EnmClnTipo.INTEGER;

	private int _intFrmLinha = 1;

	private int _intFrmLinhaPeso = 1;

	private int _intOrdem;

	private int _intTamanhoCampo = 50;

	private List<String> _lstStrOpcao;

	private CampoFrmTbl _objCampoFrmTbl;

	private String _strValor;

	private DbTabela _tbl;

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

	/**
	 * Carrega "comboBox" com os devidos valores de acordo com a tabela
	 * referenciada ou as op��es default da coluna.
	 */
	public void carregarComboBox(CampoComboBox objCampoComboBox) {
		// VARI�VEIS

		int intIndex;
		ResultSet objResultSet;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (this.getClnReferencia() != null) {

				objResultSet = this.getClnReferencia().getTbl()
						.getObjResultSetNomeValor();

				if (objResultSet != null && objResultSet.first()) {

					do {

						objCampoComboBox.getLstStrValor().add(
								objResultSet.getString(1));
						objCampoComboBox.getLstStrNome().add(
								objResultSet.getString(2));

					} while (objResultSet.next());

					return;
				}
			}

			if (this.getLstStrOpcao().size() > 0) {

				intIndex = 0;

				for (String strOpcao : this.getLstStrOpcao()) {

					objCampoComboBox.getLstStrValor().add(
							String.valueOf(++intIndex));
					objCampoComboBox.getLstStrNome().add(strOpcao);
				}

				return;
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public boolean getBooChavePrimaria() {
		return _booChavePrimaria;
	}

	public boolean getBooClnNome() {
		return _booClnNome;
	}

	public boolean getBooSenha() {
		return _booSenha;
	}

	public boolean getBooVisivelCadastro() {
		return _booVisivelCadastro;
	}

	public boolean getBooVisivelConsulta() {
		return _booVisivelConsulta;
	}

	public DbColuna getClnReferencia() {
		return _clnReferencia;
	}

	public Date getDttValor() {
		// VARI�VEIS

		SimpleDateFormat objSimpleDateFormat;
		Date dttResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			objSimpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS");
			dttResultado = new Date(objSimpleDateFormat.parse(
					this.getStrValor()).getTime());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return dttResultado;
	}

	public EnmClnTipo getEnmClnTipo() {
		return _enmClnTipo;
	}

	public int getIntFrmLinha() {
		return _intFrmLinha;
	}

	public int getIntFrmLinhaPeso() {
		return _intFrmLinhaPeso;
	}

	protected int getIntOrdem() {
		return _intOrdem;
	}

	public int getIntTamanhoCampo() {
		return _intTamanhoCampo;
	}

	public int getIntValor() {
		return Integer.valueOf(this.getStrValor());
	}

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

	public CampoFrmTbl getObjCampoFrmTbl() {
		return _objCampoFrmTbl;
	}

	public String getStrValor() {
		return _strValor;
	}

	public DbTabela getTbl() {
		return _tbl;
	}

	public void setBooChavePrimaria(boolean booChavePrimaria) {
		_booChavePrimaria = booChavePrimaria;
	}

	public void setBooClnNome(boolean booClnNome) {
		_booClnNome = booClnNome;
	}

	public void setBooSenha(boolean booSenha) {
		_booSenha = booSenha;
	}

	public void setBooVisivelCadastro(boolean booVisivelCadastro) {
		_booVisivelCadastro = booVisivelCadastro;
	}

	public void setBooVisivelConsulta(boolean booVisivelConsulta) {
		_booVisivelConsulta = booVisivelConsulta;
	}

	public void setClnReferencia(DbColuna clnReferencia) {
		_clnReferencia = clnReferencia;
	}

	public void setEnmClnTipo(EnmClnTipo enmClnTipo) {
		_enmClnTipo = enmClnTipo;
	}

	public void setIntFrmLinha(int intFrmLinha) {
		_intFrmLinha = intFrmLinha;
	}

	public void setIntFrmLinhaPeso(int intFrmLinhaPeso) {
		_intFrmLinhaPeso = intFrmLinhaPeso;
	}

	public void setIntOrdem(int intOrdem) {
		_intOrdem = intOrdem;
	}

	public void setIntTamanhoCampo(int intTamanhoCampo) {
		_intTamanhoCampo = intTamanhoCampo;
	}

	public void setIntValor(int intValor) {
		this.setStrValor(String.valueOf(intValor));
	}

	protected void setLstStrOpcao(List<String> lstStrOpcao) {
		_lstStrOpcao = lstStrOpcao;
	}

	public void setObjCampoFrmTbl(CampoFrmTbl objCampoFrmTbl) {
		_objCampoFrmTbl = objCampoFrmTbl;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public void setStrValor(String strValor) {
		_strValor = strValor;
	}

	// FIM CONSTRUTORES

	// M�TODOS

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

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
