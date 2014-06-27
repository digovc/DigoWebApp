package com.digosofter.digowebapp.arquivo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.digosofter.digowebapp.erro.Erro;

public class ArqXml extends Arquivo {

  private File _objFile;

  private File getObjFile() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_objFile == null) {
        _objFile = new File(this.getDirCompleto());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objFile;
  }

  /**
   * Retorna o valor de um elemento do "XML".
   */
  public String getStrElemento(String strElemento) {
    // VARIÁVEIS

    String strResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      // TODO: Parei aqui.
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(this.getObjFile());
      doc.getDocumentElement().normalize();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }
}
