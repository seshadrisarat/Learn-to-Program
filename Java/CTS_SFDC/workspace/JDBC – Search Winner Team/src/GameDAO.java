

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GameDAO {
  
  
      List<Game> displayMatchDetails(Date gameDate) throws SQLException, ClassNotFoundException
      {

    	  List<Game> games = new ArrayList<>();
    	  
              Connection con = null;

              ResourceBundle rb = ResourceBundle.getBundle("mysql");
              String url = rb.getString("db.url");
              String user = rb.getString("db.username");
              String pass = rb.getString("db.password");

                      try {
                          Class.forName("com.mysql.jdbc.Driver");
                      } catch (ClassNotFoundException ex) {
                          Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
                      }
              con = DriverManager.getConnection(url,user,pass);
              

              
              Statement statement = con.createStatement();
              
              String sql = "select * from game where game_date=\"" + new SimpleDateFormat("yyyy-MM-dd").format(gameDate) + "\" order by game_date";
              
              ResultSet result = statement.executeQuery(sql);
              
              while(result.next()) {
            	  games.add(new Game(result.getDate("game_date"), new OutComeDAO().FindByOutcomeID(result.getLong("outcome_id"))));
              }
              
              return games;
      }
  }



