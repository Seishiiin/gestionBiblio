import java.util.Date;

public class Reservations {
    private Livres livre;
    private Adherents adherent;
    private Date dateReservation;
    private Date dateLimite;
    private boolean enCours;

    public Reservations(Livres livre, Adherents adherent, Date dateReservation) {
        this.livre = livre;
        this.adherent = adherent;
        this.dateReservation = dateReservation;
        this.dateLimite = new Date(dateReservation.getTime() + 7 * 24 * 60 * 60 * 1000);
        this.enCours = true;
    }

    public String toString() {
        return "Livre : " + livre.getTitre() + " - Adhérent : " + adherent.getNom() + " " + adherent.getPrenom() + " - Date de réservation : " + dateReservation + " - Date limite : " + dateLimite + " - En cours : " + enCours;
    }

    public Livres getLivre() { return livre; }
    public Adherents getAdherent() { return adherent; }
    public Date getDateReservation() { return dateReservation; }
    public Date getDateLimite() { return dateLimite; }
    public boolean getEnCours() { return enCours; }

    public void setEnCours(boolean enCours) { this.enCours = enCours; }
}
