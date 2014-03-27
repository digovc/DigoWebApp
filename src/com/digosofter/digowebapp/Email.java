package com.digosofter.digowebapp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import com.digosofter.digowebapp.erro.Erro;

public class Email extends Objeto {

  private boolean _booSsl = true;

  private int _intSmtpPort = 465;

  private List<String> _lstStrBccEmail;

  private List<String> _lstStrBccNome;

  private List<String> _lstStrCcEmail;

  private List<String> _lstStrCcNome;

  private List<String> _lstStrToEmail;

  private List<String> _lstStrToNome;

  private DefaultAuthenticator _objDefaultAuthenticator;

  private String _strAssunto;

  private String _strFromEmail;

  private String _strFromNome;

  private String _strMensagem;

  private String _strReplyToEmail;

  private String _strReplyToNome;

  private String _strSmtp = "smtp.gmail.com";

  private void addBcc(SimpleEmail objSimpleEmail) {
    // VARI�VEIS

    String strEmail;
    String strNome;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (int i = 0; i < this.getLstStrBccEmail().size(); i++) {

        strEmail = this.getLstStrBccEmail().get(i);
        strNome = this.getLstStrBccNome().get(i);

        objSimpleEmail.addBcc(strEmail, strNome);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void addCc(SimpleEmail objSimpleEmail) {
    // VARI�VEIS

    String strEmail;
    String strNome;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (int i = 0; i < this.getLstStrCcEmail().size(); i++) {

        strEmail = this.getLstStrCcEmail().get(i);
        strNome = this.getLstStrCcNome().get(i);

        objSimpleEmail.addCc(strEmail, strNome);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void addTo(SimpleEmail objSimpleEmail) {
    // VARI�VEIS

    String strEmail;
    String strNome;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (int i = 0; i < this.getLstStrToEmail().size(); i++) {

        strEmail = this.getLstStrToEmail().get(i);
        strNome = this.getLstStrToNome().get(i);

        objSimpleEmail.addTo(strEmail, strNome);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void enviar() {
    // VARI�VEIS

    SimpleEmail objSimpleEmail;

    // FIM VARI�VEIS
    try {
      // A��ES

      objSimpleEmail = new SimpleEmail();
      objSimpleEmail.addReplyTo(this.getStrReplyToEmail(), this.getStrReplyToNome());
      objSimpleEmail.setAuthenticator(this.getObjDefaultAuthenticator());
      objSimpleEmail.setFrom(this.getStrFromEmail(), this.getStrFromNome());
      objSimpleEmail.setHostName(this.getStrSmtp());
      objSimpleEmail.setMsg(this.getStrMensagem());
      objSimpleEmail.setSSLOnConnect(this.getBooSsl());
      objSimpleEmail.setSmtpPort(this.getIntSmtpPort());
      objSimpleEmail.setSubject(this.getStrAssunto());

      this.addBcc(objSimpleEmail);
      this.addCc(objSimpleEmail);
      this.addTo(objSimpleEmail);

      objSimpleEmail.send();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private boolean getBooSsl() {
    return _booSsl;
  }

  private int getIntSmtpPort() {
    return _intSmtpPort;
  }

  private List<String> getLstStrBccEmail() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrBccEmail == null) {

        _lstStrBccEmail = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrBccEmail;
  }

  private List<String> getLstStrBccNome() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrBccNome == null) {

        _lstStrBccNome = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrBccNome;
  }

  private List<String> getLstStrCcEmail() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrCcEmail == null) {

        _lstStrCcEmail = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrCcEmail;
  }

  private List<String> getLstStrCcNome() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrCcNome == null) {

        _lstStrCcNome = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrCcNome;
  }

  private List<String> getLstStrToEmail() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrToEmail == null) {

        _lstStrToEmail = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrToEmail;
  }

  private List<String> getLstStrToNome() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrToNome == null) {

        _lstStrToNome = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrToNome;
  }

  private DefaultAuthenticator getObjDefaultAuthenticator() {
    return _objDefaultAuthenticator;
  }

  private String getStrAssunto() {
    return _strAssunto;
  }

  private String getStrFromEmail() {
    return _strFromEmail;
  }

  private String getStrFromNome() {
    return _strFromNome;
  }

  private String getStrMensagem() {
    return _strMensagem;
  }

  private String getStrReplyToEmail() {
    return _strReplyToEmail;
  }

  private String getStrReplyToNome() {
    return _strReplyToNome;
  }

  private String getStrSmtp() {
    return _strSmtp;
  }

  private void setBooSsl(boolean booSsl) {
    _booSsl = booSsl;
  }

  private void setIntSmtpPort(int intSmtpPort) {
    _intSmtpPort = intSmtpPort;
  }

  private void setLstStrBccEmail(List<String> lstStrBccEmail) {
    _lstStrBccEmail = lstStrBccEmail;
  }

  private void setLstStrBccNome(List<String> lstStrBccNome) {
    _lstStrBccNome = lstStrBccNome;
  }

  private void setLstStrCcEmail(List<String> lstStrCcEmail) {
    _lstStrCcEmail = lstStrCcEmail;
  }

  private void setLstStrCcNome(List<String> lstStrCcNome) {
    _lstStrCcNome = lstStrCcNome;
  }

  private void setLstStrToEmail(List<String> lstStrToEmail) {
    _lstStrToEmail = lstStrToEmail;
  }

  private void setLstStrToNome(List<String> lstStrToNome) {
    _lstStrToNome = lstStrToNome;
  }

  private void setObjDefaultAuthenticator(DefaultAuthenticator objDefaultAuthenticator) {
    _objDefaultAuthenticator = objDefaultAuthenticator;
  }

  private void setStrAssunto(String strAssunto) {
    _strAssunto = strAssunto;
  }

  private void setStrFromEmail(String strEmailFrom) {
    _strFromEmail = strEmailFrom;
  }

  private void setStrFromNome(String strFromNome) {
    _strFromNome = strFromNome;
  }

  private void setStrMensagem(String strMensagem) {
    _strMensagem = strMensagem;
  }

  private void setStrReplyToEmail(String strReplyToEmail) {
    _strReplyToEmail = strReplyToEmail;
  }

  private void setStrReplyToNome(String strReplyToNome) {
    _strReplyToNome = strReplyToNome;
  }

  private void setStrSmtp(String strSmtp) {
    _strSmtp = strSmtp;
  }

}
