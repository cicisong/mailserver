package MailBoxManager;

class MailBoxManager implements ImailBoxManager
	{
		public void readAUserNewMessages(String message)
		{
			system.out.println("Message read");
		}

		public void readAUserAllMessages(String subject);
		{
			system.out.println("Messages read");
		}

		public void deleteAUserMessage(String message);
		{
			system.out.println("message successfully deleted");
		}

		public void deleteAUserReadMessages(string messages);
		{
			system.out.println("Messages successfully deleted");
		}

		public void sendAMessageToABox(String subject, String message);
		{
			system.out.println("Message succesfully sent");
		}

		public void addUser(String user, String password );
		{
			system.out.println("User successfully added");
		}

		public void removeUser(String user);
		{
			system.out.println("User succesfully removed");
		}

		public void sendNews(String message );
		{
			system.out.println("News successfuly sent");
		}
	}
