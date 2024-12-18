import java.util.ArrayList;

public class Bibliotheque {
    private String nom;
    private ArrayList<Livres> livres;
    private ArrayList<Adherents> adherents;
    private ArrayList<Reservations> reservations;

    public Bibliotheque(String nom) {
        this.nom = nom;
        this.livres = new ArrayList<Livres>();
        this.adherents = new ArrayList<Adherents>();
        this.reservations = new ArrayList<Reservations>();
    }

    public void addData() {
        livres.add(new Roman("Le rouge et le noir", "Stendhal", 1830, 500, "Français"));
        livres.add(new Roman("Les misérables", "Victor Hugo", 1862, 1500, "Français"));
        livres.add(new Roman("Madame Bovary", "Gustave Flaubert", 1857, 500, "Français"));
        livres.add(new Roman("Les fleurs du mal", "Charles Baudelaire", 1857, 500, "Français"));

        livres.add(new Revue("Le monde", "Le monde", 1944, "Actualité"));
        livres.add(new Revue("Le figaro", "Le figaro", 1826, "Actualité"));
        livres.add(new Revue("Le point", "Le point", 1972, "Actualité"));
        livres.add(new Revue("L'express", "L'express", 1953, "Actualité"));

        adherents.add(new Adherents("Jean", "Dupont", "4 rue de la paix", "04 78 45 12 36", 1983));
        adherents.add(new Adherents("Pierre", "Durand", "5 rue de la paix", "04 78 45 12 36", 1983));
        adherents.add(new Adherents("Paul", "Dujardin", "6 rue de la paix", "04 78 45 12 36", 1983));
        adherents.add(new Adherents("Jacques", "Dumas", "7 rue de la paix", "04 78 45 12 36", 1983));
    }

    public void afficherLivres() {
        System.out.println("\n|--------------- LISTE DES LIVRES ---------------|");
        for (Livres livre : livres) {
            System.out.println("| " + livre);
        }
        System.out.println("\n");
    }

    public void afficherAdherents() {
        System.out.println("\n|--------------- LISTE DES ADHERENTS ------------|");
        for (Adherents adherent : adherents) {
            System.out.println("| " + adherent);
        }
        System.out.println("\n");
    }

    public void afficherHistoriqueEmprunts() {
        System.out.println("\n|--------------- HISTORIQUE DES EMPRUNTS --------|");
        for (Reservations reservation : reservations) {
            System.out.println("| " + reservation);
        }
        System.out.println("\n");
    }

    public void afficherEmpruntsAdherent(int numeroAdherent) {
        System.out.println("\n|--------------- EMPRUNTS DE L'ADHERENT ---------|");
        for (Reservations reservation : reservations) {
            if (reservation.getAdherent().getId() == numeroAdherent) {
                System.out.println("| " + reservation);
            }
        }
        System.out.println("\n");
    }

    public void ajouterLivre(Livres livre) {
        this.livres.add(livre);
    }

    public void ajouterAdherent(Adherents adherent) {
        adherents.add(adherent);
    }

    public void ajouterReservation(Reservations reservation) {
        this.reservations.add(reservation);
    }

    public void supprimerReservation(Reservations reservation) {
        this.reservations.remove(reservation);
    }

    public String getNom() {
        return this.nom;
    }

    public ArrayList<Livres> getLivres() {
        return this.livres;
    }

    public Livres getLivre(int id) {
        for (Livres livre : livres) {
            if (livre.getIsbn() == id) {
                return livre;
            }
        }
        return null;
    }

    public ArrayList<Adherents> getAdherents() {
        return this.adherents;
    }

    public Adherents getAdherent(int id) {
        for (Adherents adherent : adherents) {
            if (adherent.getId() == id) {
                return adherent;
            }
        }
        return null;
    }

    public ArrayList<Reservations> getReservations() {
        return this.reservations;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
