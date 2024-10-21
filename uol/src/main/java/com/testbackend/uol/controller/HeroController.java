package com.testbackend.uol.controller;

import com.testbackend.uol.client.LigaDaJusticaClient;
import com.testbackend.uol.client.VingadoresClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;


@RestController
@RequestMapping("/api/v1/hero")
public class HeroController {


    private final VingadoresClient heroClient;

    private final LigaDaJusticaClient ligaDaJusticaClient;

    public HeroController(VingadoresClient heroClient, LigaDaJusticaClient ligaDaJusticaClient) {
        this.heroClient = heroClient;
        this.ligaDaJusticaClient = ligaDaJusticaClient;
    }



    @GetMapping
    public ResponseEntity<List<String>> getHeroes() {

        String vingadores = heroClient.getHeroesVingadores().replaceAll("[:\\n\\t{}\\[\\]\"]", "").replaceAll("\\s+", " ").replace("codinome","").replace("vingadores","").trim();
        var list = List.of(vingadores.split(","));

        List<String> listVingadores = new ArrayList<>(list);
        int index = RandomGenerator.getDefault().nextInt(list.size());
        if (listVingadores.get(index) == null){
            System.out.println("este heroi ja foi");
        }

        String hero = listVingadores.get(index);
        System.out.println(listVingadores);
        System.out.println(listVingadores.size());
        System.out.println(hero);

        listVingadores.remove(index);

        System.out.println(listVingadores);
        System.out.println(listVingadores.size());



        String justiceLeague = ligaDaJusticaClient.getHeroesLigaDaJustica();
        List<String> listJustice = Arrays.asList(justiceLeague.split(","));
        //System.out.println(listJustice);


        return ResponseEntity.ok(listJustice);

    }
}
