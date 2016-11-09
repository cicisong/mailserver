package Server;


public class NewsGroupRight {

	int readNewsGroup;
	int writeNewsGroup;
	
	
	/** Constructor
	*
	*/
	public NewsGroupRight(){
	
	}
	
	/**Getting the value for the reading access of a user to a mailing list
	* @param user
	* @param mailName mailinglist's name
	* @return the value of the right 0: cannot read, 1: can read
	*/	
	public int getReadAccess(String user, String mailName){
	
	}
	
	/** Setting the access of a user to a mailing list so that he can read
	* @param user
	* @param mailName mailinglist's name 
	*/
	public void setReadAccess(String user, String mailName){
	
	}

	/** Setting the access of a user to a mailing list so that he cannot read
	* @param user
	* @param mailName mailinglist's name 
	*/
	public void unsetReadAccess(String user, String mailName){
	
	}

	/**Getting the value for the reading access of a user to a mailing list
	* @param user
	* @param mailName mailinglist's name
	* @return the value of the right 0: cannot read, 1: can read
	*/	
	public int getWriteAccess(String user, String mailName){
	
	}

	/** Setting the access of a user to a mailing list so that he can read
	* @param user
	* @param mailName mailinglist's name 
	*/
	public void setWriteAccess(String user, String mailName){
	
	}

	/** Setting the access of a user to a mailing list so that he cannot read
	* @param user
	* @param mailName mailinglist's name 
	*/
	public void unsetWriteAccess(String user, String mailName){
	
	}

}
