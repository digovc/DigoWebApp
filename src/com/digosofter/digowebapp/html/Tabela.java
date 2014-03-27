package com.digosofter.digowebapp.html;

import java.sql.ResultSet;

import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;

public class Tabela extends Tag {

  private Tag _tagTbody;

  private DbTabela _tbl;

  public Tabela(DbTabela tbl) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrTagNome("table");
      this.setTbl(tbl);
      this.addAtr("border", "1px");
      this.addCss(CssTag.getCssMainInst().setHeight(450, "px"));
      this.addCss(CssTag.getCssMainInst().setDisplay("block"));
      this.addCss(CssTag.getCssMainInst().setOverflowY("scroll"));
      this.addCss(CssTag.getCssMainInst().addCss("border-collapse", "collapse"));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
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

  private DbTabela getTbl() {
    return _tbl;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.getTagTbody().setTagPai(this);
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
      tagTr.setTagPai(this.getTagTbody());
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

      objResultSet = this.getTbl().getObjResultSetConsulta();

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