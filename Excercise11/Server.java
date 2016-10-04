// UDPServer.java: A simple UDP server program.
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
