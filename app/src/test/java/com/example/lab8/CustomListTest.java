package com.example.lab8;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList mockCityList() {
        CustomList cityList = new CustomList(null, new ArrayList<City>());
        cityList.addCity(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    private CustomList list;

    @Test
    public void addCityTest(){
        list = new CustomList(null, new ArrayList<City>());
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);

    }

    @Test
    void testHasCities() {
        CustomList cityList = mockCityList();
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDeleteCities() {
        CustomList cityList = mockCityList();
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        cityList.delete(city);
        assertEquals(1,cityList.getCities().size());
    }

    @Test
    void testDeleteCitiesThrows() {
        CustomList cityList = mockCityList();
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        cityList.delete(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city); }
        );
    }

    @Test
    void testCountCities() {
        CustomList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(2, cityList.countCities());
    }


}
