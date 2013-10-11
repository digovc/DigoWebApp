package com.digosofter.digowebapp;

import java.util.List;

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

			if (str == null)
				booStrVaziaResultado = true;
			else if (str.equals(Utils.STRING_VAZIA))
				booStrVaziaResultado = true;
			else
				booStrVaziaResultado = false;

			// FIM AÇÕES
		} catch (Exception ex) {

			return booStrVaziaResultado;

		} finally {
		}
		return booStrVaziaResultado;
	}

	public static String getStrConcatenarLst(List<String> lstStr,
			String strDelimitador) {
		// VARIÁVEIS

		StringBuilder objStringBuilder = new StringBuilder();

		String strConcatenadaResultado = Utils.STRING_VAZIA;
		String strDelimitador2 = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (String str : lstStr) {
				objStringBuilder.append(strDelimitador2).append(str);
				strDelimitador2 = strDelimitador;
			}
			strConcatenadaResultado = objStringBuilder.toString();
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return strConcatenadaResultado;
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
