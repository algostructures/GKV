// UDPServer.java: A simple UDP server program.
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
public class Server {
    public static void main(String args[]){
      DatagramSocket aSocket = null;
      if (args.length < 1) {
        System.out.println("Usage: java Server <Port Number>");
        System.exit(1);
      }
      try {
        int socket_no = Integer.valueOf(args[0]).intValue();
        aSocket = new DatagramSocket(socket_no);
        byte[] reciveBuffer = new byte[30];
        while(true) {
          System.out.println("Server Listning...");
          DatagramPacket request = new DatagramPacket(reciveBuffer, reciveBuffer.length);
          aSocket.receive(request);
          System.out.println("Request Recived For : "+ new String(request.getData()));
          Calculator calculator = new Calculator(new String(request.getData()));
          /*
          what ever you want to calculate just write method in calculator class
          and call like
          String result = calculator.yourMethod();
          */
          String result = calculator.CalculateCircleArea();
          byte[] sendBuffer = result.getBytes();
          DatagramPacket reply = new DatagramPacket(sendBuffer,sendBuffer.length,request.getAddress(),request.getPort());
          aSocket.send(reply);
          System.out.println("Request Processes With Result : "+ result);
        }
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
