package FramesA;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import Entities.Account;
import Entities.AdminAccount;

public class AdminDashboard extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private JLabel userlbl,adimglbl;
    private ImageIcon icon,adimg;
    private JButton logoutbtn,vuserbtn,vadminbtn,addadminbtn,duserbtn;
    private Color c1,c2,c3,c4;
    private Font f1,f2;
    private String admin;
    private Login lgn;
    private Account acc ;

    public AdminDashboard(String s1,Login lgn){
        super("X3RTZY Gaming Shop");
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        this.lgn=lgn;
        icon = new ImageIcon("Images/appicon.png");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        c1 = new Color(29,57,67);
        c2 = new Color(68,141,143);
        c3 = new Color(97,201,204);
        c4 = new Color(220,96,96);
        f1 = new Font("Cambria",Font.PLAIN,22);
        f2 = new Font("Cambria",Font.PLAIN,15);
        acc = new Account();

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);
        userlbl = new JLabel("Hello, "+s1);
        userlbl.setBounds(600,2,300,50);
        userlbl.setForeground(Color.WHITE);
        userlbl.setHorizontalAlignment(JLabel.RIGHT);
        userlbl.setFont(f1);
        panel.add(userlbl);
        admin = s1;

        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(915,12,80,30);
        logoutbtn.setForeground(Color.WHITE);
        logoutbtn.setFocusPainted(false);
        logoutbtn.addMouseListener(this);
        logoutbtn.addActionListener(this);
        logoutbtn.setBackground(c2);
        logoutbtn.setFont(f2);
        panel.add(logoutbtn);

        duserbtn = new JButton("Delete User");
        duserbtn.setBounds(362,230,300,50);
        duserbtn.setBackground(c2);
        duserbtn.setForeground(Color.WHITE);
        duserbtn.addMouseListener(this);
        duserbtn.addActionListener(this);
        duserbtn.setFont(f1);
        duserbtn.setFocusPainted(false);
        panel.add(duserbtn);

        vuserbtn = new JButton("View Users");
        vuserbtn.setBounds(362,300,300,50);
        vuserbtn.setBackground(c2);
        vuserbtn.setForeground(Color.WHITE);
        vuserbtn.addMouseListener(this);
        vuserbtn.addActionListener(this);
        vuserbtn.setFont(f1);
        vuserbtn.setFocusPainted(false);
        panel.add(vuserbtn);

        vadminbtn = new JButton("View Admin");
        vadminbtn.setBounds(362,370,300,50);
        vadminbtn.setForeground(Color.WHITE);
        vadminbtn.addMouseListener(this);
        vadminbtn.addActionListener(this);
        vadminbtn.setFont(f1);
        vadminbtn.setBackground(c2);
        vadminbtn.setFocusPainted(false);
        panel.add(vadminbtn);

        addadminbtn = new JButton("Add Admin");
        addadminbtn.setBounds(362,440,300,50);
        addadminbtn.setBackground(c2);
        addadminbtn.setForeground(Color.WHITE);
        addadminbtn.addMouseListener(this);
        addadminbtn.addActionListener(this);
        addadminbtn.setFont(f1);
        addadminbtn.setFocusPainted(false);
        panel.add(addadminbtn);



        adimg = new ImageIcon("Images/adminD.png");
        adimglbl = new JLabel(adimg);
        adimglbl.setBounds(0,0,1024,768);
        panel.add(adimglbl);

        this.add(panel);
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==logoutbtn){
            logoutbtn.setBackground(c4);
            logoutbtn.setForeground(Color.BLACK);
        } else if (me.getSource()==vuserbtn) {
            vuserbtn.setForeground(Color.BLACK);
            vuserbtn.setBackground(c3);
        }
        else if (me.getSource()==vadminbtn) {
            vadminbtn.setForeground(Color.BLACK);
            vadminbtn.setBackground(c3);
        } else if (me.getSource()==addadminbtn) {
            addadminbtn.setForeground(Color.BLACK);
            addadminbtn.setBackground(c3);
        } else if (me.getSource()==duserbtn) {
            duserbtn.setBackground(c3);
            duserbtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if(me.getSource()==logoutbtn){
            logoutbtn.setForeground(Color.WHITE);
            logoutbtn.setBackground(c2);
        } else if (me.getSource()==vuserbtn) {
            vuserbtn.setForeground(Color.WHITE);
            vuserbtn.setBackground(c2);
        }
        else if (me.getSource()==vadminbtn) {
            vadminbtn.setForeground(Color.WHITE);
            vadminbtn.setBackground(c2);
        }
        else if (me.getSource()==addadminbtn) {
            addadminbtn.setForeground(Color.WHITE);
            addadminbtn.setBackground(c2);
        } else if (me.getSource()==duserbtn) {
            duserbtn.setBackground(c2);
            duserbtn.setForeground(Color.WHITE);
        }
    }


    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==logoutbtn){
            this.setVisible(false);
            Login l1 = new Login();
            l1.setVisible(true);
        }
        else if(ae.getSource()==addadminbtn){
            this.setVisible(false);
            AddAdmin ad = new AddAdmin(admin);
            ad.setVisible(true);
        } else if (ae.getSource()==vuserbtn) {
            String allUsers = acc.viewAllAccounts();
            JTextArea textArea = new JTextArea(allUsers);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500,400));
            JOptionPane.showMessageDialog(this, scrollPane, "All Accounts", JOptionPane.INFORMATION_MESSAGE);
            
        } else if (ae.getSource()==vadminbtn) {
            AdminAccount adminAcc = new AdminAccount();
            String allAdmins = adminAcc.viewAllAdmins();

            JTextArea textArea = new JTextArea(allAdmins);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500,400));
            JOptionPane.showMessageDialog(this, scrollPane, "Admins", JOptionPane.INFORMATION_MESSAGE);

        }
        else if(ae.getSource() == duserbtn){
            String username = JOptionPane.showInputDialog(this, "Enter username to delete:");
            if(username != null && !username.isEmpty()){
                boolean result = acc.deleteAccount(username);
                if(result){
                    JOptionPane.showMessageDialog(this, "User deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "User not found!");
                }
            }
        }


    }
}