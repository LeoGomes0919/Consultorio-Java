/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.MedicoDAO;
import java.util.ArrayList;
import model.Medico;

/**
 *
 * @author leogo
 */
public class MedicoCtrl {

    MedicoDAO medicoDao = new MedicoDAO();

    public int saveMedicoCrtl(Medico m) {
        return this.medicoDao.salvarMedico(m);
    }

    public Medico retoMedicoNomeCtrl(String nomeMedico) {
        return this.medicoDao.retornarMedicoNome(nomeMedico);
    }

    public ArrayList<Medico> retoListMedicoCrtl() {
        return this.medicoDao.retornarListaMedico();
    }

    public boolean updateMedicoCtrl(Medico m) {
        return this.medicoDao.alterarMedico(m);
    }

    public Medico retoMedicoIdCtrl(int idMedico) {
        return this.medicoDao.retornarMedicoId(idMedico);
    }

    public ArrayList<Medico> retornarListaMedicoPesquisaCtrl(String nome, String rg, String cpf, String crm, String estado, String cidade, String funcao, String espc_principal) {
        return this.medicoDao.retornarListaMedicoPesquisa(nome, rg, cpf, crm, estado, cidade, funcao, espc_principal);
    }

    public boolean upMedicoCtrl(Medico medico) {
        return this.medicoDao.updateMedico(medico);
    }

    public boolean deletMedicoCtrl(int idMedico) {
        return this.medicoDao.excluirMedico(idMedico);
    }

    public boolean getValidarUsuarioController(Medico medico) {
        return this.medicoDao.getValidarUsuario(medico);
    }

    public Medico getUsuarioController(String mLogin) {
        return this.medicoDao.getUsuarioDAO(mLogin);
    }
}
