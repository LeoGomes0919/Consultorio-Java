/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Desktop;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import model.Consulta;
import model.Generic;
import model.Medico;
import model.Paciente;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import util.ConexaoPostgre;

/**
 *
 * @author leogo
 */
public class ConsultaDAO extends ConexaoPostgre {

    public int salvarConsulta(Consulta c) {
        try {
            this.conectar();
            return this.insertSQL("INSERT INTO tbl_consulta ("
                    + "datahora, "
                    + "paciente_idpaciente, "
                    + "medico_idmedico, "
                    + "sistole, "
                    + "diastole, "
                    + "frequencia,"
                    + "status "
                    + ") VALUES ("
                    + "'" + c.getData_consulta() + "', "
                    + "'" + c.getPaciente() + "', "
                    + "'" + c.getMedico() + "', "
                    + "'" + c.getSistolica() + "', "
                    + "'" + c.getDiastolica() + "', "
                    + "'" + c.getFrequencia() + "', "
                    + "'" + c.getStatus() + "' "
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

    public ArrayList<Generic> getListaGenericConsulta() {
        ArrayList<Generic> listaGenericConsulta = new ArrayList<>();
        Consulta consulta = new Consulta();
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        Generic generico = new Generic();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_consulta, "
                    + "datahora, "
                    + "paciente_idpaciente, "
                    + "medico_idmedico, "
                    + "sistole, "
                    + "diastole, "
                    + "frequencia,"
                    + "status, "
                    + "nome, "
                    + "pac_nome "
                    + "FROM tbl_consulta "
                    + "INNER JOIN tbl_medico ON tbl_consulta.medico_idmedico = tbl_medico.id_medico "
                    + "INNER JOIN tbl_paciente ON tbl_consulta.paciente_idpaciente = tbl_paciente.id_paciente "
                    + "ORDER BY id_consulta ASC;"
            );
            while (this.getResultSet().next()) {
                generico = new Generic();
                consulta = new Consulta();
                paciente = new Paciente();
                medico = new Medico();

                consulta.setId_consulta(this.getResultSet().getInt(1));
                consulta.setData_consulta(this.getResultSet().getString(2));
                consulta.setPaciente(this.getResultSet().getInt(3));
                consulta.setMedico(this.getResultSet().getInt(4));
                consulta.setSistolica(this.getResultSet().getInt(5));
                consulta.setDiastolica(this.getResultSet().getInt(6));
                consulta.setFrequencia(this.getResultSet().getString(7));
                consulta.setStatus(this.getResultSet().getString(8));
                medico.setNome(this.getResultSet().getString(9));
                paciente.setNome(this.getResultSet().getString(10));

                generico.setConsulta(consulta);
                generico.setMedico(medico);
                generico.setPaciente(paciente);

                listaGenericConsulta.add(generico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaGenericConsulta;
    }

    public boolean excluirConsulta(int idConsulta) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("DELETE FROM tbl_consulta "
                    + "WHERE id_consulta = '" + idConsulta + "'");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public Consulta getConsultaDao(int idConsulta) {
        Consulta consulta = new Consulta();
        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_consulta, "
                    + "datahora, "
                    + "paciente_idpaciente, "
                    + "medico_idmedico, "
                    + "sistole, "
                    + "diastole, "
                    + "frequencia,"
                    + "status "
                    + "FROM tbl_consulta "
                    + "WHERE id_consulta = '" + idConsulta + "'"
                    + ";"
            );
            while (this.getResultSet().next()) {
                consulta.setId_consulta(this.getResultSet().getInt(1));
                consulta.setData_consulta(this.getResultSet().getString(2));
                consulta.setPaciente(this.getResultSet().getInt(3));
                consulta.setMedico(this.getResultSet().getInt(4));
                consulta.setSistolica(this.getResultSet().getInt(5));
                consulta.setDiastolica(this.getResultSet().getInt(6));
                consulta.setFrequencia(this.getResultSet().getString(7));
                consulta.setStatus(this.getResultSet().getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return consulta;
    }

    public boolean updateConsulta(Consulta c) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL("UPDATE tbl_consulta SET "
                    + "datahora = '" + c.getData_consulta() + "', "
                    + "paciente_idpaciente = '" + c.getPaciente() + "', "
                    + "medico_idmedico = '" + c.getMedico() + "', "
                    + "sistole = '" + c.getSistolica() + "', "
                    + "diastole = '" + c.getDiastolica() + "', "
                    + "frequencia = '" + c.getFrequencia() + "', "
                    + "status= '" + c.getStatus() + "' "
                    + "WHERE id_consulta = '" + c.getId_consulta() + "' "
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro: " + e);
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public ArrayList<Generic> getListaGenericConsultaRealizadas() {
        ArrayList<Generic> listaGenericConsulta = new ArrayList<>();
        Consulta consulta = new Consulta();
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        Generic generico = new Generic();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_consulta, "
                    + "datahora, "
                    + "paciente_idpaciente, "
                    + "medico_idmedico, "
                    + "sistole, "
                    + "diastole, "
                    + "frequencia,"
                    + "status, "
                    + "nome, "
                    + "pac_nome "
                    + "FROM tbl_consulta "
                    + "INNER JOIN tbl_medico ON tbl_consulta.medico_idmedico = tbl_medico.id_medico "
                    + "INNER JOIN tbl_paciente ON tbl_consulta.paciente_idpaciente = tbl_paciente.id_paciente "
                    + "WHERE status LIKE '%SIM%' "
                    + "ORDER BY id_consulta ASC;"
            );
            while (this.getResultSet().next()) {
                generico = new Generic();
                consulta = new Consulta();
                paciente = new Paciente();
                medico = new Medico();

                consulta.setId_consulta(this.getResultSet().getInt(1));
                consulta.setData_consulta(this.getResultSet().getString(2));
                consulta.setPaciente(this.getResultSet().getInt(3));
                consulta.setMedico(this.getResultSet().getInt(4));
                consulta.setSistolica(this.getResultSet().getInt(5));
                consulta.setDiastolica(this.getResultSet().getInt(6));
                consulta.setFrequencia(this.getResultSet().getString(7));
                consulta.setStatus(this.getResultSet().getString(8));
                medico.setNome(this.getResultSet().getString(9));
                paciente.setNome(this.getResultSet().getString(10));

                generico.setConsulta(consulta);
                generico.setMedico(medico);
                generico.setPaciente(paciente);

                listaGenericConsulta.add(generico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaGenericConsulta;
    }

    public ArrayList<Generic> getListaGenericConsultaGrafico(String nome, String data, String data2) {
        ArrayList<Generic> listaGenericConsultaGrafico = new ArrayList<>();
        Consulta consulta = new Consulta();
        Paciente paciente = new Paciente();
        Generic generico = new Generic();
        Medico medico = new Medico();

        try {
            this.conectar();
            this.executarSQL("SELECT "
                    + "id_consulta, "
                    + "datahora, "
                    + "paciente_idpaciente, "
                    + "medico_idmedico, "
                    + "sistole, "
                    + "diastole, "
                    + "frequencia,"
                    + "status, "
                    + "nome, "
                    + "pac_nome "
                    + "FROM tbl_consulta "
                    + "INNER JOIN tbl_paciente ON tbl_consulta.paciente_idpaciente = tbl_paciente.id_paciente "
                    + "INNER JOIN tbl_medico ON tbl_consulta.medico_idmedico = tbl_medico.id_medico "
                    + "WHERE pac_nome LIKE '%" + nome + "%' "
                    + "AND datahora BETWEEN '" + data + "' "
                    + "AND '" + data2 + "' "
                    + "AND status LIKE '%SIM%' "
                    + "GROUP BY id_consulta, datahora, paciente_idpaciente, medico_idmedico, sistole, diastole, frequencia, status, nome, pac_nome "
                    + "ORDER BY datahora ASC;"
            );
            while (this.getResultSet().next()) {
                generico = new Generic();
                consulta = new Consulta();
                paciente = new Paciente();

                consulta.setId_consulta(this.getResultSet().getInt(1));
                consulta.setData_consulta(this.getResultSet().getString(2));
                consulta.setPaciente(this.getResultSet().getInt(3));
                consulta.setMedico(this.getResultSet().getInt(4));
                consulta.setSistolica(this.getResultSet().getInt(5));
                consulta.setDiastolica(this.getResultSet().getInt(6));
                consulta.setFrequencia(this.getResultSet().getString(7));
                consulta.setStatus(this.getResultSet().getString(8));
                medico.setNome(this.getResultSet().getString(9));
                paciente.setNome(this.getResultSet().getString(10));

                generico.setConsulta(consulta);
                generico.setPaciente(paciente);
                generico.setMedico(medico);

                listaGenericConsultaGrafico.add(generico);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listaGenericConsultaGrafico;
    }

    public boolean gerarGraficoConsultaPorNomeData(String nome, String data1, String data2) {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_consulta, "
                    + "datahora, "
                    + "paciente_idpaciente, "
                    + "medico_idmedico, "
                    + "id_paciente, "
                    + "sistole, "
                    + "diastole, "
                    + "frequencia,"
                    + "status, "
                    + "nome, "
                    + "pac_nome "
                    + "FROM tbl_consulta "
                    + "INNER JOIN tbl_paciente ON tbl_consulta.paciente_idpaciente = tbl_paciente.id_paciente "
                    + "INNER JOIN tbl_medico ON tbl_consulta.medico_idmedico = tbl_medico.id_medico "
                    + "WHERE pac_nome LIKE '%" + nome + "%' AND datahora BETWEEN '" + data1 + "' AND '" + data2 + "' AND status LIKE '%SIM%' "
                    + "GROUP BY id_consulta, datahora, paciente_idpaciente, medico_idmedico, sistole, diastole, frequencia, status, nome, pac_nome, id_paciente "
                    + "ORDER BY datahora DESC;"
            );
            JRResultSetDataSource jrRs = new JRResultSetDataSource(this.getResultSet());

            //Caminho do relatorio
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/GraficoConsulta.jasper");
            JasperPrint jasper = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);

            JasperExportManager.exportReportToPdfFile(jasper, "C:/relatorioJasper/GraficoConsultaNome.pdf");

            File file = new File("C:/relatorioJasper/GraficoConsultaNome.pdf");
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean gerarGraficoConsultaRealizadas() {
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_consulta, "
                    + "datahora, "
                    + "sistole, "
                    + "diastole, "
                    + "frequencia,"
                    + "status, "
                    + "nome, "
                    + "pac_nome "
                    + "FROM tbl_consulta "
                    + "INNER JOIN tbl_paciente ON tbl_consulta.paciente_idpaciente = tbl_paciente.id_paciente "
                    + "INNER JOIN tbl_medico ON tbl_consulta.medico_idmedico = tbl_medico.id_medico "
                    + "WHERE status LIKE '%SIM%' "
                    + "ORDER BY id_consulta ASC;"
            );
            JRResultSetDataSource jrRs = new JRResultSetDataSource(this.getResultSet());

            //Caminho do relatorio
            InputStream caminhoRelatorio = this.getClass().getClassLoader().getResourceAsStream("relatorios/ConsulrasRealizadas.jasper");
            JasperPrint jasper = JasperFillManager.fillReport(caminhoRelatorio, new HashMap(), jrRs);
            JasperExportManager.exportReportToPdfFile(jasper, "C:/relatorioJasper/ConsulTas.pdf");

            File file = new File("C:/relatorioJasper/ConsulTas.pdf");
            try {
                Desktop.getDesktop().open(file);
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, e);
            }
            file.deleteOnExit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
