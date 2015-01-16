package com.digosofter.digowebapp.html.componente.item;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.database.DbColuna;
import com.digosofter.digojava.database.DbColuna.EnmTipo;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.database.DbColunaWeb;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.ComboBox;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.componente.ComponenteMain;

public class CampoFrmTbl extends ComponenteMain {

  private DbColunaWeb _cln;
  private Campo _objCampo;
  private Painel _pnlCampo;
  private Painel _pnlTitulo;

  public CampoFrmTbl(DbColunaWeb cln) {

    try {

      this.setCln(cln);
      this.addCss(CssTag.getIMain().setWidth(this.getDblCampoWidth(), "%"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void carregarValorRegistro() {

    try {

      this.getObjCampo().setStrValor(this.getCln().getStrValor());
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
      if (this.getCln().getClnRef() != null || this.getCln().getLstStrOpcao().size() > 0) {

        this.definirTipoCampoComboBox();
        return;
      }

      // CheckBox
      if (this.getCln().getEnmTipo() == EnmTipo.BOOLEAN) {

        this.definirTipoCampoCheckBox();
        return;
      }

      // Comum
      this.setObjCampo(new Campo());

      if (this.getCln().getIntTamanhoCampo() >= 120) {

        this.getObjCampo().setEnmTipo(Campo.EnmTipo.TEXT_AREA);
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

    Campo objCampo;

    try {

      objCampo = new Campo();

      objCampo.setEnmTipo(Campo.EnmTipo.CHECKBOX);

      this.setObjCampo(objCampo);
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

    ComboBox objCampoComboBox;

    try {

      objCampoComboBox = new ComboBox();

      this.getCln().carregarComboBox(objCampoComboBox);
      this.setObjCampo(objCampoComboBox);
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

  private Campo getObjCampo() {

    try {

      if (_objCampo != null) {

        return _objCampo;
      }

      this.definirTipoCampo();

      _objCampo.setStrNome(this.getCln().getStrNomeSimplificado());
      _objCampo.addCss(CssTag.getIMain().setPadding(5, "px"));
      _objCampo.addCss(CssTag.getIMain().setWidth(100, "%"));

      if (this.getCln().getIntTamanhoCampo() > 0) {

        _objCampo.addAtr("maxlength", this.getCln().getIntTamanhoCampo());
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

    return _objCampo;
  }

  private Painel getPnlCampo() {

    try {

      if (_pnlCampo != null) {

        return _pnlCampo;
      }

      _pnlCampo = new Painel();

      _pnlCampo.addCss(CssTag.getIMain().setPaddingLeft(10));
      _pnlCampo.addCss(CssTag.getIMain().setPaddingRight(10));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlCampo;
  }

  @Override
  protected Painel getPnlTitulo() {

    try {

      if (_pnlTitulo != null) {

        return _pnlTitulo;
      }

      _pnlTitulo = super.getPnlTitulo();

      _pnlTitulo.setStrConteudo(this.getCln().getStrNomeExibicao());
      _pnlTitulo.addCss(CssTag.getIMain().setPaddingLeft(10));
      _pnlTitulo.addCss(CssTag.getIMain().setPaddingRight(10));
      _pnlTitulo.addCss(CssTag.getIMain().setTextAlign("left"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlTitulo;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.getPnlTitulo().setTagPai(this);
      this.getPnlCampo().setTagPai(this);
      this.getObjCampo().setTagPai(this.getPnlCampo());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setCln(DbColunaWeb cln) {

    _cln = cln;
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      this.addCss(tagCss.setFloat("left"));
      this.addCss(tagCss.setPaddingBottom(5));
      this.addCss(tagCss.setPaddingTop(5));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setObjCampo(Campo objCampo) {

    _objCampo = objCampo;
  }
}