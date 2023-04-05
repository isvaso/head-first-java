package App;

import Listener.NewMenuListener;
import Listener.NextCardListener;
import Listener.SaveMenuListener;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class QuizCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame window;
    private final Font defaultFont;
    private final int defaultCloseOp;

    public QuizCardBuilder(Font f, int defaultCloseOp) {
        this.defaultFont = f;
        this.defaultCloseOp = defaultCloseOp;
    }

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder(
                new Font("sanserif", Font.BOLD, 24),
                JFrame.EXIT_ON_CLOSE
        );
        builder.startApp();
    }

    private JFrame buildWindow(String title, int width, int height) {
        JFrame w;
        w = new JFrame(title);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(width, height);
        return w;
    }

    private JTextArea getTextArea(int rows, int cols) {
        JTextArea ta;
        ta = new JTextArea(rows, cols);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setFont(defaultFont);
        return ta;
    }

    private JScrollPane getPane(Component c){
        JScrollPane p;
        p = new JScrollPane(c);
        p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        p.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return p;
    }

    private JPanel getPanel(Component ... components){
        JPanel p;
        p = new JPanel();
        for (Component c: components) {
            p.add(c);
        }

        return p;
    }

    private JMenuBar getMenuBar(Component saveDialogParent) {
        JMenuBar mb;

        mb = new JMenuBar();
        JMenu fm = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener(question, answer, cardList));
        saveMenuItem.addActionListener(new SaveMenuListener(question, answer, cardList, saveDialogParent));
        fm.add(newMenuItem);
        fm.add(saveMenuItem);
        mb.add(fm);

        return mb;
    }

    public void startApp() {
        window = buildWindow("Quiz Card Builder", 500, 520);
        question = getTextArea(6,20);
        answer = getTextArea(6,20);

        cardList = new ArrayList<QuizCard>();

        JScrollPane qScroller = getPane(question);
        JScrollPane aScroller = getPane(answer);

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(new NextCardListener(question, answer, cardList));

        JPanel mainPanel = getPanel(new JLabel("Question:"), qScroller, new JLabel("Answer:"), aScroller, nextButton);
        JMenuBar menuBar = getMenuBar(window);
        window.setJMenuBar(menuBar);
        window.getContentPane().add(BorderLayout.CENTER, mainPanel);
        window.setVisible(true);
    }
}
