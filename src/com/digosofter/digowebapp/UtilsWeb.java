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

    BufferedReader bfr;
    URL url;

    try {

      if (!Utils.ping("http://checkip.amazonaws.com")) {

        return null;
      }

      url = new URL("http://checkip.amazonaws.com");
      bfr = new BufferedReader(new InputStreamReader(url.openStream()));

      return bfr.readLine();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public static String getStrLinkHtml(String strTexto, String strLink) {

    StringBuilder strBuilder;

    try {

      strBuilder = new StringBuilder();
      strBuilder.append("<a href=\"" + strLink + "\">" + strTexto + "</a>");

      return strBuilder.toString();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }
}