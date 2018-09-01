/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Medico;
import util.ConexaoPostgre;

/**
 *
 * @author leogo
 */
public class MedicoDAO extends ConexaoPostgre {

    public int salvarMedico(Medico m) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_Medico ("
                    + "nome, "
                    + "cpf, "
                    + "crm, "
                    + "data_nasc, "
                    + "sexo, "
                    + "funcao, "
                    + "senha, "
                    + "permissao, "
                    + "orgao_emissor, "
                    + "estado_civil, "
                    + "endereco, "
                    + "bairro, "
                    + "cep, "
                    + "cidade, "
                    + "estado_uf, "
                    + "tel_resid, "
                    + "tel_celular, "
                    + "rg, "
                    + "espc_principal, "
                    + "espc_secundaria, "
                    + "email_comercial, "
                    + "tel_comerci, "
                    + "usuario, "
                    + "numero "
                    + ") VALUES ("
                    + "'" + m.getNome() + "',"
                    + "'" + m.getCpf() + "',"
                    + "'" + m.getCrm() + "',"
                    + "'" + m.getDataNasc() + "',"
                    + "'" + m.getSexo() + "',"
                    + "'" + m.getFuncao() + "',"
                    + "'" + m.getSenha() + "',"
                    + "'" + m.getPermissao() + "',"
                    + "'" + m.getOrgaoEmissor() + "',"
                    + "'" + m.getEstadoCivil() + "',"
                    + "'" + m.getEndereco() + "',"
                    + "'" + m.getBairro() + "',"
                    + "'" + m.getCep() + "',"
                    + "'" + m.getCidade() + "',"
                    + "'" + m.getEstado() + "',"
                    + "'" + m.getTelrrsid() + "',"
                    + "'" + m.getTelCelular() + "',"
                    + "'" + m.getRg() + "',"
                    + "'" + m.getEspcPrincipal() + "',"
                    + "'" + m.getEspcSecundaria() + "',"
                    + "'" + m.getEmailComerc() + "',"
                    + "'" + m.getTelComerc() + "',"
                    + "'" + m.getUsuario() + "',"
                    + "'" + m.getNumero() + "'"
                    + ");");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public Medico retornarMedicoNome(String medicoNome) {
        Medico medico = new Medico();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_medico, "
                    + "nome, "
                    + "cpf, "
                    + "crm, "
                    + "sexo, "
                    + "funcao, "
                    + "usuario, "
                    + "senha, "
                    + "permissao, "
                    + "orgao_emissor, "
                    + "rg "
                    + "FROM tbl_Medico "
                    + "WHERE nome = '" + medicoNome + "'"
            );
            while (this.getResultSet().next()) {
                medico.setIdMedico(this.getResultSet().getInt(1));
                medico.setNome(this.getResultSet().getString(2));
                medico.setCpf(this.getResultSet().getString(3));
                medico.setCrm(this.getResultSet().getString(4));
                medico.setSexo(this.getResultSet().getString(5));
                medico.setFuncao(this.getResultSet().getString(6));
                medico.setUsuario(this.getResultSet().getString(7));
                medico.setSenha(this.getResultSet().getString(8));
                medico.setPermissao(this.getResultSet().getString(9));
                medico.setOrgaoEmissor(this.getResultSet().getString(10));
                medico.setRg(this.getResultSet().getString(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return medico;
    }

    public ArrayList<Medico> retornarListaMedico() {
        ArrayList<Medico> listaMedico = new ArrayList<>();
        Medico medico = new Medico();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_medico, "
                    + "nome, "
                    + "cpf, "
                    + "crm, "
                    + "data_nasc, "
                    + "sexo, "
                    + "funcao, "
                    + "usuario, "
                    + "senha, "
                    + "permissao, "
                    + "orgao_emissor, "
                    + "estado_civil, "
                    + "endereco, "
                    + "numero, "
                    + "cep, "
                    + "bairro, "
                    + "cidade, "
                    + "estado_uf, "
                    + "tel_resid, "
                    + "tel_celular, "
                    + "rg, "
                    + "espc_principal, "
                    + "espc_secundaria, "
                    + "email_comercial, "
                    + "tel_comerci "
                    + "FROM tbl_Medico "
                    + "ORDER BY id_medico ASC");
            while (this.getResultSet().next()) {
                medico = new Medico();
                medico.setIdMedico(this.getResultSet().getInt(1));
                medico.setNome(this.getResultSet().getString(2));
                medico.setCpf(this.getResultSet().getString(3));
                medico.setCrm(this.getResultSet().getString(4));
                medico.setDataNasc(this.getResultSet().getDate(5));
                medico.setSexo(this.getResultSet().getString(6));
                medico.setFuncao(this.getResultSet().getString(7));
                medico.setUsuario(this.getResultSet().getString(8));
                medico.setSenha(this.getResultSet().getString(9));
                medico.setPermissao(this.getResultSet().getString(10));
                medico.setOrgaoEmissor(this.getResultSet().getString(11));
                medico.setEstadoCivil(this.getResultSet().getString(12));
                medico.setEndereco(this.getResultSet().getString(13));
                medico.setNumero(this.getResultSet().getString(14));
                medico.setCep(this.getResultSet().getString(15));
                medico.setBairro(this.getResultSet().getString(16));
                medico.setCidade(this.getResultSet().getString(17));
                medico.setEstado(this.getResultSet().getString(18));
                medico.setTelrrsid(this.getResultSet().getString(19));
                medico.setTelCelular(this.getResultSet().getString(20));
                medico.setRg(this.getResultSet().getString(21));
                medico.setEspcPrincipal(this.getResultSet().getString(22));
                medico.setEspcSecundaria(this.getResultSet().getString(23));
                medico.setEmailComerc(this.getResultSet().getString(24));
                medico.setTelComerc(this.getResultSet().getString(25));
                listaMedico.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return listaMedico;
    }

    public boolean alterarMedico(Medico m) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_Medico SET "
                    + "usuario = '" + m.getUsuario() + "',"
                    + "senha = '" + m.getSenha() + "',"
                    + "permissao = '" + m.getPermissao() + "'"
                    + "WHERE id_medico = '" + m.getIdMedico() + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Medico retornarMedicoId(int idMedico) {
        Medico medico = new Medico();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_medico, "
                    + "nome, "
                    + "cpf, "
                    + "crm, "
                    + "sexo, "
                    + "funcao, "
                    + "usuario, "
                    + "senha, "
                    + "permissao, "
                    + "orgao_emissor, "
                    + "rg, "
                    + "data_nasc, "
                    + "estado_civil, "
                    + "endereco, "
                    + "bairro, "
                    + "numero, "
                    + "estado_uf, "
                    + "cidade, "
                    + "cep, "
                    + "tel_resid, "
                    + "tel_celular, "
                    + "espc_principal, "
                    + "espc_secundaria, "
                    + "email_comercial, "
                    + "tel_comerci "
                    + "FROM tbl_Medico "
                    + "WHERE id_medico = '" + idMedico + "'");
            while (this.getResultSet().next()) {
                medico.setIdMedico(this.getResultSet().getInt(1));
                medico.setNome(this.getResultSet().getString(2));
                medico.setCpf(this.getResultSet().getString(3));
                medico.setCrm(this.getResultSet().getString(4));
                medico.setSexo(this.getResultSet().getString(5));
                medico.setFuncao(this.getResultSet().getString(6));
                medico.setUsuario(this.getResultSet().getString(7));
                medico.setSenha(this.getResultSet().getString(8));
                medico.setPermissao(this.getResultSet().getString(9));
                medico.setOrgaoEmissor(this.getResultSet().getString(10));
                medico.setRg(this.getResultSet().getString(11));
                medico.setDataNasc(this.getResultSet().getDate(12));
                medico.setEstadoCivil(this.getResultSet().getString(13));
                medico.setEndereco(this.getResultSet().getString(14));
                medico.setBairro(this.getResultSet().getString(15));
                medico.setNumero(this.getResultSet().getString(16));
                medico.setEstado(this.getResultSet().getString(17));
                medico.setCidade(this.getResultSet().getString(18));
                medico.setCep(this.getResultSet().getString(19));
                medico.setTelrrsid(this.getResultSet().getString(20));
                medico.setTelCelular(this.getResultSet().getString(21));
                medico.setEspcPrincipal(this.getResultSet().getString(22));
                medico.setEspcSecundaria(this.getResultSet().getString(23));
                medico.setEmailComerc(this.getResultSet().getString(24));
                medico.setTelComerc(this.getResultSet().getString(25));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return medico;
    }

    public ArrayList<Medico> retornarListaMedicoPesquisa(String nome, String rg, String cpf, String crm, String estado, String cidade, String funcao, String espc_principal) {
        ArrayList<Medico> listaMedico = new ArrayList<>();
        Medico medico = new Medico();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_medico, "
                    + "nome, "
                    + "cpf, "
                    + "crm, "
                    + "data_nasc, "
                    + "sexo, "
                    + "funcao, "
                    + "usuario, "
                    + "senha, "
                    + "permissao, "
                    + "orgao_emissor, "
                    + "estado_civil, "
                    + "endereco, "
                    + "numero, "
                    + "cep, "
                    + "bairro, "
                    + "cidade, "
                    + "estado_uf, "
                    + "tel_resid, "
                    + "tel_celular, "
                    + "rg, "
                    + "espc_principal, "
                    + "espc_secundaria, "
                    + "email_comercial, "
                    + "tel_comerci "
                    + "FROM tbl_Medico "
                    + "WHERE nome LIKE '%" + nome + "%' "
                    + "AND rg LIKE '%" + rg + "%' "
                    + "AND cpf LIKE '%" + cpf + "%' "
                    + "AND crm LIKE '%" + crm + "%' "
                    + "AND estado_uf LIKE '%" + estado + "%' "
                    + "AND cidade LIKE '%" + cidade + "%' "
                    + "AND funcao LIKE '%" + funcao + "%' "
                    + "AND espc_principal LIKE '%" + espc_principal + "%' "
                    + "ORDER BY id_medico ASC");
            while (this.getResultSet().next()) {
                medico = new Medico();
                medico.setIdMedico(this.getResultSet().getInt(1));
                medico.setNome(this.getResultSet().getString(2));
                medico.setCpf(this.getResultSet().getString(3));
                medico.setCrm(this.getResultSet().getString(4));
                medico.setDataNasc(this.getResultSet().getDate(5));
                medico.setSexo(this.getResultSet().getString(6));
                medico.setFuncao(this.getResultSet().getString(7));
                medico.setUsuario(this.getResultSet().getString(8));
                medico.setSenha(this.getResultSet().getString(9));
                medico.setPermissao(this.getResultSet().getString(10));
                medico.setOrgaoEmissor(this.getResultSet().getString(11));
                medico.setEstadoCivil(this.getResultSet().getString(12));
                medico.setEndereco(this.getResultSet().getString(13));
                medico.setNumero(this.getResultSet().getString(14));
                medico.setCep(this.getResultSet().getString(15));
                medico.setBairro(this.getResultSet().getString(16));
                medico.setCidade(this.getResultSet().getString(17));
                medico.setEstado(this.getResultSet().getString(18));
                medico.setTelrrsid(this.getResultSet().getString(19));
                medico.setTelCelular(this.getResultSet().getString(20));
                medico.setRg(this.getResultSet().getString(21));
                medico.setEspcPrincipal(this.getResultSet().getString(22));
                medico.setEspcSecundaria(this.getResultSet().getString(23));
                medico.setEmailComerc(this.getResultSet().getString(24));
                medico.setTelComerc(this.getResultSet().getString(25));
                listaMedico.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return listaMedico;
    }

    public boolean updateMedico(Medico medico) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_Medico SET "
                    + "nome = '" + medico.getNome() + "', "
                    + "cpf = '" + medico.getCpf() + "', "
                    + "crm = '" + medico.getCrm() + "', "
                    + "data_nasc = '" + medico.getDataNasc() + "', "
                    + "sexo = '" + medico.getSexo() + "', "
                    + "funcao = '" + medico.getFuncao() + "', "
                    + "orgao_emissor = '" + medico.getOrgaoEmissor() + "', "
                    + "estado_civil = '" + medico.getEstadoCivil() + "', "
                    + "endereco = '" + medico.getEndereco() + "', "
                    + "numero = '" + medico.getNumero() + "', "
                    + "cep = '" + medico.getCep() + "', "
                    + "bairro = '" + medico.getBairro() + "', "
                    + "cidade = '" + medico.getCidade() + "', "
                    + "estado_uf = '" + medico.getEstado() + "', "
                    + "tel_resid = '" + medico.getTelrrsid() + "', "
                    + "tel_celular = '" + medico.getTelCelular() + "', "
                    + "rg = '" + medico.getRg() + "', "
                    + "espc_principal = '" + medico.getEspcPrincipal() + "', "
                    + "espc_secundaria = '" + medico.getEspcSecundaria() + "', "
                    + "email_comercial = '" + medico.getEmailComerc() + "', "
                    + "tel_comerci = '" + medico.getTelComerc() + "' "
                    + "WHERE id_medico = '" + medico.getIdMedico() + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean excluirMedico(int idMedico) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_Medico "
                    + "WHERE id_medico = '" + idMedico + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean getValidarUsuario(Medico medico) {
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_medico, "
                    + "nome, "
                    + "usuario, "
                    + "senha, "
                    + "permissao "
                    + "FROM tbl_medico "
                    + "WHERE "
                    + "usuario = '" + medico.getUsuario() + "' AND senha = '" + medico.getSenha() + "'"
                    + ";"
            );
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Medico getUsuarioDAO(String mLogin) {
        Medico medico = new Medico();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_medico, "
                    + "usuario, "
                    + "nome, "
                    + "senha, "
                    + "permissao "
                    + "FROM "
                    + "tbl_medico "
                    + "WHERE "
                    + "usuario = '" + mLogin + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                medico.setIdMedico(this.getResultSet().getInt(1));
                medico.setUsuario(this.getResultSet().getString(2));
                medico.setNome(this.getResultSet().getString(3));
                medico.setSenha(this.getResultSet().getString(4));
                medico.setPermissao(this.getResultSet().getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return medico;
    }
}
