public class Revue extends Livres {
    private String theme;

    public Revue(String titre, String auteur, int annee, String theme) {
        super(titre, auteur, annee);
        this.theme = theme;
    }

    public String getTheme() { return theme; }

    public void setTheme(String theme) { this.theme = theme; }
}