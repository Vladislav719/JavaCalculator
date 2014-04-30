import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

/**
 * Created by vladislav on 30.04.14.
 */
public class View extends JFrame {

    private java.util.Timer timer = new Timer();

    private String memExp = "";

    private Calc calc = new Calc();

    public static void main(String[] args) {
        new View();
    }

    public View() {
        setBounds(300, 300, 360, 420);
        setLayout(new BorderLayout());
        initFrame();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        timer.schedule(new Inform(this,timer),0,3000);
    }

    @Deprecated //will be implemented in latest versions @see https://github.com/Vladislav719/JavaCalculator/
    public void showMsg(){
        JOptionPane.showMessageDialog(this,"To show extra menu, please press following shortcut \"Ctrl\" + \"R\" ");
    }

    private void initFrame() {
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(buttonExp, BorderLayout.EAST);
        buttonPanel.add(button0);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);
        buttonPanel.add(buttonSum);
        buttonPanel.add(buttonSub);
        buttonPanel.add(buttonMul);
        buttonPanel.add(buttonDel);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonOpenBracket);
        buttonPanel.add(buttonCloseBracket);
        buttonPanel.add(buttonExp);
        buttonPanel.add(buttonMem);
        buttonPanel.add(buttonMemRec);
        buttonPanel.add(buttonMemDel);
//        display.setEnabled(false);
        initListener();
    }

    private JTextArea display = new JTextArea();

    private JPanel buttonPanel = new JPanel(new GridLayout(7, 3));

    private JButton button0 = new JButton("0");

    private JButton button1 = new JButton("1");

    private JButton button2 = new JButton("2");

    private JButton button3 = new JButton("3");

    private JButton button4 = new JButton("4");

    private JButton button5 = new JButton("5");

    private JButton button6 = new JButton("6");

    private JButton button7 = new JButton("7");

    private JButton button8 = new JButton("8");

    private JButton button9 = new JButton("9");

    private JButton buttonSum = new JButton("+");

    private JButton buttonDel = new JButton("←");

    private JButton buttonDivide = new JButton("/");

    private JButton buttonSub = new JButton("-");

    private JButton buttonMul = new JButton("*");

    private JButton buttonExp = new JButton("=");

    private JButton buttonOpenBracket = new JButton("(");

    private JButton buttonCloseBracket = new JButton(")");

    private JButton buttonMem = new JButton("M+");//add to memory

    private JButton buttonMemDel = new JButton("M-");//remove from memory

    private JButton buttonMemRec = new JButton("MR");//memory recall

    private void initListener() {
        button0.addActionListener(e -> display.setText(display.getText() + "0"));
        button1.addActionListener(e -> display.setText(display.getText() + "1"));
        button2.addActionListener(e -> display.setText(display.getText() + "2"));
        button3.addActionListener(e -> display.setText(display.getText() + "3"));
        button4.addActionListener(e -> display.setText(display.getText() + "4"));
        button5.addActionListener(e -> display.setText(display.getText() + "5"));
        button6.addActionListener(e -> display.setText(display.getText() + "6"));
        button7.addActionListener(e -> display.setText(display.getText() + "7"));
        button8.addActionListener(e -> display.setText(display.getText() + "8"));
        button9.addActionListener(e -> display.setText(display.getText() + "9"));
        buttonSum.addActionListener(e -> display.setText(display.getText() + "+"));
        buttonDel.addActionListener(e -> display.setText(display.getText().substring(0, display.getText().length() - 1)));
        buttonDivide.addActionListener(e -> display.setText(display.getText() + "/"));
        buttonSub.addActionListener(e -> display.setText(display.getText() + "-"));
        buttonMul.addActionListener(e -> display.setText(display.getText() + "*"));
        buttonOpenBracket.addActionListener(e -> display.setText(display.getText() + "("));
        buttonCloseBracket.addActionListener(e -> display.setText(display.getText() + ")"));
        buttonMemDel.addActionListener(e -> memExp = "");

        buttonMemDel.addActionListener(e -> this.memExp = "");

        buttonMem.addActionListener(e -> {
            String exp = display.getText();
            if (!exp.matches("^[0-9\\/\\*\\+\\-\\(\\)]*$")) {
                JOptionPane.showMessageDialog(this, "Is not permitted in this scope", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (exp.charAt(exp.length() - 1) == '+' || exp.charAt(exp.length() - 1) == '-'
                        || exp.charAt(exp.length() - 1) == '/' || exp.charAt(exp.length() - 1) == '*') {
                    exp = exp.substring(0, exp.length() - 1);
                }
                int res = calc.express(exp);
                memExp = "" + res;
//                Timer timer = new Timer(500, ex -> display.setBackground(Color.GREEN));
            }
        });

//        System.out.println("123".substring(0,"123".length()-1));

        buttonMemRec.addActionListener(e -> {
            if (memExp != "") {
                Integer getMem = Integer.parseInt(memExp);
                String temp = display.getText().trim();
                if (getMem >= 0) {
                    if (temp.charAt(temp.length() - 1) == '+' || temp.charAt(temp.length() - 1) == '-'
                            || temp.charAt(temp.length() - 1) == '/' || temp.charAt(temp.length() - 1) == '*') {
                        display.setText(display.getText() + getMem);
                    } else {
                        display.setText(display.getText() + "+" + getMem);
                    }
                } else {
                    if (temp.charAt(temp.length() - 1) == '+' || temp.charAt(temp.length() - 1) == '-'
                            || temp.charAt(temp.length() - 1) == '/' || temp.charAt(temp.length() - 1) == '*') {
                        display.setText(display.getText() + "(" + getMem + ")");
                    } else {
                        display.setText(display.getText() + getMem);
                    }

                }
            } else ;
        });

        buttonExp.addActionListener(e -> {
            String exp = display.getText();
            if (!exp.matches("^[0-9\\/\\*\\+\\-\\(\\)]*$")) {
//                System.out.println(true);
                JOptionPane.showMessageDialog(this, "Typing error", "Error", JOptionPane.ERROR_MESSAGE);
                display.setText("");
            } else {
//                System.out.println(false);
                int res = calc.express(exp);
                display.setText(res + "");
            }
        });
    }
}
