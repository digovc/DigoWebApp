package com.digosofter.digowebapp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digosofter.digowebapp.design.PaletaCor;
import com.digosofter.digowebapp.erro.Erro;

public abstract class AppWeb extends Objeto {

  private static List<PaletaCor> _lstObjPaletaCor;

  private static AppWeb i;

  public static final String JS_BOTAO = "res/js/lib/JDigo/html/Botao.js";
  public static final String JS_CAMPO = "res/js/lib/JDigo/html/Campo.js";
  public static final String JS_COMPONENTE_MAIN = "res/js/lib/JDigo/html/componente/ComponenteMain.js";
  public static final String JS_FORMULARIO = "res/js/lib/JDigo/html/Formulario.js";
  public static final String JS_FORMULARIO_TBL = "res/js/lib/JDigo/html/componente/FormularioTbl.js";
  public static final String JS_IMAGEM = "res/js/lib/JDigo/html/Imagem.js";
  public static final String JS_ITEM_MAIN = "res/js/lib/JDigo/html/componente/item/ItemMain.js";
  public static final String JS_MOOTOOLS = "res/js/lib/JDigo/lib/mootools-core-1.4.5.js";
  public static final String JS_PAINEL = "res/js/lib/JDigo/html/Painel.js";
  public static final String JS_POPUP = "res/js/lib/JDigo/html/componente/Popup.js";
  public static final String JS_POPUP_ITEM = "res/js/lib/JDigo/html/componente/item/PopupItem.js";
  public static final String JS_QUICKSEARCH = "res/js/lib/JDigo/lib/jquery.quicksearch.min.js";
  public static final String JS_TABELA = "res/js/lib/JDigo/html/componente/Tabela.js";
  public static final String JS_TABLESORTER = "res/js/lib/JDigo/lib/jquery.tablesorter.min.js";
  public static final String JS_TAG = "res/js/lib/JDigo/html/Tag.js";
  public static final String JS_WEBSOCKET_FILE_TRANSFER = "res/js/lib/JDigo/lib/WebSocketFileTransfer.js";

  public static AppWeb getI() {
    return i;
  }

  private List<Usuario> _lstObjUsuarioSessao;

  private HttpServletRequest _objHttpServletRequest;

  private HttpServletResponse _objHttpServletResponse;

  private HttpSession _objHttpSession;

  private PaletaCor _objPaletaCor;

  private PrintWriter _objPrintWriter;

  private Usuario _objUsuarioAtual;

  private String _strPagSolicitada;

  private String _strVersao;

  public AppWeb(String strAppNome) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setI(this);
      this.setStrNome(strAppNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void addStrHtmlResposta(int intHtml) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getObjPrintWriter().print(intHtml);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void addStrHtmlResposta(String strHtml) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getObjPrintWriter().print(strHtml);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public boolean getBooUsuarioExiste(String strSessaoId) {
    // VARIÁVEIS

    boolean booResultado = false;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (Usuario usuario : this.getLstObjUsuarioSessao()) {
        if (usuario.getStrSessaoId().equals(strSessaoId)) {
          booResultado = true;
          break;
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return booResultado;
  }

  /**
   * Retorna o valor do parâmetro "GET" ou "POST" vindo do cliente indicado pelo
   * nome contido em "strParamNome". Caso não exista retorna "-1".
   */
  public int getIntParam(String strParamNome) {
    // VARIÁVEIS

    int intResultado = -1;
    String strParam;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strParam = this.getObjHttpServletRequest().getParameter(strParamNome);
      strParam = !Utils.getBooStrVazia(strParam) ? strParam : "-1";

      intResultado = Integer.valueOf(strParam);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intResultado;
  }

  public int getIntPostParam(String strParamNome) {
    // VARIÁVEIS

    int intResultado = -1;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      intResultado = Integer.valueOf(this.getObjHttpServletRequest().getParameter(strParamNome));

      // FIM AÇÕES
    } catch (Exception ex) {

      intResultado = -1;

    } finally {
    }
    return intResultado;
  }

  public List<PaletaCor> getLstObjPaletaCor() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstObjPaletaCor == null) {
        _lstObjPaletaCor = new ArrayList<PaletaCor>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstObjPaletaCor;
  }

  public List<Usuario> getLstObjUsuarioSessao() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstObjUsuarioSessao == null) {
        _lstObjUsuarioSessao = new ArrayList<Usuario>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstObjUsuarioSessao;
  }

