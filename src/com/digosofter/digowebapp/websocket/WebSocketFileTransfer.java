package com.digosofter.digowebapp.websocket;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.digosofter.digowebapp.erro.Erro;

@ServerEndpoint("/ws/ws_file_transfer")
public class WebSocketFileTransfer extends WebSocketMain {

  private List<ObjWsFileTransfer> _lstObjWsFileTransfer;

  private List<ObjWsFileTransfer> getLstObjWsFileTransfer() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_lstObjWsFileTransfer == null) {

        _lstObjWsFileTransfer = new ArrayList<ObjWsFileTransfer>();
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _lstObjWsFileTransfer;
  }

  /**
   * Retorna a instância do "ObjWsFileTransfer" referente a sessão passada como
   * parâmetro.
   */
  private ObjWsFileTransfer getObjWsFileTransfer(Session objSession) {
    // VARIÁVEIS

    ObjWsFileTransfer wftResultado = null;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      for (ObjWsFileTransfer wft : this.getLstObjWsFileTransfer()) {

        if (wft.getObjSession() == objSession) {

          wftResultado = wft;
          return wftResultado;
        }
      }

      wftResultado = new ObjWsFileTransfer(objSession);
      this.getLstObjWsFileTransfer().add(wftResultado);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return wftResultado;
  }

  @OnClose
  @Override
  public void onClose(Session objSession, CloseReason objCloseReason) {
    // VARIÁVEIS

    ObjWsFileTransfer wft;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      wft = this.getObjWsFileTransfer(objSession);
      wft.salvar();

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnMessage
  @Override
  public void onMessage(Session objSession, String strMensagem) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      // if (!this.verificarUsuarioLogado(objSession)) {
      //
      // return;
      // }

      if (strMensagem.contains("AUTH")) {

        this.processarMsgAuth(objSession);

      } else if (strMensagem.contains("STOR")) {

        this.processarMsgStor(objSession, strMensagem);
      } else{

        this.processarData(objSession, strMensagem);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  @OnOpen
  @Override
  public void onOpen(Session objSession, EndpointConfig objEndpointConfig) {

    super.onOpen(objSession, objEndpointConfig);

  }

  private void processarData(Session objSession, String strMensagem) {
    // VARIÁVEIS

    ObjWsFileTransfer wft;
    int intTamanho;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      wft = this.getObjWsFileTransfer(objSession);
      intTamanho = wft.addBytes(strMensagem);
      objSession.getBasicRemote().sendText(
          "{ 'type': 'DATA', 'code': 200, 'bytesRead': " + intTamanho + " }");

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void processarMsgAuth(Session objSession) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objSession.getBasicRemote().sendText(
          "{ 'type': 'AUTH', 'message': 'Authentification success', 'code': 200 }");

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  private void processarMsgStor(Session objSession, String strMensagem) {
    // VARIÁVEIS

    ObjWsFileTransfer wft;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      wft = this.getObjWsFileTransfer(objSession);
      wft.setStrJsonStor(strMensagem);

      objSession.getBasicRemote().sendText(
          "{ 'type': 'STOR', 'message': 'Upload initialized. Wait for data', 'code': 200 }");

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

}
