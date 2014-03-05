package com.digosofter.digowebapp.websocket;

import com.digosofter.digowebapp.objeto.ObjMain;

public final class ObjWsInterlocutor extends ObjMain {

  private int _intFncId;

  private String _strJson;

  public int getIntFuncId() {
    return _intFncId;
  }

  public String getStrJson() {
    return _strJson;
  }

  public void setIntFuncId(int intFuncId) {
    _intFncId = intFuncId;
  }

  public void setStrJson(String strJson) {
    _strJson = strJson;
  }

}
