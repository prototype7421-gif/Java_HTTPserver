package core;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;

public class Server{
    public static void main(String[] args) {
        System.out.println("HyperPage Loading.....");
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8080);
        try {
            ServerSocket server = new ServerSocket();
            server.bind(address);
            System.out.println("Server Started");
            Socket socket =server.accept();
            System.out.println("Accepted connection from "+ socket.getInetAddress().getHostAddress());
            byte[] buffer = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            int bytesRead  ;
            while((bytesRead = inputStream.read(buffer) )!= -1) {
                String message = new String(buffer, 0, bytesRead,StandardCharsets.UTF_8);
                System.out.println("Received: " + message);
                String m = "Can send message: " + message;
                byte[] responseBytes = m.getBytes(StandardCharsets.UTF_8);
                outputStream.write(responseBytes);
                outputStream.flush();
            }
        }
        catch(IOException ServerBinding) {
            System.out.println("Server connections failes" + ServerBinding.getMessage());
        }
    }
}