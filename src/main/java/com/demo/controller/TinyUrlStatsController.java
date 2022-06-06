package com.demo.controller;

import com.demo.model.TinyUrlStats;
import com.demo.repo.TinyUrlStatsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("v1/tinyurl")
public class TinyUrlStatsController {

    private static final Logger LOG = LoggerFactory.getLogger(TinyUrlStatsController.class);

    @Autowired
    TinyUrlStatsRepository tinyUrlStatsRepository= new TinyUrlStatsRepository();

    @RequestMapping(method = RequestMethod.GET, value = "/{shortcode}/stats")
    @ResponseBody
    public ResponseEntity<TinyUrlStats> getStats(@PathVariable String shortcode) {
        TinyUrlStats response = tinyUrlStatsRepository.getStats(shortcode);
        LOG.info("Response is :"+response);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}




