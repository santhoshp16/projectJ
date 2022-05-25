package sandy;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;

import oracle.net.aso.f;

import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import sandy.DataBase;

public class Register {
    Register(JFrame jf){
        
        JPanel f=new JPanel();
        f.setBounds(10, 10, 900, 650);
        f.setVisible(false);
        JLabel jl=new JLabel(" Full Name");
        jl.setBounds(30,60,300,100);
        JTextField jt=new JTextField();
        jt.setBounds(120,93,150,25);
        JLabel jl1=new JLabel("Mail Id");
        jl1.setBounds(30,110,300,100);
        JTextField jt1=new JTextField();
        jt1.setBounds(120,145,150,25);
        JLabel jl2=new JLabel("Mob No");
        jl2.setBounds(30,160,300,100);
        JTextField jt2=new JTextField();
        jt2.setBounds(120,195,150,25);
        JLabel jl3=new JLabel("Password");
        jl3.setBounds(30,200,300,100);
        JPasswordField jp=new JPasswordField();
        jp.setBounds(120,240,150,25);
        JLabel jl4=new JLabel("Confirm");
        jl4.setBounds(30,250,300,100);
        JPasswordField jp1=new JPasswordField();
        jp1.setBounds(120,290,150,25);
        JButton jb=new JButton("Register");
        jb.setBounds(130,380,130,30);

        
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
        
        f.add(jl);
        f.add(jl1);
        f.add(jl2);
        f.add(jl3);
        f.add(jt);
        f.add(jt1);
        f.add(jt2);
        f.add(jp);
        f.add(jl4);
        f.add(jp1);
        f.add(jb);
        jf.add(f);
        
        jb.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                String Name=jt.getText();
                String Email=jt1.getText();
                String Mob=jt2.getText();
                String Password=new String(jp.getPassword());
                String Confirm=new String(jp1.getPassword());

                if(!Pattern.matches("^[a-zA-Z\\s]*$",Name)){
                    JOptionPane.showMessageDialog(jb,"Enter your Name");
                    return;
                    
                }
                else  if(!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",Email)){
                    JOptionPane.showMessageDialog(jb,"Enter vaild email");
                    return;
                    
                }
                
                else if(!((Mob.length()==10) && (Mob.matches("[0-9]+")))){
                   JOptionPane.showMessageDialog(jb,"Enter vaild phone no");
                    return;
               }
                else if(!Pattern.matches("[a-zA-Z0-9#@_]{6,15}",Password)){
                    JOptionPane.showMessageDialog(jb,"Create a Strong Password");
                    return;
                }
                else if(!Password.equals(Confirm)){
                    JOptionPane.showMessageDialog(jb,"You Enter Different Password");
                    return;
                }
                else{
                    JavaBean j=new JavaBean();
                    j.setEm(Email);
                    j.setName(Name);
                    j.setMobNo(jt2.getText());
                    j.setPassword(Password);
                    JOptionPane.showMessageDialog(jb,"Registered");
                    DataBase db=new DataBase();
                    db.insert(j);
                    jf.dispose();
                    new Login();
                  


                }
               
            }
        });

    }
}
