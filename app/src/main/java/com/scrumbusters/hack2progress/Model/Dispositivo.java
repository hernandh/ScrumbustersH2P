package com.scrumbusters.hack2progress.Model;

import java.util.Random;

public abstract class Dispositivo extends ElementoConfigurable{
    boolean encendido;
    public Dispositivo(String nombre, String icono, String descripcion, Grupo grupoPadre,
                       boolean heredaConfiguracion, Configuracion config) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);

        isGroup = false;
    }

    public abstract int readIntensity();

    public boolean isEncendido(){
        return encendido;
    }

    public void turnEncendido(){
        encendido = !encendido;
    }
}
