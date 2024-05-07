package com.shortener.service;

import com.shortener.model.UrlModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlShortenerService {

    private static final int SHORT_URL_LENGTH = 7;

    private final Map<String, String> urlCache = new HashMap<>();

    public String shortenUrl(UrlModel urlModel) {
        String generatedShortPart = RandomStringUtils.randomAlphanumeric(SHORT_URL_LENGTH);
        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().build();

        String shortUrl = UriComponentsBuilder
                .fromHttpUrl(uriComponents.getScheme() + "://" + uriComponents.getHost() + ":" +
                        uriComponents.getPort())
                .pathSegment(generatedShortPart)
                .build()
                .toString();

        urlCache.put(shortUrl, urlModel.getUrlLong());

        return shortUrl;
    }
}
