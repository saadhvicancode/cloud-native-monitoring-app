package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.*;
import java.sql.*;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JComboBox comboBox;

    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;


    NEW_PATIENT(){

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(250, 241, 165));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(25, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.BLACK);
        panel.add(labelID);


        comboBox = new JComboBox(new String[]{"Aadhaar Card", "Voter ID", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        comboBox.setBackground(new Color(156, 223, 240));
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(25, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.BLACK);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name:");
        labelName1.setBounds(25, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.BLACK);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(25, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.BLACK);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.BLACK);
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.BLACK);
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 150, 15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(25, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.BLACK);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setBounds(25, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.BLACK);
        panel.add(labelRoom);

        //Room Choice//
        c1 = new Choice();
        try{
            conn c  = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        c1.setBounds(271, 274, 150, 20);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setForeground(Color.BLACK);
        c1.setBackground(Color.WHITE);
        panel.add(c1);


        JLabel labelDate = new JLabel("Time:");
        labelDate.setBounds(25, 316, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDate.setForeground(Color.BLACK);
        panel.add(labelDate);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271, 316, 250, 14);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        date.setForeground(Color.BLACK);
        panel.add(date);



        JLabel labelDeposit = new JLabel("Deposit:");
        labelDeposit.setBounds(25, 359, 200, 17);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposit.setForeground(Color.BLACK);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposit);

        b1 = new JButton("ADD");
        b1.setForeground(Color.BLACK);
        b1.setBounds(100, 430, 120, 30);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setForeground(Color.BLACK);
        b2.setBounds(260, 430, 120, 30);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);

        setSize(850, 550);
        setLayout(null);
        setLocation(300, 250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new NEW_PATIENT();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            conn c = new conn();
            String radioBTN = null;

            if(r1.isSelected()){
                radioBTN = "Male";
            }else if(r2.isSelected()){
                radioBTN = "Female";
            }
            String s1 = (String)comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposit.getText();

            try{
                String q = "insert into Patient_Info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1 = "update Room set Availability = 'Occupied' where room_no ="+s6;


                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);

            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
}
