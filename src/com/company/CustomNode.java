package com.company;

public class CustomNode<T> {
    public T item;
    public CustomNode<T> next;

    public CustomNode(T item, CustomNode<T> next) {
        this.item = item;
        this.next = next;
    }
}
