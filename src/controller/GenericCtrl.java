/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AgendaDAO;
import DAO.ConsultaDAO;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import model.Generic;

/**
 *
 * @author leogo
 */
public class GenericCtrl {

    AgendaDAO agendaDao = new AgendaDAO();
    ConsultaDAO consultaDao = new ConsultaDAO();
    
    public ArrayList<Generic> getListaAgendaCtrl() {
        return this.agendaDao.getListaGenericAgenda();
    }

    public ArrayList<Generic> retornarListaAgendaPesquisa(String statusCons) {
        return agendaDao.retornarListaAgendaPesquisa(statusCons);
    }
    
    public ArrayList<Generic> getListaConsultaCtrl(){
        return  this.consultaDao.getListaGenericConsulta();
    }
    
     public ArrayList<Generic> getListaConsultaRealizadaCtrl(){
        return  this.consultaDao.getListaGenericConsultaRealizadas();
    }
     
     public ArrayList<Generic> getListaConsultaGrafico(String nome, String data, String data2){
         return  this.consultaDao.getListaGenericConsultaGrafico(nome, data, data2);
     }
}
