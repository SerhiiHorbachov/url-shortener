package com.shortener.service;

import com.shortener.UrlRepository;
import com.shortener.entity.UrlData;
import com.shortener.model.UrlModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class UrlShortenerService {

    private static final int SHORT_URL_LENGTH = 7;

    private final UrlRepository urlRepository;

    @Transactional
    public String shortenUrl(UrlModel urlModel) {
        String shortUrl = createShortUrl();

        UrlData urlData = UrlData.builder()
                .longUrl(urlModel.getUrlLong())
                .shortUrl(shortUrl)
                .build();
        urlRepository.save(urlData);

        return shortUrl;
    }

    private String createShortUrl() {
        String generatedShortPart = RandomStringUtils.randomAlphanumeric(SHORT_URL_LENGTH);
        UriComponents uriComponents = ServletUriComponentsBuilder.fromCurrentRequest().build();

        return UriComponentsBuilder
                .fromHttpUrl(uriComponents.getScheme() + "://" + uriComponents.getHost() + ":" +
                        uriComponents.getPort())
                .pathSegment(generatedShortPart)
                .build()
                .toString();
    }
}
