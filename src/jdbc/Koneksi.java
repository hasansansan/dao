package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Koneksi {
   

    private static Koneksi instance = new Koneksi();
    private static Connection conn;

    public static Koneksi getInstance() {
        return instance;
    }

    public static Connection getConnection() {
        return conn;
    }

    private Koneksi() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //cara 1
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/db_data","root","");
            
            //cara 2            
//            MysqlDataSource dataSource = new MysqlDataSource();
//            dataSource.setUser("kul");
//            dataSource.setPassword("123456");
//            dataSource.setServerName("localhost");
//            dataSource.setDatabaseName("kuliah");
//            conn = dataSource.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
