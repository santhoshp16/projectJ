package sandy;

import connect.DataBase;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
public class JavaBean implements Serializable{
    private  String name;
    private String em;
    private String mobNo;
    private String password;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;

    }
    public String getEm(){
        return em;
    }
    public void setEm(String em){
        this.em=em;

    }
    public String getMobno(){
        return mobNo;
    }
    public void setMobNo(String mobNo){
        this.mobNo=mobNo;

    }
   
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;

    }
    

}