package com.thellaidev.mockito.mockito.demo.business;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl( DataService dataService ) {
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData(){
        int data[] = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;

        for( int val : data ){
            greatest = Math.max( val, greatest);
        }
        return  greatest;
    }
}

interface DataService{
    int[] retrieveAllData();
}
