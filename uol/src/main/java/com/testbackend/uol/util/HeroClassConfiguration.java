package com.testbackend.uol.util;


import com.testbackend.uol.client.LigaDaJusticaClient;
import com.testbackend.uol.client.VingadoresClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;


@Component
public class HeroClassConfiguration {


    private final VingadoresClient vingadoresClient;

    private final LigaDaJusticaClient ligaDaJusticaClient;

    private final Random random = new Random();

    public HeroClassConfiguration(VingadoresClient vingadoresClient, LigaDaJusticaClient ligaDaJusticaClient) {
        this.vingadoresClient = vingadoresClient;
        this.ligaDaJusticaClient = ligaDaJusticaClient;
    }


    public String getVingador(){

        String vingadores = vingadoresClient.getHeroesVingadores()
                .replaceAll("[:\\n\\t{}\\[\\]\"]", "")
                .replaceAll("\\s+", " ")
                .replace("codinome","")
                .replace("vingadores","").trim();

        List<String> listVingadores = new ArrayList<>(List.of(vingadores.split(",")));

        int index = random.nextInt(listVingadores.size());

        return listVingadores.get(index);

    }


    public String getLigaDaJustica(){

        String justiceLeague = ligaDaJusticaClient.getHeroesLigaDaJustica()
                .replaceAll("\\s+", " ")
                .replaceAll("[<>/:\\n\\t{}\\[\\]\"]", "")
                .replace("codinomes", "").replace("codinome",",")
                .replace("liga_da_justica","").trim();

        var listJustice = List.of(justiceLeague.split(","));

        List<String> listJusticeFinal = new ArrayList<>(listJustice);
        listJusticeFinal.removeAll(Arrays.asList(""," ",null));

        int index = RandomGenerator.getDefault().nextInt(listJusticeFinal.size());

        return listJusticeFinal.get(index);

    }
}
