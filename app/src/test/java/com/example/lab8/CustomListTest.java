package com.example.lab8;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {



    public CustomList MockCityList() {
        CustomList list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        CustomList list = MockCityList();
        int expectedCountBeforeAdd = 0;
        assertEquals(expectedCountBeforeAdd, list.getCount(),"Count shows incorrect number");
        City cityToAdd = new City("Nanton", "AB");
        list.addCity(cityToAdd);

        int expectedCountAfterAdd = 1;
        assertEquals(expectedCountAfterAdd, list.getCount(),"The city was not added to the list");
    }

    @Test
    public void hasCityTest() {
        CustomList list = MockCityList();
        City cityToAdd = new City("Regina", "SK");
        list.addCity(cityToAdd);
        assertTrue(list.hasCity(cityToAdd));

    }


    @Test
    void deleteCityTest() {
        CustomList cityList = MockCityList();

        City city = new City("Edmonton", "Alberta");
        cityList.addCity(city);
        cityList.delete(city);


        assertEquals(0, cityList.countCities());
    }
    @Test
    void countCities(){
        CustomList cityList = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);
        cityList.countCities();
        assertEquals(1, cityList.countCities());
    }






}
