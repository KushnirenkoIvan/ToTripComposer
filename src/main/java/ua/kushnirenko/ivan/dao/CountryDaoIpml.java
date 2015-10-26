package ua.kushnirenko.ivan.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.kushnirenko.ivan.domain.Country;

import java.util.ArrayList;
import java.util.List;


@Repository
public class CountryDaoIpml implements CountryDao {

    final int STEP_PORCED = 5;
    private static Logger log = Logger.getLogger(Country.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public String create(Country country) {
        return (String) sessionFactory.getCurrentSession().save(country);
    }

    @Override
    public Country read(String id) {
        return (Country) sessionFactory.getCurrentSession().get(Country.class, id);
    }

    @Override
    public boolean update(Country country) {
        sessionFactory.getCurrentSession().update(country);
        return true;
    }

    @Override
    public boolean delete(Country country) {
        sessionFactory.getCurrentSession().delete(country);
        return true;
    }

    @Override
    public List<Country> getCountriesPorced(int start, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Country");
        query.setFirstResult(start);
        query.setMaxResults(size);
        return query.list();
    }

    @Override
    public boolean contains(Country country) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Country c WHERE c.countryISOCode='" + country.getCountryISOCode() + "'");
        List<Country> cityList = query.list();
        return cityList.size() > 0;
    }

    public Long getCount() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select COUNT(c.countryName) from Country c").uniqueResult();
    }

    @Override
    public List<Country> showAll() {
        List<Country> cities = new ArrayList<>();
        Long count = getCount();
        for (int i = 0; i < count; i += STEP_PORCED) {
            cities.addAll(getCountriesPorced(i, STEP_PORCED));
        }
        return cities;
    }
}
