package com.digosofter.digowebapp.html.componente;

import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.database.DbColuna;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.database.DbColunaWeb;
import com.digosofter.digowebapp.database.DbTabelaWeb;
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
  private boolean _booSubmit;
  private Botao _btnCancelar;
  private Botao _btnSalvar;
  private Formulario _frm;
  private int _intRegistroId;
  private LimiteFloat _objLimiteFloat;
  private Painel _pnlCampos;
  private String _strAction;
  private DbTabelaWeb _tbl;

  /**
   * Formulário para cadastro de um registro da tabela passada como parâmetro.
   */
  public FormularioTbl(DbTabelaWeb tbl) {

    try {

      this.setTbl(tbl);
      this.setStrId("div_frm_" + this.getTbl().getStrNomeSql());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void addJsArquivo(List<JavaScriptTag> lstObjJsTag) {

    super.addJsArquivo(lstObjJsTag);

    try {

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_FORMULARIO_TBL));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private boolean getBooBtnCancelarVisivel() {

    return _booBtnCancelarVisivel;
  }

  private boolean getBooSalvar() {

    try {

      _booSalvar = this.getTbl().getStrNomeSql().equals(AppWeb.getI().getStrParam("save"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _booSalvar;
  }

  private boolean getBooSubmit() {

    return _booSubmit;
  }

  private Botao getBtnCancelar() {

    try {

      if (_btnCancelar != null) {

        return _btnCancelar;
      }

      _btnCancelar = new Botao();

      _btnCancelar.setStrId("btnCancelar");
      _btnCancelar.setStrConteudo("Cancelar");

      _btnCancelar.addCss(CssTag.getIMain().setMarginTop(15));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _btnCancelar;
  }

  private Botao getBtnSalvar() {

    try {

      if (_btnSalvar != null) {

        return _btnSalvar;
      }

      _btnSalvar = new Botao();

      _btnSalvar.setStrConteudo("Salvar");
      _btnSalvar.setStrId("btnSalvar");

      _btnSalvar.addCss(CssTag.getIMain().setMarginTop(15));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _btnSalvar;
  }

  private Formulario getFrm() {

    try {

      if (_frm != null) {

        return _frm;
      }

      _frm = new Formulario(this.getStrAction(), Formulario.EnmMetodo.POST);

      _frm.setStrId("frm_" + this.getTbl().getStrNomeSql());

      if (!this.getBooSubmit()) {

        _frm.addAtr("onsubmit", "return false;");
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _frm;
  }

  /**
   * Retorna a quantidade de linhas contidas no formulário.
   */
  private int getIntQtdLinha() {

    int intResultado = 1;

    try {

      for (DbColuna cln : this.getTbl().getLstClnCadastro()) {

        if (intResultado < cln.getIntFrmLinha()) {

          intResultado = cln.getIntFrmLinha();
        }
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  public int getIntRegistroId() {

    try {

      if (_intRegistroId != 0) {

        return _intRegistroId;
      }

      _intRegistroId = AppWeb.getI().getIntParam("id");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _intRegistroId;
  }

  private LimiteFloat getObjLimiteFloat() {

    try {

      if (_objLimiteFloat != null) {

        return _objLimiteFloat;
      }

      _objLimiteFloat = new LimiteFloat();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objLimiteFloat;
  }

  public Painel getPnlCampos() {

    try {

      if (_pnlCampos != null) {

        return _pnlCampos;
      }

      _pnlCampos = new Painel();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlCampos;
  }

  private String getStrAction() {

    try {

      if (!Utils.getBooStrVazia(_strAction)) {

        return _strAction;
      }

      _strAction = AppWeb.getI().getStrPagSolicitada();

      _strAction += "?save=";
      _strAction += this.getTbl().getStrNomeSql();

      if (this.getIntRegistroId() > 0) {

        _strAction += "&id=";
        _strAction += this.getIntRegistroId();
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _strAction;
  }

  private DbTabelaWeb getTbl() {

    return _tbl;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.salvarRegistro();
      this.montarLayoutCadastro();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutCadastro() {

    try {

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
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutCampos() {

    CampoFrmTbl objCampoFrmTbl;

    try {

      if (this.getIntRegistroId() > 0) {

        this.getTbl().buscarRegistro(this.getIntRegistroId());
      }
      else {

        this.getTbl().limparColunas();
      }

      for (int i = 1; i <= this.getIntQtdLinha(); i++) {

        for (DbColuna cln : this.getTbl().getLstClnCadastro()) {

          if (cln.getIntFrmLinha() == i) {

            objCampoFrmTbl = new CampoFrmTbl((DbColunaWeb) cln);

            objCampoFrmTbl.setTagPai(this.getPnlCampos());
          }
        }
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void mostrarMsgSalvo() {

    Mensagem msg;

    try {

      // TODO: Implementar mensagens de erro
      msg = new Mensagem();

      msg.setStrTitulo("Ok");
      msg.setStrMensagem("Salvo com sucesso!");
      msg.setEnmTipo(Mensagem.EnmTipo.POSITIVA);

      PaginaHtml.getI().mostrarMsgCliente(msg);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Persiste os dados vindos do cliente no banco de dados.
   */
  private void salvarRegistro() {

    int intId;

    try {

      if (!this.getBooSalvar()) {

        return;
      }

      this.mostrarMsgSalvo();

      intId = this.getTbl().salvarRegistroPost();
      this.setIntRegistroId(intId);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
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

    try {

      this.addCss(tagCss.setPadding(10, "px"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setIntRegistroId(int intRegistroId) {

    _intRegistroId = intRegistroId;
  }

  private void setTbl(DbTabelaWeb tbl) {

    _tbl = tbl;
  }
}