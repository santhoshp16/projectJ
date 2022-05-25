package connect;

import java.io.*;
import java.net.*;
import java.sql.*;
import javax.swing.JOptionPane;

import sandy.data;

public class Server{
    static ServerSocket ss;
    public static void startServer() throws IOException{
        System.out.println("Server-Side");
        ss = new ServerSocket(2385);
        System.out.println("Waiting for client ....");
    }
   public  Server() {
        try{
           
            Socket s = ss.accept();
            System.out.println("Server - Client connection established");
            
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            data n = (data)ois.readObject();
            DataBase db=new DataBase();
            db.insert(n);
        }
        catch (Exception e ){

        }
    }
    public static String id(){
        String s=DataBase.id();
        return s;
    }
    public static data view(int id){
        DataBase dp=new DataBase();
        data d =dp.view(id);
        return d;
    }
}
