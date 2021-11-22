package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// === AddStudents === //

public class AddStudents extends JPanel {
    Frame parent;

    public AddStudents(Frame parent){
        this.parent = parent;
        setSize(500, 280);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setSize(80,30);
        nameLabel.setLocation(70,30);
        add(nameLabel);

        JTextField nameText = new JTextField();
        nameText.setSize(250, 30);
        nameText.setLocation(150, 30);
        add(nameText);

        JLabel surLabel = new JLabel("SURNAME:");
        surLabel.setSize(80,30);
        surLabel.setLocation(70,80);
        add(surLabel);

        JTextField surText = new JTextField();
        surText.setSize(250, 30);
        surText.setLocation(150, 80);
        add(surText);

        JLabel ageLabel = new JLabel("AGE:");
        ageLabel.setSize(80,30);
        ageLabel.setLocation(70,130);
        add(ageLabel);

        JTextField ageText = new JTextField();
        ageText.setSize(250, 30);
        ageText.setLocation(150, 130);
        add(ageText);

        JButton addButton = new JButton("ADD");
        addButton.setSize(150,30);
        addButton.setLocation(70,190);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData();
                String new_name = nameText.getText();
                String new_surname = surText.getText();
                int new_age = Integer.parseInt(ageText.getText());
                pd.setOperationType("add_student");
                nameText.setText("");
                surText.setText("");
                ageText.setText("");
                pd.setStud(new Student(null, new_name, new_surname, new_age));
                try {
                    parent.outputStream.writeObject(pd);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setSize(150,30);
        backButton.setLocation(250,190);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainMenu();
            }
        });
    }
}