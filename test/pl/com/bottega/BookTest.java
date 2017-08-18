package pl.com.bottega;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import pl.com.bottega.books.Book;
import pl.com.bottega.books.BookCollections;
import pl.com.bottega.books.Genre;
import pl.com.bottega.books.Person;

import java.util.*;

import static pl.com.bottega.books.Genre.*;

class BookTest {

    private Collection<Book> books = Arrays.asList(
            new Book("czerwona", new Person("adam", "adamowski"), new HashSet<>(Arrays.asList(HORROR, ROMANTIC))),
            new Book("zielona", new Person("bartek", "bartoszewski"), new HashSet<>(Arrays.asList(DRAMA, REALISTIC, TRAGEDY))),
            new Book("brązowa", new Person("bartek", "bartoszewski"), new HashSet<>(Arrays.asList(COMEDY, ROMANTIC))),
            new Book("czarna", new Person("danuta", "danutowska"), new HashSet<>(Arrays.asList(COMEDY, ROMANTIC))),
            new Book("niebieska", new Person("danuta", "danutowska"), new HashSet<>(Arrays.asList(COMEDY, ROMANTIC))),
            new Book("pomarańczowa", new Person("danuta", "danutowska"), new HashSet<>(Arrays.asList(DRAMA, REALISTIC, TRAGEDY))),
            new Book("czarno biała", new Person("celina", "celinowska"), new HashSet<>(Arrays.asList(SATIRE, COMEDY))),
            new Book("biała", new Person("celina", "celinowska"), new HashSet<>(Arrays.asList(FICTION))),
            new Book("żółta", new Person("tomasz", "tomaszewski"), new HashSet<>(Arrays.asList(TRAGICOMEDY, MYTHOLOGY))));

    @Test
    void canFindBooksByAuthor() {
        List<Book> list = new LinkedList<>(BookCollections.findByAuthor(books, new Person("celina", "celinowska")));
        assertEquals("czarno biała", list.get(0).getTitle());
        assertEquals("biała", list.get(1).getTitle());
        assertThat(list).extracting(Book::getTitle).containsOnly("czarno biała", "biała");
    }

    @Test
    void canFindBooksByPhrase() {
        List<Book> list = new LinkedList<>(BookCollections.findByTitle(books, "pom"));
        assertEquals("pomarańczowa", list.get(0).getTitle());
        assertThat(list).filteredOn("title", "pomarańczowa");
    }

    @Test
    void canFindByGenre() {
        Set<Genre> genres = new HashSet<>();
        genres.add(COMEDY);
        genres.add(ROMANTIC);
        Collection<Book> list = BookCollections.findByGenres(books, genres);
        assertEquals(3, list.size());
        assertThat(list).extracting(book -> book.getTitle()).containsOnly("czarna", "niebieska", "brązowa");
        assertThat(list).extracting(Book::getTitle).containsOnly("czarna", "niebieska", "brązowa");
    }

    @Test
    void canSortByTitleAsc() {
        List<Book> list = BookCollections.sortByTitle(books);
        assertEquals("biała", list.get(0).getTitle());
        assertEquals("brązowa", list.get(1).getTitle());
        assertEquals("czarna", list.get(2).getTitle());
        assertEquals("czarno biała", list.get(3).getTitle());
        assertEquals("czerwona", list.get(4).getTitle());
        assertEquals("niebieska", list.get(5).getTitle());
        assertEquals("pomarańczowa", list.get(6).getTitle());
        assertEquals("zielona", list.get(7).getTitle());
        assertEquals("żółta", list.get(8).getTitle());
    }

    @Test
    void canGenerateGenreMap() {
        Map<Genre, Collection<Book>> map = BookCollections.genresMap(books);
        assertEquals(10, map.keySet().size());
        assertThat(map.keySet().size()).isEqualTo(10);
    }

    @Test
    void canCheckHowManyBooksWriteSomeAuthor() {
        int testAmount = BookCollections.booksCount(books, new Person("danuta", "danutowska"));
        assertEquals(3, testAmount);
    }

    @Test
    void canCheckHowManyBooksContainGenre() {
        int testAmount = BookCollections.booksCount(books, Genre.COMEDY);
        assertEquals(4, testAmount);
    }

    @Test
    void canCheckWhoWroteBiggestAmountOfBooks() {
        Person test = BookCollections.bestAuthor(books);
        Person max = new Person("danuta", "danutowska");
        assertEquals(max.getLastN(), test.getLastN());
        assertThat(max).extracting(max.getFirstN(), max.getLastN()).contains(tuple("danuta", "danutowska"));
    }

    @Test
    void canGenereMapWithAuthors() {
        Map<Person, Collection<Book>> map = BookCollections.authorsMap(books);
        assertEquals(5, map.keySet().size());
        assertThat(map.keySet()).extracting(Person::getFirstN, Person::getLastN).
                contains(tuple("adam", "adamowski"),
                        tuple("bartek", "bartoszewski"),
                        tuple("danuta", "danutowska"),
                        tuple("celina", "celinowska"),
                        tuple("tomasz", "tomaszewski"));
        assertThat(map.keySet()).extracting(author -> author.getFirstN(), author -> author.getLastN()).
                contains(tuple("adam", "adamowski"),
                        tuple("bartek", "bartoszewski"),
                        tuple("danuta", "danutowska"),
                        tuple("celina", "celinowska"),
                        tuple("tomasz", "tomaszewski"));
    }

    @Test
    void canGenerateMapWithAmountBookWroteByEachAuthor() {
        Map<Person, Integer> map = BookCollections.authorsBookCountMap(books);
        int amount = map.get(new Person("bartek", "bartoszewski"));
        assertEquals(2, amount);
    }

    @Test
    void canCheckWhichGenreContainsBiggestAmountOfBooks() {
        Genre genre = BookCollections.mostPopularGenre(books);
        assertTrue(genre.equals(ROMANTIC));
        assertThat(genre).isEqualTo(ROMANTIC);
    }

}
