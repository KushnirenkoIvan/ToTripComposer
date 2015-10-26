package ua.kushnirenko.ivan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kushnirenko.ivan.dao.CityDao;
import ua.kushnirenko.ivan.dao.CountryDao;
import ua.kushnirenko.ivan.domain.City;
import ua.kushnirenko.ivan.domain.Country;
import ua.kushnirenko.ivan.domain.Response;
import ua.kushnirenko.ivan.util.HTTPConnector;

import java.util.List;

/**
 * This is a main class of the application.
 * Method <b>saveInfoToDBfromServer()</b> - is an 'entry point' of this application.
 * This method gets
 * @see Response from
 * @see HTTPConnector
 * and parses Responce using
 * @see ua.kushnirenko.ivan.util.JSONConverter
 * The result of this operations is an array of entities. Type of each entity is:
 * @see Country
 * After that the array of countries is stored in the database using DAO classes:
 * @see ua.kushnirenko.ivan.dao
 * Connection to database is set up with Spring framework - file 'spring-config.xml' in folder 'resources'.
 * IoC is realized by using annotations for my classes
 * and bean definitions(for 'org.hibernate.SessionFactory' and 'com.google.gson.Gson').
*/
@Service
public class Main {

    @Autowired
    private HTTPConnector httpConnector;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CountryDao countryDao;

    @Transactional
    public void saveInfoToDBfromServer() {
        Response response = httpConnector.makeHTTPPOSTRequest();
        Country[] countries = response.getCountries();
        for (Country country : countries) {
            List<City> cities = country.getCities();
            for (City city : cities) {
                if (!cityDao.contains(city)) {
                    cityDao.create(city);
                }
            }
            if (!countryDao.contains(country)) {
                countryDao.create(country);
            }
        }
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");
        Main main = (Main) ac.getBean("main");
        main.saveInfoToDBfromServer();
        System.out.println("Server response has been successfully added to DB.");
    }

}
