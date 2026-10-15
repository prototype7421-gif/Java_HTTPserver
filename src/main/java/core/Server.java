package core;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
public class Server{
    public static void main(String[] args) {
       System.out.println("HyperPage Loading....."); 
    ServerSocket server = new ServerSocket();
    
        InetSocketAddress address  = new InetSocketAddress("127.0.0.1", 8080);
        server.bind(address);
      }
    }