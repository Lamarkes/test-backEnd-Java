package com.testbackend.uol.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "LigaDaJusticaClient",
        url = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml")
public interface LigaDaJusticaClient {


    @GetMapping
    String getHeroesLigaDaJustica();
}
