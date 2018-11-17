package com.scrumbusters.hack2progress.Model;

public abstract class Dispositivo extends ElementoConfigurable{
    public Dispositivo(String nombre, String icono, String descripcion, Grupo grupoPadre, boolean heredaConfiguracion) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion);

        isGroup = false;
    }
}
