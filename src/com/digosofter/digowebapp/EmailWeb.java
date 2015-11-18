package com.digosofter.digowebapp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;

import com.digosofter.digojava.Objeto;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public class EmailWeb extends Objeto {

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

  private void addBcc(Email eml) {

    String strEmail;
    String strNome;

    try {

      if (eml == null) {

        return;
      }

      for (int i = 0; i < this.getLstStrBccEmail().size(); i++) {

        strEmail = this.getLstStrBccEmail().get(i);
        strNome = this.getLstStrBccNome().get(i);

        eml.addBcc(strEmail, strNome);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona um email que receberá este email com cópia oculta.
   */
  public void addBcc(String strEmail, String strNome) {

    try {

      if (Utils.getBooStrVazia(strEmail)) {

        return;
      }

      if (Utils.getBooStrVazia(strNome)) {

        strNome = strEmail;
      }

      this.getLstStrBccEmail().add(strEmail);
      this.getLstStrBccNome().add(strNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void addCc(Email eml) {

    String strEmail;
    String strNome;

    try {

      if (eml == null) {

        return;
      }

      for (int i = 0; i < this.getLstStrCcEmail().size(); i++) {

        strEmail = this.getLstStrCcEmail().get(i);
        strNome = this.getLstStrCcNome().get(i);

        eml.addCc(strEmail, strNome);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona um email que receberá este email com cópia.
   */
  public void addCc(String strEmail, String strNome) {

    try {

      if (Utils.getBooStrVazia(strEmail)) {

        return;
      }

      if (Utils.getBooStrVazia(strNome)) {

        strNome = strEmail;
      }

      this.getLstStrCcEmail().add(strEmail);
      this.getLstStrCcNome().add(strNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void addTo(Email eml) {

    String strEmail;
    String strNome;

    try {

      if (eml == null) {

        return;
      }

      for (int i = 0; i < this.getLstStrToEmail().size(); i++) {

        strEmail = this.getLstStrToEmail().get(i);
        strNome = this.getLstStrToNome().get(i);

        eml.addTo(strEmail, strNome);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona um email que receberá este email.
   */
  public void addTo(String strEmail, String strNome) {

    try {

      if (Utils.getBooStrVazia(strEmail)) {

        return;
      }

      if (Utils.getBooStrVazia(strNome)) {

        strNome = strEmail;
      }

      this.getLstStrToEmail().add(strEmail);
      this.getLstStrToNome().add(strNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void enviar() {

    HtmlEmail eml;

    try {

      eml = new HtmlEmail();

      eml.setAuthenticator(this.getObjDefaultAuthenticator());
      eml.setFrom(this.getStrFromEmail(), this.getStrFromNome());
      eml.setHostName(this.getStrSmtp());
      eml.setMsg(this.getStrMensagem());
      eml.setSmtpPort(this.getIntSmtpPort());
      eml.setSSLOnConnect(this.getBooSsl());
      eml.setSubject(this.getStrAssunto());

      if (!Utils.getBooStrVazia(this.getStrReplyToEmail())) {

        eml.addReplyTo(this.getStrReplyToEmail(), this.getStrReplyToNome());
      }

      this.addBcc(eml);
      this.addCc(eml);
      this.addTo(eml);

      eml.send();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private boolean getBooSsl() {

    return _booSsl;
  }

  private int getIntSmtpPort() {

    return _intSmtpPort;
  }

  private List<String> getLstStrBccEmail() {

    try {

      if (_lstStrBccEmail != null) {

        return _lstStrBccEmail;
      }

      _lstStrBccEmail = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrBccEmail;
  }

  private List<String> getLstStrBccNome() {

    try {

      if (_lstStrBccNome != null) {

        return _lstStrBccNome;
      }

      _lstStrBccNome = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrBccNome;
  }

  private List<String> getLstStrCcEmail() {

    try {

      if (_lstStrCcEmail != null) {

        return _lstStrCcEmail;
      }

      _lstStrCcEmail = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrCcEmail;
  }

  private List<String> getLstStrCcNome() {

    try {

      if (_lstStrCcNome != null) {

        return _lstStrCcNome;
      }

      _lstStrCcNome = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrCcNome;
  }

  private List<String> getLstStrToEmail() {

    try {

      if (_lstStrToEmail != null) {

        return _lstStrToEmail;
      }

      _lstStrToEmail = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrToEmail;
  }

  private List<String> getLstStrToNome() {

    try {

      if (_lstStrToNome != null) {

        return _lstStrToNome;
      }

      _lstStrToNome = new ArrayList<String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
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

  protected void setBooSsl(boolean booSsl) {

    _booSsl = booSsl;
  }

  protected void setIntSmtpPort(int intSmtpPort) {

    _intSmtpPort = intSmtpPort;
  }

  protected void setObjDefaultAuthenticator(DefaultAuthenticator objDefaultAuthenticator) {

    _objDefaultAuthenticator = objDefaultAuthenticator;
  }

  public void setStrAssunto(String strAssunto) {

    _strAssunto = strAssunto;
  }

  protected void setStrFromEmail(String strEmailFrom) {

    _strFromEmail = strEmailFrom;
  }

  protected void setStrFromNome(String strFromNome) {

    _strFromNome = strFromNome;
  }

  public void setStrMensagem(String strMensagem) {

    _strMensagem = strMensagem;
  }

  public void setStrReplyToEmail(String strReplyToEmail) {

    _strReplyToEmail = strReplyToEmail;
  }

  public void setStrReplyToNome(String strReplyToNome) {

    _strReplyToNome = strReplyToNome;
  }

  protected void setStrSmtp(String strSmtp) {

    _strSmtp = strSmtp;
  }
}