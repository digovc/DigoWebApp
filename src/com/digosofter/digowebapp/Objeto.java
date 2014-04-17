package com.digosofter.digowebapp;

import com.digosofter.digowebapp.erro.Erro;

public abstract class Objeto {

  private static int _intIndex;

  private static int getIntIndex() {
    return _intIndex;
  }

  private static void setIntIndex(int intIndex) {
    _intIndex = intIndex;
  }

  private int _intId;

  private String _strNome;

  private String _strNomeExibicao;

  public Objeto() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      Objeto.setIntIndex(Objeto.getIntIndex() + 1);
      this.setIntId(Objeto.getIntIndex());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public int getIntId() {
    return _intId;
  }

  public String getStrNome() {
    return _strNome;
  }

  public String getStrNomeExibicao() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (Utils.getBooStrVazia(_strNomeExibicao)) {

        if (!Utils.getBooStrVazia(this.getStrNome())) {

          _strNomeExibicao = Utils.getStrPrimeiraMaiuscula(this.getStrNome());
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strNomeExibicao;
  }

  public String getStrNomeSimplificado() {
    return Utils.getStrSimplificada(this.getStrNome());
  }

  public void setIntId(int intId) {
    _intId = intId;
  }

  public void setStrNome(String strNome) {
    _strNome = strNome;
  }

  public void setStrNomeExibicao(String strNomeExibicao) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      _strNomeExibicao = strNomeExibicao;
      _strNomeExibicao = Utils.getStrPrimeiraMaiuscula(_strNomeExibicao);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
