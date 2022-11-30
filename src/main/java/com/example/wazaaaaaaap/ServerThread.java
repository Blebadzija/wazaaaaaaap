package com.example.wazaaaaaaap;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread implements Runnable{
    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(1234);
            //ss.setSoTimeout(12000);
            System.out.println("Server pokrenut");
            while(true) {
                Socket s = ss.accept();
                ClientThread ct = new ClientThread(s);
                ct.start();
                HelloApplication.listaKlijenata.add(s);
                System.out.println("Neko se konektovao");
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
