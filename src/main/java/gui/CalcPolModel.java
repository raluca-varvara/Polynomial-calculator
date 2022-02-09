package gui;

import businessLogic.OperationPolinom;
import dataModels.Monom;
import dataModels.Polinom;
import gui.exceptii.InvalidPolinomException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcPolModel {

    private Polinom poly1;
    private Polinom poly2;
    private Polinom total;


    public CalcPolModel() {
        total = new Polinom();
    }

    public void validateMonom(String s) throws InvalidPolinomException {
        Pattern polinom = Pattern.compile("[+-]?[0-9]*(x(\\^[0-9]+)?)?"); // regexul pentru monom
        Matcher matcher = polinom.matcher(s);
        if(!matcher.matches())
            throw new InvalidPolinomException(); // daca nu se potriveste se arunca exceptie
    }

    public Monom stringToMonom(String s){
        int coef=0;
        int p=0;
        int i=0;
        if(s.charAt(i)=='+' || s.charAt(i)=='-'){ // se verifica daca primul caracter este
            i++;
        }
        if(s.charAt(i)=='x') // daca primul caracter fara semn este x inseamna ca coeficientul e 1
            coef=1;
        while(i<s.length()&& s.charAt(i)!='x'){
            coef = coef*10+(s.charAt(i)-'0'); // se creaza coeficientul pana se ajunge la x, se parcurge de la cea mai imp cifra pana la ultima
            i++;
        }
        if(s.charAt(0)=='-') // daca semnul e - se schimba semnul coeficientului
            coef*=-1;

        if(s.charAt(s.length()-1)=='x') // daca ultimul caracter e x puterea e 1
            p=1;
        int j;
        j=s.length()-1;
        int aux = 1;
        while(s.charAt(j)!='x'&&s.charAt(j)!='^'&&j>i){ // se parcurge pana se ajunge la x sau la indicele anterior
            p = p + (s.charAt(j)-'0')*aux; // si se creaza puterea, se parcurge de la unitati in sus
            aux*=10;
            j--;
        }
        return new Monom(coef, p);
    }

    public Polinom setValue(String s) throws InvalidPolinomException {
        Polinom p = new Polinom();
        String substr;
        int inc=0, sf=0; // indicii pentru inceputul si finalul substringurilor

        for(int i=0; i<s.length();i++){
            if(i!=0&&(s.charAt(i)=='-'||s.charAt(i)=='+')){ // daca s-a dat de un minus sau plus inseamna ca s-a terminat monomul curent, si se actualizeaza indicele sfarsitului
                sf=i;
                substr=s.substring(inc, sf);
                this.validateMonom(substr); // se valideaza substringul
                p.getPolinom().add(this.stringToMonom(substr));
                if(s.charAt(i)=='+') // daca ultimul caracter la care s-a ajuns e plus se ignora pt urm substring
                    inc=sf+1;
                else
                    inc=sf;
            }
        }
        substr=s.substring(inc);
        this.validateMonom(substr);
        p.getPolinom().add(this.stringToMonom(substr));
        return p;
    }

    public String getValue(){
        String r;
        try{
            r = total.toString(); // daca rezultatul e nul se poate arunca o exceptie in polinom toStruing si se trateaza
        }
        catch(ArrayIndexOutOfBoundsException e){
            r = "0";
        }
        return r;
    }

    public Polinom getPoly1() {
        return poly1;
    }

    public Polinom getPoly2() {
        return poly2;
    }

    public void setPoly1(Polinom poly1) {
        this.poly1 = poly1;
    }

    public void setPoly2(Polinom poly2) {
        this.poly2 = poly2;
    }

    public void setTotal(Polinom res) {
        this.total = res;
    }

}
