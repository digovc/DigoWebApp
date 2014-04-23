// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function _Utils() {
  // HERANÇA
  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  // FIM ATRIBUTO

  // MÉTODO

  this.carregarImagem = function(strSrc, evtOnLoad) {
    // VARIÁVEIS

    var img;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      img = new Image;
      img.src = strSrc;
      img.onload = evtOnLoad;

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return img;
  }

  this.getBooStrVazia = function(str) {
    // VARIÁVEIS

    var booResultado = false;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (str == null) {
        booResultado = true;
      } else if (str == "") {
        booResultado = true;
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return booResultado;
  }

  this.getBooValidarEmail = function(strEmail) {
    // VARIÁVEIS

    var booResultado = false;
    var objRe;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      objRe = new RegExp(/^[A-Za-z0-9_\-\.]+@[A-Za-z0-9_\-\.]{2,}\.[A-Za-z0-9]{2,}(\.[A-Za-z0-9])?/);

      if (Utils.getBooVazia(strEmail)) {

        booResultado = true;

      } else if (objRe.test(strEmail)) {

        booResultado = true;
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return booResultado;
  }

  this.getStrTamanhoFixo = function(str, intTamanho, chrComplemento, booDireita) {
    // VARIÁVEIS

    var intDif;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      str = String(str);

      if (str.length > intTamanho) {
        str = str.substring(intTamanho, 0);
        return str;
      }

      if (str.length < intTamanho) {
        intDif = intTamanho - str.length;

        while (true) {

          if (booDireita) {
            str = str + chrComplemento.substring(1, 0);
          } else {
            str = chrComplemento.substring(1, 0) + str;
          }

          if (str.length == intTamanho) {
            return str;
          }
        }
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return str;
  };

  this.mostrarLstMensagemInformacao = function(lstStrMensagem) {
    // VARIÁVEIS

    var strMensagemFormatada = "";

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strMensagemFormatada = "Informação:";
      strMensagemFormatada += "\n\n\n";

      if (lstStrMensagem != null && lstStrMensagem.length > 0) {

        for ( var intIndex in lstStrMensagem) {
          strMensagemFormatada += "\n";
          strMensagemFormatada += lstStrMensagem[intIndex];
        }
      }

      Utils.mostrarMensagemInformacao(strMensagemFormatada)

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

  this.mostrarMensagemInformacao = function(strMensagem) {
    // VARIÁVEIS

    var strMensagemFormatada;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      strMensagemFormatada += strMensagem;

      alert(strMensagemFormatada);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

  this.replaceAll = function(str, strAntigo, strNovo) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      while (str.indexOf(strAntigo) != -1) {
        str = str.replace(strAntigo, strNovo);
      }

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return str;
  }

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

var Utils;

$(document).ready(function() {

  Utils = new _Utils();

});

// FIM INICIALIZAÇÃO
