package by.rubakhin.epam.informationhandling.creator;

import by.rubakhin.epam.informationhandling.entity.Symbol;
import by.rubakhin.epam.informationhandling.entity.component.Component;
import by.rubakhin.epam.informationhandling.creator.handler.HandlerInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolHandler implements HandlerInterface {

    @Override
    public Component chain(Component result, String text) {
        Matcher matcher = Pattern.compile(RegularExpression.REGEX_SYMBOL).matcher(text);
        String symbol;

        while(matcher.find()){
            symbol = matcher.group();
            result.add(new Symbol(symbol));
        }
        return result;
    }
}
