package businessLogic;

import businessLogic.exceptiiAritm.DivideByZeroException;
import dataModels.Monom;
import dataModels.Polinom;


import java.util.Collections;

public class OperationPolinom {
    public Polinom derivare(Polinom a){
        Polinom derivat = new Polinom();
        OperationMonom op = new OperationMonom();
        for(Monom b: a.getPolinom()){ // se parcurge fiecare monom din polinom
            Monom aux = op.derivare(b); // se deriveaza
            if(aux.getCoeficient()!=0 && aux.getPutere()>=0) // si daca nu e 0 se adauga la rezultat
                derivat.getPolinom().add(aux);
        }
        if(derivat.getPolinom().isEmpty()){
            derivat.getPolinom().add(new Monom(0,0));
        }
        return derivat;
    }
    public Polinom integrare(Polinom a){
        Polinom integrat = new Polinom();
        OperationMonom op = new OperationMonom();
        for(Monom b: a.getPolinom()){     // se parcurge fiecare monom
            Monom aux = op.integrare(b);    // se integreaza
            if(aux.getCoeficient()!=0 && aux.getPutere()>=0)
                integrat.getPolinom().add(aux); // si se adauga la rezultat
        }
        Collections.sort(integrat.getPolinom());
        if(integrat.getPolinom().isEmpty()){
            integrat.getPolinom().add(new Monom(0,0));
        }
        return integrat;
    }
    public Polinom adunare(Polinom a, Polinom b){
        Polinom adunat = new Polinom();
        Polinom paux = new Polinom();
        OperationMonom op = new OperationMonom();
        paux.getPolinom().addAll(a.getPolinom());
        paux.getPolinom().addAll(b.getPolinom());
        Collections.sort(paux.getPolinom());    // se concateneaza cele 2 polinoame si se sorteaza, collection.sort e o sortare stabila
        int ok=1;
        Monom prev = null;
        for(Monom curr:paux.getPolinom()){
            if(ok == 1){ // ok este un flag pentru a atentiona daca s-a facut suma dintre doua monoame, iar daca da sa treaca peste al doilea termen din suma
                if(prev!=null){ // de ex daca o sa fie x^3+2x+x+7 cand se adauga la rezultat se se treaca peste x deoarece el a fost adaugat deja prin suma 2x+x
                    if(prev.getPutere()== curr.getPutere()) {
                        ok = 0;
                        if ((prev.getCoeficient() + curr.getCoeficient() > 0.00001)||(prev.getCoeficient() + curr.getCoeficient() < - 0.00001))
                            adunat.getPolinom().add(op.adunare(prev, curr)); // daca suma da 0 se va ignora termenul
                    }
                    else
                        adunat.getPolinom().add(prev);
                }
            }
            else ok = 1;
            prev = curr;
        }
        if(ok == 1)
            adunat.getPolinom().add(prev);
        if(adunat.getPolinom().isEmpty()){
            adunat.getPolinom().add(new Monom(0,0));
        }
        return adunat;
    }
    public Polinom scadere(Polinom a, Polinom b){
        Polinom aux = new Polinom();
        for(Monom baux: b.getPolinom()){
            aux.getPolinom().add(new Monom(-1*baux.getCoeficient(), baux.getPutere())); // se inverseaza semnul celui de-al doilea termen
        }
        OperationPolinom op = new OperationPolinom();
        return op.adunare(a,aux); // si se aduna

    }
    public Polinom inmultire(Polinom a, Polinom b){
        Polinom inmultit = new Polinom();
        Polinom paux = new Polinom();
        OperationMonom opm = new OperationMonom();
        OperationPolinom opp = new OperationPolinom();
        for(Monom x: a.getPolinom()){ // se inmulteste fiecare monom din primul polinom cu al doilea polinom si rezultatele se aduna
            for(Monom y: b.getPolinom())
                paux.getPolinom().add(opm.inmultire(x,y));

            inmultit = opp.adunare(paux, inmultit);
            paux = new Polinom();
        }
        if(inmultit.getPolinom().isEmpty()){
            inmultit.getPolinom().add(new Monom(0,0));
        }
        return inmultit;
    }
    public Polinom impartire(Polinom a, Polinom b) throws DivideByZeroException {
        OperationMonom op = new OperationMonom();
        Polinom cat = new Polinom();
        Polinom rest = new Polinom();
        rest.getPolinom().addAll(a.getPolinom());
        Monom p = a.getPolinom().get(0);
        Monom q = b.getPolinom().get(0);
        Monom aux;
        Polinom paux;
        do{
            paux = new Polinom();
            aux=op.impartire(p,q);// se imparte primul termen din deimpartit/rest la primul termen din impartitor
            paux.getPolinom().add(aux);
            cat.getPolinom().add(aux);// se adauga la cat
            rest = this.scadere(a,this.inmultire(b,paux)); // se scade din rest inmultirea acestul rezultat cu impartitorul
            p=rest.getPolinom().get(0);

        }while(aux.getPutere()>0&&cat.getPolinom().get(0).getPutere()<rest.getPolinom().get(0).getPutere()); // se repeta pana restul are grad < impartitorului

        return cat;
    }
    public Polinom modulo(Polinom a, Polinom b) throws DivideByZeroException { // D = I * C + R - se afla restul dupa aceasta formula
        Polinom cat = this.impartire(a,b);
        Polinom modulo = this.scadere(a,this.inmultire(cat,b));
        return modulo;
    }
}
