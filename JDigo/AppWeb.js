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
    
    
    try {
      

      if (_arrObjPaletaCor == null) {

        _arrObjPaletaCor = new Array();
      }

      
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

  // M�TODO

  this.imprimir = function(pag) {
    

    var objWindow;

    
    try {
      

      objWindow = window.open('', 'my div', 'height=400,width=600');
      objWindow.document.write(pag);
      objWindow.print();
      objWindow.close();

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgAlerta = function(strTitulo, strMensagem) {
    

    var msg;

    
    try {
      

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_ALERTA);
      msg.mostrar();

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgNegativa = function(strTitulo, strMensagem) {
    

    var msg;

    
    try {
      

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_NEGATIVA);
      msg.mostrar();

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrarMsgPositiva = function(strTitulo, strMensagem) {
    

    var msg;

    
    try {
      

      msg = new Mensagem(strTitulo, strMensagem, Mensagem_TIPO_POSITIVA);
      msg.mostrar();

      
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM M�TODO

  /* Construtor */
  {
    
    
    try {
      
      
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
