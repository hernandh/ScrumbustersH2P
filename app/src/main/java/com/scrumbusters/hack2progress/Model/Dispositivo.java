package com.scrumbusters.hack2progress.Model;

public abstract class Dispositivo extends ElementoConfigurable{
    public Dispositivo(String nombre, String icono, String descripcion, Grupo grupoPadre,
                       boolean heredaConfiguracion, Configuracion config) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);

        isGroup = false;
    }
}
