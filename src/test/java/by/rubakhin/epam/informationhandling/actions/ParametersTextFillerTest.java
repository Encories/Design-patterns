package by.rubakhin.epam.informationhandling.actions;

import by.rubakhin.epam.informationhandling.ConstantTestValues;
import by.rubakhin.epam.informationhandling.creator.RegularExpression;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class ParametersTextFillerTest {
    private ParametersTextFiller parametersTextFiller = new ParametersTextFiller();

    @Test
    public void testFillTextByParametersIsFindAll() throws Exception {
        String resultText = parametersTextFiller.textByParameters(ConstantTestValues.TEST_TEXT,
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J
        );
        Scanner parametersScanner = new Scanner(resultText);
        String founded = parametersScanner.findInLine(RegularExpression.REGEX_IANDJ);

        Assert.assertEquals(founded, null);
    }

    @Test
    public void testFillTextByParametersIsCorrect() throws Exception {
        String resultText = parametersTextFiller.textByParameters(ConstantTestValues.TEST_TEXT,
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, ConstantTestValues.RIGHT_RESULT_TEXT_WITH_PARAMETERS);
    }

    @Test
    public void testFillTextByParametersIsCorrectSmall() throws Exception {
        String resultText = parametersTextFiller.textByParameters("++i",
                ConstantTestValues.TEST_I,
                ConstantTestValues.TEST_J);

        Assert.assertEquals(resultText, "6\n");
    }
}
