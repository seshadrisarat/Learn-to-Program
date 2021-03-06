
import java.util.List;

public class Main {
    public static void main(String ags[])throws Exception{
        System.out.println("List of all player and their skill"); 
        System.out.println(String.format("%-15s%-30s%-30s%-15s","Id", "Name", "Country","Skill"));
        List<Player> playerList = null;
        PlayerDAO playerIns = new PlayerDAO();
 
        playerList = playerIns.getAllPlayers();
        
        for(Player p : playerList) { 
            System.out.println(String.format("%-15d%-30s%-30s%-15s",p.getPlayerId(), p.getName(), p.getCountry(), p.getSkill().getSkillName()));
        }  
        
    }
}
