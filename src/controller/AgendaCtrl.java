/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AgendaDAO;
import java.util.ArrayList;
import model.Agenda;

/**
 *
 * @author leogo
 */
public class AgendaCtrl {

    AgendaDAO agendaDao = new AgendaDAO();

    public int saveAgendaCrtl(Agenda a) {
        return this.agendaDao.salvarAgenda(a);
    }

    public ArrayList<Agenda> getListaAgendaController() {
        return this.agendaDao.getListaAgendaDAO();
    }

    public boolean upAgendaCtrl(Agenda a) {
        return this.agendaDao.updateAgenda(a);
    }

    public Agenda getAgendaController(int idAgenda) {
        return this.agendaDao.getAgendaDao(idAgenda);
    }

    public boolean deletAgendaCtrl(int idAgenda) {
        return this.agendaDao.excluirAgenda(idAgenda);
    }
}
