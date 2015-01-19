﻿// CONSTANTE
// ATRIBUTOS GLOBAIS
// CLASSE
function Erro(strMensagem, e) {
  // HERANÇA

  Objeto.apply(this);

  // ATRIBUTO

  var _this = this;

  var _strMensagem = "Erro inesperado.";

  this.getStrMensagem = function() {
    return _strMensagem;
  }

  this.setStrMensagem = function(strMensagem) {
    _strMensagem = strMensagem;
  }

  var _strMensagemFormatada;

  this.getStrMensagemFormatada = function() {

    try {


      _strMensagemFormatada = "";
      _strMensagemFormatada += this.getStrMensagem();

      if (this.getStrMensagemTecnica() != "") {

        _strMensagemFormatada += "\n\n\n"
        _strMensagemFormatada += "Detalhes:"
        _strMensagemFormatada += "\n\n"
        _strMensagemFormatada += this.getStrMensagemTecnica();
      }

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _strMensagemFormatada;
  }

  var _strMensagemTecnica = "<Sem detalhes>";

  this.getStrMensagemTecnica = function() {
    return _strMensagemTecnica;
  }

  this.setStrMensagemTecnica = function(strMensagemTecnica) {
    _strMensagemTecnica = strMensagemTecnica;
  }

  // MÉTODO

  /* Construtor */
  {


    try {


      this.setStrMensagem(strMensagem);

      if (e != null) {
        this.setStrMensagemTecnica(e.message)
      }

      alert(this.getStrMensagemFormatada());


    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}