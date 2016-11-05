public class Message
{
   String senderName;
   String receiverName;
   String subject;
   String sendingDate;
   int alreadyRead;  
   /*
   this method set the alreadyread as an is read
   */
   public void setIsRead( int isread)
   {
       alreadyRead=isread;
   }
   /*
   this method is a boolean true when read and false when not
   */
   public static boolean IsRead(int isread)
   { 
       return isread == 1;
     }   
}