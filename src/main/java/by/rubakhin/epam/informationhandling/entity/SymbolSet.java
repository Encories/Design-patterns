package by.rubakhin.epam.informationhandling.entity;

import by.rubakhin.epam.informationhandling.entity.component.Component;

import java.util.ArrayList;
import java.util.List;

public class SymbolSet implements Component {
    private List<Component> components = new ArrayList<>();

    public int getComponentsSize (){
        return components.size();
    }

    public void add(Component component) {
        components.add(component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Object getChild(int index) {
        return components.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SymbolSet symbolSet = (SymbolSet) o;

        return components != null ? components.equals(symbolSet.components) : symbolSet.components == null;
    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }

    @Override
    public String toString() {
        String result = " ";
        for (int i = 0; i < components.size(); i++){
            result += components.get(i);
        }
        return result;
    }
}
