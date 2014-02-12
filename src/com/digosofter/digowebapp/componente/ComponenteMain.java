package com.digosofter.digowebapp.componente;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;

public abstract class ComponenteMain extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private Painel _pnlComando;

	public Painel getPnlComando() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlComando == null) {

				_pnlComando = new Painel();
				_pnlComando.adicionarCss(CssTag.getCssMainInstancia().setPaddingLeft(10));
				_pnlComando.adicionarCss(CssTag.getCssMainInstancia().setPaddingRight(10));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlComando;
	}

	private Painel _pnlContainer;

	public Painel getPnlContainer() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlContainer == null) {
				_pnlContainer = new Painel();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlContainer;
	}

	private Painel _pnlTitulo;

	protected Painel getPnlTitulo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlTitulo == null) {
				_pnlTitulo = new Painel();
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
	// FIM CONSTRUTORES

	// M�TODOS

	/**
	 * Retorna o componente pronto para ser usado no html.
	 */
	public String getStrCompFormatado() {
		// VARI�VEIS

		String strResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			strResultado = this.getPnlContainer().getStrTagFormatada();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return strResultado;
	}

	/**
	 * Prepara o layout final do componente.
	 */
	public abstract void montarLayout();

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
