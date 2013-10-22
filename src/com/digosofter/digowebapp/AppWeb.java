package com.digosofter.digowebapp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digosofter.digowebapp.erro.Erro;

public abstract class AppWeb extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private static AppWeb _appWebInstancia;

	private static AppWeb getAppWebInstancia() {
		return _appWebInstancia;
	}

	private static void setAppWebInstancia(AppWeb appWebInstancia) {
		_appWebInstancia = appWebInstancia;
	}

	private List<Usuario> _lstUsuarioSessao = new ArrayList<Usuario>();

	public List<Usuario> getLstUsuarioSessao() {
		return _lstUsuarioSessao;
	}

	private HttpServletRequest _objHttpServletRequest;

	private HttpServletRequest getObjHttpServletRequest() {
		return _objHttpServletRequest;
	}

	public void setObjHttpServletRequest(HttpServletRequest objHttpServletRequest) {
		// VARI�VEIS

		_objHttpServletRequest = objHttpServletRequest;

		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI().replace("/relatar/app/", Utils.STRING_VAZIA));
			this.setObjHttpSession(this.getObjHttpServletRequest().getSession());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private HttpServletResponse _objHttpServletResponse;

	private HttpServletResponse getObjHttpServletResponse() {
		return _objHttpServletResponse;
	}

	public void setObjHttpServletResponse(HttpServletResponse objHttpServletResponse) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			_objHttpServletResponse = objHttpServletResponse;
			this.setObjPrintWriter(_objHttpServletResponse.getWriter());

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private HttpSession _objHttpSession;

	private HttpSession getObjHttpSession() {
		return _objHttpSession;
	}

	private void setObjHttpSession(HttpSession objHttpSession) {
		// VARI�VEIS

		_objHttpSession = objHttpSession;
		Usuario objUsuario = null;

		// FIM VARI�VEIS
		try {
			// A��ES

			if (!this.getBooUsuarioExiste(_objHttpSession.getId())) {
				objUsuario = new Usuario();
				objUsuario.setStrSessaoId(_objHttpSession.getId());
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private PrintWriter _objPrintWriter;

	private PrintWriter getObjPrintWriter() {
		return _objPrintWriter;
	}

	public void setObjPrintWriter(PrintWriter objPrintWriter) {
		_objPrintWriter = objPrintWriter;
	}

	private String _strPaginaSolicitada;

	public String getStrPaginaSolicitada() {
		return _strPaginaSolicitada;
	}

	private void setStrPaginaSolicitada(String strPaginaSolicitada) {
		_strPaginaSolicitada = strPaginaSolicitada;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public AppWeb(String strAppNome) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			AppWeb.setAppWebInstancia(this);
			this.setStrNome(strAppNome);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	public void escreveStrHtmlResposta(String strHtml) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.getObjPrintWriter().print(strHtml);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public boolean getBooUsuarioExiste(String strSessaoId) {
		// VARI�VEIS

		boolean booUsuarioExisteResultado = false;

		// FIM VARI�VEIS
		try {
			// A��ES

			for (Usuario usuario : this.getLstUsuarioSessao()) {
				if (usuario.getStrSessaoId().equals(strSessaoId)) {
					booUsuarioExisteResultado = true;
					break;
				}
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return booUsuarioExisteResultado;
	}

	public static AppWeb getInstancia() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES
			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return AppWeb.getAppWebInstancia();
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
