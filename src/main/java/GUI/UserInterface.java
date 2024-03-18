package GUI;

import Logic.ConvertPolynomial;
import Logic.Operations;
import Model.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.OperatingSystemMXBean;


public class UserInterface extends JFrame {
    private JLabel polLabel1;
    private JTextField polTextField1;
    private JLabel polLabel2;
    private JTextField polTextField2;
    private JLabel resultLabel;
    private JLabel resultLabel2;
    private JTextArea resultTextArea;
    private JTextArea resultTextArea2;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton derButton;
    private JButton intgButton;

    public UserInterface()
    {
        setTitle("Calculator");
        setSize(400, 500);
        polLabel1 = new JLabel("First polynomial:         ");
        polTextField1 = new JTextField(20);
        polLabel2 = new JLabel("Second polynomial:    ");
        polTextField2 = new JTextField(20);
        resultLabel = new JLabel("     Result:                          ");
        resultLabel2 = new JLabel("     Result:                          ");
        resultTextArea = new JTextArea("                                                        ");
        resultTextArea2 = new JTextArea("                                                        ");
        Dimension dimensiuniButon = new Dimension(150, 50);
        addButton = new JButton("Add");
        addButton.setPreferredSize(dimensiuniButon);
        subButton = new JButton("Subtract");
        subButton.setPreferredSize(dimensiuniButon);
        mulButton = new JButton("Multiply");
        mulButton.setPreferredSize(dimensiuniButon);
        divButton = new JButton("Divide");
        divButton.setPreferredSize(dimensiuniButon);
        derButton = new JButton("Differentiate");
        derButton.setPreferredSize(dimensiuniButon);
        intgButton = new JButton("Integrate");
        intgButton.setPreferredSize(dimensiuniButon);

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
        panel7.add(resultLabel2);
        panel7.add(resultTextArea2);
        JPanel panel3 = new JPanel();
        panel3.add(addButton);
        panel3.add(subButton);
        JPanel panel4 = new JPanel();
        panel4.add(mulButton);
        panel4.add(divButton);
        JPanel panel5 = new JPanel();
        panel5.add(derButton);
        panel5.add(intgButton);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel6);
        panel.add(panel7);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);


        panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultLabel2.setVisible(false);
        resultTextArea2.setVisible(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel2.setVisible(false);
                resultTextArea2.setVisible(false);

                String p1 = polTextField1.getText();
                String p2 = polTextField2.getText();
                Polynomial pol1 = ConvertPolynomial.parsePolynomial(p1);
                Polynomial pol2 = ConvertPolynomial.parsePolynomial(p2);

                if(pol1.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else if(pol2.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else
                    resultTextArea.setText((Operations.addition(pol1, pol2)).toString());

            }
        });

        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel2.setVisible(false);
                resultTextArea2.setVisible(false);

                String p1 = polTextField1.getText();
                String p2 = polTextField2.getText();
                Polynomial pol1 = ConvertPolynomial.parsePolynomial(p1);
                Polynomial pol2 = ConvertPolynomial.parsePolynomial(p2);

                if(pol1.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else if(pol2.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else
                    resultTextArea.setText((Operations.subtraction(pol1, pol2)).toString());
            }
        });

        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel2.setVisible(false);
                resultTextArea2.setVisible(false);

                String p1 = polTextField1.getText();
                String p2 = polTextField2.getText();
                Polynomial pol1 = ConvertPolynomial.parsePolynomial(p1);
                Polynomial pol2 = ConvertPolynomial.parsePolynomial(p2);

                if(pol1.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else if(pol2.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else
                    resultTextArea.setText((Operations.multiplication(pol1, pol2)).toString());
            }
        });

        divButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultTextArea.setVisible(true);
                resultLabel2.setText("     Remainder:                  ");
                resultLabel2.setVisible(true);
                resultTextArea2.setVisible(true);

                String p1 = polTextField1.getText();
                String p2 = polTextField2.getText();
                Polynomial pol1 = ConvertPolynomial.parsePolynomial(p1);
                Polynomial pol2 = ConvertPolynomial.parsePolynomial(p2);

                if(pol1.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else if(pol2.getPolynomial().firstEntry() == null)
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);
                else {
                    resultTextArea.setText((Operations.division(pol1, pol2)[0]).toString());
                    resultTextArea2.setText((Operations.division(pol1, pol2)[1]).toString());
                }
            }
        });

        derButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setVisible(false);
                resultTextArea.setVisible(false);
                resultLabel2.setVisible(false);
                resultTextArea2.setVisible(false);
                resultLabel2.setText("     Result:                          ");

                if(polTextField1.getText().isEmpty() && polTextField2.getText().isEmpty())
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);

                if(!polTextField1.getText().isEmpty()){
                    resultLabel.setVisible(true);
                    resultTextArea.setVisible(true);

                    String p1 = polTextField1.getText();
                    Polynomial pol1 = ConvertPolynomial.parsePolynomial(p1);
                    if(pol1.getPolynomial().firstEntry() == null)
                        JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);

                    resultTextArea.setText((Operations.differentiation(pol1)).toString());
                }

                if(!polTextField2.getText().isEmpty()){
                    resultLabel2.setVisible(true);
                    resultTextArea2.setVisible(true);

                    String p2 = polTextField2.getText();
                    Polynomial pol2 = ConvertPolynomial.parsePolynomial(p2);
                    if(pol2.getPolynomial().firstEntry() == null)
                        JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);

                    resultTextArea2.setText((Operations.differentiation(pol2)).toString());
                }

            }
        });

        intgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultLabel.setVisible(false);
                resultTextArea.setVisible(false);
                resultLabel2.setVisible(false);
                resultTextArea2.setVisible(false);
                resultLabel2.setText("     Result:                          ");

                if(polTextField1.getText().isEmpty() && polTextField2.getText().isEmpty())
                    JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);

                if(!polTextField1.getText().isEmpty()){
                    resultLabel.setVisible(true);
                    resultTextArea.setVisible(true);

                    String p1 = polTextField1.getText();
                    Polynomial pol1 = ConvertPolynomial.parsePolynomial(p1);
                    if(pol1.getPolynomial().firstEntry() == null)
                        JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);

                    resultTextArea.setText((Operations.integration(pol1)).toString());
                }

                if(!polTextField2.getText().isEmpty()){
                    resultLabel2.setVisible(true);
                    resultTextArea2.setVisible(true);

                    String p2 = polTextField2.getText();
                    Polynomial pol2 = ConvertPolynomial.parsePolynomial(p2);
                    if(pol2.getPolynomial().firstEntry() == null)
                        JOptionPane.showMessageDialog(new UserInterface(), "Invalid Polynomial", "Error", JOptionPane.ERROR_MESSAGE);

                    resultTextArea2.setText((Operations.integration(pol2)).toString());
                }

            }
        });

    }
        public static void main(String[] args) {
            new UserInterface().setVisible(true);
    }
}