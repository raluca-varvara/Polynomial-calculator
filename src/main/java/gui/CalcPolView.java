package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CalcPolView {
    private final JFrame frame = new JFrame("Polynomial calculator");
    private final JPanel content = new JPanel();
    private final JPanel panelButtons = new JPanel();
    private final JLabel title = new JLabel("Polynomial Calculator",SwingConstants.CENTER);
    private final JLabel lPoly1 = new JLabel("First polynom:");
    private final JLabel lPoly2 = new JLabel("Second polynom:");
    private final JLabel lRes = new JLabel("Result:");
    private final JTextField tPoly1 = new JTextField();
    private final JTextField tPoly2 = new JTextField();
    private final JTextField tRes = new JTextField();
    private final JButton add = new JButton("+");
    private final JButton sub = new JButton("-");
    private final JButton mul = new JButton("x");
    private final JButton div = new JButton("/");
    private final JButton ddx = new JButton("d/dx");
    private final JButton integral = new JButton("∫");
    private final JButton modulo = new JButton("%");


    public CalcPolView() {
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS)); //new BoxLayout(content, BoxLayout.Y_AXIS)
        content.setBackground(new Color(255,200,200));
        panelButtons.setBackground(new Color(255,200,200));
        panelButtons.setLayout( new GridLayout(4, 2));
        frame.setSize(new Dimension(600,600));
        panelButtons.setPreferredSize(new Dimension(600,250));

        tPoly1.setHorizontalAlignment(SwingConstants.CENTER);
        tPoly2.setHorizontalAlignment(SwingConstants.CENTER);
        tRes.setHorizontalAlignment(SwingConstants.CENTER);
        lPoly1.setHorizontalAlignment(SwingConstants.LEFT);
        lPoly2.setHorizontalAlignment(SwingConstants.LEFT);
        lRes.setHorizontalAlignment(SwingConstants.LEFT);

        add.setBackground(new Color(102,0,51));
        add.setForeground(new Color(255,200,200));
        sub.setBackground(new Color(102,0,51));
        sub.setForeground(new Color(255,200,200));
        mul.setBackground(new Color(102,0,51));
        mul.setForeground(new Color(255,200,200));
        div.setBackground(new Color(102,0,51));
        div.setForeground(new Color(255,200,200));
        ddx.setBackground(new Color(102,0,51));
        ddx.setForeground(new Color(255,200,200));
        integral.setBackground(new Color(102,0,51));
        integral.setForeground(new Color(255,200,200));
        modulo.setBackground(new Color(102,0,51));
        modulo.setForeground(new Color(255,200,200));

        panelButtons.add(add);
        panelButtons.add(sub);
        panelButtons.add(mul);
        panelButtons.add(div);
        panelButtons.add(ddx);
        panelButtons.add(integral);
        panelButtons.add(modulo);

        content.add(title);
        content.add(lPoly1);
        content.add(tPoly1);
        content.add(lPoly2);
        content.add(tPoly2);
        content.add(lRes);
        content.add(tRes);
        content.add(panelButtons);

        frame.setContentPane(content);
        frame.setVisible(true);
    }
    // metode de adaugare a actionListenerilor
    void addAddListener(ActionListener ac) {
        add.addActionListener(ac);
    }

    void addSubListener(ActionListener ac) {
        sub.addActionListener(ac);
    }

    void addMulListener(ActionListener ac) {
        mul.addActionListener(ac);
    }

    void addDivListener(ActionListener ac) {
        div.addActionListener(ac);
    }

    void addDdxListener(ActionListener ac) {
        ddx.addActionListener(ac);
    }

    void addIntegralListener(ActionListener ac) {
        integral.addActionListener(ac);
    }

    void addModuloListener(ActionListener ac) {
        modulo.addActionListener(ac);
    }

    String getPoly1() {
        return tPoly1.getText();
    }

    String getPoly2() {
        return tPoly2.getText();
    }

    void setTotal(String newTotal) {
        tRes.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(frame, errMessage);
    } // adauga un pop up cu eroare
}
