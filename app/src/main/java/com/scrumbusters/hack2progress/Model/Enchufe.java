package com.scrumbusters.hack2progress.Model;

public class Enchufe extends Dispositivo{
    public Enchufe(String nombre, String icono, String descripcion, Grupo grupoPadre,
                   boolean heredaConfiguracion, Configuracion config) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);
    }
}
