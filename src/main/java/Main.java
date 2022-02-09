public class Main {
    public static void main(String[] args) {
        gui.CalcPolView v = new gui.CalcPolView();
        gui.CalcPolModel m = new gui.CalcPolModel();
        gui.CalcPolController c = new gui.CalcPolController(m, v);

    }
}
