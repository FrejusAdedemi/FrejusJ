package frejus.adedemi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class BookApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public BookApp() {
        frame = new JFrame("Gestion de Location de Livres");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Table pour afficher les livres
        tableModel = new DefaultTableModel(new String[]{"Titre", "Auteur"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Boutons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Ajouter");
        JButton deleteButton = new JButton("Supprimer");
        JButton refreshButton = new JButton("Actualiser");
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Actions des boutons
        addButton.addActionListener(e -> addBook());
        deleteButton.addActionListener(e -> deleteBook());
        refreshButton.addActionListener(e -> refreshTable());

        // Charger les livres au démarrage
        refreshTable();

        frame.setVisible(true);
    }

    // Méthode pour ajouter un livre
    private void addBook() {
        JTextField titleField = new JTextField(15);
        JTextField authorField = new JTextField(15);

        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Titre :"));
        panel.add(titleField);
        panel.add(new JLabel("Auteur :"));
        panel.add(authorField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Ajouter un Livre", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String title = titleField.getText();
                String author = authorField.getText();
                if (!title.isEmpty() && !author.isEmpty()) {
                    BookManager.saveBook(new Book(title, author));
                    JOptionPane.showMessageDialog(frame, "Livre ajouté avec succès !");
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs !");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Erreur lors de l'ajout du livre : " + ex.getMessage());
            }
        }
    }

    // Méthode pour supprimer un livre
    private void deleteBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String title = tableModel.getValueAt(selectedRow, 0).toString();
            String author = tableModel.getValueAt(selectedRow, 1).toString();
            try {
                BookManager.deleteBook(new Book(title, author));
                JOptionPane.showMessageDialog(frame, "Livre supprimé avec succès !");
                refreshTable();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Erreur lors de la suppression du livre : " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Veuillez sélectionner un livre à supprimer !");
        }
    }

    // Méthode pour actualiser la table
    private void refreshTable() {
        try {
            List<Book> books = BookManager.readBooks();
            tableModel.setRowCount(0); // Réinitialiser la table
            for (Book book : books) {
                tableModel.addRow(new Object[]{book.getTitle(), book.getAuthor()});
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Erreur lors du chargement des livres : " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookApp::new);
    }
}
