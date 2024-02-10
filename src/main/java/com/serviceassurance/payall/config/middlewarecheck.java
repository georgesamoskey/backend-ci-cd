package com.serviceassurance.payall.config;

import java.io.IOException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class middlewarecheck extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

         HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String requestApiKey = request.getHeader("X-API-KEY");
        // headers.set("X-API-KEY", requestApiKey);
         HttpEntity<String> entity = new HttpEntity<String>(headers);

        // String responseEntity = restTemplate.getForObject(
        //         "http://192.168.20.17:8080/realms/example/check?apiKey=" + requestApiKey,
        //         String.class);
        // logger.info("ieeieieiei" + responseEntity);
        // return;

        // Validate the key and secret
        // if (apiKey.equals(requestApiKey) && apiSecret.equals(requestApiSecret)) {
        if (requestApiKey.equals(null)) {

            //Continue processing the request
             filterChain.doFilter(request, response);
        } else {
            // Reject the request and send an unauthorized error
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Unauthorized");
            return;
        }
    }

}
