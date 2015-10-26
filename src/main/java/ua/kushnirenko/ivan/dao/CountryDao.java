package ua.kushnirenko.ivan.dao;

import ua.kushnirenko.ivan.domain.Country;

import java.util.List;


public interface CountryDao {

    String create(Country country);

    Country read(String id);

    boolean update(Country country);

    boolean delete(Country country);

    List<Country> getCountriesPorced(int start, int size);

    boolean contains(Country country);

    List<Country> showAll();

}
