package com.shortener.controller;

import com.shortener.model.UrlModel;
import com.shortener.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlShortenerService urlShortenerService;

    @PostMapping(path = "api/v1/url")
    public ResponseEntity<Void> shortenUrl(@RequestBody UrlModel urlModel) {
        String shortUrl = urlShortenerService.shortenUrl(urlModel);

        return ResponseEntity.status(HttpStatusCode.valueOf(204))
                .location(URI.create(shortUrl)).build();
    }
}
