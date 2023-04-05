import javax.sound.midi.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MiniPlayer {

    public static void main(String[] args) {

        MiniPlayer mini = new MiniPlayer();

        int newNote =  Integer.parseInt(mini.getInput("Enter new note code"));
        int newInstrument =  Integer.parseInt(mini.getInput("Enter new instrument code"));

        mini.play(newNote, newInstrument);
    }

        public void play(int instrument, int note) {

            try {

                Sequencer player = MidiSystem.getSequencer();
                player.open();
                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();

                MidiEvent event = null;

                ShortMessage first = new ShortMessage();
                first.setMessage(192, 1, instrument, 0);
                MidiEvent changeInstrument = new MidiEvent(first, 1);
                track.add(changeInstrument);

                ShortMessage a = new ShortMessage();
                a.setMessage(144 , 1, note, 90);
                MidiEvent noteOn = new MidiEvent(a, 1);
                track.add(noteOn);

                ShortMessage b = new ShortMessage();
                b.setMessage(128, 1, note, 90);
                MidiEvent noteOff = new MidiEvent(b, 16);
                track.add(noteOff);

                ShortMessage aa = new ShortMessage();
                aa.setMessage(144 , 1, note/2, 100);
                MidiEvent noteOn2 = new MidiEvent(aa, 1);
                track.add(noteOn2);

                ShortMessage bb = new ShortMessage();
                bb.setMessage(128, 1, note/3, 100);
                MidiEvent noteOff2 = new MidiEvent(bb, 16);
                track.add(noteOff2);

                ShortMessage aaa = new ShortMessage();
                aaa.setMessage(144 , 1, note/3 + 9, 50);
                MidiEvent noteOn3 = new MidiEvent(aaa, 1);
                track.add(noteOn3);

                ShortMessage bbb = new ShortMessage();
                bbb.setMessage(128, 1, note/3 + 9, 50);
                MidiEvent noteOff3 = new MidiEvent(bbb, 16);
                track.add(noteOff3);



                player.setSequence(seq);
                player.start();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public String getInput(String startMessage) {

            System.out.print(startMessage + " ");

            String inputLine = null;

            try {
                BufferedReader is = new BufferedReader(
                        new InputStreamReader(System.in));
                inputLine = is.readLine();
                if (inputLine.length() == 0) return null;

            } catch (IOException ex) {
                System.out.println("IOException " + ex);
            }
            assert inputLine !=  null;
            return inputLine;

        }
    }
