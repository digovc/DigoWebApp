// CONSTANTE
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
      _strMensagemFormatada += _this.getStrMensagem();

      if (_this.getStrMensagemTecnica() != "") {

        _strMensagemFormatada += "\n\n\n"
        _strMensagemFormatada += "Detalhes:"
        _strMensagemFormatada += "\n\n"
        _strMensagemFormatada += _this.getStrMensagemTecnica();
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

      _this.setStrMensagem(strMensagem);

      if (e != null) {
        _this.setStrMensagemTecnica(e.message)
      }

      alert(_this.getStrMensagemFormatada());

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}