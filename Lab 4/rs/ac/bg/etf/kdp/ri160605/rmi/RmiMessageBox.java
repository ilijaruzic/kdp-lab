package rs.ac.bg.etf.kdp.ri160605.rmi;

import java.rmi.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public interface RmiMessageBox<T> extends Remote {
    
    Message<T> get(long timeToDie, Status status) throws RemoteException;

    void put(Message<T> message, Priority priority, long timeToLive) throws RemoteException;
}
