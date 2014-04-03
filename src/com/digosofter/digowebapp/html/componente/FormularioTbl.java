package com.digosofter.digowebapp.html.componente;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Botao;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Formulario;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.LimiteFloat;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.componente.item.CampoFrmTbl;

public class FormularioTbl extends ComponenteMain {

  private boolean _booSubmit = false;

  private Botao _btnCancelar;

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
      this.setStrId("div_frm_" + this.getTbl().getStrNomeSimplificado());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_FORMULARIO_TBL));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private boolean getBooSubmit() {
    return _booSubmit;
  }

  private Botao getBtnCancelar() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_btnCancelar == null) {

        _btnCancelar = new Botao();
        _btnCancelar.setStrId("btnCancelar");
        _btnCancelar.setStrConteudo("Cancelar");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _btnCancelar;
  }

  private Botao getBtnSalvar() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_btnSalvar == null) {

        _btnSalvar = new Botao();
        _btnSalvar.setStrConteudo("Salvar");
        _btnSalvar.setStrId("btnSalvar");
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
        _frm.setStrId("frm_" + this.getTbl().getStrNomeSimplificado());

        if (!this.getBooSubmit()) {
          _frm.addAtr("onsubmit", "return false;");
        }
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
  protected void montarLayout() {

    super.montarLayout();

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

  private void montarLayoutCadastro() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getPnlTitulo().setTagPai(this);
      this.getFrm().setTagPai(this);
      this.getPnlCampos().setTagPai(this.getFrm());
      this.getPnlComando().setTagPai(this.getFrm());
      this.getBtnCancelar().setTagPai(this.getPnlComando());
      this.getBtnSalvar().setTagPai(this.getPnlComando());

      this.montarLayoutCampos();

      this.getObjLimiteFloat().setTagPai(this.getPnlComando());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutCampos() {
    // VARIÁVEIS

    CampoFrmTbl objCampoFrmTbl;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (int intIndex = 1; intIndex <= this.getIntQtdLinha(); intIndex++) {

        for (DbColuna cln : this.getTbl().getLstClnVisivelCadastro()) {

          if (cln.getIntFrmLinha() == intIndex) {

            objCampoFrmTbl = new CampoFrmTbl(cln);
            objCampoFrmTbl.setTagPai(this.getPnlCampos());
          }
        }
      }

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

      this.setStrConteudo("Salvo com sucesso!");

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

  public void setBooSubmit(boolean booSubmit) {
    _booSubmit = booSubmit;
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.addCss(tagCss.setPadding(10, "px"));

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
