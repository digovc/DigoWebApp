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
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setCln(cln);
      this.addCss(CssTag.getCssMainInst().setWidth(this.getDblCampoWidth(), "%"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Define o tipo de campo a ser colocado no formulário de acordo com o tipo de
   * dado que é esperado para o mesmo.
   */
  private void definirTipoCampo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

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

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Define o campo como um "checkBox" para seleção de valores sim ou não.
   */
  private void definirTipoCampoCheckBox() {
    // VARIÁVEIS

    Campo objCampo;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objCampo = new Campo();
      objCampo.setEnmTipo(Campo.EnmTipo.CHECKBOX);

      this.setObjCampo(objCampo);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Define o campo como um "comboBox" para seleção de valor entre os
   * pré-definidos.
   */
  private void definirTipoCampoComboBox() {
    // VARIÁVEIS

    ComboBox objCampoComboBox;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objCampoComboBox = new ComboBox();
      this.getCln().carregarComboBox(objCampoComboBox);
      this.setObjCampo(objCampoComboBox);

      // FIM AÇÕES
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
    // VARIÁVEIS

    double dblResultado = 100;
    int intPesoSoma;
    int intPeso;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      intPeso = this.getCln().getIntFrmLinhaPeso();
      intPesoSoma = this.getIntPesoSoma();
      dblResultado = 100 / (double) intPesoSoma * intPeso;

      // FIM AÇÕES
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
    // VARIÁVEIS

    int intResultado = 0;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (DbColuna cln : this.getCln().getTbl().getLstClnVisivelCadastro()) {
        if (cln.getIntFrmLinha() == this.getCln().getIntFrmLinha()) {
          intResultado = intResultado + cln.getIntFrmLinhaPeso();
        }
      }

      if (intResultado == 0) {
        intResultado = 1;
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;
  }

  private Campo getObjCampo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_objCampo == null) {

        this.definirTipoCampo();

        _objCampo.setStrNome(this.getCln().getStrNomeSimplificado());
        _objCampo.addCss(CssTag.getCssMainInst().setPadding(5, "px"));
        _objCampo.addCss(CssTag.getCssMainInst().setWidth(100, "%"));

        if (this.getCln().getIntTamanhoCampo() > 0) {

          _objCampo.addAtr("maxlength", this.getCln().getIntTamanhoCampo());
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objCampo;
  }

  private Painel getPnlCampo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlCampo == null) {

        _pnlCampo = new Painel();
        _pnlCampo.addCss(CssTag.getCssMainInst().setPaddingLeft(10));
        _pnlCampo.addCss(CssTag.getCssMainInst().setPaddingRight(10));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlCampo;
  }

  @Override
  protected Painel getPnlTitulo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlTitulo == null) {

        _pnlTitulo = super.getPnlTitulo();
        _pnlTitulo.setStrConteudo(this.getCln().getStrNomeExibicao());
        _pnlTitulo.addCss(CssTag.getCssMainInst().setPaddingLeft(10));
        _pnlTitulo.addCss(CssTag.getCssMainInst().setPaddingRight(10));
        _pnlTitulo.addCss(CssTag.getCssMainInst().setTextAlign("left"));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlTitulo;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getPnlTitulo().setTagPai(this);
      this.getPnlCampo().setTagPai(this);
      this.getObjCampo().setTagPai(this.getPnlCampo());

      // FIM AÇÕES
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

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.addCss(tagCss.setFloat("left"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setObjCampo(Campo objCampo) {
    _objCampo = objCampo;
  }

}
