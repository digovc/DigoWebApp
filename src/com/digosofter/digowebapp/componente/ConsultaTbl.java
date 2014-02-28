package com.digosofter.digowebapp.componente;

import java.sql.ResultSet;

import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Botao;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.LimiteFloat;
import com.digosofter.digowebapp.html.Painel;

public class ConsultaTbl extends ComponenteMain {

	// FIM CONSTANTES

	// ATRIBUTOS

	private Botao _btnNovo;

	private Painel _pnlContainer;

	private Painel _pnlLista;

	private LimiteFloat _tagLimiteFloat;

	private DbTabela _tbl;

	public ConsultaTbl(DbTabela tbl) {
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

	private Botao getBtnNovo() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_btnNovo == null) {

				_btnNovo = new Botao();
				_btnNovo.setStrConteudo("Novo");
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _btnNovo;
	}

	@Override
	public Painel getPnlContainer() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlContainer == null) {

				_pnlContainer = super.getPnlContainer();
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia()
						.setPadding(5, "px"));
				_pnlContainer.adicionarCss(CssTag.getCssMainInstancia()
						.setBorder(1, "solid", "black"));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlContainer;
	}

	private Painel getPnlLista() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_pnlLista == null) {
				_pnlLista = new Painel();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _pnlLista;
	}

	private LimiteFloat getTagLimiteFloat() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_tagLimiteFloat == null) {
				_tagLimiteFloat = new LimiteFloat();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _tagLimiteFloat;
	}

	private DbTabela getTbl() {
		return _tbl;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	@Override
	public void montarLayout() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getPnlTitulo().setTagPai(this.getPnlContainer());
			this.getPnlLista().setTagPai(this.getPnlContainer());
			this.montarLayoutLista();
			this.getPnlComando().setTagPai(this.getPnlContainer());
			this.getBtnNovo().setTagPai(this.getPnlComando());
			this.getTagLimiteFloat().setTagPai(this.getPnlComando());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	/**
	 * Monta o layout de uma linha baseado no registro posicionado no objeto
	 * "objResultSet".
	 */
	private void montarLayoutLinha(ResultSet objResultSet) {
		// VARI�VEIS

		// String strNome;
		// String strValor;
		//
		// LinhaConsultaTbl objLinhaConsultaTbl;

		// FIM VARI�VEIS
		try {
			// A��ES

			// objLinhaConsultaTbl = new LinhaConsultaTbl();
			// objLinhaConsultaTbl.setStrNome(objResultSet.getString(this.getTbl().getClnNome().getStrNomeSimplificado()));
			//
			// for (DbColuna cln : this.getTbl().getLstClnVisivelConsulta()) {
			//
			// if (!cln.getBooClnNome()) {
			//
			// strNome = cln.getStrNomeExibicao();
			// objLinhaConsultaTbl.getLstStrNome().add(strNome);
			// strValor = objResultSet.getString(cln.getStrNomeSimplificado());
			// objLinhaConsultaTbl.getLstStrValor().add(strValor);
			// }
			// }
			//
			// objLinhaConsultaTbl.getPnlContainer().setTagPai(this.getPnlLista());
			// objLinhaConsultaTbl.montarLayout();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	/**
	 * Monta o layout da lista com os valores da "tbl".
	 */
	private void montarLayoutLista() {
		// VARI�VEIS

		ResultSet objResultSet;

		// FIM VARI�VEIS
		try {
			// A��ES

			objResultSet = this.getTbl().getObjResultSetConsulta();

			if (objResultSet != null && objResultSet.first()) {

				do {

					this.montarLayoutLinha(objResultSet);

				} while (objResultSet.next());
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private void setTbl(DbTabela tbl) {
		_tbl = tbl;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
