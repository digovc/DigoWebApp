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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_pnlComando == null) {

				_pnlComando = new Painel();
				_pnlComando.adicionarCss(CssTag.getCssMainInstancia().setPaddingLeft(10));
				_pnlComando.adicionarCss(CssTag.getCssMainInstancia().setPaddingRight(10));
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlComando;
	}

	private Painel _pnlContainer;

	public Painel getPnlContainer() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_pnlContainer == null) {
				_pnlContainer = new Painel();
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlContainer;
	}

	private Painel _pnlTitulo;

	protected Painel getPnlTitulo() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_pnlTitulo == null) {
				_pnlTitulo = new Painel();
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlTitulo;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// MÉTODOS

	/**
	 * Retorna o componente pronto para ser usado no html.
	 */
	public String getStrCompFormatado() {
		// VARIÁVEIS

		String strResultado = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			strResultado = this.getPnlContainer().getStrTagFormatada();

			// FIM AÇÕES
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

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
