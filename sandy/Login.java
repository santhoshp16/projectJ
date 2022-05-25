package sandy;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.*;



import java.awt.Color;
import java.awt.event.*;
import java.awt.*;


public class Login {
    Login(){
        JFrame jf=new JFrame();
        JPanel f=new JPanel();
        jf.setBounds(10, 10, 900, 650);
        f.setVisible(true);
        JLabel jl1=new JLabel("User Login");
        jl1.setBounds(260,50,300,80);
        JLabel jl2=new JLabel("Emai Id    ");
        jl2.setBounds(180,90,300,100);
        JLabel jl3=new JLabel("Password  ");
        jl3.setBounds(180,130,300,100);
        JTextField jt=new JTextField();
        jt.setBounds(250,125,150,25);
        JTextField jt1=new JTextField();
        jt1.setBounds(250,165,150,25);
        JButton jb=new JButton("Log in");
        jb.setBounds(260,210,100,30);
        JLabel jl4=new JLabel("-------------------------- or -------------------------");
        jl4.setBounds(180, 220, 300, 100);
        JLabel jl5=new JLabel("New User ? ");
        jl5.setBounds(190,250,300,100);
        JButton jb1=new JButton("Register");
        jb1.setBounds(265,285,100,30);
        jf.setLayout(new BorderLayout());
        jf.setContentPane(new JLabel(new ImageIcon("login2.jpg")));
        jf.setResizable(true);
        f.setBounds(10, 10, 900, 650);
        f.add(jl1);
        f.add(jl2);
        f.add(jl3);
        f.add(jl3);
        f.add(jt);
        f.add(jt1);
        f.add(jb);
        f.add(jl4);
        f.add(jl5);
        f.add(jb1);
        f.setVisible(true);
        jf.setBounds(10, 10, 900, 650);
        jf.add(f);
        jf.setVisible(true);
      
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        jb1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
                new Register(jf);
            
            }
            
        });
		
	
    jb.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            String email=DataBase.email();
           

            String password=DataBase.password(jt.getText());
            if(!email.contains(jt.getText())){
                JOptionPane.showMessageDialog(jb,"Email Id is Invalid");
                    return;


            }
            else if(!password.equals(jt1.getText())){
                JOptionPane.showMessageDialog(jb,"Password is Invalid");
                    return;

            }
            else{
                JOptionPane.showMessageDialog(jb,"Login successfully");
            }

        }});
    }
	public static void main(String[] aa) {
		
        new Login();

    
    }
}
