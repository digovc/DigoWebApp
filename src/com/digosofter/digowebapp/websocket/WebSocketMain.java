package com.digosofter.digowebapp.websocket;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

import com.digosofter.digowebapp.erro.Erro;

public abstract class WebSocketMain extends WebSocketServlet {
	// CONSTANTES

	private static final long serialVersionUID = 1L;

	// FIM CONSTANTES

	// ATRIBUTOS
	// FIM ATRIBUTOS

	// CONSTRUTORES
	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS

	@Override
	protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest arg1) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return null;
	}

	// FIM EVENTOS
}
