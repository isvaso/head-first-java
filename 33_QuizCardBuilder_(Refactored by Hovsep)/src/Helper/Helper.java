package Helper;

import App.QuizCard;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Helper {

    public static void ClearCard(JTextArea question, JTextArea answer) {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    public static void SaveFile(File file, ArrayList<QuizCard> cards) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){

            for (QuizCard card : cards) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Couldn't write the cardList out");
            e.printStackTrace();
        }
    }
}
