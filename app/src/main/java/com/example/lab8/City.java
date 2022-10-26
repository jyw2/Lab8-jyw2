package com.example.lab8;

public class City implements Comparable {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares two cities
     * @param o city to compare to.
     * @return 0 if the two are equal,&lt; 0 if this city's name is lexicographically less and &gt; 0 if this city's name is lexicographically more.
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Compares two cities for equality
     * @param cityObj city to compare to.
     * @return true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object cityObj){
        City city = (City)cityObj;
        if (this.getCityName() == city.getCityName() &&
                this.getProvinceName() == city.getProvinceName()){
            return true;
        }
        return false;
    }
}
