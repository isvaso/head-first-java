import java.util.*;
import java.io.*;

public class Jukebox2 {

    ArrayList<Song> songList = new ArrayList<Song>();
    ArtistCompare artistCompare = new ArtistCompare();

    public static void main(String[] args) {
        new Jukebox2().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList, artistCompare);
        System.out.println(songList);
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
        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}
