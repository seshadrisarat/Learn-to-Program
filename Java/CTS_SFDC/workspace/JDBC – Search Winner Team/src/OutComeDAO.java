

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class OutComeDAO {
  
  
    public OutCome FindByOutcomeID(Long id) throws ClassNotFoundException, SQLException {
      ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
      
      Statement statement = con.createStatement();
      
      String sql = "select id, winner_team_id from outcome where id=" + id;
      
      ResultSet result = statement.executeQuery(sql);
      result.next();

      return new OutCome(result.getLong("id"), new TeamDAO().getTeamByID(result.getLong("winner_team_id")));
  }
}
