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
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_objLimiteFloat == null) {
				_objLimiteFloat = new LimiteFloat();
			}

			// FIM A��ES
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

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setTbl(tbl);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	@Override
	public String getStrTagFormatada() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			for (DbColuna cln : this.getTbl().getLstCln()) {

				cln.adicionarCampoFrm();
			}

			this.getObjLimiteFloat().setTagPai(this);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return super.getStrTagFormatada();
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
