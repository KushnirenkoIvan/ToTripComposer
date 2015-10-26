package ua.kushnirenko.ivan.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.kushnirenko.ivan.domain.City;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CityDaoImpl implements CityDao {

    final int STEP_PORCED = 5;
    private static Logger log = Logger.getLogger(City.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String create(City city) {
        return (String) sessionFactory.getCurrentSession().save(city);
    }

    @Override
    public City read(String id) {
        return (City) sessionFactory.getCurrentSession().get(City.class, id);
    }

    @Override
    public boolean update(City city) {
        sessionFactory.getCurrentSession().update(city);
        return true;
    }

    @Override
    public boolean delete(City city) {
        sessionFactory.getCurrentSession().delete(city);
        return true;
    }

    public boolean contains(City city) {
        Query query = sessionFactory.getCurrentSession().createQuery("from City c WHERE c.cityName='" + city.getCityName() + "'");
        List<City> cityList = query.list();
        return cityList.size() > 0;
    }

    @Override
    public List<City> showAll() {
        List<City> cities = new ArrayList<>();
        Long count = getCount();
        for (int i = 0; i < count; i += STEP_PORCED) {
            cities.addAll(getCitiesPorced(i, STEP_PORCED));
        }
        return cities;
    }

    public Long getCount() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select COUNT(c.cityName) from City c").uniqueResult();
    }

    @Override
    public List<City> getCitiesPorced(int start, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from City");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

}
