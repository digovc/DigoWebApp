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
		// VARIÁVEIS

		WsConexaoMain objConexaoMainResultado = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (WsConexaoMain objConexaoMain : AppWeb.getI()
					.getLstObjWsConexaoMain()) {

				if (objConexaoMain.getObjUsuario().getIntUsuarioId() == intUsuarioId) {

					objConexaoMainResultado = objConexaoMain;
					break;
				}
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return objConexaoMainResultado;
	}

	private Usuario _objUsuario;

	private WsOutbound _objWsOutbound;

	public WsConexaoMain(String strSessionId) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setObjUsuario(Usuario.getObjUsuarioPelaSessionId(strSessionId));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public void enviar(WsObjetoMain objWsObjetoMain) {
		// VARIÁVEIS

		Gson objJson;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			objJson = new Gson();
			this.getObjWsOutbound().writeTextMessage(
					CharBuffer.wrap(objJson.toJson(objWsObjetoMain)));

			// FIM AÇÕES
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

	// MÉTODOS

	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
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

	@Override
	protected void onClose(int status) {

		super.onClose(status);

		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			AppWeb.getI().getLstObjWsConexaoMain().remove(this);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM MÉTODOS

	// EVENTOS

	@Override
	protected void onOpen(WsOutbound outbound) {

		super.onOpen(outbound);

		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			AppWeb.getI().getLstObjWsConexaoMain().add(this);
			this.setObjWsOutbound(outbound);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	@Override
	protected void onTextMessage(CharBuffer objCharBufferMensagem)
			throws IOException {
		// VARIÁVEIS

		String strSessionId = Utils.STRING_VAZIA;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (objCharBufferMensagem.toString().contains("strSessionId")) {

				strSessionId = objCharBufferMensagem.toString();
				strSessionId = strSessionId.replace("strSessionId=",
						Utils.STRING_VAZIA);

				this.setObjUsuario(Usuario
						.getObjUsuarioPelaSessionId(strSessionId));
			}

			// FIM AÇÕES
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
