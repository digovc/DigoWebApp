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

	private boolean _booVisivelCadastro = true;

	public boolean getBooVisivelCadastro() {
		return _booVisivelCadastro;
	}

	public void setBooVisivelCadastro(boolean booVisivelCadastro) {
		_booVisivelCadastro = booVisivelCadastro;
	}

	private boolean _booVisivelConsulta = true;

	public boolean getBooVisivelConsulta() {
		return _booVisivelConsulta;
	}

	public void setBooVisivelConsulta(boolean booVisivelConsulta) {
		_booVisivelConsulta = booVisivelConsulta;
	}

	private DbColuna _clnReferencia;

	public DbColuna getClnReferencia() {
		return _clnReferencia;
	}

	public void setClnReferencia(DbColuna clnReferencia) {
		_clnReferencia = clnReferencia;
	}

	private EnmClnTipo _enmClnTipo = EnmClnTipo.INTEGER;

	public EnmClnTipo getEnmClnTipo() {
		return _enmClnTipo;
	}

	public void setEnmClnTipo(EnmClnTipo enmClnTipo) {
		_enmClnTipo = enmClnTipo;
	}

	private int _intFrmLinha = 1;

	public int getIntFrmLinha() {
		return _intFrmLinha;
	}

	public void setIntFrmLinha(int intFrmLinha) {
		_intFrmLinha = intFrmLinha;
	}

	private int _intFrmLinhaPeso = 1;

	public int getIntFrmLinhaPeso() {
		return _intFrmLinhaPeso;
	}

	public void setIntFrmLinhaPeso(int intFrmLinhaPeso) {
		_intFrmLinhaPeso = intFrmLinhaPeso;
	}

	private int _intTamanhoCampo = 50;

	public int getIntTamanhoCampo() {
		return _intTamanhoCampo;
	}

	public void setIntTamanhoCampo(int intTamanhoCampo) {
		_intTamanhoCampo = intTamanhoCampo;
	}

	private List<String> _lstStrOpcao;

	public List<String> getLstStrOpcao() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_lstStrOpcao == null) {
				_lstStrOpcao = new ArrayList<String>();
			}

			// FIM AÇÕES
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

	public CampoFrmTbl getObjCampoFrmTbl() {
		return _objCampoFrmTbl;
	}

	public void setObjCampoFrmTbl(CampoFrmTbl objCampoFrmTbl) {
		_objCampoFrmTbl = objCampoFrmTbl;
	}

	private String _strValor;

	public String getStrValor() {
		return _strValor;
	}

	public Date getDttValor() {
		// VARIÁVEIS

		SimpleDateFormat objSimpleDateFormat;
		Date dttResultado = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			dttResultado = new Date(objSimpleDateFormat.parse(this.getStrValor()).getTime());

			// FIM AÇÕES
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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_tbl = tbl;
			_tbl.getLstCln().add(this);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
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

	/**
	 * Carrega "comboBox" com os devidos valores de acordo com a tabela
	 * referenciada ou as opções default da coluna.
	 */
	public void carregarComboBox(CampoComboBox objCampoComboBox) {
		// VARIÁVEIS

		int intIndex;
		ResultSet objResultSet;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (this.getClnReferencia() != null) {

				objResultSet = this.getClnReferencia().getTbl().getObjResultSetNomeValor();

				if (objResultSet != null && objResultSet.first()) {

					do {

						objCampoComboBox.getLstStrValor().add(objResultSet.getString(1));
						objCampoComboBox.getLstStrNome().add(objResultSet.getString(2));

					} while (objResultSet.next());

					return;
				}
			}

			if (this.getLstStrOpcao().size() > 0) {

				intIndex = 0;

				for (String strOpcao : this.getLstStrOpcao()) {

					objCampoComboBox.getLstStrValor().add(String.valueOf(++intIndex));
					objCampoComboBox.getLstStrNome().add(strOpcao);
				}

				return;
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
