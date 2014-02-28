package com.digosofter.digowebapp.websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Usuario;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.websocket.wsobjetos.WsObjetoMain;
import com.google.gson.Gson;

public abstract class WsConexaoMain extends MessageInbound {

	// FIM CONSTANTES

	// ATRIBUTOS

	public static WsConexaoMain getObjWsConexaoMainPeloIntUsuarioId(
			int intUsuarioId) {
		// VARI�VEIS

		WsConexaoMain objConexaoMainResultado = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (WsConexaoMain objConexaoMain : AppWeb.getI()
					.getLstObjWsConexaoMain()) {

				if (objConexaoMain.getObjUsuario().getIntUsuarioId() == intUsuarioId) {

					objConexaoMainResultado = objConexaoMain;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return objConexaoMainResultado;
	}

	private Usuario _objUsuario;

	private WsOutbound _objWsOutbound;

	public WsConexaoMain(String strSessionId) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setObjUsuario(Usuario.getObjUsuarioPelaSessionId(strSessionId));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void enviar(WsObjetoMain objWsObjetoMain) {
		// VARI�VEIS

		Gson objJson;

		// FIM VARI�VEIS
		try {
			// A��ES

			objJson = new Gson();
			this.getObjWsOutbound().writeTextMessage(
					CharBuffer.wrap(objJson.toJson(objWsObjetoMain)));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public Usuario getObjUsuario() {
		return _objUsuario;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	private WsOutbound getObjWsOutbound() {
		return _objWsOutbound;
	}

	// FIM CONSTRUTORES

	// M�TODOS

	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
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

	@Override
	protected void onClose(int status) {

		super.onClose(status);

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			AppWeb.getI().getLstObjWsConexaoMain().remove(this);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM M�TODOS

	// EVENTOS

	@Override
	protected void onOpen(WsOutbound outbound) {

		super.onOpen(outbound);

		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			AppWeb.getI().getLstObjWsConexaoMain().add(this);
			this.setObjWsOutbound(outbound);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	@Override
	protected void onTextMessage(CharBuffer objCharBufferMensagem)
			throws IOException {
		// VARI�VEIS

		String strSessionId = Utils.STRING_VAZIA;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (objCharBufferMensagem.toString().contains("strSessionId")) {

				strSessionId = objCharBufferMensagem.toString();
				strSessionId = strSessionId.replace("strSessionId=",
						Utils.STRING_VAZIA);

				this.setObjUsuario(Usuario
						.getObjUsuarioPelaSessionId(strSessionId));
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private void setObjUsuario(Usuario objUsuario) {
		_objUsuario = objUsuario;
	}

	private void setObjWsOutbound(WsOutbound objWsOutbound) {
		_objWsOutbound = objWsOutbound;
	}

	// FIM EVENTOS
}
