package com.digosofter.digowebapp.html.componente.item;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.database.DbColuna;
import com.digosofter.digojava.database.DbColuna.EnmTipo;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.database.DbColunaWeb;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.ComboBox;
import com.digosofter.digowebapp.html.CssTag;

public class CampoFrmTbl extends LabelCampo {

  private DbColunaWeb _cln;
  private Campo _tagCampo;

  public CampoFrmTbl(DbColunaWeb cln) {

    try {

      this.setCln(cln);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void carregarValorRegistro() {

    try {

      this.getTagCampo().setStrValor(this.getCln().getStrValor());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Define o tipo de campo a ser colocado no formulário de acordo com o tipo de
   * dado que é esperado para o mesmo.
   */
  private void definirTipoCampo() {

    try {

      // ComboBox
      if ((this.getCln().getClnRef() != null) || (!this.getCln().getMapOpcao().isEmpty())) {

        this.definirTipoCampoComboBox();
        return;
      }

      // CheckBox
      if (this.getCln().getEnmTipo() == EnmTipo.BOOLEAN) {

        this.definirTipoCampoCheckBox();
        return;
      }

      // Comum
      this.setTagCampo(new Campo());

      if (this.getCln().getIntTamanhoCampo() >= 120) {

        this.getTagCampo().setEnmTipo(Campo.EnmTipo.TEXT_AREA);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Define o campo como um "checkBox" para seleção de valores sim ou não.
   */
  private void definirTipoCampoCheckBox() {

    Campo tagCampo;

    try {

      tagCampo = new Campo();

      tagCampo.setEnmTipo(Campo.EnmTipo.CHECKBOX);

      this.setTagCampo(tagCampo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Define o campo como um "comboBox" para seleção de valor entre os
   * pré-definidos.
   */
  private void definirTipoCampoComboBox() {

    ComboBox tagCmb;

    try {

      tagCmb = new ComboBox();

      this.getCln().carregarComboBox(tagCmb);
      this.setTagCampo(tagCmb);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private DbColunaWeb getCln() {

    return _cln;
  }

  /**
   * Retorna o tamanho horizontal do campo.
   */
  private double getDblCampoWidth() {

    double dblResultado = 100;
    int intPesoSoma;
    int intPeso;

    try {

      intPeso = this.getCln().getIntFrmLinhaPeso();
      intPesoSoma = this.getIntPesoSoma();
      dblResultado = 100 / (double) intPesoSoma * intPeso;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return dblResultado;
  }

  /**
   * Retorna a soma dos pesos dos campos da linha deste campo.
   */
  private int getIntPesoSoma() {

    int intResultado = 0;

    try {

      for (DbColuna cln : this.getCln().getTbl().getLstClnCadastro()) {

        if (cln.getIntFrmLinha() == this.getCln().getIntFrmLinha()) {

          intResultado = intResultado + cln.getIntFrmLinhaPeso();
        }
      }

      if (intResultado == 0) {

        intResultado = 1;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  @Override
  public Campo getTagCampo() {

    try {

      if (_tagCampo != null) {

        return _tagCampo;
      }

      this.definirTipoCampo();

      _tagCampo.setStrNome(this.getCln().getStrNomeSql());

      if (this.getCln().getIntTamanhoCampo() > 0) {

        _tagCampo.addAtr("maxlength", this.getCln().getIntTamanhoCampo());
      }

      if (!Utils.getBooStrVazia(this.getCln().getStrValor())) {

        this.carregarValorRegistro();
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagCampo;
  }

  private void setCln(DbColunaWeb cln) {

    try {

      _cln = cln;

      this.setStrLabel(this.getCln().getStrNomeExibicao());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      // this.addCss(tagCss.setWidth(this.getDblCampoWidth(), "%"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setTagCampo(Campo tagCampo) {

    _tagCampo = tagCampo;
  }
}