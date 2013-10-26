package com.digosofter.digowebapp.database;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class DbFiltro extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private boolean _booAndOr = true;

	private boolean getBooAndOr() {
		return _booAndOr;
	}

	public void setBooAndOr(boolean booAndOr) {
		_booAndOr = booAndOr;
	}

	private boolean _booSelect = false;

	private boolean getBooSelect() {
		return _booSelect;
	}

	public void setBooSelect(boolean booSelect) {
		_booSelect = booSelect;
	}

	private String _strOperador = "=";

	private String getStrOperador() {
		return _strOperador;
	}

	public void setStrOperador(String strOperador) {
		_strOperador = strOperador;
	}

	private String _strValor;

	private String getStrValor() {
		return _strValor;
	}

	public void setStrValor(String strValor) {
		_strValor = strValor;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public DbFiltro(String strNome, String strValor) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrNome(strNome);
			this.setStrValor(strValor);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public DbFiltro(DbColuna cln, String strValor) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrNome(cln.getStrNomeSimplificado());
			this.setStrValor(strValor);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS

	@Override
	public String toString() {
		// VARIÁVEIS

		String strDbFiltroResultado = Utils.STRING_VAZIA;
		StringBuilder strBuilder = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (this.getBooSelect()) {
				strDbFiltroResultado = this.getStrValor();
			} else {
				if (this.getBooAndOr()) {
					strBuilder.append("and ");
				} else {
					strBuilder.append("or ");
				}
				strBuilder.append(this.getStrNomeSimplificado());
				strBuilder.append(this.getStrOperador());
				strBuilder.append("'");
				strBuilder.append(this.getStrValor());
				strBuilder.append("' ");
			}

			strDbFiltroResultado = strBuilder.toString();

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strDbFiltroResultado;
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
