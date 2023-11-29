package com.thellaidev.mockito.mockito.demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTestWithAnnotations {
    @Mock // Creates the mock for this DataServices
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;
    /*
        InjectsMocks the mock(s) into the constructor of this class, if the constructor needs more than one mock
        & if the mock object is present in this class, this annotation will automatically send that mock object into this
        the someBusinessImpl class constructor :
    */


    @Test
    void  findTheGreatestFromAllData_BasicScenario(){

        when( dataServiceMock.retrieveAllData()).thenReturn( new int[]{ 25, 15, 55, 96 } );
        int ans = businessImpl.findTheGreatestFromAllData();
        assertEquals( 96, ans );
    }

    @Test
    void  findTheGreatestFromAllData_WithSingleValue(){
        when( dataServiceMock.retrieveAllData() ).thenReturn( new int[]{  55 } );
        int ans = businessImpl.findTheGreatestFromAllData();
        assertEquals( 55, ans );
    }

    @Test
    void  findTheGreatestFromAllData_WithEmptyArray(){
        when( dataServiceMock.retrieveAllData() ).thenReturn( new int[0] );
        int ans = businessImpl.findTheGreatestFromAllData();
        assertEquals( Integer.MIN_VALUE, ans );
    }
}
