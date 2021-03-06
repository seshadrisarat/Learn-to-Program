


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;



public class GameDAO {

	

	public List<Game> getAllGameDetails() throws ClassNotFoundException, SQLException {

	       List<Game>Al=new ArrayList<>();
	      try
	      {
	             
	          ResourceBundle rb= ResourceBundle.getBundle("mysql");
	          
	          String url=rb.getString("db.url");
	          String user=rb.getString("db.username");
	          String pass=rb.getString("db.password");
	          Class.forName("com.mysql.jdbc.Driver");
	          Connection con = DriverManager.getConnection(url,user,pass);
	          
	          Statement statement = con.createStatement();
	          
	          String sql = "select * from game";
	          
	          ResultSet result = statement.executeQuery(sql);
	          
	          while(result.next()) {
	        	  Al.add(new Game(String.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(result.getDate("game_date"))), new TeamDAO().getTeamByID(result.getLong("team_id_1")), new TeamDAO().getTeamByID(result.getLong("team_id_2"))));
	          }
	          
	      } catch (Exception e) {	}
	      
	      return Al;

	  }
  
  public void updateTeamDetails(Date gameDate,String team1,String team2) throws ClassNotFoundException, SQLException, ParseException {
    
	  ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
      
      Statement statement = con.createStatement();
      
      String sql = "update game set team_id_1=" + new TeamDAO().getTeamByName(team1).getTeamId() + ", team_id_2=" + new TeamDAO().getTeamByName(team2).getTeamId() + " where game_date=\"" + new SimpleDateFormat("yyyy-MM-dd").format(gameDate) + "\"";
      statement.executeUpdate(sql); 
  }
  public static void displayGame(List<Game> gameList){
      System.out.format("%-15s %-30s %-30s\n","Game Date","Team 1","Team 2"); 
      
      for(Game g : gameList) { 
          System.out.println(String.format("%-15s %-30s %-30s", g.getGameDate(), g.getTeam1().getTeamName(), g.getTeam2().getTeamName()));
      }
  }
	
}
