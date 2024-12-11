package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists=null;
    public static List<Song> songs=null;


    @PostConstruct
    public void init(){
        artists=new ArrayList<>();
        artists = new ArrayList<>();
        artists.add(new Artist(6L, "Paul", "McCartney", "English singer, songwriter, and member of The Beatles."));
        artists.add(new Artist(7L, "Mick", "Jagger", "English singer, songwriter, and lead vocalist of The Rolling Stones."));
        artists.add(new Artist(8L, "Stevie", "Wonder", "American singer, songwriter, and musician."));
        artists.add(new Artist(9L, "Aretha", "Franklin", "American singer, songwriter, and the 'Queen of Soul'."));
        artists.add(new Artist(10L, "Bruce", "Springsteen", "American rock singer-songwriter known as 'The Boss'."));

        songs=new ArrayList<>();
        songs.add(new Song("T006", "Hey Jude", "Rock", 1968, new ArrayList<>(), 0));
        songs.add(new Song("T007", "Sympathy for the Devil", "Rock", 1968, new ArrayList<>(), 0));
        songs.add(new Song("T008", "Superstition", "Funk", 1972, new ArrayList<>(), 0 ));
        songs.add(new Song("T009", "Respect", "Soul", 1967, new ArrayList<>(), 0));
        songs.add(new Song("T010", "Born to Run", "Rock", 1975, new ArrayList<>(), 0));



    }
}