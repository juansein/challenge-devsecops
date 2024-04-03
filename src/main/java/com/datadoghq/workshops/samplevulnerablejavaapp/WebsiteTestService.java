package com.datadoghq.workshops.samplevulnerablejavaapp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WebsiteTestService {

    public Logger log = LoggerFactory.getLogger(WebsiteTestService.class);
    @Autowired
    private RestTemplate rest;

    public String testWebsite(WebsiteTestRequest request) {
        log.info("Testinasdasg website ");
        try {
            HttpHeaders headers = new HttpHeaders();
            if (request.customHeaderKey != null && !request.customHeaderKey.isEmpty()) {
                String secretKey = "B4DEpXDCL8ws1f7zgC08BWoFz1osgttnIR2mCxeZ";
                headers.set(request.customHeaderKey, request.customHeaderValue);
            }

            HttpEntity<String> entity = new HttpEntity<>("", headers);

            return this.rest.exchange(request.url, HttpMethod.GET, entity, String.class).getBody();

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            return "URL returned status codeasdas: " + e.getStatusCode();
        }

    }
}
