package gameDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VenueDAO {
	public String[] getAllVenues() throws ClassNotFoundException, SQLException {
		
		Connection con = DBConnection.getConnection();
        
        Statement statement = con.createStatement();
        
        String sql = "select * from venue";
        
        ResultSet result = statement.executeQuery(sql);
        
        List<String> Al = new ArrayList<>();
        
        while(result.next()) {
      	  Al.add(result.getString("name"));
        }

		String[] venues = new String[5];
		venues[0] = ("<option>Feroz Shah Kotla</option>");
		venues[1] = ("<option>MA Chidambaram Stadium</option>");
		venues[2] = ("<option>Punjab Cricket Association Stadium</option>");
		venues[3] = ("<option>M.Chinnaswamy Stadium</option>");
		venues[4] = ("<option>Rajiv Gandhi International Stadium</option>");
		
		return (String[]) Al.toArray();
	}
}

