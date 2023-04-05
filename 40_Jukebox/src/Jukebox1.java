import java.util.*;
import java.io.*;

public class Jukebox1 {

    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
    }

    public void getSongs() {
        try {
            File file = new File("SongList1.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addSong(String lineToParse) {
        String [] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }
}
