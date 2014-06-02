// CONSTANTE
// FIM CONSTANTE

// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS

// CLASSE
function AppWeb() {
  // HERANÇA

  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _arrObjPaletaCor = null;

  this.getArrObjPaletaCor = function() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_arrObjPaletaCor == null) {

        _arrObjPaletaCor = new Array();
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return _arrObjPaletaCor;
  }

  var _intPaletaCorSelecionada = 0;

  this.getIntPaletaCorSelecionada = function() {

    return _intPaletaCorSelecionada;

  }

  this.setIntPaletaCorSelecionada = function(intPaletaCorSelecionada) {

    _intPaletaCorSelecionada = intPaletaCorSelecionada;

  }

  var _strSessionId;

  this.getStrSessionId = function() {

    return _strSessionId;

  }

  this.setStrSessionId = function(strSessionId) {

    _strSessionId = strSessionId;

  }

  // FIM ATRIBUTO

  // MÉTODO

  this.imprimir = function(pag) {
    // VARIÁVEIS

    var objWindow;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objWindow = window.open('', 'my div', 'height=400,width=600');
      objWindow.document.write(pag);
      objWindow.print();
      objWindow.close();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgAlerta = function(strTitulo, strMensagem) {
    // VARIÁVEIS

    var msg;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_ALERTA);
      msg.mostrar();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgNegativa = function(strTitulo, strMensagem) {
    // VARIÁVEIS

    var msg;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_NEGATIVA);
      msg.mostrar();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgPositiva = function(strTitulo, strMensagem) {
    // VARIÁVEIS

    var msg;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_POSITIVA);
      msg.mostrar();

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */
  {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES
      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}

// INICIALIZAÇÃO

var appWeb;

$(document).ready(function() {

  appWeb = new AppWeb();

});

// FIM INICIALIZAÇÃO
