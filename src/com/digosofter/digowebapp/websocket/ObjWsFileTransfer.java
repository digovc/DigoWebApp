package com.digosofter.digowebapp.websocket;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.websocket.Session;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.objeto.ObjMain;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class ObjWsFileTransfer extends ObjMain {

  private int _intTamanhoEscrito;

  public int getIntTamanhoEscrito() {
    return _intTamanhoEscrito;
  }

  private void setIntTamanhoEscrito(int intTamanhoEscrito) {
    _intTamanhoEscrito = intTamanhoEscrito;
  }

  public enum EnmTipo {
    BASE64_BINARY, BINARY,
  }

  private BufferedOutputStream _bos;

  private EnmTipo _enmTipo = EnmTipo.BASE64_BINARY;

  private int _intTamanho;

  private JsonElement _jse;

  private Session _objSession;

  private String _strJsonStor;

  private String _strNome;

  public ObjWsFileTransfer(Session objSession) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setObjSession(objSession);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona "bytes" ao arquivo. Retorna a quantidade de "bytes" escritos no "Buffer".
   */
  public int addBytes(String strMensagem) {
    // VARIÁVEIS

    byte[] arrBte;
    int intResultado = 0;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (this.getEnmTipo() == EnmTipo.BASE64_BINARY) {

        arrBte = Base64.decode(strMensagem);

      }else{

        arrBte = strMensagem.getBytes();
      }

      this.getBos().write(arrBte);
      intResultado = arrBte.length;
      this.setIntTamanhoEscrito(this.getIntTamanhoEscrito() + intResultado);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;
  }

  private BufferedOutputStream getBos() {
    // VARIÁVEIS

    File objFile;
    FileOutputStream fos;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_bos == null) {

        objFile = new File("c:/ws_temp/server/" + this.getStrNome());
        fos = new FileOutputStream(objFile);
        _bos = new BufferedOutputStream(fos);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _bos;
  }

  private EnmTipo getEnmTipo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _enmTipo = this.getJse().getAsJsonObject().get("type").getAsString().equals("binary") ? EnmTipo.BINARY
          : EnmTipo.BASE64_BINARY;

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _enmTipo;
  }

  private int getIntTamanho() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_intTamanho == 0) {

        _intTamanho = this.getJse().getAsJsonObject().get("size").getAsInt();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _intTamanho;
  }

  private JsonElement getJse() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_jse == null) {

        _jse = new JsonParser().parse(this.getStrJsonStor().replace("STOR: ", ""));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _jse;
  }

  public Session getObjSession() {
    return _objSession;
  }

  private String getStrJsonStor() {
    return _strJsonStor;
  }

  public String getStrNome() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Utils.getBooStrVazia(_strNome)) {

        _strNome = this.getJse().getAsJsonObject().get("filename").getAsString();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strNome;
  }

  public void salvar() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getBos().flush();
      this.getBos().close();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setObjSession(Session objSession) {
    _objSession = objSession;
  }

  public void setStrJsonStor(String strJsonStor) {
    _strJsonStor = strJsonStor;
  }

}
