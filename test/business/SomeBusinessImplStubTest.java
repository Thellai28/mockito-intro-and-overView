package com.thellaidev.mockito.mockito.demo.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplStubTest {

    @Test
    void  findTheGreatestFromAllData_BasicScenario(){
        SomeBusinessImpl businessImpl = new SomeBusinessImpl( new DataServiceStub() );
        /*
            Insted of suing the real database, we are using stubs as the substitute for the actual data base.
         */

        int ans = businessImpl.findTheGreatestFromAllData();
        assertEquals( 96, ans );

    }

    @Test
    void  findTheGreatestFromAllData_WithOneValue(){
        SomeBusinessImpl businessImpl = new SomeBusinessImpl( new DataServiceStubWithOneValue() );

        int ans = businessImpl.findTheGreatestFromAllData();
        assertEquals( 15, ans );
    }

    /*
        To test two different scenario, we have created two different stubbs class, Just imaging, if you want to
        test more than 150 different scenario like this, you have to crate 150 different stubs to achieve that.
        Testing your code using stubs becomes very headache, if your app becomes very huge & maintaining stubs is
        not very easy. To avoid this we have mocks.

        When you add a new method int the interface, you should add the implementation for that methods in all the
        implemented stubs class, this could be very hectic to maintain in longer run and you interface has the nature
        of adding new methods very often.
    * */
}
class DataServiceStub implements DataService{ // Replacing a data service using stubb :
    @Override
    public int[] retrieveAllData() {
        return new int[]{ 25, 15, 55, 96 };
    }
}

class DataServiceStubWithOneValue implements DataService{ // TO test anothe different scenario, we are creating new stubs
    @Override
    public int[] retrieveAllData() {
        return new int[]{ 15 };
    }
}