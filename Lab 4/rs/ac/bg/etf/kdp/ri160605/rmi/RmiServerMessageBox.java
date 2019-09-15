package rs.ac.bg.etf.kdp.ri160605.rmi;

import java.rmi.*;
import java.rmi.server.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class RmiServerMessageBox<T> extends UnicastRemoteObject implements RmiMessageBox<T> {

    private static final long serialVersionUID = 1L;
    
    MessageBox<T> buffer;

    protected RmiServerMessageBox(MessageBox<T> buffer) throws RemoteException {
        super();
        this.buffer = buffer;
    }

    @Override
    public Message<T> get(long timeToDie, Status status) throws RemoteException {
        return buffer.get(timeToDie, status);
    }

    @Override
    public void put(Message<T> message, Priority priority, long timeToLive) throws RemoteException {
        buffer.put(message, priority, timeToLive);
    }
}