package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField teducation, tfname, taddress, tphone, temail, tsalary, tdesignation;
    JLabel tempid, tname, taadhar, tdob;
    JButton updateBtn, backBtn;
    String number;

    UpdateEmployee(String number) {
        this.number = number;

        getContentPane().setBackground(new Color(163, 255, 188));
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        // Name (Display only)
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        add(tname);

        // Father's Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(177, 252, 197));
        add(tfname);

        // DOB (Display only)
        JLabel dob = new JLabel("Date Of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        add(tdob);

        // Salary
        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(177, 252, 197));
        add(tsalary);

        // Address
        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(177, 252, 197));
        add(taddress);

        // Phone
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(177, 252, 197));
        add(tphone);

        // Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        // Education
        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 200, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);

        // Designation
        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(177, 252, 197));
        add(tdesignation);

        // Aadhar
        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhar = new JLabel();
        taadhar.setBounds(600, 350, 150, 30);
        add(taadhar);

        // Emp ID
        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        // Fetch Employee Data
        try {
            Conn c = new Conn();
            ResultSet rs = c.statement.executeQuery("select * from employee where empid = '" + number + "'");
            if (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tsalary.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                taadhar.setText(rs.getString("aadhar"));
                tempid.setText(rs.getString("empid"));
                tdesignation.setText(rs.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Buttons
        updateBtn = new JButton("Update");
        updateBtn.setBounds(200, 550, 150, 40);
        updateBtn.setBackground(Color.black);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.addActionListener(this);
        add(updateBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(390, 550, 150, 40);
        backBtn.setBackground(Color.black);
        backBtn.setForeground(Color.WHITE);
        backBtn.addActionListener(this);
        add(backBtn);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateBtn) {
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try {
                Conn c = new Conn();
                String query = "UPDATE employee SET fname='" + fname + "', salary='" + salary + "', address='" + address + "', phone='" + phone + "', email='" + email + "', education='" + education + "', designation='" + designation + "' WHERE empid='" + number + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new view_Employee();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new view_Employee();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("101"); // Example Employee ID
    }
}
