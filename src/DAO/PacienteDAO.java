/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Paciente;
import util.ConexaoPostgre;

/**
 *
 * @author leogo
 */
public class PacienteDAO extends ConexaoPostgre {

    public int salvarPaciente(Paciente p) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_Paciente( "
                    + "pac_nome, "
                    + "cpf, "
                    + "data_nasc, "
                    + "altura, "
                    + "peso, "
                    + "sexo, "
                    + "telefone, "
                    + "cidade, "
                    + "uf, "
                    + "endereco, "
                    + "bairro, "
                    + "numresidencia, "
                    + "cep, "
                    + "rg "
                    + ") VALUES ("
                    + "'" + p.getNome() + "', "
                    + "'" + p.getCpf() + "', "
                    + "'" + p.getDataNascimento() + "', "
                    + "'" + p.getAltura() + "', "
                    + "'" + p.getPeso() + "', "
                    + "'" + p.getSexo() + "', "
                    + "'" + p.getTelCelular() + "', "
                    + "'" + p.getCidade() + "', "
                    + "'" + p.getEstadoUf() + "', "
                    + "'" + p.getEndereco() + "', "
                    + "'" + p.getBairro() + "', "
                    + "'" + p.getNumero() + "', "
                    + "'" + p.getCep() + "', "
                    + "'" + p.getRg() + "'"
                    + ");");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<Paciente> retornarListaPaciente() {
        ArrayList<Paciente> listaPaciente = new ArrayList<>();
        Paciente paciente = new Paciente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_paciente, "
                    + "pac_nome, "
                    + "cpf, "
                    + "data_nasc, "
                    + "altura, "
                    + "peso, "
                    + "sexo, "
                    + "telefone, "
                    + "cidade, "
                    + "uf, "
                    + "bairro, "
                    + "numresidencia, "
                    + "cep, "
                    + "rg, "
                    + "endereco "
                    + "FROM tbl_Paciente "
                    + "ORDER BY id_paciente ASC");
            while (this.getResultSet().next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(this.getResultSet().getInt(1));
                paciente.setNome(this.getResultSet().getString(2));
                paciente.setCpf(this.getResultSet().getString(3));
                paciente.setDataNascimento(this.getResultSet().getDate(4));
                paciente.setAltura(this.getResultSet().getDouble(5));
                paciente.setPeso(this.getResultSet().getDouble(6));
                paciente.setSexo(this.getResultSet().getString(7));
                paciente.setTelCelular(this.getResultSet().getString(8));
                paciente.setCidade(this.getResultSet().getString(9));
                paciente.setEstadoUf(this.getResultSet().getString(10));
                paciente.setBairro(this.getResultSet().getString(11));
                paciente.setNumero(this.getResultSet().getString(12));
                paciente.setCep(this.getResultSet().getString(13));
                paciente.setRg(this.getResultSet().getString(14));
                paciente.setEndereco(this.getResultSet().getString(15));

                listaPaciente.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return listaPaciente;
    }

    public ArrayList<Paciente> retornarListaPacientePesquisa(String nome, String cpf, String rg, String sexo, String estado, String cidade) {
        ArrayList<Paciente> listaPaciente = new ArrayList<>();
        Paciente paciente = new Paciente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_paciente, "
                    + "pac_nome, "
                    + "cpf, "
                    + "data_nasc, "
                    + "altura, "
                    + "peso, "
                    + "sexo, "
                    + "telefone, "
                    + "cidade, "
                    + "uf, "
                    + "bairro, "
                    + "numresidencia, "
                    + "cep, "
                    + "rg "
                    + "FROM tbl_Paciente "
                    + "WHERE pac_nome LIKE '%" + nome + "%' "
                    + "AND cpf LIKE '%" + cpf + "%' "
                    + "AND rg LIKE '%" + rg + "%' "
                    + "AND sexo LIKE '%" + sexo + "%' "
                    + "AND uf LIKE '%" + estado + "%' "
                    + "AND cidade LIKE '%" + cidade + "%' "
                    + "ORDER BY id_paciente ASC");
            while (this.getResultSet().next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(this.getResultSet().getInt(1));
                paciente.setNome(this.getResultSet().getString(2));
                paciente.setCpf(this.getResultSet().getString(3));
                paciente.setDataNascimento(this.getResultSet().getDate(4));
                paciente.setAltura(this.getResultSet().getDouble(5));
                paciente.setPeso(this.getResultSet().getDouble(6));
                paciente.setSexo(this.getResultSet().getString(7));
                paciente.setTelCelular(this.getResultSet().getString(8));
                paciente.setCidade(this.getResultSet().getString(9));
                paciente.setEstadoUf(this.getResultSet().getString(10));
                paciente.setBairro(this.getResultSet().getString(11));
                paciente.setNumero(this.getResultSet().getString(12));
                paciente.setCep(this.getResultSet().getString(13));
                paciente.setRg(this.getResultSet().getString(14));
                listaPaciente.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return listaPaciente;
    }

