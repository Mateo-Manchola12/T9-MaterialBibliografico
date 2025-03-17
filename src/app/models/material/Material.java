package app.models.material;

public abstract class Material {
    protected String title;
    protected String author;
    protected int published;
    protected boolean lend;

    public Material(String title, String author, int published) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.lend = false;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished() {
        return this.published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public boolean getLend() {
        return this.lend;
    }

    public void setLend(boolean lend) {
        this.lend = lend;
    }

    public abstract boolean lend();

    @Override
    public String toString() {
        return String.format("""
                \tTitulo: %s
                \tAutor: %s
                \tPublicación: %d
                \tEstado: %s
                """,
                this.title,
                this.author,
                this.published,
                this.lend ? "Prestado" : "No prestado");
    }

    final boolean remit() {
        boolean lend = this.lend;
        this.lend = false;
        return !lend;
    }
}