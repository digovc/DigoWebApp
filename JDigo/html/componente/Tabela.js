// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

function Tabela(strId) {
  // HERANÇA

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _fncLinhaClick = null;

  this.getFncLinhaClick = function() {

    try {

      if (_fncLinhaClick != null) {

        return _fncLinhaClick;
      }

      _fncLinhaClick = function(evt) {

        var strRegistroId;
        var url;

        try {

          strRegistroId = $($(evt.currentTarget).find("td")[0]).html();

          url = "_url_atual?id=_registro_id";

          url = url.replace("_url_atual", window.location.href);
          url = url.replace("_registro_id", strRegistroId);

          window.location.href = url;

        } catch (e) {

          new Erro("Erro inesperado.", e);
        } finally {
        }
      }
    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }

    return _fncLinhaClick;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.setEventos = function() {

    try {

      _this.getJq().find("tr").click(this.getFncLinhaClick());

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.setOrdenacao = function() {

    try {

      this.getJq().find('table').tablesorter();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.setPesquisa = function() {

    try {

      if ('quicksearch' in $('document')) {

        this.getJq().find("input").quicksearch('#' + this.getStrId() + ' table tbody tr');
      }
    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */{

    try {

      _this.setStrId(strId);
      _this.setPesquisa();
      _this.setOrdenacao();
      _this.setEventos();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  }

}