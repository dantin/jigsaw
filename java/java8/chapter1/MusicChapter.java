package chapter1;

import java.util.ArrayList;
import java.util.List;

public abstract class MusicChapter {
    protected final List<Artist> artists;
    protected final List<Album> albums;

    public MusicChapter() {
        this.artists = new ArrayList<>();
        this.albums = new ArrayList<>();
        loadData("");
    }

    private void loadData(String file) {

    }
}