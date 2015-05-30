package inuputoutput;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
 
public class ChatServer
{  private Socket          socket   = null;
   private ServerSocket    server   = null;
   private Scanner Recieving=null;
   private Scanner Sending=null;
   private PrintWriter out1=null;
   private boolean inManage=false;
   public ChatServer(int port)
   {  try
      {
		 System.out.println("Binding to port " + port + ", please wait  ...");
         server = new ServerSocket(port);
         System.out.println("Server started: " + server);
         System.out.println("Waiting for a client ...");
         socket = server.accept();
         System.out.println("Client accepted: " + socket);
 		try
 		{
 			Recieving = new Scanner(socket.getInputStream());
 			Sending= new Scanner(System.in);
			out1 = new PrintWriter(socket.getOutputStream());
 
 		}
 		catch (Exception e)
 		{
 			e.printStackTrace();
		}
         close();
      }
      catch(IOException ioe)
      {
		  System.out.println(ioe);
      }
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();
   }
 
   public void Manage()
   {
	   if(inManage==true)
	      return;
	   inManage=true;
	          System.out.println("Server In Manage");
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
      final ChatServer server = new ChatServer(8800);
      Timer timer=null;
      timer=new Timer();
	  	         timer.scheduleAtFixedRate(new TimerTask() {
	  	     @Override
	  	     public void run() {
	  	            server.Manage();
	  	   	    }
            },0, 1000);
   }
}