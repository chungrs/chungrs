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

package cmsc256;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SongList {

    public static void main (String[] args) {
        String artist = "";

        //Prompt user for input if no arguments are passed from the command line
        if (args.length < 1) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter an artist name: ");
            artist = in.nextLine();
            in.close();
        } else {
            /*If the artist's name consists of multiple words and the user does not
            enclose them in double quotes, the program will iterate through args[]
            and concatenate them into a single string with with spaces between the words.*/
            for (int i = 0; i < args.length; i++) {
                if (i == 0) {
                    artist = args[i];
                } else {
                    artist += " " + args[i];
                }
            }
        }

        //Create instance variable of SongList
        SongList sl = new SongList();
        //trim artist string
        String songsByArtist = sl.getSongsByArtist(artist.trim());
        //Print song list
        System.out.println(songsByArtist);
    }

    public String getSongsByArtist(String artist) {
        //Return following message if user does not enter an artist name
        if (artist.isBlank()){
            return "Invalid input: artist name cannot be blank.";
        }

        String songsList = "";

        //create the Bridges object
        Bridges bridges = new Bridges(5, "chungrs", "1313147220589");
        DataSource ds = bridges.getDataSource();
        //Create a List of songs
        List<Song> songData = null;

        //populate the List with data downloaded from Bridges.
        try {
            songData = ds.getSongData();
        } catch (Exception e) {
            songsList = "Unable to connect to Bridges.";
        }

        //Sort the song titles in the List by artist name, album title, and song name.
        Collections.sort(songData, new SongComparator());

        //Iterate through the List of Song objects and add songs by the user-defined artist to songsList. Ignore case to facilitate searching.
        for (Song entry : songData ) {
            if (entry.getArtist().equalsIgnoreCase(artist)) {
                //New line for all lines after the first, if any
                if (!songsList.equals("")) {
                    songsList += "\n";
                }
                songsList += "Title: " + entry.getSongTitle() + "    Artist: " + entry.getArtist() + "    Album: " + entry.getAlbumTitle();
            }
        }

        //If the above for loop does not find any songs by the user-defined artist, then the following message is returned
        if (songsList.isBlank()) {
            songsList = "There are no songs in the playlist by " + artist + ".";
        }

        return songsList;
    }
}