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

	// M�TODOS
	// FIM M�TODOS

	// EVENTOS

	@Override
	protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest arg1) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return null;
	}

	// FIM EVENTOS
}