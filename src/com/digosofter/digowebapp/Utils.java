package com.digosofter.digowebapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.digosofter.digowebapp.erro.Erro;

public abstract class Utils {

  public enum EnmDataFormato {
    DD_MM,
    DD_MM_YYYY,
    DD_MM_YYYY_HH_MM,
    DD_MM_YYYY_HH_MM_SS,
    HH_MM,
    HH_MM_DD_MM_YYYY,
    HH_MM_SS_DD_MM_YYYY,
    YYYY_MM_DD_HH_MM_SS
  }

  public static final Locale LOCAL_BRASIL = new Locale("pt", "BR");
  public static final String STR_VAZIA = "";

  public static boolean getBooStrVazia(String str) {
    // VARI�VEIS

    boolean booStrVaziaResultado = true;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (str == null) {
        booStrVaziaResultado = true;
      } else if (str.equals(Utils.STR_VAZIA)) {
        booStrVaziaResultado = true;
      } else {
        booStrVaziaResultado = false;
      }

      // FIM A��ES
    } catch (Exception ex) {

      return booStrVaziaResultado;

    } finally {
    }
    return booStrVaziaResultado;
  }

  public static Date getDttAgora() {
    // VARI�VEIS

    Date dttResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      dttResultado = new Date();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
    return dttResultado;
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

      new Erro("Erro ao gerar cor aleat�ria.\n", ex);

    } finally {
    }

    return intResultado;
  }

  public static String getStrConcatenarLst(List<String> lstStr, String strDelimitador,
      boolean booEliminarDuplicata) {
    // VARI�VEIS

    boolean booStrIncluida = false;
    List<String> lstStrIncluida;
    StringBuilder stb;
    String strResultado = Utils.STR_VAZIA;
    String strDelimitador2 = Utils.STR_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      lstStrIncluida = new ArrayList<String>();
      stb = new StringBuilder();

      for (String str : lstStr) {

        if (booEliminarDuplicata) {

          for (String strInserida : lstStrIncluida) {

            if (strInserida == str) {
              booStrIncluida = true;
            }
          }
        }

        if (!booStrIncluida) {

          stb.append(strDelimitador2);
          stb.append(str);

          strDelimitador2 = strDelimitador;

          lstStrIncluida.add(str);
        }
      }

      strResultado = stb.toString();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public static String getStrConcatenarLst(String[] arrStr, String strDelimitador,
      boolean booEliminarDuplicata) {
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
    String strDataFormato = Utils.STR_VAZIA;
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
        case HH_MM:
          strDataFormato = "HH:mm";
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

  /**
   * Retorna o n�mero "IP" externo da m�quina.
   */
  public static String getStrIpExterno() {
    // VARI�VEIS

    String strResultado = Utils.STR_VAZIA;
    URL url;
    BufferedReader bfr;

    // FIM VARI�VEIS
    try {
      // A��ES

      url = new URL("http://checkip.amazonaws.com");
      bfr = new BufferedReader(new InputStreamReader(url.openStream()));
      strResultado = bfr.readLine();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public static String getStrLinkHtml(String strTexto, String strLink) {
    // VARI�VEIS

    String strLinkHtmlResultado = Utils.STR_VAZIA;

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

  public static String getStrMd5(String str) {
    // VARI�VEIS

    BigInteger objBigInteger;
    MessageDigest objMessageDigest;
    String strMd5Resultado = Utils.STR_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      objMessageDigest = MessageDigest.getInstance("MD5");
      objBigInteger = new BigInteger(1, objMessageDigest.digest(str.getBytes()));
      strMd5Resultado = String.format("%0" + (objMessageDigest.digest(str.getBytes()).length << 1)
          + "X", objBigInteger);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strMd5Resultado;
  }

  public static String getStrPrimeiraMaiuscula(String str) {
    // VARI�VEIS

    String strResultado = "";

    // FIM VARI�VEIS
    try {
      // A��ES

      if (Utils.getBooStrVazia(str)) {

        return "";
      }

      strResultado = "";
      strResultado += str.substring(0, 1).toUpperCase();
      strResultado += str.substring(1);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public static String getStrRemoverUltimaLetra(String str) {
    // VARI�VEIS

    String strResultado = Utils.STR_VAZIA;

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
      String[] arrChrAcentos = new String[] { "�", "�", "�", "�", "�", "�", "�", "�", "�", "�",
          "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�", "�" };
      String[] arrChrSemAcento = new String[] { "c", "a", "e", "i", "o", "u", "y", "a", "e", "i",
          "o", "u", "a", "o", "n", "a", "e", "i", "o", "u", "y", "a", "e", "i", "o", "u" };
      for (int intTemp = 0; intTemp < arrChrAcentos.length; intTemp++) {
        strComplexa = strComplexa.replace(arrChrAcentos[intTemp], arrChrSemAcento[intTemp]);
      }
      String[] arrChrCaracteresEspeciais = { "\\.", ",", "-", ":", "\\(", "\\)", "�", "\\|",
          "\\\\", "�", "^\\s+", "\\s+$", "\\s+", ".", "(", ")" };
      for (String arrChrCaracteresEspeciai : arrChrCaracteresEspeciais) {
        strComplexa = strComplexa.replace(arrChrCaracteresEspeciai, "");
      }
      strComplexa = strComplexa.replace(" ", "");

      // FIM A��ES
    } catch (Exception e) {
    } finally {
    }
    return strComplexa;
  }

  public static String getStrToken(List<String> lstStrTermo) {
    return Utils.getStrToken(lstStrTermo, 5);
  }

  public static String getStrToken(List<String> lstStrTermo, int intTamanho) {
    // VARI�VEIS

    String strTermoMd5 = Utils.STR_VAZIA;
    String strTokenResultado = Utils.STR_VAZIA;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (String strTermo : lstStrTermo) {

        if (Utils.getBooStrVazia(strTermo)) {
          continue;
        }

        strTermoMd5 = Utils.getStrMd5(strTermo);
        strTokenResultado = Utils.getStrMd5(strTokenResultado + strTermoMd5);
      }

      strTokenResultado = strTokenResultado.substring(0, intTamanho);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
    return strTokenResultado;
  }

}
