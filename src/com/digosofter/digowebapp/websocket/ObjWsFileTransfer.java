package com.digosofter.digowebapp.websocket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.websocket.Session;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.objeto.ObjMain;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class ObjWsFileTransfer extends ObjMain {

  public enum EnmTipo {

    BASE64_BINARY,
    BINARY,
  }

  private BufferedOutputStream _bos;
  private EnmTipo _enmTipo = EnmTipo.BASE64_BINARY;
  private int _intTamanho;
  private int _intTamanhoEscrito;
  private JsonElement _jse;
  private Session _objSession;
  private String _strJsonStor;
  private String _strNome;

  public ObjWsFileTransfer(Session objSession) {

    try {

      this.setObjSession(objSession);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona "bytes" ao arquivo. Retorna a quantidade de "bytes" escritos no
   * "Buffer".
   */
  public int addBytes(String strMensagem) {

    byte[] arrBte;
    int intResultado = 0;

    try {

      if (this.getEnmTipo() == EnmTipo.BASE64_BINARY) {

        arrBte = Base64.decode(strMensagem);
      }
      else {

        arrBte = strMensagem.getBytes();
      }

      this.getBos().write(arrBte);

      intResultado = arrBte.length;

      this.setIntTamanhoEscrito(this.getIntTamanhoEscrito() + intResultado);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  private BufferedOutputStream getBos() {

    File objFile;
    FileOutputStream fos;

    try {

      if (_bos == null) {

        objFile = new File("c:/ws_temp/server/" + this.getStrNome());

        fos = new FileOutputStream(objFile);
        _bos = new BufferedOutputStream(fos);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _bos;
  }

  private EnmTipo getEnmTipo() {

    try {

      _enmTipo = this.getJse().getAsJsonObject().get("type").getAsString().equals("binary") ? EnmTipo.BINARY : EnmTipo.BASE64_BINARY;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _enmTipo;
  }

  private int getIntTamanho() {

    try {

      if (_intTamanho == 0) {

        _intTamanho = this.getJse().getAsJsonObject().get("size").getAsInt();
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _intTamanho;
  }

  public int getIntTamanhoEscrito() {

    return _intTamanhoEscrito;
  }

  private JsonElement getJse() {

    try {

      if (_jse == null) {

        _jse = new JsonParser().parse(this.getStrJsonStor().replace("STOR: ", ""));
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _jse;
  }

  public Session getObjSession() {

    return _objSession;
  }

  private String getStrJsonStor() {

    return _strJsonStor;
  }

  @Override
  public String getStrNome() {

    try {

      if (Utils.getBooStrVazia(_strNome)) {

        _strNome = this.getJse().getAsJsonObject().get("filename").getAsString();
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strNome;
  }

  public void salvar() {

    try {

      this.getBos().flush();
      this.getBos().close();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setIntTamanhoEscrito(int intTamanhoEscrito) {

    _intTamanhoEscrito = intTamanhoEscrito;
  }

  private void setObjSession(Session objSession) {

    _objSession = objSession;
  }

  public void setStrJsonStor(String strJsonStor) {

    _strJsonStor = strJsonStor;
  }
}