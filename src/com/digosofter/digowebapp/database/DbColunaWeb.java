package com.digosofter.digowebapp.database;

import java.sql.ResultSet;
import java.util.Map.Entry;

import com.digosofter.digojava.database.DbColuna;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.html.Combobox;
import com.digosofter.digowebapp.html.CssTag;

public class DbColunaWeb extends DbColuna {

  public DbColunaWeb(String strNome, DbTabelaWeb tbl, EnmTipo enmTipo) {

    super(strNome, tbl, enmTipo);
  }

  /**
   * Carrega "comboBox" com os devidos valores de acordo com a tabela
   * referenciada ou as opções default da coluna.
   */
  public void carregarCombobox(Combobox cmb) {

    try {

      if (cmb == null) {

        return;
      }

      if (this.getClnRef() != null) {

        this.carregarComboboxClnRef(cmb);
        return;
      }

      this.carregarComboboxMapOpcao(cmb);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void carregarComboboxClnRef(Combobox cmb) {

    ResultSet rst;

    try {

      rst = ((DbTabelaWeb) this.getClnRef().getTbl()).getRstNomeValor();

      cmb.setBooOpcaoVazia(!this.getClnRef().getBooNotNull());

      if (rst == null || !rst.first()) {

        return;
      }

      do {

        cmb.addOpcao(rst.getInt(1), rst.getString(2));
      }
      while (rst.next());

      rst.close();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void carregarComboboxMapOpcao(Combobox cmb) {

    try {

      if (cmb == null) {

        return;
      }

      if (this.getMapOpcao().size() == 0) {

        return;
      }

      for (Entry<Integer, String> opc : this.getMapOpcao().entrySet()) {

        if (opc == null) {

          continue;
        }

        cmb.addOpcao(opc.getKey(), opc.getValue());
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

        case TEMPORAL:
          return CssTag.getIMain().setTextAlign(CssTag.CSS_TEXT_ALIGN_DIREITA);

        case NUMERICO:
          return CssTag.getIMain().setTextAlign(CssTag.CSS_TEXT_ALIGN_DIREITA);

        default:
          return CssTag.getIMain().setTextAlign(CssTag.CSS_TEXT_ALIGN_ESQUERDA);
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