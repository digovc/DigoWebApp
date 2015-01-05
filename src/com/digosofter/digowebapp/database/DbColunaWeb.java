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
  public void carregarComboBox(ComboBox objCampoComboBox) {

    ResultSet rst;

    try {

      if (this.getClnRef() != null) {

        rst = ((DbTabelaWeb) this.getClnRef().getTbl()).getRstNomeValor();

        objCampoComboBox.setBooOpcaoVazia(!this.getClnRef().getBooNotNull());

        if (rst != null && rst.first()) {

          do {

            objCampoComboBox.addNomeValor(rst.getString(1), rst.getString(2));

          }
          while (rst.next());

          return;
        }
      }

      if (this.getLstStrOpcao().size() == 0) {

        return;
      }

      for (int i = 0; i < this.getLstIntOpcaoValor().size(); i++) {

        objCampoComboBox.addNomeValor(this.getLstIntOpcaoValor().get(i).toString(), this.getLstStrOpcao().get(i));
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public String getStrCss() {

    String strCss = "";

    try {

      switch (this.getEnmTipoGrupo()) {
        case ALPHANUMERICO:
          strCss += CssTag.getIMain().setTextAlign("left");
          break;
        default:
          break;
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return strCss;
  }
}
