package com.digosofter.digowebapp.html.componente;

import java.sql.ResultSet;
import java.util.List;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.database.DbColuna;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.database.DbColunaWeb;
import com.digosofter.digowebapp.database.DbTabelaWeb;
import com.digosofter.digowebapp.html.Campo;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.Painel;
import com.digosofter.digowebapp.html.Tag;

public class Tabela extends ComponenteMain {

  private boolean _booPesquisa = true;
  private Painel _pnlPesquisa;
  private String _strPagClick;
  private Tag _tagTable;
  private Tag _tagTbody;
  private Tag _tagThead;
  private DbTabelaWeb _tbl;
  private Campo _txtPesquisa;

  public Tabela(DbTabelaWeb tbl) {

    try {

      this.setTbl(tbl);
      this.setStrId("div_" + this.getTbl().getStrNome());
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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TABELA));
      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TABLESORTER));

      if (this.getBooPesquisa()) {

        lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_QUICKSEARCH));
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  protected void addJsCodigo(JavaScriptTag tagJs) {

    super.addJsCodigo(tagJs);

    String strJsCodigo;

    try {

      strJsCodigo = "var tbl__tbl_nome = new Tabela('_tbl_id', _pag_click);";

      strJsCodigo = strJsCodigo.replace("_tbl_nome", this.getTbl().getStrNome());
      strJsCodigo = strJsCodigo.replace("_tbl_id", this.getStrId());
      strJsCodigo = strJsCodigo.replace("_pag_click", !Utils.getBooStrVazia(this.getStrPagClick()) ? "'" + this.getStrPagClick() + "'" : "null");

      tagJs.addJsCodigo(strJsCodigo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private boolean getBooPesquisa() {

    return _booPesquisa;
  }

  private Painel getPnlPesquisa() {

    try {

      if (_pnlPesquisa != null) {

        return _pnlPesquisa;
      }

      _pnlPesquisa = new Painel();

      _pnlPesquisa.addCss(CssTag.getIMain().setPadding(10, "px"));
      _pnlPesquisa.addCss(CssTag.getIMain().setPaddingBottom(0));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlPesquisa;
  }

  private String getStrPagClick() {

    return _strPagClick;
  }

  private Tag getTagTable() {

    try {

      if (_tagTable != null) {

        return _tagTable;
      }

      _tagTable = new Tag("table");

      _tagTable.addAtr("border", "0px");

      _tagTable.addCss(CssTag.getIMain().addCss("border-collapse", "collapse"));
      _tagTable.addCss(CssTag.getIMain().addCss("max-height", "500px"));
      _tagTable.addCss(CssTag.getIMain().setBorder(1, "solid", "gray"));
      _tagTable.addCss(CssTag.getIMain().setBoxShadow(0, 0, 5, 0, "gray"));
      _tagTable.addCss(CssTag.getIMain().setCursor("pointer"));
      _tagTable.addCss(CssTag.getIMain().setDisplay("block"));
      _tagTable.addCss(CssTag.getIMain().setHeight(100, "%"));
      _tagTable.addCss(CssTag.getIMain().setMargin(10, "px"));
      _tagTable.addCss(CssTag.getIMain().setOverflowY("auto"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagTable;
  }

  private Tag getTagTbody() {

    try {

      if (_tagTbody != null) {

        return _tagTbody;
      }

      _tagTbody = new Tag("tbody");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagTbody;
  }

  private Tag getTagThead() {

    try {

      if (_tagThead != null) {

        return _tagThead;
      }

      _tagThead = new Tag("thead");

      _tagThead.addCss(CssTag.getIMain().addCss("white-space", "nowrap"));
      _tagThead.addCss(CssTag.getIMain().setBackgroundColor("gray"));
      _tagThead.addCss(CssTag.getIMain().setColor("white"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _tagThead;
  }

  private DbTabelaWeb getTbl() {

    return _tbl;
  }

  private Campo getTxtPesquisa() {

    try {

      if (_txtPesquisa != null) {

        return _txtPesquisa;
      }

      _txtPesquisa = new Campo();

      _txtPesquisa.setStrId("txtPesquisa_" + this.getTbl().getStrNomeSql());
      _txtPesquisa.setStrPlaceHolder("Pesquisa");

      _txtPesquisa.addCss(CssTag.getIMain().setWidth(30, "%"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _txtPesquisa;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      if (this.getBooPesquisa()) {

        this.getPnlPesquisa().setTagPai(this);
        this.getTxtPesquisa().setTagPai(this.getPnlPesquisa());
      }

      this.getTagTable().setTagPai(this);
      this.getTagThead().setTagPai(this.getTagTable());
      this.getTagTbody().setTagPai(this.getTagTable());

      this.montarLayoutCabecalho();
      this.montarLayoutLinhas();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutCabecalho() {

    Tag tagTr;

    try {

      tagTr = new Tag("tr");

      tagTr.setTagPai(this.getTagThead());
      tagTr.addCss(CssTag.getIMain().setBorderBottom(1, "#999"));

      for (DbColuna cln : this.getTbl().getLstClnConsulta()) {

        this.montarLayoutCabecalhoItem(cln, tagTr);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutCabecalhoItem(DbColuna cln, Tag tagTr) {

    Tag tagTh;

    try {

      tagTh = new Tag("th");

      tagTh.addCss(CssTag.getIMain().setPadding(5, "px"));
      tagTh.addCss(CssTag.getIMain().setPaddingLeft(30));
      tagTh.addCss(CssTag.getIMain().setPaddingRight(30));

      tagTh.setStrConteudo(cln.getStrNomeExibicao());

      tagTh.setTagPai(tagTr);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutColuna(DbColuna cln, Tag tagTr, ResultSet rst) {

    Tag tagTd;

    try {

      cln.setStrValor(rst.getString(cln.getStrNomeSql()));

      tagTd = new Tag("td");

      tagTd.setTagPai(tagTr);
      tagTd.setStrConteudo(cln.getStrValorExibicao());
      tagTd.addCss(((DbColunaWeb) cln).getStrCss());
      tagTd.addCss(CssTag.getIMain().addCss("text-overflow", "ellipsis"));
      tagTd.addCss(CssTag.getIMain().setOverflow("hidden"));
      tagTd.addCss(CssTag.getIMain().setPadding(5, "px"));
      tagTd.addCss(CssTag.getIMain().setWhiteSpace("nowrap"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutLinha(ResultSet rst) {

    Tag tagTr;

    try {

      tagTr = new Tag("tr");

      tagTr.setTagPai(this.getTagTbody());

      if (rst.getRow() % 2 == 0) {

        tagTr.addCss(CssTag.getIMain().setBackgroundColor("#FAFAFA"));
      }

      for (DbColuna cln : this.getTbl().getLstClnConsulta()) {

        this.montarLayoutColuna(cln, tagTr, rst);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutLinhas() {

    ResultSet rst;

    try {

      rst = this.getTbl().getRstConsulta();

      if (rst == null || !rst.first()) {

        return;
      }

      do {

        this.montarLayoutLinha(rst);
      }
      while (rst.next());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setBooPesquisa(boolean booPesquisa) {

    _booPesquisa = booPesquisa;
  }

  public void setStrPagClick(String strPagClick) {

    _strPagClick = strPagClick;
  }

  private void setTbl(DbTabelaWeb tbl) {

    _tbl = tbl;
  }
}
