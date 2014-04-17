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

  private Painel _pnlPesquisa;

  private Tag _tagTable;

  private Tag _tagTbody;

  private Tag _tagThead;

  private DbTabela _tbl;

  private Campo _txtPesquisa;

  public Tabela(DbTabela tbl) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setTbl(tbl);
      this.setStrId("div_" + this.getTbl().getStrNomeSimplificado());

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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TABELA));
      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_TABLESORTER));
      lstObjJsTag.add(new JavaScriptTag(AppWeb.JS_QUICKSEARCH));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void addJsCodigo(JavaScriptTag tagJs) {

    super.addJsCodigo(tagJs);

    // VARI�VEIS

    String strJsCodigo;

    // FIM VARI�VEIS
    try {
      // A��ES

      strJsCodigo = "";

      strJsCodigo += "var tbl_";
      strJsCodigo += this.getTbl().getStrNomeSimplificado();
      strJsCodigo += " = new Tabela('";
      strJsCodigo += this.getStrId();
      strJsCodigo += "');";

      tagJs.addJsCodigo(strJsCodigo);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private Painel getPnlPesquisa() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_pnlPesquisa == null) {

        _pnlPesquisa = new Painel();
        _pnlPesquisa.addCss(CssTag.getCssMainInst().setPadding(10, "px"));
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _pnlPesquisa;
  }

  private Tag getTagTable() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_tagTable == null) {

        _tagTable = new Tag("table");
        _tagTable.addAtr("border", "1px");
        _tagTable.addCss(CssTag.getCssMainInst().addCss("border-collapse", "collapse"));
        _tagTable.addCss(CssTag.getCssMainInst().setCursor("pointer"));
        _tagTable.addCss(CssTag.getCssMainInst().setDisplay("block"));
        _tagTable.addCss(CssTag.getCssMainInst().setHeight(650, "px"));
        _tagTable.addCss(CssTag.getCssMainInst().setOverflowY("scroll"));
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagTable;
  }

  private Tag getTagTbody() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_tagTbody == null) {

        _tagTbody = new Tag("tbody");
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _tagTbody;
  }

  private Tag getTagThead() {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_tagThead == null) {

        _tagThead = new Tag("thead");
      }

      // FIM A��ES
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
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      if (_txtPesquisa == null) {

        _txtPesquisa = new Campo();
        _txtPesquisa.setStrId("txtPesquisa_" + this.getTbl().getStrNomeSimplificado());
        _txtPesquisa.setStrPlaceHolder("Pesquisa");
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _txtPesquisa;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getPnlPesquisa().setTagPai(this);
      this.getTxtPesquisa().setTagPai(this.getPnlPesquisa());
      this.getTagTable().setTagPai(this);
      this.getTagThead().setTagPai(this.getTagTable());
      this.getTagTbody().setTagPai(this.getTagTable());
      this.montarLayoutCabecalho();
      this.montarLayoutLinhas();

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutCabecalho() {
    // VARI�VEIS

    Tag tagTh;
    Tag tagTr;

    // FIM VARI�VEIS
    try {
      // A��ES

      tagTr = new Tag("tr");
      tagTr.setTagPai(this.getTagThead());
      tagTr.addCss(CssTag.getCssMainInst().setBorderBottom(1, "#999"));

      for (DbColuna cln : this.getTbl().getLstClnVisivelConsulta()) {

        tagTh = new Tag("th");
        tagTh.setStrConteudo(cln.getStrNomeExibicao());
        tagTh.setTagPai(tagTr);
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutLinha(ResultSet objResultSet) {
    // VARI�VEIS

    String strValor;
    String strValorFormatado;
    Tag tagTd;
    Tag tagTr;

    // FIM VARI�VEIS
    try {
      // A��ES

      tagTr = new Tag("tr");
      tagTr.setTagPai(this.getTagTbody());

      if (objResultSet.getRow() % 2 == 0) {

        tagTr.addCss(CssTag.getCssMainInst().setBackgroundColor("#F6F4F0"));
      }

      for (DbColuna cln : this.getTbl().getLstClnVisivelConsulta()) {

        strValor = objResultSet.getString(cln.getStrNomeSimplificado());
        strValorFormatado = cln.getStrValorFormatado(strValor);

        tagTd = new Tag("td");
        tagTd.setTagPai(tagTr);
        tagTd.setStrConteudo(strValorFormatado);
        tagTd.addCss(CssTag.getCssMainInst().setOverflow("hidden"));
        tagTd.addCss(CssTag.getCssMainInst().setWhiteSpace("nowrap"));
        tagTd.addCss(CssTag.getCssMainInst().addCss("text-overflow", "ellipsis"));
        tagTd.addCss(cln.getStrCss());
      }

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutLinhas() {
    // VARI�VEIS

    ResultSet objResultSet;

    // FIM VARI�VEIS
    try {
      // A��ES

      objResultSet = this.getTbl().getRstConsulta();

      if (objResultSet != null && objResultSet.first()) {

        do {

          this.montarLayoutLinha(objResultSet);

        } while (objResultSet.next());
      }

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
