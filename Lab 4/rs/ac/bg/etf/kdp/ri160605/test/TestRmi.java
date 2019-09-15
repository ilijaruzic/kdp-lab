package rs.ac.bg.etf.kdp.ri160605.test;

import rs.ac.bg.etf.kdp.ri160605.*;
import rs.ac.bg.etf.kdp.ri160605.gui.*;
import rs.ac.bg.etf.kdp.ri160605.rmi.*;

public class TestRmi {

   public static void main(String[] args) {
       MessageBox<String> buffer = new RmiClientMessageBox<String>(args[0], Integer.parseInt(args[1]));
       Put put = new Put(buffer);
       Get get = new Get(buffer);
       put.setVisible(true);
       get.setVisible(true);
   }
}
