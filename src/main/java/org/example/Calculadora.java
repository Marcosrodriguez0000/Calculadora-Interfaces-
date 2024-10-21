package org.example;

import javax.swing.*;

public class Calculadora {

    private JPanel panelMain;
    private JTextField resultField;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonEquals;
    private JButton buttonClear;

    private double currentResult = 0;
    private String currentOperator = "";
    private boolean isNewOperation = true;

    public Calculadora() {
        button0.addActionListener(e -> appendNumber("0"));
        button1.addActionListener(e -> appendNumber("1"));
        button2.addActionListener(e -> appendNumber("2"));
        button3.addActionListener(e -> appendNumber("3"));
        button4.addActionListener(e -> appendNumber("4"));
        button5.addActionListener(e -> appendNumber("5"));
        button6.addActionListener(e -> appendNumber("6"));
        button7.addActionListener(e -> appendNumber("7"));
        button8.addActionListener(e -> appendNumber("8"));
        button9.addActionListener(e -> appendNumber("9"));


        buttonPlus.addActionListener(e -> setOperator("+"));
        buttonMinus.addActionListener(e -> setOperator("-"));
        buttonMultiply.addActionListener(e -> setOperator("*"));
        buttonDivide.addActionListener(e -> setOperator("/"));


        buttonEquals.addActionListener(e -> calculateResult());


        buttonClear.addActionListener(e -> clear());
    }


    private void appendNumber(String number) {
        if (isNewOperation) {
            resultField.setText(number);
            isNewOperation = false;
        } else {
            resultField.setText(resultField.getText() + number);
        }
    }


    private void setOperator(String operator) {
        currentResult = Double.parseDouble(resultField.getText());
        currentOperator = operator;
        isNewOperation = true;
    }



    private void calculateResult() {
        double secondNumber = Double.parseDouble(resultField.getText());
        switch (currentOperator) {
            case "+" -> currentResult += secondNumber;
            case "-" -> currentResult -= secondNumber;
            case "*" -> currentResult *= secondNumber;
            case "/" -> currentResult /= secondNumber;
        }
        resultField.setText(String.valueOf(currentResult));
        isNewOperation = true;
    }


    private void clear() {
        resultField.setText("");
        currentResult = 0;
        currentOperator = "";
        isNewOperation = true;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


