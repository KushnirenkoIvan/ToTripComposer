package ua.kushnirenko.ivan.domain;


import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Component
@Entity
@Table
public class Country {

    @Id
    @Column(name = "COUNTRY_ISO_CODE")
    private String countryISOCode;

    @Column
    private String countryName;

    @OneToMany
    private List<City> cities;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISOCode() {
        return countryISOCode;
    }

    public void setCountryISOCode(String countryISOCode) {
        this.countryISOCode = countryISOCode;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public Country(String countryName, String countryISOCode, ArrayList<City> cities) {
        this();
        this.countryName = countryName;
        this.countryISOCode = countryISOCode;
        this.cities = cities;
    }

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", countryISOCode='" + countryISOCode + '\'' +
                ", cities=" + cities +
                '}';
    }
}
