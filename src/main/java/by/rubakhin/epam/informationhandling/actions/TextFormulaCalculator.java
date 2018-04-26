package by.rubakhin.epam.informationhandling.actions;

import by.rubakhin.epam.informationhandling.calculator.PolishFormConverter;
import by.rubakhin.epam.informationhandling.calculator.counter.Client;
import by.rubakhin.epam.informationhandling.creator.RegularExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFormulaCalculator {

    private final static Logger LOG = LogManager.getLogger("ParametersTextFiller");

    public String calculateTextFormulas(String text, int i, int j){

        ParametersTextFiller parametersFiller = new ParametersTextFiller();
        String result = parametersFiller.textByParameters(text, i, j);
        Matcher matcher = Pattern
                .compile(RegularExpression.REGEX_MATH_EXPRESSIONS)
                .matcher(result);

        String foundExpression = "";
        String polishFormExpression = "";
        String answer = "";

        while(matcher.find()){
            foundExpression = matcher.group();
            LOG.info("Math expression founded " + foundExpression);

            polishFormExpression = PolishFormConverter.sortingStation(foundExpression,
                    PolishFormConverter.MAIN_MATH_OPERATIONS);
            LOG.info("Math expression converted to polish form " + foundExpression);

            Client interpreter = new Client(polishFormExpression);
            answer = interpreter.calculate().toString();
            LOG.info("Math expression was calculated " + answer);

            result = result.replace(foundExpression, answer);
        }
        return result;
    }
}
