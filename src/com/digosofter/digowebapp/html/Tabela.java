package com.digosofter.digowebapp.html;

import java.sql.ResultSet;

import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;

public class Tabela extends Tag {

  private Tag _tagTbody;

  private DbTabela _tbl;

  public Tabela(DbTabela tbl) {

    super("table");

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setTbl(tbl);
      this.addAtr("border", "1px");

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
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

      this.getTagTbody().setTagPai(this);
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
      tagTr.setTagPai(this.getTagTbody());
      tagTr.addCss(CssTag.getCssMainInst().setBorderBottom(1, "#999"));

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

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void montarLayoutLinhas() {
    // VARIÁVEIS

    ResultSet objResultSet;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objResultSet = this.getTbl().getObjResultSetConsulta();

      if (objResultSet != null && objResultSet.first()) {

        do {

          this.montarLayoutLinha(objResultSet);

        } while (objResultSet.next());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.addCss(tagCss.setHeight(450, "px"));
      this.addCss(tagCss.setDisplay("block"));
      this.addCss(tagCss.setOverflowY("scroll"));
      this.addCss(tagCss.addCss("border-collapse", "collapse"));

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
