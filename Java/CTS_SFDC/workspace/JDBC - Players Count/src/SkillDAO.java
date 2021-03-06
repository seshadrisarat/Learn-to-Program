

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class SkillDAO {
  public TreeMap<Skill,Integer> skillCount(){
      TreeMap<Skill,Integer> skillCountMap = new TreeMap<Skill,Integer>();
      try{
          ResourceBundle rb= ResourceBundle.getBundle("mysql");
          String url=rb.getString("db.url");
          String user=rb.getString("db.username");
          String pass=rb.getString("db.password");
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection(url,user,pass);
          
          Statement statement = con.createStatement();
          
          String sql = "select s.id, s.name, count(p.id) as pcount"
          			+ " from skill s, player p"
          			+ " where p.skill_id = s.id"
          			+ " group by s.name"
          			+ " order by s.name";
          
          ResultSet result = statement.executeQuery(sql);
          
          while(result.next()) {
        	  skillCountMap.put(new Skill(result.getLong("id"), result.getString("name")), result.getInt("pcount"));
          }
      } catch (Exception e) {}
      
      return skillCountMap;
  }
}

