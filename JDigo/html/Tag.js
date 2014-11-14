﻿// CONSTANTE// FIM CONSTANTE// ATRIBUTOS GLOBAIS// FIM ATRIBUTOS GLOBAIS// CLASSEfunction Tag(strId) {  // HERANÇA  Objeto.apply(this);  // FIM HERANÇA  // ATRIBUTO  var _this = this;  var _booVisivel = true;  this.getBooVisivel = function() {    try {      _booVisivel = _this.getJq().is(':visible');    } catch (e) {      new Erro("Erro inesperado.", e);    }    return _booVisivel;  }  this.setBooVisivel = function(booVisivel) {    try {      _booVisivel = booVisivel;      if (_booVisivel) {        _this.getJq().fadeIn();      } else {        _this.getJq().fadeOut();      }    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  var _fncOnChange;  this.getFncOnChange = function() {    return _fncOnChange;  };  this.setFncOnChange = function(fncOnChange) {    try {      _fncOnChange = fncOnChange;      _this.getJq().change(_fncOnChange);    } catch (e) {      new Erro("Erro inesperado.", e);    }  };  this.change = function(fncOnChange) {    try {      _this.setFncOnChange(fncOnChange);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  var _fncOnClick;  this.getFncOnClick = function() {    return _fncOnClick;  }  this.setFncOnClick = function(fncOnClick) {    try {      _fncOnClick = fncOnClick;      _this.getJq().click(_fncOnClick);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.click = function(fncOnClick) {    try {      _this.setFncOnClick(fncOnClick);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  var _fncKeyDown;  this.getFncKeyDown = function() {    return _fncKeyDown;  }  this.setFncKeyDown = function(fncKeyDown) {    try {      _fncKeyDown = fncKeyDown;      _this.getJq().keydown(_fncKeyDown);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.keyDown = function(fncKeyDown) {    try {      _this.setFncKeyDown(fncKeyDown);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  var _fncKeyPress;  this.getFncKeyPress = function() {    return _fncKeyPress;  }  this.setFncKeyPress = function(fncKeyPress) {    try {      _fncKeyPress = fncKeyPress;      _this.getJq().keypress(_fncKeyPress);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.keyPress = function(fncKeyPress) {    try {      _this.setFncKeyPress(fncKeyPress);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  var _fncKeyUp;  this.getFncKeyUp = function() {    return _fncKeyUp;  }  this.setFncKeyUp = function(fncKeyUp) {    try {      _fncKeyUp = fncKeyUp;      _this.getJq().keyup(_fncKeyUp);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.keyUp = function(fncKeyUp) {    try {      _this.setFncKeyUp(fncKeyUp);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  var _jq;  this.getJq = function() {    try {      _jq = $("#" + _this.getStrId());    } catch (e) {      new Erro("Erro inesperado.", e);    }    return _jq;  }  var _strEstrutura = null;  this.getStrEstrutura = function() {    try {      _this.montarLayout();    } catch (e) {      new Erro("Erro inesperado.", e);    }    return _strEstrutura;  }  this.setStrEstrutura = function(strEstrutura) {    _strEstrutura = strEstrutura;  }  var _strId;  this.getStrId = function() {    return _strId;  }  this.setStrId = function(strId) {    _strId = strId;  }  var _strPlaceholder = "";  this.getStrPlaceholder = function() {    try {      _strPlaceholder = _this.getJq().attr("placeholder");    } catch (e) {      new Erro("Erro inesperado.", e);    }    return _strPlaceholder;  }  this.setStrPlaceholder = function(strPlaceholder) {    try {      _strPlaceholder = strPlaceholder;      _this.getJq().attr("placeholder", _strPlaceholder);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  var _strTitle = "";  this.getStrTitle = function() {    try {      _strTitle = _this.getJq().attr("title");    } catch (e) {      new Erro("Erro inesperado.", e);    }    return _strTitle;  }  this.setStrTitle = function(strTitle) {    try {      _strTitle = strTitle;      _this.getJq().attr("title", _strTitle);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.setStrTitulo = function(strTitle) {    _this.setStrTitle(strTitle);  }  // FIM ATRIBUTO  // MÉTODO  this.addStrConteudo = function(strConteudo) {    try {      $("#" + _this.getStrId()).append(strConteudo);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.esconder = function() {    try {      _this.setBooVisivel(false);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.montarLayout = function() {    try {      _this.setStrEstrutura("<div/>");    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.mostrar = function() {    try {      _this.setBooVisivel(true);    } catch (e) {      new Erro("Erro inesperado.", e);    }  }  this.toHtml = function() {    var tag;    try {      tag = _this.getStrEstrutura();    } catch (e) {      new Erro("Erro inesperado.", e);    }    return tag;  };  this.toString = function() {    var tag;    try {      tag = _this.getStrEstrutura();    } catch (e) {      new Erro("Erro inesperado.", e);    }    return tag;  };  // FIM MÉTODO  /* Construtor */  {    try {      if (!Utils.getBooStrVazia(strId)) {        _this.setStrId(strId);      }    } catch (e) {      new Erro("Erro inesperado.", e);    }  }}