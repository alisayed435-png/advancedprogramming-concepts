package de.thro.inf.prg3.a04.collections;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SimpleList extends Iterable {

    int size();

    void add(Object item);


    Object get(int index);

    void set(int index,Object item);

    SimpleList filter(Predicate predicate);
}

