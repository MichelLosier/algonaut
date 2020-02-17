package com.michellosier.algonaut.sort;

//Find smallest smallest item in array and exchange with first entry, then next
//O(n^2) compares and N exchanges
//Doesn't take advantage of initial order. Set could already be in order and still you have to iterate through each item
//Swaping is minimal linear to array size
public class SelectionSort extends Sort {
    SelectionSort(Comparable[] items){
        super(items);
    }

    public Comparable[] sort(){
        Comparable[] items = this.getItems();
        int n = items.length;
        for (int i = 0; i < n; i++){ //iterate through each item
            int min = i; //set index of current smallest value
            for (int j = i+1; j < n; j++){ //compare all array items against current minimal value
                if(less(items[j], items[min])){ //if item is less than current minimum
                    min = j; //set as minimum
                }
            }
            swap(items, i, min); //swap minimal value to current index
        }
        this.setSortedItems(items);
        return items;
    }
}
