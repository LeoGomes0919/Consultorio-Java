/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import model.Consulta;

/**
 *
 * @author leogo
 */
public class ConsultaCtrl {

    ConsultaDAO consultaDao = new ConsultaDAO();

    public int saveConsultaCrtl(Consulta c) {
        return this.consultaDao.salvarConsulta(c);
    }

    public boolean deletConsultaCtrl(int idConsulta) {
        return this.consultaDao.excluirConsulta(idConsulta);
    }

    public Consulta getConsultaIdCtrl(int idConsulta) {
        return this.consultaDao.getConsultaDao(idConsulta);
    }
    
    public boolean upConsultCtrl(Consulta c){
        return this.consultaDao.updateConsulta(c);
    }
    
    public boolean gerarGraficoConsultaNomeData(String nome, String data1, String data2){
        return this.consultaDao.gerarGraficoConsultaPorNomeData(nome, data1, data2);
    }
    
    public boolean gerarGraficoConsultaRealizadas(){
        return this.consultaDao.gerarGraficoConsultaRealizadas();
    }
}
