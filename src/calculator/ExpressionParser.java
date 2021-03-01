package calculator;

public class ExpressionParser {

    private final char[] operatorChars = new char[]{'+', '-', '/', '*'};

    private char[] expRaw;
    private int currInd;

    private final StringBuilder sb = new StringBuilder();

    public void setExp(String exp) {
        this.expRaw = exp.toCharArray();
        currInd = 0;
    }

    //Получаем следующий оператор или операнд
    public String getNext(){
        sb.setLength(0);

        if (charIsOperator(expRaw[currInd])) {
            return String.valueOf(expRaw[currInd++]);
        }

        while (currInd < expRaw.length && !charIsOperator(expRaw[currInd])) {
            sb.append(expRaw[currInd]);
            currInd++;
        }
        return sb.toString();
    }

    public boolean hasNext() {
        return currInd < expRaw.length;
    }


    public boolean charIsOperator(char c) {
        for (int i = 0; i < operatorChars.length; i++) {
            if (c == operatorChars[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean stringIsOperator(String s) {
        return s.length() == 1 && charIsOperator(s.charAt(0));
    }
}
