/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PacienteDAO;
import java.util.ArrayList;
import model.Paciente;

/**
 *
 * @author leogo
 */
public class PacienteCtrl {

    PacienteDAO pacienteDao = new PacienteDAO();

    public int savePacienteCrtl(Paciente p) {
        return this.pacienteDao.salvarPaciente(p);
    }

    public ArrayList<Paciente> retoListPacienteCrtl() {
        return this.pacienteDao.retornarListaPaciente();
    }

    public ArrayList<Paciente> retornarListaPacientePesquisa(String nome, String cpf, String rg, String sexo, String estado, String cidade) {
        return pacienteDao.retornarListaPacientePesquisa(nome, cpf, rg, sexo, estado, cidade);
    }

    public boolean deletPacienteCtrl(int idPaciente) {
        return this.pacienteDao.excluirPaciente(idPaciente);
    }

    public Paciente retoPacienteIdCtrl(int idPaciente) {
        return this.pacienteDao.retornarPacienteId(idPaciente);
    }

    public Paciente retoPacienteNomeCtrl(String NomePaciente) {
        return this.pacienteDao.retornarPacienteNome(NomePaciente);
    }

    public boolean upPacienteCtrl(Paciente p) {
        return this.pacienteDao.updatePaciente(p);
    }
}
