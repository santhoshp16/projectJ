package register;

import connect.DataBase;
import connect.*;
import oracle.jdbc.aq.AQNotificationListener;
import sandy.Client;
import sandy.data;

import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;

public class Register {
    static     String dates[] 

    = { "1", "2", "3", "4", "5", 

        "6", "7", "8", "9", "10", 

        "11", "12", "13", "14", "15", 

        "16", "17", "18", "19", "20", 

        "21", "22", "23", "24", "25", 

        "26", "27", "28", "29", "30", 

        "31" }; 

 static String months[] 

    = { "Jan", "feb", "Mar", "Apr", 

        "May", "Jun", "July", "Aug", 

        "Sup", "Oct", "Nov", "Dec" }; 

 static  String years[] 

    = { "1995", "1996", "1997", "1998", 

        "1999", "2000", "2001", "2002", 

        "2003", "2004", "2005", "2006", 

        "2007", "2008", "2009", "2010", 

        "2011", "2012", "2013", "2014", 

        "2015", "2016", "2017", "2018", 

        "2019","2020","2021" };
        public static void reg(){
            Register a=new Register();
        JFrame jf=new JFrame();
        JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
        JComboBox date,month,year;
        JTextField jt1,jt2,jt3,jt4,jt5;
        JButton jb;
        JRadioButton jrb1,jrb2;

        jb=new JButton("Submit");
        jrb1=new JRadioButton("M");
        jrb2=new JRadioButton("F");
        jl1=new JLabel("ID:");
        jl2=new JLabel("First Name:");
        jl3=new JLabel("Last Name:");
        jl4=new JLabel("Email:");
        jl5=new JLabel("Phone No:");
        jl6=new JLabel("D.O.B:");
        jt1=new JTextField();
        jt2=new JTextField();
        jt3=new JTextField();
        jt4=new JTextField();
        jt5=new JTextField();
    
        date=new JComboBox(dates);
        month=new JComboBox(months);
        year=new JComboBox(years);
        jf.setBounds(10,10,500,700);
        jf.setLayout(null);
        jf.setVisible(true);
        JLabel j=new JLabel("Registeration Form ");
        jl7=new JLabel("Gender :");
        
        j.setBounds(120,0,150,70);
        jl1.setBounds(20,40,70,70);
        jt1.setBounds(100,65,150,20);
        jl2.setBounds(20,90,70,70);
        jt2.setBounds(100,115,150,20);
        jl3.setBounds(20,150,70,70);
        jt3.setBounds(100,175,150,20);
        jl4.setBounds(20,200,70,70);
        jt4.setBounds(100,225,150,20);
        jl5.setBounds(20,250,70,70);
        jt5.setBounds(100,275,150,20);
        jl7.setBounds(20,320,70,20);
        jrb1.setBounds(100,320,70,20);
        jrb2.setBounds(180,320,70,20);
        jb.setBounds(100,500,120,50);
        jl6.setBounds(20,355,70,70);
        date.setBounds(100,380,50,20);
        month.setBounds(150,380,80,20);
        year.setBounds(230,380,90,20);
        jf.add(j);
        jf.add(jl7);
        jf.add(date);
        jf.add(month);
        jf.add(year);
        jf.add(jt1);
        jf.add(jl1);
        jf.add(jt2);
        jf.add(jl2);
        jf.add(jt3);
        jf.add(jl3);
        jf.add(jt4);
        jf.add(jl4);
        jf.add(jt5);
        jf.add(jl5);
        jf.add(jl6);
        jf.add(jt5);
        jf.add(jrb1);
        jf.add(jrb2);
        jf.add(jb);
        java.awt.Container c=jf.getContentPane();
        c.setBackground(Color.green);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String id=jt1.getText();
                String Fname=jt2.getText();
                String Lname=jt3.getText();
                String  email=jt4.getText();
                int mob=jt5.getText().length();
                String gen=" ";
                if(jrb1.isSelected()){
                    gen="M";
                }
                else if(jrb2.isSelected()){
                    gen="F";
                }
                else{
                    JOptionPane.showMessageDialog(jb,"Choose male or Female");
                    

                }
               
                //if(!Pattern.matches("[A-Za-z+]",Fname) && (!Pattern.matches("[A-Za-z+]",Lname))){
                  //  JOptionPane.showMessageDialog(jb,"Must contain Letters");
                    

               // }
                 if(!Pattern.matches("[0-9]{1,4}",id)){
                    JOptionPane.showMessageDialog(jb,"btw 0-999");
                    

                }
                else if(!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",email)){
                    JOptionPane.showMessageDialog(jb,"Enter vaild email");
                    
                }
                
                else if(!(mob==10)){
                    JOptionPane.showMessageDialog(jb,"Enter vaild phone no");
                    
                }
               else{
               
                data d=new data();
                d.setId(Integer.parseInt(id));
                d.setName(Fname+" "+Lname);
                d.setEm(email);
                d.setMobNo(jt5.getText());
                d.setGen(gen);
                d.setDob(date.getSelectedItem().toString()+" "+month.getSelectedItem().toString()+" "+year.getSelectedItem().toString());
            
                JOptionPane.showMessageDialog(jb,"REGISTERED SUCCESSFULLY");
               try {
                Server.startServer();
            } catch (IOException e1) {
                //
                e1.printStackTrace();
            }
               Client c=    new Client(d);
               }





            }

           
            
        });
    }
        public static void main(String[] arg){
            Register rg=new Register();
            rg.reg();

        }
      


    
}
