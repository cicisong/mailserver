package MailBoxManager;

class MailBox implements ImailBox
	{
		public void deleteAMessage();
		{
			system.out.println("message successfully deleted");
		}

		public void deleteReadMessages();
		{
			system.out.println("Messages successfully deleted");
		}

		public void deleteAllMessages();
		{
			system.out.println("Messages succesfully deleted");
		}

		public void readNewMessage();
		{
			system.out.println("New message read");
		}

	}
