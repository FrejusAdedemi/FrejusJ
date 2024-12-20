package frejus.adedemi;

public class Book {
    private String title;
    private String author;

    // Constructeur
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Représentation sous forme de chaîne
    @Override
    public String toString() {
        return title + ";" + author; // Utilisé pour l'écriture dans le fichier texte
    }

    // Méthode pour créer un Book à partir d'une chaîne (pour lecture du fichier)
    public static Book fromString(String line) {
        String[] parts = line.split(";");
        return new Book(parts[0], parts[1]);
    }
}
