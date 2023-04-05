package Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import App.QuizCard;
import Helper.Helper;

public class SaveMenuListener implements ActionListener {
    private final JTextArea q;
    private final JTextArea a;
    private final ArrayList cardRepo;
    private final Component saveDialogParent;


    public SaveMenuListener(JTextArea questionProvider, JTextArea answerProvider, ArrayList repo, Component saveDialogParent) {
        this.q = questionProvider;
        this.a = answerProvider;
        this.cardRepo = repo;
        this.saveDialogParent = saveDialogParent;
    }

    public void actionPerformed(ActionEvent e) {
        cardRepo.add(new QuizCard(q.getText(), a.getText()));

        JFileChooser fileSave = new JFileChooser();
        fileSave.showSaveDialog(saveDialogParent);
        Helper.SaveFile(fileSave.getSelectedFile(), cardRepo);



    }
}