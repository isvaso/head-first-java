import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui1 implements ActionListener {

    JButton button;

    public static void main(String[] args) {
        SimpleGui1 gui = new SimpleGui1();
        gui.go();
    }

    public void go() {

        JFrame frame = new JFrame();
        button = new JButton("Click Me");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(500,500);
        frame.setLocation(600, 500);
        frame.setFocusable(true);
        frame.setVisible(true);

        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!button.getText().equals("Fuck!")) {
            button.setText("Fuck!");
            System.out.print("A.");
        } else {
            button.setText("Click Me");
        }
    }
}
