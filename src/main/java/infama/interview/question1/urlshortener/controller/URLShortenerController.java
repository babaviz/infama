package infama.interview.question1.urlshortener.controller;

import infama.interview.question1.urlshortener.models.MyRequest;
import infama.interview.question1.urlshortener.utility.ValidateUrls;
import infama.interview.question1.urlshortener.service.URLConverterService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;


@RestController
public class URLShortenerController {
    private final URLConverterService urlConverterService;

    public URLShortenerController(URLConverterService urlConverterService) {
        this.urlConverterService = urlConverterService;
    }

    @RequestMapping(value = "/shorten", method=RequestMethod.POST, consumes = {"application/json"})
    public String shortenUrl(@RequestBody final MyRequest myRequest, HttpServletRequest request) throws Exception {

        String longUrl = myRequest.getUrl();
        if (ValidateUrls.instance.validateURL(longUrl)) {
            String localURL = request.getRequestURL().toString();
            return urlConverterService.shortenURL(localURL, myRequest.getUrl());
        }
        throw new Exception("Invalid url");
    }

    @GetMapping("/{id}")
    public RedirectView redirectUrl(@PathVariable String id){
        String redirectUrlString = urlConverterService.getLongURLFromID(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrlString);
        return redirectView;
    }
}