    public boolean excluirPaciente(int idPaciente) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_Paciente "
                    + "WHERE id_paciente = '" + idPaciente + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Paciente retornarPacienteId(int idPaciente) {
        Paciente paciente = new Paciente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_paciente, "
                    + "pac_nome, "
                    + "cpf, "
                    + "data_nasc, "
                    + "altura, "
                    + "peso, "
                    + "sexo, "
                    + "telefone, "
                    + "cidade, "
                    + "uf, "
                    + "bairro, "
                    + "numresidencia, "
                    + "cep, "
                    + "rg "
                    + "FROM tbl_paciente "
                    + "WHERE id_paciente = '" + idPaciente + "'");
            while (this.getResultSet().next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(this.getResultSet().getInt(1));
                paciente.setNome(this.getResultSet().getString(2));
                paciente.setCpf(this.getResultSet().getString(3));
                paciente.setDataNascimento(this.getResultSet().getDate(4));
                paciente.setAltura(this.getResultSet().getDouble(5));
                paciente.setPeso(this.getResultSet().getDouble(6));
                paciente.setSexo(this.getResultSet().getString(7));
                paciente.setTelCelular(this.getResultSet().getString(8));
                paciente.setCidade(this.getResultSet().getString(9));
                paciente.setEstadoUf(this.getResultSet().getString(10));
                paciente.setBairro(this.getResultSet().getString(11));
                paciente.setNumero(this.getResultSet().getString(12));
                paciente.setCep(this.getResultSet().getString(13));
                paciente.setRg(this.getResultSet().getString(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return paciente;
    }

    public boolean updatePaciente(Paciente p) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_Paciente SET "
                    + "pac_nome = '" + p.getNome() + "', "
                    + "cpf = '" + p.getCpf() + "', "
                    + "data_nasc = '" + p.getDataNascimento() + "', "
                    + "altura = '" + p.getAltura() + "', "
                    + "peso = '" + p.getPeso() + "', "
                    + "sexo = '" + p.getSexo() + "', "
                    + "telefone = '" + p.getTelCelular() + "', "
                    + "cidade = '" + p.getCidade() + "', "
                    + "uf = '" + p.getEstadoUf() + "', "
                    + "bairro = '" + p.getBairro() + "', "
                    + "numresidencia = '" + p.getNumero() + "', "
                    + "cep = '" + p.getCep() + "', "
                    + "rg = '" + p.getRg() + "' "
                    + "WHERE id_paciente = '" + p.getIdPaciente() + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Paciente retornarPacienteNome(String NomePaciente) {
        Paciente paciente = new Paciente();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_paciente, "
                    + "pac_nome, "
                    + "cpf, "
                    + "data_nasc, "
                    + "altura, "
                    + "peso, "
                    + "sexo, "
                    + "telefone, "
                    + "cidade, "
                    + "uf, "
                    + "bairro, "
                    + "numresidencia, "
                    + "cep, "
                    + "rg "
                    + "FROM tbl_Paciente "
                    + "WHERE pac_nome = '" + NomePaciente + "'");
            while (this.getResultSet().next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(this.getResultSet().getInt(1));
                paciente.setNome(this.getResultSet().getString(2));
                paciente.setCpf(this.getResultSet().getString(3));
                paciente.setDataNascimento(this.getResultSet().getDate(4));
                paciente.setAltura(this.getResultSet().getDouble(5));
                paciente.setPeso(this.getResultSet().getDouble(6));
                paciente.setSexo(this.getResultSet().getString(7));
                paciente.setTelCelular(this.getResultSet().getString(8));
                paciente.setCidade(this.getResultSet().getString(9));
                paciente.setEstadoUf(this.getResultSet().getString(10));
                paciente.setBairro(this.getResultSet().getString(11));
                paciente.setNumero(this.getResultSet().getString(12));
                paciente.setCep(this.getResultSet().getString(13));
                paciente.setRg(this.getResultSet().getString(14));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
        } finally {
            this.fecharConexao();
        }
        return paciente;
    }
}
