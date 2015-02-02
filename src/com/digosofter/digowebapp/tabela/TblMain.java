package com.digosofter.digowebapp.tabela;

import java.util.List;

import com.digosofter.digojava.erro.Erro;
import com.digosofter.digowebapp.database.DbColunaWeb;
import com.digosofter.digowebapp.database.DbTabelaWeb;
import com.digosofter.digowebapp.database.DbView;

public abstract class TblMain extends DbTabelaWeb {

  private DbColunaWeb _clnBooAtivo;
  private DbColunaWeb _clnDttAlteracao;
  private DbColunaWeb _clnDttCadastro;
  private DbColunaWeb _clnDttExclusao;
  private DbColunaWeb _clnIntId;
  private DbColunaWeb _clnIntUsuarioAlteracaoId;
  private DbColunaWeb _clnIntUsuarioCadastroId;

  public TblMain(String strNome) {

    super(strNome);

    try {

      this.inicializarViews(this.getLstViw());
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }
  }

  public DbColunaWeb getClnBooAtivo() {

    try {

      if (_clnBooAtivo != null) {

        return _clnBooAtivo;
      }

      _clnBooAtivo = new DbColunaWeb("boo_ativo", this, DbColunaWeb.EnmTipo.BOOLEAN);

      _clnBooAtivo.setBooVisivelCadastro(false);
      _clnBooAtivo.setBooVisivelConsulta(false);
      _clnBooAtivo.setIntFrmLinha(2);
      _clnBooAtivo.setIntFrmLinhaPeso(2);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _clnBooAtivo;
  }

  public DbColunaWeb getClnDttAlteracao() {

    try {

      if (_clnDttAlteracao != null) {

        return _clnDttAlteracao;
      }

      _clnDttAlteracao = new DbColunaWeb("dtt_alteracao", this, DbColunaWeb.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);

      _clnDttAlteracao.setBooVisivelCadastro(false);
      _clnDttAlteracao.setBooVisivelConsulta(false);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _clnDttAlteracao;
  }

  public DbColunaWeb getClnDttCadastro() {

    try {

      if (_clnDttCadastro != null) {

        return _clnDttCadastro;
      }

      _clnDttCadastro = new DbColunaWeb("dtt_cadastro", this, DbColunaWeb.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);

      _clnDttCadastro.setBooVisivelCadastro(false);
      _clnDttCadastro.setBooVisivelConsulta(false);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _clnDttCadastro;
  }

  public DbColunaWeb getClnDttExclusao() {

    try {

      if (_clnDttExclusao != null) {

        return _clnDttExclusao;
      }

      _clnDttExclusao = new DbColunaWeb("dtt_exclusao", this, DbColunaWeb.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);

      _clnDttExclusao.setBooVisivelCadastro(false);
      _clnDttExclusao.setBooVisivelConsulta(false);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _clnDttExclusao;
  }

  public DbColunaWeb getClnIntId() {

    try {

      if (_clnIntId != null) {

        return _clnIntId;
      }

      _clnIntId = new DbColunaWeb("int_id", this, DbColunaWeb.EnmTipo.BIGSERIAL);

      _clnIntId.setBooChavePrimaria(true);
      _clnIntId.setBooVisivelCadastro(false);
      _clnIntId.setBooVisivelConsulta(false);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _clnIntId;
  }

  public DbColunaWeb getClnIntUsuarioAlteracaoId() {

    try {

      if (_clnIntUsuarioAlteracaoId != null) {

        return _clnIntUsuarioAlteracaoId;
      }

      _clnIntUsuarioAlteracaoId = new DbColunaWeb("int_usuario_alteracao_id", this, DbColunaWeb.EnmTipo.BIGINT);

      _clnIntUsuarioAlteracaoId.setBooVisivelCadastro(false);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _clnIntUsuarioAlteracaoId;
  }

  public DbColunaWeb getClnIntUsuarioCadastroId() {

    try {

      if (_clnIntUsuarioCadastroId != null) {

        return _clnIntUsuarioCadastroId;
      }

      _clnIntUsuarioCadastroId = new DbColunaWeb("int_usuario_cadastro_id", this, DbColunaWeb.EnmTipo.BIGINT);

      _clnIntUsuarioCadastroId.setBooVisivelCadastro(false);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return _clnIntUsuarioCadastroId;
  }

  @Override
  protected int inicializarColunas(int intOrdem) {

    try {

      intOrdem = super.inicializarColunas(intOrdem);

      this.getClnBooAtivo().setIntOrdem(++intOrdem);
      this.getClnDttAlteracao().setIntOrdem(++intOrdem);
      this.getClnDttCadastro().setIntOrdem(++intOrdem);
      this.getClnDttExclusao().setIntOrdem(++intOrdem);
      this.getClnIntId().setIntOrdem(++intOrdem);
      this.getClnIntUsuarioAlteracaoId().setIntOrdem(++intOrdem);
      this.getClnIntUsuarioCadastroId().setIntOrdem(++intOrdem);
    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);
    }
    finally {
    }

    return intOrdem;
  }

  /**
   * Método que inicializa a lista de views que a tabela possui. Este método é
   * chamado na construção da classe.
   */
  protected void inicializarViews(List<DbView> lstObjDbView) {

  }
}