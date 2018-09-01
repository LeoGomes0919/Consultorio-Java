/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.Agenda;
import model.Generic;
import model.Medico;
import model.Paciente;
import util.ConexaoPostgre;

/**
 *
 * @author leogo
 */
public class AgendaDAO extends ConexaoPostgre {

    public int salvarAgenda(Agenda a) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_agenda ("
                    + "dataagend, "
                    + "horaagend, "
                    + "tipoconsulta, "
                    + "id_medico_ag, "
                    + "id_paciente_ag,"
                    + "status "
                    + ") VALUES ("
                    + "'" + a.getDataAgenda() + "', "
                    + "'" + a.getHoraAagenda() + "', "
                    + "'" + a.getMotivoConsulta() + "', "
                    + "'" + a.getMedico() + "', "
                    + "'" + a.getPaciente() + "', "
                    + "'" + a.getStatus() + "' "
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<Agenda> getListaAgendaDAO() {
        ArrayList<Agenda> listamodelAgenda = new ArrayList();
        Agenda agenda = new Agenda();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_agenda, "
                    + "id_medico_ag, "
                    + "id_paciente_ag, "
                    + "dataagend, "
                    + "horaagend, "
                    + "tipoconsulta, "
                    + "status "
                    + "FROM "
                    + "tbl_agenda"
                    + ";"
            );

            while (this.getResultSet().next()) {
                agenda = new Agenda();
                agenda.setId_agenda(this.getResultSet().getInt(1));
                agenda.setMedico(this.getResultSet().getInt(2));
                agenda.setPaciente(this.getResultSet().getInt(3));
                agenda.setDataAgenda(this.getResultSet().getDate(4));
                agenda.setHoraAagenda(this.getResultSet().getString(5));
                agenda.setMotivoConsulta(this.getResultSet().getString(6));
                agenda.setStatus(this.getResultSet().getString(7));
                listamodelAgenda.add(agenda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelAgenda;
    }

    public ArrayList<Generic> getListaGenericAgenda() {
        ArrayList<Generic> listaGenericAgenda = new ArrayList<>();
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        Agenda agenda = new Agenda();
        Generic generico = new Generic();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_agenda, "
                    + "id_medico_ag, "
                    + "id_paciente_ag, "
                    + "dataagend, "
                    + "horaagend, "
                    + "tipoconsulta, "
                    + "nome, "
                    + "pac_nome ,"
                    + "status "
                    + "FROM tbl_agenda "
                    + "INNER JOIN tbl_medico ON tbl_agenda.id_medico_ag = tbl_medico.id_medico "
                    + "INNER JOIN tbl_paciente ON tbl_agenda.id_paciente_ag = tbl_paciente.id_paciente "
                    + "ORDER BY id_agenda ASC;"
            );
            while (this.getResultSet().next()) {
                agenda = new Agenda();
                medico = new Medico();
                paciente = new Paciente();
                generico = new Generic();

                agenda.setId_agenda(this.getResultSet().getInt(1));
                agenda.setMedico(this.getResultSet().getInt(2));
                agenda.setPaciente(this.getResultSet().getInt(3));
                agenda.setDataAgenda(this.getResultSet().getDate(4));
                agenda.setHoraAagenda(this.getResultSet().getString(5));
                agenda.setMotivoConsulta(this.getResultSet().getString(6));
                medico.setNome(this.getResultSet().getString(7));
                paciente.setNome(this.getResultSet().getString(8));
                agenda.setStatus(this.getResultSet().getString(9));

                generico.setAgenda(agenda);
                generico.setMedico(medico);
                generico.setPaciente(paciente);

                listaGenericAgenda.add(generico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaGenericAgenda;
    }

    public boolean updateAgenda(Agenda a) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_agenda SET "
                    + "dataagend = '" + a.getDataAgenda() + "', "
                    + "horaagend = '" + a.getHoraAagenda() + "', "
                    + "tipoconsulta = '" + a.getMotivoConsulta() + "', "
                    + "id_medico_ag = '" + a.getMedico() + "', "
                    + "status = '" + a.getStatus() + "', "
                    + "id_paciente_ag = '" + a.getPaciente() + "' "
                    + "WHERE id_agenda = '" + a.getId_agenda() + "' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Agenda getAgendaDao(int idAgenda) {
        Agenda agenda = new Agenda();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_agenda, "
                    + "id_medico_ag, "
                    + "id_paciente_ag, "
                    + "dataagend, "
                    + "horaagend, "
                    + "tipoconsulta, "
                    + "status "
                    + "FROM "
                    + "tbl_agenda "
                    + "WHERE id_agenda = '" + idAgenda + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                agenda.setId_agenda(this.getResultSet().getInt(1));
                agenda.setMedico(this.getResultSet().getInt(2));
                agenda.setPaciente(this.getResultSet().getInt(3));
                agenda.setDataAgenda(this.getResultSet().getDate(4));
                agenda.setHoraAagenda(this.getResultSet().getString(5));
                agenda.setMotivoConsulta(this.getResultSet().getString(6));
                agenda.setStatus(this.getResultSet().getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return agenda;
    }

    public ArrayList<Generic> retornarListaAgendaPesquisa(String status) {
        ArrayList<Generic> listaGenericAgenda = new ArrayList<>();
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        Agenda agenda = new Agenda();
        Generic generico = new Generic();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_agenda, "
                    + "id_medico_ag, "
                    + "id_paciente_ag, "
                    + "dataagend, "
                    + "horaagend, "
                    + "tipoconsulta, "
                    + "nome, "
                    + "pac_nome ,"
                    + "status "
                    + "FROM tbl_agenda "
                    + "INNER JOIN tbl_medico ON tbl_agenda.id_medico_ag = tbl_medico.id_medico "
                    + "INNER JOIN tbl_paciente ON tbl_agenda.id_paciente_ag = tbl_paciente.id_paciente "
                    + "WHERE status LIKE '%" + status + "%' "
                    + "ORDER BY id_agenda ASC;"
            );
            while (this.getResultSet().next()) {
                agenda = new Agenda();
                medico = new Medico();
                paciente = new Paciente();
                generico = new Generic();

                agenda.setId_agenda(this.getResultSet().getInt(1));
                agenda.setMedico(this.getResultSet().getInt(2));
                agenda.setPaciente(this.getResultSet().getInt(3));
                agenda.setDataAgenda(this.getResultSet().getDate(4));
                agenda.setHoraAagenda(this.getResultSet().getString(5));
                agenda.setMotivoConsulta(this.getResultSet().getString(6));
                medico.setNome(this.getResultSet().getString(7));
                paciente.setNome(this.getResultSet().getString(8));
                agenda.setStatus(this.getResultSet().getString(9));

                generico.setAgenda(agenda);
                generico.setMedico(medico);
                generico.setPaciente(paciente);

                listaGenericAgenda.add(generico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaGenericAgenda;
    }
    
     public boolean excluirAgenda(int idAgenda) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_Agenda "
                    + "WHERE id_agenda = '" + idAgenda + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
