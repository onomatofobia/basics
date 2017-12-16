package pl.com.bottega.homework.bookcollection;

import java.lang.reflect.Array;
import java.util.*;

import static pl.com.bottega.homework.bookcollection.Genre.*;

public class BookCollections {

    public static void main(String[] args) {

     /*   Collection<Book> shelf = new ArrayList<>();

        Set<Genre> horror = new HashSet<>();
        horror.add(HORROR);
        Set<Genre> fantasy = new HashSet<>();
        fantasy.add(FANTASY);
        Set<Genre> romantic = new HashSet<>();
        romantic.add(ROMANTIC);
        Set<Genre> nonfiction = new HashSet<>();
        nonfiction.add(NON_FICTION);

        Book b1 = new Book("Ogniem i mieczem", new Person("Henryk", "Sienkiewicz"), romantic);
        Book b2 = new Book("Potop", new Person("Henryk", "Sienkiewicz"), romantic);
        Book b3 = new Book("To", new Person("Stephen", "King"), horror);
        Book b4 = new Book("Pan Wołodyjowski", new Person("Henryk", "Sienkiewicz"), romantic);
        Book b5 = new Book("Władca Pierścieni", new Person("John", "Tolkien"), fantasy);
        Book b6 = new Book("Krótka historia czasu", new Person("Stephen", "Hawking"), nonfiction);

        shelf.add(b1);
        shelf.add(b2);
        shelf.add(b3);
        shelf.add(b4);
        shelf.add(b5);
        shelf.add(b6);

        System.out.println("------  Wynik szukania po autorze: ------\n"+ findByAuthor(shelf, new Person("Stephen", "Hawking")).toString());
        System.out.println("------ Wynik szukania po frazie tytułu: ------\n" + findByTitle(shelf, "cie").toString());
        System.out.println("------ Wynik szukania po gatunku: ------\n" + findByGenres(shelf, horror).toString());
        System.out.println("------ Lista posortowana po tytule: ------\n" + sortByTitle(shelf).toString());
        System.out.println("------ Lista posortowana po autorze i tytule: ------\n" + sortByAuthorAndTitle(shelf).toString());
        System.out.println("------ Mapa książek z poszczególnych gatunków: ------\n" + genresMap(shelf).toString());
        System.out.println("------ Mapa książek poszczególnych autorów: ------\n" + authorsMap(shelf).toString());
        System.out.println("------ Mapa autorów z ilością napisanych książek: ------\n" + authorsBookCountMap(shelf).toString());
        System.out.println("------ Ilość książek danego autora: ------\n" + booksCount(shelf, new Person("Henryk", "Sienkiewicz")));
        System.out.println("------ Ilość książek danego gatunku: ------\n" + booksCount(shelf, Genre.ROMANTIC));
        System.out.println("------ Autor z największą ilością książek: ------\n" + bestAuthor(shelf));
        System.out.println("------ Gatunek z największą ilością książek: ------\n" + mostPopularGenre(shelf));*/

        System.out.println("------ Zmapowane zdanie: ------\n" + wordIndexMap("ala ma kota ala"));
        System.out.println("------ Zmapowane zdanie ponownie: ------\n" + wordIndexMap2("ala ma kota ala"));
        System.out.println("------ Zmapowane zdanie ponownie: ------\n" + wordIndexMap2("a aaa aa a aaaa"));
        System.out.println("------ Zmapowane zdanie ponownie: ------\n" + wordIndexMap2("   ALA ala ala ala Ala alaALA alaala   "));

    }

    // zwraca książki z kolekcji books które zostały napisane przez zadanego autora
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByAuthor(Collection<Book> books, Person author) {
        List<Book> collection = new ArrayList<>(books);
        List<Book> collectionOfAuthor = new ArrayList<>();

        for (Book singleBook : books) {
            if (singleBook.isWrittenBy(author))
                collectionOfAuthor.add(singleBook);
        }
        return collectionOfAuthor;
    }

    // zwraca książki z kolekcji books których tytuł zaczyna się od zadanej frazy,
    // wielkość liter nie ma znaczenia
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByTitle(Collection<Book> books, String phrase) {
        List<Book> collectionByTitle = new ArrayList<>();
        String lowerPhrase = phrase.toLowerCase();

        for (Book singleBook : books) {
            if (singleBook.getTitle().toLowerCase().contains(lowerPhrase))
                collectionByTitle.add(singleBook);
        }
        return collectionByTitle;
    }

    // zwraca książki z kolekcji books które należą do wszystkich zadanych gatunków
    // NIE modyfikuje kolekcji books!
    public static Collection<Book> findByGenres(Collection<Book> books, Set<Genre> genres) {
        List<Book> collectionByGenre = new ArrayList<>();

        for (Book singleBook : books) {
            if (singleBook.hasGenres(genres))
                collectionByGenre.add(singleBook);
        }
        return collectionByGenre;
    }

    // zwraca posortowaną rosnąco po tytule listę książek stworzoną z kolekcji books
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByTitle(Collection<Book> books) {
        List<Book> sortedByTitle = new ArrayList<>(books);
        sortedByTitle.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return sortedByTitle;
    }

