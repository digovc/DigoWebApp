package com.digosofter.digowebapp.html.componente;

import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Botao;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Formulario;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.LimiteFloat;
import com.digosofter.digowebapp.html.PaginaHtml;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.componente.item.CampoFrmTbl;

public class FormularioTbl extends ComponenteMain {

  private boolean _booBtnCancelarVisivel = true;

  private boolean _booSalvar;

  private boolean _booSubmit = false;

  private Botao _btnCancelar;

  private Botao _btnSalvar;

  private Formulario _frm;

  private int _intRegistroId;

  private LimiteFloat _objLimiteFloat;

  private Painel _pnlCampos;

  private String _strAction;

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

  private boolean getBooBtnCancelarVisivel() {
    return _booBtnCancelarVisivel;
  }

  private boolean getBooSalvar() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _booSalvar = this.getTbl().getStrNomeSimplificado().equals(AppWeb.getI().getStrParam("save"));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _booSalvar;
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
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_frm == null) {
        _frm = new Formulario(this.getStrAction(), Formulario.EnmMetodo.POST);
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

  public int getIntRegistroId() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_intRegistroId == 0) {
        _intRegistroId = AppWeb.getI().getIntParam("id");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _intRegistroId;
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

  private String getStrAction() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Utils.getBooStrVazia(_strAction)) {
        _strAction = AppWeb.getI().getStrPagSolicitada();
        _strAction += "?save=";
        _strAction += this.getTbl().getStrNomeSimplificado();

        if (this.getIntRegistroId() > 0) {
          _strAction += "&id=";
          _strAction += this.getIntRegistroId();
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _strAction;
  }

  private DbTabela getTbl() {
    return _tbl;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.salvarRegistro();
      this.montarLayoutCadastro();

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
      this.getBtnSalvar().setTagPai(this.getPnlComando());

      if (this.getBooBtnCancelarVisivel()) {
        this.getBtnCancelar().setTagPai(this.getPnlComando());
      }

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

      if (this.getIntRegistroId() > 0) {
        this.getTbl().buscarRegistro(this.getIntRegistroId());
      } else {
        this.getTbl().zerarColunas();
      }

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

  private void mostrarMsgSalvo() {
    // VARIÁVEIS

    Mensagem msg;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      // TODO: Implementar mensagens de erro
      msg = new Mensagem();
      msg.setStrTitulo("Ok");
      msg.setStrMensagem("Salvo com sucesso!");
      msg.setEnmTipo(Mensagem.EnmTipo.POSITIVA);
      PaginaHtml.getI().mostrarMsgCliente(msg);

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

    int intId;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (!this.getBooSalvar()) {
        return;
      }

      this.mostrarMsgSalvo();
      intId = this.getTbl().salvarRegistroPost();
      this.setIntRegistroId(intId);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setBooBtnCancelarVisivel(boolean booBtnCancelarVisivel) {
    _booBtnCancelarVisivel = booBtnCancelarVisivel;
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

  private void setIntRegistroId(int intRegistroId){
    _intRegistroId = intRegistroId;
  }

  private void setTbl(DbTabela tbl) {
    _tbl = tbl;
  }

}
