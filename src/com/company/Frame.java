package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

// === Frame === //

public class Frame extends JFrame{
    PackageData request;
    MainMenu MM;
    AddStudents AP;
    ListStudents LS;
    ObjectOutputStream outputStream;
    ObjectInputStream inputStream;
    Socket socket;

    public Frame(){
        try {
            socket = new Socket("localhost", 4040);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            request = new PackageData();
        }catch (Exception e){
            e.printStackTrace();
        }

        setSize(500, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Students Application");
        setResizable(false);
        setBackground(Color.DARK_GRAY);
        setLayout(null);

        MM = new MainMenu(this);
        MM.setVisible(true);
        add(MM);

        AP = new AddStudents(this);
        AP.setVisible(false);
        add(AP);

        LS = new ListStudents(this);
        LS.setVisible(false);
        add(LS);
    }

    public void showMainMenu(){
        AP.setVisible(false);
        LS.setVisible(false);
        MM.setVisible(true);
    }

    public void showAP(){
        LS.setVisible(false);
        MM.setVisible(false);
        AP.setVisible(true);
    }

    public void showLP(){
        MM.setVisible(false);
        AP.setVisible(false);
        LS.setVisible(true);
    }
}