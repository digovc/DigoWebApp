package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;

public class ComboBox extends Campo {

  private boolean _booOpcaoVazia = false;

  private List<String> _lstStrNome;

  private List<String> _lstStrValor;

  public ComboBox() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setStrTagNome("select");

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona uma opção à lista do "comboBox".
   */
  public void addNomeValor(String strNome, String strValor) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getLstStrValor().add(strValor);
      this.getLstStrNome().add(strNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private boolean getBooOpcaoVazia() {
    return _booOpcaoVazia;
  }

  private List<String> getLstStrNome() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrNome == null) {
        _lstStrNome = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrNome;
  }

  private List<String> getLstStrValor() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstStrValor == null) {
        _lstStrValor = new ArrayList<String>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrValor;
  }

  @Override
  public String getStrTagFormatada() {
    // VARIÁVEIS

    String strTagNome;
    Tag tag;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (this.getLstStrValor().size() == 0 || this.getBooOpcaoVazia()) {

        this.getLstStrValor().add(0, "-1");
        this.getLstStrNome().add(0, "");
      }

      for (int i = 0; i < this.getLstStrValor().size(); i++) {

        if (!Utils.getBooStrVazia(this.getStrValor())
            && this.getStrValor().equals(this.getLstStrValor().get(i))) {
          strTagNome = "option selected";
        } else {
          strTagNome = "option";
        }

        tag = new Tag(strTagNome);
        tag.addAtr("value", this.getLstStrValor().get(i));
        tag.setStrConteudo(this.getLstStrNome().get(i));
        tag.setTagPai(this);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return super.getStrTagFormatada();
  }

  public void setBooOpcaoVazia(boolean booOpcaoVazia) {
    _booOpcaoVazia = booOpcaoVazia;
  }

  public void setLstStrNome(List<String> lstStrNome) {
    _lstStrNome = lstStrNome;
  }

  public void setLstStrValor(List<String> lstStrValor) {
    _lstStrValor = lstStrValor;
  }
}
