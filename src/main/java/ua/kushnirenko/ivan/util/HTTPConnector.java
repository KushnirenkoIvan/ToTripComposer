package ua.kushnirenko.ivan.util;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kushnirenko.ivan.domain.Request;
import ua.kushnirenko.ivan.domain.Response;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Do request to server using
 *
 * @see Request
 * <p>
 * and returns response:
 * @see Response
 */

@Service
public class HTTPConnector {

    @Autowired
    private Request request;

    @Autowired
    private JSONConverter jsonConverter;

    public Response makeHTTPPOSTRequest() {
        Response response = null;
        try {
            HttpClient c = new DefaultHttpClient();
            HttpPost p = new HttpPost(Request.getUrl());

            p.setEntity(new StringEntity(jsonConverter.toJSON(request),
                    ContentType.create("application/json")));

            HttpResponse r = c.execute(p);

            BufferedReader rd = new BufferedReader(new InputStreamReader(r.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                response = (Response) jsonConverter.toJavaObject(line, Response.class);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return response;
    }

}
