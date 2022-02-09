package gui;

import businessLogic.OperationPolinom;
import businessLogic.exceptiiAritm.DivideByZeroException;
import dataModels.Polinom;
import gui.exceptii.InvalidPolinomException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPolController {
    private CalcPolModel model;
    private CalcPolView view;
    public CalcPolController(CalcPolModel model, CalcPolView view) {
        this.model = model;
        this.view  = view;

        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addMulListener(new MulListener());
        view.addDivListener(new DivListener());
        view.addDdxListener(new DdxListener());
        view.addIntegralListener(new IntegralListener());
        view.addModuloListener(new ModuloListener());
    }
    //
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom res;
            try {
                model.setPoly1(model.setValue(view.getPoly1())); // se incearca sa se seteze valorile operanzilor din model
                model.setPoly2(model.setValue(view.getPoly2()));
                res =new OperationPolinom().adunare(model.getPoly1(), model.getPoly2()); // se efectueaza operatia
                model.setTotal(res);
                view.setTotal(model.getValue());

            } catch (InvalidPolinomException exc) { // se prinde exceptia aruncata in transformarea stringurilor in polinoame
                view.showError("Bad input: "+exc.getMessage());
            }
        }
    }
    // la fel la urmatoarele ca la adunare
    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom res;
            try {
                model.setPoly1(model.setValue(view.getPoly1()));
                model.setPoly2(model.setValue(view.getPoly2()));
                res =new OperationPolinom().scadere(model.getPoly1(), model.getPoly2());
                model.setTotal(res);
                view.setTotal(model.getValue());

            } catch (InvalidPolinomException exc) {
                view.showError("Bad input: "+exc.getMessage());
            }
        }
    }
    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom res;
            try {
                model.setPoly1(model.setValue(view.getPoly1()));
                model.setPoly2(model.setValue(view.getPoly2()));
                res =new OperationPolinom().inmultire(model.getPoly1(), model.getPoly2());
                model.setTotal(res);
                view.setTotal(model.getValue());

            } catch (InvalidPolinomException exc) {
                view.showError("Bad input: "+exc.getMessage());
            }
        }
    }
    // in plus fata de la adunare se poate arunca si exceptie cu impartire la 0 si se trateaza si aceasta
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom res;
            try {
                model.setPoly1(model.setValue(view.getPoly1()));
                model.setPoly2(model.setValue(view.getPoly2()));
                res =new OperationPolinom().impartire(model.getPoly1(), model.getPoly2());
                model.setTotal(res);
                view.setTotal(model.getValue());

            } catch (InvalidPolinomException exc) {
                view.showError("Bad input: "+exc.getMessage());
            }catch(DivideByZeroException exc){
                view.showError(exc.getMessage());
            }
        }
    }
    class ModuloListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom res;
            try {
                model.setPoly1(model.setValue(view.getPoly1()));
                model.setPoly2(model.setValue(view.getPoly2()));
                res =new OperationPolinom().modulo(model.getPoly1(), model.getPoly2());
                model.setTotal(res);
                view.setTotal(model.getValue());

            } catch (InvalidPolinomException exc) {
                view.showError("Bad input: "+exc.getMessage());
            }
            catch(DivideByZeroException exc){
                view.showError(exc.getMessage());
            }
        }
    }
    class DdxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom res;
            try {
                model.setPoly1(model.setValue(view.getPoly1()));
                res =new OperationPolinom().derivare(model.getPoly1());
                model.setTotal(res);
                view.setTotal(model.getValue());

            } catch (InvalidPolinomException exc) {
                view.showError("Bad input: "+exc.getMessage());
            }
        }
    }
    class IntegralListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinom res;
            try {
                model.setPoly1(model.setValue(view.getPoly1()));
                res =new OperationPolinom().integrare(model.getPoly1());
                model.setTotal(res);
                view.setTotal(model.getValue());

            } catch (InvalidPolinomException exc) {
                view.showError("Bad input: "+exc.getMessage());
            }
        }
    }
}