    // zwraca posortowaną rosnąco listę książek z kolekcji books po nazwisku, imieniu autora i
    // po tytule
    // NIE modyfikuje kolekcji books!
    public static List<Book> sortByAuthorAndTitle(Collection<Book> books) {
        List<Book> sortedByAuthorAndTitle = new ArrayList<>(books);
        sortedByAuthorAndTitle.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //-1 o1 < o2
                // 0 o1 == o2
                // 1 o1 > o2
                int compareLastName = o1.getAuthor().getLastName().compareTo(o2.getAuthor().getLastName());

                if (compareLastName == 0) {
                    int compareFirstName = o1.getAuthor().getFirstName().compareTo(o2.getAuthor().getFirstName());
                    if (compareFirstName == 0) {
                        return o1.getTitle().compareTo(o2.getTitle());
                    } else
                        return compareFirstName;
                } else
                    return compareLastName;
            }
        });
        return sortedByAuthorAndTitle;
    }

    //tworzy mapę książek należących do poszczególnych gatunków, jeśli ksiżąka należy
    //do wielu gatunków, powinna wiele razy występować na mapie
    public static Map<Genre, Collection<Book>> genresMap(Collection<Book> books) {
        Map<Genre, Collection<Book>> genreMap = new HashMap<>();
        Collection<Book> newCollection;

        for (Book singleBook : books) {
            for (Genre singleGenre : singleBook.getGenres()) {
                newCollection = genreMap.get(singleGenre);
                if (newCollection == null) {
                    newCollection = new ArrayList<>();
                    genreMap.put(singleGenre, newCollection);
                }
                newCollection.add(singleBook);
            }
        }
        return genreMap;
    }

    //tworzy mapę książek napisanych przez poszczególnych autorów
    public static Map<Person, Collection<Book>> authorsMap(Collection<Book> books) {
        Map<Person, Collection<Book>> authorsMap = new HashMap<>();
        Collection<Book> newCollection;

        for (Book singleBook : books) {
            newCollection = authorsMap.get(singleBook.getAuthor());
            if (newCollection == null) {
                newCollection = new ArrayList<>();
                authorsMap.put(singleBook.getAuthor(), newCollection);
            }
            newCollection.add(singleBook);
        }
        return authorsMap;
    }


    //tworzy mapę z ilością książek napisanych przez zadanego autora
    public static Map<Person, Integer> authorsBookCountMap(Collection<Book> books) {
        Map<Person, Integer> authorsBookCountMap = new HashMap<>();
        Integer bookCounter;

        for (Book singleBook : books) {
            bookCounter = authorsBookCountMap.get(singleBook.getAuthor());
            if (bookCounter == null)
                authorsBookCountMap.put(singleBook.getAuthor(), 1);
            else
                authorsBookCountMap.put(singleBook.getAuthor(), bookCounter + 1);
        }
        return authorsBookCountMap;
    }

    // zwraca liczbę książek których autorem jest auhtor
    public static int booksCount(Collection<Book> books, Person author) {
        int counter = 0;
        for (Book singleBook : books) {
            if (author.equals(singleBook.getAuthor())) {
                counter++;
            }
        }
        return counter;
    }


    // zwraca liczbę książek z danego gatunku
    public static int booksCount(Collection<Book> books, Genre genre) {
        int counter = 0;
        for (Book singleBook : books) {
            if (singleBook.hasGenre(genre))
                counter++;
        }
        return counter;
    }

    // zwraca autora który napisał najwięcej książek
    public static Person bestAuthor(Collection<Book> books) {
        Person bestAuthor = null;
        int currentHighestAmount = 0;
        Map<Person, Integer> bestAuthorMap = authorsBookCountMap(books);

        for (Map.Entry<Person, Integer> singleEntry : bestAuthorMap.entrySet()) {
            if (currentHighestAmount < singleEntry.getValue()) {
                currentHighestAmount = singleEntry.getValue();
                bestAuthor = singleEntry.getKey();
            }
        }
        return bestAuthor;
    }

    // zwraca gatunek który ma najwięcej książek
    public static Genre mostPopularGenre(Collection<Book> books) {
        Genre bestGenre = null;
        int currentHighestAmount = 0;
        Map<Genre, Collection<Book>> bestGenreMap = genresMap(books);

        for (Map.Entry<Genre, Collection<Book>> singleEntry : bestGenreMap.entrySet()) {
            if (currentHighestAmount < singleEntry.getValue().size()) {
                currentHighestAmount = singleEntry.getValue().size();
                bestGenre = singleEntry.getKey();
            }
        }
        return bestGenre;
    }

    public static Map<String, List<Integer>> wordIndexMap(String text) {
        Map<String, List<Integer>> wordIndexMap = new HashMap<>();
        int wordStartIndex = -1;
        text = text + ' ';
        for (int index = 0; index < text.length(); index++) {
            char currentChar = text.charAt(index);
            if (Character.isWhitespace(currentChar)) {
                if (wordStartIndex != -1) {
                    String word = text.substring(wordStartIndex, index);
                    putWord(wordIndexMap, word, wordStartIndex);
                    wordStartIndex = -1;
                } else if (wordStartIndex == -1)
                    wordStartIndex = index;
            }
        }
        return wordIndexMap;
    }


    private static void putWord(Map<String, List<Integer>> wordIndexMap, String word, int index) {
        List<Integer> currentIndexes = wordIndexMap.get(word);
        if (currentIndexes == null) {
            currentIndexes = new LinkedList<>();
            wordIndexMap.put(word, currentIndexes);
        }
        currentIndexes.add(index);
    }

    public static Map<String, List<Integer>> wordIndexMap2(String text) {
        Map<String, List<Integer>> wordIndexMap = new HashMap<>();
        int wordIndex = 0;
        String[] words = text.split(" ");

        for (String word : words) {
            if (!word.isEmpty()) {
              wordIndex = text.indexOf(word, wordIndex);
              putWord(wordIndexMap, word, wordIndex);
              wordIndex += 1;
            }
        }
        return wordIndexMap;
    }
}