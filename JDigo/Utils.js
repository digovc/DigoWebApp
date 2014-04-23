// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function _Utils() {
  // HERAN�A
  // FIM HERAN�A

  // ATRIBUTO

  var _this = this;

  // FIM ATRIBUTO

  // M�TODO

  this.carregarImagem = function(strSrc, evtOnLoad) {
    // VARI�VEIS

    var img;

    // FIM VARI�VEIS
    try {
      // A��ES

      img = new Image;
      img.src = strSrc;
      img.onload = evtOnLoad;

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return img;
  }

  this.getBooStrVazia = function(str) {
    // VARI�VEIS

    var booResultado = false;

    // FIM VARI�VEIS
    try {
      // A��ES

      if (str == null) {
        booResultado = true;
      } else if (str == "") {
        booResultado = true;
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return booResultado;
  }

  this.getBooValidarEmail = function(strEmail) {
    // VARI�VEIS

    var booResultado = false;
    var objRe;

    // FIM VARI�VEIS
    try {
      // A��ES

      objRe = new RegExp(/^[A-Za-z0-9_\-\.]+@[A-Za-z0-9_\-\.]{2,}\.[A-Za-z0-9]{2,}(\.[A-Za-z0-9])?/);

      if (Utils.getBooVazia(strEmail)) {

        booResultado = true;

      } else if (objRe.test(strEmail)) {

        booResultado = true;
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return booResultado;
  }

  this.getStrTamanhoFixo = function(str, intTamanho, chrComplemento, booDireita) {
    // VARI�VEIS

    var intDif;

    // FIM VARI�VEIS
    try {
      // A��ES

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

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return str;
  };

  this.mostrarLstMensagemInformacao = function(lstStrMensagem) {
    // VARI�VEIS

    var strMensagemFormatada = "";

    // FIM VARI�VEIS
    try {
      // A��ES

      strMensagemFormatada = "Informa��o:";
      strMensagemFormatada += "\n\n\n";

      if (lstStrMensagem != null && lstStrMensagem.length > 0) {

        for ( var intIndex in lstStrMensagem) {
          strMensagemFormatada += "\n";
          strMensagemFormatada += lstStrMensagem[intIndex];
        }
      }

      Utils.mostrarMensagemInformacao(strMensagemFormatada)

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

  this.mostrarMensagemInformacao = function(strMensagem) {
    // VARI�VEIS

    var strMensagemFormatada;

    // FIM VARI�VEIS
    try {
      // A��ES

      strMensagemFormatada += strMensagem;

      alert(strMensagemFormatada);

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

  this.replaceAll = function(str, strAntigo, strNovo) {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES

      while (str.indexOf(strAntigo) != -1) {
        str = str.replace(strAntigo, strNovo);
      }

      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }

    return str;
  }

  // FIM M�TODO

  /* Construtor */
  {
    // VARI�VEIS
    // FIM VARI�VEIS
    try {
      // A��ES
      // FIM A��ES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}

// INICIALIZA��O

var Utils;

$(document).ready(function() {

  Utils = new _Utils();

});

// FIM INICIALIZA��O
