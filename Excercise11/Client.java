// UDPClient.java: A simple UDP client program.
/***
Usage :
1. Run the Sever Program with : java server 8000
2. Run Client Program with : java Client redius  127.0.0.1  8000
Note 1 : redius is a Positive Integer
Note 2 : If Program Requires Multiple Numbers Just separate them with comma like 2,3,4,5
  then usgae will be : java Client 2,3,4,5 127.0.0.1 8000
***/
import java.net.*;
import java.io.*;
public class Client {
 public static void main(String args[]){
 // args give message contents and server hostname
   DatagramSocket aSocket = null;
   if (args.length < 3) {
     System.out.println("Usage: java UDPClient <number> <Host name> <Port number>");
     System.exit(1);
   }
   try {
     aSocket = new DatagramSocket();
     byte [] sendBuffer = args[0].getBytes();
     InetAddress aHost = InetAddress.getByName(args[1]);
     int serverPort = Integer.valueOf(args[2]).intValue();
     DatagramPacket request =new DatagramPacket(sendBuffer, args[0].length(), aHost, serverPort);
     aSocket.send(request);
     byte[] reciveBuffer = new byte[30];
     DatagramPacket reply = new DatagramPacket(reciveBuffer, reciveBuffer.length);
     aSocket.receive(reply);
     System.out.println("Reply: " + new String(reply.getData()));
   }
   catch (SocketException e) {
     System.out.println("Socket: " + e.getMessage());
   }
   catch (IOException e) {
     System.out.println("IO: " + e.getMessage());
   }
   finally {
     if (aSocket != null)
      aSocket.close();
   }
  }
}
