package dataModels;

public class Monom implements Comparable{
    private double coeficient;
    private int putere;

    public Monom(double coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
    }
    public double getCoeficient() {
        return coeficient;
    }
    public int getPutere() {
        return putere;
    }
    @Override
    public String toString() {
        String s = "";
        if(coeficient == 1 && putere == 0)
            s="1";
        else {
            if (coeficient != 1) // daca coeficientul e 1 nu se afiseaza
                s = s + coeficient;
            if (putere == 1) // daca puterea e 1 nu se mai afiseaza
                s= s+ 'x';
            else if(putere > 1)
                s = s + "x^" + putere;
        }
        return s;
    }
    @Override
    public int compareTo(Object o) {
        Monom aux = (Monom) o;
        return aux.putere-this.putere; // se compara numai puterile, gradul
    }
}
