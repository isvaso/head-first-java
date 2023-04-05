import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Jukebox3 {

    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox3().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        HashSet<Song> songSet = new HashSet<Song>();
        songSet.addAll(songList);
        System.out.println(songSet);

    }

    public void getSongs() {
        try {
            File file = new File("SongList2.txt");
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
        Song addSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(addSong);
    }
}
