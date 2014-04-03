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
   * Formul�rio para cadastro de um registro da tabela passada como par�metro.
   */
  public FormularioTbl(DbTabela tbl) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setTbl(tbl);
      this.setStrId("div_frm_" + this.getTbl().getStrNomeSimplificado());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_FORMULARIO_TBL));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private boolean getBooSubmit() {
    return _booSubmit;
  }

  private Botao getBtnCancelar() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_btnCancelar == null) {

        _btnCancelar = new Botao();
        _btnCancelar.setStrId("btnCancelar");
        _btnCancelar.setStrConteudo("Cancelar");
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _btnCancelar;
  }

  private Botao getBtnSalvar() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_btnSalvar == null) {

        _btnSalvar = new Botao();
        _btnSalvar.setStrConteudo("Salvar");
        _btnSalvar.setStrId("btnSalvar");
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _btnSalvar;
  }

  private Formulario getFrm() {
    // VARI�VEIS

    String strAction;

    // FIM VARI�VEIS
    try {
      // A��ES

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

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _frm;
  }

  /**
   * Retorna a quantidade de linhas contidas no formul�rio.
   */
  private int getIntQtdLinha() {
    // VARI�VEIS

    int intResultado = 1;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (DbColuna cln : this.getTbl().getLstClnVisivelCadastro()) {
        if (intResultado < cln.getIntFrmLinha()) {
          intResultado = cln.getIntFrmLinha();
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;
  }

  private LimiteFloat getObjLimiteFloat() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_objLimiteFloat == null) {
        _objLimiteFloat = new LimiteFloat();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objLimiteFloat;
  }

  public Painel getPnlCampos() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlCampos == null) {

        _pnlCampos = new Painel();
      }

      // FIM A��ES
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

    // VARI�VEIS

    String strParam;

    // FIM VARI�VEIS
    try {
      // A��ES

      strParam = AppWeb.getI().getParametro(this.getTbl().getStrNomeSimplificado());

      if (strParam == null) {

        this.montarLayoutCadastro();

      } else {

        this.salvarRegistro();
        this.montarLayoutSalvo();
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutCadastro() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getPnlTitulo().setTagPai(this);
      this.getFrm().setTagPai(this);
      this.getPnlCampos().setTagPai(this.getFrm());
      this.getPnlComando().setTagPai(this.getFrm());
      this.getBtnCancelar().setTagPai(this.getPnlComando());
      this.getBtnSalvar().setTagPai(this.getPnlComando());

      this.montarLayoutCampos();

      this.getObjLimiteFloat().setTagPai(this.getPnlComando());

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutCampos() {
    // VARI�VEIS

    CampoFrmTbl objCampoFrmTbl;

    // FIM VARI�VEIS
    try {
      // A��ES

      for (int intIndex = 1; intIndex <= this.getIntQtdLinha(); intIndex++) {

        for (DbColuna cln : this.getTbl().getLstClnVisivelCadastro()) {

          if (cln.getIntFrmLinha() == intIndex) {

            objCampoFrmTbl = new CampoFrmTbl(cln);
            objCampoFrmTbl.setTagPai(this.getPnlCampos());
          }
        }
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutSalvo() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrConteudo("Salvo com sucesso!");

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Persiste os dados vindos do cliente no banco de dados.
   */
  private void salvarRegistro() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getTbl().salvarRegistroPost();

      // FIM A��ES
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

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.addCss(tagCss.setPadding(10, "px"));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setTbl(DbTabela tbl) {
    _tbl = tbl;
  }

}
