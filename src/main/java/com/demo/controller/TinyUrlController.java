package com.demo.controller;

import com.demo.Utils.ErrorCodes;
import com.demo.model.TinyUrl;
import com.demo.repo.TinyUrlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("v1/tinyurl")
public class TinyUrlController {

    private static final Logger LOG = LoggerFactory.getLogger(TinyUrlController.class);

    TinyUrlRepository tinyUrlRepository = new TinyUrlRepository() ;

    @RequestMapping(method = RequestMethod.POST, value = "/shorten", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> createShortUrl(@Valid @RequestBody TinyUrl tinyUrlRequest) {
        LOG.info("Request is :"+tinyUrlRequest);
        String shortcode = tinyUrlRepository.create(tinyUrlRequest);
        if (tinyUrlRequest != null) {
            if (tinyUrlRequest.getShortcode() == null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(shortcode);
            } else {
                if (tinyUrlRequest.getShortcode().length() != 6) {
                    return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(ErrorCodes.ERR_412);
                } else {
                    return ResponseEntity.status(HttpStatus.CREATED).body(tinyUrlRequest.getShortcode());

                }
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorCodes.ERR_400);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{shortcode}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> getShortCodeUrl(@PathVariable String shortcode) {
        String response = tinyUrlRepository.get(shortcode);
        LOG.info("response is:"+response);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorCodes.ERR_404);
        }
    }

}




