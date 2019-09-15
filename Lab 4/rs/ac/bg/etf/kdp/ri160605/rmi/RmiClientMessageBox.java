package rs.ac.bg.etf.kdp.ri160605.rmi;

import java.rmi.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class RmiClientMessageBox<T> implements MessageBox<T> {

    RmiMessageBox<T> rmiBuffer;

    @SuppressWarnings("unchecked")
    public RmiClientMessageBox(String host, int port) {
        try {
            System.setSecurityManager(new SecurityManager());

            String url = "rmi://" + host + ":" + port + "/RmiMessageBox";
            Object object = Naming.lookup(url);

            rmiBuffer = (RmiMessageBox<T>) object;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message<T> get(long timeToDie, Status status) {
        try {
            return rmiBuffer.get(timeToDie, status);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void put(Message<T> message, Priority priority, long timeToLive) {
        try {
            rmiBuffer.put(message, priority, timeToLive);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
