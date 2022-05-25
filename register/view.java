package register;
import connect.DataBase;
import connect.Server;
import oracle.jdbc.aq.AQNotificationListener;
import sandy.data;

import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class view {
    public static void main(String[] aa){
        JFrame fr=new JFrame();
        JLabel j1,j2;
        JTextField t1;
        JPasswordField t2;
        j1=new JLabel("User Id:");
        
        t1=new JTextField();
        JButton jb=new JButton("Enter");
        
        j1.setBounds(20,20,70,70);
        t1.setBounds(100,45,150,20);
        jb.setBounds(300,45,80,20);
        
       
        fr.setLayout(null);
        fr.setVisible(true);
        fr.add(j1);
        
        fr.add(t1);
       
        java.awt.Container c=fr.getContentPane();
                c.setBackground(Color.CYAN);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        fr.add(jb);
        fr.setBounds(0,0,500,300);
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String ID=Server.id();
                String[] userId=ID.split(" ");
                if(ID.contains(t1.getText())){
                
                
                                view.views(Integer.parseInt(t1.getText()));
                                
                          
            }
        
       
            else{
                JOptionPane.showMessageDialog(null,"User ID is Invalid");
                            
             }}
          });
         
    
    
        

       
        
        
    }
    
    
            
                    public static void views(int id){
                                 
                                  
                                  data d=Server.view(id);
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
                    }