package com.proxy.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
@RequestMapping("/api/proxy")
@RequiredArgsConstructor
public class UserControllerProxy {

    @Value("${service1.url}")
    private  String service1Url;

    @Value("${service2.url}")
    private String  service2Url;

    private final RestTemplate restTemplate;


    @GetMapping("/user/**")
    public ResponseEntity<String> forwardToService1() {
        String url = service1Url + getRequestPath("/user");
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/user/v2/**")
    public ResponseEntity<String> forwardToService2() {
        String url = service2Url + getRequestPath("/user");
        return restTemplate.getForEntity(url, String.class);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login() {
        String url = service1Url + getRequestPath("/user");
        return restTemplate.getForEntity(url, String.class);
    }


    private String getRequestPath(String prefix) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();

        String pathAfterPrefix = requestURI.substring(requestURI.indexOf(prefix) + prefix.length());

        return pathAfterPrefix;
    }
}
