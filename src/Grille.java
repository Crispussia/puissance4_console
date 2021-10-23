public class Grille {
    private int colonne = 7;
    private int ligne = 6;
    private char[][] table = new char[ligne + 2][colonne + 2];

    public Grille(char [][] table) {
        this.table = table;

    }

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }


    public char[][] getTable() {
        return table;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }



    /**
     * Méthode pour initialiser le plateau de jeu.
     */
    public void init() {
        for (int i = 0; i < this.ligne + 2; i++) {
            for (int j = 0; j < this.colonne + 2; j++) {
                if (i != 0 && i !=7) {
                    if (j != 0 && j != 8)
                        table[i][j] = '.';
                    else
                        table[i][j] = '|';

                } else {
                    table[i][j] = '-';
                }
            }
        }
    }

    /**
     * Méthode pour vider le plateau de jeu.
     */
    public void vider() {
        for (int i = 1; i <= this.ligne; i++) {
            for (int j = 1; j <= this.colonne; j++)
                this.table[i][j] = '.';
        }
    }


    /**
     * Méthode pour afficher le plateau de jeu.
     */
    public void affichage(){

        for (int i = 0; i < this.ligne+2; i++) {

            for (int j = 0; j <this.colonne+2; j++) {
                System.out.print(this.table[i][j]);
                if(i!=0 && i!=ligne+1)
                    System.out.print("  ");
                else {
                    if(j!=colonne+1)
                        System.out.print("--");
                }
            }
            System.out.println();
        }
        System.out.print(" ");
        for(int i=0; i<this.ligne+2;i++)
        {
            if(i!=0 && i!=ligne+2)
                System.out.print("  "+i);
        }
        System.out.println();
    }

    /*Statut de la grille*/
    public int statutGrille(){
        int s=1;
        for(int i=1;i<=this.ligne;i++){
            for(int j=1; j<=this.colonne;j++)
                if(this.getTable()[i][j]=='.')
                    s=-1;

        }
        return s;
    }

    /* Statut colonne*/
    public int statutColonne(int colonne){
        int line=-1;
        for(int i=this.ligne;i>=1;i--){
            if(this.table[i][colonne]=='.') {
                line=i;
                break;
            }
        }
        return line;
    }
    /*statut jeu*/
    public int statutJeu(){
        int somme=1;
        /**
         * Vérifier s'il y a un alignement de 4 jetons à l'horizontal.
         */
        for(int i=1;i<=this.ligne;i++) {
            somme=1;
            for (int j = 1; j <=this.colonne; j++) {
                if (this.table[i][j] !='.' && this.table[i][j] == this.table[i][j+1])
                    somme++;
                else
                    somme = 1;
                if(somme==4) {
                    return somme;

                }
            }

        }


        somme=1;
        /**
         * Vérifier s'il y a un alignement de 4 jetons à la verticale.
         */
        for (int j = 1; j <= this.colonne; j++) {
            somme=1;
            for (int i = 1; i <=this.ligne; i++) {
                if (this.table[i][j] != '.' && this.table[i][j] == this.table[i + 1][j])
                    somme++;
                else
                    somme = 1;
                if(somme==4)
                    return somme;
            }
        }
        somme=0;
        /**
         * Vérifier s'il y a un alignement de 4 jetons en diagonale du bas gauche au haut droit.
         */
        /*Alignement diagonale Haut à gauche vers le haut*/
        for (int i = 1; i<4; i++) {
            somme=0;
            char symbole=this.table[i][1];

            for (int j = 1; j <=this.colonne - i; j++) {

                if (symbole !='.' && this.table[j+i-1][j] ==symbole )
                    somme++;
                else{
                    symbole=this.table[j+i-1][j];
                    somme = 1;
                }

                if(somme==4)
                    return somme;
            }

        }
        /*Alignement diagonale Haut à droite vers le haut*/
        for (int i = 1; i<4; i++) {
            somme=0;
            char symbole=this.table[1][i+1];

            for (int j = 1; j <=this.colonne - i; j++) {

                if (symbole != '.' && this.table[j][j+i] ==symbole )
                    somme++;
                else{
                    symbole=this.table[j][j+i];
                    somme = 1;
                }

                if(somme==4)
                    return somme;
            }

        }
        /*Alignement diagonale Haut à gauche vers le bas*/
        for (int i = 1; i<4; i++) {
            somme=0;
            char symbole=this.table[1][this.colonne - i];

            for (int j = 1; j <=this.colonne - i; j++) {

                if (symbole != '.' && this.table[j][this.colonne - i-j+1] ==symbole )
                    somme++;
                else{
                    symbole=this.table[j][this.colonne - i-j+1];
                    somme = 1;
                }

                if(somme==4)
                    return somme;
            }

        }
        /*Alignement diagonale Haut à gauche vers le bas cette partie génère des erreurs quand je run*/
        for (int i = 1; i<4; i++) {
            somme=0;
            char symbole=this.table[i][7];
            int k = this.colonne;

            for (int j = 1; j <=this.colonne - i; j++) {

                if (symbole != '.' && this.table[i+j-1][k-j+1] ==symbole )
                    somme++;
                else{
                    symbole=this.table[i+j-1][k-j+1];
                    somme = 1;
                }

                if(somme==4)
                    return somme;
            }

        }
        return somme;
    }


}


