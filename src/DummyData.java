import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class DummyData {
  String query=null;
 Statement st=null;
 
 public DummyData(String qry) {
       query=qry;
    }

 public Vector getData()throws Exception
{  
    Vector<Vector<String>> cVector = new Vector<Vector<String>>();

Connection con = ConnectionProvider.getConnection();
st=con.createStatement();

ResultSet rs = st.executeQuery(query);

while(rs.next())
{
Vector<String> custVet = new Vector<String>(); //Empid
custVet.add(""+rs.getInt(1)); //name
custVet.add(rs.getString(2)); //position
custVet.add(rs.getString(3)); //department
custVet.add(rs.getString(4)); //name
custVet.add(""+rs.getInt(5)); 
custVet.add(""+rs.getInt(6));
custVet.add(""+rs.getInt(7));

cVector.add(custVet);
}
if(con!=null)
con.close();

return cVector;
}
}
