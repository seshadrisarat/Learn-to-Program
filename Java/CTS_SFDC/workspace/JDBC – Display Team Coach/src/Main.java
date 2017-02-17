
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException, ParseException, SQLException, ClassNotFoundException {

      BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
     

      System.out.println("Enter the team name:");
      String teamName = inp.readLine();
     
      TeamDAO teamDAO = new TeamDAO();
      
      List<Team> teamList=teamDAO.listTeams(teamName);
   
      System.out.println("Team Coach");

      
      for(Team t : teamList) { 
          System.out.println(t.getCoach());
      }

  }

}
