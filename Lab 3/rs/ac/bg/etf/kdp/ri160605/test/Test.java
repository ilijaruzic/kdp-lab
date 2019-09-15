package rs.ac.bg.etf.kdp.ri160605.test;

import rs.ac.bg.etf.kdp.ri160605.*;
import rs.ac.bg.etf.kdp.ri160605.gui.*;

public class Test {

   public static void main(String[] args) {
       MessageBox<String> buffer = new ListMessageBox<String>();
       Put put = new Put(buffer);
       Get get = new Get(buffer);
       put.setVisible(true);
       get.setVisible(true);
   }
}
