package com.digosofter.digowebapp.database.frm;

import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Formulario;
import com.digosofter.digowebapp.html.LimiteFloat;

public class FormularioTbl extends Formulario {

	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private LimiteFloat _objLimiteFloat;

	private LimiteFloat getObjLimiteFloat() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_objLimiteFloat == null) {
				_objLimiteFloat = new LimiteFloat();
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _objLimiteFloat;
	}

	private DbTabela _tbl;

	private DbTabela getTbl() {
		return _tbl;
	}

	private void setTbl(DbTabela tbl) {
		_tbl = tbl;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public FormularioTbl(DbTabela tbl) {

		super(tbl.getStrNomeSimplificado(), Formulario.EnmMetodo.POST);

		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setTbl(tbl);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS

	@Override
	public String getStrTagFormatada() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (DbColuna cln : this.getTbl().getLstCln()) {

				cln.adicionarCampoFrm();
			}

			this.getObjLimiteFloat().setTagPai(this);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return super.getStrTagFormatada();
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
