
import java.sql.*;

public class DatabaseTable {

    int T_ID;
    String date;
    String T_Type;
    int T_Amount;
    int A_Number;
    String Served_By;
}

class DatabaseTableDAO {

    Connection con;
    PreparedStatement pst;

    void Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String mysqlURL = "jdbc:mysql://localhost:3306/oop";
            con = DriverManager.getConnection(mysqlURL, "root", "");

        } catch (Exception ex) {

        }
    }

    int Insert(DatabaseTable d) {
        int res = 0;
        try {
            Connection();
            String ins = "insert into labA values (?,?,?,?,?,?)";

            pst = con.prepareStatement(ins);

            pst.setInt(1, d.T_ID);
            pst.setString(2, d.date);
            pst.setString(3, d.T_Type);
            pst.setInt(4, d.T_Amount);
            pst.setInt(5, d.A_Number);
            pst.setString(6, d.Served_By);

            res = pst.executeUpdate();
        } catch (Exception ex) {

        }
        return res;
    }

    int Update(DatabaseTable d) {
        int res = 0;
        try {
            Connection();
            String upd = "update labA set date=?, type=?, amount=?, number=?, served_by=? where id = ?";
            pst = con.prepareStatement(upd);

            pst.setString(1, d.date);
            pst.setString(2, d.T_Type);
            pst.setInt(3, d.T_Amount);
            pst.setInt(4, d.A_Number);
            pst.setString(5, d.Served_By);
            pst.setInt(6, d.T_ID);

            res = pst.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return res;
    }

    int Delete(DatabaseTable d) {
        int res = 0;
        try {
            Connection();
            String del = "delete from labA where id = ?";
            pst = con.prepareStatement(del);

            pst.setInt(1, d.T_ID);
            res = pst.executeUpdate();

        } catch (Exception ex) {

        }
        return res;
    }

    ResultSet SelectAll() {
        ResultSet rs = null;
        try {
            String qry = "select * from labA";
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        } catch (Exception ex) {

        }
        return rs;
    }

    
}
