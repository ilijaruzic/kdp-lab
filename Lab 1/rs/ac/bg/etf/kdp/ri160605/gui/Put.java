package rs.ac.bg.etf.kdp.ri160605.gui;

import java.awt.event.*;
import javax.swing.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class Put extends JFrame {

    private static final long serialVersionUID = 1L;

    MessageBox<String> buffer;

    JTextArea textArea;
    JButton button;

    public Put() {
        super("Put");

        buffer = new ListMessageBox<String>();

        textArea = new JTextArea();
        button = new JButton("Put");
        button.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message<String> message = new TextMessage();
                    message.setBody(textArea.getText());
                    buffer.put(message, null, 0);
                }
            }
        );
        this.add(textArea);
        this.add(button);
    }
}
