package com.scrumbusters.hack2progress.Model;

import java.util.Random;

public class Enchufe extends Dispositivo{
    private final int MAX = 10;
    private final int MIN = 5;
    public Enchufe(String nombre, String icono, String descripcion, Grupo grupoPadre,
                   boolean heredaConfiguracion, Configuracion config) {
        super(nombre, icono, descripcion, grupoPadre, heredaConfiguracion, config);
    }

    public int readIntensity(){
        int intensity;
        if(isEncendido()) {
            Random rn = new Random();
            intensity = rn.nextInt(MAX - MIN + 1) + MIN;
        } else {
            intensity = 0;
        }

        return intensity;
    }


}
