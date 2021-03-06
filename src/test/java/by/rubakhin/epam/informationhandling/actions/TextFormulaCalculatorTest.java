package by.rubakhin.epam.informationhandling.actions;

import by.rubakhin.epam.informationhandling.ConstantTestValues;
import by.rubakhin.epam.informationhandling.creator.RegularExpression;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class TextFormulaCalculatorTest {
    private TextFormulaCalculator textFormulaCalculator = new TextFormulaCalculator();

    @Test
    public void testCalculateTextFormulasIsFindAll() throws Exception {
        String resultText = textFormulaCalculator.calculateTextFormulas(ConstantTestValues.TEST_TEXT, 5, 12);
        Scanner parametersScanner = new Scanner(resultText);
        String founded = parametersScanner.findInLine(RegularExpression.REGEX_MATH_EXPRESSIONS);

        Assert.assertEquals(founded, null);
    }

    @Test
    public void testCalculateTextFormulasIsCorrectAllText() throws Exception {
        String resultText = textFormulaCalculator.calculateTextFormulas(ConstantTestValues.TEST_TEXT,
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, ConstantTestValues.RIGHT_RESULT_TEXT);
    }

    @Test
    public void testCalculateTextFormulasIsCorrectAddition() throws Exception {
        String resultText = textFormulaCalculator.calculateTextFormulas("14+12",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, "26\n");
    }

    @Test
    public void testCalculateTextFormulasIsCorrectSubtraction() throws Exception {
        String resultText = textFormulaCalculator.calculateTextFormulas("14-16",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, "2\n");
    }

    @Test
    public void testCalculateTextFormulasIsCorrectMultiplication() throws Exception {
        String resultText = textFormulaCalculator.calculateTextFormulas("14*16",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, "224\n");
    }

    @Test
    public void testCalculateTextFormulasIsCorrectDivision() throws Exception {
        String resultText = textFormulaCalculator.calculateTextFormulas("5/4",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, "0\n");
    }

}
