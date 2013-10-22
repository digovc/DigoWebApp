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
		// VARIÁVEIS

		_objHttpServletRequest = objHttpServletRequest;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI().replace("/relatar/app/", Utils.STRING_VAZIA));
			this.setObjHttpSession(this.getObjHttpServletRequest().getSession());

			// FIM AÇÕES
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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_objHttpServletResponse = objHttpServletResponse;
			this.setObjPrintWriter(_objHttpServletResponse.getWriter());

			// FIM AÇÕES
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
		// VARIÁVEIS

		_objHttpSession = objHttpSession;
		Usuario objUsuario = null;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			if (!this.getBooUsuarioExiste(_objHttpSession.getId())) {
				objUsuario = new Usuario();
				objUsuario.setStrSessaoId(_objHttpSession.getId());
			}

			// FIM AÇÕES
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
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			AppWeb.setAppWebInstancia(this);
			this.setStrNome(strAppNome);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS

	public void escreveStrHtmlResposta(String strHtml) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.getObjPrintWriter().print(strHtml);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	public boolean getBooUsuarioExiste(String strSessaoId) {
		// VARIÁVEIS

		boolean booUsuarioExisteResultado = false;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			for (Usuario usuario : this.getLstUsuarioSessao()) {
				if (usuario.getStrSessaoId().equals(strSessaoId)) {
					booUsuarioExisteResultado = true;
					break;
				}
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return booUsuarioExisteResultado;
	}

	public static AppWeb getInstancia() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES
			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
		return AppWeb.getAppWebInstancia();
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
