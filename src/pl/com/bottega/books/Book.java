package pl.com.bottega.books;


import com.sun.istack.internal.NotNull;
import pl.com.bottega.collections.Gender;

import java.util.HashSet;
import java.util.Set;

public class Book {

    private String title;
    private Person author;
    private Set<Genre> genres = new HashSet<>();

    public Book (String title, Person author, Set<Genre> genres){
        if (title == null || author == null || genres == null || genres.isEmpty())
            throw new IllegalArgumentException("All data required");
            this.title = title;
            this.author = author;
            this.genres.addAll(genres);
        }
    public boolean hasGenere(Genre genre) {
        return genres.contains(genre);
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public Set<Genre> getGenres() {
        return genres;
    }
}
