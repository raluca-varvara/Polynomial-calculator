package dataModels;

import dataModels.Monom;

import java.util.*;

public class Polinom {
    private List<Monom> polinom = new ArrayList<Monom>();
    @Override
    public String toString() {
        String s = "";
        for (Monom a : polinom)
            if(a.getCoeficient()>0) // daca coeficientul e pozitiv se afiseaza cu plus
                s = s + "+" + a.toString() ;
            else if(a.getCoeficient()<0) // daca e negativ se afiseaza cu minus
                s = s + a.toString() ;
        return s;
    }

    public List<Monom> getPolinom() {
        return polinom;
    }
}
