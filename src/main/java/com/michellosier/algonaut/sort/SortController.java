package com.michellosier.algonaut.sort;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sort")
public class SortController {

    @PostMapping(value = "/selection", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> selectionSort(@RequestBody String[] items ){
       Comparable[] sortedItems =  new SelectionSort(items).sort();
       if (Sort.isSorted(sortedItems)) {
           return new ResponseEntity<String[]>((String[])sortedItems, HttpStatus.OK);
       } else {
           return new ResponseEntity<String[]>((String[])sortedItems, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PostMapping(value = "/insertion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> insertionSort(@RequestBody String[] items ){
        Comparable[] sortedItems =  new InsertionSort(items).sort();
        if (Sort.isSorted(sortedItems)) {
            return new ResponseEntity<String[]>((String[])sortedItems, HttpStatus.OK);
        } else {
            return new ResponseEntity<String[]>((String[])sortedItems, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
