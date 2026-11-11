package net_Concept;
import java.io.IOException;
import java.net.InetAddress;
public class DNSexperiment {
    public static void main(String[] args) {
        try{
        InetAddress address = InetAddress.getByName("youtube.com");
       System.out.println("Hostname: " + address.getHostName());
       System.out.println("IP Address: " + address.getHostAddress());
        InetAddress local = InetAddress.getByName("localhost");
        System.out.println(local.getHostName());
        System.out.println(local.getHostAddress());
        }catch(IOException e){
            System.out.println("DNS not working");
        }
    }
}