package com.demo;

import com.demo.controller.TinyUrlController;
import com.demo.controller.TinyUrlStatsController;
import com.demo.model.TinyUrl;
import com.demo.model.TinyUrlStats;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TinyUrlStatsProcessingTests {

    private static final Logger LOG = LoggerFactory.getLogger(TinyUrlStatsProcessingTests.class);

    TinyUrlStatsController tinyUrlStatsController= new TinyUrlStatsController();

    TinyUrlStats tinyUrlStats= new TinyUrlStats();

    @Test
    public void testShortenUrlGetStatusWithOKStatusCode() {
        tinyUrlStats.setShortcode("ewx123");
        ResponseEntity<TinyUrlStats> responseEntity = tinyUrlStatsController
                .getStats(tinyUrlStats.getShortcode());
        LOG.info(String.valueOf(responseEntity.getBody()));
        assertThat(responseEntity.getStatusCode(),is(HttpStatus.OK));

    }
    @Test
    public void testShortenUrlGetStatusWithResponseForOkStatus() {
        tinyUrlStats.setShortcode("ewx123");
        ResponseEntity<TinyUrlStats> responseEntity = tinyUrlStatsController
                .getStats(tinyUrlStats.getShortcode());
        LOG.info(String.valueOf(responseEntity.getBody()));
        Assert.assertNotNull(responseEntity.getBody().getRedirectCount());
        Assert.assertNotNull(responseEntity.getBody().getCreated());
        Assert.assertNotNull(responseEntity.getBody().getLastRedirect());
    }

    @Test
    public void testShortenUrlGetStatusWithStatusNotFound() {
        tinyUrlStats.setShortcode("ewx");
        ResponseEntity<TinyUrlStats> responseEntity = tinyUrlStatsController
                .getStats(tinyUrlStats.getShortcode());
        LOG.info(String.valueOf(responseEntity.getBody()));
        assertThat(responseEntity.getStatusCode(),is(HttpStatus.NOT_FOUND));
    }

}
