import java.util.ArrayList;

public class Bibliotheque {
    private final ArrayList<Livres> listeLivres;
    private final ArrayList<Adherents> listeAdherents;
    private final ArrayList<Emprunts> listeEmprunts;

    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.listeAdherents = new ArrayList<>();
        this.listeEmprunts = new ArrayList<>();
    }

    public void ajouterLivre(Livres livre) { listeLivres.add(livre); }
    public void ajouterAdherent(Adherents adherent) { listeAdherents.add(adherent); }
    public void ajouterEmprunt(Emprunts emprunt) { listeEmprunts.add(emprunt); }

    public Livres searchLivreByIsbn(String isbn) {
        return listeLivres.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }
    public Adherents searchAdherentByNom(String nom) {
        return listeAdherents.stream()
                .filter(a -> a.getNom().equals(nom))
                .findFirst()
                .orElse(null);
    }

    public void getLivres() {
        listeLivres.forEach(System.out::println);
    }
    public void getAdherents() {
        listeAdherents.forEach(System.out::println);
    }
    public void getEmprunts() {
        listeEmprunts.forEach(System.out::println);
    }

    public ArrayList<Emprunts> getListeEmprunts() { return listeEmprunts; }
}