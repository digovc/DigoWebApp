package com.digosofter.digowebapp.websocket;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.tomcat.websocket.WsSession;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Usuario;
import com.google.gson.Gson;

@ServerEndpoint("/ws/ws_main")
public abstract class WebSocketMain {

  public static final int FNC_MSG_ERRO = 70000;
  public static final int FNC_MSG_POSITIVA = 701000;

  /**
   * Envia o "ObjWsInterlocutor" para o cliente associado a sessão indicada no
   * objeto "Session" passado como parâmetro.
   */
  protected void enviar(Session objSession, ObjWsInterlocutor objWsInterlocutor) {

    Gson objGson;

    try {

      objGson = new Gson();
      objSession.getBasicRemote().sendText(objGson.toJson(objWsInterlocutor));

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  protected void enviarMsgErro(Session objSession, String strMsg) {

    ObjWsInterlocutor objWsInterlocutor;

    try {

      objWsInterlocutor = new ObjWsInterlocutor();
      objWsInterlocutor.setIntFuncId(FNC_MSG_ERRO);
      objWsInterlocutor.setStrJson(strMsg);

      this.enviar(objSession, objWsInterlocutor);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  protected void enviarMsgPositiva(Session objSession, String strMsg) {

    ObjWsInterlocutor objWsInterlocutor;

    try {

      objWsInterlocutor = new ObjWsInterlocutor();
      objWsInterlocutor.setIntFuncId(FNC_MSG_POSITIVA);
      objWsInterlocutor.setStrJson(strMsg);

      this.enviar(objSession, objWsInterlocutor);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Retorna o usuário referente a sessão passada como parâmetro.
   */
  protected Usuario getObjUsuarioPorSession(Session objSession) {

    Usuario objUsuarioResultado = null;
    String strSessaoId;

    try {

      strSessaoId = ((WsSession) objSession).getHttpSessionId();
      objUsuarioResultado = AppWeb.getI().getObjUsuarioPorSessaoId(strSessaoId);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return objUsuarioResultado;
  }

  @OnClose
  public void onClose(Session session, CloseReason closeReason) {

    try {

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  @OnMessage
  public void onMessage(Session objSession, String strMensagem) {

    try {

      this.processarMensagem(objSession, strMensagem);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Método disparado a cada solicitação vinda do cliente contendo um
   * "ObjWsMain".
   */
  protected void onObjWsMainRecebido(Session objSession, ObjWsInterlocutor objWsMain) {

    try {

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  @OnOpen
  public void onOpen(Session objSession, EndpointConfig objEndpointConfig) {

    try {

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Processa a mensagem vinda do cliente.
   */
  private void processarMensagem(Session objSession, String strMensagem) {

    Gson objGson;
    ObjWsInterlocutor objWsInterlocutor;

    try {

      objGson = new Gson();
      objWsInterlocutor = objGson.fromJson(strMensagem, ObjWsInterlocutor.class);
      this.onObjWsMainRecebido(objSession, objWsInterlocutor);

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  /**
   * Verifica se o usuário atrelado ao objeto "Session" está "logado" no
   * sistema.
   */
  protected boolean verificarUsuarioLogado(Session objSession) {

    boolean booResultado = false;
    Usuario objUsuario;

    try {

      objUsuario = this.getObjUsuarioPorSession(objSession);

      booResultado = objUsuario.getBooLogado();

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return booResultado;
  }

}
