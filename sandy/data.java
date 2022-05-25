package sandy;

import connect.DataBase;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
public class data implements Serializable{
    private  int id;
    private  String name;
    private String em;
    private String mobNo;
    private String gen;
    private String dob;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;

    }
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
    public String getGen(){
        return gen;
    }
    public void setGen(String gen){
        this.gen=gen;

    }
    public String getDob(){
        return dob;
    }
    public void setDob(String dob){
        this.dob=dob;

    }
    

}