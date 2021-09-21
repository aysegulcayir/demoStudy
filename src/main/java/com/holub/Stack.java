package com.holub;
import java.util.*;

interface Stack<T> {
    void push(T item);
    T pop();
    void pushMany(T[] item);
    int size();

}
class SimpleStack<T> implements Stack<T>{
    T[] contents = (T[]) new Object[1000];
private int stackPointer = 0 ;

    @Override
    public void push(T item) {
        assert  stackPointer< contents.length : "push to fill stack";
        contents[stackPointer++] = item;

    }

    public T pop(){
        assert  stackPointer>0 : "pop from empty stack";
        return contents[--stackPointer];
    }

    public void pushMany(T[] items){
        assert  (stackPointer+ items.length)<=contents.length: "too many items";
        System.arraycopy(items,0,contents,stackPointer,items.length);
        stackPointer+=items.length;
    }
    public int size(){return stackPointer;}


    public static void main(String[] args) {
        MonitorableStack<String> myStack = new MonitorableStack<String>();
        myStack.pushMany(new String[]{"abc","def"});
        assert myStack.maximumSizeSoFar()==2:
                "Unexpected max Size: " +myStack.maximumSizeSoFar();
    }
}
class MonitorableStack<T> implements Stack<T>{
    private int highWaterMark = 0;

public int maximumSizeSoFar(){
    return highWaterMark;
}
    @Override
    public void push(T item) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public void pushMany(T[] item) {

    }

    @Override
    public int size() {
        return 0;
    }
}
