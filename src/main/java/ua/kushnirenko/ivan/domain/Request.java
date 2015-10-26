package ua.kushnirenko.ivan.domain;

import org.springframework.stereotype.Component;

/**
 * This class represents request to server. Used in:
 *
 * @see ua.kushnirenko.ivan.util.HTTPConnector
 */

@Component
public class Request {

    private static String url = "http://tripcomposer.net/rest/test/countries/get";

    private String key = "$1$12309856$euBrWcjT767K2sP9MHcVS/";

    private String echo = "test1234";

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Request.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public Request() {

    }

    public Request(String key, String echo) {
        this.key = key;
        this.echo = echo;
    }

    @Override
    public String toString() {
        return "Request{" +
                "key='" + key + '\'' +
                ", echo='" + echo + '\'' +
                '}';
    }

}
