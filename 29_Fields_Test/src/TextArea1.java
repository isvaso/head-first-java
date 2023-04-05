import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class TextArea1 implements ActionListener, ItemListener, ListSelectionListener {

    JTextArea text;
    JCheckBox checkbox;
    JList list;

    public static void main(String[] args) {

        TextArea1 gui = new TextArea1();
        gui.go();
    }

    public void go() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton button = new JButton("Just Click It");
        text = new JTextArea(10, 26);
        text.setLineWrap(true);
        checkbox = new JCheckBox("Print");
        checkbox.addItemListener(this);
        checkbox.setForeground(Color.WHITE);

        String[] listEntries = {"Green", "Yellow", "Asphalt", "Copy", "East"};

        list = new JList(listEntries);
        list.setVisibleRowCount(1);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFixedCellWidth(100);

        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JScrollPane scroller = new JScrollPane(text);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scroller);
        panel.add(listScroller);
        panel.add(checkbox);
        panel.setBackground(Color.DARK_GRAY);

        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(350, 300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (checkbox.isSelected() && !list.isSelectionEmpty()) {
            text.append(list.getSelectedValue() + ". Button clicked \n");
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
