package com.scrumbusters.hack2progress.Model;

import java.util.Random;

public class Bombilla extends Dispositivo {
    public Bombilla(String nombre, String icono, String descripcion, Grupo grupoPadre,
                    boolean heredaConfiguracion, Configuracion config) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);
    }

    public int readIntensity(){
        if(encendido){
            return 10;
        } else {
            return 0;
        }
    }
}
