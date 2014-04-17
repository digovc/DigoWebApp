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

    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      this.inicializarViews(this.getLstObjDbView());

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }
  }

  public DbColuna getClnBooAtivo() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_clnBooAtivo == null) {
        _clnBooAtivo = new DbColuna("boo_ativo", this, DbColuna.EnmTipo.BOOLEAN);
        _clnBooAtivo.setBooVisivelCadastro(false);
        _clnBooAtivo.setBooVisivelConsulta(false);
        _clnBooAtivo.setIntFrmLinha(2);
        _clnBooAtivo.setIntFrmLinhaPeso(2);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnBooAtivo;
  }

  public DbColuna getClnDttAlteracao() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_clnDttAlteracao == null) {
        _clnDttAlteracao = new DbColuna("dtt_alteracao", this,
            DbColuna.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
        _clnDttAlteracao.setBooVisivelCadastro(false);
        _clnDttAlteracao.setBooVisivelConsulta(false);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnDttAlteracao;
  }

  public DbColuna getClnDttCadastro() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_clnDttCadastro == null) {
        _clnDttCadastro = new DbColuna("dtt_cadastro", this,
            DbColuna.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
        _clnDttCadastro.setBooVisivelCadastro(false);
        _clnDttCadastro.setBooVisivelConsulta(false);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnDttCadastro;
  }

  public DbColuna getClnDttExclusao() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_clnDttExclusao == null) {
        _clnDttExclusao = new DbColuna("dtt_exclusao", this,
            DbColuna.EnmTipo.TIMESTAMP_WITHOUT_TIME_ZONE);
        _clnDttExclusao.setBooVisivelCadastro(false);
        _clnDttExclusao.setBooVisivelConsulta(false);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnDttExclusao;
  }

  public DbColuna getClnIntId() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_clnIntId == null) {

        _clnIntId = new DbColuna("int_id", this, DbColuna.EnmTipo.BIGSERIAL);
        _clnIntId.setBooChavePrimaria(true);
        _clnIntId.setBooVisivelCadastro(false);
        _clnIntId.setBooVisivelConsulta(false);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnIntId;
  }

  public DbColuna getClnIntUsuarioAlteracaoId() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_clnIntUsuarioAlteracaoId == null) {

        _clnIntUsuarioAlteracaoId = new DbColuna("int_usuario_alteracao_id", this,
            DbColuna.EnmTipo.BIGINT);
        _clnIntUsuarioAlteracaoId.setBooVisivelCadastro(false);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnIntUsuarioAlteracaoId;
  }

  public DbColuna getClnIntUsuarioCadastroId() {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      if (_clnIntUsuarioCadastroId == null) {

        _clnIntUsuarioCadastroId = new DbColuna("int_usuario_cadastro_id", this,
            DbColuna.EnmTipo.BIGINT);
        _clnIntUsuarioCadastroId.setBooVisivelCadastro(false);
      }

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return _clnIntUsuarioCadastroId;
  }

  @Override
  protected int inicializarColunas(int intOrdem) {
    // VARIÁVEIS
    // FIM VARIÁVEIS
    try {
      // AÇÕES

      intOrdem = super.inicializarColunas(intOrdem);
      this.getClnBooAtivo().setIntOrdem(++intOrdem);
      this.getClnDttAlteracao().setIntOrdem(++intOrdem);
      this.getClnDttCadastro().setIntOrdem(++intOrdem);
      this.getClnDttExclusao().setIntOrdem(++intOrdem);
      this.getClnIntId().setIntOrdem(++intOrdem);
      this.getClnIntUsuarioAlteracaoId().setIntOrdem(++intOrdem);
      this.getClnIntUsuarioCadastroId().setIntOrdem(++intOrdem);

      // FIM AÇÕES
    } catch (Exception ex) {

      new Erro("Erro inesperado.\n", ex);

    } finally {
    }

    return intOrdem;
  }

  /**
   * Método que inicializa a lista de views que a tabela possui. Este método é
   * chamado na construção da classe.
   */
  protected void inicializarViews(List<DbView> lstObjDbView){

  };

}
