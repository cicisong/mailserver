
import javax.xml.ws.Endpoint;
import java.sql.*;
import java.lang.String;
import java.util.Properties;


public class Mailserver {
	
  private static final String dbClassName = "com.mysql.jdbc.Driver";

  private static final String CONNECTION =
                          "jdbc:mysql://127.0.0.1/mailServer?user=root&password=root";

    public static void main(String args[]) throws Exception {

	    Class.forName(dbClassName);

		Connection c = DriverManager.getConnection(CONNECTION);
		DirectoryManager UM = new DirectoryManager(c);
		System.out.println(UM.getUserReadingRight( 2, 1));
		System.out.println("It works !");
		c.close();
      
		System.out.println("Server exiting");
      System.exit(0);
    }
}
