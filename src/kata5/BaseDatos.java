package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatos {
    private String url;
    Connection connection;

    public BaseDatos(String url) {
        this.url = url;
        connection = null;
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.url);
            System.out.println("Base de Datos abierta");
        } catch (SQLException exception) {
            System.out.println("ERROR BaseDatos::open (SQLException) " + exception);
        }
    }

    void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
                    System.out.println("Base de Datos cerrada");
            } catch (SQLException exception) {
                System.out.println("ERROR BaseDatos::close (SQLException) " + exception);
            }
        }
    }

    void select_PERSONAS() {
        String SQL = "SELECT * FROM PERSONAS";
        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            
            System.out.println("ID \t NOMBRE \t APELLIDOS \t DEPARTAMENTO");
            System.out.println("-- \t ------ \t --------- \t ------------");
            while (resultset.next()) {
                System.out.println(resultset.getInt("ID") + " \t" +
                        resultset.getString("NOMBRE") + " \t" + 
                        resultset.getString("APELLIDOS") + " \t" + 
                        resultset.getString("DEPARTAMENTO") + " \t" );
            }
                    
        } catch (SQLException exception) {
            System.out.println("ERROR BaseDatos::select_PERSONAS (SQLException) " + exception);
        }
    }

    void insert_PERSONAS(People people) {
        String SQL = "INSERT INTO PERSONAS(NOMBRE, APELLIDOS, DEPARTAMENTO) VALUES(?,?,?)";
        
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(SQL);
            preparedStatement.setString(1, people.getNombre());
            preparedStatement.setString(2, people.getApellido());
            preparedStatement.setString(3, people.getDepartamento());
            preparedStatement.executeUpdate();
            
        } catch (SQLException exception) {
            System.out.println("ERROR BaseDatos::insert_PERSONAS (SQLException) " + exception.getMessage());
        }
        
    }
    
}
