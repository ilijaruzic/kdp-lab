package rs.ac.bg.etf.kdp.ri160605.net;

import java.io.*;
import java.net.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class WorkingThread extends Thread {

    MessageBox<Object> buffer;

    Socket clientSocket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public WorkingThread(Socket clientSocket, MessageBox<Object> buffer) {
        this.buffer = buffer;

        this.clientSocket = clientSocket;
        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void run() {
        try {
            String command = (String) in.readObject();
            if ("PUT".equals(command)) {
                Message<Object> message = (Message<Object>) in.readObject();
                buffer.put(message, null, 0);
            } else if ("GET".equals(command)) {
                Message<Object> message = buffer.get(0, null);
                out.writeObject(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
