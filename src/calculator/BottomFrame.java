package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BottomFrame {

    private final JPanel panel;

    public BottomFrame(DigitButtonListener digitButtonListener, ActionListener globalActionListener) {

        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3));


        for (int i = 0; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButtonListener);
            panel.add(btn);
        }


        panel.add(genButton("-", digitButtonListener));
        panel.add(genButton("+", digitButtonListener));
        panel.add(genButton("/", digitButtonListener));
        panel.add(genButton("*", digitButtonListener));
        panel.add(genButton(".", digitButtonListener));
        panel.add(genButton("SQRT", digitButtonListener));

        panel.add(genButton("C", globalActionListener));
        panel.add(genButton("=", globalActionListener));
    }

    public JPanel getPanel() {
        return panel;
    }

    private JButton genButton(String text, ActionListener listener) {
        JButton btn = new JButton(text);
        btn.addActionListener(listener);
        return btn;
    }
}
