package com.testbackend.uol.enums;

import lombok.Getter;

@Getter
public enum HeroGrupo {

    VINGADORES("Vingadores"),
    LIGADAJUSTICA("liga Da Justiça");

    private final String value;

    HeroGrupo(String value){
        this.value = value;
    }

}
