package FramesA;
import Entities.*;

import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class AddAdmin extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private JLabel namelbl,passlbl,lgnimglbl,lgnlbl;
    private JTextField namefld;
    private JPasswordField passfld;
    private ImageIcon lgnimg,icon;
    private JButton addadminbtn,backbtn;
    private Color c1,c2,c3;
    private String admin;
    private Font f1,f2,f3;

    public AddAdmin(String s1){
        super("X3RTZY Gaming Shop");
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        icon = new ImageIcon("Images/appicon.png");
        this.setIconImage(icon.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        c1 = new Color(29,57,67);
        c2 = new Color(68,141,143);
        c3 = new Color(97,201,204);
        f1 = new Font("Cambria",Font.PLAIN,22);
        f2 = new Font("Cambria",Font.PLAIN,19);
        f3 = new Font("Cambria",Font.BOLD,30);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);

        admin = s1;

        lgnlbl = new JLabel("AddAdmin");
        lgnlbl.setBounds(252,20,520,50);
        lgnlbl.setForeground(Color.WHITE);
        lgnlbl.setHorizontalAlignment(JLabel.CENTER);
        lgnlbl.setFont(f3);
        panel.add(lgnlbl);

        namelbl = new JLabel("Name :");
        namelbl.setBounds(252, 190, 520, 40);
        namelbl.setForeground(Color.WHITE);
        namelbl.setFont(f1);
        panel.add(namelbl);


        namefld = new JTextField();
        namefld.setBounds(252, 235, 520, 55);
        panel.add(namefld);

        passlbl = new JLabel("Password :");
        passlbl.setBounds(252, 305, 520, 40);
        passlbl.setForeground(Color.WHITE);
        passlbl.setFont(f1);
        panel.add(passlbl);

        passfld = new JPasswordField();
        passfld.setBounds(252, 350, 520, 55);
        panel.add(passfld);

        addadminbtn = new JButton("AddAdmin");
        addadminbtn.setBounds(252, 520, 166, 50);
        addadminbtn.setBackground(c2);
        addadminbtn.setFont(f1);
        addadminbtn.setForeground(Color.WHITE);
        addadminbtn.setFocusPainted(false);
        addadminbtn.addMouseListener(this);
        addadminbtn.addActionListener(this);
        panel.add(addadminbtn);



        backbtn = new JButton("Back");
        backbtn.setBounds(604, 520, 168, 50);
        backbtn.setBackground(c2);
        backbtn.setFont(f1);
        backbtn.setForeground(Color.WHITE);
        backbtn.setFocusPainted(false);
        backbtn.addMouseListener(this);
        backbtn.addActionListener(this);
        panel.add(backbtn);

        lgnimg = new ImageIcon("Images/AddAdmin.png");
        lgnimglbl = new JLabel(lgnimg);
        lgnimglbl.setBounds(0,0,1024,768);
        panel.add(lgnimglbl);

        this.add(panel);
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        
        if(me.getSource()==backbtn){
            backbtn.setBackground(c3);
            backbtn.setForeground(Color.BLACK);

        } else if (me.getSource()==addadminbtn) {
            addadminbtn.setBackground(c3);
            addadminbtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if(me.getSource()==backbtn){
            backbtn.setBackground(c2);
            backbtn.setForeground(Color.white);

        } else if (me.getSource()==addadminbtn) {
            addadminbtn.setBackground(c2);
            addadminbtn.setForeground(Color.WHITE);
        }
    }


    public void actionPerformed(ActionEvent ae) {
        String s1 = namefld.getText();
        String s2 = passfld.getText();

         if (ae.getSource()==addadminbtn) {
             if(s1.isEmpty()||s2.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Fill Up All..!!");
             }
             else{
                 AdminAccount acc = new AdminAccount(s1,s2);
                 acc.addAdminAccount();

                 JOptionPane.showMessageDialog(null,"Admin Added Successfully");
                 this.setVisible(false);
                 AdminDashboard ad = new AdminDashboard(admin,null);
                 ad.setVisible(true);
             }
         } else if (ae.getSource()==backbtn) {
             this.setVisible(false);
             AdminDashboard ad = new AdminDashboard(admin,null);
             ad.setVisible(true);
         }
    }
}