package businessLogic;
import businessLogic.exceptiiAritm.DivideByZeroException;
import dataModels.Monom;

public class OperationMonom {
    // se aduna coeficientii si se considera ca puterile au acelasi grad
    public Monom adunare(Monom a, Monom b){ // se vor aduna numai polinoame cu acelasi coeficient, metoda ajutatoare pentru adunarea polinoamelor
        return new Monom(a.getCoeficient() + b.getCoeficient(), a.getPutere());
    }
    // rezultatul inmultirii a doua monoame este un nou monom cu coeficientul = inmultirea coef ant si putere = suma puterilor anterioare
    public Monom inmultire(Monom a, Monom b){
        return new Monom(a.getCoeficient()*b.getCoeficient(), a.getPutere()+b.getPutere());
    }
    /// la impartire e la fel ca la inmultire dar coeficientii se impart in puterile se scad
    public Monom impartire(Monom a, Monom b) throws DivideByZeroException {
        if(Math.abs(b.getCoeficient())<0.00000001)
            throw new DivideByZeroException();
        return new Monom(a.getCoeficient()/b.getCoeficient(), a.getPutere()-b.getPutere());
    }
    // la integrare se foloseste formula de integrare a monoamelor
    public Monom integrare(Monom a){
        return new Monom(a.getCoeficient()/(a.getPutere()+1), a.getPutere()+1);
    }
    // se foloseste formula de derivare a monoamelor
    public Monom derivare(Monom a){
        int p = a.getPutere();
        double c = a.getCoeficient() * p;
        if(p > 0)
            p--;
        return new Monom(c, p);
    }
}
