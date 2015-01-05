package com.digosofter.digowebapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public abstract class UtilsWeb {

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

}