  public HttpServletRequest getObjHttpServletRequest() {
    return _objHttpServletRequest;
  }

  private HttpServletResponse getObjHttpServletResponse() {
    return _objHttpServletResponse;
  }

  private HttpSession getObjHttpSession() {
    return _objHttpSession;
  }

  public PaletaCor getObjPaletaCor() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_objPaletaCor != null) {
        return _objPaletaCor;
      }

      for (PaletaCor objPaletaCor : this.getLstObjPaletaCor()) {

        if (objPaletaCor.getBooSelecionado()) {

          _objPaletaCor = objPaletaCor;
          return _objPaletaCor;
        }

      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objPaletaCor;
  }

  private PrintWriter getObjPrintWriter() {
    return _objPrintWriter;
  }

  public Usuario getObjUsuarioAtual() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {
        if (objUsuario.getStrSessaoId() == this.getObjHttpSession().getId()) {
          _objUsuarioAtual = objUsuario;
          break;
        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _objUsuarioAtual;
  }

  public Usuario getObjUsuarioPorSessaoId(String strSessaoId) {
    // VARIÁVEIS

    Usuario objUsuarioResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {

        if (objUsuario.getStrSessaoId().equals(strSessaoId)) {

          objUsuarioResultado = objUsuario;
          break;

        }
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objUsuarioResultado;
  }

  public void getResposta(HttpServletRequest objRequest, HttpServletResponse objResponse) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setObjHttpServletRequest(objRequest);
      this.setObjHttpServletResponse(objResponse);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public String getStrPagSolicitada() {
    return _strPagSolicitada;
  }

  /**
   * Retorna o valor do parâmetro "GET" ou "POST" vindo do cliente indicado pelo
   * nome contido em "strParamNome". Caso não exista retorna "null".
   */
  public String getStrParam(String strParamNome) {
    // VARIÁVEIS

    String strResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strResultado = this.getObjHttpServletRequest().getParameter(strParamNome);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strResultado;
  }

  public String getStrVersao() {
    return _strVersao;
  }

  public void reencaminhar(String strUrl) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.getObjHttpServletResponse().sendRedirect(strUrl);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setI(AppWeb _i) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (i == null) {
        i = _i;
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro ao instanciar objeto do tipo 'AppWeb'.\n", ex);

    } finally {
    }
  }

  public void setObjHttpServletRequest(HttpServletRequest objHttpServletRequest) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _objHttpServletRequest = objHttpServletRequest;
      this.setStrPagSolicitada(_objHttpServletRequest.getRequestURI().replace(
          _objHttpServletRequest.getContextPath() + "/app/", Utils.STRING_VAZIA));
      this.setObjHttpSession(_objHttpServletRequest.getSession());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setObjHttpServletResponse(HttpServletResponse objHttpServletResponse) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _objHttpServletResponse = objHttpServletResponse;
      this.setObjPrintWriter(_objHttpServletResponse.getWriter());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void setObjHttpSession(HttpSession objHttpSession) {
    // VARIÁVEIS

    Usuario objUsuario;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      _objHttpSession = objHttpSession;

      if (!this.getBooUsuarioExiste(_objHttpSession.getId())) {

        objUsuario = new Usuario();
        objUsuario.setStrSessaoId(_objHttpSession.getId());
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public void setObjPaletaCorSelecionada(PaletaCor objPaletaCorSelecionada) {
    _objPaletaCor = objPaletaCorSelecionada;
  }

  public void setObjPrintWriter(PrintWriter objPrintWriter) {
    _objPrintWriter = objPrintWriter;
  }

  private void setStrPagSolicitada(String strPagSolicitada) {
    _strPagSolicitada = strPagSolicitada;
  }

  protected void setStrVersao(String strVersao) {
    _strVersao = strVersao;
  }

}
