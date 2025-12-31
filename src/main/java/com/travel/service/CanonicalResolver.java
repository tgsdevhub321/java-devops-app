package com.travel.service;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class CanonicalResolver {

    public String getCanonicalUrl(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String query = request.getQueryString();

        if (query != null) {
            url += "?" + query;
        }

        return url.toLowerCase();
    }
}
