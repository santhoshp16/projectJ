package connect;
import java.util.*;
import sandy.data;

import java.io.StringReader;
import java.sql.*;
class Data {
    private static Connection con;
    public static  Connection getConnection(){
   
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","sandy","santhosh");
        System.out.println(con);
     
        
    }
    catch (Exception e){
        System.out.println(e);
    }
    
    return con;    
}
}
public class DataBase {
    public static void main(String[] args){
        
        
    }
    public void insert(data d){
       
        try {
            Connection con=Data.getConnection();
            String Quary="insert into reg values(?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(Quary);
            ps.setInt(1,d.getId());
            ps.setString(2,d.getName());
            ps.setString(3,d.getEm());
            ps.setString(4, d.getMobno());
            ps.setString(5,d.getGen());
            ps.setString(6,d.getDob());
            ps.executeQuery();

            }
            catch(Exception e){
                System.out.println(e);
                
            }

    }
    public static String id(){
        Connection con=Data.getConnection();
        String eid="";
        try {
            Statement stmt =con.createStatement();
            String Quary="select id from reg";
            ResultSet rs=stmt.executeQuery(Quary);
            
            while((rs.next())){
                
                eid+=String.valueOf(rs.getInt(1))+" ";

            }
           
            return eid;


        } catch (SQLException e) {
           
        }
        return null;
           

    }

    public static data view(int ids){
        Connection con=Data.getConnection();
        data d=new data();
        try {
            PreparedStatement ps=con.prepareStatement("select * from reg where ID=?");
            ps.setInt(1, ids);
            ResultSet rs=ps.executeQuery();
            
            while((rs.next())){
                
                
                d.setName(rs.getString(2));
                d.setEm(rs.getString(3));
                d.setMobNo(rs.getString(4));
                d.setGen(rs.getString(5));
                d.setDob(rs.getString(6));
            }
           
            return d;


        } catch (SQLException e) {
           System.out.println(d.getName());
        }
        return d;
    
           

    }
    public static int update(data d,int id){

        Connection con=Data.getConnection();
        try {
           PreparedStatement psmt=con.prepareStatement("update reg set Name=?, EM=?,MOB=?,GENDER=?,DOB=? where ID=? ");
           psmt.setString(1,d.getName());
           psmt.setString(2,d.getEm());
           psmt.setString(3,d.getMobno());
           psmt.setString(4,d.getGen());
           psmt.setString(5,d.getDob());
           psmt.setInt(6,id);
           psmt.executeQuery();
           return 1;
    }
    catch(SQLException e){

    }
    return 0;


}
public static int delete(int id){
    Connection con=Data.getConnection();
    data d=new data();
    try {
        PreparedStatement stmt=con.prepareStatement("delete from reg where id=?");;
        stmt.setInt(1, id);
        stmt.executeQuery();
        return 1;
}
catch(SQLException e){
    System.out.println(e);
}
return 0;

}

}