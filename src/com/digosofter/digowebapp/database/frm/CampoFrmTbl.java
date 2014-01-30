package com.digosofter.digowebapp.database.frm;

import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;

public class CampoFrmTbl extends Campo {
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

	private Painel _pnlCampo;

	public Painel getPnlCampo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlCampo == null) {
				_pnlCampo = new Painel();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlCampo;
	}

	private Painel _pnlContainer;

	public Painel getPnlContainer() {
		// VARI�VEIS

		int intPeso;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlContainer == null) {

				intPeso = 100 / this.getCln().getTbl().getIntQtdCampoPorLinha(this.getCln().getIntFrmLinha());

				_pnlContainer = new Painel();
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia().setFloat("left"));
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia().setWidth(intPeso, "%"));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlContainer;
	}

	private Painel _pnlTitulo;

	public Painel getPnlTitulo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlTitulo == null) {

				_pnlTitulo = new Painel();
				_pnlTitulo.setStrConteudo(this.getCln().getStrNomeExibicao());
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

	/**
	 *
	 */
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

	@Override
	public String getStrTagFormatada() {
		// VARI�VEIS

		String strResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			this.getPnlTitulo().setTagPai(this.getPnlContainer());
			this.getPnlCampo().setTagPai(this.getPnlContainer());

			// TODO: Parei aqui
			// Pelo fato de adicionar a inst�ncia deste objeto na lista de tag's filhas,
			// fica num loop infinito ao montar a tag pai, pois sempre volta neste m�todo.
			// Fazer com que tudo isso (formularioTbl e CampoFrmTbl) herde de componentes e
			// n�o das tags diretas.

			this.setTagPai(this.getPnlCampo());

			strResultado = this.getPnlContainer().getStrTagFormatada();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return strResultado;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
