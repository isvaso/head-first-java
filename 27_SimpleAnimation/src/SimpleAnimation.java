import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {

    int x = 50;
    int y = 50;

    public static void main(String[] args) {

        SimpleAnimation simpleAnimation = new SimpleAnimation();
        simpleAnimation.go();
    }

    public void go() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(600, 600);
        frame.setVisible(true);

        for (int i = 0; i < 20000; i++) {

            i = i < 1100 ? i++ : 0;
            x = i + (int) Math.cos(x);
            y = i + 50;

            System.out.println();
            drawPanel.repaint();

            try {
                Thread.sleep(1);
            } catch (Exception ex) {}
        }
    }

    public class MyDrawPanel extends JPanel{

        public void paintComponent(Graphics g) {

            g.setColor(Color.red);
            g.fillOval(x, y, 50, 50);

        }
    }
}




