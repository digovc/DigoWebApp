package com.digosofter.digowebapp.componente;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.componente.item.CampoFrmTbl;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Botao;
import com.digosofter.digowebapp.html.Formulario;
import com.digosofter.digowebapp.html.LimiteFloat;
import com.digosofter.digowebapp.html.Painel;

public class FormularioTbl extends ComponenteMain {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private Botao _btnSalvar;

	private Botao getBtnSalvar() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_btnSalvar == null) {

				_btnSalvar = new Botao();
				_btnSalvar.setStrConteudo("Salvar");
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _btnSalvar;
	}

	private Formulario _frm;

	private Formulario getFrm() {
		// VARI�VEIS

		String strAction;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (_frm == null) {

				strAction = AppWeb.getI().getStrPaginaSolicitada();
				strAction += "?";
				strAction += this.getTbl().getStrNomeSimplificado();
				// strAction += "=salvar";

				_frm = new Formulario(strAction, Formulario.EnmMetodo.POST);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _frm;
	}

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

	private Painel _pnlCampos;

	public Painel getPnlCampos() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlCampos == null) {

				_pnlCampos = new Painel();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlCampos;
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

	/**
	 * Formul�rio para cadastro de um registro da tabela passada como par�metro.
	 */
	public FormularioTbl(DbTabela tbl) {
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

	/**
	 * Retorna a quantidade de linhas contidas no formul�rio.
	 */
	private int getIntQtdLinha() {
		// VARI�VEIS

		int intResultado = 1;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (DbColuna cln : this.getTbl().getLstClnVisivelCadastro()) {
				if (intResultado < cln.getIntFrmLinha()) {
					intResultado = cln.getIntFrmLinha();
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return intResultado;
	}

	@Override
	public void montarLayout() {
		// VARI�VEIS

		String strParam;

		// FIM VARI�VEIS
		try {
			// A��ES

			strParam = AppWeb.getI().getParametro(this.getTbl().getStrNomeSimplificado());

			if (strParam == null) {

				this.montarLayoutCadastro();

			} else {

				this.salvarRegistro();
				this.montarLayoutSalvo();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void montarLayoutCadastro() {
		// VARI�VEIS

		int intQtdLinha;

		// FIM VARI�VEIS
		try {
			// A��ES

			this.getPnlTitulo().setTagPai(this.getPnlContainer());
			this.getFrm().setTagPai(this.getPnlContainer());
			this.getPnlCampos().setTagPai(this.getFrm());
			this.getPnlComando().setTagPai(this.getFrm());
			this.getBtnSalvar().setTagPai(this.getPnlComando());

			intQtdLinha = this.getIntQtdLinha();

			for (int intIndex = 1; intIndex <= intQtdLinha; intIndex++) {

				for (DbColuna cln : this.getTbl().getLstClnVisivelCadastro()) {

					if (cln.getIntFrmLinha() == intIndex) {

						cln.setObjCampoFrmTbl(new CampoFrmTbl(cln));
						cln.getObjCampoFrmTbl().montarLayout();
					}
				}
			}

			this.getObjLimiteFloat().setTagPai(this.getPnlContainer());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private void montarLayoutSalvo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getPnlContainer().setStrConteudo("Salvo com sucesso!");

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	/**
	 * Persiste os dados vindos do cliente no banco de dados.
	 */
	private void salvarRegistro() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getTbl().salvarRegistroPost();

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
