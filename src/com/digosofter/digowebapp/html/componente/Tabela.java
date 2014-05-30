package com.digosofter.digowebapp.html.componente;

import java.sql.ResultSet;
import java.util.List;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.Tag;

public class Tabela extends ComponenteMain {

  private boolean _booPesquisa = true;

  private Painel _pnlPesquisa;

  private Tag _tagTable;

  private Tag _tagTbody;

  private Tag _tagThead;

  private DbTabela _tbl;

  private Campo _txtPesquisa;

  public Tabela(DbTabela tbl) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setTbl(tbl);
      this.setStrId("div_" + this.getTbl().getStrNome());

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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TABELA));
      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TABLESORTER));

      if (this.getBooPesquisa()) {
        lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_QUICKSEARCH));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsCodigo(JavaScriptTag tagJs) {

    super.addJsCodigo(tagJs);

    // VARIÁVEIS

    String strJsCodigo;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strJsCodigo = "";

      strJsCodigo += "var tbl_";
      strJsCodigo += this.getTbl().getStrNome();
      strJsCodigo += " = new Tabela('";
      strJsCodigo += this.getStrId();
      strJsCodigo += "');";

      tagJs.addJsCodigo(strJsCodigo);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private boolean getBooPesquisa() {
    return _booPesquisa;
  }

  private Painel getPnlPesquisa() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_pnlPesquisa == null) {

        _pnlPesquisa = new Painel();
        _pnlPesquisa.addCss(CssTag.getIMain().setPadding(10, "px"));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlPesquisa;
  }

  private Tag getTagTable() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagTable == null) {

        _tagTable = new Tag("table");
        _tagTable.addAtr("border", "1px");
        _tagTable.addCss(CssTag.getIMain().addCss("border-collapse", "collapse"));
        _tagTable.addCss(CssTag.getIMain().setCursor("pointer"));
        _tagTable.addCss(CssTag.getIMain().setDisplay("block"));
        _tagTable.addCss(CssTag.getIMain().setHeight(650, "px"));
        _tagTable.addCss(CssTag.getIMain().setOverflowY("scroll"));
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagTable;
  }

  private Tag getTagTbody() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagTbody == null) {

        _tagTbody = new Tag("tbody");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagTbody;
  }

  private Tag getTagThead() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_tagThead == null) {

        _tagThead = new Tag("thead");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagThead;
  }

  private DbTabela getTbl() {
    return _tbl;
  }

  private Campo getTxtPesquisa() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_txtPesquisa == null) {

        _txtPesquisa = new Campo();
        _txtPesquisa.setStrId("txtPesquisa_" + this.getTbl().getStrNomeSimplificado());
        _txtPesquisa.setStrPlaceHolder("Pesquisa");
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _txtPesquisa;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (this.getBooPesquisa()) {
        this.getPnlPesquisa().setTagPai(this);
        this.getTxtPesquisa().setTagPai(this.getPnlPesquisa());
      }

      this.getTagTable().setTagPai(this);
      this.getTagThead().setTagPai(this.getTagTable());
      this.getTagTbody().setTagPai(this.getTagTable());
      this.montarLayoutCabecalho();
      this.montarLayoutLinhas();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutCabecalho() {
    // VARIÁVEIS

    Tag tagTh;
    Tag tagTr;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      tagTr = new Tag("tr");
      tagTr.setTagPai(this.getTagThead());
      tagTr.addCss(CssTag.getIMain().setBorderBottom(1, "#999"));

      for (DbColuna cln : this.getTbl().getLstClnVisivelConsulta()) {

        tagTh = new Tag("th");
        tagTh.setStrConteudo(cln.getStrNomeExibicao());
        tagTh.setTagPai(tagTr);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutLinha(ResultSet objResultSet) {
    // VARIÁVEIS

    String strValor;
    String strValorFormatado;
    Tag tagTd;
    Tag tagTr;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      tagTr = new Tag("tr");
      tagTr.setTagPai(this.getTagTbody());

      if (objResultSet.getRow() % 2 == 0) {

        tagTr.addCss(CssTag.getIMain().setBackgroundColor("#F6F4F0"));
      }

      for (DbColuna cln : this.getTbl().getLstClnVisivelConsulta()) {

        strValor = objResultSet.getString(cln.getStrNomeSimplificado());
        strValorFormatado = cln.getStrValorFormatado(strValor);

        tagTd = new Tag("td");
        tagTd.setTagPai(tagTr);
        tagTd.setStrConteudo(strValorFormatado);
        tagTd.addCss(CssTag.getIMain().setOverflow("hidden"));
        tagTd.addCss(CssTag.getIMain().setWhiteSpace("nowrap"));
        tagTd.addCss(CssTag.getIMain().addCss("text-overflow", "ellipsis"));
        tagTd.addCss(cln.getStrCss());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutLinhas() {
    // VARIÁVEIS

    ResultSet rst;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      rst = this.getTbl().getRstConsulta();

      if (rst != null && rst.first()) {

        do {

          this.montarLayoutLinha(rst);

        } while (rst.next());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setBooPesquisa(boolean booPesquisa) {
    _booPesquisa = booPesquisa;
  }

  private void setTbl(DbTabela tbl) {
    _tbl = tbl;
  }
}
