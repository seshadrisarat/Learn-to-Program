
import java.util.List;


public class Main {
    
    public static void main(String ags[])throws Exception{
        System.out.println("List of all City"); 
        List<City> cityList = null;
        CityDAO cityIns = new CityDAO();
 
        cityList = cityIns.listAllCity();
        
        int i=0;
        for(City c : cityList) {
        	System.out.println((++i) + ") " + c.getSkillName());
        }
    }
}
