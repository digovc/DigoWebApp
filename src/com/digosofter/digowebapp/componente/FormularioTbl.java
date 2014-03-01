package com.digosofter.digowebapp.componente;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.componente.item.CampoFrmTbl;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Botao;
import com.digosofter.digowebapp.html.Formulario;
import com.digosofter.digowebapp.html.LimiteFloat;
import com.digosofter.digowebapp.html.Painel;

public class FormularioTbl extends ComponenteMain {

  private Botao _btnSalvar;

  private Formulario _frm;

  private LimiteFloat _objLimiteFloat;

  private Painel _pnlCampos;

  private DbTabela _tbl;

  /**
   * Formulário para cadastro de um registro da tabela passada como parâmetro.
   */
  public FormularioTbl(DbTabela tbl) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setTbl(tbl);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private Botao getBtnSalvar() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_btnSalvar == null) {

        _btnSalvar = new Botao();
        _btnSalvar.setStrConteudo("Salvar");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _btnSalvar;
  }

  private Formulario getFrm() {
    // VARIÁVEIS

    String strAction;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_frm == null) {

        strAction = AppWeb.getI().getStrPagSolicitada();
        strAction += "?";
        strAction += this.getTbl().getStrNomeSimplificado();
        // strAction += "=salvar";

        _frm = new Formulario(strAction, Formulario.EnmMetodo.POST);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _frm;
  }

  /**
   * Retorna a quantidade de linhas contidas no formulário.
   */
  private int getIntQtdLinha() {
    // VARIÁVEIS

    int intResultado = 1;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (DbColuna cln : this.getTbl().getLstClnVisivelCadastro()) {
        if (intResultado < cln.getIntFrmLinha()) {
          intResultado = cln.getIntFrmLinha();
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;
  }

  private LimiteFloat getObjLimiteFloat() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_objLimiteFloat == null) {
        _objLimiteFloat = new LimiteFloat();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objLimiteFloat;
  }

  public Painel getPnlCampos() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlCampos == null) {

        _pnlCampos = new Painel();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlCampos;
  }

  private DbTabela getTbl() {
    return _tbl;
  }

  @Override
  public void montarLayout() {
    // VARIÁVEIS

    String strParam;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strParam = AppWeb.getI().getParametro(this.getTbl().getStrNomeSimplificado());

      if (strParam == null) {

        this.montarLayoutCadastro();

      } else {

        this.salvarRegistro();
        this.montarLayoutSalvo();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void montarLayoutCadastro() {
    // VARIÁVEIS

    int intQtdLinha;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getPnlTitulo().setTagPai(this.getPnlContainer());
      this.getFrm().setTagPai(this.getPnlContainer());
      this.getPnlCampos().setTagPai(this.getFrm());
      this.getPnlComando().setTagPai(this.getFrm());
      this.getBtnSalvar().setTagPai(this.getPnlComando());

      intQtdLinha = this.getIntQtdLinha();

      for (int intIndex = 1; intIndex <= intQtdLinha; intIndex++) {

        for (DbColuna cln : this.getTbl().getLstClnVisivelCadastro()) {

          if (cln.getIntFrmLinha() == intIndex) {

            cln.setObjCampoFrmTbl(new CampoFrmTbl(cln));
            cln.getObjCampoFrmTbl().montarLayout();
          }
        }
      }

      this.getObjLimiteFloat().setTagPai(this.getPnlContainer());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutSalvo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getPnlContainer().setStrConteudo("Salvo com sucesso!");

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Persiste os dados vindos do cliente no banco de dados.
   */
  private void salvarRegistro() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getTbl().salvarRegistroPost();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setTbl(DbTabela tbl) {
    _tbl = tbl;
  }

}
