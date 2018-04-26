package by.rubakhin.epam.informationhandling.calculator.counter;

public class TerminalExpressionMinus extends AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        c.pushValue(c.popValue() - c.popValue());
    }
}
