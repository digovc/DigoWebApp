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

	// M�TODOS

	public static boolean getBooStrVazia(String str) {
		// VARI�VEIS

		boolean booStrVaziaResultado = true;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (!str.equals(Utils.STRING_VAZIA))
				booStrVaziaResultado = false;
			if (str != null)
				booStrVaziaResultado = false;

			// FIM A��ES
		} catch (Exception ex) {

			return booStrVaziaResultado;

		} finally {
		}
		return booStrVaziaResultado;
	}
	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
