package org.example;


public class HttpStatusChecker {
    public static final String URL = "https://http.cat/";

    public String getStatusImage(int code){
        if (HttpStatusCode.isValidStatusCde(code)){
            return URL + code + ".jpg";
        }
        throw new IllegalArgumentException("Invalid code " + code);
    }
}
