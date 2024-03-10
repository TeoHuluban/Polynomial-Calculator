package GUI;

import javax.swing.*;
import java.awt.*;

public class UserInterface extends JFrame {
    private JLabel polLabel1;
    private JTextField polTextField1;
    private JLabel polLabel2;
    private JTextField polTextField2;
    private JLabel resultLabel;
    private JTextArea resultTextArea;
    private JTextArea resultTextArea2;
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private JButton der;
    private JButton intg;

    public UserInterface()
    {
        setTitle("Calculator");
        setSize(400, 500);
        polLabel1 = new JLabel("First polynomial         ");
        polTextField1 = new JTextField(20);
        polLabel2 = new JLabel("Second polynomial    ");
        polTextField2 = new JTextField(20);
        resultLabel = new JLabel("Result");
        resultTextArea = new JTextArea("                                                        ");
        resultTextArea2 = new JTextArea("                                                        ");
        Dimension dimensiuniButon = new Dimension(150, 50);
        add = new JButton("Add");
        add.setPreferredSize(dimensiuniButon);
        sub = new JButton("Subtract");
        sub.setPreferredSize(dimensiuniButon);
        mul = new JButton("Multiply");
        mul.setPreferredSize(dimensiuniButon);
        div = new JButton("Divide");
        div.setPreferredSize(dimensiuniButon);
        der = new JButton("Derive");
        der.setPreferredSize(dimensiuniButon);
        intg = new JButton("Integrate");
        intg.setPreferredSize(dimensiuniButon);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);

        JPanel panel1 = new JPanel();
        panel1.add(polLabel1);
        panel1.add(polTextField1);
        JPanel panel2 = new JPanel();
        panel2.add(polLabel2);
        panel2.add(polTextField2);
        JPanel panel6 = new JPanel();
        panel6.add(resultLabel);
        panel6.add(resultTextArea);
        JPanel panel7 = new JPanel();
        panel7.add(resultTextArea2);
        JPanel panel3 = new JPanel();
        panel3.add(add);
        panel3.add(sub);
        JPanel panel4 = new JPanel();
        panel4.add(mul);
        panel4.add(div);
        JPanel panel5 = new JPanel();
        panel5.add(der);
        panel5.add(intg);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel6);
        panel.add(panel7);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);

    }

    public static void main(String[] args) {
        new UserInterface().setVisible(true);
    }
}
