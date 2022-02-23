package DAO;
import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {

    private Connection connection;

    public MedicoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaMedico() {
        String sql = "CREATE TABLE IF NOT EXISTS medicos (" +
                "idMedico BIGSERIAL PRIMARY KEY," +
                "nomeMedico VARCHAR(50)" +
                "porcenParticipacao DECIMAL" +
                "consultorio VARCHAR (30)" +
                ");";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
