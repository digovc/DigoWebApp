package com.digosofter.digowebapp.html.relatorio;

import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.html.CssTag;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.PaginaHtml;
import com.digosofter.digowebapp.html.Titulo;
import com.digosofter.digowebapp.html.Titulo.EnmTipo;

public abstract class RelatorioMain extends PaginaHtml {

  private String _strTitulo;
  private Titulo _ttl;
  private Titulo _ttlSub;

  public RelatorioMain() {

    try {

      this.setStrTitulo("Relatório sem nome");
      this.setStrDescricao("A descrição deste relatório é desconhecida");
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

      lstObjJsTag.add(new JavaScriptTag(AppWeb.DIR_JS_RELATORIO_MAIN));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public String getStrTitulo() {

    return _strTitulo;
  }

  private Titulo getTtl() {

    try {

      if (_ttl != null) {

        return _ttl;
      }

      _ttl = new Titulo();

      _ttl.setStrConteudo(this.getStrTitulo());

      _ttl.limparClass();

      _ttl.addCss(CssTag.getIMain().setTextAlign("center"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _ttl;
  }

  private Titulo getTtlSub() {

    try {

      if (_ttlSub != null) {

        return _ttlSub;
      }

      _ttlSub = new Titulo();

      _ttlSub.setEnmTipo(EnmTipo.H2);
      _ttlSub.setStrConteudo(this.getStrDescricao());

      _ttlSub.limparClass();

      _ttlSub.addCss(CssTag.getIMain().setTextAlign("center"));
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _ttlSub;
  }

  @Override
  protected void montarLayout() {

    super.montarLayout();

    try {

      this.getTtl().setTagPai(this.getTagBody());
      this.getTtlSub().setTagPai(this.getTagBody());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void setStrTitulo(String strTitulo) {

    try {

      _strTitulo = strTitulo;

      this.getTagTitle().setStrConteudo(_strTitulo);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }
}