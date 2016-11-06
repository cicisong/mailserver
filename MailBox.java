package MailBoxManager;
/*
class inherits methods from super class Box
*/
public class MailBox extends Box
{
/*
class implements the interface
*/
class MailBox implements ImailBox
	{
		public void deleteAMessage();
		{
			system.out.println("message deleted");
		}

		public void deleteReadMessages();
		{
			system.out.println("Messages deleted");
		}

		public void deleteAllMessages();
		{
			system.out.println("Messages deleted");
		}

		public void readNewMessage();
		{
			system.out.println("New message read");
		}

	}
}
