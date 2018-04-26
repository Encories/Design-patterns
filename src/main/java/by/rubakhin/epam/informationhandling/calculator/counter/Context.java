package by.rubakhin.epam.informationhandling.calculator.counter;

import java.util.ArrayDeque;

public class Context {
    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue(Integer value) {
        this.contextValues.push(value);
    }
}
