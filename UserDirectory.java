package Server;

import java.io.IOException;

import java.util.Properties;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;


@Path("/userdirectory")
public class UserDirectory {

	public UserDirectory(){
		System.out.println("toto");
	}
	
	
	/**REST : to add a user
	*@param  username
	*@param  password
	*@param  address
	*/	
	@POST
	@Path("/addUser")
  @Consumes({MediaType.APPLICATION_XML})
	public void addUser(String username, String password, String address){
	
		System.out.println("addUser");
		DirectoryManager.insertUserDB(username, password, address);
	}
	
	
	/**REST : to list all users
	*@return list of users 
	*/
	@GET
	@Path("/alluser")
	@Produces(MediaType.TEXT_XML)
	public Users lookupAllUsers() throws IOException {
		//System.out.println("all");
		return DirectoryManager.getUsersDB();
	}
	

	
	/**REST : Look the reading right of a user (Reading and Writing)
	* @param username
	* @return a hashmap<idMailinglist, readingRight>
	*/
	@GET
	@Path("/getrights/R/{user}")
	@Produces(MediaType.TEXT_XML)
	public Rights lookupAUserRRights(@PathParam("user")String username){
		System.out.println("getAUserRights R");
		return DirectoryManager.getUserRRsDB(username);
	
	}
	
	
	/**REST : Look the writing right of a user (Reading and Writing)
	* @param username
	* @return a hashmap<idMailinglist, writingRight>
	*/
	@GET
	@Path("/getrights/W/{user}")
	@Produces(MediaType.TEXT_XML)
	public Rights lookupAUserWRights(@PathParam("user")String username){
		System.out.println("getAUserRights W");
		return DirectoryManager.getUserWRsDB(username);
	
	}
	

	/**REST : to delete a user 
	* @param username 
	*/
	@DELETE
	@Path("/delete/{user}")
	public void removeUser(@PathParam("user")String username) throws IOException{
		System.out.println(username);
		int id = DirectoryManager.getUserIdDB(username);
		DirectoryManager.deleteUserDB(id);
	
	}
	
	
	/**Update the rights of a user (Reading or Writing)
	* @param username
	* @param right the right we want to modify (reading or writing)
	* @param value 1 : has the right, 0 : 0 does not have the right
	* @param mailName the name of the mailing list 
	*/
	@PUT
	@Path("/updateAUserRights/{name}")
  @Consumes({MediaType.TEXT_PLAIN})
	public void updateAUserRights(String username, int right, int value, String mailName){
	
	}

}
