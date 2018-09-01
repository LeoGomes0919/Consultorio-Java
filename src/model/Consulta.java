/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author leogo
 */
public class Consulta {

    private int id_consulta;
    private int sistolica;
    private int diastolica;
    private String data_consulta;
    private String frequencia;
    private int Medico;
    private int Paciente;
    private String status;
    
    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }

    public int getMedico() {
        return Medico;
    }

    public void setMedico(int Medico) {
        this.Medico = Medico;
    }

    public int getPaciente() {
        return Paciente;
    }

    public void setPaciente(int Paciente) {
        this.Paciente = Paciente;
    }

    public int getSistolica() {
        return sistolica;
    }

    public void setSistolica(int sistolica) {
        this.sistolica = sistolica;
    }

    public int getDiastolica() {
        return diastolica;
    }

    public void setDiastolica(int diastolica) {
        this.diastolica = diastolica;
    }
}
