package com.company;

// === ClientHandler === //

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        ArrayList<Student> studs = new ArrayList<>();
        try {
            DBManager dm = new DBManager();
            dm.ConnectToDb();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            PackageData take = null;
            while ((take = (PackageData) inputStream.readObject()) != null) {
                if (take.getOperationType().equals("add_student") && take.getStud() != null) {
                    dm.addStudentToDB(take.getStud());
                } else if (take.getOperationType().equals("list_student")) {
                    studs = dm.getAllStudents();
                    take.setStuds(studs);
                    outputStream.writeObject(take);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}