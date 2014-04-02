// CONSTANTE

var Mensagem_BOO_MENSAGEM_VISIVEL = false;
var Mensagem_ESTRUTURA_INFO_ALERTA = "";
var Mensagem_ESTRUTURA_INFO_NEGATIVA = "";
var Mensagem_ESTRUTURA_INFO_POSITIVA = "";

// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

/**
 *
 */
function Mensagem(strTitulo, strMsg, intTipo) {
  // HERANÇA

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  /**
   * 0 = alerta; 1 = negativa; 2 = positiva.
   */
  var _intTipo = 2;

  this.getIntTipo = function() {
    return _intTipo;
  };

  this.setIntTipo = function(intTipo) {
    _intTipo = intTipo;
  };

  var _strMsg = "";

  this.getStrMsg = function() {
    return _strMsg;
  };

  this.setStrMsg = function(strMsg) {
    _strMsg = strMsg;
  };

  var _strTitulo = "";

  this.getStrTitulo = function() {
    return _strTitulo;
  };

  this.setStrTitulo = function(strTitulo) {
    _strTitulo = strTitulo;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.montarLayout = function() {
    // VARIÁVEIS

    var tag;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      switch (this.getIntTipo()) {

      case 0: // Alerta
        tag = Mensagem_ESTRUTURA_INFO_ALERTA;
        break;

      case 1: // Negativa
        tag = Mensagem_ESTRUTURA_INFO_NEGATIVA;
        break;

      case 2: // Positiva
        tag = Mensagem_ESTRUTURA_INFO_POSITIVA;
        break;

      default:
        tag = Mensagem_ESTRUTURA_INFO_POSITIVA;
        break;
      }

      tag = tag.replace("_titulo", this.getStrTitulo());
      tag = tag.replace("_msg", this.getStrMsg());

      this.setStrEstrutura(tag);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  this.mostrar = function() {
    // VARIÁVEIS

    var intTempo;
    var tag;

    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (Mensagem_BOO_MENSAGEM_VISIVEL) {

        window.setTimeout(function() {
          _this.mostrar();
        }, 250);

        return false;
      }

      tag = this.toHtml();
      intTempo = this.getStrMsg().length * 75;
      $("body").append(tag);
      Mensagem_BOO_MENSAGEM_VISIVEL = true;

      window.setTimeout(function() {

        $(document).find("#msg").fadeOut("slow");

        window.setTimeout(function() {

          $(document).find("#msg").remove();
          Mensagem_BOO_MENSAGEM_VISIVEL = false;

        }, 250);
      }, intTempo);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */{
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.setIntTipo(intTipo);
      this.setStrTitulo(strTitulo);
      this.setStrMsg(strMsg);

      // FIM AÇÕES
    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}