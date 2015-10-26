package ua.kushnirenko.ivan.util;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Converts objects to JSON string format
 */

@Service
public class JSONConverter {

    @Autowired
    Gson gson;

    public String toJSON(Object obj) {
        String resultJson = gson.toJson(obj);
        return resultJson;
    }

    public Object toJavaObject(String json, Class cls) {
        Object obj = gson.fromJson(json, cls);
        return obj;
    }

}
