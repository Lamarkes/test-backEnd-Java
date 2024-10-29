package com.testbackend.uol.util;

import com.testbackend.uol.exception.GrupoIndisponivelException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LigaChoice implements HeroChoice {

    private final HeroClassConfiguration configuration;

    @Override
    public String choiceHeroClass(List<String> list) {
        String codinome;
        if (list.size() == 6)
            throw new GrupoIndisponivelException("Nao ha mais herois disponiveis para esse grupo");

        do {
            codinome = configuration.getLigaDaJustica();
        } while (list.contains(codinome));
        return codinome;
    }
}
