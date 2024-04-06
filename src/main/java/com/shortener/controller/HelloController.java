package com.shortener.controller;

import com.shortener.model.UrlModel;
import com.shortener.service.UrlShortenerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {

    private final UrlShortenerService urlShortenerService;

    public HelloController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("urlModel", new UrlModel());
        return "index";
    }

    @PostMapping("/")
    public String shortenUrl(@ModelAttribute UrlModel urlModel,
                             Model model) {
        urlShortenerService.shortenUrl(urlModel);
        return "index";
    }

}
