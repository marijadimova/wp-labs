package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;

    @OneToMany
    private List<Artist> performers;

    @ManyToOne
    private Album album;

    @OneToMany
    List<Review> reviews;

    public Song(){
    }

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
        this.reviews=new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        if (!performers.contains(artist)) {
            performers.add(artist);
        }
    }

}