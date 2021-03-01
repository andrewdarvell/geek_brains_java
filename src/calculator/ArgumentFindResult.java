package calculator;

public class ArgumentFindResult {

    private String argument;
    private int stopPosition;
    private char lastOperator;

    public ArgumentFindResult(String argument, int stopPosition) {
        this.argument = argument;
        this.stopPosition = stopPosition;
    }

    public String getArgument() {
        return argument;
    }

    public int getStopPosition() {
        return stopPosition;
    }
}
