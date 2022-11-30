package com.example.wazaaaaaaap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class HelloController {

    public TextField ipServera;
    public TextField Poruka;
    public TextField reply;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private Socket s;

    private DataOutputStream dos;

    public void onStartServer(ActionEvent actionEvent) {
        ServerThread st = new ServerThread();
        Thread t = new Thread(st);
        t.start();
    }

    public void OnKonekt(ActionEvent actionEvent) {
        try {
            Socket s = new Socket(ipServera.getText(), 1234);
            this.s = s;
            this.dos = new DataOutputStream(s.getOutputStream());
            ClientThread ct = new ClientThread(s);
            ct.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onSend(ActionEvent actionEvent) {
        try {
            dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(Poruka.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onReply(ActionEvent actionEvent) {
        for (Socket s : HelloApplication.listaKlijenata) {
            try {
                dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(reply.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}