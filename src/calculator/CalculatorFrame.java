package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame implements ActionListener {

    private final StringBuilder sb = new StringBuilder();

    private TopFrame topFrame;

    public CalculatorFrame() {
        setTitle("MyCalculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 500);

        setLayout(new BorderLayout());

        topFrame = new TopFrame();
        add(topFrame.getPanel(), BorderLayout.NORTH);

        DigitButtonListener digitButtonListener = new DigitButtonListener(topFrame);

        BottomFrame bottomFrame = new BottomFrame(digitButtonListener, this);
        add(bottomFrame.getPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton button = (JButton) actionEvent.getSource();
        if (button.getText().equals("C")) {
            topFrame.reset();
        } else {
            String exp = topFrame.prepareAndGetExpression();

            //Выполняем операции по приоритетам
            //Каждый раз возвращается промежуточный результат

            exp = toSqrt(exp);

            if (exp.contains("*") || exp.contains("/")) {
                exp = calculateExpression(exp, "[*/]");
            }
            if (exp.contains("-") || exp.contains("+")) {
                exp = calculateExpression(exp, "[+-]");
            }
            //Убирем лишние нули с точнкой, если их можно отбросить
            exp = exp.replaceAll("\\.0*$", "");
            topFrame.setResult(exp);
        }
    }

    //Вычисляет корень на всех числах с буковой s (s9, s124)
    private String toSqrt(String exp){
        sb.setLength(0);
        ExpressionParser expressionParser = new ExpressionParser();
        expressionParser.setExp(exp);

        while (expressionParser.hasNext()) {
            String s = expressionParser.getNext();
            if (s.contains("s")) {
                s = s.replaceAll("s", "");
                sb.append(Math.sqrt(Double.parseDouble(s)));
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    //Получаем все аргументы выражения и выполняем только те операции, которые необходимо
    private String calculateExpression(String exp, String operators) {
        sb.setLength(0);
        ExpressionParser expressionParser = new ExpressionParser();
        expressionParser.setExp(exp);

        String arg1 = "";

        //Первый берём аргумент
        if (expressionParser.hasNext()) {
            arg1 = expressionParser.getNext();
        }
        while (expressionParser.hasNext()) {
            // Следующий аргумент (это точно оператор)
            String n = expressionParser.getNext();
            if (expressionParser.stringIsOperator(n)) {
                //Следующий аргумент (это точно цифра)
                String n2 = expressionParser.getNext();

                //Если оператор подходит, вычисляем выражение
                if (n.matches(operators)) {
                    arg1 = String.valueOf(calculate(arg1, n2, n));
                } else {
                    //Если нет, то пишем первый операнд и оператор в результат и переключаемся на следующий
                    sb.append(arg1);
                    sb.append(n);
                    arg1 = n2;
                }
                //Если дальше арументов не будет, то пишем всё в результат
                if (!expressionParser.hasNext()) {
                    sb.append(arg1);
                }
            }
        }
       return sb.toString();
    }

    public double calculate(String arg1, String arg2, String operator){
        double a1 = Double.parseDouble(arg1);
        double a2 = Double.parseDouble(arg2);
        switch (operator){
            case "+": return a1 + a2;
            case "-": return a1 - a2;
            case "/": return a1 / a2;
            case "*": return a1 * a2;
            default: return a1;
        }
    }


}
