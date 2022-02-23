package DAO;
import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SecretariaDAO {

    private Connection connection;

    public SecretariaDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criarTabelaMedico() {
        String sql = "CREATE TABLE IF NOT EXISTS secretarias (" +
                "idSecretaria BIGSERIAL PRIMARY KEY," +
                "salario DECIMAL," +
                "dataContratacao TIMESTAMP," +
                "pis VARCHAR (30)" +
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
