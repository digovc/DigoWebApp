// CONSTANTE
// FIM CONSTANTE
// ATRIBUTOS GLOBAIS
// FIM ATRIBUTOS GLOBAIS
// CLASSE

function Tabela(strId, booClick) {
  // HERANÇA

  ComponenteMain.apply(this);
  Tag.apply(this);
  Objeto.apply(this);

  // FIM HERANÇA

  // ATRIBUTO

  var _this = this;

  var _booClick = true;

  this.getBooClick = function() {
    return _booClick;
  };

  this.setBooClick = function(booClick) {
    _booClick = booClick;
  };

  // FIM ATRIBUTO

  // MÉTODO

  this.evtLinhaClick = function(evt) {

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
  };

  this.evtLinhaMouseEnter = function(evt) {

    try {

      if (evt == null) {

        return;
      }

      if (evt.target == null) {

        return;
      }

      if (evt.target.parentElement == null) {

        return;
      }

      $(evt.target.parentElement).css("background-color", "rgb(228, 228, 228)");

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.evtLinhaMouseLeave = function(evt) {

    try {

      if (evt == null) {

        return;
      }

      if (evt.target == null) {

        return;
      }

      if (evt.target.parentElement == null) {

        return;
      }

      $(evt.target.parentElement).css("background-color", "");

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.setEventos = function() {

    try {

      if (_this.getBooClick()) {

        _this.getJq().find("tr").click(_this.evtLinhaClick);
      }

      _this.getJq().find("tr").mouseenter(_this.evtLinhaMouseEnter);
      _this.getJq().find("tr").mouseleave(_this.evtLinhaMouseLeave);

    } catch (e) {

      new Erro("Erro inesperado.", e);
    } finally {
    }
  };

  this.setOrdenacao = function() {

    try {

      _this.getJq().find('table').tablesorter();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  this.setPesquisa = function() {

    try {

      if ('quicksearch' in $('document')) {

        _this.getJq().find("input").quicksearch('#' + _this.getStrId() + ' table tbody tr');
      }
    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  };

  // FIM MÉTODO

  /* Construtor */{

    try {

      _this.setStrId(strId);
      _this.setBooClick(booClick);
      _this.setPesquisa();
      _this.setOrdenacao();
      _this.setEventos();

    } catch (e) {

      new Erro("Erro inesperado.", e);
    }
  }

}