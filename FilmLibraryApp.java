import java.util.*;

interface IFilm {
    String getTitle();
    String getDirector();
    int getYear();
}

class Film implements IFilm {
    private String title;
    private String director;
    private int year;

    Film(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }

    public String getTitle() { return title; }
    public String getDirector() { return director; }
    public int getYear() { return year; }

    public String toString() {
        return title + " (" + director + ", " + year + ")";
    }
}

interface IFilmLibrary {
    void addFilm(IFilm film);
    IFilm removeFilm(String title);
    List<IFilm> getFilms();
    List<IFilm> searchFilms(String query);
    int getTotalFilmCount();
}

class FilmLibrary implements IFilmLibrary {
    private List<IFilm> films = new ArrayList<>();

    public void addFilm(IFilm film) { films.add(film); }

    public IFilm removeFilm(String title) {
        Iterator<IFilm> it = films.iterator();
        while (it.hasNext()) {
            IFilm film = it.next();
            if (film.getTitle().equals(title)) {
                it.remove();
                return film;
            }
        }
        return null;
    }

    public List<IFilm> getFilms() { return new ArrayList<>(films); }

    public List<IFilm> searchFilms(String query) {
        List<IFilm> result = new ArrayList<>();
        for (IFilm film : films) {
            if (film.getTitle().contains(query) || film.getDirector().contains(query)) {
                result.add(film);
            }
        }
        return result;
    }

    public int getTotalFilmCount() { return films.size(); }
}

public class FilmLibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        FilmLibrary library = new FilmLibrary();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            String title = parts[0];
            String director = parts[1];
            int year = Integer.parseInt(parts[2]);
            library.addFilm(new Film(title, director, year));
        }
        String query = sc.nextLine();
        String titleToDelete = sc.nextLine();

        System.out.println("Total Film Count: " + library.getTotalFilmCount());
        System.out.println("Search Results for " + query + ":");
        List<IFilm> searchResults = library.searchFilms(query);
        for (IFilm f : searchResults) System.out.println(f);

        IFilm removed = library.removeFilm(titleToDelete);
        if (removed != null) System.out.println("Removed Film: " + removed);

        System.out.println("All Films:");
        for (IFilm f : library.getFilms()) System.out.println(f);
    }
}
