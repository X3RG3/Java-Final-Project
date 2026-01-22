package FramesA;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class PayBill extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private JLabel pbimglbl,billbl,cardlbl, explbl, cvclbl, billinglbl;
    private ImageIcon icon,pbimg;
    private JTextField cardfld, expfld, cvcfld, billingfld;
    private JButton logoutbtn, backbtn,paybtn;
    private Color c1,c2,c3,c4;
    private Font f1,f2,f3;
    private Login lgn;
    private String usern;

    public PayBill(String s1,double bill){
        super("X3RTZY Gaming Shop");
        this.setSize(1024,768);
        this.setLocationRelativeTo(null);
        usern = s1;
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
        f3 = new Font("Cambria",Font.BOLD,20);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(c1);

        backbtn = new JButton("Back");
        backbtn.setBounds(10,12,80,30);
        backbtn.setForeground(Color.WHITE);
        backbtn.setFocusPainted(false);
        backbtn.addMouseListener(this);
        backbtn.addActionListener(this);
        backbtn.setBackground(c2);
        backbtn.setFont(f2);
        panel.add(backbtn);

        logoutbtn = new JButton("Logout");
        logoutbtn.setBounds(915,12,80,30);
        logoutbtn.setForeground(Color.WHITE);
        logoutbtn.setFocusPainted(false);
        logoutbtn.addMouseListener(this);
        logoutbtn.addActionListener(this);
        logoutbtn.setBackground(c2);
        logoutbtn.setFont(f2);
        panel.add(logoutbtn);

        billbl = new JLabel("Your Total Bill is : "+bill+" taka");
        billbl.setBounds(265, 100, 500, 60);
        billbl.setForeground(Color.YELLOW);
        billbl.setFont(f3);
        panel.add(billbl);

        cardlbl = new JLabel("Card Number:");
        cardlbl.setBounds(200, 150, 200, 35);
        cardlbl.setFont(f1);
        cardlbl.setForeground(Color.WHITE);
        panel.add(cardlbl);

        cardfld = new JTextField();
        cardfld.setBounds(420, 150, 300, 40);
        panel.add(cardfld);

        JLabel cardhint = new JLabel("Enter 16-digit card number");
        cardhint.setBounds(420, 190, 300, 20);
        cardhint.setFont(f2);
        cardhint.setForeground(Color.LIGHT_GRAY);
        panel.add(cardhint);


        explbl = new JLabel("Expiration Date:");
        explbl.setBounds(200, 230, 200, 35);
        explbl.setFont(f1);
        explbl.setForeground(Color.WHITE);
        panel.add(explbl);

        expfld = new JTextField();
        expfld.setBounds(420, 230, 300, 40);
        panel.add(expfld);

        JLabel exphint = new JLabel("Format: MM/YY");
        exphint.setBounds(420, 270, 300, 20);
        exphint.setFont(f2);
        exphint.setForeground(Color.LIGHT_GRAY);
        panel.add(exphint);


        cvclbl = new JLabel("CVC:");
        cvclbl.setBounds(200, 310, 200, 35);
        cvclbl.setFont(f1);
        cvclbl.setForeground(Color.WHITE);
        panel.add(cvclbl);

        cvcfld = new JTextField();
        cvcfld.setBounds(420, 310, 300, 40);
        panel.add(cvcfld);

        JLabel cvchint = new JLabel("3-digit number on back of card");
        cvchint.setBounds(420, 350, 300, 20);
        cvchint.setFont(f2);
        cvchint.setForeground(Color.LIGHT_GRAY);
        panel.add(cvchint);


        billinglbl = new JLabel("Billing Address:");
        billinglbl.setBounds(200, 390, 200, 35);
        billinglbl.setFont(f1);
        billinglbl.setForeground(Color.WHITE);
        panel.add(billinglbl);

        billingfld = new JTextField();
        billingfld.setBounds(420, 390, 300, 40);
        panel.add(billingfld);

        JLabel billinghint = new JLabel("Enter full billing address");
        billinghint.setBounds(420, 430, 300, 20);
        billinghint.setFont(f2);
        billinghint.setForeground(Color.LIGHT_GRAY);
        panel.add(billinghint);


        paybtn = new JButton("Pay");
        paybtn.setBounds(450, 500, 240, 50);
        paybtn.addActionListener(this);
        paybtn.addMouseListener(this);
        paybtn.setBackground(c2);
        paybtn.setForeground(Color.WHITE);
        panel.add(paybtn);

        pbimg = new ImageIcon("Images/paybill.png");
        pbimglbl = new JLabel(pbimg);
        pbimglbl.setBounds(0,0,1024,768);
        panel.add(pbimglbl);

        this.add(panel);
    }

    public void mouseClicked(MouseEvent me) {}
    public void mousePressed(MouseEvent me) {}
    public void mouseReleased(MouseEvent me) {}

    public void mouseEntered(MouseEvent me) {
        if(me.getSource()==logoutbtn){
            logoutbtn.setBackground(c4);
            logoutbtn.setForeground(Color.BLACK);
        }
        else if (me.getSource()==backbtn) {
            backbtn.setBackground(c3);
            backbtn.setForeground(Color.BLACK);

        }
    }

    public void mouseExited(MouseEvent me) {
        if(me.getSource()==logoutbtn){
            logoutbtn.setForeground(Color.WHITE);
            logoutbtn.setBackground(c2);
        }
        else if (me.getSource()==backbtn) {
            backbtn.setBackground(c2);
            backbtn.setForeground(Color.WHITE);

        }
    }


    public void actionPerformed(ActionEvent ae) {
        String s1 = cardfld.getText();
        String s2 = expfld.getText();
        String s3 = cvcfld.getText();
        String s4 = billingfld.getText();
        if(ae.getSource()==paybtn){
            if (s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()){
                JOptionPane.showMessageDialog(null,"Fill all First");
            }
            else{
                JOptionPane.showMessageDialog(null,"Payment Successful");
                this.setVisible(false);
                FirstPage fp = new FirstPage(usern,null);
                fp.setVisible(true);
            }
        }
        else if(ae.getSource()==logoutbtn){
            this.setVisible(false);
            Login l1 = new Login();
            l1.setVisible(true);
        } else if (ae.getSource()==backbtn) {
            this.setVisible(false);
            FirstPage fp = new FirstPage(usern,null);
            fp.setVisible(true);
        }

    }

}