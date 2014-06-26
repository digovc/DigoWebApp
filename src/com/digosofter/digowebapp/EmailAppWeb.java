package com.digosofter.digowebapp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.HtmlEmail;
import com.digosofter.digowebapp.erro.Erro;

public class EmailAppWeb extends Objeto {

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

  private void addBcc(Email objEmail) {
    // VARIÁVEIS

    String strEmail;
    String strNome;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (int i = 0; i < this.getLstStrBccEmail().size(); i++) {

        strEmail = this.getLstStrBccEmail().get(i);
        strNome = this.getLstStrBccNome().get(i);

        objEmail.addBcc(strEmail, strNome);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void addCc(Email objEmail) {
    // VARIÁVEIS

    String strEmail;
    String strNome;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (int i = 0; i < this.getLstStrCcEmail().size(); i++) {

        strEmail = this.getLstStrCcEmail().get(i);
        strNome = this.getLstStrCcNome().get(i);

        objEmail.addCc(strEmail, strNome);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void addTo(Email objEmail) {
    // VARIÁVEIS

    String strEmail;
    String strNome;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (int i = 0; i < this.getLstStrToEmail().size(); i++) {

        strEmail = this.getLstStrToEmail().get(i);
        strNome = this.getLstStrToNome().get(i);

        objEmail.addTo(strEmail, strNome);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona um email que receberá este email com cópia oculta.
   */
  public void addBcc(String strEmail, String strNome) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getLstStrBccEmail().add(strEmail);
      this.getLstStrBccNome().add(strNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona um email que receberá este email com cópia.
   */
  public void addCc(String strEmail, String strNome) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getLstStrCcEmail().add(strEmail);
      this.getLstStrCcNome().add(strNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona um email que receberá este email.
   */
  public void addTo(String strEmail, String strNome) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getLstStrToEmail().add(strEmail);
      this.getLstStrToNome().add(strNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void enviar() {
    // VARIÁVEIS

    HtmlEmail objHtmlEmail;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objHtmlEmail = new HtmlEmail();
      objHtmlEmail.addReplyTo(this.getStrReplyToEmail(), this.getStrReplyToNome());
      objHtmlEmail.setAuthenticator(this.getObjDefaultAuthenticator());
      objHtmlEmail.setFrom(this.getStrFromEmail(), this.getStrFromNome());
      objHtmlEmail.setHostName(this.getStrSmtp());
      objHtmlEmail.setMsg(this.getStrMensagem());
      objHtmlEmail.setSSLOnConnect(this.getBooSsl());
      objHtmlEmail.setSmtpPort(this.getIntSmtpPort());
      objHtmlEmail.setSubject(this.getStrAssunto());

      this.addBcc(objHtmlEmail);
      this.addCc(objHtmlEmail);
      this.addTo(objHtmlEmail);

      objHtmlEmail.send();

      // FIM AÇÕES
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrBccEmail == null) {

        _lstStrBccEmail = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrBccEmail;
  }

  private List<String> getLstStrBccNome() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrBccNome == null) {

        _lstStrBccNome = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrBccNome;
  }

  private List<String> getLstStrCcEmail() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrCcEmail == null) {

        _lstStrCcEmail = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrCcEmail;
  }

  private List<String> getLstStrCcNome() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrCcNome == null) {

        _lstStrCcNome = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrCcNome;
  }

  private List<String> getLstStrToEmail() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrToEmail == null) {

        _lstStrToEmail = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrToEmail;
  }

  private List<String> getLstStrToNome() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrToNome == null) {

        _lstStrToNome = new ArrayList<String>();
      }

      // FIM AÇÕES
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
