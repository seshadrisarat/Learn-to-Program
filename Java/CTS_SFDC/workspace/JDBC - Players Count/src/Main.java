
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
    
    public static void main(String ags[]) throws Exception {
        System.out.format("%-25s %s\n","Skill","Players");
        TreeMap<Skill,Integer> skillCountMap = null;
        SkillDAO skillDAOIns = new SkillDAO();
        
        skillCountMap = skillDAOIns.skillCount();
        
        for(Entry<Skill, Integer> e : skillCountMap.entrySet()) { 
            System.out.println(String.format("%-25s %s", e.getKey().getSkillName(), e.getValue()));
        }  
    }
}
