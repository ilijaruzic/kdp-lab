package rs.ac.bg.etf.kdp.ri160605.rmi;

import java.rmi.*;
import java.rmi.registry.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class RmiServer {

    public static void main(String[] args) {
        try {
            System.setSecurityManager(new SecurityManager());

            String host = args[0];
            int port = Integer.parseInt(args[1]);
            LocateRegistry.createRegistry(port);

            MessageBox<Object> buffer = new ListMessageBox<Object>();
            RmiMessageBox<Object> rmiBuffer = new RmiServerMessageBox<Object>(buffer);

            String url = "rmi://" + host + ":" + port + "/RmiMessageBox";
            Naming.rebind(url, rmiBuffer);   

            System.out.printf("Server started on port %d.\n", port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
