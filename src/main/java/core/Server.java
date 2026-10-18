package core;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

public class Server{
    void main() {
       System.out.println("HyperPage Loading.....");
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);
    try {
        ServerSocket server = new ServerSocket();
        server.bind(address);
        Socket socket =server.accept();
        System.out.println("Accepted connection from "+ socket.getInetAddress().getHostAddress());
         byte[] buffer = new byte[1024];
        InputStream inputStream = socket.getInputStream();
            int bytesRead  ;

         while((bytesRead = inputStream.read(buffer) )!= -1){
             String message = new String(buffer,0,bytesRead);
             System.out.println("Received: " + message);
         }
    }
    catch(IOException ServerBinding) {
        System.out.println("Server connections failes" + ServerBinding.getMessage());
    }
      }
    }