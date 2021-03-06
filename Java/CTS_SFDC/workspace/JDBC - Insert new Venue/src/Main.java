

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.List;


public class Main {
  
  public static void main(String ags[])throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String name;
    

      System.out.println("Enter venue name");
      name = br.readLine();
  
    
      System.out.println("Enter the city");
      System.out.println("1.Pune");
      System.out.println("2.Hyderabad");
      System.out.println("3.Delhi");
      Integer choice = Integer.parseInt(br.readLine());
      City cityIns = null;
      CityDAO city = new CityDAO();
      List<Venue> venueList = null;
      VenueDAO venueIns = new VenueDAO();
      
      String cityName = "";
      if(choice==1)	cityName="Pune";
      else if(choice == 2) cityName="Hyderabad";
      else if(choice == 3) cityName="Delhi";  
      cityIns = city.getCityByName(cityName);  
      venueIns.createVenue(new Venue(name, cityIns));
      
      venueList = venueIns.getAllVenues();
      
      System.out.println("Venue Details are:"); 
      System.out.println(String.format("%-50s%-25s", "Name","City"));
      
      for(Venue v : venueList) { 
          System.out.println(String.format("%-50s%-25s", v.getName(), v.getCity().getCityName()));
      }  
  }
  
      
}
