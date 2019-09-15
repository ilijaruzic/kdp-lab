package rs.ac.bg.etf.kdp.ri160605.net;

import java.io.*;
import java.net.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class ClientMessageBox<T> implements MessageBox<T> {

    class IO {
        Socket serverSocket;
        ObjectInputStream in;
        ObjectOutputStream out;
    }

    String host;
    int port;

    public ClientMessageBox(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public IO connect() {
        try {
            IO io = new IO();
            io.serverSocket = new Socket(host, port);
            io.out = new ObjectOutputStream(io.serverSocket.getOutputStream());
            io.in = new ObjectInputStream(io.serverSocket.getInputStream());
            return io;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect(IO io) {
        try {
            io.serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Message<T> get(long timeToDie, Status status) {
        try {
            IO io = connect();
            io.out.writeObject("GET");
            Message<T> message = (Message<T>) io.in.readObject();
            disconnect(io);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void put(Message<T> message, Priority priority, long timeToLive) {
        try {
            IO io = connect();
            io.out.writeObject("PUT");
            io.out.writeObject(message);
            disconnect(io);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
