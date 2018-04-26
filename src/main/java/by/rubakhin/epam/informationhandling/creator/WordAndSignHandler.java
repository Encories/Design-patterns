package by.rubakhin.epam.informationhandling.creator;

import by.rubakhin.epam.informationhandling.entity.SymbolSet;
import by.rubakhin.epam.informationhandling.entity.component.Component;
import by.rubakhin.epam.informationhandling.creator.handler.HandlerInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndSignHandler implements HandlerInterface {
    private HandlerInterface successor;

    public WordAndSignHandler(HandlerInterface successor) {
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {

        Matcher matcher = Pattern.compile(RegularExpression.REGEX_WORD).matcher(text);
        SymbolSet word;
        String wordText;

        while(matcher.find()){
            wordText = matcher.group();
            word = new SymbolSet();
            result.add(successor.chain(word, wordText));
        }
        return result;
    }
}
