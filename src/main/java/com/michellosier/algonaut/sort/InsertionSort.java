package com.michellosier.algonaut.sort;

//iterate through each item and put among those already considered - persist sort
//like sorting a hand of cards
//movement to the right, left of index is sorted
//O(n^2 / 2)
//Good for sets that may already be partially sorted already
//Good for sorting streamed values
public class InsertionSort extends Sort {
    InsertionSort(Comparable[] items){
        super(items);
    }

    public Comparable[] sort() {
        Comparable[] items = this.getItems();
        int n = items.length;
        for (int i = 1; i < n; i++) { //for each item
            //swap to each item to the left if current value is less than its left
            //stop iteration if current value is greater than left, or we reach left limit
            for (int j = i; j > 0 && less(items[j], items[j - 1]); j--) {
                swap(items, j, j - 1);
            }
        }
        this.setSortedItems(items);
        return items;
    }
}
