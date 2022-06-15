package com.xinxisimple.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {

    @Value("${server.port}")
    private int port;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/index")
    public String index() {
        return "Hello Consul~" + port;
    }

    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getServices();
    }

    @RequestMapping("/instances/{service}")
    public Object instances(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consume")
    public String consume() {
        return restTemplate.getForObject("http://spring-cloud-consul/index", String.class);
    }

    @GetMapping("/load")
    public Object load() {
        return loadBalancerClient.choose("spring-cloud-consul");
    }
}
