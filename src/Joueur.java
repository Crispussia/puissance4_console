public class Joueur {
    private String nom;
    private char symbole;
    private int score;

    public Joueur(String nom,char symbole){
        this.nom=nom;
        this.symbole=symbole;
        this.score=0;
    }

    public String getNom() {
        return nom;
    }

    public char getSymbole() {
        return symbole;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

}
