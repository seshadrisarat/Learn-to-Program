import java.sql.*;

class GetTablesFromDb{
  public static void main(String args[]){
    try{
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mySqlDb","root","mkteq1mu");
      DatabaseMetaData dbmd=con.getMetaData();

      String table[] = {"TABLE"};
      ResultSet rs = dbmd.getTables(null, null, null, table);
      while(rs.next())
        System.out.println("\n\n\nNumber of Tables:\t" + rs.getString(3));
      con.close();
    }catch(Exception e){
      System.out.println(e);
    }
  }
}
