package sandy;
import connect.DataBase;

import oracle.jdbc.aq.AQNotificationListener;

import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
 public class Awwts {
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
            Awwts a=new Awwts();
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
               
                if(!Pattern.matches("[A-Za-z+]",Fname) && (!Pattern.matches("[A-Za-z+]",Lname))){
                    JOptionPane.showMessageDialog(jb,"Must contain Letters");
                    

                }
                else if(!Pattern.matches("[0-9]{1,4}",id)){
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
                DataBase db=new DataBase();
                db.insert(d);
                JOptionPane.showMessageDialog(jb,"REGISTERED SUCCESSFULLY");
               }





            }

           
            
        });
        }



    public static void main(String[] aa){
        JFrame fr=new JFrame();
        JLabel j1,j2;
        JTextField t1;
        JPasswordField t2;
        j1=new JLabel("User Id:");
        j2=new JLabel("New user :");
        t1=new JTextField();
        JButton jb=new JButton("Enter");
        JButton jb1=new JButton("Register");
        j1.setBounds(20,20,70,70);
        t1.setBounds(100,45,150,20);
        jb.setBounds(300,45,80,20);
        j2.setBounds(20, 170, 70, 70);
        jb1.setBounds(125,180,100,50);
        fr.setLayout(null);
        fr.setVisible(true);
        fr.add(j1);
        fr.add(jb1);
        fr.add(t1);
        fr.add(j2);
        java.awt.Container c=fr.getContentPane();
                c.setBackground(Color.CYAN);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        fr.add(jb);
        fr.setBounds(0,0,500,300);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String ID=DataBase.id();
                String[] userId=ID.split(" ");
                if(ID.contains(t1.getText())){
                JFrame jj=new JFrame();
                JButton b2=new JButton("Update");
                JButton b3=new JButton("Delete");
                JButton b4=new JButton("View");
               
                b2.setBounds(60,50,100,50);
                b3.setBounds(60,120,100,50);
                b4.setBounds(60,200,100,50);
                jj.setLayout(null);
                jj.setBounds(0,0,500,300);
                
                jj.add(b2);
                jj.add(b3);
                jj.add(b4);
                jj.setVisible(true);
                java.awt.Container c=jj.getContentPane();
                c.setBackground(Color.gray);
                jj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
                    b2.addActionListener(new ActionListener(){

                

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Awwts.update(Integer.parseInt(t1.getText()));
                            
                        }});
                        b3.addActionListener(new ActionListener(){

                

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Awwts.delete(Integer.parseInt(t1.getText()));
                                
                            }});
                        b4.addActionListener(new ActionListener(){

                

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                DataBase db=new DataBase();
                                Awwts.view(Integer.parseInt(t1.getText()));
                                
                            }});
            }
        
       
            else{
                JOptionPane.showMessageDialog(null,"User ID is Invalid");
                            
             }}
          });
         
    
    
        jb1.addActionListener(new ActionListener(){

                

            @Override
            public void actionPerformed(ActionEvent e) {
                Awwts.reg();
                
            }});

       
        
        

    }
    public static  void update(int id){
        
                 DataBase db=new DataBase();
                 //int id=Integer.parseInt(jt1.getText());
                 data d=DataBase.view(id);
                 JFrame jf5=new JFrame();
                 JLabel L1=new JLabel("update form:");
                 JLabel L2=new JLabel("Name:");
                 JLabel L3=new JLabel("Email:");
                 JLabel L4=new JLabel("mob.no");
                 JLabel L5=new JLabel("gender:");
                 JLabel L6=new JLabel("DOF");
                 JButton B1=new JButton("Update");
                 JTextField T2=new JTextField(),T3=new JTextField(),T4=new JTextField(),T5=new JTextField(),T6=new JTextField();
                 T2.setText(d.getName());
                 T3.setText(d.getEm());
                 T4.setText(d.getMobno());
                 T5.setText(d.getGen());
                 T6.setText(d.getDob());
                 L1.setBounds(150, 25, 100, 50);
                 L2.setBounds(20,40,70,70);
                 T2.setBounds(100,65,150,20);
                 L3.setBounds(20,90,70,70);
                 T3.setBounds(100,115,150,20);
                 L4.setBounds(20,150,70,70);
                 T4.setBounds(100,175,150,20);
                 L5.setBounds(20,200,70,70);
                 T5.setBounds(100,225,150,20);
                 L6.setBounds(20,250,70,70);
                 T6.setBounds(100,275,150,20);
                 jf5.setBounds(0,0,800,500);
                 B1.setBounds(120, 400, 100, 40);
                 jf5.setLayout(null);
                 jf5.setVisible(true);
                 jf5.add(L1);
                 jf5.add(L2);
                 jf5.add(L3);
                 jf5.add(L4);
                 jf5.add(L5);
                 jf5.add(L6);
                 jf5.add(T2);
                 jf5.add(T3);
                 jf5.add(T4);
                 jf5.add(T5);
                 jf5.add(T6);
                 jf5.add(B1);
                 jf5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 B1.addActionListener(new ActionListener(){
                     public void actionPerformed(ActionEvent e){
                         String Name=T2.getText(),email=T3.getText(),mobno=T4.getText(),gen=T5.getText(),dob=T6.getText();
                         int mob=mobno.length();
                         
                           
                            
                            if(!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",email)){
                                JOptionPane.showMessageDialog(jf5,"Enter vaild email");
                        
            
                            }
                            
                            else if(!(mob==10)){
                                JOptionPane.showMessageDialog(jf5,"Enter vaild phone no");
                            
                            }
                        else{   

                        data d=new data();
                        d.setName(Name);
                        d.setEm(email);
                        d.setMobNo(mobno);
                        d.setGen(gen);
                        d.setDob(dob);
                        DataBase db=new DataBase();
                       int val= db.update(d,id);
                       if(val!=0){
                        JOptionPane.showMessageDialog(jf5,"updated successfully");
                     }
                    }
    

        
                     }
                     
                 });
                 
                 
                 
              }
    public static void view(int id){
      DataBase db=new DataBase();
                //int id=Integer.parseInt(jt1.getText());
                data d=DataBase.view(id);
                JFrame jf5=new JFrame();
                JLabel L1=new JLabel("View form:");
                JLabel L2=new JLabel("Name:");
                JLabel L3=new JLabel("Email:");
                JLabel L4=new JLabel("mob.no");
                JLabel L5=new JLabel("gender:");
                JLabel L6=new JLabel("DOF");
                JTextField T2=new JTextField(),T3=new JTextField(),T4=new JTextField(),T5=new JTextField(),T6=new JTextField();
                T2.setText(d.getName());
                T2.setEditable(false);
                T3.setText(d.getEm());
                T4.setText(d.getMobno());
                T5.setText(d.getGen());
                T6.setText(d.getDob());
                T3.setEditable(false);
                T4.setEditable(false);
                T5.setEditable(false);
                T6.setEditable(false);
                L1.setBounds(150, 25, 100, 50);
                L2.setBounds(20,40,70,70);
                T2.setBounds(100,65,150,20);
                L3.setBounds(20,90,70,70);
                T3.setBounds(100,115,150,20);
                L4.setBounds(20,150,70,70);
                T4.setBounds(100,175,150,20);
                L5.setBounds(20,200,70,70);
                T5.setBounds(100,225,150,20);
                L6.setBounds(20,250,70,70);
                T6.setBounds(100,275,150,20);
                jf5.setBounds(0,0,800,500);
                jf5.setLayout(null);
                jf5.setVisible(true);
                jf5.setBackground(Color.GREEN);
                jf5.add(L1);
                jf5.add(L2);
                jf5.add(L3);
                jf5.add(L4);
                jf5.add(L5);
                jf5.add(L6);
                jf5.add(T2);
                jf5.add(T3);
                jf5.add(T4);
                jf5.add(T5);
                jf5.add(T6);
                jf5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
                
           


    }

    public static  void delete(int id){
       int v=DataBase.delete(id);
                 if(v!=0){
                    JOptionPane.showMessageDialog(null,"Deleted successfully");
                 }



   

 }



    }
