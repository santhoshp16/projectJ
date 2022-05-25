package sandy;

import java.util.*;
import sandy.JavaBean;

import java.io.StringReader;
import java.sql.*;

//create table userside(name VARCHAR2(30),email VARCHAR2(30),mob DECIMAL(10),password Varchar2(30));

class Data {
    private static Connection con;
    public static  Connection getConnection(){
   
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","register","data");
        
     
        
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    return con;    
}
}
public class DataBase {
   //comment
    public void insert(JavaBean jb){
       
        try {
            Connection con=Data.getConnection();
            String Quary="insert into userside values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(Quary);
            ps.setString(1,jb.getName());
            ps.setString(2,jb.getEm());
            ps.setString(3, jb.getMobno());
            ps.setString(4, jb.getPassword());
           
            ps.executeQuery();

            }
            catch(Exception e){
                System.out.println(e);
                
            }

    }
    public static String email(){
        Connection con=Data.getConnection();
        String email="";
        try {
            Statement stmt =con.createStatement();
            String Quary="select email from userside";
            ResultSet rs=stmt.executeQuery(Quary);
            
            while((rs.next())){
        
                email+=(rs.getString(1))+" ";

            }
           
            return email;


        } catch (SQLException e) {
           
        }
        return email;
           

    }
    public static String password(String mail){
        Connection con=Data.getConnection();
        String password="";
        try {
            Statement stmt =con.createStatement();
            String Quary="select password from userside where email='"+mail+"'";
            ResultSet rs=stmt.executeQuery(Quary);
            
            while((rs.next())){
                
                
                password+=(rs.getString(1));

            }
           
            return password;


        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
           

    }
    public static JavaBean view(String ids){
        Connection con=Data.getConnection();
        JavaBean d=new JavaBean();
        System.out.println("hi");
        try {
            PreparedStatement ps=con.prepareStatement("select * from reg where ID=?");
            ps.setString(3, ids);
            ResultSet rs=ps.executeQuery();
            
            while((rs.next())){
                
                
                d.setName(rs.getString(2));
                d.setEm(rs.getString(3));
                d.setMobNo(rs.getString(4));
               d.setPassword(rs.getString(5));
            }
           
            return d;


        } catch (SQLException e) {
           System.out.println(d.getName());
        }
        return d;
    
           

    }
   
}


