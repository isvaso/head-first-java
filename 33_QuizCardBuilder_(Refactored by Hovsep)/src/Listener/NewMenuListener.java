package Listener;

import Helper.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewMenuListener implements ActionListener {
    private final JTextArea q;
    private final JTextArea a;
    private final ArrayList cardRepo;

    public NewMenuListener(JTextArea questionProvider, JTextArea answerProvider, ArrayList cardRepo) {
        this.q = questionProvider;
        this.a = answerProvider;
        this.cardRepo = cardRepo;
    }



    public void actionPerformed(ActionEvent e) {
        cardRepo.clear();
        Helper.ClearCard(q,a);
    }
}