package calculator;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class CalcPanel extends JPanel implements ActionListener {

  String num1 = "";
  String num2 = "";
  String operator = "";
  boolean usingFirst = true;
  double total = 0;

  JTextField display;
  JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdec;
  JButton bclear, bequals, bplus, bsubtract, bmultiply;

  public CalcPanel() {
    this.setBackground(Color.white);
    setLayout(null);
    display = new JTextField();

    b1 = new JButton("1");
    b2 = new JButton("2");
    b3 = new JButton("3");
    b4 = new JButton("4");
    b5 = new JButton("5");
    b6 = new JButton("6");
    b7 = new JButton("7");
    b8 = new JButton("8");
    b9 = new JButton("9");
    b0 = new JButton("0");
    bdec = new JButton(".");
    bclear = new JButton("C");
    bequals = new JButton("=");
    bplus = new JButton("+");
    bsubtract = new JButton("-");
    bmultiply = new JButton("*");

    display.setBounds(0, 0, 205, 50);

    int width = 50;
    int height = 50;

    b1.setBounds(0, 200, width, height);
    b2.setBounds(50, 200, width, height);
    b3.setBounds(100, 200, width, height);
    bplus.setBounds(154, 200, width, height);

    b4.setBounds(0, 150, width, height);
    b5.setBounds(50, 150, width, height);
    b6.setBounds(100, 150, width, height);
    bsubtract.setBounds(154, 150, width, height);

    b7.setBounds(0, 100, width, height);
    b8.setBounds(50, 100, width, height);
    b9.setBounds(100, 100, width, height);
    bmultiply.setBounds(154, 100, width, height);

    b0.setBounds(0, 250, width, height);
    bdec.setBounds(50, 250, width, height);
    bclear.setBounds(100, 250, width, height);
    bequals.setBounds(154, 250, width, height);

    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
    add(b7);
    add(b8);
    add(b9);
    add(b0);
    add(bdec);
    add(display);
    add(bclear);
    add(bequals);
    add(bplus);
    add(bsubtract);
    add(bmultiply);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
    b6.addActionListener(this);
    b7.addActionListener(this);
    b8.addActionListener(this);
    b9.addActionListener(this);
    b0.addActionListener(this);
    bequals.addActionListener(this);
    bplus.addActionListener(this);
    bclear.addActionListener(this);
    bdec.addActionListener(this);
    bsubtract.addActionListener(this);
    bmultiply.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String s = e.getActionCommand();
    if (
      s.equals("1") ||
      s.equals("2") ||
      s.equals("3") ||
      s.equals("4") ||
      s.equals("5") ||
      s.equals("6") ||
      s.equals("7") ||
      s.equals("8") ||
      s.equals("9") ||
      s.equals("0") ||
      s.equals(".")
    ) {
      if (usingFirst) {
        num1 = num1 + s;
      } else {
        num2 = num2 + s;
      }

      display.setText(display.getText() + s);
    } else if (s.equals("+") || s.equals("-") || s.equals("*")) {
      if (s.equals("+")) {
        usingFirst = false;
        operator = "+";
      } else if (s.equals("-")) {
        usingFirst = false;
        operator = "-";
      } else if (s.equals("*")) {
        usingFirst = false;
        operator = "*";
      }
      display.setText(num1 + operator);
    } else if (s.equals("=")) {
      switch (operator) {
        case "+":
          total = Double.parseDouble(num1) + Double.parseDouble(num2);
          display.setText("" + total);
          break;
        case "-":
          total = Double.parseDouble(num1) - Double.parseDouble(num2);
          display.setText("" + total);
          break;
        case "*":
          total = Double.parseDouble(num1) * Double.parseDouble(num2);
          display.setText("" + total);
          break;
      }

      usingFirst = true;
      num1 = String.valueOf(total);
      num2 = "";
      operator = "";
    } else if (s.equals("C")) {
      display.setText("");
      usingFirst = true;
      num1 = "";
      num2 = "";
      total = 0;
    }
  }
}
