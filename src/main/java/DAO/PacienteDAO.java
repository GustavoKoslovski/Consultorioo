package DAO;

import Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {

    private Connection connection;

    public PacienteDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaMedico() {
        String sql = "CREATE TABLE IF NOT EXISTS pacientes (" +
                "idPaciente BIGSERIAL PRIMARY KEY," +
                "tipoAtendimento VARCHAR(30)" +
                "dataContratacao TIMESTAMP" +
                "numeroCartaoConvenio VARCHAR (30)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


}
