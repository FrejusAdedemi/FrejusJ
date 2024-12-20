package frejus.adedemi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final String FILE_NAME = "books.txt";

    // Méthode pour sauvegarder un livre dans le fichier
    public static void saveBook(Book book) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(book.toString());
            writer.newLine();
        }
    }

    // Méthode pour lire tous les livres depuis le fichier
    public static List<Book> readBooks() throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        }
        return books;
    }

    // Méthode pour supprimer un livre
    public static void deleteBook(Book book) throws IOException {
        List<Book> books = readBooks();
        books.removeIf(b -> b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor()));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book b : books) {
                writer.write(b.toString());
                writer.newLine();
            }
        }
    }
}
