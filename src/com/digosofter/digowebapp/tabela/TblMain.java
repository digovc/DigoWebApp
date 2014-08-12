package com.digosofter.digowebapp.tabela;

import java.util.List;

import com.digosofter.digowebapp.database.DataBase;
import com.digosofter.digowebapp.database.DbColuna;
import com.digosofter.digowebapp.database.DbTabela;
import com.digosofter.digowebapp.database.DbView;
import com.digosofter.digowebapp.erro.Erro;

public abstract class TblMain extends DbTabela {

  private DbColuna _clnBooAtivo;

  private DbColuna _clnDttAlteracao;

  private DbColuna _clnDttCadastro;

  private DbColuna _clnDttExclusao;

  private DbColuna _clnIntId;

  private DbColuna _clnIntUsuarioAlteracaoId;

  private DbColuna _clnIntUsuarioCadastroId;

  public TblMain(String strNome, DataBase objDataBase) {

    super(strNome, objDataBase);

    try {

      this.inicializarViews(this.getLstObjDbView());

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }
  }

  public DbColuna getClnBooAtivo() {

    try {

      if (_clnBooAtivo == null) {
        _clnBooAtivo = new DbColuna("boo_ativo", this, DbColuna.EnmTipo.BOOLEAN);
        _clnBooAtivo.setBooVisivelCadastro(false);
        _clnBooAtivo.setBooVisivelConsulta(false);
        _clnBooAtivo.setIntFrmLinha(2);
        _clnBooAtivo.setIntFrmLinhaPeso(2);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _clnBooAtivo;
  }

  public DbColuna getClnDttAlteracao() {

    try {

      if (_clnDttAlteracao == null) {
        _clnDttAlteracao = new DbColuna("dtt_alteracao", this,
            DbColuna.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
        _clnDttAlteracao.setBooVisivelCadastro(false);
        _clnDttAlteracao.setBooVisivelConsulta(false);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _clnDttAlteracao;
  }

  public DbColuna getClnDttCadastro() {

    try {

      if (_clnDttCadastro == null) {
        _clnDttCadastro = new DbColuna("dtt_cadastro", this,
            DbColuna.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
        _clnDttCadastro.setBooVisivelCadastro(false);
        _clnDttCadastro.setBooVisivelConsulta(false);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _clnDttCadastro;
  }

  public DbColuna getClnDttExclusao() {

    try {

      if (_clnDttExclusao == null) {
        _clnDttExclusao = new DbColuna("dtt_exclusao", this,
            DbColuna.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
        _clnDttExclusao.setBooVisivelCadastro(false);
        _clnDttExclusao.setBooVisivelConsulta(false);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _clnDttExclusao;
  }

  public DbColuna getClnIntId() {

    try {

      if (_clnIntId == null) {

        _clnIntId = new DbColuna("int_id", this, DbColuna.EnmTipo.BIGSERIAL);
        _clnIntId.setBooChavePrimaria(true);
        _clnIntId.setBooVisivelCadastro(false);
        _clnIntId.setBooVisivelConsulta(false);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _clnIntId;
  }

  public DbColuna getClnIntUsuarioAlteracaoId() {

    try {

      if (_clnIntUsuarioAlteracaoId == null) {

        _clnIntUsuarioAlteracaoId = new DbColuna("int_usuario_alteracao_id", this,
            DbColuna.EnmTipo.BIGINT);
        _clnIntUsuarioAlteracaoId.setBooVisivelCadastro(false);
      }

    }
    catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    }
    finally {
    }

    return _clnIntUsuarioAlteracaoId;
  }

  public DbColuna getClnIntUsuarioCadastroId() {

    try {

      if (_clnIntUsuarioCadastroId == null) {

        _clnIntUsuarioCadastroId = new DbColuna("int_usuario_cadastro_id", this,
            DbColuna.EnmTipo.BIGINT);
        _clnIntUsuarioCadastroId.setBooVisivelCadastro(false);
      }

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
   * M�todo que inicializa a lista de views que a tabela possui. Este m�todo �
   * chamado na constru��o da classe.
   */
  protected void inicializarViews(List<DbView> lstObjDbView) {

  }

}
