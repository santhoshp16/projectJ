package sandy;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class Update {
	public  Update(String  em) {
		JFrame f=new JFrame("Update");
        f.setBounds(10, 10, 900, 650);
        f.setVisible(true);
        JLabel full_name=new JLabel(" Full Name");
        full_name.setBounds(30,60,300,100);
        JTextField text_name=new JTextField();
        text_name.setBounds(120,93,150,25);
        JLabel mail_id=new JLabel("Mail Id");
        mail_id.setBounds(30,110,300,100);
        JTextField text_mail=new JTextField();
        text_mail.setBounds(120,145,150,25);
        JLabel mob_number=new JLabel("Mob No");
        mob_number.setBounds(30,160,300,100);
        JTextField text_mob=new JTextField();
        text_mob.setBounds(120,195,150,25);
        JLabel J_password=new JLabel("Password");
        J_password.setBounds(30,200,300,100);
        JTextField text_password=new JTextField();
        text_password.setBounds(120,240,150,25);
        JButton update=new JButton("Update");
        update.setBounds(130,380,130,30);
        f.add(full_name);
        f.add(text_name);
        f.add(mail_id);
        f.add(text_mail);
        f.add(mob_number);
        f.add(text_mob);
        f.add(J_password);
        f.add(text_password);
        f.add(update);
        //JavaBean d=db.view("19eucs121@skcet.ac.in");
        //text_name.setText(d.getName());
        //text_mail.setText(d.getEm());
        //text_mail.setEditable(false);
        //text_mob.setText(d.getMobno());
        //text_password.setText(d.getPassword());
       
        f.setContentPane(new JLabel(new ImageIcon("D:\\openCv\\login1.jpg")));
     
        
        
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        
        update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e){
                String Name=text_name.getText();
                String Email=text_mail.getText();
                String Mob=text_mob.getText();
                String Password=new String(text_password.getText());
               

                if(!Pattern.matches("^[a-zA-Z\\s]*$",Name)){
                    JOptionPane.showMessageDialog(update,"Enter your Name");
                    return;
                    
                }
                else  if(!Pattern.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",Email)){
                    JOptionPane.showMessageDialog(update,"Enter vaild email");
                    return;
                    
                }
                
                else if(!((Mob.length()==10) && (Mob.matches("[0-9]+")))){
                   JOptionPane.showMessageDialog(update,"Enter vaild phone no");
                    return;
               }
                else if(!Pattern.matches("[a-zA-Z0-9#@_]{6,15}",Password)){
                    JOptionPane.showMessageDialog(update,"Create a Strong Password");
                    return;
                }
               
                else{
                    JavaBean j=new JavaBean();
                    j.setEm(Email);
                    j.setName(Name);
                    j.setMobNo(Mob);
                    j.setPassword(Password);
                    JOptionPane.showMessageDialog(update,"Update");
                    DataBase db=new DataBase();
                    db.insert(j);
                    


               
                }
                
            }
        });

    }
	public static void main(String[] aa) {
		new Update("hi");
	}
}


