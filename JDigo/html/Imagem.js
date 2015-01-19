/**
 *
 */
function Imagem(strId) {
  // HERANÇA

  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  // FIM ATRIBUTO

  // MÉTODO

  this.setObjImage = function(objImage) {

    try {

      _this.getJq().attr("src", objImage.src)

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

  // FIM MÉTODO

  /* Construtor */
  {

    try {

      _this.setStrId(strId);

    } catch (e) {
      new Erro("Erro inesperado.", e);
    }
  }

}