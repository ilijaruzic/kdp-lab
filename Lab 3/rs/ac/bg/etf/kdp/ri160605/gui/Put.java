package rs.ac.bg.etf.kdp.ri160605.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import rs.ac.bg.etf.kdp.ri160605.*;

public class Put extends JFrame {

    private static final long serialVersionUID = 1L;

    MessageBox<String> buffer;

    JTextArea textArea;
    JButton button;

    public Put(final MessageBox<String> buffer) {
        super("Put");

        this.buffer = buffer;

        textArea = new JTextArea();
        button = new JButton("Put");
        button.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setEnabled(false);
                    Thread thread = new Thread() {
                        public void run() {
                            Message<String> message = new TextMessage();
                            message.setBody(textArea.getText());
                            buffer.put(message, null, 0);
                            button.setEnabled(true);
                        }
                    };
                    thread.start();
                }
            }
        );
        this.setLayout(new GridLayout(2, 1));
        this.add(textArea);
        this.add(button);
        this.setSize(400, 200);
    }
}
