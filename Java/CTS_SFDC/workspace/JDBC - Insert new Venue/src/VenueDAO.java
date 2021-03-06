

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class VenueDAO {
  
  public void createVenue(Venue venue) throws ClassNotFoundException, SQLException {
       ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String username=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,username,pass);
      
      Statement statement = con.createStatement();
      
      String sql = "select id from venue order by id desc";
      
      ResultSet result = statement.executeQuery(sql);
      result.next();
      
      long id = result.getLong("id");
      result.close();
      
      sql = "insert into venue(id,name,city_id) values(" 
    		  + (++id) + ",'" + venue.getName() + "'," + venue.getCity().getCityId() + ")";
      statement.executeUpdate(sql);
      
      System.out.println("Venue has been created");
  }
  
   public List<Venue> getAllVenues() throws ClassNotFoundException, SQLException{
	  List<Venue> venues = new ArrayList<>();
		  
      ResourceBundle rb= ResourceBundle.getBundle("mysql");
      
      String url=rb.getString("db.url");
      String user=rb.getString("db.username");
      String pass=rb.getString("db.password");
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection(url,user,pass);
      
      Statement statement = con.createStatement();
      
      String sql = "select * from venue order by name";
      
      ResultSet result = statement.executeQuery(sql);
      
      CityDAO cityIns = new CityDAO();
      
      while(result.next()) {
    	  venues.add(new Venue(result.getString("name"), cityIns.getCityByID(result.getLong("city_id"))));
      }
      
      return venues;
  }
  
  
}

