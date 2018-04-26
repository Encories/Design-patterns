package by.rubakhin.epam.informationhandling.creator;

import by.rubakhin.epam.informationhandling.entity.SymbolSet;
import by.rubakhin.epam.informationhandling.entity.component.Component;
import by.rubakhin.epam.informationhandling.creator.handler.HandlerInterface;

public class TextHandler implements HandlerInterface {

    private String text;
    private HandlerInterface successor;
    public TextHandler(HandlerInterface successor, String text) {
        this.text = text;
        this.successor = successor;
    }

    @Override
    public Component chain(Component result, String text) {
        SymbolSet core = new SymbolSet();
        core = (SymbolSet) successor.chain(core, text);
        return core;
    }

}
