package businessLogic.exceptiiAritm;

public class DivideByZeroException extends Exception{
    public DivideByZeroException() {
        super("Invalida impartirea cu 0");
    }
}
