import java.util.Objects;

public class Song implements Comparable<Song> {
    private String title;
    private String artist;
    private String rating;
    private String bpm;

    public Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    @Override
    public int compareTo(Song o) {
        int compareResult = title.compareTo(o.getTitle());
       //if (compareResult == 0) compareResult = 1;
        return compareResult;

    }

    @Override
    public boolean equals(Object o) {
        Song s = (Song) o;
        return getTitle().equals(s.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        return title;
    }


}
