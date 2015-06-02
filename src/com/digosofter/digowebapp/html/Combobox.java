package com.digosofter.digowebapp.html;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;

public class Combobox extends Campo {

  private boolean _booOpcaoVazia;

  private LinkedHashMap<Integer, String> _mapOpcao;

  public Combobox() {

    try {

      this.setStrTagNome("select");
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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.DIR_JS_CAMPO));
      lstObjJsTag.add(new JavaScriptTag(AppWeb.DIR_JS_COMBO_BOX));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  /**
   * Adiciona uma opção à lista do "Combobox".
   */
  public void addOpcao(int intValor, String strNome) {

    try {

      if (this.getMapOpcao().containsKey(intValor)) {

        return;
      }

      this.getMapOpcao().put(intValor, strNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private boolean getBooOpcaoVazia() {

    return _booOpcaoVazia;
  }

  protected LinkedHashMap<Integer, String> getMapOpcao() {

    try {

      if (_mapOpcao != null) {

        return _mapOpcao;
      }

      _mapOpcao = new LinkedHashMap<Integer, String>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _mapOpcao;
  }

  private Tag getNewTagOption(int intValor, String strNome) {

    Tag tagResultado;

    try {

      tagResultado = new Tag("option");

      if (this.getIntValor() == intValor) {

        tagResultado.addAtr("selected", null);
      }

      tagResultado.addAtr("value", intValor);
      tagResultado.setStrConteudo(strNome);

      return tagResultado;
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.montarLayoutItens();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void montarLayoutItens() {

    Tag tagOption;

    try {

      if (this.getMapOpcao().isEmpty() || this.getBooOpcaoVazia()) {

        tagOption = this.getNewTagOption(-1, Utils.STR_VAZIA);
        tagOption.setTagPai(this);
      }

      for (Entry<Integer, String> opc : this.getMapOpcao().entrySet()) {

        if (opc == null) {

          return;
        }

        tagOption = this.getNewTagOption(opc.getKey(), opc.getValue());
        tagOption.setTagPai(this);
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void setBooOpcaoVazia(boolean booOpcaoVazia) {

    _booOpcaoVazia = booOpcaoVazia;
  }
}