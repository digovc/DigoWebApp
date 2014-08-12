package com.digosofter.digowebapp.html.componente;

import java.sql.ResultSet;

import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.Botao;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.Painel;

public class ConsultaTbl extends ComponenteMain {

  private Botao _btnNovo;

  private Painel _pnlLista;

  private DbTabela _tbl;

  public ConsultaTbl(DbTabela tbl) {

    try {

      this.setTbl(tbl);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  private Botao getBtnNovo() {

    try {

      if (_btnNovo == null) {

        _btnNovo = new Botao();
        _btnNovo.setStrConteudo("Novo");
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _btnNovo;
  }

  private Painel getPnlLista() {

    try {

      if (_pnlLista == null) {
        _pnlLista = new Painel();
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _pnlLista;
  }

  private DbTabela getTbl() {

    return _tbl;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.getPnlTitulo().setTagPai(this);
      this.getPnlLista().setTagPai(this);
      this.montarLayoutLista();
      this.getPnlComando().setTagPai(this);
      this.getBtnNovo().setTagPai(this.getPnlComando());
      this.getTagLimiteFloat().setTagPai(this.getPnlComando());

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Monta o layout de uma linha baseado no registro posicionado no objeto
   * "objResultSet".
   */
  private void montarLayoutLinha(ResultSet objResultSet) {

    // String strNome;
    // String strValor;
    //
    // LinhaConsultaTbl objLinhaConsultaTbl;

    try {

      // objLinhaConsultaTbl = new LinhaConsultaTbl();
      // objLinhaConsultaTbl.setStrNome(objResultSet.getString(this.getTbl().getClnNome().getStrNomeSimplificado()));
      //
      // for (DbColuna cln : this.getTbl().getLstClnVisivelConsulta()) {
      //
      // if (!cln.getBooClnNome()) {
      //
      // strNome = cln.getStrNomeExibicao();
      // objLinhaConsultaTbl.getLstStrNome().add(strNome);
      // strValor = objResultSet.getString(cln.getStrNomeSimplificado());
      // objLinhaConsultaTbl.getLstStrValor().add(strValor);
      // }
      // }
      //
      // objLinhaConsultaTbl.getPnlContainer().setTagPai(this.getPnlLista());
      // objLinhaConsultaTbl.montarLayout();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Monta o layout da lista com os valores da "tbl".
   */
  private void montarLayoutLista() {

    ResultSet objResultSet;

    try {

      objResultSet = this.getTbl().getRstConsulta();

      if (objResultSet != null && objResultSet.first()) {

        do {

          this.montarLayoutLinha(objResultSet);

        }
        while (objResultSet.next());
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  @Override
  protected void setCss(CssTag tagCss) {

    super.setCss(tagCss);

    try {

      this.addCss(tagCss.setPadding(5, "px"));
      this.addCss(tagCss.setBorder(1, "solid", "black"));

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  private void setTbl(DbTabela tbl) {

    _tbl = tbl;
  }

}
