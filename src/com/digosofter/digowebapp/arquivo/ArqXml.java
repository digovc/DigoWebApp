package com.digosofter.digowebapp.arquivo;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import com.digosofter.digowebapp.erro.Erro;

public class ArqXml extends Arquivo {

  private File _objFile;

  private File getObjFile() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_objFile == null) {
        _objFile = new File(this.getDirCompleto());
      }

      // FIM A��ES
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
    // VARI�VEIS

    String strResultado = null;

    // FIM VARI�VEIS
    try {
      // A��ES

      // TODO: Parei aqui.
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(this.getObjFile());
      doc.getDocumentElement().normalize();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }
}
