package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int id=0;
        try {
            ServerSocket server = new ServerSocket(4040);
            while (true){
                Socket socket = server.accept();
                id++;
                System.out.println("Client #"+id+" connected");
                ClientHandler ch = new ClientHandler(socket);
                ch.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
