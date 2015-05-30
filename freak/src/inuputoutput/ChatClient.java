package inuputoutput;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class ChatClient
{
   private Socket          socket   = null;
   private Scanner Recieving=null;
   private Scanner Sending=null;
   private boolean inManage=false;
   private PrintWriter out1=null;
   public ChatClient(String serverName, int serverPort)
   {
	  System.out.println("Establishing connection. Please wait ...");
      try
      {  socket = new Socket(serverName, serverPort);
         System.out.println("Connected: " + socket);
          Recieving = new Scanner(socket.getInputStream());
		  Sending= new Scanner(System.in);
		 out1 = new PrintWriter(socket.getOutputStream());
      }
      catch(UnknownHostException uhe)
      {  System.out.println("Host unknown: " + uhe.getMessage());
      }
      catch(IOException ioe)
      {  System.out.println("Unexpected exception: " + ioe.getMessage());
      }
   }
   public void stop()
   {  try
      {
         if (socket    != null)  socket.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error closing ...");
      }
   }
   public void Manage()
   {
	   if(inManage==true)
	      return;
	   inManage=true;
       System.out.println("Client In Manage");
	  	   	   				if (Recieving.hasNextLine())
	  	   	   				{
	  	   	   					String input = Recieving.nextLine();
	  	   	   					System.out.println("Client : " + input);
	  	   	   				}
	  	   	   				if (Sending.hasNextLine())
	  	   	   				{
	  	   	   					String input = Sending.nextLine();
	  	   	   					out1.println((new Date()).toString()+": " + input);
	  	   	   				}
	  inManage=false;
   }
   public static void main(String args[])
   {
      String serverAddress = JOptionPane.showInputDialog(
          "Enter Server IP Address:");
      final ChatClient client = new ChatClient( serverAddress,8800);
      Timer timer=null;
      timer=new Timer();
	  	         timer.schedule(new TimerTask() {
	  	     @Override
	  	     public void run() {
	  	            client.Manage();
	  	   	    }
            },0, 1000);
   }
}