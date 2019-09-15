package rs.ac.bg.etf.kdp.ri160605.net;

import java.io.*;
import java.net.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        MessageBox<Object> buffer = new ListMessageBox<Object>();
        try {
            int port = Integer.parseInt(args[0]);
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                processRequest(buffer, clientSocket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void processRequest(MessageBox<Object> buffer, Socket clientSocket) {
        new WorkingThread(clientSocket, buffer).start();
    }
}
