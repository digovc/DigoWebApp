package com.digosofter.digowebapp.design;

import com.digosofter.digowebapp.AppWeb;
import com.digosofter.digowebapp.Objeto;
import com.digosofter.digowebapp.Utils;
import com.digosofter.digowebapp.erro.Erro;
import com.digosofter.digowebapp.html.JavaScriptTag;
import com.digosofter.digowebapp.html.PaginaHtml;

public class PaletaCor extends Objeto {
	// CONSTANTES
	// FIM CONSTANTES

	// ATRIBUTOS

	private boolean _booSelecionado;

	public boolean getBooSelecionado() {
		return _booSelecionado;
	}

	public void setBooSelecionado(boolean booSelecionado) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_booSelecionado) {
				for (PaletaCor objPaletaCor : AppWeb.getI().getLstObjPaletaCor()) {
					objPaletaCor.setBooSelecionado(false);
				}
			} else {
				AppWeb.getI().getLstObjPaletaCor().get(0).setBooSelecionado(true);
			}

			_booSelecionado = booSelecionado;

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strCorControleClicado;

	private String getStrCorControleClicado() {
		return _strCorControleClicado;
	}

	public void setStrCorControleClicado(String strCorControleClicado) {
		// VARI�VEIS

		String strJs;

		// FIM VARI�VEIS
		try {
			// A��ES

			_strCorControleClicado = strCorControleClicado;
			strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorControleClicado('" + _strCorControleClicado + "');";
			this.addJs(strJs);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strCorControleMouse;

	private String getStrCorControleMouse() {
		return _strCorControleMouse;
	}

	public void setStrCorControleMouse(String strCorControleMouse) {
		// VARI�VEIS

		String strJs;

		// FIM VARI�VEIS
		try {
			// A��ES

			_strCorControleMouse = strCorControleMouse;
			strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorControleMouse('" + _strCorControleMouse + "');";
			this.addJs(strJs);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strCorControleNormal;

	private String getStrCorControleNormal() {
		return _strCorControleNormal;
	}

	public void setStrCorControleNormal(String strCorControleNormal) {
		// VARI�VEIS

		String strJs;

		// FIM VARI�VEIS
		try {
			// A��ES

			_strCorControleNormal = strCorControleNormal;
			strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorControleNormal('" + _strCorControleNormal + "');";
			this.addJs(strJs);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strCorFundo;

	private String getStrCorFundo() {
		return _strCorFundo;
	}

	public void setStrCorFundo(String strCorFundo) {
		// VARI�VEIS

		String strJs;

		// FIM VARI�VEIS
		try {
			// A��ES

			_strCorFundo = strCorFundo;
			strJs = this.getStrObjetoJavaScriptNome() + ".setStrCorFundo('" + _strCorFundo + "');";
			this.addJs(strJs);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strObjetoJavaScriptNome = "";

	private String getStrObjetoJavaScriptNome() {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			if (_strObjetoJavaScriptNome == "") {
				_strObjetoJavaScriptNome = "objPaletaCor" + this.getStrNome();
			}

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}

		return _strObjetoJavaScriptNome;
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public PaletaCor(String strNome) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			this.setStrNome(strNome);
			this.addJs("var " + this.getStrObjetoJavaScriptNome() + "= new PaletaCor('" + this.getStrNome() + "');");
			PaginaHtml.getI().getLstObjJavaScriptTag().add(new JavaScriptTag("res/lib/DigoWebAppLib/js/design/PaletaCor.js"));

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// M�TODOS

	private void addJs(String strJs) {
		// VARI�VEIS
		// FIM VARI�VEIS
		try {
			// A��ES

			PaginaHtml.getI().adicionarJsCodigo(strJs);

			// FIM A��ES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM M�TODOS

	// EVENTOS
	// FIM EVENTOS
}
