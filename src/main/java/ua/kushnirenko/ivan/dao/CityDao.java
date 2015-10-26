package ua.kushnirenko.ivan.dao;

import ua.kushnirenko.ivan.domain.City;

import java.util.List;


public interface CityDao {

    String create(City city);

    City read(String id);

    boolean update(City city);

    boolean delete(City city);

    List<City> getCitiesPorced(int start, int size);

    boolean contains(City city);

    List<City> showAll();

}
