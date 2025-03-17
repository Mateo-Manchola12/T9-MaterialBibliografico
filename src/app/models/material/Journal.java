package app.models.material;

public class Journal extends Material {
    private int issue;

    public Journal(String title, String author, int published, int issue) {
        super(title, author, published);
        this.issue = issue;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    @Override
    public boolean lend() {
        boolean lend = this.lend;
        this.lend = true;
        return lend;
    }

    @Override
    public String toString() {
        return String.format("Revista:%n %s%n\tGenero: %s", super.toString(), this.issue);
    }

}