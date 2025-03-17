package app.models.material;

public class Book extends Material implements IRenew {

    private String genre;

    public Book(String title, String author, int published, String genre) {
        super(title, author, published);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean lend() {
        boolean lend = this.lend;
        this.lend = true;
        return lend;
    }

    @Override
    public String toString() {
        return String.format("Libro:%n %s%n\tGenero: %s", super.toString(), this.genre);
    }

    @Override
    public boolean renew() {
        return lend;
    }
}