package testPolCalc;

import businessLogic.exceptiiAritm.DivideByZeroException;
import gui.exceptii.InvalidPolinomException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestOperations {
    private dataModels.Polinom pa = new dataModels.Polinom();
    private dataModels.Polinom pb = new dataModels.Polinom();
    private dataModels.Polinom pc = new dataModels.Polinom();

    @Before
    public void setUp() {
        pa.getPolinom().add(new dataModels.Monom(1, 3));
        pa.getPolinom().add(new dataModels.Monom(-2, 2));
        pa.getPolinom().add(new dataModels.Monom(6, 1));
        pa.getPolinom().add(new dataModels.Monom(-5, 0));
        pb.getPolinom().add(new dataModels.Monom(1, 2));
        pb.getPolinom().add(new dataModels.Monom(-1, 0));
        pc = new dataModels.Polinom();
    }

    @Test
    public void testAddTrue() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 3));
        pc.getPolinom().add(new dataModels.Monom(-1, 2));
        pc.getPolinom().add(new dataModels.Monom(6, 1));
        pc.getPolinom().add(new dataModels.Monom(-6, 0));
        assertEquals(new businessLogic.OperationPolinom().adunare(pa, pb).toString(),pc.toString());
    }
    @Test
    public void testAddFalse() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 3));
        pc.getPolinom().add(new dataModels.Monom(1, 2));
        pc.getPolinom().add(new dataModels.Monom(6, 1));
        pc.getPolinom().add(new dataModels.Monom(-6, 0));
        assertNotEquals(new businessLogic.OperationPolinom().adunare(pa, pb).toString(),pc.toString());
    }
    @Test
    public void testSubTrue() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 3));
        pc.getPolinom().add(new dataModels.Monom(-3, 2));
        pc.getPolinom().add(new dataModels.Monom(6, 1));
        pc.getPolinom().add(new dataModels.Monom(-4, 0));
        assertEquals(new businessLogic.OperationPolinom().scadere(pa, pb).toString(),pc.toString());
    }
    @Test
    public void testSubFalse() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 3));
        pc.getPolinom().add(new dataModels.Monom(-3, 2));
        pc.getPolinom().add(new dataModels.Monom(6, 1));
        pc.getPolinom().add(new dataModels.Monom(4, 0));
        assertNotEquals(new businessLogic.OperationPolinom().scadere(pa, pb).toString(),pc.toString());
    }
    @Test
    public void testDivTrue() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 1));
        pc.getPolinom().add(new dataModels.Monom(-2, 0));
        try {
            assertEquals(new businessLogic.OperationPolinom().impartire(pa, pb).toString(),pc.toString());
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDivFalse() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 1));
        pc.getPolinom().add(new dataModels.Monom(2, 0));
        try {
            assertNotEquals(new businessLogic.OperationPolinom().impartire(pa, pb).toString(),pc.toString());
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testModuloTrue() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(7, 1));
        pc.getPolinom().add(new dataModels.Monom(-7, 0));
        try {
            assertEquals(new businessLogic.OperationPolinom().modulo(pa, pb).toString(),pc.toString());
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testModuloFalse() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(7, 1));
        pc.getPolinom().add(new dataModels.Monom(7, 0));
        try {
            assertNotEquals(new businessLogic.OperationPolinom().modulo(pa, pb).toString(),pc.toString());
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMulTrue() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 5));
        pc.getPolinom().add(new dataModels.Monom(-2, 4));
        pc.getPolinom().add(new dataModels.Monom(5, 3));
        pc.getPolinom().add(new dataModels.Monom(-3, 2));
        pc.getPolinom().add(new dataModels.Monom(-6, 1));
        pc.getPolinom().add(new dataModels.Monom(5, 0));
        assertEquals(new businessLogic.OperationPolinom().inmultire(pa, pb).toString(),pc.toString());
    }
    @Test
    public void testMulFalse() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1, 5));
        pc.getPolinom().add(new dataModels.Monom(-2, 4));
        pc.getPolinom().add(new dataModels.Monom(5, 3));
        pc.getPolinom().add(new dataModels.Monom(-3, 2));
        pc.getPolinom().add(new dataModels.Monom(-6, 1));
        pc.getPolinom().add(new dataModels.Monom(-5, 0));
        assertNotEquals(new businessLogic.OperationPolinom().inmultire(pa, pb).toString(),pc.toString());
    }
    @Test
    public void testDdxTrue() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(2, 1));
        assertEquals(new businessLogic.OperationPolinom().derivare(pb).toString(),pc.toString());
    }
    @Test
    public void testDdxFalse() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(-2, 1));
        assertNotEquals(new businessLogic.OperationPolinom().derivare(pb).toString(),pc.toString());
    }
    @Test
    public void testIntegrareTrue() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(1.0/3, 3));
        pc.getPolinom().add(new dataModels.Monom(-1, 1));
        assertEquals(new businessLogic.OperationPolinom().integrare(pb).toString(),pc.toString());
    }
    @Test
    public void testIntegrareFalse() {
        pc = new dataModels.Polinom();
        pc.getPolinom().add(new dataModels.Monom(-2, 1));
        assertNotEquals(new businessLogic.OperationPolinom().integrare(pb).toString(),pc.toString());
    }
    @Test
    public void testParsare1True() {
        String s ="x^3-2x^2+6x-5";
        try {
            assertEquals(new gui.CalcPolModel().setValue(s).toString(),pa.toString());
        } catch (InvalidPolinomException e) {
            assertFalse(true);
        }
    }
    @Test
    public void testParsare1False() {
        String s ="x^3+2x^2-6x-5";
        try {
            assertNotEquals(new gui.CalcPolModel().setValue(s).toString(),pa.toString());
        } catch (InvalidPolinomException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testParsare2True() {
        String s ="x^2-1";
        try {
            assertEquals(new gui.CalcPolModel().setValue(s).toString(),pb.toString());
        } catch (InvalidPolinomException e) {
            assertFalse(true);
        }
    }
    @Test
    public void testParsare2False() {
        String s ="x^2O-1";
        try {
            assertNotEquals(new gui.CalcPolModel().setValue(s).toString(),pb.toString());
        } catch (InvalidPolinomException e) {
            assertTrue(true);
        }
    }
}