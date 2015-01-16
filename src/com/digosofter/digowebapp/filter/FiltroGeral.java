package com.digosofter.digowebapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.digosofter.digojava.erro.Erro;

public class FiltroGeral implements Filter {

  @Override
  public void destroy() {

  }

  @Override
  public void doFilter(ServletRequest objServletRequest, ServletResponse objServletResponse, FilterChain objFilterChain) throws IOException, ServletException {

    HttpServletRequest objHttpServletRequest;
    String strPath;

    try {

      objHttpServletRequest = (HttpServletRequest) objServletRequest;
      strPath = objHttpServletRequest.getRequestURI().substring(objHttpServletRequest.getContextPath().length());

      if (strPath.startsWith("/res")) {

        objFilterChain.doFilter(objServletRequest, objServletResponse);
        return;
      }

      if (strPath.startsWith("/ws")) {

        objFilterChain.doFilter(objServletRequest, objServletResponse);
        return;
      }

      objHttpServletRequest.getRequestDispatcher("/app/" + strPath).forward(objServletRequest, objServletResponse);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  @Override
  public void init(FilterConfig config) throws ServletException {

  }
}