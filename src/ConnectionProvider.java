 
import java.io.FileInputStream;
//import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *
 * @author kk
 */
public class ConnectionProvider {
	public static Properties prop;
	static {
		try {
			prop = new Properties();
			prop.load(new FileInputStream("db.properties"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static Connection getConnection() {
		Connection con = null;
		try {

			Class.forName(prop.getProperty("drivername"));
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
        
        public static void main(String[] arg)
        {
            System.out.println("statis  "+getConnection());
        }
}
