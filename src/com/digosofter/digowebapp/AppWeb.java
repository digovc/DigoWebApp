package com.digosofter.digowebapp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

			this.setStrPaginaSolicitada(_objHttpServletRequest.getRequestURI().replace("/relatar/", Utils.STRING_VAZIA));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex.getMessage());

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

			new Erro("Erro inesperado.\n", ex.getMessage());

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

			new Erro("Erro inesperado.\n", ex.getMessage());

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

			new Erro("Erro inesperado.\n", ex.getMessage());

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

			new Erro("Erro inesperado.\n", ex.getMessage());

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

			new Erro("Erro inesperado.\n", ex.getMessage());

		} finally {
		}
		return AppWeb.getAppWebInstancia();
	}

	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
