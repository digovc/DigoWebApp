package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Campo extends Tag {

	public enum EnmTipo {
		BUTTON, CHECKBOX, COLOR, DATE, DATETIME, DATETIME_LOCAL, EMAIL, FILE, HIDDEN, IMAGE, MONTH, NUMBER, PASSWORD, RADIO, RANGE, RESET, SEARCH, SUBMIT, TEL, TEXT, TEXT_AREA, TIME, URL, WEEK

	}

	// FIM CONSTANTES

	// ATRIBUTOS

	private EnmTipo _enmTipo = EnmTipo.TEXT;

	private String _strId;

	private String _strPlaceHolder;

	public Campo() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTagNome("input");
			this.adicionarCss(CssTag.getCssMainInstancia().addCss("box-sizing",
					"border-box"));
			PaginaHtml.getI().getLstObjJavaScriptTag()
					.add(new JavaScriptTag("res/js/lib/JDigo/html/Campo.js"));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private EnmTipo getEnmTipo() {
		return _enmTipo;
	}

	private String getStrPlaceHolder() {
		return _strPlaceHolder;
	}

	public void setEnmTipo(EnmTipo enmTipo) {
		// VARIÁVEIS

		String strTipo;

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_enmTipo = enmTipo;

			switch (_enmTipo) {
			case BUTTON:
				this.getAtrType().setStrValor("button");
				break;
			case CHECKBOX:
				this.getAtrType().setStrValor("checkbox");
				break;
			case COLOR:
				this.getAtrType().setStrValor("color");
				break;
			case DATE:
				this.getAtrType().setStrValor("date");
				break;
			case DATETIME:
				this.getAtrType().setStrValor("datetime");
				break;
			case DATETIME_LOCAL:
				this.getAtrType().setStrValor("datetime-local");
				break;
			case EMAIL:
				this.getAtrType().setStrValor("email");
				break;
			case FILE:
				this.getAtrType().setStrValor("file");
				break;
			case HIDDEN:
				this.getAtrType().setStrValor("hidden");
				break;
			case IMAGE:
				this.getAtrType().setStrValor("image");
				break;
			case MONTH:
				this.getAtrType().setStrValor("month");
				break;
			case NUMBER:
				this.getAtrType().setStrValor("number");
				break;
			case PASSWORD:
				this.getAtrType().setStrValor("password");
				break;
			case RADIO:
				this.getAtrType().setStrValor("radio");
				break;
			case RANGE:
				this.getAtrType().setStrValor("range");
				break;
			case RESET:
				this.getAtrType().setStrValor("reset");
				break;
			case SEARCH:
				this.getAtrType().setStrValor("search");
				break;
			case SUBMIT:
				this.getAtrType().setStrValor("submit");
				break;
			case TEL:
				this.getAtrType().setStrValor("tel");
				break;
			case TEXT:
				this.getAtrType().setStrValor("text");
				break;
			case TEXT_AREA:
				this.setStrTagNome("textarea");
				this.setBooForcarTagDupla(true);
				this.adicionarAtr("rows", "10");
				break;
			case TIME:
				this.getAtrType().setStrValor("time");
				break;
			case URL:
				this.getAtrType().setStrValor("url");
				break;
			case WEEK:
				this.getAtrType().setStrValor("week");
				break;
			default:
				this.getAtrType().setStrValor("text");
				break;
			}

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	@Override
	public void setStrId(String strId) {

		super.setStrId(strId);

		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_strId = this.getStrId();
			this.getLstAtr().add(new Atributo("name", _strId));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public void setStrPlaceHolder(String strPlaceHolder) {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			_strPlaceHolder = strPlaceHolder;
			this.getLstAtr().add(new Atributo("placeholder", _strPlaceHolder));

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	// FIM CONSTRUTORES

	// MÉTODOS
	// FIM MÉTODOS

	// EVENTOS
	// FIM EVENTOS
}
