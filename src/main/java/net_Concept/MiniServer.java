package net_Concept;

import java.io.IOException;
import java.net.ServerSocket;

public class MiniServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);

        }catch (IOException s){
            System.out.println("Server could not be started");
        }
    }
}
