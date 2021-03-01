package calculator;

import javax.swing.*;
import java.awt.*;

public class TopFrame {

    private final JPanel panel;
    private final JTextField inputField;

    private boolean isLastDigit = false;
    private boolean lastSqrt = false;

    public TopFrame() {

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        inputField = new JTextField();
        inputField.setEditable(false);
        panel.add(inputField, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    //Сразу вводим пример в текстовое поле правильно
    //Нельзя дублировать операторы (типа 2 +++ 3 )
    //Корень обозначен - 's', только перед цифрой
    public void addButton(String text) {
        if (text.matches("[-+/*s]")) {
            if (text.equals("s")) {
                if (!isLastDigit && !lastSqrt) {
                    addSymbol(text);
                    isLastDigit = false;
                    lastSqrt = true;
                }
            } else {
                if (isLastDigit) {
                    addSymbol(text);
                    isLastDigit = false;
                }
            }
        } else {
            addSymbol(text);
            isLastDigit = true;
            lastSqrt = false;
        }
    }

    private void addSymbol(String text) {
        inputField.setText(inputField.getText() + text);
    }

    public void setResult(String result) {
        inputField.setText(result);
        lastSqrt = false;
        isLastDigit = true;
    }

    public void reset() {
        isLastDigit = false;
        lastSqrt = false;
        inputField.setText("");
    }

    //Подготавливаем выражение к вычислению, убираем мусор в конце.
    public String prepareAndGetExpression() {
        String exp = inputField.getText();
        inputField.setText(exp.replaceAll("[-+/*s]+$", ""));
        return inputField.getText();
    }
}
