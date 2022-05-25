package sandy;
import register.*;
import connect.*;
import java.io.*;
import java.net.*;

public class Client{
     public  Client(data n){
        try{
            Socket s = new Socket("localhost",2385);
            ObjectOutputStream dout = new ObjectOutputStream(s.getOutputStream());
            dout.writeObject(n);
            dout.flush();
            System.out.println("Establishing . . . . ");
            
            Server obj = new Server();
        }
        catch(Exception e){
            System.out.println(e);
        }   
    }
}