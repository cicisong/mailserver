package Server;

import javax.xml.ws.Endpoint;

import java.sql.*;

import java.lang.String;

import java.util.*;



public class DirectoryManager {
	
  private static final String dbClassName = "com.mysql.jdbc.Driver";

  private static final String CONNECTION =
                          "jdbc:mysql://127.0.0.1/mailServer?user=root&password=root";
                          
  public static Connection c;
  
/**
* @param username the new user's username
* @param password the new user's password
* @param password the new user's email address
*/
	public static Connection initConnection() throws Exception {
		Class.forName(DirectoryManager.dbClassName);
		DirectoryManager.c = DriverManager.getConnection(DirectoryManager.CONNECTION);
		return DirectoryManager.c;
	}
	
	
	/**to insert a user in the database
	* @param username the new user's username
	* @param password the new user's password
	* @param password the new user's email address
	*/
	public static void insertUserDB(String username, String password, String address){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("INSERT INTO utilisateur (username, password, address) VALUES('"+username+"','"+password+"', '"+address+"')");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**Delete a user in the database
	* @param id
	*/
	public static void deleteUserDB(int id){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("DELETE FROM utilisateur WHERE idUser = "+id);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**To get all the users from the database
	* @return map of users
	*/
	public static Users getUsersDB(){
		Statement s;
		Users liste = new Users ();

		try{

			s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT username,address, droitLecture, droitEcriture FROM utilisateur u, rel r WHERE u.idUser = r.idUser");
			while ( rs.next() ){
			
				FinalUser user = new FinalUser(rs.getString("username"),rs.getString("address"), rs.getInt("droitLecture"), rs.getInt("droitEcriture"));
				liste.createUser(rs.getString("username"), user);
 
 			}
 		
 			return liste;
 		
		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return null; 
	}


/** get the id of a user in the database
* @param username the new user's username
* @reuturn idUser the id of the user
*/
	public static int getUserIdDB(String user){
		Statement s;

		try{

			s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT idUser FROM utilisateur WHERE username = '"+user +"'");
			rs.next();
			return rs.getInt("idUser");
 
		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return -1; 
	}


/** Set the reading or the writing rights of a user
* @param idUser the id of the user
* @param idMailingList the id of the mailing list we want to subscribe
* @param readingRight the value we want for the reading right of the user for this mailing list
* @param writingRight the value we want for the writing right of the user for this mailing list
*/
	public static void setRightsDB(int idUser, int idMailingList, int readingRight, int writingRight){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("INSERT INTO rel (idUser, idMailingList,  	droitLecture, droitEcriture) VALUES("+idUser+","+idMailingList+","+readingRight+", "+writingRight+")");
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateRightsDB (int idUser, int idMailingList, int readingRight, int writingRight) {

		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("UPDATE rel SET droitLecture = "+ readingRight +", droitEcriture = "+ writingRight +" WHERE idUser = "+idUser+" AND idMailingList = "+idMailingList);

		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}	
		
		
	/** Get the reading right of a user from the database for a mailinglist
	* @param idUser the id of the user
	* @param idMailingList the id of the mailing list
	* @return readingRight the value we want for the reading right of the user for this mailing list  
	*/
	public static int getUserReadingRightDB(int idUser, int idMailingList){
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
	
	/** Get the reading right of a user from the database for all the mailinglists
	* @param idUser the id of the user
	* @return readRights the value for the reading right of the user for all the mailinglists  
	*/	
	public static Rights getUserRRsDB(String username){
	
		Statement s;
		Rights readRights = new Rights ();

		try{

			s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT droitLecture, idMailingList FROM utilisateur u, rel r WHERE u.username = '" + username + "' AND u.idUser = r.idUser");
			while ( rs.next() ){
			
				readRights.createRR(rs.getInt("idMailingList"), rs.getInt("droitLecture"));
 
 			}
 		
 			return readRights;
 		
		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return null;
	
	}
	
	
	/** Get the writing right of a user from the database for a mailinglists
	* @param idUser the id of the user
	* @param idMailingList the id of the mailing list
	* @return readRights the value for the writing right of the user for this mailing list  
	*/	
	public static int getUserWritingRightDB(int idUser, int idMailingList){
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

	
	/** Get the writing right of a user from the database for all the mailinglists
	* @param idUser the id of the user
	* @return readRights the value for the reading right of the user for all the mailinglists 
	*/	
	public static Rights getUserWRsDB(String username){
	
		Statement s;
		Rights writeRights = new Rights ();

		try{

			s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT  droitEcriture , idMailingList FROM utilisateur u, rel r WHERE u.username = '" + username + "' AND u.idUser = r.idUser");
			while ( rs.next() ){
			
				writeRights.createRR(rs.getInt("idMailingList"), rs.getInt("droitEcriture"));
 
 			}
 		
 			return writeRights;
 		
		}catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return null;
	
	}
	


	//delete user's rights when a user is deleted
	public static void deleteRightUserDB(int idUser){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("DELETE FROM rel WHERE idUser = "+idUser);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	//delete user's rights when a mailinglist is deleted
	public static void deleteRightUserMailingDB(int idMailingList){
		Statement s;		
		try{
			s = c.createStatement();
			s.executeUpdate("DELETE FROM rel WHERE idMailingList = "+idMailingList);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
