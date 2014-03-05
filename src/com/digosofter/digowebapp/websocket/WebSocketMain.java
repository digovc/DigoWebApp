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
   * Retorna o usuário referente a sessão passada como parâmetro.
   */
  protected Usuario getObjUsuarioPorSession(Session objSession) {
    // VARIÁVEIS

    Usuario objUsuarioResultado = null;
    String strSessaoId;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strSessaoId = ((WsSession) objSession).getHttpSessionId();
      objUsuarioResultado = AppWeb.getI().getObjUsuarioPorSessaoId(strSessaoId);

      // FIM AÇÕES
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
    // VARIÁVEIS

    Gson objGson;
    ObjWsInterlocutor objWsInterlocutor;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objGson = new Gson();
      objWsInterlocutor = objGson.fromJson(strMensagem, ObjWsInterlocutor.class);
      this.onObjWsMainRecebido(objSession, objWsInterlocutor);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnClose
  public void onClose(Session session, CloseReason closeReason) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES
      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnMessage
  public String onMessage(Session objSession,String strMensagem) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.processarMensagem(objSession,strMensagem);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return strMensagem;
  }

  /**
   * Envia o "ObjWsInterlocutor" para o cliente associado a sessão indicada no
   * objeto "Session" passado como parâmetro.
   */
  protected void enviar(Session objSession, ObjWsInterlocutor objWsInterlocutor) {
    // VARIÁVEIS

    Gson objGson;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objGson = new Gson();
      objSession.getBasicRemote().sendText(objGson.toJson(objWsInterlocutor));

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  /**
   * Método disparado a cada solicitação vinda do cliente contendo um
   * "ObjWsMain".
   */
  protected void onObjWsMainRecebido(Session objSession,ObjWsInterlocutor objWsMain) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnOpen
  public void onOpen(Session objSession, EndpointConfig objEndpointConfig) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES
      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
