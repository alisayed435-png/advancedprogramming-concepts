package de.thro.inf.prg3.a04.collections;


import java.util.Iterator;

public class SimpleListImpl implements SimpleList {

    private ListElement head;

    private int size;

    public SimpleListImpl() {
        head = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object item) {
        if (head == null) {
            head = new ListElement(item);
        } else {
            ListElement current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new ListElement(item));
        }
        size++;
    }

    @Override
    public Iterator iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator {

        private ListElement current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }
    }

    private static class ListElement {

        Object item;

        private ListElement next;

        public ListElement(Object item) {
            this.item = item;
            this.next = null;
        }

        public Object getItem() {
            return item;
        }

        public void setItem(Object item) {
            this.item = item;
        }

        public ListElement getNext() {
            return next;
        }

        public void setNext(ListElement next) {
            this.next = next;
        }
    }
}

