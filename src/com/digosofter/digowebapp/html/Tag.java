package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class Tag extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private String _strAbertura = "<";

	public String getStrAbertura() {
		return _strAbertura;
	}

	public void setStrAbertura(String strAbertura) {
		_strAbertura = strAbertura;
	}

	private String _strConteudo;

	public String getStrConteudo() {
		return _strConteudo;
	}

	public void setStrConteudo(String strConteudo) {
		_strConteudo = strConteudo;
	}

	private String _strFechamento = ">";

	public String getStrFechamento() {
		return _strFechamento;
	}

	public void setStrFechamento(String strFechamento) {
		_strFechamento = strFechamento;
	}

	private String _strNome = "div";

	public String getStrNome() {
		return _strNome.toLowerCase();
	}

	public void setStrNome(String strNome) {
		_strNome = strNome;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// MÉTODOS

	public String getStrTagFormatada() {
		// VARIÁVEIS

		String strTagFormatadaResultado = Utils.STRING_VAZIA;
		StringBuilder objStringBuilder = new StringBuilder();

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (!Utils.getBooStrVazia(this.getStrConteudo())) {
				objStringBuilder.append(this.getStrAbertura());
				objStringBuilder.append(this.getStrNome());
				objStringBuilder.append(this.getStrFechamento());
				objStringBuilder.append(this.getStrConteudo());
				objStringBuilder.append(this.getStrAbertura());
				objStringBuilder.append("/");
				objStringBuilder.append(this.getStrNome());
				objStringBuilder.append(this.getStrFechamento());
			} else {
				objStringBuilder.append(this.getStrAbertura());
				objStringBuilder.append(this.getStrNome());
				objStringBuilder.append("/");
				objStringBuilder.append(this.getStrFechamento());
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strTagFormatadaResultado;
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
