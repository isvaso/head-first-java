import javax.swing.*;
import java.awt.*;

public class MyDrawPanel extends JPanel {

    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int xOval = (int)(Math.random() * 300 + 50);
        int yOval = (int)(Math.random() * 300 + 50);

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        Color randomColor1 = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);

        Color randomColor2 = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(xOval, yOval+50, randomColor1, xOval+100, yOval+50, randomColor2);
        g2d.setPaint(gradient);
        g2d.fillOval(xOval, yOval, 100, 100);

    }
}
