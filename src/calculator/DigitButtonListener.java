package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {

    private final TopFrame topFrame;

    public DigitButtonListener(TopFrame topFrame){
        this.topFrame = topFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        topFrame.addButton(button.getText().equals("SQRT") ? "s" : button.getText());
    }
}
