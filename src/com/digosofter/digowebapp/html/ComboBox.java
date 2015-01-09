package com.digosofter.digowebapp.html;

import java.util.ArrayList;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;

public class ComboBox extends Campo {

  private boolean _booOpcaoVazia;
  private List<String> _lstStrNome;
  private List<String> _lstStrValor;

  public ComboBox() {

    try {

      this.setStrTagNome("select");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona uma opção à lista do "comboBox".
   */
  public void addNomeValor(String strValor, String strNome) {

    try {

      this.getLstStrValor().add(strValor);
      this.getLstStrNome().add(strNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private boolean getBooOpcaoVazia() {

    return _booOpcaoVazia;
  }

  private List<String> getLstStrNome() {

    try {

      if (_lstStrNome == null) {

        _lstStrNome = new ArrayList<String>();
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrNome;
  }

  private List<String> getLstStrValor() {

    try {

      if (_lstStrValor == null) {

        _lstStrValor = new ArrayList<String>();
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstStrValor;
  }

  private Tag getNewTagOption(int intOrdem) {

    Tag tagResultado = null;

    try {

      if (!Utils.getBooStrVazia(this.getStrValor()) && this.getStrValor().equals(this.getLstStrValor().get(intOrdem))) {

        tagResultado = new Tag("option selected");
      }
      else {

        tagResultado = new Tag("option");
      }

      tagResultado.addAtr("value", this.getLstStrValor().get(intOrdem));
      tagResultado.setStrConteudo(this.getLstStrNome().get(intOrdem));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return tagResultado;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      if (this.getLstStrValor().size() == 0 || this.getBooOpcaoVazia()) {

        this.getLstStrValor().add(0, "-1");
        this.getLstStrNome().add(0, "");
      }

      this.montarLayoutItens();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutItens() {

    Tag tagOption;

    try {

      for (int i = 0; i < this.getLstStrValor().size(); i++) {

        tagOption = this.getNewTagOption(i);
        tagOption.setTagPai(this);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
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