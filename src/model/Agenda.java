package model;

import java.util.Date;

/**
*
* @author leo go
*/
public class Agenda {

    private int id_agenda;
    private int Medico;
    private int Paciente;
    private String horaAagenda;
    private Date dataAgenda;
    private String motivoConsulta;
    private String status;

    /**
    * Construtor
    */
    public Agenda(){}

    /**
    * seta o valor de id_agenda
    * @param pId_agenda
    */
    public void setId_agenda(int pId_agenda){
        this.id_agenda = pId_agenda;
    }
    /**
    * return pk_id_agenda
     * @return 
    */
    public int getId_agenda(){
        return this.id_agenda;
    }

    /**
    * seta o valor de Medico
    * @param pMedico
    */
    public void setMedico(int pMedico){
        this.Medico = pMedico;
    }
    /**
    * return fk_Medico
     * @return 
    */
    public int getMedico(){
        return this.Medico;
    }

    /**
    * seta o valor de Paciente
    * @param pPaciente
    */
    public void setPaciente(int pPaciente){
        this.Paciente = pPaciente;
    }
    /**
    * return fk_Paciente
     * @return 
    */
    public int getPaciente(){
        return this.Paciente;
    }

    /**
    * seta o valor de horaAagenda
    * @param pHoraAagenda
    */
    public void setHoraAagenda(String pHoraAagenda){
        this.horaAagenda = pHoraAagenda;
    }
    /**
    * return horaAagenda
     * @return 
    */
    public String getHoraAagenda(){
        return this.horaAagenda;
    }

    /**
    * seta o valor de dataAgenda
    * @param pDataAgenda
    */
    public void setDataAgenda(Date pDataAgenda){
        this.dataAgenda = pDataAgenda;
    }
    /**
    * return dataAgenda
     * @return 
    */
    public Date getDataAgenda(){
        return this.dataAgenda;
    }

    /**
    * seta o valor de motivoConsulta
    * @param pMotivoConsulta
    */
    public void setMotivoConsulta(String pMotivoConsulta){
        this.motivoConsulta = pMotivoConsulta;
    }
    /**
    * return motivoConsulta
     * @return 
    */
    public String getMotivoConsulta(){
        return this.motivoConsulta;
    }

    public String getStatus(){
        return status;
    }

    /**
     * seta o valor de status
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Agenda {" + "::id_agenda = " + this.id_agenda + "::Medico = " + this.Medico + "::Paciente = " + this.Paciente + "::horaAagenda = " + this.horaAagenda + "::dataAgenda = " + this.dataAgenda + "::motivoConsulta = " + this.motivoConsulta + "::status = " + this.status +  "}";
    }
}