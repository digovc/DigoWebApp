package com.digosofter.digowebapp.html;

import com.digosofter.digowebapp.erro.Erro;

public class Campo extends Tag {
	// CONSTANTES

	public enum EnmTipo {
		BUTTON, CHECKBOX, COLOR, DATE, DATETIME, DATETIME_LOCAL, EMAIL, FILE, HIDDEN, IMAGE, MONTH, NUMBER, PASSWORD, RADIO, RANGE, RESET, SEARCH, SUBMIT, TEL, TEXT, TEXT_AREA, TIME, URL, WEEK

	}

	// FIM CONSTANTES

	// ATRIBUTOS

	private EnmTipo _enmTipo = EnmTipo.TEXT;

	private EnmTipo getEnmTipo() {
		return _enmTipo;
	}

	public void setEnmTipo(EnmTipo enmTipo) {
		// VARIÁVEIS

		_enmTipo = enmTipo;

		String strTipo = "text";

		// FIM VARIÁVEIS
		try {
			// AÇÕES

			switch (_enmTipo) {
			case BUTTON:
				strTipo = "button";
				break;
			case CHECKBOX:
				strTipo = "checkbox";
				break;
			case COLOR:
				strTipo = "color";
				break;
			case DATE:
				strTipo = "date";
				break;
			case DATETIME:
				strTipo = "datetime";
				break;
			case DATETIME_LOCAL:
				strTipo = "datetime-local";
				break;
			case EMAIL:
				strTipo = "email";
				break;
			case FILE:
				strTipo = "file";
				break;
			case HIDDEN:
				strTipo = "hidden";
				break;
			case IMAGE:
				strTipo = "image";
				break;
			case MONTH:
				strTipo = "month";
				break;
			case NUMBER:
				strTipo = "number";
				break;
			case PASSWORD:
				strTipo = "password";
				break;
			case RADIO:
				strTipo = "radio";
				break;
			case RANGE:
				strTipo = "range";
				break;
			case RESET:
				strTipo = "reset";
				break;
			case SEARCH:
				strTipo = "search";
				break;
			case SUBMIT:
				strTipo = "submit";
				break;
			case TEL:
				strTipo = "tel";
				break;
			case TEXT:
				strTipo = "text";
				break;
			case TEXT_AREA:
				strTipo = "textarea";
				break;
			case TIME:
				strTipo = "time";
				break;
			case URL:
				strTipo = "url";
				break;
			case WEEK:
				strTipo = "week";
				break;
			default:
				strTipo = "text";
				break;
			}
			this.getAtrType().setStrValor(strTipo);

			// FIM AÇÕES
		} catch (Exception ex) {

			new Erro("Erro inesperado.\n", ex);

		} finally {
		}
	}

	private String _strPlaceHolder;

	private String getStrPlaceHolder() {
		return _strPlaceHolder;
	}

	public void setStrPlaceHolder(String strPlaceHolder) {
		_strPlaceHolder = strPlaceHolder;
		this.getLstAtr().add(new Atributo("placeholder", _strPlaceHolder));
	}

	// FIM ATRIBUTOS

	// CONSTRUTORES

	public Campo() {
		// VARIÁVEIS
		// FIM VARIÁVEIS
		try {
			// AÇÕES

			this.setStrTagNome("input");

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
