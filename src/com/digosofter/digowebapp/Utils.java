package com.digosofter.digowebapp;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.digosofter.digowebapp.erro.Erro;

public abstract class Utils {
	// CONSTANTES

	public enum EnmDataFormato {
		DD_MM, DD_MM_YYYY, DD_MM_YYYY_HH_MM, DD_MM_YYYY_HH_MM_SS, HH_MM_DD_MM_YYYY, HH_MM_SS_DD_MM_YYYY, YYYY_MM_DD_HH_MM_SS
	}

	public static final Locale LOCAL_BRASIL = new Locale("pt", "BR");

	public static final String STRING_VAZIA = "";

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

			if (str == null)
				booStrVaziaResultado = true;
			else if (str.equals(Utils.STRING_VAZIA))
				booStrVaziaResultado = true;
			else
				booStrVaziaResultado = false;

			// FIM A��ES
		} catch (Exception ex) {

			return booStrVaziaResultado;

		} finally {
		}
		return booStrVaziaResultado;
	}

	public static int getIntNumeroAleatorio(int intMaximo) {
		// VARI�VEIS

		int intResultado = 0;
		Random objRandom = new Random(); 

		// FIM VARI�VEIS
		try {
			// A��ES
			
			intResultado = objRandom.nextInt(intMaximo);
			
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro ao gerar cor aleat�ria.\n" , ex);

		} finally {
		}
		
		return intResultado;
	}
	
	public static String getStrConcatenarLst(List<String> lstStr, String strDelimitador, boolean booEliminarDuplicata) {
		// VARI�VEIS
		
		boolean booStrIncluida = false;
		
		List<String> lstStrIncluida = new ArrayList<String>();
		
		StringBuilder strBuilder = new StringBuilder();
		
		String strConcatenadaResultado = Utils.STRING_VAZIA;
		String strDelimitador2 = Utils.STRING_VAZIA;
		
		// FIM VARI�VEIS
		try {
			// A��ES
			
			for (String str : lstStr) {
				if (booEliminarDuplicata) {
					for (String strInserida : lstStrIncluida) {
						if (strInserida == str) {
							booStrIncluida = true;
						}
					}
				}
				
				if (!booStrIncluida) {
					if (strDelimitador2 != null && strDelimitador2 != "") {
						strBuilder.append(strDelimitador2);
					}
					strBuilder.append(str);
					lstStrIncluida.add(str);
					strDelimitador2 = strDelimitador;
				}
			}
			strConcatenadaResultado = strBuilder.toString();
			// FIM A��ES
		} catch (Exception ex) {
			
			new Erro("Erro inesperado.\n", ex);
			
		} finally {
		}
		return strConcatenadaResultado;
	}
	
	public static String getStrConcatenarLst(String[] arrStr, String strDelimitador, boolean booEliminarDuplicata) {
		// VARI�VEIS
		
		List<String> lstStr = null;
		
		// FIM VARI�VEIS
		try {
			// A��ES

			lstStr = new ArrayList<String>();
			
			for (String str : arrStr) {
				lstStr.add(str);	
			}
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		
		return Utils.getStrConcatenarLst(lstStr, strDelimitador, booEliminarDuplicata);
	}

	public static String getStrDataFormatada(Date objDate, EnmDataFormato enmDataFormato) {
		// VARI�VEIS
		String strDataFormato = Utils.STRING_VAZIA;
		SimpleDateFormat objSimpleDateFormat = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			switch (enmDataFormato) {
			case DD_MM:
				strDataFormato = "dd/MM";
				break;
			case DD_MM_YYYY:
				strDataFormato = "dd/MM/yyyy";
				break;
			case DD_MM_YYYY_HH_MM:
				strDataFormato = "dd/MM/yyyy HH:mm";
				break;
			case DD_MM_YYYY_HH_MM_SS:
				strDataFormato = "dd/MM/yyyy HH:mm:ss";
				break;
			case HH_MM_DD_MM_YYYY:
				strDataFormato = "HH:mm dd/MM/yyyy";
				break;
			case HH_MM_SS_DD_MM_YYYY:
				strDataFormato = "HH:mm:ss dd/MM/yyyy";
				break;
			case YYYY_MM_DD_HH_MM_SS:
				strDataFormato = "yyyy/MM/dd HH:mm:ss";
				break;
			default:
				strDataFormato = "dd/MM/yyyy";
				break;
			}
			
			objSimpleDateFormat = new SimpleDateFormat(strDataFormato, LOCAL_BRASIL);

			// FIM A��ES
		} catch (Exception e) {
		} finally {
			// LIMPAR VARI�VEIS
			// FIM LIMPAR VARI�VEIS
		}
		
		return objSimpleDateFormat.format(objDate);
	}
	
	public static String getStrLinkHtml(String strTexto, String strLink) {
		// VARI�VEIS

		String strLinkHtmlResultado = Utils.STRING_VAZIA;

		StringBuilder strBuilder = new StringBuilder();

		// FIM VARI�VEIS
		try {
			// A��ES

			strBuilder.append("<a href=\"" + strLink + "\">" + strTexto + "</a>");
			strLinkHtmlResultado = strBuilder.toString();

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strLinkHtmlResultado;
	}

	public static String getStrRemoverUltimaLetra(String str) {
		// VARI�VEIS

		String strResultado = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			strResultado = str.substring(0, str.length() - 1);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return strResultado;
	}

	public static String getStrSimplificada(String strComplexa) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			strComplexa = strComplexa.toLowerCase(Utils.LOCAL_BRASIL);
			String[] arrChrAcentos = new String[] { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
					"�", "�", "�", "�", "�", "�", "�" };
			String[] arrChrSemAcento = new String[] { "c", "a", "e", "i", "o", "u", "y", "a", "e", "i", "o", "u", "a", "o", "n", "a", "e", "i", "o",
					"u", "y", "a", "e", "i", "o", "u" };
			for (int intTemp = 0; intTemp < arrChrAcentos.length; intTemp++) {
				strComplexa = strComplexa.replace(arrChrAcentos[intTemp], arrChrSemAcento[intTemp]);
			}
			String[] arrChrCaracteresEspeciais = { "\\.", ",", "-", ":", "\\(", "\\)", "�", "\\|", "\\\\", "�", "^\\s+", "\\s+$", "\\s+", ".", "(",
					")" };
			for (int intTemp = 0; intTemp < arrChrCaracteresEspeciais.length; intTemp++) {
				strComplexa = strComplexa.replace(arrChrCaracteresEspeciais[intTemp], "");
			}
			strComplexa = strComplexa.replace(" ", "");

			// FIM A��ES
		} catch (Exception e) {
		} finally {
		}
		return strComplexa;
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
