import javax.swing.*;
import java.awt.*;

/**
 * Created by vladislav on 30.04.14.
 */
public class View extends JFrame {

    public static void main(String[] args) {
        new View();
    }

    public View(){
        setBounds(300,300,360, 420);
        setLayout(new BorderLayout());
        initFrame();
        setVisible(true);
    }

    private void initFrame(){
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(buttonEval, BorderLayout.SOUTH);
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
    }

    private JTextArea display = new JTextArea();

    private JPanel buttonPanel = new JPanel(new GridLayout(5,3));

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

    private JButton buttonEval = new JButton("=");
}
