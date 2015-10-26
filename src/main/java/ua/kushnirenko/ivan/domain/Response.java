package ua.kushnirenko.ivan.domain;

import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * This class represents response from server. Used in:
 *
 * @see ua.kushnirenko.ivan.util.HTTPConnector
 */

@Component
public class Response {

    private String type;
    private Long time;
    private Country[] countries;
    private String echo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public Response() {
    }

    public Response(Long time, Country[] countries, String echo) {
        this.time = time;
        this.countries = countries;
        this.echo = echo;
    }

    @Override
    public String toString() {
        return "Response{" +
                "type=" + type +
                "time=" + time +
                ", countries=" + Arrays.toString(countries) +
                ", echo='" + echo + '\'' +
                '}';
    }

}
