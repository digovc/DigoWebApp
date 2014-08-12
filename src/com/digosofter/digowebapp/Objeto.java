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

    try {

      Objeto.setIntIndex(Objeto.getIntIndex() + 1);
      this.setIntId(Objeto.getIntIndex());

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public int getIntId() {

    return _intId;
  }

  public String getStrNome() {

    return _strNome;
  }

  public String getStrNomeExibicao() {

    try {

      if (Utils.getBooStrVazia(_strNomeExibicao)) {

        if (!Utils.getBooStrVazia(this.getStrNome())) {

          _strNomeExibicao = Utils.getStrPrimeiraMaiuscula(this.getStrNome());
        }
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
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

    try {

      _strNomeExibicao = strNomeExibicao;
      _strNomeExibicao = Utils.getStrPrimeiraMaiuscula(_strNomeExibicao);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

}
