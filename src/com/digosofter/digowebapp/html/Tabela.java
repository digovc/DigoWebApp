package com.digosofter.digowebapp.html;

import java.sql.ResultSet;

import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;

public class Tabela extends Tag {

  private DbTabela _tbl;

  public Tabela(DbTabela tbl) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.setStrTagNome("table");
      this.setTbl(tbl);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
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
      tagTr.setTagPai(this);

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
      tagTr.setTagPai(this);

      for (DbColuna cln : this.getTbl().getLstClnVisivelConsulta()) {

        strValor = objResultSet.getString(cln.getStrNomeSimplificado());
        strValorFormatado = cln.getStrValorFormatado(strValor);

        tagTd = new Tag("td");
        tagTd.setTagPai(tagTr);
        tagTd.setStrConteudo(strValorFormatado);
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
