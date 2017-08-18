package pl.com.bottega.books;

import java.util.*;

public class BookCollections {

    // zwraca książki z kolekcji books które zostały napisane przez zadanego autora
    // NIE modyfikuje kolekcji books!

    public static Collection<Book> findByAuthor(Collection<Book> books, Person author) {
        List<Book> list = new LinkedList<>();    // ArrayList bo prawdopodobnie będziemy chcieli któreś z nich wybrać
        for (Book book : books) {
            if (book.getAuthor().equals(author))
                list.add(book);
        }
        return list;
    }

    // zwraca książki z kolekcji books których tytuł zaczyna się od zadanej frazy,
    // wielkość liter nie ma znaczenia
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByTitle(Collection<Book> books, String phrase) {
        List<Book> list = new LinkedList<>();
        for (Book book: books)
            if (book.getTitle().startsWith(phrase, 0))
                list.add(book);
        return list;
    }

    // zwraca książki z kolekcji books które należą do wszystkich zadanych gatunków
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByGenres(Collection<Book> books, Set<Genre> genres) {    // TODO co z kolejnością w generes?
        List<Book> list = new LinkedList<>();
        for (Book book : books)
            if (book.getGenres().containsAll(genres))
                list.add(book);
        return list;
    }


    // zwraca posortowaną rosnąco po tytule listę książek stworzoną z kolekcji books
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByTitle(Collection<Book> books) {
        List<Book> list = new LinkedList<>(books);
        list.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {

                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return list;
    }

    // zwraca posortowaną rosnąco listę książek z kolekcji books po nazwisku, imieniu autora i
    // po tytule
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByAuthorAndTitle(Collection<Book> books) {
        List<Book> list = new LinkedList<>(books);
        list.sort(new Comparator<Book>() {
            private static final int LAST_N_PRIORITY = 100;
            private static final int FIRST_N_PRIORYTY = 10;
            private static final int TITLE_PRIORYTY = 1;

            @Override
            public int compare(Book o1, Book o2) {
                int compLastN = (int) Math.signum(o1.getAuthor().getLastN().compareTo(o2.getAuthor().getLastN()));
                int compFirstN = (int) Math.signum(o1.getAuthor().getFirstN().compareTo(o2.getAuthor().getFirstN()));
                int compTitle = (int) Math.signum(o1.getTitle().compareTo(o2.getTitle()));
                return compLastN * LAST_N_PRIORITY + compFirstN * FIRST_N_PRIORYTY + compTitle * TITLE_PRIORYTY;
            }
        });
        return list;
    }

    //tworzy mapę książek należących do poszczególnych gatunków, jeśli ksiżąka należy
    //do wielu gatunków, powinna wiele razy występować na mapie
    public static Map<Genre, Collection<Book>> genresMap(Collection<Book> books) {
        Map<Genre, Collection<Book>> map = new HashMap<>();
        for (Book book : books) {
            for (Genre genre : book.getGenres()) {
                Collection<Book> mappedCollection = map.get(genre);
                if(mappedCollection == null) {
                    mappedCollection = new LinkedList<>();
                    map.put(genre, mappedCollection);
                }
                mappedCollection.add(book);
            }
        }
        return map;
    }

    //tworzy mapę książek napisanych przez poszczególnych autorów
    public static Map<Person, Collection<Book>> authorsMap(Collection<Book> books) {
        Map<Person, Collection<Book>> map = new HashMap<>();
        for (Book book: books) {
            Collection<Book> mappedCollection = map.get(book.getAuthor());
            if (mappedCollection == null){
                mappedCollection = new LinkedList<>();
                map.put(book.getAuthor(), mappedCollection);
            }
            mappedCollection.add(book);
        }
        return map;
    }


    //tworzy mapę z ilością książek napisanych przez zadanego autora
    public static Map<Person, Integer> authorsBookCountMap(Collection<Book> books) {
        Map<Person, Integer> map = new HashMap<>();
        for (Book book : books) {
            Integer count = map.getOrDefault(book.getAuthor(), 0);
            map.put(book.getAuthor(), count + 1);
        }
        return map;
    }

    // zwraca liczbę książek których autorem jest auhtor
    public static int booksCount(Collection<Book> books, Person author) {
        int counter = 0;
        for (Book book : books)
            if (book.getAuthor().equals(author))
                counter++;
        return counter;
    }


    // zwraca liczbę książek z danego gatunku
    public static int booksCount(Collection<Book> books, Genre genre) {
        int counter = 0;
        for (Book book : books)
            if(book.hasGenere(genre))
                    counter++;
        return counter;
    }
    // zwraca autora który napisał najwięcej książek
    public static Person bestAuthor(Collection<Book> books) {
        Map<Person, Integer> map = authorsBookCountMap(books);
        int courentMax = 0;
            Person bestAuthor = null;
        for (Map.Entry<Person, Integer> entry: map.entrySet())
            if (entry.getValue() > courentMax) {
                bestAuthor = entry.getKey();
                courentMax = entry.getValue();
            }
        return bestAuthor;
    }
    // zwraca gatunek który ma najwięcej książek
    public static Genre mostPopularGenre(Collection<Book> books) {
        Map<Genre, Collection<Book>> map = genresMap(books);
        int courentMax = 0;
        Genre bestGenre = null;
        for (Map.Entry<Genre, Collection<Book>> entry: map.entrySet())
            if (entry.getValue().size() > courentMax){
                bestGenre = entry.getKey();
                courentMax = entry.getValue().size();
            }
        return bestGenre;
    }
}
