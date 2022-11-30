package com.example.wazaaaaaaap;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread{
    Socket s;
    DataInputStream dis;

    public ClientThread(Socket s){
        try {
            this.s = s;
            this.dis = new DataInputStream(s.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run(){
        while(true){
            try {
                System.out.println(dis.readUTF());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
