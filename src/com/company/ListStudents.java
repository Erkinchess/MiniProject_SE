package com.company;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// === ListStudents === //

public class ListStudents extends JPanel {
    Frame parent;
    JButton goBack;
    String HEAD[] = {"ID", "Name", "Surname", "Age"};
    JTable table;
    JScrollPane scrollPane;

    public ListStudents (Frame parent){
        this.parent = parent;
        setSize(500, 280);
        setBackground(Color.WHITE);
        setLayout(null);

        goBack = new JButton("Back");
        goBack.setSize(150,20);
        goBack.setLocation(170, 220);
        goBack.setBackground(Color.WHITE);
        goBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        add(goBack);
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.showMainMenu();
            }
        });

        table = new JTable();
        table.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(400,200);
        scrollPane.setLocation(40,10);
        add(scrollPane);
    }

    public void generateTable(ArrayList<Student> students){
        Object data[][] = new Object[students.size()][4];

        for (int i=0; i<students.size(); i++) {
            if (students.get(i) != null) {
                data[i][0] = "00" + students.get(i).getId();
                data[i][1] = students.get(i).getName();
                data[i][2] = students.get(i).getSurname();
                data[i][3] = students.get(i).getAge();
            }
        }
        DefaultTableModel model = new DefaultTableModel(data, HEAD);
        table.setModel(model);
    }
}