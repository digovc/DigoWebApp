package com.digosofter.digowebapp.componente.item;

import com.digosofter.digowebapp.componente.ComponenteMain;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbColuna.EnmClnTipo;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.CampoComboBox;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.Campo.EnmTipo;

public class CampoFrmTbl extends ComponenteMain {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private DbColuna _cln;

	private DbColuna getCln() {
		return _cln;
	}

	private void setCln(DbColuna cln) {
		_cln = cln;
	}

	private Campo _objCampo;

	private Campo getObjCampo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_objCampo == null) {

				this.definirTipoCampo();

				_objCampo.setStrNome(this.getCln().getStrNomeSimplificado());
				_objCampo.adicionarCss(CssTag.getCssMainInstancia().setPadding(5, "px"));
				_objCampo.adicionarCss(CssTag.getCssMainInstancia().setWidth(100, "%"));

			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _objCampo;
	}

	private void setObjCampo(Campo objCampo) {
		_objCampo = objCampo;
	}

	private Painel _pnlCampo;

	private Painel getPnlCampo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlCampo == null) {
				_pnlCampo = new Painel();
				_pnlCampo.adicionarCss(CssTag.getCssMainInstancia().setPaddingLeft(10));
				_pnlCampo.adicionarCss(CssTag.getCssMainInstancia().setPaddingRight(10));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlCampo;
	}

	private Painel _pnlContainer;

	@Override
	public Painel getPnlContainer() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlContainer == null) {
				_pnlContainer = super.getPnlContainer();
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia().setFloat("left"));
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia().setWidth(this.getDblCampoWidth(), "%"));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlContainer;
	}

	private Painel _pnlTitulo;

	@Override
	protected Painel getPnlTitulo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlTitulo == null) {
				_pnlTitulo = super.getPnlTitulo();
				_pnlTitulo.setStrConteudo(this.getCln().getStrNomeExibicao());
				_pnlTitulo.adicionarCss(CssTag.getCssMainInstancia().setPaddingLeft(10));
				_pnlTitulo.adicionarCss(CssTag.getCssMainInstancia().setPaddingRight(10));
				_pnlTitulo.adicionarCss(CssTag.getCssMainInstancia().setTextAlign("left"));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlTitulo;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public CampoFrmTbl(DbColuna cln) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setCln(cln);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	/**
	 * Define o tipo de campo a ser colocado no formul�rio de acordo com o tipo
	 * de dado que � esperado para o mesmo.
	 */
	private void definirTipoCampo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			// ComboBox
			if (this.getCln().getClnReferencia() != null || this.getCln().getLstStrOpcao().size() > 0) {
				this.definirTipoCampoComboBox();
				return;
			}

			// CheckBox
			if (this.getCln().getEnmClnTipo() == EnmClnTipo.BOOLEAN) {
				this.definirTipoCampoCheckBox();
				return;
			}

			// Comum
			this.setObjCampo(new Campo());

			if (this.getCln().getIntTamanhoCampo() >= 120) {
				this.getObjCampo().setEnmTipo(EnmTipo.TEXT_AREA);
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	/**
	 * Define o campo como um "checkBox" para sele��o de valores sim ou n�o.
	 */
	private void definirTipoCampoCheckBox() {
		// VARI�VEIS

		Campo objCampo;

		// FIM VARI�VEIS
		try {
			// A��ES

			objCampo = new Campo();
			objCampo.setEnmTipo(EnmTipo.CHECKBOX);

			this.setObjCampo(objCampo);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	/**
	 * Define o campo como um "comboBox" para sele��o de valor entre os
	 * pr�-definidos.
	 */
	private void definirTipoCampoComboBox() {
		// VARI�VEIS

		CampoComboBox objCampoComboBox;

		// FIM VARI�VEIS
		try {
			// A��ES

			objCampoComboBox = new CampoComboBox();
			this.getCln().carregarComboBox(objCampoComboBox);
			this.setObjCampo(objCampoComboBox);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	/**
	 * Retorna o tamanho horizontal do campo.
	 */
	private double getDblCampoWidth() {
		// VARI�VEIS

		double dblResultado = 100;
		int intPesoSoma;
		int intPeso;

		// FIM VARI�VEIS
		try {
			// A��ES

			intPeso = this.getCln().getIntFrmLinhaPeso();
			intPesoSoma = this.getIntPesoSoma();
			dblResultado = 100 / (double) intPesoSoma * (double) intPeso;

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return dblResultado;
	}

	/**
	 * Retorna a soma dos pesos dos campos da linha deste campo.
	 */
	private int getIntPesoSoma() {
		// VARI�VEIS

		int intResultado = 0;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (DbColuna cln : this.getCln().getTbl().getLstClnVisivelCadastro()) {
				if (cln.getIntFrmLinha() == this.getCln().getIntFrmLinha()) {
					intResultado = intResultado + cln.getIntFrmLinhaPeso();
				}
			}

			if (intResultado == 0) {
				intResultado = 1;
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
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getPnlTitulo().setTagPai(this.getPnlContainer());
			this.getPnlCampo().setTagPai(this.getPnlContainer());
			this.getObjCampo().setTagPai(this.getPnlCampo());
			this.getPnlContainer().setTagPai(this.getCln().getTbl().getFrmTbl().getPnlCampos());

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
