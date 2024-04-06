package com.shortener.service;

import com.shortener.model.UrlModel;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

    public void shortenUrl(UrlModel request) {
        request.setUrlShort(request.getUrlLong());
    }
}
