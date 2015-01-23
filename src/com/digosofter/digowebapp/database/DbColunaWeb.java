package com.digosofter.digowebapp.database;

import java.sql.ResultSet;

import com.digosofter.digojava.database.DbColuna;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.html.ComboBox;
import com.digosofter.digowebapp.html.CssTag;

public class DbColunaWeb extends DbColuna {

  public DbColunaWeb(String strNome, DbTabelaWeb tbl, EnmTipo enmTipo) {

    super(strNome, tbl, enmTipo);
  }

  /**
   * Carrega "comboBox" com os devidos valores de acordo com a tabela
   * referenciada ou as opções default da coluna.
   */
  public void carregarComboBox(ComboBox cmb) {

    ResultSet rst;

    try {

      if (this.getClnRef() != null) {

        rst = ((DbTabelaWeb) this.getClnRef().getTbl()).getRstNomeValor();

        cmb.setBooOpcaoVazia(!this.getClnRef().getBooNotNull());

        if (rst != null && rst.first()) {

          do {

            cmb.addNomeValor(rst.getString(1), rst.getString(2));
          }
          while (rst.next());

          return;
        }
      }

      if (this.getLstStrOpcao().size() == 0) {

        return;
      }

      for (int i = 0; i < this.getLstIntOpcaoValor().size(); i++) {

        cmb.addNomeValor(this.getLstIntOpcaoValor().get(i).toString(), this.getLstStrOpcao().get(i));
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public String getStrCss() {

    try {

      switch (this.getEnmTipoGrupo()) {
        case ALPHANUMERICO:
          return CssTag.getIMain().setTextAlign(CssTag.CSS_TEXT_ALIGN_ESQUERDA);

        case TEMPORAL:
          return CssTag.getIMain().setTextAlign(CssTag.CSS_TEXT_ALIGN_DIREITA);

        case NUMERICO:
          return CssTag.getIMain().setTextAlign(CssTag.CSS_TEXT_ALIGN_DIREITA);

        default:
          break;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }
}