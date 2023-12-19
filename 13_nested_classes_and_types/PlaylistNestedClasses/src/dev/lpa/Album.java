package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList theSongList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.theSongList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.theSongList.add(new Song(title, duration));
    }


    public boolean addToPlayList(int trackNumber, LinkedList<Song> thePlayList) {
        Song checkedSong = this.theSongList.findSong(trackNumber);
        if (checkedSong != null) {
            thePlayList.add(checkedSong);
            return true;
        }
        return false;
    }


    public boolean addToPlayList(String title, LinkedList<Song> thePlayList) {
        Song theSong = theSongList.findSong(title);
        if (theSong != null) {
            thePlayList.add(theSong);
            return true;
        }
        return false;
    }



    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            if (findSong(song.getTitle()) == null) {
                songs.add(song);
                return true;
            }
            return false;
        }

        private Song findSong(String title) {
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            if (trackNumber > 0 && trackNumber <= songs.size()) {
                return songs.get(trackNumber - 1);
            }
            return null;
        }
    }
}
