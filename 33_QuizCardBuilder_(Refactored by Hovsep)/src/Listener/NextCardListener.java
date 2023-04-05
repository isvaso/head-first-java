package Listener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import App.QuizCard;
import Helper.Helper;

public class NextCardListener implements ActionListener {
    private final JTextArea q;
    private final JTextArea a;
    private ArrayList cardRepo;

    public NextCardListener(JTextArea questionProvider, JTextArea answerProvider, ArrayList repo) {
        this.q = questionProvider;
        this.a = answerProvider;
        this.cardRepo = repo;
    }


    public void actionPerformed(ActionEvent e) {
        cardRepo.add(new QuizCard(q.getText(), a.getText()));
        Helper.ClearCard(q,a);
    }
}