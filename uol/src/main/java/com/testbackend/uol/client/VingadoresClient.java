package com.testbackend.uol.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "VingadoresClient",
             url = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json")
public interface VingadoresClient {


    @GetMapping
    String getHeroesVingadores();
}
