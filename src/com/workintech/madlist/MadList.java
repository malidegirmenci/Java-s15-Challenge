package com.workintech.madlist;

import java.util.Arrays;

public class MadList<T> {

    private static final int INITIAL_CAPACITY = 1;
    private Object[] arr;
    private int size = 0;

    public MadList(){
        this.arr = new Object[INITIAL_CAPACITY];
    }
    public MadList(Object[] arr){
        this.arr = arr;
    }

    public void add(T element){
        if(size == arr.length){
            expand();
        }
        if(!contains(element)){
            arr[size++] = element;
        }
    }
    public boolean contains(T element){
        for(Object item: arr){
            if(item == element){
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    public  T get(int index){
        if(index >= size || index < 0){
            throw  new IndexOutOfBoundsException("Invalid index: "+ index);
        }
        return (T) arr[index];
    }

    private  void  expand(){
        int newCapacity = arr.length + 1;
        Object[] newArr = new Object[newCapacity];
        System.arraycopy(arr,0,newArr,0, size);
        arr = newArr;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void clear(){
        arr = new Object[INITIAL_CAPACITY];
        size=0;
    }

    public int indexOf(T element){
        for(int i = 0; i < arr.length; i++){
            if(element == arr[i]){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("[");
        int count = 0;
        for (Object item : arr) {
            if (item != null) {
                if (item instanceof Object[]) {
                    msg.append(Arrays.toString((Object[]) item));
                } else {
                    msg.append(item);
                }
                count++;
                if (count < arr.length && arr[count] != null) {
                    msg.append(", ");
                }
            }
        }
        msg.append("]");
        return msg.toString();
    }
}
