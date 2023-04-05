import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MidiFrame implements ActionListener {

    static Helper helper = new Helper();

    static JFrame frame = new JFrame("Maj Min");
    static JButton buttonPlay = new JButton("Play");
    static DrawPanel drawPanel;
    static Sequencer sequencer;

    static int inputUserNote = Integer.parseInt(helper.getUserInput("Enter first note (0 - 127): "));
    static String inputUserChord = helper.getUserInput("Maj/Min? ");
    static int inputSequenceLength = Integer.parseInt(helper.getUserInput("How many steps in sequence? "));
    static int inputTimeSignature = Integer.parseInt(helper.getUserInput("What time signature Will Be? "));
    static int inputBPM = Integer.parseInt(helper.getUserInput("And BPM Please: "));

    static int[] notesProgression;

    public static void main(String[] args) throws InterruptedException {

        MidiFrame midiFrame = new MidiFrame();
        midiFrame.startWorking();
    }


    public void startWorking() throws InterruptedException {

        setUpGUI();

        Thread.sleep(3000);

        frame.setVisible(true);

        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(drawPanel, new int[] {127});
            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            notesProgression = getChordSequence(inputUserNote, inputUserChord, inputSequenceLength);

            int noteTime = 0;

                for (int i = 0; i < notesProgression.length; i++) {

                    track.add(makeMidiEvent(192, 1, 102, 0, noteTime));
                    track.add(makeMidiEvent(144, 1, notesProgression[i], 100, noteTime));
                    track.add(makeMidiEvent(128, 1, notesProgression[i], 100, noteTime + inputTimeSignature));
                    track.add(makeMidiEvent(176, 1, 127, 0, noteTime));

                    noteTime += inputTimeSignature;
                }

                sequencer.setSequence(sequence);
                sequencer.setTempoInBPM(inputBPM);
                sequencer.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public MidiEvent makeMidiEvent(int command, int channel, int additionalParamOne, int additionalParamTwo, int thick) {

        MidiEvent event = null;

        try {
            ShortMessage shortMessage = new ShortMessage();
            shortMessage.setMessage(command, channel, additionalParamOne, additionalParamTwo);
            event = new MidiEvent(shortMessage, thick);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
        }

        return event;
    }


    public int[] getChordSequence(int note, String chord, int length) {

        chord = chord.toLowerCase();

        int[] returnNotesProgression = new int[length];
        int[] chordStructure = getChordNotes(chord);
        int currentOctave = 1;
        int currentChordNote = 0;

        for (int i = 0; i < length; i++) {

            returnNotesProgression[i] = (chordStructure[currentChordNote] + note) + (currentOctave * 12);

            currentChordNote++;

            if (currentChordNote > chordStructure.length - 1) {
                currentChordNote = 0;
                currentOctave++;
            }

        }

        return returnNotesProgression;
    }

    public int[] getChordNotes(String chord) {

        int[] chordSemitonesList = null;

        if ("maj".equals(chord)) {

            chordSemitonesList = new int[] {0, 3, 6};
        }

        if ("min".equals(chord)) {

            chordSemitonesList = new int[] {0, 2, 6};
        }

        return chordSemitonesList;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public void setUpGUI() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //buttonPlay.addActionListener(this);
        drawPanel = new DrawPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.add(BorderLayout.SOUTH, buttonPlay);
        frame.add(drawPanel);
        frame.setBounds(screenSize.width/2-300, screenSize.height/2-300, 600, 600);
        //frame.setVisible(true);
        frame.setAlwaysOnTop(true);
    }


    public class DrawPanel extends JPanel implements ControllerEventListener {

        private boolean messageIsHere = false;
        private int currentOvalStep = 0;

        public void paintComponent(Graphics g) {

            int panelWidth = this.getWidth();
            int panelHeight = this.getHeight();
            int ovalStartRadius = 300;
            int ovalFinishRadius = 30;

            int[] sizesList = getOvalSizesSequence(ovalStartRadius, ovalFinishRadius, inputSequenceLength);

            if (messageIsHere) {

                g.fillRect(0, 0, panelWidth, panelHeight);

                g.setColor(Color.RED);
                g.fillOval(panelWidth/2 - sizesList[currentOvalStep - 1] / 2 , panelHeight/2 - sizesList[currentOvalStep - 1] / 2, sizesList[currentOvalStep - 1], sizesList[currentOvalStep - 1]);

                messageIsHere = false;
            }
        }

        public int[] getOvalSizesSequence(int firstSize, int lastSize, int count) {

            int[] returnSequence = new int[count];

            int middleStepNumber = Math.round((float) (count / 2));
            int ovalSizeIncrement = Math.round((float)(lastSize - firstSize) / count * 2);

            int direction = 1;

            returnSequence[0] = firstSize;
            returnSequence[middleStepNumber] = lastSize;
            returnSequence[count - 1] = firstSize;

            for (int i = 1; i < count - 1; i++) {

                if (i == middleStepNumber) i++;

                if (i > middleStepNumber) direction = -1;

                returnSequence[i] = returnSequence[i - 1] + ovalSizeIncrement * direction;

            }

            return returnSequence;
        }

        @Override
        public void controlChange(ShortMessage event) {

            messageIsHere = true;
            currentOvalStep++;
            repaint();

        }
    }
}
