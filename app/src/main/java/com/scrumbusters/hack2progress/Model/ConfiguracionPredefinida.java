package com.scrumbusters.hack2progress.Model;

import java.util.List;

public class ConfiguracionPredefinida extends Configuracion {

    private String name;

    public ConfiguracionPredefinida(List<Planning> plannigs,String name) {
        super(plannigs);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
