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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      Objeto.setIntIndex(Objeto.getIntIndex() + 1);
      this.setIntId(Objeto.getIntIndex());

      // FIM AÇÕES
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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Utils.getBooStrVazia(_strNomeExibicao)) {

        if (!Utils.getBooStrVazia(this.getStrNome())) {

          _strNomeExibicao = Character.toString(this.getStrNome().charAt(0)).toUpperCase()
              + this.getStrNome().substring(1);
        }
      }

      // FIM AÇÕES
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
    _strNomeExibicao = strNomeExibicao;
  }

}
