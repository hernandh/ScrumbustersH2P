package com.scrumbusters.hack2progress.Model;

public class Bombilla extends Dispositivo {
    public Bombilla(String nombre, String icono, String descripcion, Grupo grupoPadre,
                    boolean heredaConfiguracion, Configuracion config) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);
    }
}
