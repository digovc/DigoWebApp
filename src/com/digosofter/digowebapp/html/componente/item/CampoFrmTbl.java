package com.digosofter.digowebapp.html.componente.item;

import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbColuna.EnmTipo;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.ComboBox;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.componente.ComponenteMain;

public class CampoFrmTbl extends ComponenteMain {

  private DbColuna _cln;

  private Campo _objCampo;

  private Painel _pnlCampo;

  private Painel _pnlTitulo;

  public CampoFrmTbl(DbColuna cln) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setCln(cln);
      this.addCss(CssTag.getCssMainInst().setWidth(this.getDblCampoWidth(), "%"));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Define o tipo de campo a ser colocado no formul�rio de acordo com o tipo de
   * dado que � esperado para o mesmo.
   */
  private void definirTipoCampo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      // ComboBox
      if (this.getCln().getClnReferencia() != null || this.getCln().getLstStrOpcao().size() > 0) {
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

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Define o campo como um "checkBox" para sele��o de valores sim ou n�o.
   */
  private void definirTipoCampoCheckBox() {
    // VARI�VEIS

    Campo objCampo;

    // FIM VARI�VEIS
    try {
      // A��ES

      objCampo = new Campo();
      objCampo.setEnmTipo(Campo.EnmTipo.CHECKBOX);

      this.setObjCampo(objCampo);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Define o campo como um "comboBox" para sele��o de valor entre os
   * pr�-definidos.
   */
  private void definirTipoCampoComboBox() {
    // VARI�VEIS

    ComboBox objCampoComboBox;

    // FIM VARI�VEIS
    try {
      // A��ES

      objCampoComboBox = new ComboBox();
      this.getCln().carregarComboBox(objCampoComboBox);
      this.setObjCampo(objCampoComboBox);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private DbColuna getCln() {
    return _cln;
  }

  /**
   * Retorna o tamanho horizontal do campo.
   */
  private double getDblCampoWidth() {
    // VARI�VEIS

    double dblResultado = 100;
    int intPesoSoma;
    int intPeso;

    // FIM VARI�VEIS
    try {
      // A��ES

      intPeso = this.getCln().getIntFrmLinhaPeso();
      intPesoSoma = this.getIntPesoSoma();
      dblResultado = 100 / (double) intPesoSoma * intPeso;

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return dblResultado;
  }

  /**
   * Retorna a soma dos pesos dos campos da linha deste campo.
   */
  private int getIntPesoSoma() {
    // VARI�VEIS

    int intResultado = 0;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (DbColuna cln : this.getCln().getTbl().getLstClnVisivelCadastro()) {
        if (cln.getIntFrmLinha() == this.getCln().getIntFrmLinha()) {
          intResultado = intResultado + cln.getIntFrmLinhaPeso();
        }
      }

      if (intResultado == 0) {
        intResultado = 1;
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;
  }

  private Campo getObjCampo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_objCampo == null) {

        this.definirTipoCampo();

        _objCampo.setStrNome(this.getCln().getStrNomeSimplificado());
        _objCampo.addCss(CssTag.getCssMainInst().setPadding(5, "px"));
        _objCampo.addCss(CssTag.getCssMainInst().setWidth(100, "%"));

        if (this.getCln().getIntTamanhoCampo() > 0) {

          _objCampo.addAtr("maxlength", this.getCln().getIntTamanhoCampo());
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objCampo;
  }

  private Painel getPnlCampo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlCampo == null) {

        _pnlCampo = new Painel();
        _pnlCampo.addCss(CssTag.getCssMainInst().setPaddingLeft(10));
        _pnlCampo.addCss(CssTag.getCssMainInst().setPaddingRight(10));
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlCampo;
  }

  @Override
  protected Painel getPnlTitulo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlTitulo == null) {

        _pnlTitulo = super.getPnlTitulo();
        _pnlTitulo.setStrConteudo(this.getCln().getStrNomeExibicao());
        _pnlTitulo.addCss(CssTag.getCssMainInst().setPaddingLeft(10));
        _pnlTitulo.addCss(CssTag.getCssMainInst().setPaddingRight(10));
        _pnlTitulo.addCss(CssTag.getCssMainInst().setTextAlign("left"));
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlTitulo;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getPnlTitulo().setTagPai(this);
      this.getPnlCampo().setTagPai(this);
      this.getObjCampo().setTagPai(this.getPnlCampo());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setCln(DbColuna cln) {
    _cln = cln;
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.addCss(tagCss.setFloat("left"));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setObjCampo(Campo objCampo) {
    _objCampo = objCampo;
  }

}
