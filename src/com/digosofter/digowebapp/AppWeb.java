package com.digosofter.digowebapp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digosofter.digojava.App;
import com.digosofter.digojava.Utils;
import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.design.PaletaCor;

public abstract class AppWeb extends App {

  private static List<PaletaCor> _lstObjPaletaCor;
  private static AppWeb i;

  public static final String JS_BOTAO = "res/js/lib/JDigo/html/Botao.js";
  public static final String JS_CAMPO = "res/js/lib/JDigo/html/Campo.js";
  public static final String JS_COMBO_BOX = "res/js/lib/JDigo/html/ComboBox.js";
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

  private String _dirLocal;
  private List<Usuario> _lstObjUsuarioSessao;
  private HttpServletRequest _objHttpServletRequest;
  private HttpServletResponse _objHttpServletResponse;
  private HttpSession _objHttpSession;
  private PaletaCor _objPaletaCor;
  private PrintWriter _objPrintWriter;
  private ServletContext _objServletContext;
  private Usuario _objUsuarioAtual;
  private String _strPagSolicitada;

  protected AppWeb(String strAppNome) {

    try {

      this.setI(this);
      this.setStrNome(strAppNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addStrHtmlResposta(int intHtml) {

    try {

      this.getObjPrintWriter().print(intHtml);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void addStrHtmlResposta(String strHtml) {

    try {

      this.getObjPrintWriter().print(strHtml);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public boolean getBooUsuarioExiste(String strSessaoId) {

    try {

      for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {

        if (!objUsuario.getStrSessaoId().equals(strSessaoId)) {

          continue;
        }

        return true;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return false;
  }

  public String getDirLocal() {

    try {

      if (!Utils.getBooStrVazia(_dirLocal)) {

        return _dirLocal;
      }

      _dirLocal = this.getObjServletContext().getRealPath("/");
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _dirLocal;
  }

  /**
   * Retorna o valor do par�metro "GET" ou "POST" vindo do cliente indicado pelo
   * nome contido em "strParamNome". Caso n�o exista retorna "-1".
   */
  public int getIntParam(String strParamNome) {

    int intResultado = -1;
    String strParam;

    try {

      strParam = this.getObjHttpServletRequest().getParameter(strParamNome);
      strParam = !Utils.getBooStrVazia(strParam) ? strParam : "-1";

      intResultado = Integer.valueOf(strParam);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intResultado;
  }

  public int getIntPostParam(String strParamNome) {

    int intResultado = -1;

    try {

      intResultado = Integer.valueOf(this.getObjHttpServletRequest().getParameter(strParamNome));
    }
    catch (Exception ex) {

      intResultado = -1;
    }
    finally {
    }

    return intResultado;
  }

  public List<PaletaCor> getLstObjPaletaCor() {

    try {

      if (_lstObjPaletaCor != null) {

        return _lstObjPaletaCor;
      }

      _lstObjPaletaCor = new ArrayList<PaletaCor>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstObjPaletaCor;
  }

  public List<Usuario> getLstObjUsuarioSessao() {

    try {

      if (_lstObjUsuarioSessao != null) {

        return _lstObjUsuarioSessao;
      }

      _lstObjUsuarioSessao = new ArrayList<Usuario>();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _lstObjUsuarioSessao;
  }

  public HttpServletRequest getObjHttpServletRequest() {

    return _objHttpServletRequest;
  }

  protected HttpServletResponse getObjHttpServletResponse() {

    return _objHttpServletResponse;
  }

  public HttpSession getObjHttpSession() {

    return _objHttpSession;
  }

  public PaletaCor getObjPaletaCor() {

    try {

      if (_objPaletaCor != null) {

        return _objPaletaCor;
      }

      for (PaletaCor objPaletaCor : this.getLstObjPaletaCor()) {

        if (!objPaletaCor.getBooSelecionado()) {

          continue;
        }

        _objPaletaCor = objPaletaCor;
      }

      if (_objPaletaCor == null) {

        _objPaletaCor = new PaletaCor("default");
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objPaletaCor;
  }

  private PrintWriter getObjPrintWriter() {

    return _objPrintWriter;
  }

  protected ServletContext getObjServletContext() {

    try {

      _objServletContext = this.getObjHttpServletRequest().getServletContext();
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objServletContext;
  }

  public Usuario getObjUsuarioAtual() {

    try {

      if (_objUsuarioAtual != null && _objUsuarioAtual.getStrSessaoId() == this.getObjHttpSession().getId()) {

        return _objUsuarioAtual;
      }

      for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {

        if (objUsuario.getStrSessaoId() != this.getObjHttpSession().getId()) {

          continue;
        }

        return _objUsuarioAtual = objUsuario;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _objUsuarioAtual;
  }

  public Usuario getObjUsuarioPorSessaoId(String strSessaoId) {

    try {

      for (Usuario objUsuario : this.getLstObjUsuarioSessao()) {

        if (!objUsuario.getStrSessaoId().equals(strSessaoId)) {

          continue;
        }

        return objUsuario;
      }
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return null;
  }

  public String getStrPagSolicitada() {

    return _strPagSolicitada;
  }

  /**
   * Retorna o valor do par�metro "GET" ou "POST" vindo do cliente indicado pelo
   * nome contido em "strParamNome". Caso n�o exista retorna "null".
   */
  public String getStrParam(String strParamNome) {

    String strResultado = null;

    try {

      strResultado = this.getObjHttpServletRequest().getParameter(strParamNome);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return strResultado;
  }

  public void reencaminhar(String strUrl) {

    try {

      this.getObjHttpServletResponse().sendRedirect(strUrl);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public void responder(HttpServletRequest objRequest, HttpServletResponse objResponse) {

    try {

      this.setObjHttpServletRequest(objRequest);
      this.setObjHttpServletResponse(objResponse);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setI(AppWeb _i) {

    try {

      if (i != null) {

        return;
      }

      i = _i;
    }
    catch (Exception ex) {

      new Erro("Erro ao instanciar objeto do tipo 'AppWeb'.\n", ex);
    }
    finally {
    }
  }

  private void setObjHttpServletRequest(HttpServletRequest objHttpServletRequest) {

    try {

      _objHttpServletRequest = objHttpServletRequest;

      this.setStrPagSolicitada(_objHttpServletRequest.getRequestURI().replace(_objHttpServletRequest.getContextPath() + "/app/", Utils.STR_VAZIA));
      this.setObjHttpSession(_objHttpServletRequest.getSession());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setObjHttpServletResponse(HttpServletResponse objHttpServletResponse) {

    try {

      _objHttpServletResponse = objHttpServletResponse;

      this.setObjPrintWriter(_objHttpServletResponse.getWriter());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  private void setObjHttpSession(HttpSession objHttpSession) {

    Usuario objUsuario;

    try {

      _objHttpSession = objHttpSession;

      if (this.getBooUsuarioExiste(_objHttpSession.getId())) {

        return;
      }

      objUsuario = new Usuario();
      objUsuario.setStrSessaoId(_objHttpSession.getId());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
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
}