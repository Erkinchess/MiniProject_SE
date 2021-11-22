package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// === MainMenu === //

public class MainMenu extends JPanel {
    Frame parent;

    public MainMenu(Frame parent){
        this.parent = parent;
        Scanner in = new Scanner(System.in);
        setSize(500, 280);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        JButton addButton = new JButton("ADD STUDENT");
        addButton.setSize(300,30);
        addButton.setLocation(100, 30);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showAP();
            }
        });

        JButton listButton = new JButton("LIST STUDENTS");
        listButton.setSize(300,30);
        listButton.setLocation(100, 90);
        add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showLP();
                try {
                    PackageData pd = new PackageData();
                    pd.setOperationType("list_student");
                    parent.outputStream.writeObject(pd);
                    parent.request=null;
                    if ((parent.request = (PackageData) parent.inputStream.readObject())!=null) {
                        parent.LS.generateTable(parent.request.getStuds());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton exitButton = new JButton("EXIT");
        exitButton.setSize(300, 30);
        exitButton.setLocation(100, 150);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}