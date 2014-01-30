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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_pnlCampo == null) {
				_pnlCampo = new Painel();
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlCampo;
	}

	private Painel _pnlContainer;

	public Painel getPnlContainer() {
		// VARIÁVEIS

		int intPeso;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_pnlContainer == null) {

				intPeso = 100 / this.getCln().getTbl().getIntQtdCampoPorLinha(this.getCln().getIntFrmLinha());

				_pnlContainer = new Painel();
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia().setFloat("left"));
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia().setWidth(intPeso, "%"));
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlContainer;
	}

	private Painel _pnlTitulo;

	public Painel getPnlTitulo() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (_pnlTitulo == null) {

				_pnlTitulo = new Painel();
				_pnlTitulo.setStrConteudo(this.getCln().getStrNomeExibicao());
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

	/**
	 *
	 */
	public CampoFrmTbl(DbColuna cln) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setCln(cln);

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

		String strResultado = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getPnlTitulo().setTagPai(this.getPnlContainer());
			this.getPnlCampo().setTagPai(this.getPnlContainer());

			// TODO: Parei aqui
			// Pelo fato de adicionar a instância deste objeto na lista de tag's filhas,
			// fica num loop infinito ao montar a tag pai, pois sempre volta neste método.
			// Fazer com que tudo isso (formularioTbl e CampoFrmTbl) herde de componentes e
			// não das tags diretas.

			this.setTagPai(this.getPnlCampo());

			strResultado = this.getPnlContainer().getStrTagFormatada();

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return strResultado;
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
