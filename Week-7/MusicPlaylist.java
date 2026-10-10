
import java.util.Arrays;

public class MusicPlaylist {
    private String[] songs;
    private int songCount;

    public MusicPlaylist(int size) {
        songs = new String[size];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {
        MusicPlaylist playlist = new MusicPlaylist(5);

        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");

        System.out.println("Songs: "
                + Arrays.toString(playlist.getSongs()));
        System.out.println("Total songs: "
                + playlist.getSongCount());

        String[] copy = playlist.getSongs();
        copy[0] = "Changed Song";

        System.out.println("Original first song: "
                + playlist.getSongs()[0]);
    }
}