package by.rubakhin.epam.informationhandling.entity.component;

public interface Component {

    void add(Component c);

    void remove(Component c);

    Object getChild(int index);

    int getComponentsSize ();
}
