import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimplyGui3C implements ActionListener {

    JFrame frame;

    public static void main(String[] args) {

        SimplyGui3C gui = new SimplyGui3C();
        gui.go();
    }

    public void go() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Press to change");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
}
