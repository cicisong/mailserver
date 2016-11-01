
import javax.xml.ws.Endpoint;
import java.sql.*;
import java.lang.String;
import java.util.Properties;


public class DirectoryManager {
	Connection c;
	public DirectoryManager(Connection c){
		this.c = c;
	}


	public void insertUser(String username, String password, String address){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("INSERT INTO utilisateur (username, password, address) VALUES('"+username+"','"+password+"', '"+address+"')");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public void deleteUser(int id){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("DELETE FROM utilisateur WHERE idUser = "+id);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


	public int getUserId(String user, String mdp){
		Statement s;

		try{

			s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT idUser FROM utilisateur WHERE username = '"+user +"' AND password = '"+mdp+"'");
			rs.next();
			return rs.getInt("idUser");
 
		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return -1; 
	}


	public void setRights(int idUser, int idMailingList, int readingRight, int writingRight){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("INSERT INTO rel (idUser, idMailingList,  	droitLecture, droitEcriture) VALUES("+idUser+","+idMailingList+","+readingRight+", "+writingRight+")");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateRights (int idUser, int idMailingList, int readingRight, int writingRight) {

		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("UPDATE rel SET droitLecture = "+ readingRight +", droitEcriture = "+ writingRight +" WHERE idUser = "+idUser+" AND idMailingList = "+idMailingList);

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}	
		
	public int getUserReadingRight(int idUser, int idMailingList){
		Statement s;

		try{

			s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT droitLecture FROM rel WHERE idUser = '"+idUser +"' AND idMailingList = '"+idMailingList+"'");
			rs.next();
			return rs.getInt("droitLecture");
 
		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return -1; 
	}

	public int getUserWritingRight(int idUser, int idMailingList){
		Statement s;

		try{

			s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT droitEcriture FROM rel WHERE idUser = '"+idUser +"' AND idMailingList = '"+idMailingList+"'");
			rs.next();
			return rs.getInt("droitEcriture");
 
		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return -1; 
	}


	//delete user's rights when a user is deleted
	public void deleteRightUser(int idUser){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("DELETE FROM rel WHERE idUser = "+idUser);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	//delete user's rights when a mailinglist is deleted
	public void deleteRightUser(int idMailingList){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("DELETE FROM rel WHERE idMailingList = "+idMailingList);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
