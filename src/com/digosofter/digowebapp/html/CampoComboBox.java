package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digowebapp.erro.Erro;

public class CampoComboBox extends Campo {

  private List<String> _lstStrNome;

  private List<String> _lstStrValor;

  private String _strValorSelecionado;

  public CampoComboBox() {
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

  public List<String> getLstStrNome() {
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

  public List<String> getLstStrValor() {
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

      if (this.getLstStrValor().size() == 0) {

        this.getLstStrValor().add("-1");
        this.getLstStrNome().add("");
      }

      for (int intIndex = 0; intIndex < this.getLstStrValor().size(); intIndex++) {

        strTagNome = this.getStrValorSelecionado() == this.getLstStrValor().get(intIndex) ? "option selected"
            : "option";

        tag = new Tag();
        tag.setStrTagNome(strTagNome);
        tag.addAtr("value", this.getLstStrValor().get(intIndex));
        tag.setStrConteudo(this.getLstStrNome().get(intIndex));
        tag.setTagPai(this);
      }

      // FIM AÇÕES
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
