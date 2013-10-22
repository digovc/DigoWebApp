package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.erro.Erro;

public class Botao extends Tag {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Botao() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTagNome("button");
			this.setStrConteudo("Botão");
			this.getLstAtr().add(new Atributo("type", "button"));

			// CSS
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingTop(5)); 
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingBottom(5));
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingLeft(15));
			this.adicionaCss(CssTag.getCssMainInstancia().setPaddingRight(15));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
