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

    boolean booStrVaziaResultado = true;

    try {

      if (str == null) {
        booStrVaziaResultado = true;
      }
      else if (str.equals(Utils.STR_VAZIA)) {
        booStrVaziaResultado = true;
      }
      else {
        booStrVaziaResultado = false;
      }

    }
    catch (Exception ex) {

      return booStrVaziaResultado;

    }
    finally {
    }
    return booStrVaziaResultado;
  }

  public static Date getDttAgora() {

    Date dttResultado = null;

    try {

      dttResultado = new Date();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return dttResultado;
  }

  public static int getIntNumeroAleatorio(int intMaximo) {

    int intResultado = 0;
    Random objRandom = new Random();

    try {

      intResultado = objRandom.nextInt(intMaximo);

    }
    catch (Exception ex) {

      new Erro("Erro ao gerar cor aleatória.\n", ex);

    }
    finally {
    }

    return intResultado;
  }

  public static String getStrConcatenarLst(List<String> lstStr, String strDelimitador,
      boolean booEliminarDuplicata) {

    boolean booStrIncluida = false;
    List<String> lstStrIncluida;
    StringBuilder stb;
    String strResultado = Utils.STR_VAZIA;
    String strDelimitador2 = Utils.STR_VAZIA;

    try {

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

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strResultado;
  }

  public static String getStrConcatenarLst(String[] arrStr, String strDelimitador,
      boolean booEliminarDuplicata) {

    List<String> lstStr = null;

    try {

      lstStr = new ArrayList<String>();

      for (String str : arrStr) {
        lstStr.add(str);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return Utils.getStrConcatenarLst(lstStr, strDelimitador, booEliminarDuplicata);
  }

  public static String getStrDataFormatada(Date objDate, EnmDataFormato enmDataFormato) {

    String strDataFormato = Utils.STR_VAZIA;
    SimpleDateFormat objSimpleDateFormat = null;

    try {

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

    }
    catch (Exception e) {
    }
    finally {
      // LIMPAR VARIÁVEIS
      // FIM LIMPAR VARIÁVEIS
    }

    return objSimpleDateFormat.format(objDate);
  }

  /**
   * Retorna o número "IP" externo da máquina.
   */
  public static String getStrIpExterno() {

    String strResultado = Utils.STR_VAZIA;
    URL url;
    BufferedReader bfr;

    try {

      url = new URL("http://checkip.amazonaws.com");
      bfr = new BufferedReader(new InputStreamReader(url.openStream()));
      strResultado = bfr.readLine();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strResultado;
  }

  public static String getStrLinkHtml(String strTexto, String strLink) {

    String strLinkHtmlResultado = Utils.STR_VAZIA;

    StringBuilder strBuilder = new StringBuilder();

    try {

      strBuilder.append("<a href=\"" + strLink + "\">" + strTexto + "</a>");
      strLinkHtmlResultado = strBuilder.toString();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return strLinkHtmlResultado;
  }

  public static String getStrMd5(String str) {

    BigInteger objBigInteger;
    MessageDigest objMessageDigest;
    String strMd5Resultado = null;

    try {

      objMessageDigest = MessageDigest.getInstance("MD5");
      objBigInteger = new BigInteger(1, objMessageDigest.digest(str.getBytes()));
      strMd5Resultado = String.format("%0" + (objMessageDigest.digest(str.getBytes()).length << 1)
          + "X", objBigInteger);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strMd5Resultado;
  }

  public static String getStrPrimeiraMaiuscula(String str) {

    String strResultado = "";

    try {

      if (Utils.getBooStrVazia(str)) {

        return "";
      }

      strResultado = "";
      strResultado += str.substring(0, 1).toUpperCase();
      strResultado += str.substring(1);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strResultado;
  }

  public static String getStrRemoverUltimaLetra(String str) {

    String strResultado = Utils.STR_VAZIA;

    try {

      strResultado = str.substring(0, str.length() - 1);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return strResultado;
  }

  public static String getStrSimplificada(String strComplexa) {

    try {

      strComplexa = strComplexa.toLowerCase(Utils.LOCAL_BRASIL);
      String[] arrChrAcentos = new String[] { "ç", "á", "é", "í", "ó", "ú", "ý", "à", "è", "ì",
          "ò", "ù", "ã", "õ", "ñ", "ä", "ë", "ï", "ö", "ü", "ÿ", "â", "ê", "î", "ô", "û" };
      String[] arrChrSemAcento = new String[] { "c", "a", "e", "i", "o", "u", "y", "a", "e", "i",
          "o", "u", "a", "o", "n", "a", "e", "i", "o", "u", "y", "a", "e", "i", "o", "u" };
      for (int intTemp = 0; intTemp < arrChrAcentos.length; intTemp++) {
        strComplexa = strComplexa.replace(arrChrAcentos[intTemp], arrChrSemAcento[intTemp]);
      }
      String[] arrChrCaracteresEspeciais = { "\\.", ",", "-", ":", "\\(", "\\)", "ª", "\\|",
          "\\\\", "°", "^\\s+", "\\s+$", "\\s+", ".", "(", ")" };
      for (String arrChrCaracteresEspeciai : arrChrCaracteresEspeciais) {
        strComplexa = strComplexa.replace(arrChrCaracteresEspeciai, "");
      }
      strComplexa = strComplexa.replace(" ", "");

    }
    catch (Exception e) {
    }
    finally {
    }
    return strComplexa;
  }

  public static String getStrToken(List<String> lstStrTermo) {

    return Utils.getStrToken(lstStrTermo, 5);
  }

  public static String getStrToken(List<String> lstStrTermo, int intTamanho) {

    String strTermoMd5;
    String strTokenResultado = Utils.STR_VAZIA;

    try {

      for (String strTermo : lstStrTermo) {

        if (Utils.getBooStrVazia(strTermo)) {
          continue;
        }

        strTermoMd5 = Utils.getStrMd5(strTermo);
        strTokenResultado = Utils.getStrMd5(strTokenResultado + strTermoMd5);
      }

      strTokenResultado = strTokenResultado.substring(0, intTamanho);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
    return strTokenResultado;
  }

}
