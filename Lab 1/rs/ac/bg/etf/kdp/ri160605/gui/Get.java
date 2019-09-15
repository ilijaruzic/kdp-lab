package rs.ac.bg.etf.kdp.ri160605.gui;

import java.awt.event.*;
import javax.swing.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class Get extends JFrame {

    private static final long serialVersionUID = 1L;

    MessageBox<String> buffer;

    JTextArea textArea;
    JButton button;

    public Get() {
        super("Get");

        buffer = new ListMessageBox<String>();

        textArea = new JTextArea();
        button = new JButton("Get");
        button.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message<String> message = buffer.get(0, null);
                    textArea.setText(message.getBody());
                }
            }
        );
        this.add(textArea);
        this.add(button);
    }
}
