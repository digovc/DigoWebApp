package com.digosofter.digowebapp.websocket;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.tomcat.websocket.WsSession;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Usuario;
import com.digosofter.digowebapp.erro.Erro;
import com.google.gson.Gson;

@ServerEndpoint("/ws/ws_main")
public class WebSocketMain {

  /**
   * Retorna o usu�rio referente a sess�o passada como par�metro.
   */
  protected Usuario getObjUsuarioPorSession(Session objSession) {
    // VARI�VEIS

    Usuario objUsuarioResultado = null;
    String strSessaoId;

    // FIM VARI�VEIS
    try {
      // A��ES

      strSessaoId = ((WsSession) objSession).getHttpSessionId();
      objUsuarioResultado = AppWeb.getI().getObjUsuarioPorSessaoId(strSessaoId);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return objUsuarioResultado;
  }

  /**
   * Processa a mensagem vinda do cliente.
   */
  private void processarMensagem(Session objSession,String strMensagem) {
    // VARI�VEIS

    Gson objGson;
    ObjWsInterlocutor objWsInterlocutor;

    // FIM VARI�VEIS
    try {
      // A��ES

      objGson = new Gson();
      objWsInterlocutor = objGson.fromJson(strMensagem, ObjWsInterlocutor.class);
      this.onObjWsMainRecebido(objSession, objWsInterlocutor);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnClose
  public void onClose(Session session, CloseReason closeReason) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES
      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnMessage
  public String onMessage(Session objSession,String strMensagem) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      this.processarMensagem(objSession,strMensagem);

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strMensagem;
  }

  /**
   * Envia o "ObjWsInterlocutor" para o cliente associado a sess�o indicada no
   * objeto "Session" passado como par�metro.
   */
  protected void enviar(Session objSession, ObjWsInterlocutor objWsInterlocutor) {
    // VARI�VEIS

    Gson objGson;

    // FIM VARI�VEIS
    try {
      // A��ES

      objGson = new Gson();
      objSession.getBasicRemote().sendText(objGson.toJson(objWsInterlocutor));

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * M�todo disparado a cada solicita��o vinda do cliente contendo um
   * "ObjWsMain".
   */
  protected void onObjWsMainRecebido(Session objSession,ObjWsInterlocutor objWsMain) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnOpen
  public void onOpen(Session objSession, EndpointConfig objEndpointConfig) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES
      // FIM A��ES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
