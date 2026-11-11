package net_Concept;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class  outputstream{
    public static void main(String[] args) {
        try{
        OutputStream out = new FileOutputStream("data.txt");
            out.write(12);
            byte[]data = {65,66,67};
            out.write(data);
            out.flush();
    }catch(IOException e){
    System.out.println("not writing");
    }
}
}