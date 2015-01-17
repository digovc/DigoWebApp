package com.digosofter.digowebapp.html.componente;

import java.sql.ResultSet;
import java.util.List;

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

      strJsCodigo = "var tbl__tbl_nome = new Tabela('_tbl_id');";

      strJsCodigo = strJsCodigo.replace("_tbl_nome", this.getTbl().getStrNomeSimplificado());
      strJsCodigo = strJsCodigo.replace("_tbl_id", this.getStrId());

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
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _pnlPesquisa;
  }

  private Tag getTagTable() {

    try {

      if (_tagTable != null) {

        return _tagTable;
      }

      _tagTable = new Tag("table");

      _tagTable.addAtr("border", "1px");

      _tagTable.addCss(CssTag.getIMain().addCss("border-collapse", "collapse"));
      _tagTable.addCss(CssTag.getIMain().setCursor("pointer"));
      _tagTable.addCss(CssTag.getIMain().setDisplay("block"));
      _tagTable.addCss(CssTag.getIMain().setHeight(650, "px"));
      _tagTable.addCss(CssTag.getIMain().setOverflowY("scroll"));
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

      _txtPesquisa.setStrId("txtPesquisa_" + this.getTbl().getStrNomeSimplificado());
      _txtPesquisa.setStrPlaceHolder("Pesquisa");
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

    Tag tagTh;
    Tag tagTr;

    try {

      tagTr = new Tag("tr");

      tagTr.setTagPai(this.getTagThead());
      tagTr.addCss(CssTag.getIMain().setBorderBottom(1, "#999"));

      for (DbColuna cln : this.getTbl().getLstClnConsulta()) {

        tagTh = new Tag("th");

        tagTh.setStrConteudo(cln.getStrNomeExibicao());
        tagTh.setTagPai(tagTr);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutColuna(DbColuna cln, Tag tagTr, ResultSet objResultSet) {

    String strValor;
    String strValorFormatado;
    Tag tagTd;

    try {

      strValor = objResultSet.getString(cln.getStrNomeSimplificado());
      strValorFormatado = cln.getStrValorFormatado(strValor);

      tagTd = new Tag("td");

      tagTd.setTagPai(tagTr);
      tagTd.setStrConteudo(strValorFormatado);

      tagTd.addCss(((DbColunaWeb) cln).getStrCss());
      tagTd.addCss(CssTag.getIMain().addCss("text-overflow", "ellipsis"));
      tagTd.addCss(CssTag.getIMain().setOverflow("hidden"));
      tagTd.addCss(CssTag.getIMain().setWhiteSpace("nowrap"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutLinha(ResultSet objResultSet) {

    Tag tagTr;

    try {

      tagTr = new Tag("tr");

      tagTr.setTagPai(this.getTagTbody());

      if (objResultSet.getRow() % 2 == 0) {

        tagTr.addCss(CssTag.getIMain().setBackgroundColor("#F6F4F0"));
      }

      for (DbColuna cln : this.getTbl().getLstClnConsulta()) {

        this.montarLayoutColuna(cln, tagTr, objResultSet);
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

  private void setTbl(DbTabelaWeb tbl) {

    _tbl = tbl;
  }
}