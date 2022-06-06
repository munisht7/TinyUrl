package com.demo;


import com.demo.Utils.ErrorCodes;
import com.demo.controller.TinyUrlController;
import com.demo.model.TinyUrl;
import com.demo.repo.TinyUrlRepository;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Objects;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@SpringBootTest
public class TinyUrlProcessingTests {

    private static final Logger LOG = LoggerFactory.getLogger(TinyUrlProcessingTests.class);

    TinyUrlController tinyUrlController= new TinyUrlController();
    TinyUrl tinyUrlRequest= new TinyUrl();

    @Test
    public void testShortenurlForCreatedResponse() {
        tinyUrlRequest.setUrl("https://www.energyworx.com/");
        tinyUrlRequest.setShortcode("eww123");
        ResponseEntity<String> responseEntity = tinyUrlController
                .createShortUrl(tinyUrlRequest);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }

    @Test
    public void testShortenUrlStatusCodeWithUnderScoreInShortCode(){
        tinyUrlRequest.setUrl("https://www.energyworx.com/");
        tinyUrlRequest.setShortcode("aas_12");
        ResponseEntity<String> responseEntity = tinyUrlController
                .createShortUrl(tinyUrlRequest);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
    }

    @Test
    public void testShortenUrlResponseSameAsPresentInRequest() {
        tinyUrlRequest.setUrl("https://www.energyworx.com/");
        tinyUrlRequest.setShortcode("aa1234");
        ResponseEntity<String> responseEntity = tinyUrlController
                .createShortUrl(tinyUrlRequest);
        LOG.info(tinyUrlRequest.getShortcode());
        Assert.assertTrue(Objects.requireNonNull(responseEntity.getBody()).contains(tinyUrlRequest.getShortcode()));
    }

    @Test
    public void testForRandomCreationOfShortUrlWhenShortCodeIsNotPresentInRequest(){
        tinyUrlRequest.setUrl("https://www.energyworx.com/");
        ResponseEntity<String> responseEntity = tinyUrlController
                .createShortUrl(tinyUrlRequest);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.CREATED));
        LOG.info(responseEntity.getBody());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void testShortenUrlStatusCodeForInavlidLengthOfShortCodeGreaterThan6(){
        tinyUrlRequest.setUrl("https://www.energyworx.com/");
        tinyUrlRequest.setShortcode("asdasdadas");
        ResponseEntity<String> responseEntity = tinyUrlController
                .createShortUrl(tinyUrlRequest);
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.PRECONDITION_FAILED));
    }

    @Test
    public void testShortenUrlWithInvalidShortCode() {
        tinyUrlRequest.setUrl("https://www.energyworx.com/");
        tinyUrlRequest.setShortcode("aa134");
        ResponseEntity<String> responseEntity = tinyUrlController
                .createShortUrl(tinyUrlRequest);
        assertThat(responseEntity.getStatusCode(),is(HttpStatus.PRECONDITION_FAILED));
    }

    @Test
    public void testShortenUrlWithShortCodeAsNull() {
        tinyUrlRequest.setUrl("https://www.energyworx.com/");
        tinyUrlRequest.setShortcode(null);
        ResponseEntity<String> responseEntity = tinyUrlController
                .createShortUrl(tinyUrlRequest);
        LOG.info(responseEntity.getBody());
        assertThat(responseEntity.getStatusCode(),is(HttpStatus.CREATED));
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void testShortenUrlGetStatus() {

        tinyUrlRequest.setShortcode("ewx123");
        ResponseEntity<String> responseEntity = tinyUrlController
                .getShortCodeUrl(tinyUrlRequest.getShortcode());
        LOG.info(responseEntity.getBody());
        assertThat(responseEntity.getStatusCode(),is(HttpStatus.FOUND));
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void testShortenUrlGetStatusWithStatusNotFound() {
        tinyUrlRequest.setShortcode("ewx");
        ResponseEntity<String> responseEntity = tinyUrlController
                .getShortCodeUrl(tinyUrlRequest.getShortcode());
        LOG.info(responseEntity.getBody());
        assertThat(responseEntity.getStatusCode(),is(HttpStatus.NOT_FOUND));
    }

    @Test
    public void testShortenUrlGetStatusResponseForNotFound() {
        tinyUrlRequest.setShortcode("ewx");
        ResponseEntity<String> responseEntity = tinyUrlController
                .getShortCodeUrl(tinyUrlRequest.getShortcode());
        LOG.info(responseEntity.getBody());
        Assert.assertEquals(responseEntity.getBody(), ErrorCodes.ERR_404);
    }

}
