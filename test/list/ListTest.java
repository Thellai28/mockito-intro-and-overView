package com.thellaidev.mockito.mockito.demo.list;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {
    @Test
    void simpleTest(){
        List listMock = mock(List.class);
        when( listMock.size() ).thenReturn(3 );
        assertEquals( 3, listMock.size() );
    }

    @Test
    void multipleReturns(){
        List listMock = mock(List.class);
        when( listMock.size() ).thenReturn(3 ). thenReturn(4);
        assertEquals( 3, listMock.size() );
        assertEquals(4, listMock.size() );
        assertEquals(4, listMock.size() );
        assertEquals(4, listMock.size() );
    }

    @Test
    void SpecificParameters(){
        List listMock = mock(List.class);
        when( listMock.get(3) ).thenReturn("SomeStringBuh" );
        assertEquals( "SomeStringBuh", listMock.get(3) );
        assertEquals( null, listMock.get(1) );
    }

    @Test
    void genericParameters(){
        List listMock = mock(List.class);
        when( listMock.get( Mockito.anyInt() ) ).thenReturn("BruhBruhBruh" );
        assertEquals( "BruhBruhBruh", listMock.get(-1) );
        assertEquals( "BruhBruhBruh", listMock.get(100) );
        assertEquals( "BruhBruhBruh", listMock.get(-8900) );
        assertEquals( "BruhBruhBruh", listMock.get(51001) );
    }
}
