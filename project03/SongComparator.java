 /******************************************
 * Programming Project 3 - SongList Class  *
 * --------------------------------------- *
 * SongList is a program that obtains data *
 * from an online database then sorts the  *
 * data by artist, album, and song names   *
 * with decreasing priority. The user      *
 * enters an artist name as a command line *
 * argument. If no arguments are detected, *
 * then the program prompts the user to    *
 * enter one. The program then returns     *
 * sorted song information if the database *
 * contains songs by that artist.          *
 * --------------------------------------- *
 * Roy Chung                               *
 * 20200222                                *
 * CMSC 256 Section 902                    *
 ******************************************/

package cmsc256.project03;

import java.util.Comparator;
import bridges.data_src_dependent.Song;

public class SongComparator implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
        //Artist name is top priority, so it is in the outermost if statement
        //if two songs are by the same artist, then album titles are compared
        if (o1.getArtist().equals(o2.getArtist())) {
            //if album titles of two songs by the same artist are identical, then song titles are compared
            if (o1.getAlbumTitle().equals(o2.getAlbumTitle())) {
                return o1.getSongTitle().compareTo(o2.getSongTitle());
            } else { //if album titles are not identical, then the songs are sorted by album title
                return o1.getAlbumTitle().compareTo(o2.getAlbumTitle());
            }
        } else { //if two songs are not by the same artist, then they're sorted by artist name
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }
}