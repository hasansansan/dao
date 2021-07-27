package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void readAll() {
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_data");
            while (rs.next()) {
                System.out.print(rs.getString("id"));
                System.out.print(" --> ");
                System.out.println(rs.getString("nama"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read all error: "+ex.getMessage());
        }
    }
    public List<User> readAlltoList() {
        List<User> list = new ArrayList<User>();
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_data");
            while (rs.next()) {
                User user = new User();
                user.setId( rs.getString("id") );
                user.setNama(rs.getString("nama") );
                user.setAlamat(rs.getString("alamat") );
                list.add(user);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read all error: "+ex.getMessage());
        }
        return list;
    }
    public int insertOne(String id, String n, String a) {
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO tb_data (id,nama,alamat) VALUES ("
                    + "'" + id + "','"
                    + n + "','"
                    + a + "')";
            int i = st.executeUpdate(sql);
            st.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("insert error: "+ex.getMessage());
            return 0;
        }
    }
    public int deleteOne(String id) {
        try {
            Connection con = Koneksi.getConnection();
            String sql = "delete from tb_data where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,id);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
    public int updateOne(String id, String nama, String alamat) {
        try {
            Connection con = Koneksi.getConnection();
            String sql = "update tb_data set nama=?, alamat=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setString(2,alamat);
            ps.setString(3,id);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
}
