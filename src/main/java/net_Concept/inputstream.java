package net_Concept;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class inputstream{
    public static void main(String[] args) {
        try{
        InputStream in = new FileInputStream("data.txt");
         int data;
         while((data = in.read()) != -1){
            byte[]buffer = {55,66,77};
       int byteread =   in.read(buffer);
       System.out.println(byteread);
         in.skip(56);
         }
        }catch(IOException e){
           System.out.println("not reading");
        }
}
}