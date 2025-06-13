package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    Login() {
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        // Background images
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        JLabel imgg = new JLabel(new ImageIcon(i22));
        imgg.setBounds(350, 10, 600, 400);
        add(imgg);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 0, 600, 300);
        add(img);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());

                Conn conn = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);

                if (resultSet.next()) {
                    setVisible(false);
                    new main_();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
