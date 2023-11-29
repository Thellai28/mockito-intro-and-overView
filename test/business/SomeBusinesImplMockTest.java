package com.thellaidev.mockito.mockito.demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplMockTest {



    @Test
    void  findTheGreatestFromAllData_BasicScenario(){
        DataService dataServiceMock = mock(DataService.class);
        when( dataServiceMock.retrieveAllData()).thenReturn( new int[]{ 25, 15, 55, 96 } );

        SomeBusinessImpl businessImpl = new SomeBusinessImpl( dataServiceMock);
        int ans = businessImpl.findTheGreatestFromAllData();

        assertEquals( 96, ans );
    }

    @Test
    void  findTheGreatestFromAllData_WithSingleValue(){
        DataService dataServiceMock = mock(DataService.class);
        when( dataServiceMock.retrieveAllData() ).thenReturn( new int[]{  55 } );

        SomeBusinessImpl businessImpl = new SomeBusinessImpl( dataServiceMock);
        int ans = businessImpl.findTheGreatestFromAllData();

        assertEquals( 55, ans );
    }

    /*
        Using mocks, we can dynamically assign the change the values which should be returned. we don't need to worry
        about creating new clas for new scenario. Even when new methods are created in the interface, we don't have to
        worry about that, mockito will take care of that. In Case of stubs, we need to implement that newly added
        methods in all the implemented classes, regardless of whether we'll use them or not.
    */

}
