package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.erro.Erro;

public class ComboBox extends Campo {

  private List<String> _lstStrNome;

  private List<String> _lstStrValor;

  private String _strValorSelecionado;

  public ComboBox() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrTagNome("select");

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Adiciona uma op��o � lista do "comboBox".
   */
  public void addNomeValor(String strNome, String strValor) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getLstStrValor().add(strValor);
      this.getLstStrNome().add(strNome);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private List<String> getLstStrNome() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrNome == null) {
        _lstStrNome = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrNome;
  }

  private List<String> getLstStrValor() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_lstStrValor == null) {
        _lstStrValor = new ArrayList<String>();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstStrValor;
  }

  @Override
  public String getStrTagFormatada() {
    // VARI�VEIS

    String strTagNome;
    Tag tag;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (this.getLstStrValor().size() == 0) {

        this.getLstStrValor().add("-1");
        this.getLstStrNome().add("");
      }

      for (int i = 0; i < this.getLstStrValor().size(); i++) {

        strTagNome = this.getStrValorSelecionado() == this.getLstStrValor().get(i) ? "option selected"
            : "option";

        tag = new Tag();
        tag.setStrTagNome(strTagNome);
        tag.addAtr("value", this.getLstStrValor().get(i));
        tag.setStrConteudo(this.getLstStrNome().get(i));
        tag.setTagPai(this);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return super.getStrTagFormatada();
  }

  private String getStrValorSelecionado() {
    return _strValorSelecionado;
  }

  public void setLstStrNome(List<String> lstStrNome) {
    _lstStrNome = lstStrNome;
  }

  public void setLstStrValor(List<String> lstStrValor) {
    _lstStrValor = lstStrValor;
  }

  public void setStrValorSelecionado(String strValorSelecionado) {
    _strValorSelecionado = strValorSelecionado;
  }

}