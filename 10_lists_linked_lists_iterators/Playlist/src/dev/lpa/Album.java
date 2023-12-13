package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist, ArrayList<Song> songs) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String song, double duration) {
        if (findSong(song) == null) {
            this.songs.add(new Song(song, duration));
            return true;
        } else {
            System.out.println("Song already exists");
            return false;
        }
    }

    public boolean addToPlayList(String song, LinkedList<Song> thePlayList) {
        if (findSong(song) == null) {
            this.songs.add(new Song(song, duration));
            return true;
        } else {
            System.out.println("Song already exists");
            return false;
        }
    }

    private Song findSong(String songTitle) {
        for (Song song : songs) {
            if (song.getTitle().equals(songTitle)) {
                return song;
            }
        }
        return null;
    }



    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
