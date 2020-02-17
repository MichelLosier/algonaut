package com.michellosier.algonaut.sort;

public abstract class Sort {
    private Comparable[] items;
    private Comparable[] sortedItems;

    Sort(Comparable[] items){
        this.items = items;
    }

    public Comparable[] getItems(){
        return items;
    }

    public void setItems(Comparable[] items){
        this.items = items;
    }

    public Comparable[] getSortedItems(){
        return this.sortedItems;
    }

    public void setSortedItems(Comparable[] sortedItems){
        this.sortedItems = sortedItems;
    }

    public static boolean less(Comparable v, Comparable w) {
        //compareTo returns -1 for less, 0 for equal, and 1 for greater
        return v.compareTo(w) < 0;
    }

    public static void swap(Comparable[] set, int i, int j){
        Comparable temp = set[i];
        set[i] = set[j];
        set[j] = temp;
    }

    public static void show(Comparable[] items) {
        for (Comparable item: items) {
            System.out.println(item + " ");
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++){
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }

    //algorithm implementation
    abstract Comparable[] sort();

}
