package com.digosofter.digowebapp;

import com.digosofter.digowebapp.erro.Erro;

public abstract class Utils {
	// CONSTANTES

	public final static String STRING_VAZIA = "";

	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// MÉTODOS

	public static boolean getBooStrVazia(String str) {
		// VARIÁVEIS

		boolean booStrVaziaResultado = true;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (!str.equals(Utils.STRING_VAZIA))
				booStrVaziaResultado = false;
			if (str != null)
				booStrVaziaResultado = false;

			// FIM AÇÕES
		} catch (Exception ex) {

			return booStrVaziaResultado;

		} finally {
		}
		return booStrVaziaResultado;
	}
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
