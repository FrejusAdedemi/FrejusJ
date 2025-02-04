package Frejus;

public class Anomalie {
    private String description;
    private int anneeApparition;
    private String niveauDangerosite;
    private String statut;

    public Anomalie(String description, int anneeApparition, String niveauDangerosite) {
        this.description = description;
        this.anneeApparition = anneeApparition;
        this.niveauDangerosite = niveauDangerosite;
        this.statut = "Non résolue";
    }

    public String getDescription() {
        return description;
    }

    public int getAnneeApparition() {
        return anneeApparition;
    }

    public String getNiveauDangerosite() {
        return niveauDangerosite;
    }

    public String getStatut() {
        return statut;
    }

    public void changerStatut(String nouveauStatut) {
        if (nouveauStatut.equals("Non résolue") || nouveauStatut.equals("En cours de résolution") || nouveauStatut.equals("Résolue")) {
            this.statut = nouveauStatut;
            System.out.println("Statut de l'anomalie modifié : " + statut);
        } else {
            System.out.println("⚠ Erreur : Statut invalide !");
        }
    }
}
